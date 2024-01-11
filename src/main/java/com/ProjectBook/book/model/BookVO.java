package com.ProjectBook.book.model;

public class BookVO {

	//DB의 컬럼과 동일하게 변수명 선언
	private int book_num;
	private String img;
	private String book_name;
	private String book_author;
	private String book_publsher;
	private String book_releasedate;
	private String book_category;
	private int book_price;
	private String book_grade;

		
	public BookVO() {
		// TODO Auto-generated constructor stub
	}
	public BookVO(
				  int book_num,
				  String img,
				  String book_name,
				  String book_author,
				  String book_publsher,
				  String book_releasedate,
				  String book_category,
				  int book_price,
				  String book_grade
				  ) {
		super();
		this.img = img;
		this.book_num = book_num;
		this.book_name =book_name;
		this.book_author =book_author;
		this.book_publsher =book_publsher;
		this.book_releasedate =book_releasedate;
		this.book_category =book_category;
		this.book_price =book_price;
		this.book_grade = book_grade;

	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public String getBook_releasedate() {
		return book_releasedate;
	}
	public void setBook_releasedate(String book_releasedate) {
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
	public String getBook_grade() {
		return book_grade;
	}
	public void setBook_grade(String book_grade) {
		this.book_grade = book_grade;
	}
	
		
}
