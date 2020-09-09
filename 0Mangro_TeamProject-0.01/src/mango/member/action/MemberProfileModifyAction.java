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
		String realFolder = request.getServletContext().getRealPath("/O_member_regFiles/upload/images/");
		int max = 1000 * 1024 * 1024; 
		MultipartRequest multi = new MultipartRequest(request, realFolder, max, "UTF-8", new DefaultFileRenamePolicy()); 
		
		
		
		/* 학원 프로필 이미지 변경 */
		Enumeration e = multi.getFileNames();

		while(e.hasMoreElements()){		
			
	 		String filename = (String)e.nextElement();	 		 		
	 		String org_file_name = "O_member_regFiles/upload/images/" + multi.getOriginalFileName(filename);
	 		String stored_file_name = "O_member_regFiles/upload/images/" + multi.getFilesystemName(filename);
	 		 		
	  		System.out.println("org_file_name : " + org_file_name); 			
	  		System.out.println("org_file_name : " + stored_file_name); 			
	  		
	  			MemberDAO mDAO = new MemberDAO();
	  			int result = mDAO.updateProfileImg(stored_file_name, email);
	  			if(result == 0){
	  				PrintWriter out = response.getWriter();
	  				out.println("<script>");
	  				out.println("alert('이미지 변경 중 오류가 발생하였습니다. 담당자에게 문의하세요.');");		
	  				out.println("location.href='./MemberUpdate.me'");
	  				out.println("</script>");
	  				out.close();
	  			}	  			
	  		
		} // 파일업로드 끝
		
		
		
		/* 프로필 이미지 가져오기 */
		MemberDAO mdao = new MemberDAO();
		String profileImg = mdao.getProfileImg(email);
		request.setAttribute("profileImg", profileImg);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./MemberUpdate.me");
		
		return forward;
	} // excute 끝
	
}