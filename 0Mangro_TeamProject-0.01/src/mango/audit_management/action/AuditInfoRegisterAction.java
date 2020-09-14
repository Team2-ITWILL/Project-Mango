package mango.audit_management.action;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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
		
		LocalDate auditAvailDate = null;
		try {
			auditAvailDate = LocalDate.parse(request.getParameter("auditAvailDate"));
			
		} catch (/*DateTimeParseException*/ Exception e) {
			e.printStackTrace();
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('숫자만 입력해주세요!');");
			out.println("history.back();");
			out.println("</script>");	
			out.close();			
			return null;	
		}
		
		int auditLastTime;
		try {
			auditLastTime = Integer.parseInt(request.getParameter("auditLastTime"));
			
		} catch (/*NumberFormatException*/ Exception e) {
			e.printStackTrace();
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('숫자만 입력해주세요!');");
			out.println("history.back();");
			out.println("</script>");	
			out.close();			
			return null;	
		} 
		
		bean.setAuditAvailDate(auditAvailDate);
		bean.setAuditLastTime(auditLastTime);				
		/*bean.setAuditAvailDate(LocalDate.parse(request.getParameter("auditAvailDate")));
		bean.setAuditLastTime(Integer.parseInt(request.getParameter("auditLastTime")));*/		
		
		bean.setAuditAblemem(Integer.parseInt(request.getParameter("auditAblemem")));
		
		AuditManagementDAO dao = new AuditManagementDAO();
		
		int result = dao.insertAuditMangement(bean);	
		
		if(result == -1){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이미 등록된 과목입니다.');");
			out.println("history.back();");
			out.println("</script>");	
			out.close();			
			return null;	
		}else if(result == 0){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('청강신청 과목 등록이 완료되지 않았습니다. 다시 시도해주세요.');");
			out.println("history.back();");
			out.println("</script>");	
			out.close();			
			return null;			
		}else{
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('청강신청 과목이 성공적으로 등록되었습니다.');");		
			out.println("location.href='./AuditInfoToCalendar.adrq'");
			out.println("</script>");				
			out.close();			
			return null;			
		}		
			
		
	}

}
