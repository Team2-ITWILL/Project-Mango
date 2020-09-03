package mango.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberDAO;

public class MemberFindPwAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		
		/* 비밀번호 조회하기 */
		MemberDAO mdao = new MemberDAO();
		String email = (String)request.getParameter("id_email");
		String pw = mdao.findPw(email);
		
		System.out.println(pw);
		
		if(pw != null){
			
			response.setContentType("text/html; charset=UTF-8"); 
			
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호를 전송했습니다.')");
			out.println("location.href='/MemberFindPwMailAction.me'");
			out.println("</script>");
			
			return null;
			
		}else{
			
			response.setContentType("text/html; charset=UTF-8"); 
			
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('가입한 이메일이 없습니다.')");
			out.println("location.href='./MemberFindPw.me'");
			out.println("</script>");
			
		}
		
//		ActionForward forward = new ActionForward();
//		forward.setRedirect(false);
//		forward.setPath("./MemberFindPw.me");
		
		return null;
	}
	
}