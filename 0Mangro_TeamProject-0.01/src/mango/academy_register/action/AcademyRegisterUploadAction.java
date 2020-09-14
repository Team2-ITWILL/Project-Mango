package mango.academy_register.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mango.action.Action;
import mango.action.ActionForward;

public class AcademyRegisterUploadAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");

/*		
		//업로드할 실제 서버의 경로 얻기
		String realFolder = request.getServletContext().getRealPath("/O_aca_regFiles/upload/images/");
		int max = 10 * 1024 * 1024; //업로드용량, 10MB
		
		MultipartRequest multi =
		 		new MultipartRequest(request, 
		 							 realFolder, // 파일을 저장할 디렉토리 지정
		 							 max,  // 첨부파일 최대 용량 설정(byte) / 10KB / 용량 초과 시 예외 발생
		 							 "UTF-8", // 인코딩 방식 지정
		 							 new DefaultFileRenamePolicy()); // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
		
	 	//서버에 실제로 업로드된 파일명을 저장할 컬렉션프레임워크의 ArrayList 생성
	 	ArrayList saveFiles = new ArrayList();
	 	
	 	//클라이언트가 업로드한 파일의 원본명을 하나씩 저장할 ArrayList 생성
	 	ArrayList originFiles = new ArrayList();					 
		 							 
		//파일 업로드 당시 선택했던 <input> 태그들의 name속성값들을 모두 Enumeration 반복기 객체에 담아 반환
	 	Enumeration e = multi.getFileNames();
		
		while(e.hasMoreElements()){
			//파일 업로드 당시 선택했던 <input>태그들의 name 속성의 값들을 하나씩 차례로 얻는다.
	 		String filename = (String)e.nextElement();
	 		//서버에 실제로 업로드된 파일명을 하나씩 하나씩 얻어  ArrayList에 저장
	 		saveFiles.add(multi.getFilesystemName(filename));
	 		//클라이언트가 업로드한 파일의 원본이름을 하나씩 하나씩 얻어 ArrayList에 저장
	 		originFiles.add(multi.getOriginalFileName(filename));	 	 		
	 		
	 		PrintWriter out = response.getWriter();
	 		//프로젝트경로 포함
	  		//out.print(request.getContextPath() + "/O_aca_regFiles/upload/images/" + multi.getFilesystemName(filename));
	  		//프로젝트경로 미포함
	  		out.print("/O_aca_regFiles/upload/images/" + multi.getFilesystemName(filename));
	 		
	  		System.out.print("이미지 파일 경로 : " 
  					+ request.getContextPath() + "/O_aca_regFiles/upload/images/" 
 					+ multi.getFilesystemName(filename) 
 					+ "\r\n");	 
	 					 	
		}
		
*/		
		//프론트컨트롤러가 인식하지 못하게 하기(ajax 연동 때문)
		return null;
	}

	
}
