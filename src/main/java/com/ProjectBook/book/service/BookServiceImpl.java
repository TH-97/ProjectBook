package com.ProjectBook.book.service;


import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
	
		String img = request.getParameter("img");
		String book_name = request.getParameter("book_name");
		String book_author = request.getParameter("book_author");
		String book_publisher = request.getParameter("book_publisher");
		String book_releasedate = request.getParameter("book_releasedate");
		String book_category = request.getParameter("book_category");
		int book_price = Integer.parseInt(request.getParameter("book_price"));
		String book_grade = request.getParameter("book_grade");
		BookVO vo = new BookVO(0,img, book_name, book_author, book_publisher, book_releasedate,
				book_category, book_price, book_grade);
		int result = 0;
		result = dao.insertBook(vo);
		
		return result;
	}

}
