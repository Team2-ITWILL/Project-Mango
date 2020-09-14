package mango.audit_request.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.academy.db.AcademyDAO;
import mango.academy_register.db.AcademyRegisterDAO;
import mango.action.Action;
import mango.action.ActionForward;
import mango.audit_request.db.AuditRequestBean;
import mango.audit_request.db.AuditRequestDAO;

public class AuditRequestListAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String email = (String)request.getSession().getAttribute("id_email");
		
		//====================로그인이 되어있는지 확인===========================//
		if(email == null || email.equals("")){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			
			out.println("<script>");
			out.println("alert('로그인이 필요합니다!');");
			out.println("location.href='./MemberLogin.me';");
			out.println("</script>");
			out.close();
			return null;
		}
		
		//====================학원관리자 계정인지 확인=========================//
		AcademyRegisterDAO registerDAO = new AcademyRegisterDAO();
		int isAdmin = registerDAO.CheckAdminUser(email);
		System.out.println("isAdmin : " + isAdmin);
		if(isAdmin == 0){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			
			out.println("<script>");
			out.println("alert('해당 계정은 학원 관리자 등급이 아닙니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}		
		
		//============청강신청현황 조회=============
		//학원 정보 얻어오기
		AcademyDAO acaDAO = new AcademyDAO();
		String acaName = acaDAO.getAcademyContent(email).getAcaName();
		int aca_main_num = acaDAO.getAcademyContent(email).getAcaMainNum();
		
		AuditRequestDAO dao = new AuditRequestDAO();	
		//청강신청현황 리스트
		List<AuditRequestBean> list = null;	
		
		//1. 사이트 관리자일 경우(admin@mango.com) 모든 청강신청현황 출력
		String admin = "admin@mango.com";
		if(email.equals(admin)){
			list = dao.getAllAuditList();	
			
		//2. 일반 학원관리자일 경우(member table의 mem_admin 컬럼 != 0)
		//   자기 학원의 청강신청현황 출력
		}else{
			AuditRequestBean bean = new AuditRequestBean();	
			bean.setAcaNum(aca_main_num);		
			list = dao.getAuditList(bean);	
		}			
		request.setAttribute("AuditList", list);
		
		//====================승인된 청강신청 수=======================		
		//해당 학원의 총 청강신청수
		int total = dao.getAuditCount(aca_main_num, email);
		//해당 학원의 승인된 청강신청수
		int count_approved = dao.getAuditCountApproval(aca_main_num, email);
		request.setAttribute("total", total);
		request.setAttribute("count_approved", count_approved);
		
		//청강신청현황 상단에 회원 아이디 출력 목적
		request.setAttribute("email", email);		

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_aca_admin_page/aca_audit_list.jsp");
		return forward;	
	
	}
	
}
