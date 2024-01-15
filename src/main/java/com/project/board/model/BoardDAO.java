
package com.project.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ProjectBook.book.model.BookVO;
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
			dataSource = (DataSource)init.lookup("java:comp/env/jdbc/oracle1");


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
	public void insert(String writer, String title, String content, String state) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into board(bul_num, writer, title, content, state) "
				+ "values(board_seq2.nextval, ?, ?, ? ,?)";

		try {

			conn = dataSource.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer );
			pstmt.setString(2, title );
			pstmt.setString(3, content );
			pstmt.setString(4, state);

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

		String sql = "select * from board order by bul_num desc";

		try {

			conn = dataSource.getConnection();

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				int bul_num = rs.getInt("bul_num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				int like_count = rs.getInt("like_count");
				String writer = rs.getString("writer");
				int hit = rs.getInt("hit");
				String state = rs.getString("state");

				BoardVO vo =new BoardVO(bul_num, title, content, regdate, like_count, writer, hit,state);
				;

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
	public BoardVO getContent(String bul_num) {

		BoardVO vo = new BoardVO(); //

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from board where bul_num = ?";

		try {

			conn = dataSource.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bul_num);

			rs = pstmt.executeQuery();

			if(rs.next()) {

				int bul_num2 = rs.getInt("bul_num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				int like_count = rs.getInt("like_count");
				String writer = rs.getString("writer");
				int hit = rs.getInt("hit");
				String state = rs.getString("state");

				vo.setBul_num(bul_num2);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setRegdate(regdate);
				vo.setLike_count(like_count);
				vo.setWriter(writer);
				vo.setHit(hit);
				vo.setState(state);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

		return vo;
	}

	//글 수정
	public int update(String bul_num, String title, String content , String state) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update board set title = ?, content = ?, state = ? where bul_num = ?";

		try {
			conn = dataSource.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title );
			pstmt.setString(2, content );
			pstmt.setString(3, state);
			pstmt.setString(4, bul_num );

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

		String sql = "update board set hit = hit + 1 where bul_num = ?";

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
	public void lcupdate(String bul_num) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update board set like_count = like_count + 1 where bul_num = ?";

		try {
			conn = dataSource.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bul_num);

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	// 게시물 검색
	public ArrayList<BoardVO> searchBoard(String borad_name) {
		ArrayList<BoardVO> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from board where title like ?";

		try {
			conn = dataSource.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+borad_name+"%");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bul_num = rs.getInt("bul_num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate =rs.getTimestamp("regdate");
				int like_count = rs.getInt("like_count");
				String writer = rs.getString("writer");
				int hit = rs.getInt("hit");
				String state = rs.getString("state");

				BoardVO vo = new BoardVO(bul_num,title,content,regdate,like_count,writer,hit,
						state);

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
	// 나의 게시물 검색
	public ArrayList<BoardVO> searchMyBoard(String writer1) {
		ArrayList<BoardVO> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from board where writer = ?";

		try {
			conn = dataSource.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,writer1);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bul_num = rs.getInt("bul_num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate =rs.getTimestamp("regdate");
				int like_count = rs.getInt("like_count");
				String writer = rs.getString("writer");
				int hit = rs.getInt("hit");
				String state = rs.getString("state");

				BoardVO vo = new BoardVO(bul_num,title,content,regdate,like_count,writer,hit,
						state);

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
