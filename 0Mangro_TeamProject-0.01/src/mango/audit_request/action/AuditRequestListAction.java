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
		
		//필수!!
		request.setCharacterEncoding("utf-8");
		String email = (String)request.getSession().getAttribute("id_email");
		
		System.out.println("AuditRequestListAction.java 실행");
		
		AuditRequestDAO dao = new AuditRequestDAO();
		
		int count = dao.getAuditCount();
		int count_app = dao.getAuditCountApproval();
		System.out.println("누적 청강수 : " + count);
		System.out.println("승인된 청강수 : " + count_app);
		
		AuditRequestBean bean = new AuditRequestBean();	
		bean.setMemEmail(email);
		
		List<AuditRequestBean> list = dao.getAuditList(bean);
		request.setAttribute("AuditList", list);
		
		//화면갱신 -> request값 날라가는 듯
//		PrintWriter out = response.getWriter();
//		out.println("<script>");
//		out.println("location.reload(true)");
//		out.println("</script>");
//		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_aca_admin_page/aca_audit_list.jsp");
		return forward;
		
		//★★★★★★★★★★★
		//현재 DB의 audit_management 테이블의
		//audit_avail_subj1 -> audit_avail_subj로 컬럼명 바뀌었고
		//audit_avail_date -> date 타입으로 바뀌었음
		//audit_Requset,managetment 테이블과 bean,dao 타입 date로 변경할 것
		
		//audit_requsest 테이블에 audit_wish_date
		//->null값 들어가있음
		//->청강현황페이지에서 조회안되는 이유
		
		//청강신청일자,청강희망일자 순서 ->테이블,bean,dao, jsp파일 일치시키기
		//변수명도
		
		
		//  aca_admin.main.jsp와 aca_audit_list.jsp에서  청강현황리스트를 바로 불러오게 하기 위해서
		//  <li class="sidebar-item"><a href="./ListAction.adrq"></a></li>로 수정함
		
		// -> 학원관리자 - 청강신청현황 버튼 클릭		
		// -> AuditRequestListAction.java 실행 (ListAction.adrq) 
		// -> 청강현황 리스트를 바인딩하여 aca_audit_list.jsp로 포워딩
		// -> aca_audit_list.jsp에서 리스트 데이터 출력
	}
	
}
