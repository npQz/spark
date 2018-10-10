package net.member.action;

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
		
		dto.setPASSWORD(request.getParameter("pw"));
		
		
		result = dao.memberModify(dto);
		
		if(result == false) {
			System.out.println("회원정보 수정에 실패하였습니다.");
			return null;
		}
		
		forward.setRedirect(true);
		forward.setPath("./Home.Lo");
		return forward;
	}

}
