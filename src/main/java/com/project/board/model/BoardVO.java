package com.project.board.model;

import java.sql.Timestamp;

public class BoardVO {

	private int bul_num;
	private String title;
	private String content;
	private Timestamp regdate;
	private int like_count;
	private String writer; //자동
	private int hit;
	private String state;


	public BoardVO() {
	}


	public BoardVO(int bul_num, String title, String content, Timestamp regdate, int like_count, String writer, int hit,
			String state) {
		super();
		this.bul_num = bul_num;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.like_count = like_count;
		this.writer = writer;
		this.hit = hit;
		this.state = state;
	}


	public int getBul_num() {
		return bul_num;
	}


	public void setBul_num(int bul_num) {
		this.bul_num = bul_num;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Timestamp getRegdate() {
		return regdate;
	}


	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}


	public int getLike_count() {
		return like_count;
	}


	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	
}

