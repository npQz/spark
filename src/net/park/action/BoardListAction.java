package net.park.action;

import net.park.db.BoardDAO;
import net.park.db.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		request.setCharacterEncoding("utf-8");
		String parking_name = request.getParameter("BOARD_NAME");
		
		request.setAttribute("parking_name", parking_name);
		
		System.out.println("상세보기 성공");
		
		forward = new ActionForward();
		forward.setPath("/views/board_search.jsp");
		forward.setRedirect(false);
		
		return forward;
		
	}
	
}
