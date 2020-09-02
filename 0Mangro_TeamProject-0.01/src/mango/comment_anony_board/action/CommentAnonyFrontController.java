package mango.comment_anony_board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.action.AnoBoardDeleteAction;
import mango.anony_board.action.AnoBoardFileDownAction;
import mango.anony_board.action.AnoBoardInsertAction;
import mango.anony_board.action.AnoBoardSingleAction;
import mango.anony_board.action.AnoBoardToUpdateFormAction;
import mango.anony_board.action.AnoBoardUpdateAction;
import mango.anony_board.action.AnoBoardWriteAction;
import mango.anony_board.action.AnonyBoardListAction;

public class CommentAnonyFrontController extends HttpServlet {

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
	if(command.equals("/CommentAnoBoardInsertAction.cano")){
		action = new CommentAnoBoardInsertAction();
		try {
			forward = action.excute(request, response);
		} catch (Exception e) {
			System.out.println("AnonyBoardFrontController의 /CommentAnoBoardInsertAction.cano에서 예외");
			e.printStackTrace();
		} 
		
	}else if(command.equals("/CommentAnoBoardListAction.cano")){
		action = new CommentAnoBoardListAction();
		try {
			forward = action.excute(request, response);
		} catch (Exception e) {
			System.out.println("AnonyBoardFrontController의 /CommentAnoBoardListAction.cano에서 예외");
			e.printStackTrace();
		} 
	
	}else if(command.equals("/CommentAnoBoardUpdateAction.cano")){
		action = new CommentAnoBoardUpdateAction();
		
		try {
			forward = action.excute(request, response);
		} catch (Exception e) {
			System.out.println("AnonyBoardFrontController의 /CommentAnoBoardUpdateAction.cano에서 예외");
			e.printStackTrace();
		} 
	}else if(command.equals("/CommentAnoBoardDeleteAction.cano")){
		action = new CommentAnoBoardDeleteAction();
		
		try {
			forward = action.excute(request, response);
		} catch (Exception e) {
			System.out.println("AnonyBoardFrontController의 /CommentAnoBoardDeleteAction.cano에서 예외");
			e.printStackTrace();
		} 
	}else if(command.equals("/CommentAnoBoardReplyAction.cano")){
		action = new CommentAnoBoardReplyAction();
		
		try {
			forward = action.excute(request, response);
		} catch (Exception e) {
			System.out.println("AnonyBoardFrontController의 /CommentAnoBoardReplyAction.cano에서 예외"+e.getMessage());
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
	// TODO Auto-generated method stub
	doProcess(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doProcess(request, response);
	}  
	


	

	
}
