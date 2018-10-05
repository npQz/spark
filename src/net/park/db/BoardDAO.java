package net.park.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
	DataSource ds;//데이터 소스저장
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public BoardDAO(){
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/*
	//글 목록보기
	public List<BoardDTO> getBoardList(int page, int limit) {
		String board_list_sql = "select * from "+
				"(select rownum rnum,BOARD_NUM,BOARD_NAME,BOARD_SUBJECT,"+
				"BOARD_CONTENT,BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,"+
				"BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE from "+
				"(select * from board order by BOARD_RE_REF desc,BOARD_RE_SEQ asc)) "+
				"where rnum>=? and rnum<=?";
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		int startrow = (page-1)*10 + 1;
		int endrow = startrow + limit - 1;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {//데이터가 있으면 트루
				BoardDTO board = new BoardDTO();//rs의 데이터 값을 dto에 넣어준다
				
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				
				list.add(board);
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {//초기화기능
			if(rs != null) try{rs.close();} catch(SQLException e) {}
			if(pstmt != null) try{pstmt.close();} catch(SQLException e) {}
			if(con != null) try{con.close();} catch(SQLException e) {}
		}
		
		return null;
	}
	*/
	
	/*
	//조회수 업데이트
	public void setReadCountUpdate(int num) {
		//조회수 증가
		String sql = "update board set BOARD_READCOUNT = BOARD_READCOUNT+1 where BOARD_NUM="+num;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {//초기화기능
			if(rs != null) try{rs.close();} catch(SQLException e) {} 업데이트에서는 필요없다
			if(pstmt != null) try{pstmt.close();} catch(SQLException e) {}
			if(con != null) try{con.close();} catch(SQLException e) {}
		}
	}
	*/
	
	
	//글 내용 보기(세부항목)
	public BoardDTO getDetail(String name) {
		BoardDTO board = null;
		String sql = "select * from SPark where PARKING_CODE = "+name;
		System.out.println("담아주기전");
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			//pstmt.setString(1, name); // 왜 안되는지 아무리 해봐도 의문
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				board = new BoardDTO();
				
				board.setParking_code(rs.getString("PARKING_CODE"));
				board.setParking_name(rs.getString("PARKING_NAME"));
				board.setAddr(rs.getString("ADDR"));
				board.setParking_type(rs.getString("PARKING_TYPE"));
				board.setParking_type_nm(rs.getString("PARKING_TYPE_NM"));
				board.setOperation_rule(rs.getString("OPERATION_RULE"));
				board.setOperation_rule_nm(rs.getString("OPERATION_RULE_NM"));
				board.setTel(rs.getString("TEL"));
				board.setCapacity(rs.getString("CAPACITY"));
				board.setCur_parking(rs.getString("CUR_PARKING"));
				board.setPay_yn(rs.getString("PAY_YN"));
				board.setPay_nm(rs.getString("PAY_NM"));
				board.setNight_free_open(rs.getString("NIGHT_FREE_OPEN"));
				board.setNight_free_open_nm(rs.getString("NIGHT_FREE_OPEN_NM"));
				board.setWeekday_begin_time(rs.getString("WEEKDAY_BEGIN_TIME"));
				board.setWeekday_end_time(rs.getString("WEEKDAY_END_TIME"));
				board.setWeekend_begin_time(rs.getString("WEEKEND_BEGIN_TIME"));
				board.setWeekend_end_time(rs.getString("WEEKEND_END_TIME"));
				board.setHoliday_begin_time(rs.getString("HOLIDAY_BEGIN_TIME"));
				board.setHoliday_end_time(rs.getString("HOLIDAY_END_TIME"));
				board.setSaturday_pay_yn(rs.getString("SATURDAY_PAY_YN"));
				board.setSaturday_pay_nm(rs.getString("SATURDAY_PAY_NM"));
				board.setHoliday_pay_yn(rs.getString("HOLIDAY_PAY_YN"));
				board.setHoliday_pay_nm(rs.getString("HOLIDAY_PAY_NM"));
				board.setFulltime_monthly(rs.getString("FULLTIME_MONTHLY"));
				board.setRates(rs.getString("RATES"));
				board.setTime_rate(rs.getString("TIME_RATE"));
				board.setAdd_rates(rs.getString("ADD_RATES"));
				board.setAdd_time_rate(rs.getString("ADD_TIME_RATE"));
				board.setDay_maximum(rs.getString("DAY_MAXIMUM"));
				board.setLat(rs.getString("LAT"));
				board.setLng(rs.getString("LNG"));
				
				System.out.println("!!!!");
			}
			
			System.out.println("담아준 후");
			
			System.out.println(board.getParking_name());
			return board;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {//초기화기능
			if(rs != null) try{rs.close();} catch(SQLException e) {}
			if(pstmt != null) try{pstmt.close();} catch(SQLException e) {}
			if(con != null) try{con.close();} catch(SQLException e) {}
		}
		
		return null;
	}
	

	
}
