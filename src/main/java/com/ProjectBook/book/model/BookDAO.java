package com.ProjectBook.book.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

import com.ProjectBook.util.JdbcUtil;

public class BookDAO {

	private static BookDAO instance = new BookDAO();
	// 커넥션 풀에서 가져오기
	private DataSource dataSource;

	private BookDAO() {
		try {

			InitialContext init = new InitialContext();
			dataSource = (DataSource) init.lookup("java:comp/env/jdbc/oracle");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static BookDAO getInstance() {
		return instance;
	}
	///////////////////////////////////////

	private String url = JdbcUtil.url;
	private String uid = JdbcUtil.uid;
	private String upw = JdbcUtil.upw;
	// 랜덤 인트

	// 책 검색
	public ArrayList<BookVO> searchBook(String name) {
		ArrayList<BookVO> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from booklist where book_name like ?";

		try {
			conn = dataSource.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int book_num = rs.getInt("book_num");
				String book_name = rs.getString("book_name");
				String book_author = rs.getString("book_author");
				String book_publisher = rs.getString("book_publisher");
				Date book_releasedate = rs.getDate("book_releasedate");
				String book_category = rs.getString("book_category");
				int book_price = rs.getInt("book_price");
				int love = rs.getInt("love");
				String book_grade = rs.getString("book_grade");
				int book_stock = rs.getInt("book_stock");

				BookVO vo = new BookVO(book_num, book_name, book_author, book_publisher, book_releasedate,
						book_category, book_price, love, book_grade, book_stock);

				list.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		System.out.println(list);
		return list;

	}

	// 내 중고책 판매(테이블에 넣기)
	public int insertBook(BookVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		

		String sql = "insert into booklist(book_num, book_name, book_author, book_publisher,BOOK_RELEASEDATE,BOOK_CATEGORY,BOOK_PRICE,LOVE,BOOK_GRADE,BOOK_STOCK) " 
						+ "values(20, ?, ?, ?,'2022/01/09', ?, ?, 0, ?, 1 )";
		
		try {

			conn = dataSource.getConnection();

			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBook_name());
			pstmt.setString(2, vo.getBook_author());
			pstmt.setString(3, vo.getBook_publsher());
			pstmt.setString(4, vo.getBook_category());
			pstmt.setInt(5, vo.getBook_price());
			pstmt.setString(6, vo.getBook_grade());

			
			pstmt.executeQuery();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		return 0;
	}

	// 중고책 구매(책 재고를 -1)
	
	// 장바구니
	
	// 좋아요 는 유저에서













}
