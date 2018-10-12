package net.bookmark.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import net.member.db.MemberDTO;
import net.park.db.BoardDTO;

public class BookmarkDAO {

	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public BookmarkDAO() {

		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");

		} catch (NamingException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}

	}

	public boolean bmkAdd(/* String parking_code */ String email, String name, String addr, String tel) {

		/*
		 * String sql =
		 * "SELECT PARKING_NAME, ADDR, TEL FROM SPARK WHERE PARKING_CODE= ?"; int result
		 * = 0;
		 * 
		 * try { con = ds.getConnection(); pstmt = con.prepareStatement(sql);
		 * pstmt.setString(1, parking_code); rs = pstmt.executeQuery();
		 * 
		 * 
		 * sql = "INSERT INTO BOOKMARK VALUES(?,?,?,?)"; con = ds.getConnection(); pstmt
		 * = con.prepareStatement(sql); pstmt.setString(1, email); pstmt.setString(2,
		 * name); pstmt.setString(3, addr); pstmt.setString(4, tel);
		 * pstmt.executeUpdate();
		 */

		String sql = "INSERT INTO BOOKMARK VALUES(?,?,?,?)";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.setString(4, tel);
			pstmt.executeUpdate();

			/*
			 * result = pstmt.executeUpdate();
			 * 
			 * if(result == 0) return false;
			 * 
			 * return true;
			 */
			return true;
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
		return false;
	}

	public boolean getaddlimit(String email) {
		String sql = "SELECT * FROM BOOKMARK WHERE BOOKMARK_EMAIL = ?";
		List<BookmarkDTO> limit = new ArrayList<BookmarkDTO>();

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookmarkDTO dto = new BookmarkDTO();

				dto.setBOOKMARK_NAME(rs.getString("BOOKMARK_NAME"));
				dto.setBOOKMARK_ADDR(rs.getString("BOOKMARK_ADDR"));
				dto.setBOOKMARK_TEL(rs.getString("BOOKMARK_TEL"));

				limit.add(dto);
			}

			System.out.println(limit.size());

			if (limit.size() < 5) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
		return false;

	}

	/* BMK start */

	public List<BookmarkDTO> getBmkList(String email) {
		String sql = "SELECT * FROM BOOKMARK WHERE BOOKMARK_EMAIL = ?";
		List<BookmarkDTO> bmklist = new ArrayList<BookmarkDTO>();

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookmarkDTO dto = new BookmarkDTO();

				dto.setBOOKMARK_NAME(rs.getString("BOOKMARK_NAME"));
				dto.setBOOKMARK_ADDR(rs.getString("BOOKMARK_ADDR"));
				dto.setBOOKMARK_TEL(rs.getString("BOOKMARK_TEL"));

				bmklist.add(dto);
			}

			return bmklist;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
		return null;

	}

	public int getlistchk(String email, String name) { // 중복체크
		String sql = "SELECT BOOKMARK_NAME FROM BOOKMARK WHERE BOOKMARK_EMAIL=?";
		int result = -1;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println(rs.getString("BOOKMARK_NAME"));
				System.out.println(name);

				if ((rs.getString("BOOKMARK_NAME")).equals(name)) {
					System.out.println("일치");
					result = 0; // 일치
					return result;
				} else {
					result = 1;// 불일치.
					return result;
				}

			}
		} catch (Exception e) {
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
				}
		}

		return 0;
	}

	public boolean bmkDelete(String email, String bmk_name) {
		String sql = "DELETE FROM BOOKMARK WHERE BOOKMARK_EMAIL = ? and BOOKMARK_NAME = ?";

		int result = 0;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, bmk_name);

			result = pstmt.executeUpdate();

			if (result != 0) {

				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}

		return false;
	}
}
