package mango.academy_review.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;

// *.arev
public class AcademyReviewFrontController extends HttpServlet{

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException{
		
		
		//가상요청 주소 가져오기
		//예)MangoProject/MemberLogin.me 
		String RequestURI=request.getRequestURI();
		
		
		//MangoProject 얻기
		String contextPath=request.getContextPath();
		
		
		System.out.println(contextPath.length());//path에 길이 얻기
	
		//MemberLogin.me 얻기
		String command=RequestURI.substring(contextPath.length());
		System.out.println(command);
		
		//주소비교
		//페이지 이동 방식 여부 값,이동페이지 경로 값 저장 하여 리턴 해주는 객체를 저장할 참조변수 선언 
		ActionForward forward=null;
		
		//자식 Action 객체들을 담을 인터페이스 타입의 참조변수 선언
		Action action=null;
	
		
		// 후기쓰기
		if(command.equals("/acaReviewWriteAction.arev")){
			action = new AcaReviewWriteAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				System.out.println("/acaReviewWriteAction.arev에서 예외 발생");
				e.printStackTrace();
			}
		} 
		// 후기수정
		else if(command.equals("/acaReviewUpdateAction.arev")){
			action = new AcaReviewUpdateAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				System.out.println("/acaReviewUpdateAction.arev에서 예외 발생");
				e.printStackTrace();
			}
		}
		// 내가 쓴 후기 받아오기
		else if(command.equals("/myReviewListAction.arev")){
			action = new myReviewListAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				System.out.println("/myReviewListAction.arev에서 예외 발생");
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
