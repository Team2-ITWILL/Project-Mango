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

public class AuditRequestListToMyPageAction implements Action{

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
		
		//============청강신청현황 조회=============				
		AuditRequestDAO dao = new AuditRequestDAO();	
		List<AuditRequestBean> list = dao.getAllAuditListOfUser(email);				
		request.setAttribute("AuditList", list);
		
		//====================승인된 청강신청 수=======================		
		//해당 학원의 총 청강신청수
		int total = dao.getAuditCountOfUser(email);
		//해당 학원의 승인된 청강신청수
		int count_approved = dao.getAuditCountApprovalOfUser(email);
		request.setAttribute("total", total);
		request.setAttribute("count_approved", count_approved);
		
		//청강신청현황 상단에 회원 아이디 출력 목적
		request.setAttribute("email", email);		

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_mypage/my_audit_list.jsp");
		return forward;
		
		
	}
	
}
