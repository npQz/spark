package net.bookmark.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bookmark.db.BookmarkDAO;

public class BookmarkDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		BookmarkDAO bmdao = new BookmarkDAO();
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		String bmk_name = request.getParameter("BOOKMARK_NAME");
		
		Boolean result = null;
		
		result = bmdao.bmkDelete(email, bmk_name);
		
		if (result == null) {
			System.out.println("delete fail");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("/views/favorite.jsp");
		return forward;
	}

}
