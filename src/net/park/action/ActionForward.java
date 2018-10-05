package net.park.action;


public class ActionForward {//경로 값이랑 재요청 하는지 중복되는 것을 제거 하기위해서
	private boolean isRedirect;
	private String path;
	
	public ActionForward() {
		isRedirect = false;
		path = null;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
