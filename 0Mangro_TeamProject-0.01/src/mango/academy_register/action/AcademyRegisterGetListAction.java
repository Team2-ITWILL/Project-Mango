package mango.academy_register.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.academy_register.db.AcademyRegisterBean;
import mango.academy_register.db.AcademyRegisterDAO;
import mango.action.Action;
import mango.action.ActionForward;

public class AcademyRegisterGetListAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
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
		// 사이트 관리자 계정인지 확인('admin@mango.com')
		String adminID = "admin@mango.com";
		if(!email.equals(adminID)){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			
			out.println("<script>");
			out.println("alert('해당 계정은 사이트 관리자 등급이 아닙니다');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}		
		
		//=================학원관리자 신청 리스트 가져오기================
		AcademyRegisterDAO arDAO = new AcademyRegisterDAO();
		List<AcademyRegisterBean> list = arDAO.getAllRegisterList(email);
		request.setAttribute("registerList", list);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_admin/register_reqManagement.jsp");		
		return forward;
		
	}

}
