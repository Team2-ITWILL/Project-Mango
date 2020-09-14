package mango.audit_request.action;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;

public class AuditRequestFrontController extends HttpServlet {


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
	
		
		if(command.equals("/request.adrq")) {			
			
			try {
				action = new AuditRequestAction();
				
				//academy_audit.jsp에서 넘어온 request값들을 AuditRequestAction 객체에 넘겨준다
				forward = action.excute(request, response);			
		
			} catch (Exception e) {				
				e.printStackTrace();
			}		
		}else if(command.equals("/ListAction.adrq")){
			try {
				action = new AuditRequestListAction();				
				
				forward = action.excute(request, response);			
		
			} catch (Exception e) {				
				e.printStackTrace();
			}		
		}else if(command.equals("/AuditApproval.adrq")){
			try {
				action = new AuditRequestApproval();				
				
				forward = action.excute(request, response);			
		
			} catch (Exception e) {				
				e.printStackTrace();
			}		
		}else if(command.equals("/AuditGetSubj.adrq")){
			try {
				action = new AuditRequestGetAvailSubjectAction();				
				
				forward = action.excute(request, response);			
		
			} catch (Exception e) {				
				e.printStackTrace();
			}		
		}else if(command.equals("/AuditInfoToCalendar.adrq")){
			try {
				action = new AuditRequestToCalendarAction();				
				
				forward = action.excute(request, response);			
		
			} catch (Exception e) {				
				e.printStackTrace();
			}		
		}else if(command.equals("/AuditInfoToMypage.adrq")){
			try {
				action = new AuditRequestToMypageMain();			
				
				forward = action.excute(request, response);			
		
			} catch (Exception e) {				
				e.printStackTrace();
			}		
		}else if(command.equals("/AuditListToMypage.adrq")){
			try {
				action = new AuditRequestListToMyPageAction();			
				
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
