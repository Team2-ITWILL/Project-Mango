package mango.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberBean;
import mango.member.db.MemberDAO;

public class MemberUpdateAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		
		MemberDAO mdao = new MemberDAO();
		MemberBean mb = new MemberBean();
		
		String memEmail = (String)request.getSession().getAttribute("memEmail");
		String memPwd = (String)request.getParameter("id_pwd"); // 기존 비밀번호
		String newPw1 = (String)request.getParameter("newPw1"); // 변경할 비밀번호
		String newPw2 = (String)request.getParameter("newPw2"); // 변경할 비밀번호 확인
		
		System.out.println(memEmail + " / " + memPwd);

		mb.setMemEmail(memEmail);
		mdao.updateMember(mb);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./MemberUpdate.me");
		
		return forward;
	} // excute() 끝
	
}