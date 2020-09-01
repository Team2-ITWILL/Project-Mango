package mango.academy.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.academy.db.AcademyDAO;
import mango.action.Action;
import mango.action.ActionForward;

public class AcademyAdminInfoAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//--------------로그인 여부 확인--------------------//
		String email = (String)request.getSession().getAttribute("mem_email");
		if(email == null || email.equals("")){
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=utf-8");
			System.out.println("<script>");
			System.out.println("alert('로그인이 필요합니다');");
			System.out.println("</script>");
			return null;
		}
		
		AcademyDAO dao = new AcademyDAO();
		
		
		return null;
	}

	
}
