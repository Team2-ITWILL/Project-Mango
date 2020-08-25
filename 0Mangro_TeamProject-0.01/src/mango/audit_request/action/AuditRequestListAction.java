package mango.audit_request.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.audit_request.db.AuditRequestBean;
import mango.audit_request.db.AuditRequestDAO;

public class AuditRequestListAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		System.out.println("AuditRequestListAction.java 실행");
		
		AuditRequestDAO dao = new AuditRequestDAO();
		
		AuditRequestBean bean = new AuditRequestBean();
		
		//학원지정번호 바인딩
		//bean.setAcaNum(Integer.parseInt(request.getParameter("aca_num")));
		bean.setAcaNum(301569); //임시번호
		
		List<AuditRequestBean> list = dao.getAuditList(bean);
		request.setAttribute("AuditList", list);
		
//		PrintWriter out = response.getWriter();
//		out.println(list);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_aca_admin_page/aca_audit_list.jsp");
		return forward;
		
		
		// aca_audit_list.jsp에서 학원관리자 - 청강신청현황 버튼 클릭
		// -> AuditRequestListAction.java 실행 (ListAction.adrq) 
		// -> 청강현황 리스트를 바인딩하여 aca_audit_list.jsp로 포워딩
		// -> aca_audit_list.jsp에서 리스트 데이터 출력
	}
	
}
