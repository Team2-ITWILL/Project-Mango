package mango.member.action;

import java.io.File;
import java.io.PrintWriter;

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
	
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		String realFolder = request.getServletContext().getRealPath("/");
		
		int max = 1000 * 1024 * 1024; 
		MultipartRequest multi = new MultipartRequest(request, realFolder, max, "UTF-8", new DefaultFileRenamePolicy()); 
		
		String memName = multi.getParameter("memName"); // 이름
		String memEmail = multi.getParameter("memEmail"); // 이메일
		String memPwd = multi.getParameter("memPwd"); // 기존 비밀번호
		String newPw = multi.getParameter("newPw1"); // 변경할 비밀번호
//		String filename = multi.getFilesystemName("fileName"); // 서버에 실제로 업로드된 파일명
//		String originFilename = multi.getOriginalFileName("fileName"); // 업로드한 파일의 원본명

		System.out.println(memEmail + " / " + memPwd + " / " + newPw + " / " /* + filename + " / " + originFilename */ );
//		System.out.println(memEmail + " / " + memPwd + " / " + newPw + " / " /* + filename + " / " + originFilename */ );

 /* --------------------------------------------------------------------------------------------------------- */	

		/* 회원 정보 수정 */
		MemberBean mb = new MemberBean();
		mb.setMemName(memName);
		mb.setMemEmail(memEmail);
		mb.setMemPwd(memPwd);
		
		MemberDAO mdao = new MemberDAO();
		boolean result = mdao.updateMember(mb, newPw);
		
		if(result == true){
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.setContentType("text/html; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("window.alert('회원정보 수정이 완료되었습니다. 다시 로그인 해주세요.');");
			out.print("location.href='./MemberLogin.me';");
			out.print("</script>");
			
			return null;
		}else{
			response.setContentType("text/html; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("window.alert('오류가 발생했습니다. 담당자에게 문의해주세요.');");
			out.print("history.back(-1);");
			out.print("</script>");
			
			return null;
		}
		
	} // excute() 끝
	
}