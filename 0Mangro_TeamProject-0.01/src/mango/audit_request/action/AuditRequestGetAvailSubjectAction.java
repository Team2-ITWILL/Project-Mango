package mango.audit_request.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.audit_management.db.AuditManagementBean;
import mango.audit_management.db.AuditManagementDAO;

public class AuditRequestGetAvailSubjectAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		//청강신청계정(user id)
		String email = (String)request.getSession().getAttribute("id_email");
		
		//---------------로그인이 되어있는지 확인-------------------------//
		if(email == null || email.equals("")){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			
			out.println("<script>");
			out.println("alert('로그인이 필요합니다.');");
			out.println("location.href='./MemberLogin.me';");
			out.println("</script>");
			out.close();
			return null;
		}
		
		//학원번호
		int aca_main_num = Integer.parseInt(request.getParameter("aca_main_num"));	
		
		AuditManagementDAO dao = new AuditManagementDAO();
		
		AuditManagementBean vo = new AuditManagementBean();
		vo.setAcaNum(aca_main_num);		
	
		
		List<AuditManagementBean> list = dao.getListAuditMangement(vo);
		
		//등록된 청강가능과목이 없을 경우
		if(list == null){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			
			out.println("<script>");
			out.println("alert('청강신청이 가능한 과목이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		request.setAttribute("auditManageList", list);
		request.setAttribute("email", email);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_academy/academy_audit.jsp");		
		return forward;
		
		//http://localhost:8090/Mango/AuditGetSubj.adrq?aca_main_num=1&acaName=(%EC%A3%BC)%EA%B7%B8%EB%A3%A8%EC%83%98%EC%88%98%ED%95%99%EB%B3%B4%EC%8A%B5%ED%95%99%EC%9B%90
		//학원 정보 -> 청강신청 -> AuditGetSubj.adrq에 학원번호,이름 바인딩해서 보내기
		
	}
	
}
