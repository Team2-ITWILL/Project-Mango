package mango.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberBean;
import mango.member.db.MemberDAO;

public class MemberFindPwMailAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		
		/* 메일 전송하기 */
		
		// 보내는 사람(망고)
	    String smtpServer = "smtp.naver.com";
	    final String sendId = "gyrud13"; // 아이디
	    final String sendPass = "busy1260@"; // 비밀번호
	    String sendEmailAddress = "gyrud13@naver.com"; // 보내는 사람
	    int smtpPort = 465; // SMTP 포트번호
		
	    // 받는 사람 (가입할 사람의 주소)
	    System.out.println(request.getParameter("id_email"));
	    String recieveEamilAddress = request.getParameter("id_email");
		
// ----------------------------------------------------------------
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./MemberLogin.me");
		
		return forward;
	}
	
}