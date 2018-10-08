package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberDAO;
import net.member.db.MemberDTO;

public class MemberViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			ActionForward forward = new ActionForward();
			HttpSession session = request.getSession();
			MemberDTO dto =  new MemberDTO();
			MemberDAO dao = new MemberDAO();
			
			/*String viewemail = request.getParameter("email");*/
			String email=(String)session.getAttribute("email");
			dto = dao.getDetail(email);
		
		System.out.println(email);
			
			if(dto == null) {
					System.out.println("회원정보 보기 실패");
					
					return null;
			}
		
			request.setAttribute("dto", dto);
	   		
	   		forward.setRedirect(false);
	   		forward.setPath("/MemberView.Lo");
	   		
	   		return forward;
			
			
	}

}
