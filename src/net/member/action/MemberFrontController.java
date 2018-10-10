package net.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.action.Action;
import net.member.action.ActionForward;
import net.member.db.MemberDAO;

@WebServlet("*.Lo")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		System.out.println(uri);
		String context = request.getContextPath();
		System.out.println(context);
		String command = uri.substring(context.length());
		System.out.println(command);

		Action action = null;
		ActionForward forward = null;

		if (command.equals("/Home.Lo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("views/home.jsp");

		} else if (command.equals("/Signin.Lo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/views/signIn.jsp");

		} else if (command.equals("/Signup.Lo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/views/signUp.jsp");
			
		} else if (command.equals("/SignModify.Lo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/views/signUp.jsp");
		
		} else if (command.equals("/MemberView.Lo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/views/account.jsp");
		
			
		}else if(command.equals("/MemberViewAction.Lo")){
		   action = new MemberViewAction();
		   try{
			   forward=action.execute(request, response);
		   }catch(Exception e){
			   e.printStackTrace();
		   }

		} else if (command.equals("/MemberLoginAction.Lo")) {

			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/MemberLogoutAction.Lo")) {

			action = new MemberLogoutAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/MemberJoinAction.Lo")) {

			action = new MemberJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (command.equals("/MemberModifyAction.Lo")) {

			action = new MemberModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	

		} else if (command.equals("/MemberDeleteAction.Lo")) {

			action = new MemberDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} /* ajax test */
		else if (command.equals("/IdChk.Lo")) {
			
			String email = request.getParameter("email");
			
			PrintWriter out = response.getWriter();
			
			MemberDAO dao = new MemberDAO();
			
			int cnt = dao.IdChk(email);
			
			if (cnt > 0) {
				out.print("fail");
			} else {
				out.print("success");
			}
			
		}else {
			System.out.println("data flow fail");

		}
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());

				dispatcher.forward(request, response);
			}
		}
	}
}
