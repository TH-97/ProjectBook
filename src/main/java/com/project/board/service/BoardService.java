package com.project.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.board.model.BoardVO;

public interface BoardService {

	public void regist(HttpServletRequest request, HttpServletResponse response);
	public ArrayList<BoardVO> getList(HttpServletRequest request, HttpServletResponse response);
	public BoardVO getContent(HttpServletRequest request, HttpServletResponse response);
	public int update(HttpServletRequest request, HttpServletResponse response);
	public void delete(HttpServletRequest request, HttpServletResponse response);
	public void hitUpdate(HttpServletRequest request, HttpServletResponse response);
	public ArrayList<BoardVO> searchBoard(HttpServletRequest request, HttpServletResponse response);
}




