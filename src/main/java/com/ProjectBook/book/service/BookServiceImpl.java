package com.ProjectBook.book.service;

import java.util.ArrayList;

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

}
