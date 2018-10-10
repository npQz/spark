package net.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
  
  DataSource ds;
  Connection con;
  PreparedStatement pstmt;
  ResultSet rs;
  
  public MemberDAO() {
    
    try {
      Context init = new InitialContext();
      ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
      
    } catch (NamingException e) {
      System.out.println("DB 연결 실패");
      e.printStackTrace();
    }
    
  }
  
  public int memberCheck(MemberDTO dto) { // 로그인 db
    String sql = "SELECT PASSWORD FROM MEMBER WHERE EMAIL=?";
    int result = -1;
    
    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, dto.getEMAIL());
      rs = pstmt.executeQuery();
      
      if (rs.next()) {
        if (rs.getString("PASSWORD").equals(dto.getPASSWORD())) {
          result = 1;//일치.
        } else {
          result = 0;//불일치.
        }
      } else {
        result = -1;//아이디 존재하지 않음.
        
      }
      
    } catch (Exception e) {
    } finally {
      if (rs != null) try {
        rs.close();
      } catch (SQLException e) {
      }
      if (pstmt != null) try {
        pstmt.close();
      } catch (SQLException e) {
      }
      if (con != null) try {
        con.close();
      } catch (SQLException e) {
      }
    }
    
    return result;
  }
  
  public String memberName(String email) {
    String sql = "SELECT NAME FROM MEMBER WHERE EMAIL=?";
    
    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(sql);
      
      pstmt.setString(1, email);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        String name = rs.getString("NAME");
        
        return name;
      }
      
    } catch (Exception e) {
    } finally {
      if (rs != null) try {
        rs.close();
      } catch (SQLException e) {
      }
      if (pstmt != null) try {
        pstmt.close();
      } catch (SQLException e) {
      }
      if (con != null) try {
        con.close();
      } catch (SQLException e) {
      }
    }
    
    return null;
    
  }
  
  
  public boolean memberInsert(MemberDTO dto) { // 회원가입 관련된 db
    String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?)";
    int result = 0;
    
    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(sql);
      
      pstmt.setString(1, dto.getEMAIL());
      pstmt.setString(2, dto.getPASSWORD());
      pstmt.setString(3, dto.getNAME());
      pstmt.setString(4, dto.getAGE());
      pstmt.setString(5, dto.getGENDER());
      result = pstmt.executeUpdate();
      
      if (result != 0) {
        return true;
      }
      
      
    } catch (SQLException e) {
      
      System.out.println("memberInserterror : " + e);
    } finally {
      if (rs != null) try {
        rs.close();
      } catch (SQLException e) { /*e.printStackTrace();*/ }
      if (pstmt != null) try {
        pstmt.close();
      } catch (SQLException e) { /*e.printStackTrace();*/ }
      if (con != null) try {
        con.close();
      } catch (SQLException e) { /*e.printStackTrace();*/ }
    }
    
    return false;
    
  }
  
  /*public boolean memberModify(MemberDTO dto) {
    
    String sql = "UPDATE MEMBER SET PASSWORD = ? WHERE EMAIL = ? ";
    
    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, dto.getPASSWORD());
      pstmt.setString(2, dto.getEMAIL());
            
      pstmt.executeUpdate();
      
      return true;
      
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (pstmt != null) try {
        pstmt.close();
      } catch (SQLException e) { e.printStackTrace(); }
      if (con != null) try {
        con.close();
      } catch (SQLException e) { e.printStackTrace(); }
    }
    
    return false;
  }*/
  
  public boolean memberModify(String email, String new_pw) {
	    
	    String sql = "UPDATE MEMBER SET PASSWORD = ? WHERE EMAIL = ? ";
	    
	    System.out.println(email);
	    System.out.println(new_pw);
	    
	    try {
	      con = ds.getConnection();
	      pstmt = con.prepareStatement(sql);
	      pstmt.setString(1, new_pw);
	      pstmt.setString(2, email);
	            
	      pstmt.executeUpdate();
	      
	      return true;
	      
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      if (pstmt != null) try {
	        pstmt.close();
	      } catch (SQLException e) { /*e.printStackTrace();*/ }
	      if (con != null) try {
	        con.close();
	      } catch (SQLException e) { /*e.printStackTrace();*/ }
	    }
	    
	    return false;
	  }
  
  public MemberDTO getDetail(String email) {
    String sql = "SELECT * FROM MEMBER WHERE EMAIL =? ";
    
    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, email);
      rs = pstmt.executeQuery();
      
      while (rs.next()) {
        MemberDTO dto = new MemberDTO();
        dto.setEMAIL(rs.getString("EMAIL"));
        dto.setPASSWORD(rs.getString("PASSWORD"));
        dto.setNAME(rs.getString("NAME"));
        dto.setAGE(rs.getString("AGE"));
        dto.setGENDER(rs.getString("GENDER"));
        
        return dto;
      }
      

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (rs != null) try {
        rs.close();
      } catch (SQLException e) { /*e.printStackTrace();*/ }
      if (pstmt != null) try {
        pstmt.close();
      } catch (SQLException e) { /*e.printStackTrace();*/ }
      if (con != null) try {
        con.close();
      } catch (SQLException e) { /*e.printStackTrace();*/ }
    }
    
    return null;
  }
  
  public MemberDTO chkMem(String email) {
	    String sql = "SELECT * FROM MEMBER WHERE EMAIL =? ";
	    
	    try {
	      con = ds.getConnection();
	      pstmt = con.prepareStatement(sql);
	      pstmt.setString(1, email);
	      rs = pstmt.executeQuery();
	      
	      while (rs.next()) {
	        MemberDTO dto = new MemberDTO();
	        dto.setPASSWORD(rs.getString("PASSWORD"));
	        System.out.println("success chk");
	        return dto;
	      }
	      	      
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      if (rs != null) try {
	        rs.close();
	      } catch (SQLException e) { /*e.printStackTrace();*/ }
	      if (pstmt != null) try {
	        pstmt.close();
	      } catch (SQLException e) { /*e.printStackTrace();*/ }
	      if (con != null) try {
	        con.close();
	      } catch (SQLException e) { /*e.printStackTrace();*/ }
	    }
	    
	    return null;
	  }
  
  
  public boolean memberDelete(String email) {
    String sql = "DELETE FROM MEMBER WHERE EMAIL = ? ";
    int result = 0;
    
    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, email);
      result = pstmt.executeUpdate();
     
      return true;
      
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (pstmt != null) try {
        pstmt.close();
      } catch (SQLException e) { /*e.printStackTrace();*/ }
      if (con != null) try {
        con.close();
      } catch (SQLException e) { /*e.printStackTrace();*/ }
    }
    
    return false;
  }
  
  public int IdChk(String email) {
    String sql = "SELECT * FROM MEMBER WHERE EMAIL=?";
    
    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(sql);
      
      pstmt.setString(1, email);
      rs = pstmt.executeQuery();
      
      if (rs.next()) {
        return 1;
      }
      
    } catch (Exception e) {
    } finally {
      if (rs != null) try {
        rs.close();
      } catch (SQLException e) {
      }
      if (pstmt != null) try {
        pstmt.close();
      } catch (SQLException e) {
      }
      if (con != null) try {
        con.close();
      } catch (SQLException e) {
      }
    }
    
    return 0;
    
  }
}




