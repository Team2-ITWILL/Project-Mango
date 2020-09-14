package mango.audit_request.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mango.academy.db.AcademyBean;
import mango.academy.db.AcademyDAO;
import mango.academy_register.db.AcademyRegisterDAO;
import mango.action.Action;
import mango.action.ActionForward;
import mango.audit_request.db.AuditRequestBean;
import mango.audit_request.db.AuditRequestDAO;

public class AuditRequestToCalendarAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//1Top.jsp에서 /AuditInfoToCalendar.adrq로 진입하도록 수정
		
		request.setCharacterEncoding("utf-8");
		String email = (String)request.getSession().getAttribute("id_email");
		
		//---------------로그인이 되어있는지 확인-------------------------//
		if(email == null || email.equals("")){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			
			out.println("<script>");
			out.println("alert('로그인이 필요합니다!');");
			out.println("location.href='./MemberLogin.me';");
			out.println("</script>");
			out.close();
			return null;
		}
		
		//===================학원지정번호 가져오기======================
		AcademyDAO acaDAO = new AcademyDAO();
		AcademyBean acaBean = acaDAO.getAcademyContent(email);
		//System.out.println(acaBean.getMem_email());
		
		//academy테이블에 학원관리자로 연동되어 있지 않다면 AcademyBean에 데이터를 받아올 수 없어 진입 불가
		if(acaBean == null){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			
			out.println("<script>");
			out.println("alert('학원 관리자 정보가 등록되어 있지 않습니다');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}		
		//연동되어 있다면 학원번호 받아옴
		int aca_main_num = acaBean.getAcaMainNum();
		
		
		
		//---------------학원관리자 계정인지 확인-------------------------//
		AcademyRegisterDAO registerDAO = new AcademyRegisterDAO();
		int isAdmin = registerDAO.CheckAdminUser(email);
		System.out.println("isAdmin : " + isAdmin);
		if(isAdmin == 0){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			
			out.println("<script>");
			out.println("alert('학원 관리자 등급이 아닙니다. 신청하시거나 승인을 기다려주세요');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		
		
		//===================학원지정번호를 매개변수로 넣어 승인된 청강신청목록 가져오기===============
		AuditRequestDAO arDAO = new AuditRequestDAO();	
		
		//승인된 청강신청목록 조회
		List<AuditRequestBean> list = arDAO.getAllAuditListApproved(aca_main_num);
		
		//각각의 청강신청 행을 JSON으로 만들고, JSON Array 객체에 넣어 aca_admin_main.jsp로 전달
		JSONArray jsArray = new JSONArray();
		for(AuditRequestBean bean : list){
			
			JSONObject obj = new JSONObject();
			obj.put("auditNum", bean.getAuditNum());
			obj.put("memEmail", bean.getMemEmail());
			obj.put("acaNum", bean.getAcaNum());
			obj.put("acaName", bean.getAcaName());
			obj.put("auditSubject", bean.getAuditSubject());
			obj.put("auditWishDate", bean.getAuditWishDate().toString());
			obj.put("auditRequestDate", bean.getAuditRequestDate().toString());
			obj.put("auditConfirmDate", bean.getAuditConfirmDate().toString());	
			
			jsArray.add(obj);
		}
		
		//System.out.println(jsArray);
		request.setAttribute("AuditArray", jsArray);
		

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_aca_admin_page/aca_admin_main.jsp");
		return forward;
		
		
	}
	
}
