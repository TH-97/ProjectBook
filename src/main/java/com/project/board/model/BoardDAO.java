
package com.project.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ProjectBook.util.JdbcUtil;

import oracle.jdbc.proxy.annotation.Pre;


public class BoardDAO {
	
	//싱글톤
	//1. 객체 1개 생성
	private static BoardDAO instance = new BoardDAO();
	//2. 생성자 private
	private BoardDAO() {
		
		try {
			//드라이버 호출문장
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//초기설정 값을 얻을 수 있는 객체
			InitialContext init = new InitialContext();
			dataSource = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
			
			
		} catch (Exception e) {
		}
		
	}
	//3. getter메서드
	public static BoardDAO getInstance() {
		return instance;
	}
	
	/////////////////////////////////////////////
	//private String url = JdbcUtil.url;
	//private String uid = JdbcUtil.uid;
	//private String upw = JdbcUtil.upw;
	
	//커넥션풀에서 얻어온 디비객체 정보.
	private DataSource dataSource;
	
	//글등록
	public void insert(String writer, String title, String content) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into board(bno, writer, title, content) "
				   + "values(board_seq.nextval, ?, ?, ? )";
		
		try {
			
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer );
			pstmt.setString(2, title );
			pstmt.setString(3, content );
			
			pstmt.executeUpdate();
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		
	}
	
	//목록조회
	public ArrayList<BoardVO> getList() {
		
		ArrayList<BoardVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from board order by bno desc";
		
		try {
			
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int bul_num = rs.getInt("bul_num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int like_count = rs.getInt("like_count");
				Timestamp regdate = rs.getTimestamp("regdate");
				String user_id = rs.getString("user_id");
				
				BoardVO vo = new BoardVO(bul_num, title, content, like_count, regdate, user_id);
								
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

		return list;
	}
	
	//내용조회
	public BoardVO getContent(String bno) {
		
		BoardVO vo = new BoardVO(); //
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from board where bul_num = ?";
		
		try {
			
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int bul_num = rs.getInt("bul_num");
				String user_id = rs.getString("user_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int like_count = rs.getInt("like_count");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				vo.setBul_num(bul_num);
				vo.setUser_id(user_id);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setLike_count(like_count);
				vo.setRegdate(regdate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

		return vo;
	}
	
	//글 수정
	public int update(String bul_num, String title, String content) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update board set title = ?, content = ? where bul_num = ?";
		
		try {
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title );
			pstmt.setString(2, content );
			pstmt.setString(3, bul_num );
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		return result;
	}
	
	//삭제기능(삭제는 나중에 컬럼을 하나 만들고 사용하지 않음 Y, N)
	public void delete(String bul_num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from board where bul_num = ?";
		
		try {
			
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bul_num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
	}
	
	//조회수작업
	public void hitUpdate(String bul_num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update board set like_count = like_count + 1 where bul_num = ?";
		
		try {
			
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bul_num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
