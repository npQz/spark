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

import net.park.db.BoardDTO;

public class BookmarkDAO {
	
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs, rs1;
	
 public BookmarkDAO() {
		
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
		} catch (NamingException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		
	}
 
 public Vector getBookmarkList(String email) {
	 Vector vector=new Vector();
	 String sql = "SELECT * FROM BOOKMARK WHERE BOOKMARK_EMAIL	 =?";
	 List bookmarklist = new ArrayList();
	 List parklist = new ArrayList();
	 
	 try {
		 con = ds.getConnection();
		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1, email);
		 rs = pstmt.executeQuery();
	 
		 while(rs.next()) {
			 BookmarkDTO dto  = new BookmarkDTO();
			 BoardDTO bodto = new BoardDTO();
			 
			 dto.setBOOKMARK_EMAIL(rs.getString("BOOKMARK_EMAIL"));
			 dto.setBOOKMARK_ADDR(rs.getString("BOOKMARK_ADDR"));
			 dto.setBOOKMARK_TEL(rs.getString("BOOKMARK_TEL"));
			 
			 sql = "SELECT * FROM SPARK WHERE ADDR = ?";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1, dto.getBOOKMARK_ADDR());
			 rs1 = pstmt.executeQuery();
			 
			 if(rs1.next()) {
				 bodto.setParking_name(rs1.getString("parking_name"));
				 bodto.setAddr(rs1.getString("addr"));
				 bodto.setTel(rs1.getString("tel"));
			
				 
			 }else {
				 	return null;
			 }
			 bookmarklist.add(dto);
			 parklist.add(bodto);
			 
		 }
		vector.add(bookmarklist);
		vector.add(parklist);
		
		return vector;
	 }catch(SQLException e) {
		 	e.printStackTrace();
	 
	 }finally {
		 	try {
		 		if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
		 	}catch(Exception ex) {}
	 }
	 return null;
	 
 	}
 
 
 public void bookmarkadd(String email, String addr, String tel ) {
	 String sql = "INSERT INTO BOOKMARK VALUES(?,?,?)";
	 
	 
	 try {
		 con = ds.getConnection();
		 pstmt = con.prepareStatement(sql);
		 
		 pstmt.setString(1, email);
		 pstmt.setString(2, addr);
		 pstmt.setString(3, tel);
		 
		 pstmt.executeUpdate();
		 
	 }catch(SQLException e) {
		 e.printStackTrace();
	 
	 }finally {
		 	try {
		 		if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
		 	}catch(Exception ex) {}
	 }
	 	 
 }
 
 public boolean bookmarkRemove(String addr) {
	 String sql = "DELETE FROM BOOKMARK WHERE BOOKMARK_ADDR= ?";
	 int result = 0;
	 
	 try {
		 con = ds.getConnection();
		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1, addr);
		 
		 result = pstmt.executeUpdate();
		 
		 if(result != 0) {
			 
			 return true;
		 }
	 }catch(SQLException e) {
		 	e.printStackTrace();
	 
	 }finally {
		 try {
			 if(pstmt!=null)pstmt.close();
			 if(con!=null)con.close();
		 }catch(Exception ex) {}
	 }
	 
	 return false;
  }

 
 
}












