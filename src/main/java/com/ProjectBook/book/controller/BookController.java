package com.ProjectBook.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
		//책 찾기
		if(path.equals("/book/search.book")) { 
			
			ArrayList<BookVO> list = service.searchBook(request, response);
			request.setAttribute("list", list);	
			
			request.getRequestDispatcher("book_search.jsp").forward(request, response);
		// 내 책 등록
		}if(path.equals("/book/sell.book")) {
			int result = 0;
			result = service.insertBook(request, response);
			
			if(result == 1) { //성공
				// 스크립트 언어
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('정상적으로 판매되었습니다');");
				out.println("location.href='/ProjectBook/home.jsp'; ");//홈화면 가기
				out.println("</script>");
				
			}else { //실패 
				//스크립트 언어
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('정확히 기입해주십시오');");
				out.println("location.href='sell_My_Book.jsp'; ");//홈화면 가기
				out.println("</script>");
				
			}
			
		}
		
	}

}
