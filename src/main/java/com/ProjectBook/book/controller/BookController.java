package com.ProjectBook.book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ProjectBook.book.model.BookVO;
import com.ProjectBook.book.service.BookServiceImpl;

/**
 * Servlet implementation class BookController
 */
@WebServlet("*.book")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String path = uri.substring(request.getContextPath().length());
		System.out.println(path);
		
		//서비스 영역 선언
		BookServiceImpl service = new BookServiceImpl();
		
		if(path.equals("/book/search.book")) { 
			
			ArrayList<BookVO> list = service.searchBook(request, response);
			request.setAttribute("list", list);	
			
			request.getRequestDispatcher("book_search.jsp").forward(request, response);
			
		}
		
	}

}
