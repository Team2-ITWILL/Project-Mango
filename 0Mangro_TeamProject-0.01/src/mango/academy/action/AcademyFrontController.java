package mango.academy.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;


public class AcademyFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException{
		
		
		//가상요청 주소 가져오기
		//예)MangoProject/MemberLogin.me 
		String RequestURI=request.getRequestURI();
		
		
		//MangoProject 얻기
		String contextPath=request.getContextPath();
		
		
	
		//MemberLogin.me 얻기
		String command=RequestURI.substring(contextPath.length());
		System.out.println(command);
		
		//주소비교
		//페이지 이동 방식 여부 값,이동페이지 경로 값 저장 하여 리턴 해주는 객체를 저장할 참조변수 선언 
		ActionForward  forward=null;
		
		//자식 Action 객체들을 담을 인터페이스 타입의 참조변수 선언
		Action action=null;
	
		
		if(command.equals("/AcademyContentAction.aca")){
			action = new AcademyContentAction();
			
			try {
				forward= action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/getListSearchOne.aca")){
			
			
			action =new ListSearchOneAciton();
			
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				
				System.out.println("/getListSearchOne.aca에서 예외 발생"+e);
			}
			
			
			
			
		}
		else if(command.equals("/getListSearchTwo.aca")){
			
			
				action =new ListSearchTwoAciton();
			
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				
				System.out.println("/getListSearchTwo.aca에서 예외 발생"+e);
			}
			
			
			
		}else if(command.equals("/getListSearchThr.aca")){
			
			
			action =new ListSearchThrAciton();
			
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				
				System.out.println("/getListSearchThr.aca에서 예외 발생"+e);
			}
			
		}else if(command.equals("/AcademyList.aca")){
			
			
			action =new AcademyListAction();
			
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				
				System.out.println("/AcademyList.aca에서 예외 발생"+e);
				e.printStackTrace();
			}
			
		}else if(command.equals("/AcademySearchList.aca")){
			
			
			action =new AcademySearchListAction();
			
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
				System.out.println("/AcademySearchList.aca에서 예외 발생");
			}
			
		}else if(command.equals("/AcademyGetAdminInfo.aca")){			
			action =new AcademyAdminInfoAction();		
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {				
				e.printStackTrace();
				System.out.println("/AcademyGetAdminInfo.aca에서 예외 발생");
			}			
		}else if(command.equals("/AcademyImgUpload.aca")){			
			action =new AcademyImgUploadAction();	
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {				
				e.printStackTrace();
				System.out.println("/AcademyImgUpload.aca에서 예외 발생");
			}			
		}else if(command.equals("/AcademyReviseAction.aca")){			
			action =new AcademyReviseAction();	
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {				
				e.printStackTrace();
				System.out.println("/AcademyReviseAction.aca에서 예외 발생");
			}			
		}
		
		
		
		
		
		
		
		
		
		if(forward!=null){ //new ActionForward()객체가 존재 하고..
			
			if(forward.isRedirect()){//true -> sendRedirect() 방식일떄..
				
				//리다이렉트 방식으로 페이지 이동!  페이지 주소 경로 노출 함 
				
				
				response.sendRedirect(forward.getPath());
				
			}else{//false -> forward() 방식일때...
				
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		
		}//if 
		
	
	
	
	}//doProcess
	
	
	
	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	
}
