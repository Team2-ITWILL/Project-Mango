package mango.audit_request.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.audit_request.db.AuditRequestBean;
import mango.audit_request.db.AuditRequestDAO;

public class AuditRequestAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.print("AuditRequestAction 실행");		
		
		AuditRequestDAO dao = new AuditRequestDAO();		
				
		//int acaNum = Integer.parseInt(request.getParameter("aca_num"));
		int acaNum = 123;
		String auditConfirmDate = request.getParameter("audit_request_date");
		
		AuditRequestBean bean 
		 = new AuditRequestBean(
				 0, //Auto-Increment
				 request.getParameter("mem_email"),
				 acaNum,
				 request.getParameter("aca_name"),
				 request.getParameter("audit_subject"),
				 request.getParameter("audit_request_date"),
				 request.getParameter("audit_wish_date"),
				 auditConfirmDate			 
				 );
		
		int result = dao.InsertAudit(bean);
		
		String msg = "";
		if(result == 0){
			msg += "<script>";
			msg += "alert('청강 신청 실패')";
			msg += "</script>";				
		}else{
			msg += "<script>";
			msg += "alert('청강 신청 성공')";
			msg += "</script>";		
		}
		
		request.setAttribute("msg", msg);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("../4index.jsp");
		
		return forward;
	}

}
