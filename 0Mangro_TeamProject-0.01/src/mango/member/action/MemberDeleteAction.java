
package mango.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberBean;
import mango.member.db.MemberDAO;

public class MemberDeleteAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");

		MemberDAO mdao = new MemberDAO();
		MemberBean mb = new MemberBean();

		String id_email = (String)request.getSession().getAttribute("id_email");
		String chk_pwd = (String)request.getParameter("mem_pwd");

		mb.setMemEmail(id_email);
		mb.setMemPwd(chk_pwd);
		
		int check = mdao.deleteMember(mb);
		 
		if(check != 0){
			
			HttpSession session = request.getSession();
			session.invalidate();
		
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('탈퇴가 완료되었습니다.');");
			out.println("location.href='/Main.me';");
			out.println("</script>");
			
		}else{
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('오류가 발생하였습니다. \n 담당자에게 문의하세요.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return null;
	} // excute() 끝


}