package mango.academy_register.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.audit_request.action.AuditRequestAction;

public class AcademyRegisterFrontController extends HttpServlet{

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException{
		
		
		//가상요청 주소 가져오기
		//예)MangoProject/MemberLogin.me 
		String RequestURI=request.getRequestURI();
		
		System.out.println(RequestURI);
		
		//MangoProject 얻기
		String contextPath=request.getContextPath();
		System.out.println(contextPath);
		
		
		System.out.println(contextPath.length());//path에 길이 얻기
	
		//MemberLogin.me 얻기
		String command=RequestURI.substring(contextPath.length());
		System.out.println(command);
		
		//주소비교
		//페이지 이동 방식 여부 값,이동페이지 경로 값 저장 하여 리턴 해주는 객체를 저장할 참조변수 선언 
		ActionForward forward=null;
		
		//자식 Action 객체들을 담을 인터페이스 타입의 참조변수 선언
		Action action=null;
	
		
		if(command.equals("/registerUpload.areg")) {			
			
			try {
				action = new AcademyRegisterUploadAction();				
				forward = action.excute(request, response);			
		
			} catch (Exception e) {				
				e.printStackTrace();
			}	
		}else if(command.equals("/register.areg")) {			
			
			try {
				action = new AcademyRegisterAction();				
				forward = action.excute(request, response);			
		
			} catch (Exception e) {				
				e.printStackTrace();
			}	
		}else if(command.equals("/registerSearch.areg")) {			
			
			try {
				action = new Academy_Register_SearchAca_Action();				
				forward = action.excute(request, response);			
		
			} catch (Exception e) {				
				e.printStackTrace();
			}	
		}else if(command.equals("/registerGetList.areg")) {			
			
			try {
				action = new AcademyRegisterGetListAction();		
				forward = action.excute(request, response);			
		
			} catch (Exception e) {				
				e.printStackTrace();
			}	
		}else if(command.equals("/regChangeApproval.areg")) {			
			
			try {
				action = new AcademyRegisterApproveAction();
				forward = action.excute(request, response);			
		
			} catch (Exception e) {				
				e.printStackTrace();
			}	
		}							
		
		
		
		if(forward!=null){ //new ActionForward()객체가 존재 하고..
			
			if(forward.isRedirect()){//true -> sendRedirect() 방식일떄..
				
				//리다이렉트 방식으로 페이지 이동!  페이지 주소 경로 노출 함 
				
				//join.jsp화면 이동
				
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
