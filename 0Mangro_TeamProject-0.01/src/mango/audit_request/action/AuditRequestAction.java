package mango.audit_request.action;


import java.text.SimpleDateFormat;
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
		
		//System.out.print("AuditRequestAction 실행");		
		
		String audit_wish_date = request.getParameter("audit_wish_date");
		String audit_request_date = request.getParameter("audit_request_date");
		SimpleDateFormat format = new SimpleDateFormat("yy-mm-dd");
		Date date = format.parse(audit_wish_date);
		
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
				 "hihi",
				
				 
				 (Date)request.getParameter("audit_request_date"),
				 (Date)request.getParameter("audit_wish_date"),
				 null			 
				 );
		
		int result = dao.InsertAudit(bean);	
		
		/*if(result == 0){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('register failed')");
			out.println("history.back();");
			out.println("</script>");	
			out.close();			
		}else{
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('register success')");		
			out.println("</script>");				
			out.close();		
		}		*/
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./4index.jsp");
		
		return forward;
	}

}
