package net.park.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface Action {//엑션을 부모객체로하여 무조건 상속해야 되겠끔 만든다
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception ;
	//인터페이스는 중괄호 없앤다	
	
}
