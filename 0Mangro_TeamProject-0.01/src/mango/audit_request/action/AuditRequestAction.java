package mango.audit_request.action;


import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.audit_request.db.AuditRequestBean;
import mango.audit_request.db.AuditRequestDAO;

public class AuditRequestAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		//청강신청일 : 언제 듣고 싶은지
		String audit_wish_date = request.getParameter("audit_wish_date");
		
		//청강신청일 : 신청 당일 날짜
		String audit_request_date = request.getParameter("audit_request_date");
		
		//System.out.println("requestDate : " + audit_wish_date);
		//System.out.println("wishDate : " + audit_request_date);
	
		AuditRequestDAO dao = new AuditRequestDAO();			
		
		AuditRequestBean bean 
		 = new AuditRequestBean(
				 0, //auditNum : Auto Increment
				 
				 //(String)request.getSession().getAttribute("mem_email"),
				 //request.getParameter("mem_email"),
				 
				 //Integer.parseInt(request.getParameter("aca_num")),
				 //request.getParameter("aca_name"),	
				 //request.getParameter("audit_subject"),
				 
				 "1@1.com",
				 301569,
				 "(주)그루샘수학보습학원",	
				 
				 //★★★★audit_management 테이블의 subject를 fk로 등록하였기 때문에 
				 //과목명이 반드시 일치해야한다!!!
				 "hihi",
				
				 LocalDate.parse(request.getParameter("audit_request_date")),
				 LocalDate.parse(request.getParameter("audit_wish_date")),				 
				 
				 null			 
				 );
		
		int result = dao.InsertAudit(bean);	
		
		if(result == 0){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('register failed');");
			out.println("history.back();");
			out.println("</script>");	
			out.close();			
			
			return null;
		
		}else{				
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('register success');");	
			out.println("location.href='./4index.jsp'");
			out.println("</script>");				
			out.close();	
			
			return null;
			
//			ActionForward forward = new ActionForward();
//			forward.setRedirect(true);
//			forward.setPath("./4index.jsp");
//			
//			return forward;
		}				
		
	}
}
	
	


