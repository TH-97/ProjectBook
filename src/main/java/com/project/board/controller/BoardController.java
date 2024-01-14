package com.project.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ProjectBook.book.model.BookVO;
import com.project.board.model.BoardVO;
import com.project.board.service.BoardService;
import com.project.board.service.BoardServiceImpl;

@WebServlet("*.board") ///
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response); ///
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response); ///
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 3. URL주소를 분기(각 요청별로 코드를 만듬)
		request.setCharacterEncoding("utf-8"); // 한글처리

		String uri = request.getRequestURI();
		String path = uri.substring(request.getContextPath().length());

		System.out.println(path);

		//////////////////////////////////////////////////////////////
		// 서비스 영역
		BoardService service = new BoardServiceImpl();

		if (path.equals("/book/list.board")) { // 목록화면

			// 목록데이터를 가지고 화면으로 이동
			ArrayList<BoardVO> list = service.getList(request, response);
			request.setAttribute("list", list);
			request.getRequestDispatcher("bookboard_list.jsp").forward(request, response);

		} else if (path.equals("/book/write.board")) { // 글쓰기화면

			request.getRequestDispatcher("bookboard_write.jsp").forward(request, response);

		} else if (path.equals("/book/registForm.board")) { // 글 등록

			service.regist(request, response);
			// MVC2에서는 redirect를 다시 컨트롤러 연결하는 형태로 사용
			response.sendRedirect("list.board");

		} else if (path.equals("/book/content.board")) {

			service.hitUpdate(request, response); // 조회수
			BoardVO vo = service.getContent(request, response); // 내용조회
			request.setAttribute("vo", vo);

			request.getRequestDispatcher("bookboard_content.jsp").forward(request, response);
		} else if (path.equals("/book/modify.board")) {

			/*
			 * 1. 화면에서는 필요한 값을 넘겨주세요. 2. getContent메서드 재활용합니다. 3. 포워드방식으로 board_modify.jsp로
			 * 이동합니다. 4. 화면에 수정할 데이터를 미리보여주면 됩니다.
			 */
			BoardVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("bookboard_modify.jsp").forward(request, response);

		} else if (path.equals("/book/update.board")) {

			/*
			 * 1. service, dao에 int update(매개값) 를 생성하세요. 2. update() 메서드에서는 sql문으로 수정을 진행 3.
			 * 성공실패 여부는 정수형으로 반환을 받으세요. 4. 컨트롤러에서는 성공시에 상세화면 redirect, 실패시에는 수정화면으로 redirect
			 * 
			 */

			int result = service.update(request, response);

			if (result == 1) { // 성공
				response.sendRedirect("content.board?bul_num=" + request.getParameter("bul_num"));
			} else { // 실패
				response.sendRedirect("modify.board?bul_num=" + request.getParameter("bul_num"));
			}

		} else if (path.equals("/book/delete.board")) { // 삭제기능
			String bul_num = request.getParameter("bul_num");
			response.setContentType("text/html; charSet = UTF-8");
			PrintWriter out = response.getWriter();

			out.println("<script>");
			out.println("if (confirm('정말 삭제하시겠습니까?')) {");
			out.println("  location.href='deleteForm.board?bul_num=" + bul_num + "';");
			out.println("} else {");
			out.println(" location.href='list.board';");
			out.println("}");
			out.println("</script>");

		} else if (path.equals("/book/deleteForm.board")) {
			service.delete(request, response);

			response.setContentType("text/html; charSet = UTF-8");
			PrintWriter out = response.getWriter();

			out.println("<script>");
			out.println("alert('삭제가 완료되었습니다')");
			out.println("location.href='list.board';");
			out.println("</script>");
		}
		// 책 찾기
		if (path.equals("/book/search.book")) {

			ArrayList<BoardVO> list = service.searchBoard(request, response);
			request.setAttribute("list", list);

			request.getRequestDispatcher("book_search.jsp").forward(request, response);

		}

	}

}
