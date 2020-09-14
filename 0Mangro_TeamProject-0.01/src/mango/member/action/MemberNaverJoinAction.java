package mango.member.action;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberBean;
import mango.member.db.MemberDAO;
public class MemberNaverJoinAction implements Action{
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		MemberBean mb = new MemberBean();
		MemberDAO mdao = new MemberDAO();
		
		mb.setMemEmail(request.getParameter("id_email"));
		mb.setMemName(request.getParameter("id_name"));
		
		int result = 0;
		
		result = mdao.insertnaverMember(mb);
		
		if(result == 1){
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter(); // getWriter() 호출하면 PrintWriter객체 얻을 수 있음
			out.print("<script>");
			out.print("alert('이미 가입한 회원입니다.');");
			out.print("location.href='./MemberLogin.me'");
			out.print("</script>");
			
//			System.out.println("회원가입 실패 !!");
			return null;
		
		}else if(result == 0){
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter(); // getWriter() 호출하면 PrintWriter객체 얻을 수 있음
			out.print("<script>");
			out.print("alert('회원가입이 완료되었습니다.');");
			out.print("location.href='./MemberLogin.me'");
			out.print("</script>");
			return null;
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./MemberLogin.me");
		
		return forward;
	} //  excute() 끝
}