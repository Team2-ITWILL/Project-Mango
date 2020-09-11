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
		
		
/* ------------------------- 학원 프로필 이미지 변경 -------------------------  */
	
		Enumeration e = multi.getFileNames();

		while(e.hasMoreElements()){		

			String filename = (String)e.nextElement();	 		 		
			String org_file_name = "O_member_regFiles/upload/images/" + multi.getOriginalFileName(filename);
			String stored_file_name = "O_member_regFiles/upload/images/" + multi.getFilesystemName(filename);
			
			if(org_file_name.equals("O_member_regFiles/upload/images/null") || 
			   stored_file_name.equals("O_member_regFiles/upload/images/null")){
				
				MemberDAO mdao = new MemberDAO();
				String f_name = mdao.getProfileImg(email);
				System.out.println("@@@ f_name : " + f_name);
				org_file_name = f_name;
				stored_file_name = f_name;
			}
	 		 		
	  		System.out.println("org_file_name : " + org_file_name); 			
	  		System.out.println("org_file_name : " + stored_file_name); 			
	  		
	  			MemberDAO mDAO = new MemberDAO();
	  			int result = mDAO.updateProfileImg(stored_file_name, email);
	  			if(result == 0){
	  				response.setContentType("text/html; charset=utf-8");
	  				PrintWriter out = response.getWriter();
	  				out.println("<script>");
	  				out.println("alert('이미지 변경 중 오류가 발생하였습니다. 담당자에게 문의하세요.');");		
	  				out.println("history.back(-1)';");
	  				out.println("</script>");
	  				out.close();
	  				
	  				return null;
	  				
	  			}else if(result == 1){
	  				response.setContentType("text/html; charset=utf-8");
	  				PrintWriter out = response.getWriter();
	  				out.println("<script>");
	  				out.println("alert('이미지 변경이 완료되었습니다.');");	
	  				out.println("location.href='./MemberUpdate.me'");
	  				out.println("</script>");
	  				out.close();
	  				
	  				return null;
	  			}
	  		
		} // while() 끝
		
		
		
		
/* ------------------------- 프로필 이미지 가져오기 -------------------------  */
		
		MemberDAO mdao = new MemberDAO();
		String profileImg = mdao.getProfileImg(email);
		request.setAttribute("profileImg", profileImg);

		
		
		
/* ------------------------- 회원 정보 수정 메서드 -------------------------  */
		
		MemberBean mb = new MemberBean();
		mb.setMemName(memName);
		mb.setMemEmail(email);
		mb.setMemPwd(memPwd);
		
		ActionForward forward = new ActionForward();

		// 비밀번호를 변경하지 않고 프로필 사진만 변경할 때
		if(mb.getMemPwd().equals(null) == false){
			forward.setRedirect(false);
			forward.setPath("./MemberUpdate.me");
		
		// 비밀번호를 변경할 때
		}else if(mb.getMemPwd().equals(null) == true){
			
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
				out.close();
				
				return null;
				
			}else if(result == false){
				response.setContentType("text/html; charset=utf-8");
				
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("window.alert('오류가 발생하였습니다. 담당자에게 문의하세요');");
				out.print("history.back(-1)';");
				out.print("</script>");
				out.close();
				
				return null;
			}

		}
		
		return forward;
	} // excute() 끝
	
}