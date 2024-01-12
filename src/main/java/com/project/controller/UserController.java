package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.user.model.UserVO;
import com.project.user.service.UserService;
import com.project.user.service.UserServiceImpl;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doaction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doaction(request, response);
	}

	protected void doaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//url주소를 분기(각 요청별로 코드를 만듦)

		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();
		String path = uri.substring(request.getContextPath().length());

		System.out.println(path);

		//서비스 영역 선언

		UserService service = new UserServiceImpl();

		if(path.equals("/user/join.user")) { //가입화면
			request.getRequestDispatcher("user_join.jsp").forward(request, response);

		}else if(path.equals("/user/login.user")) { //로그인 화면
			request.getRequestDispatcher("user_login.jsp").forward(request, response);

		}else if(path.equals("/user/joinForm.user")) {
			int result = service.join(request,response);
			if(result == 1) { //아이디 이미 존재
				response.setContentType("text/html; charSet = UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('중복된 아이디입니다')");
				out.println("location.href='join.user';");
				out.println("</script>");
				
//				request.setAttribute("msg", "아이디가 중복되었습니다");
//				request.getRequestDispatcher("user_join.jsp").forward(request, response);
			}else {
				
				response.setContentType("text/html; charSet = UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('회원가입이 완료되었습니다')");
				out.println("location.href='login.user';");
				out.println("</script>");
				
//				request.setAttribute("msg", "회원가입이 되었습니다");
//				response.sendRedirect("login.user");
			}
		}else if(path.equals("/user/loginForm.user")) {
			UserVO vo = service.login(request, response);

			if(vo !=null) { //로그인 성공
				//세션에 저장
				HttpSession session = request.getSession();
				session.setAttribute("user_id", vo.getUser_id());
				session.setAttribute("user_name", vo.getUser_name());

				response.sendRedirect(request.getContextPath()+"/home.jsp");// 홈 화면
			}else { //로그인 실패
				response.setContentType("text/html; charSet = UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('아이디 비밀번호를 확인하세요')");
				out.println("location.href='login.user';");
				out.println("</script>");
				
//				request.setAttribute("msg", "아이디 비밀번호를 확인하세요");
//				request.getRequestDispatcher("user_login.jsp").forward(request, response);
			}
		}else if(path.equals("/user/logout.user")) {//로그아웃
			HttpSession session = request.getSession();
			session.invalidate();

			response.sendRedirect(request.getContextPath()+"/home.jsp");//홈화면
		}else if(path.equals("/user/mypage.user")) {//마이페이지

			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);

		} else if(path.equals("/user/update.user")) {//정보수정
			//유저 정보 가져오기

			UserVO vo = service.getUserInfo(request, response);
			request.setAttribute("vo", vo);

			request.getRequestDispatcher("user_update.jsp").forward(request, response);

		}else if(path.equals("/user/updateForm.user")) {
			//0이면 실패 , 1이면 성공
			int result = service.update(request, response);

			if(result ==1 ) {
				response.setContentType("text/html; charset=UTF-8");

				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('정보수정 완료')");
				out.println("location.href='mypage.user';");
				out.println("</script>");
			}else {
				response.setContentType("text/html; charset=UTF-8");

				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('정보수정 실패')");
				out.println("location.href='mypage.user';");
				out.println("</script>");

			}
		}else if(path.equals("/user/delete.user")) {//탈퇴화면

			request.getRequestDispatcher("user_delete.jsp").forward(request, response);

		}else if(path.equals("/user/deleteForm.user")) { //회원탈퇴 요청
			
				service.delete(request, response);

				response.setContentType("text/html; charSet = UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<script>");
				out.println("alert('삭제가 완료되었습니다')");
				out.println("location.href='/ProjectBook/home.jsp';");
				out.println("</script>");
		
			
		}else if(path.equals("/user/deleteForm1.user")) {
			int result = 0;
			result = service.idcheck(request, response);
			System.out.println(result);
			if(result == 1) {
				response.setContentType("text/html; charSet = UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("if (confirm('정말 삭제하시겠습니까?')) {");
				out.println("  location.href='deleteForm.user';");
				out.println("} else {");
				out.println(" location.href='mypage.user';");
				out.println("}");
				out.println("</script>");
						
			}else {
				response.setContentType("text/html; charset=UTF-8");

				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호를 확인해주세요')");
				out.println("location.href='user_delete.jsp';");
				out.println("</script>");
				

			}
		}
	}

}
