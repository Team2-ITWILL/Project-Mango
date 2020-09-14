package mango.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import mango.academy.db.AcademyDAO;
import mango.academy_register.db.AcademyRegisterDAO;
import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberDAO;
import mango.payment.db.PayMentDAO;

public class AdminGetTotalInfoAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String email = (String)request.getSession().getAttribute("id_email");
		
		//---------------로그인이 되어있는지 확인-------------------------//
		if(email == null || email.equals("")){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.');");
			out.println("location.href='./MemberLogin.me';");
			out.println("</script>");
			out.close();
			return null;
		}
		// 사이트 관리자 계정인지 확인('admin@mango.com')
		String adminID = "admin@mango.com";
		if(!email.equals(adminID)){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			
			out.println("<script>");
			out.println("alert('사이트 관리자가 아닙니다');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}		
		
		//================회원 수 구분=============================
		MemberDAO memDAO = new MemberDAO();		
		
		JSONObject countObj = memDAO.getMemberCountDiff();		
		
		int memTotal = (int)countObj.get("total"); // 총 회원 수
		int isAdmin = (int)countObj.get("isAdmin"); // 학원 회원 수
		int isNormal = (int)countObj.get("isNormal"); // 일반 회원 수
		int isBaned = (int)countObj.get("isBaned"); // 정지된 회원 수
		int isSeceded = (int)countObj.get("isSeceded"); // 탈퇴한 회원 수
		request.setAttribute("memTotal", memTotal);
		request.setAttribute("isAdmin", isAdmin);
		request.setAttribute("isNormal", isNormal);
		request.setAttribute("isBaned", isBaned);
		request.setAttribute("isSeceded", isSeceded);
		
		//==================등록 학원 수===============================
		AcademyDAO acaDAO = new AcademyDAO();
		int acaCount = acaDAO.getAcademyCount();
		int registeredCount = acaDAO.getRegisteredAcademyCount();
		request.setAttribute("acaCount", acaCount);
		request.setAttribute("registeredCount", registeredCount);
		
		//===================등록 요청 학원 수=============================
		AcademyRegisterDAO arDAO = new AcademyRegisterDAO();
		int regCount = arDAO.getRegRequestCount();
		request.setAttribute("regCount", regCount);
		
		
		//===================한달 동안 결제 금액===========================
		PayMentDAO pdao = new PayMentDAO();
		int monthMoney= pdao.getMonthMoney();
		request.setAttribute("MonthMoney", monthMoney);
		
		
		//=========================포워딩===============================
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_admin/admin_main.jsp");
		return forward;
		
	}//excute()

}//AdminGetTotalInfoAction
