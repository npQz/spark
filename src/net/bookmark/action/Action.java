package net.bookmark.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bookmark.action.ActionForward;

public interface Action  {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
