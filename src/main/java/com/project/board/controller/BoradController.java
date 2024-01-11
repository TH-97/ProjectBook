package com.project.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.user.service.UserService;
import com.project.user.service.UserServiceImpl;

@WebServlet("*.Borad")
public class BoradController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoradController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doaction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doaction(request, response);
	}

	protected void doaction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// url주소를 분기(각 요청별로 코드를 만듦)
		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();
		String path = uri.substring(request.getContextPath().length());

		System.out.println(path);

		// 서비스 영역 선언
		UserService service = new UserServiceImpl();

	}
}
