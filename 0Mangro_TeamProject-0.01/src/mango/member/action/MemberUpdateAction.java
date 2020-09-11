package mango.member.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mango.action.Action;
import mango.action.ActionForward;

import mango.member.db.MemberBean;
import mango.member.db.MemberDAO;

public class MemberUpdateAction implements Action{
	
	/* 회원 정보를 수정하는 Action 페이지 */
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		String email = (String)request.getSession().getAttribute("id_email"); // 이메일
		String realFolder = request.getServletContext().getRealPath("/O_member_regFiles/upload/images/");
		
		int max = 10 * 1024 * 1024; 
		
		MultipartRequest multi = new MultipartRequest(request, realFolder, max, "UTF-8", new DefaultFileRenamePolicy()); 
		String memName = multi.getParameter("memName"); // 이름
		String memPwd = multi.getParameter("memPwd"); // 기존 비밀번호
		String newPw = multi.getParameter("newPw1"); // 변경할 비밀번호
		
		MemberDAO mdao = new MemberDAO();
		MemberBean mb = new MemberBean();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		
		
/* -------------------------------------------------- 프로필 이미지 가져오기 --------------------------------------------------  */
		String profileImg = mdao.getProfileImg(email);
		request.setAttribute("profileImg", profileImg);

		
		
/* -------------------------------------------------- 회원 정보 수정 메서드 --------------------------------------------------  */
		
		mb.setMemName(memName);
		mb.setMemEmail(email);
		mb.setMemPwd(memPwd);
		
		System.out.println("@@@ memPwd.equals(null) : " + memPwd.equals(null));
		
		// 비밀번호를 변경할 때
		boolean result = mdao.updateMember(mb, newPw);
		
		if(result == true){
			HttpSession session = request.getSession();
			session.invalidate();
			
			out.print("<script>");
			out.print("window.alert('회원정보 수정이 완료되었습니다. 다시 로그인 해주세요.');");
			out.print("location.href='./MemberLogin.me';");
			out.print("</script>");
			out.close();
			
			return null;
			
		}else if(result == false){
			out.print("<script>");
			out.print("window.alert('비밀번호가 틀립니다.');");
			out.print("location.href='./MemberUpdate.me';");
			out.print("</script>");
			out.close();
			
			return null;
		}
			

		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./MemberUpdate.me");
		return forward;
	} // excute() 끝
	
}