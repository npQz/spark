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
	
	
	//시간계산
	public String timeSet(String before) {
		String time = before;
		String colon = ":";
		int pos = 0;
		System.out.println("::"+time.length());
		time = time.trim();
		if(time.length() == 1) {
			time = "자정";
			//System.out.println("1");
			return time;
		}else if(time.length() == 3) {
			//System.out.println("2");
			pos = 1;
		}else {
			//System.out.println("3");
			pos = 2;
		}
		//System.out.println("4");
		time = time.substring(0, pos)+colon+time.substring(pos);
		return time;
	}
	
	
	//글 내용 보기(세부항목)
	public BoardDTO getDetail(String name) {
		BoardDTO board = null;
		String sql = "select * from SPark where PARKING_NAME = ? ";
		//System.out.println("담아주기전");
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
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
				
				//System.out.println("!!!!");
			}
			//System.out.println("담아준 후");
			//System.out.println(board.getParking_name());
			String dummy="";
			dummy=board.getTel();
			dummy=dummy.trim();
			if( dummy.equals("NA")) {
				board.setTel("-");
			}
			dummy=board.getFulltime_monthly();
			dummy=dummy.trim();
			if(dummy.equals("NA") || dummy.equals("0")) {
				board.setFulltime_monthly("-");
			}else if(dummy.length()>3){
				dummy = dummy.substring(0, dummy.length()-3)+","+dummy.substring(dummy.length()-3, dummy.length());
				board.setFulltime_monthly(dummy);
			}
			dummy=board.getDay_maximum();
			dummy=dummy.trim();
			if(dummy.equals("NA") || dummy.equals("0")) {
				board.setDay_maximum("-");
			}else if(dummy.length()>3){
				dummy = dummy.substring(0, dummy.length()-3)+","+dummy.substring(dummy.length()-3, dummy.length());
				board.setDay_maximum(dummy);
			}
			dummy=board.getRates();
			dummy=dummy.trim();
			if(dummy.equals("NA")|| dummy.equals("0")) {
				board.setRates("-");
			}else if(dummy.length()>3){
				dummy = dummy.substring(0, dummy.length()-3)+","+dummy.substring(dummy.length()-3, dummy.length());
				board.setRates(dummy);
			}
			dummy=board.getTime_rate();
			dummy=dummy.trim();
			if(dummy.equals("NA")|| dummy.equals("0")) {
				board.setTime_rate("-");
			}else if(dummy.length()>3){
				dummy = dummy.substring(0, dummy.length()-3)+","+dummy.substring(dummy.length()-3, dummy.length());
				board.setTime_rate(dummy);
			}
			dummy=board.getAdd_rates();
			dummy=dummy.trim();
			if(dummy.equals("NA")|| dummy.equals("0")) {
				board.setAdd_rates("-");
			}else if(dummy.length()>3){
				dummy = dummy.substring(0, dummy.length()-3)+","+dummy.substring(dummy.length()-3, dummy.length());
				board.setAdd_rates(dummy);
			}
			dummy=board.getAdd_time_rate();
			dummy=dummy.trim();
			if(dummy.equals("NA")|| dummy.equals("0")) {
				board.setAdd_time_rate("-");
			}else if(dummy.length()>3){
				dummy = dummy.substring(0, dummy.length()-3)+","+dummy.substring(dummy.length()-3, dummy.length());
				board.setAdd_time_rate(dummy);
			}
			
			System.out.println(board.getWeekday_begin_time());
			
			BoardDAO dao = new BoardDAO();
			board.setWeekday_begin_time(dao.timeSet(board.getWeekday_begin_time()));
			board.setWeekday_end_time(dao.timeSet(board.getWeekday_end_time()));
			board.setWeekend_begin_time(dao.timeSet(board.getWeekend_begin_time()));
			board.setWeekend_end_time(dao.timeSet(board.getWeekend_end_time()));
			board.setHoliday_begin_time(dao.timeSet(board.getHoliday_begin_time()));
			board.setHoliday_end_time(dao.timeSet(board.getHoliday_end_time()));
			
			System.out.println(board.getWeekday_begin_time());
			System.out.println(board.getTel());
			
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
	
	public BoardDTO getInfo(String code) {
		String sql = "SELECT * FROM SPARK WHERE PARKING_CODE = ? ";
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				
				board.setParking_name(rs.getString("PARKING_NAME"));
				board.setAddr(rs.getString("ADDR"));
				board.setTel(rs.getString("TEL"));
				
				return board;
			}
			
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
