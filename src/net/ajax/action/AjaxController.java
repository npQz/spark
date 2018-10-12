package net.ajax.action;

import net.ajax.db.AjaxDAO;
import net.bookmark.db.BookmarkDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.aj")
public class AjaxController extends HttpServlet {
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
    
    /* idChk */
    if (command.equals("/IdChk.aj")) {
      
      String email = request.getParameter("email");
      
      PrintWriter out = response.getWriter();
      
      AjaxDAO dao = new AjaxDAO();
      
      int cnt = dao.IdChk(email);
      
      if (cnt > 0) {
        out.print("fail");
      } else {
        out.print("success");
      }
      
    }
    
    /* modify PW */
    else if (command.equals("/ModifyPW.aj")) {
      
      PrintWriter out = response.getWriter();
      
      String email = request.getParameter("email_data");
      String old_pw = request.getParameter("old_pw_data");
      String new_pw = request.getParameter("new_pw_data");
      
      AjaxDAO dao = new AjaxDAO();

      /*System.out.println(email);
      System.out.println(old_pw);
      System.out.println(new_pw);*/
      
      Boolean result = null;
      
      result = dao.modifyPW_chk(email, old_pw);
      
      if (result) {
        System.out.println("modify start");
        dao.modifyPW(email, new_pw);
        out.print("success");
      } else {
        System.out.println("modify fail");
        out.print("fail");
      }
      
    } /* modify PW */
    else if (command.equals("/DeleteAcc.aj")) {
  
      HttpSession session = request.getSession();
      PrintWriter out = response.getWriter();
  
      String email = request.getParameter("email");
      String pw = request.getParameter("pw");
  
      System.out.println(email);
      System.out.println(pw);
  
      AjaxDAO dao = new AjaxDAO();
  
      Boolean result = null;
  
      result = dao.modifyPW_chk(email, pw);
  
      if (result) {
        dao.deleteAcc(email);
        session.invalidate();
        out.print("success");
      } else {
        System.out.println("modify fail");
        out.print("fail");
      }
  
    } /* bmk List  */
    else if (command.equals("/bmkList.aj")) {

      HttpSession session = request.getSession();
      PrintWriter out = response.getWriter();
      List<BookmarkDTO> bmkList = null;

      String email = request.getParameter("email");

      AjaxDAO dao = new AjaxDAO();

      Boolean result = null;

      bmkList = dao.getBmkList(email);

      if(bmkList != null) {
        out.print("success");
      } else {
        out.print("fail");
      }

    } /* bmk List  */
    else if (command.equals("/DeleteBmk.aj")) {

      HttpSession session = request.getSession();
      PrintWriter out = response.getWriter();

      String email = request.getParameter("email");
      String bmkName = request.getParameter("bmkName");

      AjaxDAO dao = new AjaxDAO();

      Boolean result = null;

      result = dao.bmkDelete(email, bmkName);

      if(result != null) {
        out.print("success");
      } else {
        out.print("fail");
      }

    } else {
      System.out.println("data flow fail");
      
    }

  }
}
