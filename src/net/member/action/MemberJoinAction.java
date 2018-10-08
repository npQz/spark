package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberDAO;
import net.member.db.MemberDTO;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		boolean result = false;
		ActionForward forward = new ActionForward();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
				
		dto.setEMAIL(request.getParameter("email"));
		dto.setPASSWORD(request.getParameter("pw"));
		dto.setNAME(request.getParameter("name"));
		dto.setAGE(request.getParameter("age"));
		dto.setGENDER(request.getParameter("gender"));
		
		
		System.out.println(dto.getEMAIL());
		System.out.println(dto.getPASSWORD());
		System.out.println(dto.getNAME());
		System.out.println(dto.getAGE());
		System.out.println(dto.getGENDER());
		
		result= dao.memberInsert(dto);
		
		if(result == false) {
			System.out.println("회원가입에 실패했습니다.");
			return null;
		}
		
		forward.setRedirect(true);
		forward.setPath("/Home.Lo");
		return forward;
	}

}
