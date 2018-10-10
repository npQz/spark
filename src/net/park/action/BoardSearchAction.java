package net.park.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.park.db.BoardDAO;
import net.park.db.BoardDTO;

public class BoardSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("BOARD_NAME");
		
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
		
		forward = new ActionForward();
		forward.setPath("./board/board_view.jsp");
		forward.setRedirect(false);
		
		return forward;
		
		
	}
	
	
}
