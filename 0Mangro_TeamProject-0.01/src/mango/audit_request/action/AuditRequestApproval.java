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
				
		request.setCharacterEncoding("utf-8");
		
		//청강신청 현황을 조회하고 있는 학원관리자 id
		String email = (String)request.getSession().getAttribute("id_email");
		int auditNum = Integer.parseInt(request.getParameter("audit_num"));
		int acaNum = Integer.parseInt(request.getParameter("aca_num"));
		System.out.println("auditNum : " + auditNum);
		System.out.println("acaNum : " + acaNum);
		
		AuditRequestBean bean = new AuditRequestBean();
		bean.setAuditNum(auditNum);
		bean.setAcaNum(acaNum);		
		
		String check = request.getParameter("check");	
		System.out.println("check : " + check);
		
		AuditRequestDAO dao = new AuditRequestDAO();
		int result = 0;		
		
		//승인버튼을 누른 경우
		if(check.equals("approve")){	
			
			//승인 처리된 상태인지 확인
			result = dao.isApproved(acaNum, auditNum);
			
			//승인 상태일 경우 1 반환
			if(result == 1){
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('failed! 이미 청강승인이 된 상태입니다.');");
				out.println("history.back();");
				out.println("</script>");	
				out.close();			
				return null;		
			}
			
			//===================누적청강수 증가=======================	
			result = dao.addAuditCount(acaNum, auditNum);
			if(result == 0){
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('addAuditCount failed!');");
				out.println("history.back();");
				out.println("</script>");	
				out.close();			
				return null;		
			}
			
		}

		
		//============청강 승인,취소,삭제================
		result = 0;	
		result = dao.ApprovalAudit(bean, check);	
		
		//ApprovalAudit() 실패
		if(result == 0){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('실패')");
			out.println("history.back();");
			out.println("</script>");	
			out.close();				
			return null;	
		
		//ApprovalAudit() 성공
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
