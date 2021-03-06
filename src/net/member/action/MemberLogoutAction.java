package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		     
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		//request.getSession().invalidate();
		
		forward.setRedirect(true);
		forward.setPath("/Home.Lo");
		
		return forward;
	}

}
