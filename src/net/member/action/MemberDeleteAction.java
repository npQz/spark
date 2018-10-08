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
		
		String  email = (String) session.getAttribute("email");
		
		System.out.println(email);
		
		if(email == null) {
			forward.setRedirect(true);
			forward.setPath("home.Lo");
			
			return forward;
		
		} /*else if(email != null) {
			response.setContentType("UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('데이터베이스 오류.')");
			out.println("location.href ='home.Lo';");
			out.println("</script>");
			out.close();
			
			return null;
		}*/
		
		/*String deleteEmail = request.getParameter("email");*/
		
		System.out.println(email);
		
		result=dao.memberDelete(email);
		
		if(result == false) {
				System.out.println("회원 삭제 실패");
				return null;
		}
		
		session.invalidate();
		
		forward.setRedirect(true);
		forward.setPath("/home.Lo");
		return forward;
	}

}
