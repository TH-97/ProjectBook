package com.ProjectBook.book.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ProjectBook.book.model.BookDAO;
import com.ProjectBook.book.model.BookVO;

public class BookServiceImpl implements BookService {
	
	private BookDAO dao = BookDAO.getInstance();

	@Override
	public ArrayList<BookVO> searchBook(HttpServletRequest request, HttpServletResponse response) {
		String book_name = request.getParameter("search_book");
		ArrayList<BookVO> result = dao.searchBook(book_name);
		return result;
	}

	@Override
	public int insertBook(HttpServletRequest request, HttpServletResponse response) {

		String book_name = request.getParameter("book_name");
		String book_author = request.getParameter("book_author");
		String book_publisher = request.getParameter("book_publisher");
		
//		SimpleDateFormat dt = new SimpleDateFormat("yyyyy/mm/dd");
//		Date book_releasedate =  dt.parse(request.getParameter("book_releasedate"));
		String book_category = request.getParameter("book_category");
		int book_price = Integer.parseInt(request.getParameter("book_price"));
		String book_grade = request.getParameter("book_grade");
		BookVO vo = new BookVO(0,book_name,book_author,book_publisher,null,
				book_category,book_price,0,book_grade,0);
		int result = 0;
		result = dao.insertBook(vo);
		
		return result;
	}

}
