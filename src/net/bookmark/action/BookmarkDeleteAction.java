package net.bookmark.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bookmark.db.BookmarkDAO;

public class BookmarkDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BookmarkDAO bmdao=new BookmarkDAO();
		HttpSession session = request.getSession();
		String email=(String)session.getAttribute("email");
		
		if(email==null){ 
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		String addr=request.getParameter("addr");
		if(addr==null){
			return null;
		}
		
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./.ba");
		return forward;
	}

}
