package mango.member.action;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberDAO;

public class MemberProfileModifyAction implements Action{

	/* 회원 수정 페이지에서 프로필 사진 변경 기능 Action 페이지 */
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("-- MemberProfileModifyAction 페이지 도착!!");
		
		request.setCharacterEncoding("UTF-8");
		
		String email = (String)request.getSession().getAttribute("id_email");
		String realFolder = request.getServletContext().getRealPath("");
		int max = 1000 * 1024 * 1024; 
		MultipartRequest multi = new MultipartRequest(request, realFolder, max, "UTF-8", new DefaultFileRenamePolicy()); 
		
		
		
			} // excute 끝
	
}