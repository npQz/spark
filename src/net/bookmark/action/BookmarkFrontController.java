package net.bookmark.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("*.me")
public class BookmarkFrontController extends HttpServlet {
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

		if (command.equals("/BookmarkList.me")) {
			action = new BookmarkListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/BookmarkAdd.me")) {
			action = new BookmarkAddAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/BookmarkDelete.me")) {
			action = new BookmarkDeleteAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		} else {
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
