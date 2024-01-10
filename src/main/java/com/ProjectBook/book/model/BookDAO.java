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
	//커넥션 풀에서 가져오기
	private DataSource dataSource;
	
	private BookDAO() {
		try {
			
			InitialContext init = new InitialContext();
			dataSource = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
			
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
	//랜덤 인트 
	
	public ArrayList<BookVO> searchBook(String name) {
		ArrayList<BookVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from booklist where book_name = ?";
		
		try {
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
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
				
				BookVO vo = new BookVO(book_num,
										book_name,
										book_author,
										book_publisher,
										book_releasedate,
										book_category,
										book_price,
										love,
										book_grade,
										book_stock);
				
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

}
