package mango.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberDAO;

public class MemberIDcheckAction implements Action{
	
	/* 아이디 중복 체크 기능 Action 페이지 */
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		
		System.out.println("@@@ email : " + email);
		
		MemberDAO mdao = new MemberDAO();
		
		int check = mdao.idCheck(email);

		PrintWriter out = response.getWriter();
		out.print(check);
		
//		ActionForward forward = new ActionForward();
//		forward.setRedirect(false);
//		forward.setPath("./MemberJoin.me");
		return null;
	} // excute() 끝
}