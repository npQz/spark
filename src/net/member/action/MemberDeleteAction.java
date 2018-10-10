package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberDAO;
import net.member.db.MemberDTO;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		HttpSession session = request.getSession();
		MemberDAO dao =  new MemberDAO();
		MemberDTO dto =  new MemberDTO();
		
		boolean result = false;
		
		String email = (String) session.getAttribute("email");
		
		result=dao.memberDelete(email);
		request.getSession().invalidate();
		
		if(result == false) {
				System.out.println("회원 삭제 실패");
				return null;
		}
		forward.setRedirect(true);
		forward.setPath("/Home.Lo");
		return forward;
	}
}
