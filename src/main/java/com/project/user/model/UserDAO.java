package com.project.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.util.DButil;

public class UserDAO {
	//싱글톤 객체
	
	private static UserDAO instance = new UserDAO();
	//2.생성자 private
	
	private UserDAO() {
	
		try {
			InitialContext init = new InitialContext();
			
			dataSource = (DataSource)init.lookup("java:comp/env/jdbc/oracle1");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//3. getter메소드
	
	public static UserDAO getInstance() {
		return instance;
	}
	private DataSource dataSource;
	
	public int idCheck(String id) { //아이디 확인
		int result = 0 ;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from users where user_id = ?";
		
		try {
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}else {
				result = 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DButil.close(conn, pstmt, rs);
		}
		
		return result; //1이면 아이디가 있고 0이면 없다.
	}
	//회원가입
	public void insertUser(UserVO vo) {

		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into users(user_id,"
				+ "user_pw,"
				+ "user_name,"
				+ "user_email,"
				+ "user_address,"
				+ "user_gender,"
				+ "user_phone)"
					+"values(?,?,?,?,?,?,?)";
		
		try {
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,vo.getUser_id());
			pstmt.setString(2,vo.getUser_pw());
			pstmt.setString(3,vo.getUser_name());
			pstmt.setString(4,vo.getUser_email());
			pstmt.setString(5,vo.getUser_address());
			pstmt.setString(6,vo.getUser_gender());
			pstmt.setString(7,vo.getUser_phone());
			
			pstmt.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DButil.close(conn, pstmt, null);
		}
	}

	//로그인 기능
	public UserVO login(String id , String pw) {
		UserVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from users where user_id = ? and user_pw =?";
		
		
		try {
			 conn = dataSource.getConnection();
			
			 pstmt = conn.prepareStatement(sql);
			
			 pstmt.setString(1, id);
			 pstmt.setString(2, pw);
			 
			 rs = pstmt.executeQuery(); //행 한개 
			 
			 if(rs.next()) {
				 
				 vo = new UserVO();
				 vo.setUser_id(id);
				 vo.setUser_name(rs.getString("user_name"));
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn, pstmt, rs);
		}
		
		
		return vo ;
	}
	//회원 정보를 조회
	public UserVO getUserInfo(String id) {
		UserVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from users where user_id = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //다음이 있으면 true니까 딱 1개나옴
				//데이터 orm작업
				String user_name = rs.getString("user_name");
				String user_email = rs.getString("user_email");
				String user_address = rs.getString("user_address");
				String user_gender = rs.getString("user_gender");
				String user_phone = rs.getString("user_phone");
				
				vo = new UserVO(id ,null , user_name , user_email , user_address , user_gender , user_phone);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DButil.close(conn, pstmt, rs);
		}
		
		
		return vo;
				
	}
	//회원정보 수정
	public int update(UserVO vo) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update users set user_pw = ? , user_name = ? , user_email =? ,user_address=? ,user_gender = ?,user_phone = ? where user_id = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,vo.getUser_pw());
			pstmt.setString(2,vo.getUser_name());
			pstmt.setString(3,vo.getUser_email());
			pstmt.setString(4,vo.getUser_address());
			pstmt.setString(5,vo.getUser_gender());
			pstmt.setString(6,vo.getUser_phone());
			pstmt.setString(7,vo.getUser_id());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DButil.close(conn, pstmt, null);
		}
		
		return result ;
	}
	//회원정보 삭제
	public int delete(String id) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from users where user_id =?";
		
		try {
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DButil.close(conn, pstmt, null);
		}
		return result ;
	}
	

}
