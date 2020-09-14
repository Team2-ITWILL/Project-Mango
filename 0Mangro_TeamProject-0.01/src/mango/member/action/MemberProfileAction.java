package mango.member.action;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberBean;
import mango.member.db.MemberDAO;

public class MemberProfileAction implements Action{

	/* 회원 정보 프로필 변경 Action 페이지 */
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		request.setCharacterEncoding("UTF-8");
		
		String email = (String)request.getSession().getAttribute("id_email"); // 이메일
		String realFolder = request.getServletContext().getRealPath("/O_member_regFiles/upload/images/");
		
		int max = 10 * 1024 * 1024; 
		
		MultipartRequest multi = new MultipartRequest(request, realFolder, max, "UTF-8", new DefaultFileRenamePolicy()); 

		MemberDAO mdao = new MemberDAO();
		MemberBean mb = new MemberBean();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		
		
/* -------------------------------------------------- 프로필 이미지 가져오기 --------------------------------------------------  */
		String profileImg = mdao.getProfileImg(email);
		request.setAttribute("profileImg", profileImg);

		
		
/* -------------------------------------------------- 학원 프로필 이미지 변경 --------------------------------------------------  */
		
		Enumeration e = multi.getFileNames();

		while(e.hasMoreElements()){		

			String filename = (String)e.nextElement();	 		 		
			String org_file_name = "O_member_regFiles/upload/images/" + multi.getOriginalFileName(filename);
			String stored_file_name = "O_member_regFiles/upload/images/" + multi.getFilesystemName(filename);
			
			if(org_file_name.equals("O_member_regFiles/upload/images/null") || 
			   stored_file_name.equals("O_member_regFiles/upload/images/null")){
				
				String f_name = mdao.getProfileImg(email);
				org_file_name = f_name;
				stored_file_name = f_name;
			}
	 		 		
	  		System.out.println("org_file_name : " + org_file_name); 			
	  		System.out.println("org_file_name : " + stored_file_name);
	  		
	  			int result = mdao.updateProfileImg(stored_file_name, email);
	  			if(result == 0){
	  				out.println("<script>");
	  				out.println("alert('이미지 변경 중 오류가 발생하였습니다. 담당자에게 문의하세요.');");		
	  				out.println("history.back(-1)';");
	  				out.println("</script>");
	  				out.close();
	  				
	  				return null;
	  				
	  			}else if(result == 1){
	  				out.println("<script>");
	  				out.println("alert('프로필이 변경되었습니다.');");		
	  				out.println("location.href='./MemberUpdate.me';");
	  				out.println("</script>");
	  				out.close();
	  				
	  				return null;

	  			} // 바깥쪽 if문 끝
	  				 
		} // while() 끝
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./MemberUpdate.me");
		return forward;
	} // excute() 끝
}