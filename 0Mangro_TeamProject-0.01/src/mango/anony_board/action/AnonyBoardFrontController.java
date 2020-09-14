package mango.anony_board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;

public class AnonyBoardFrontController extends HttpServlet{

	
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
	
		
		// 익명사담방 목록보기 화면
		if(command.equals("/AnonyBoardListAction.anob")){
			action = new AnonyBoardListAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				System.out.println("AnonyBoardFrontController의 /noBoard.anob에서 예외");
				e.printStackTrace();
			} 
			
			
		// 익명사담방 글쓰기 화면(form입력 페이지 호출 + hidden 전송값 받기 )
		}else if(command.equals("/AnoBoardWriteAction.anob")){
			action = new AnoBoardWriteAction();
			
			try {
				forward = action.excute(request, response);
				
			} catch (Exception e) {
				System.out.println("AnonyBoardFrontController의 /AnoBoardWriteView.anob에서 예외");
				e.printStackTrace();
				
			}
			
		// 익명사담방 글쓰기 화면(form입력 내용을 DB에 insert액션)
		}else if(command.equals("/AnoBoardInsertAction.anob")){
			action = new AnoBoardInsertAction();
			
			try{
				forward = action.excute(request, response);
				
			}catch(Exception e){
				System.out.println("AnonyBoardFrontController의 /AnoBoardInsertAction.anob에서 예외");
				e.printStackTrace();
				
			}
		
			
		// 익명사담방 글 상세보기 화면(글 내용 호출)
		}else if(command.equals("/AnoBoardSingleAction.anob")){
			action = new AnoBoardSingleAction();
			
			System.out.println("여기까지 옴");
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				System.out.println("AnonyBoardFrontController의 /AnoBoardSingleAction.anob에서 예외");
				e.printStackTrace();
			}

		// 익명사담방 글 상세보기 화면(글 삭제 액션)
		}else if(command.equals("/AnoBoardDeleteAction.anob")){
			action = new AnoBoardDeleteAction();
			
			try{
				forward = action.excute(request, response);
				
			}catch(Exception e){
				System.out.println("AnonyBoardFrontController의 /AnoBoardDeleteAction.anob에서 예외");
				e.printStackTrace();
			}
		// 익명사담방 글 상세보기 화면(글 수정 액션)
		
			
		}else if(command.equals("/AnoBoardToUpdateFormAction.anob")){
			action = new AnoBoardToUpdateFormAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				System.out.println("AnonyBoardFrontController의 /AnoBoardToUpdateFormAction.anob에서 예외");
				e.printStackTrace();
			}
			
		}else if(command.equals("/AnoBoardUpdateAction.anob")){
			action = new AnoBoardUpdateAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				System.out.println("AnonyBoardFrontController의 /AnoBoardUpdateAction.anob에서 예외");
				e.printStackTrace();
			}
		
		}else if(command.equals("/AnoBoardFileDownAction.anob")){
			action = new AnoBoardFileDownAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e){
				System.out.println("AnonyBoardFrontController의 /AnoBoardFileDownAction.anob에서 예외");
				e.printStackTrace();
			}
			
		}else if(command.equals("/MyAnonyBoardListAction.anob")){
			action = new MyAnonyBoardListAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e){
				System.out.println("AnonyBoardFrontController의 /MyAnonyBoardListAction.anob에서 예외");
				e.printStackTrace();
			}
			
		}else if(command.equals("/AdminAnonyReportedListAction.anob")){
			action = new AdminAnonyReportedListAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e){
				System.out.println("AnonyBoardFrontController의 /AdminAnonyReportedListAction.anob에서 예외");
				e.printStackTrace();
			}
			
		}else if(command.equals("/AdminAnonyHandleReportedAction.anob")){
			action = new AdminAnonyHandleReportedAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e){
				System.out.println("AnonyBoardFrontController의 /AdminAnonyHandleReportedAction.anob에서 예외");
				e.printStackTrace();
			}
			
		}else if(command.equals("/ReportAnonyBoardAction.anob")){
			action = new ReportAnonyBoardAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e){
				System.out.println("AnonyBoardFrontController의 /ReportAnonyBoardAction.anob에서 예외");
				e.printStackTrace();
			}
			
		}
			
		
		if(forward!=null){ //new ActionForward()객체가 존재시
			
			if(forward.isRedirect()){//true -> sendRedirect() 방식일떄..
				
				response.sendRedirect(forward.getPath());
				
			}else{//false -> forward() 방식일때...
				
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		
		}//if 
		
}//doProcess
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
}