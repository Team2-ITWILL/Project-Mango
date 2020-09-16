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
				out.println("location.href='./ListAction.adrq'");
				//out.println("history.back();");
				out.println("</script>");	
				out.close();			
				return null;		
				
			}else{
			
				//===================누적청강수 증가=======================	
				result = dao.addAuditCount(acaNum, auditNum);
				
				System.out.println("@@@누적청강수 증가 메서드 종료@@@");
				System.out.println("addAuditCount : " + result);
				
				if(result == 0){
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('addAuditCount failed!');");
					out.println("location.href='./ListAction.adrq'");
					//out.println("history.back();");
					out.println("</script>");	
					out.close();			
					return null;		
				}
			}
			//System.out.println("@@@if(check.equals(approve))@@@ 조건문 마지막");
			
		}else{
			//System.out.println("@@@if(check.equals(approve))@@@ 조건문 통과");
			//System.out.println("@@@else(check == approve가 아닐 경우) @@@");
		}

		
		//============청강 승인,취소,삭제================
		System.out.println("@@@ApprovalAudit() 실행 전@@@");
		
		//System.out.println("@@@서버 무한대기상태 들어가는 지점@@@");
		//result = 0;	
		result = dao.ApprovalAudit(bean, check);	
		
		System.out.println("@@@ApprovalAudit() 실행 후 @@@ : " + result);
		
		//ApprovalAudit() 실패
		if(result == 0){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('처리 과정에서 문제가 발생하였습니다. 관리자에게 문의하세요.')");
			out.println("location.href='./ListAction.adrq'");
			//out.println("history.back();");
			out.println("</script>");	
			out.close();				
			return null;	
		
		//ApprovalAudit() 성공
		}else{		
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('처리 완료')");
			out.println("location.href='./ListAction.adrq'");
			out.println("</script>");	
			out.close();				
			return null;
		}
		
	}

}
