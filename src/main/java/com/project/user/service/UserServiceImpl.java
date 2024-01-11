package com.project.user.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.user.model.UserDAO;
import com.project.user.model.UserVO;

public class UserServiceImpl implements UserService{

	private UserDAO dao =UserDAO.getInstance();
	
	@Override
	public int join(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String name = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		String address = request.getParameter("user_address");
		String gender = request.getParameter("user_gender");

		
		int result = dao.idCheck(id);
		
		if(result == 1) {//아이디 중복
			return 1;
		}else {
			UserVO vo = new UserVO(id, pw, name, email, address, gender, 0);
			dao.insertUser(vo);
			return 0;
		}
	}

	@Override
	public UserVO login(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		UserVO vo = dao.login(id, pw);
		return vo;
	}

	@Override
	public UserVO getUserInfo(HttpServletRequest request, HttpServletResponse response) {
		//회원 아이디는 세션에 있다.
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		
		//getUserInfo 호출
		UserVO vo = dao.getUserInfo(id);
		return vo;
	}

	@Override
	public int update(HttpServletRequest request, HttpServletResponse response) {
		int result = 0;
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String name = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		String address = request.getParameter("user_address");
		String gender = request.getParameter("user_gender");
		int balance =Integer.valueOf(request.getParameter("user_balance"));
		
		UserVO vo = new UserVO(id, pw, name, email, address, gender, balance);
		result = dao.update(vo);
		
		return result;
	}

	@Override
	public int delete(HttpServletRequest request, HttpServletResponse response) {
		int result = 0;
		
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("user_id");
		String pw = request.getParameter("pw");
		
		UserVO vo = dao.login(id, pw);
		
		if(vo !=null) {//비밀번호 일치 즉 삭제가능
			dao.delete(id);
			session.invalidate();
			return 1; //삭제완료
		}else {
			return 0; //계정이 없거나 비밀번호 일치하징낳음
		}
		
		
	}

	@Override
	public int add_balance(HttpServletRequest request, HttpServletResponse response) {
		int result = 0 ;
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		
		String deposit = request.getParameter("deposit");
		
		result = dao.add_balance(id,Integer.valueOf(deposit) );
		
		return result;
	}
	
}
