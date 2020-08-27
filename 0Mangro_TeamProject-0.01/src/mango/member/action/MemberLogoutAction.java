package mango.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mango.action.Action;
import mango.action.ActionForward;

public class MemberLogoutAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('로그아웃 되었습니다.')");
		out.println("location.href='./Main.me'");
		out.println("</script>");
		out.close();

		return null;
	} // excute() 끝

}