package com.ProjectBook.book.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ProjectBook.book.model.BookVO;

public interface BookService {
	
	public ArrayList<BookVO> searchBook (HttpServletRequest request, HttpServletResponse response);
	public int insertBook (HttpServletRequest request, HttpServletResponse response);
	

}
