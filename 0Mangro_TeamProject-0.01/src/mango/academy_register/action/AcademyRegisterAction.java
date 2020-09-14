package mango.academy_register.action;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mango.academy_register.db.AcademyRegisterBean;
import mango.academy_register.db.AcademyRegisterDAO;
import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberDAO;

public class AcademyRegisterAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String email = (String)request.getSession().getAttribute("id_email");
		
		//---------------로그인이 되어있는지 확인-------------------------//
		if(email == null || email.equals("")){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.');");
			out.println("location.href='./MemberLogin.me';");
			out.println("</script>");
			out.close();
			return null;
		}
		
		//--------------DB에 학원관리자정보가 등록되어있는지 확인---------------------//
		AcademyRegisterDAO dao = new AcademyRegisterDAO();		
		int exists = dao.CheckDataExists(email);
		//DB에 데이터가 존재할 경우 등록 진행 불가
		if(exists == 1){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			
			out.println("<script>");
			out.println("alert('이미 등록된 정보가 있습니다. 승인을 기다려주세요.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}	
		
//==============================DB에 등록된 데이터가 없을경우 등록 진행=================================
		
		//==============MultipartRequest 객체로 form태그 데이터 받아오기===============================
		//업로드할 실제 서버의 경로 얻기
		String realFolder = request.getServletContext().getRealPath("/O_aca_regFiles/upload/images/");
		int max = 10 * 1024 * 1024; //업로드용량, 10MB
		
		MultipartRequest multi =
		 		new MultipartRequest(request, 
		 							 realFolder, // 파일을 저장할 디렉토리 지정
		 							 max,  // 첨부파일 최대 용량 설정(byte) / 10KB / 용량 초과 시 예외 발생
		 							 "UTF-8", // 인코딩 방식 지정
		 							 new DefaultFileRenamePolicy()); // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)

		//=============파일태그의 데이터로부터 DB에 업로드할 이미지 파일명, 크기 받아오기(사업자 등록증,대표자 신분증/재직증명서)===============================================		
		
		// academy_register.jsp에서 파일선택 또는 드래그 시 파일태그에 데이터가 입력되고
		// fNameCompany, fNameOwner라는 이름의 input태그에 파일명이 입력되게 해놨음
		
		// 파일태그에서 추출한 파일명
		String fNameCompany = multi.getParameter("fNameCompany");	
		String fNameOwner = multi.getParameter("fNameOwner");	
		
		// 실제로 DB에 들어갈 파일경로
		String[] realPath_Arr = new String[2];
		
		// 사업자등록증, 신분증 파일 순서가 뒤바뀌어 전송될 경우 구분하기 위한 값
		String[] fileNameDiff = new String[2];
		
		Enumeration e = multi.getFileNames();
		int idx = 0;
		while(e.hasMoreElements()){				
			 		
			// MultipartRequest가 파일태그명(fileName)을 통해 form에서 전송된 file태그에 접근함
			// 파일태그명
	 		String fileName = (String)e.nextElement();	 	 		
	 		
	 		// 파일명 구분
	 		fileNameDiff[idx] = fileName;
	 		
	 		//클라이언트가 업로드한 파일의 원본이름
	 		String originalFileName = multi.getOriginalFileName(fileName);	 	
	 		//서버에 업로드할 파일명
	 		String fileSystemName = multi.getFilesystemName(fileName);	 	
	 		//이미지 파일 폴더 경로
	 		String folderPath = "O_aca_regFiles/upload/images/";	
	 		
	 		//	업로드할 파일명 + 이미지폴더 경로를 합해서 DB에 삽입
	 		realPath_Arr[idx] = folderPath + fileSystemName;
	 		
	 		System.out.println("originalFileName : " + originalFileName); 
	 		System.out.println("realPath_Arr : " + realPath_Arr[idx]); 		 		
	 		
	 		//배열 인덱스 증가
			idx++;
		
		}			
		
		//파일태그명(file1, file2)의 끝자리 문자인 숫자(1,2)를 추출해서 int에 저장
		int[] fileIdx = new int[2];
		for(int i=0; i<2; i++){
			int length = fileNameDiff[i].length();
			fileIdx[i] = Integer.parseInt(fileNameDiff[i].substring(length-1, length));
			System.out.println("fileIdx : " + fileIdx[i]);
			System.out.println("last char : " + fileNameDiff[i].charAt(length-1));
		}
		
		// 파일태그가 역순으로 업로드 되었을 경우 swap
		// multipartRequest 객체의 특성인지 모르겠는데 
		// form태그 내부 마지막 순서에 위치하는 파일태그부터 먼저 가져오는 것 같음
		if(fileIdx[0] > fileIdx[1]){
			String temp = realPath_Arr[0];
			realPath_Arr[0] = realPath_Arr[1];
			realPath_Arr[1] = temp;
		}

		
		//=============academy_register 테이블에 등록==========================
		String addr_zip = multi.getParameter("addr_zip");
		String addr_doro = multi.getParameter("addr_doro");
		String acaName = multi.getParameter("acaName");		
		String keyword = multi.getParameter("keyword");		
		
		// 파일 크기 -> academy_register.jsp의 uploadFile()함수에서 해당 태그에 맞게 
		// 파일의 사이즈를 직접 입력해주므로 multipartRequest 객체로 인한 순서 역전 없음
		String f_size_company = multi.getParameter("f_size_company");			
		String f_size_owner = multi.getParameter("f_size_owner");	
			
		
		AcademyRegisterBean bean = new AcademyRegisterBean();
		bean.setMemEmail(email);
		bean.setMemAddrZip(addr_zip);
		bean.setMemAddrDoro(addr_doro);
		bean.setAcaName(acaName);		
		bean.setAca_keyword(keyword);
		
		bean.setfNameCompany(realPath_Arr[0]);
		bean.setfNameOwner(realPath_Arr[1]);		
		
		bean.setfSizeCompany(f_size_company);
		bean.setfSizeOwner(f_size_owner);		
		
		int result = dao.RegisterToDB(bean);		
		if(result == 0){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록이 실패하였습니다. 다시 작성해주세요.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('학원 정보가 등록되었습니다. 승인을 기다려 주세요.');");
			out.println("location.href='./Main.me'");
			out.println("</script>");
			out.close();
			return null;
		}	
		

	}//execute()

	
}//AcademyRegisterAction
