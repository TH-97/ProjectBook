package com.project.board.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.board.model.BoardVO;
import com.ProjectBook.book.model.BookVO;
import com.project.board.model.BoardDAO;

public class BoardServiceImpl implements BoardService {

	//dao
	private BoardDAO dao = BoardDAO.getInstance();
	
	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String state = request.getParameter("state");
			
		dao.insert(writer, title, content,state);
		
	}

	@Override
	public ArrayList<BoardVO> getList(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<BoardVO> list = dao.getList();
		
		return list;
	}

	@Override
	public BoardVO getContent(HttpServletRequest request, HttpServletResponse response) {
		
		String bul_num = request.getParameter("bul_num");	
		BoardVO vo = dao.getContent(bul_num);
		
		return vo;
	}

	@Override
	public int update(HttpServletRequest request, HttpServletResponse response) {
		
		String bul_num = request.getParameter("bul_num");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String state = request.getParameter("state");
		
		int result = dao.update(bul_num, title, content , state);
		System.out.println(state);
		return result;
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String bul_num = request.getParameter("bul_num");
		dao.delete(bul_num);
	}

	
	@Override
	public void hitUpdate(HttpServletRequest request, HttpServletResponse response) {
		
		//쿠키 or 세션을 사용해서 조회수 중복을 막음
		//Cookie coo = new Cookie(키, 값)
		//coo.setMaxAge(30)
		//response.addCookie(coo)
		String bul_num = request.getParameter("bul_num");

		String cooValue = "";
		boolean flag = true; //if문의 실행여부
		//기존쿠기가 있었는지 확인
		Cookie[] arr = request.getCookies();
		if(arr != null) {
			for(Cookie c : arr) {
				
				if(c.getName().equals("hit")) { //hit쿠키가 있다.
					cooValue = c.getValue(); //쿠키의 값을 저장
					if(c.getValue().contains(bul_num)) {
						System.out.println(true);
						flag = false;
					} 
				}
			}
		}
		
		if(flag) { //if문을 실행 안했음.
			dao.hitUpdate(bul_num);
			cooValue += bul_num + "-";
		}

		Cookie coo = new Cookie("hit", cooValue);
		coo.setMaxAge(30);
		response.addCookie(coo);
				

		
		
	}
	// 게시판 검색해서 전달
	@Override
	public ArrayList<BoardVO> searchBoard(HttpServletRequest request, HttpServletResponse response) {
		String board_name = request.getParameter("search_board");
		ArrayList<BoardVO> list = dao.searchBoard(board_name);
		return list;
		
	}

	@Override
	public ArrayList<BoardVO> searchMyBoard(HttpServletRequest request, HttpServletResponse response) {
		String writer = request.getParameter("writer");
		ArrayList<BoardVO> list = dao.searchMyBoard(writer);
		return list;
	
	}

	
	
	
	
	
	
}
