package mango.academy.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mango.academy.db.AcademyBean;
import mango.academy.db.AcademyDAO;
import mango.academy_files.db.AcademyFilesBean;
import mango.academy_files.db.AcademyFilesDAO;
import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberDAO;

public class AcademyReviseAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");		
		
		String email = (String)request.getSession().getAttribute("id_email");

		//==============학원별 이미지 업로드================
		//업로드할 실제 서버의 경로 얻기
		String realFolder = request.getServletContext().getRealPath("/O_aca_regFiles/upload/images/");
		int max = 10 * 1024 * 1024; //업로드용량, 10MB
		
		MultipartRequest multi =
		 		new MultipartRequest(request, 
		 							 realFolder, // 파일을 저장할 디렉토리 지정
		 							 max,  // 첨부파일 최대 용량 설정(byte) / 10KB / 용량 초과 시 예외 발생
		 							 "UTF-8", // 인코딩 방식 지정
		 							 new DefaultFileRenamePolicy()); // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
				
		
	 	AcademyFilesDAO afDAO = new AcademyFilesDAO();
	 	AcademyFilesBean afVO = null;
	 	
	 	Enumeration e = multi.getFileNames();

	 	//int idx = 0;
		while(e.hasMoreElements()){		
			
	 		String filename = (String)e.nextElement();	 		 		
	 		
	  		//--프로젝트경로 미포함--	
	 		//클라이언트가 업로드한 파일의 원본이름
	 		String org_file_name = "O_aca_regFiles/upload/images/" + multi.getOriginalFileName(filename);
	 		//서버에 실제로 업로드된 파일명
	 		String stored_file_name = "O_aca_regFiles/upload/images/" + multi.getFilesystemName(filename);
	 		 		
	  		System.out.println("org_file_name : " + org_file_name); 			
	  		System.out.println("org_file_name : " + stored_file_name); 			
	  		
	  		//첫 번째 파일은 프로필 이미지이므로 memberDAO 이용
	  		//if(idx == 0){
	  		//=================학원 프로필 이미지 변경=======================
	  			
	  			System.out.println("학원 프로필 이미지: " + stored_file_name); 			
	  			MemberDAO mDAO = new MemberDAO();
	  			int result = mDAO.updateProfileImg(stored_file_name, email);
	  			if(result == 0){
	  				PrintWriter out = response.getWriter();
	  				out.println("<script>");
	  				out.println("alert('ProfileImgUpload Failed');");		
	  				out.println("history.back();");
	  				out.println("</script>");
	  				out.close();
	  			}	  			
			//}
	  		
	  		//=================학원 갤러리 이미지 등록=======================
	  		/*	
	  		afVO = new AcademyFilesBean(
  				0, 
  				Integer.parseInt(multi.getParameter("aca_main_num")),
  				org_file_name,
  				stored_file_name,
  				0, //fileSize
  				null, //regdate -> DAO에서 curdate()로 설정
  				0  // del_diff(삭제 구분)				
  				);
	  		
	  		int uploadResult = afDAO.UploadToDB(afVO);
	  		
	  		if(uploadResult == 0){
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('imgUpload Failed');");		
				out.println("</script>");
				out.close();
				//return null;
			}
	  		*/
	  			
	  		// 학원 프로필이미지 / 갤러리 이미지 파일 구분을 위한 인덱스
	  		//idx++;
	  		
		}//파일업로드 끝
	
		//==========================================================================
		
		
		//=================학원 정보 변경=========================
		AcademyBean vo = new AcademyBean();	
		
		//==========multi 객체로 파라미터값을 받아야 인식함!! request로 받으면 null 나옴=============
		vo.setAcaName(multi.getParameter("aca_name"));
		vo.setAcaStartDate(multi.getParameter("aca_start_date"));
		vo.setAcaCategory1(multi.getParameter("aca_category1"));
		vo.setAcaCategory2(multi.getParameter("aca_category2"));
		vo.setAcaAddrZip(multi.getParameter("addr_zip"));
		vo.setAcaAddrDoro(multi.getParameter("addr_doro"));	
		vo.setMem_email(email);
		
		System.out.println(vo.toString());		
		
		AcademyDAO dao = new AcademyDAO();		
		
		int result = dao.reviseAcademyInfo(vo);			
		if(result == 0){
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('failed');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('success');");
			out.println("location.href='./4index.jsp'");
			out.println("</script>");
			out.close();
			return null;
		}	
	
	}

}
