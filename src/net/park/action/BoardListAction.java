package net.park.action;

import net.bookmark.db.BookmarkDAO;
import net.bookmark.db.BookmarkDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		String parking_name = request.getParameter("PARKING_NAME");
		
		request.setAttribute("parking_name", parking_name);

		/* bmk list */

		BookmarkDAO dao = new BookmarkDAO();
		List<BookmarkDTO> bmkList = null;

		String email= (String)session.getAttribute("email");

		bmkList = dao.getBmkList(email);

		request.setAttribute("bmkList", bmkList);

		System.out.println("상세보기 성공");
		
		forward = new ActionForward();
		forward.setPath("/views/board_search.jsp");
		forward.setRedirect(false);
		
		return forward;
		
	}
	
}
