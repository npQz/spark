package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberDAO;
import net.member.db.MemberDTO;

public class MemberModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		boolean result = false;
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		
		/*dto.setPASSWORD(request.getParameter("old_pw"));*/
		
		String email=(String)session.getAttribute("email");
		String old_pw = request.getParameter("old_pw");
		String new_pw = request.getParameter("new_pw");
		
		dto = dao.chkMem(email);
		
		System.out.println(dto.getPASSWORD());
		
		if(dto.getPASSWORD().equals(old_pw)) {
			
			result = dao.memberModify(email, new_pw);
			
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.')");
			out.println("location.href='/views/modifyPW.jsp'");
			out.println("</script>");
			out.close();
			return null;
		};
		
		forward.setRedirect(true);
		forward.setPath("/MemberViewAction.Lo");
		return forward;
	}

}
