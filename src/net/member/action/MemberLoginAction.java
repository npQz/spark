package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberDAO;
import net.member.db.MemberDTO;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();

		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();

		int result = -1;
		String result2;
		
		/*String email = request.getParameter("email");*/

		dto.setEMAIL(request.getParameter("email"));
		dto.setPASSWORD(request.getParameter("pw"));
		result = dao.memberCheck(dto);
		

		if (result == 0) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.')");
			out.println("location.href='/Signin.bo'");
			out.println("</script>");
			out.close();
			return null;

		} else if (result == -1) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다.')");
			out.println("location.href='/Signin.Lo'");
			out.println("</script>");
			out.close();
			return null;
			
		}
		String name = dao.memberName(dto.getEMAIL());
		
		System.out.println(name);
		
		session.setAttribute("email", dto.getEMAIL());
		session.setAttribute("name", name);
		
		forward.setRedirect(true);
		forward.setPath("/Home.Lo");

		return forward;

	}

}
