package net.park.action;

import net.bookmark.db.BookmarkDAO;
import net.bookmark.db.BookmarkDTO;
import net.park.db.BoardDAO;
import net.park.db.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


public class BoardSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		String name = request.getParameter("PARKING_NAME");
		
		BoardDAO boarddao = new BoardDAO();
		BoardDTO boarddata = new BoardDTO();
		
		System.out.println("상세보기중...");
		System.out.println(name);
		
		//int num = Integer.parseInt(request.getParameter("num"));
		//boarddao.setReadCountUpdate(num);
		boarddata = boarddao.getDetail(name);
		
		if(boarddata == null) {
			System.out.println("상세보기 실패");
			return null;
		}


		System.out.println("상세보기 성공");
		
		request.setAttribute("boarddata", boarddata);
		
		request.setAttribute("parking_name", boarddata.getParking_name());//주차장명
		request.setAttribute("addr", boarddata.getAddr());//위치
		
		request.setAttribute("type", boarddata.getParking_type_nm());//종류
		request.setAttribute("rule", boarddata.getOperation_rule_nm());//종류2
		request.setAttribute("night", boarddata.getNight_free_open_nm());//종류3
		
		request.setAttribute("tel", boarddata.getTel());//전화번호
		request.setAttribute("capa", boarddata.getCapacity());//크기
		
		request.setAttribute("pnm", boarddata.getPay_nm());//평일 유/무료
		request.setAttribute("spnm", boarddata.getSaturday_pay_nm());//토요일 유/무료
		request.setAttribute("hpnm", boarddata.getHoliday_pay_nm());//휴일 유/무료
		
		request.setAttribute("wdbt", boarddata.getWeekday_begin_time());//평일시작주차시간
		request.setAttribute("wdet", boarddata.getWeekday_end_time());//평일끝주차시간
		request.setAttribute("webt", boarddata.getWeekend_begin_time());//주말시작주차시간
		request.setAttribute("weet", boarddata.getWeekend_end_time());//주말끝주차시간
		request.setAttribute("hdbt", boarddata.getHoliday_begin_time());//휴일시작주차시간
		request.setAttribute("hdet", boarddata.getHoliday_end_time());//휴일끝주차시간
		
		request.setAttribute("time", boarddata.getTime_rate());//분당
		request.setAttribute("rate", boarddata.getRates());//분당요금
		request.setAttribute("addtime", boarddata.getAdd_time_rate());//추가분당
		request.setAttribute("addrate", boarddata.getAdd_rates());//추가요금
		request.setAttribute("drate", boarddata.getDay_maximum());//요금1일하루최대요금
		request.setAttribute("mrate", boarddata.getFulltime_monthly());//요금 1달

		/* bmk list */

		BookmarkDAO dao = new BookmarkDAO();
		List<BookmarkDTO> bmkList = null;

		String email= (String)session.getAttribute("email");

		bmkList = dao.getBmkList(email);

		request.setAttribute("bmkList", bmkList);

		forward = new ActionForward();
		forward.setPath("./views/detail.jsp");
		forward.setRedirect(false);
		
		return forward;
		
		
	}
	
	
}
