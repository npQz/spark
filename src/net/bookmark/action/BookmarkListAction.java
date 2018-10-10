package net.bookmark.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bookmark.db.BookmarkDAO;

public class BookmarkListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		BookmarkDAO bmdao = new BookmarkDAO();
		HttpSession session = request.getSession();
		String email=(String)session.getAttribute("email");
		
		/*if(email == null) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
		}*/
		// 어차피 로그인 안하면 email null 이기 때문에
		
		Vector vector = bmdao.getBookmarkList(email);
		List bookmarklist = (ArrayList)vector.get(0);
		List parklist = (ArrayList)vector.get(1);
		
		request.setAttribute("bookmarklist", bookmarklist);
		request.setAttribute("parklist", parklist);
		
		forward.setRedirect(false);
		forward.setPath("");
		
		return forward;
	}

}
