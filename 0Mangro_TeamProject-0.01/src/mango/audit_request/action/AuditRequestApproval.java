package mango.audit_request.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.audit_request.db.AuditRequestBean;
import mango.audit_request.db.AuditRequestDAO;

public class AuditRequestApproval implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
					
		AuditRequestBean bean = new AuditRequestBean();
		bean.setAcaNum(Integer.parseInt(request.getParameter("aca_num")));	
		
		int result;
		AuditRequestDAO dao = new AuditRequestDAO();	
		
		//승인,취소 구분 파라미터
		String check = request.getParameter("check");
		if(check.equals("true")){
			result = dao.ApprovalAudit(bean);
		}else{
			result = dao.DeleteAudit(bean);
		}
		
		if(result == 0){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('실패')");
			out.println("history.back();");
			out.println("</script>");	
			out.close();			
			
			return null;
			
		}else{
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('성공')");
			out.println("location.href='./ListAction.adrq'");
			out.println("</script>");	
			out.close();			
			
			return null;
		}
		
	}

}