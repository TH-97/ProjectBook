package com.project.board.model;

import java.sql.Timestamp;

public class BoardVO {

	private int bul_num;
	private String title;
	private String content;
	private Timestamp regdate;
	private int like_count;
	private int book_num;
	private String user_id;
	private String writer;
	private int hit;

	
	public BoardVO() {
	}

	public BoardVO(int bul_num, String title, String content, Timestamp regdate,int like_count, int book_num,
			String user_id, String writer, int hit
			) {
		super();
		this.bul_num = bul_num;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.like_count = like_count;
		this.book_num = book_num;
		this.user_id = user_id;
		this.writer = writer;
		this.hit = hit;
		
	}
	
	@Override
	public String toString() {
		return "BoardVO [bul_num=" + bul_num + ", writer=" + writer + ", title=" + title + ", content=" + content + ", hit="
				+ hit + ", regdate=" + regdate + "]";
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

	public int getBook_num() {
		return book_num;
	}

	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	
}
