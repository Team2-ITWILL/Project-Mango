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
		 
		if(check == 1){
			HttpSession session = request.getSession();
			session.invalidate();
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('탈퇴가 완료되었습니다.');");
			out.print("location.href='./Main.me';");
			out.print("</script>");
			out.close();
			
			return null;
			
		}else if(check == 0){
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('비밀번호가 틀립니다.');");
			out.print("location.href='./MemberDelete.me';");
			out.print("</script>");
			out.close();
			
			return null;
		}
		
		return null;
	} // excute() 끝
}