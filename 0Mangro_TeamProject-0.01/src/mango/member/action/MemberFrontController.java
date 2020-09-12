package mango.member.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mango.action.Action;
import mango.action.ActionForward;

public class MemberFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException{
		
		
		//가상요청 주소 가져오기
		//예)MangoProject/MemberLogin.me 
		String RequestURI = request.getRequestURI();
		System.out.println(RequestURI);
		
		//MangoProject 얻기
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		
		System.out.println(contextPath.length());//path에 길이 얻기
	
		//MemberLogin.me 얻기
		String command = RequestURI.substring(contextPath.length());
		System.out.println(command);
		
		//주소비교
		//페이지 이동 방식 여부 값,이동페이지 경로 값 저장 하여 리턴 해주는 객체를 저장할 참조변수 선언 
		ActionForward forward = null;
		
		//자식 Action 객체들을 담을 인터페이스 타입의 참조변수 선언
		Action action = null;
		
		
		
/* ---------------------------------- 일반 회원가입 시작 ---------------------------------- */		
		
		if(command.equals("/MemberJoin.me")){
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/4index.jsp?center=O_member/member_sign_up.jsp");
		
		}else if(command.equals("/MemberJoinAction.me")){
			
			action = new MemberJoinAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				System.out.println("/MemberJoinAction.me : "+ e);
				e.printStackTrace();
			}

/* ---------------------------------- 일반 회원가입 끝 ---------------------------------- */		
			
			
			
/* ---------------------------------- 네이버 회원가입 시작 ---------------------------------- */		

		}else if(command.equals("/MemberNaverJoinAction.me")){
			
			action = new MemberNaverJoinAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				System.out.println("/MemberNaverJoinAction.me : "+ e);
				e.printStackTrace();
			}	
			
/* ---------------------------------- 네이버 회원가입 끝 ---------------------------------- */		
			
			
			
/* ---------------------------------- 회원 가입 메일 인증번호 전송 시작 ---------------------------------- */		
			
		}else if(command.equals("/MemberMailAction.me")){
			
			action = new MemberMailAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				System.out.println("/MemberMailAction.me : " + e);
				e.printStackTrace();
			}
			
/* ---------------------------------- 회원가입 메일 인증번호 전송 끝 ---------------------------------- */		

			
			
			
			
			
/* ---------------------------------- 로그인 시작  ---------------------------------- */	
			
		}else if(command.equals("/MemberLogin.me")){
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./4index.jsp?center=O_member/member_sign_in.jsp");
			
		}else if(command.equals("/MemberLoginAction.me")){
			
			action = new MemberLoginAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				System.out.println("/MemberLoginAction.me : "+ e);
				e.printStackTrace();
			}
			
/* ---------------------------------- 로그인 끝  ---------------------------------- */
			
			
			
/* ---------------------------------- 네이버 로그인 시작  --------------------------------- */
		
		}else if(command.equals("/MemberNaverLoginAction.me")){
					
			action = new MemberNaverLoginAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				System.out.println("/MemberNaverLoginAction.me : "+ e);
				e.printStackTrace();
			}
			
/* ---------------------------------- 네이버 로그인 끝  ---------------------------------- */
			
			
			
/* ---------------------------------- 메인화면 시작  ---------------------------------- */	
		
		}else if(command.equals("/Main.me")){
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./4index.jsp");

/* ---------------------------------- 메인화면 끝  ---------------------------------- */	

			
			
/* ---------------------------------- 로그아웃 시작  ---------------------------------- */	
			
		}else if(command.equals("/MemberLogout.me")){
			
			action = new MemberLogoutAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				System.out.println("/MemberLogout.me : " + e);
				e.printStackTrace();
			}
			
/* ---------------------------------- 로그아웃 끝  ---------------------------------- */	

			
			
/* ---------------------------------- 회원 탈퇴 시작  ------------------------------------- */	
			
		}else if(command.equals("/MemberDelete.me")){
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./4index.jsp?center=O_member/member_secede.jsp");
			
		}else if(command.equals("/MemberDeleteAction.me")){
			
			action = new MemberDeleteAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				System.out.println("/MemberDelete.me : " + e);
				e.printStackTrace();
			}
			
/* ---------------------------------- 회원 탈퇴 끝  --------------------------------------- */	

			
			
/* ---------------------------------- 회원 정보 수정 시작  ---------------------------------- */	
			
		}else if(command.equals("/MemberUpdate.me")){
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./4index.jsp?center=O_member/member_revise.jsp");
			
		}else if(command.equals("/MemberUpdateAction.me")){
	
			action = new MemberUpdateAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				System.out.println("/MemberUpdateAction.me : " + e);
				e.printStackTrace();
			}
		
/* ---------------------------------- 회원 정보 수정 끝  ------------------------------------ */	

			
			
/* ---------------------------------- 비밀번호 찾기 시작   ---------------------------------- */	
		
		}else if(command.equals("/MemberFindPw.me")){
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/4index.jsp?center=O_member/member_password.jsp");
			
		}else if(command.equals("/MemberFindPwAction.me")){
			
			action = new MemberFindPwAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("MemberFindPwAction.me : " + e);
			}
		
/* ---------------------------------- 비밀번호 찾기 끝  ----------------------------------- */	
			
			
			
/* ---------------------------------- 회원관리 시작  ------------------------------------- */	

		}else if(command.equals("/MemberManagement.me")){
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/4index.jsp?center=O_admin/member_management.jsp");
			
		}else if(command.equals("/MemberManagementAction.me")){
			
			action = new MemberManagementAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("MemberManagementAction.me : "+ e);
			} 
			
/* ---------------------------------- 회원관리 끝  ----------------------------------------- */	
		
		
			
/* ---------------------------------- 아이디 중복 체크 시작  ---------------------------------- */	
		
		}else if(command.equals("/MemberIDcheckAction.me")){
			
			action = new MemberIDcheckAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("MemberIDcheckAction.me : "+ e);
			}
	
/* ---------------------------------- 아이디 중복 체크 끝  ---------------------------------- */	
	
		
/* ---------------------------------- 프로필 변경 시작  ------------------------------------ */
		
		}else if(command.equals("/MemberProfileAction.me")){
			
			action = new MemberProfileAction();
			
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("MemberProfileAction.me : "+ e);
			}
			
		}
		
/* ---------------------------------- 프로필 변경 끝  -------------------------------------- */	
		
		
		
		
		if(forward != null){ //new ActionForward()객체가 존재 하고..
			
			if(forward.isRedirect()){//true -> sendRedirect() 방식일떄..
				
				//리다이렉트 방식으로 페이지 이동!  페이지 주소 경로 노출 함 
				
				//join.jsp화면 이동
				
				response.sendRedirect(forward.getPath());
				
			}else{//false -> forward() 방식일때...
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
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