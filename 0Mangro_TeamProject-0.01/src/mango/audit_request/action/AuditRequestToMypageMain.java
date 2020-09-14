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

public class AuditRequestToMypageMain implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//1Top.jsp에서 /AuditInfoToMypage.adrq로 진입하도록 수정	
		
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
		
		//===================학원지정번호를 매개변수로 넣어 승인된 청강신청목록 가져오기===============
		AuditRequestDAO arDAO = new AuditRequestDAO();	
		
		//승인된 청강신청목록 조회
		List<AuditRequestBean> list = arDAO.getAllAuditListApprovedOfUser(email);
		
		//각각의 청강신청 행을 JSON으로 만들고, JSON Array 객체에 넣어 mypage_main.jsp로 전달
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
		forward.setPath("./4index.jsp?center=O_mypage/mypage_main.jsp");
		return forward;
		
		
	}
	
}
