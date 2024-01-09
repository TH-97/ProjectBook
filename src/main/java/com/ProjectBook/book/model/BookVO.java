package com.ProjectBook.book.model;

import java.util.Date;

public class BookVO {

	//DB의 컬럼과 동일하게 변수명 선언
	private int book_num;
	private String book_name;
	private String book_author;
	private String book_publsher;
	private Date book_releasedate;
	private String book_category;
	private int book_price;
	private int love;
	private String book_grade;
	private int book_stock;

		
	public BookVO() {
		// TODO Auto-generated constructor stub
	}
	public BookVO(int book_num,
				  String book_name,
				  String book_author,
				  String book_publsher,
				  Date book_releasedate,
				  String book_category,
				  int book_price,
				  int love,
				  String book_grade,
				  int book_stock
				  ) {
		super();
		this.book_num = book_num;
		this.book_name =book_name;
		this.book_author =book_author;
		this.book_publsher =book_publsher;
		this.book_releasedate =book_releasedate;
		this.book_category =book_category;
		this.book_price =book_price;
		this.love = love;
		this.book_grade = book_grade;
		this.book_stock = book_stock;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_publsher() {
		return book_publsher;
	}
	public void setBook_publsher(String book_publsher) {
		this.book_publsher = book_publsher;
	}
	public Date getBook_releasedate() {
		return book_releasedate;
	}
	public void setBook_releasedate(Date book_releasedate) {
		this.book_releasedate = book_releasedate;
	}
	public String getBook_category() {
		return book_category;
	}
	public void setBook_category(String book_category) {
		this.book_category = book_category;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public String getBook_grade() {
		return book_grade;
	}
	public void setBook_grade(String book_grade) {
		this.book_grade = book_grade;
	}
	public int getBook_stock() {
		return book_stock;
	}
	public void setBook_stock(int book_stock) {
		this.book_stock = book_stock;
	}

		
}
