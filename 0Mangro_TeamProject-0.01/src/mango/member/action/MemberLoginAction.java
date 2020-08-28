
package mango.member.action;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberBean;
import mango.member.db.MemberDAO;
public class MemberLoginAction implements Action{
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		request.setCharacterEncoding("UTF-8");
		
		String id_email = request.getParameter("id_email");
		String chk_pwd = request.getParameter("id_password1");
		
		MemberDAO mdao = new MemberDAO();
		MemberBean mb = new MemberBean();
		
		mb.setMemEmail(id_email);
		mb.setMemPwd(chk_pwd);
		
		int check = mdao.loginCheck(mb);
		
		System.out.println(check);
		
		if(check == 0){ // 비밀번호 불일치
			
			response.setContentType("text/html; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("window.alert('비밀번호가 틀립니다.');");
			out.print("history.go(-1);");
			out.print("</script>");
			
			return null;
		
		}else if(check == -1){ // 아이디 불일치
			
			response.setContentType("text/html; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("window.alert('아이디가 틀립니다.');");
			out.print("history.go(-1);");
			out.print("</script>");
			
			return null;
			
		}else if(check == -2){ // 탈퇴하거나 계정정지일 경우
			
			response.setContentType("text/html; charset=UTF-8"); 
			
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("window.alert('탈퇴하거나 정지된 계정입니다. 담당자에게 문의하세요.');");
			out.print("history.go(-1);");
			out.print("</script>");
			
			return null;
		}
		
		HttpSession session = request.getSession();
		
		session.setAttribute("id_email", id_email);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./Main.me");
		
		return forward;
	} // // excute() 끝
	
}

