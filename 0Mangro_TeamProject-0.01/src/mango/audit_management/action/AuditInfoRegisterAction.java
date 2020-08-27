package mango.audit_management.action;

import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.audit_management.db.AuditManagementBean;
import mango.audit_management.db.AuditManagementDAO;

public class AuditInfoRegisterAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		AuditManagementBean bean = new AuditManagementBean();		
		bean.setAcaNum(Integer.parseInt(request.getParameter("acaNum")));
		bean.setAcaName(request.getParameter("acaName"));
		bean.setAuditAvailSubj(request.getParameter("auditAvailSubj"));
		bean.setAuditAvailDate(LocalDate.parse(request.getParameter("auditAvailDate")));
		bean.setAuditLastTime(Integer.parseInt(request.getParameter("auditLastTime")));
		bean.setAuditAblemem(Integer.parseInt(request.getParameter("auditAblemem")));
		
		AuditManagementDAO dao = new AuditManagementDAO();
		
		int result = dao.insertAuditMangement(bean);		
		
		if(result == 0){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('register failed')");
			out.println("history.back();");
			out.println("</script>");	
			out.close();
			
			return null;
			
		}else{
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('register success')");		
			out.println("location.href='./4index.jsp?center=O_aca_admin_page/aca_admin_main.jsp'");
			out.println("</script>");				
			out.close();
			
			/*ActionForward forward  = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./4index.jsp?center=O_aca_admin_page/aca_admin_main.jsp");			
			return forward;*/
			
			return null;
			
		}		
			
		
	}

}
