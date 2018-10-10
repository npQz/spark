package net.bookmark.action;

import net.bookmark.db.BookmarkDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BmkDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BookmarkDAO dao = new BookmarkDAO();
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		String bmk_name = request.getParameter("BOOKMARK_NAME");
		
		Boolean result = null;
		
		result = dao.bmkDelete(email, bmk_name);
		
		if (result == null) {
			System.out.println("delete fail");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("/BmkView.me");
		return forward;
	}

}
