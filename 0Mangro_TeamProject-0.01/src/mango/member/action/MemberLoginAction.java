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
		
		MemberBean mb = new MemberBean();
		String id_email = request.getParameter("id_email");

		System.out.println(request.getParameter("id_password1"));
		
		mb.setMemEmail(id_email);
		mb.setMemPwd(request.getParameter("id_password1"));
		
		MemberDAO mdao = new MemberDAO();
		
		int check = mdao.loginCheck(mb);
		
		if(check == 1){ // 
			
			HttpSession session = request.getSession();
			
			session.setAttribute("id_email", id_email);
			
			response.sendRedirect("./Main.me");
			
		}else if(check == -1){ // 아이디 불일치
			
			response.setContentType("text/html; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("window.alert('아이디가 존재하지 않습니다.');");
			out.print("history.go(-1);");
			out.print("</script>");
			
//			return null;
			
		}else if(check == 0){ // 비밀번호 불일치
			
			response.setContentType("text/html; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("window.alert('비밀번호가 틀립니다.');");
			out.print("history.go(-1);");
			out.print("</script>");
			
//			return null;
		}
		
//		ActionForward forward = new ActionForward();
		
//		forward.setRedirect(true);
//		forward.setPath("./4index.jsp");
		
		return null;
	} // // excute() 끝
	
}
