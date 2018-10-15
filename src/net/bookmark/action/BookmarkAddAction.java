package net.bookmark.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bookmark.db.BookmarkDAO;
import net.bookmark.db.BookmarkDTO;
import net.park.db.BoardDAO;
import net.park.db.BoardDTO;

public class BookmarkAddAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionForward forward = null;
    List<BookmarkDTO> limit = null;
    request.setCharacterEncoding("utf-8");
    HttpSession session = request.getSession();

    BoardDAO bodao = new BoardDAO();
    BoardDTO bodto = new BoardDTO();

    BookmarkDAO bmkdao = new BookmarkDAO();
    BookmarkDTO bmkdto = new BookmarkDTO();

    String email = (String) session.getAttribute("email");
    String code = request.getParameter("PARKING_CODE");
    String name = request.getParameter("PARKING_NAME");

    System.out.println(email);
    System.out.println(code);
    System.out.println(name);

    int result1 = bmkdao.getlistchk(email, name); // 중복체크

    if (result1 == 0) {
      response.setContentType("text/html; charset=utf-8");
      PrintWriter out = response.getWriter();
      out.println("<script>");
      out.println("alert('이미 즐겨찾기에 주차한 주차장입니다.')");
      out.println("javascript:history.go(-1)");
      out.println("</script>");
      out.close();

      return null;
    }

    boolean result2;

    result2 = bmkdao.getaddlimit(email);

    if (result2) {
      response.setContentType("text/html; charset=utf-8");
      PrintWriter out = response.getWriter();
      out.println("<script>");
      out.println("alert('즐겨찾기 개수가 초과되었습니다. (5개까지 가능)')");
      out.println("javascript:history.go(-1)");
      out.println("</script>");
      out.close();

      return null;

    }

    bodto = bodao.getInfo(code);

    boolean result3;

    result3 = bmkdao.bmkAdd(email, bodto.getParking_name(), bodto.getAddr(), bodto.getTel());

    if(!result3) {
      System.out.println("즐겨찾기 실패");
    }

    response.setContentType("text/html; charset=utf-8");
    PrintWriter out = response.getWriter();

    /*out.println("<script>");
    out.println("alert('즐겨찾기에 추가되었습니다.')");
    out.println("location.href='/BoardSearch.bo?PARKING_NAME='" + name + "");
    out.println("</script>");
    out.close();*/

    forward = new ActionForward();
    forward.setRedirect(false);
    forward.setPath("/BoardSearch.bo?PARKING_NAME=" + name);

    return forward;

  }

}
