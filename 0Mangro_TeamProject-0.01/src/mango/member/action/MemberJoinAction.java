package mango.member.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberBean;
import mango.member.db.MemberDAO;

public class MemberJoinAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		MemberBean mb = new MemberBean();
		
		mb.setMemEmail(request.getParameter("id_email"));
		mb.setMemName(request.getParameter("id_name"));
		mb.setMemPwd(request.getParameter("id_password1"));
		mb.setMemJoindate(new Timestamp(System.currentTimeMillis()));

		boolean result = false;

		MemberDAO mdao = new MemberDAO();

		System.out.println(mb);
		
		result = mdao.insertMember(mb);
		
		if(result == false){
			System.out.println("회원가입 실패 !!");
			return null;
		}
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("./4index.jsp");
		
		return forward;
	} //  excute() 끝

}