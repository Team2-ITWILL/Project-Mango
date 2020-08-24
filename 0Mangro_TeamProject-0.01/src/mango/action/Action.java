package mango.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action  {
	
	// Action관련 클래스들이 Action인터페이스 내부의 추상메소드를 오버라이딩해서 사용하기 위해 선언
	
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)  throws Exception;
}
