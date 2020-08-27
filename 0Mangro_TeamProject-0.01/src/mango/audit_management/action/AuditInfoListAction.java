package mango.audit_management.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;

public class AuditInfoListAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		//forward.setPath("./4index.jsp?center=O_aca_admin_page/aca_audit_list.jsp");
		return forward;
	}
	
}
