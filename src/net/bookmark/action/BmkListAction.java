package net.bookmark.action;

import net.bookmark.db.BookmarkDAO;
import net.bookmark.db.BookmarkDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class BmkListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		BookmarkDAO dao = new BookmarkDAO();
		List<BookmarkDTO> bmkList = null;
		
		String email=(String)session.getAttribute("email");
		
		bmkList = dao.getBmkList(email);
		
		request.setAttribute("bmkList", bmkList);
		
		forward.setRedirect(false);
		forward.setPath("/views/favorite.jsp");
		
		return forward;
	}

}
