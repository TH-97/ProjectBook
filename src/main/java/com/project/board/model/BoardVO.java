package com.project.board.model;

import java.sql.Timestamp;

public class BoardVO {

	private int bul_num;
	private String title;
	private String content;
	private int like_count;
	private Timestamp regdate;
	private String user_id;
	
	public BoardVO() {
	}

	public BoardVO(int bul_num, String title, String content, int like_count, Timestamp regdate,String user_id) {
		super();
		this.bul_num = bul_num;
		this.title = title;
		this.content = content;
		this.like_count = like_count;
		this.regdate = regdate;
		this.user_id = user_id;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bul_num=" + bul_num + ", title=" + title + ", content=" + content + ", like_count="
				+ like_count + ", regdate=" + regdate + ", user_id=" + user_id + "]";
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

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	
	
	
	
}
