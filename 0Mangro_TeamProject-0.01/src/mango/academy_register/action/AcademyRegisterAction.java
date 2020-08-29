package mango.academy_register.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.academy_register.db.AcademyRegisterBean;
import mango.academy_register.db.AcademyRegisterDAO;
import mango.action.Action;
import mango.action.ActionForward;

public class AcademyRegisterAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String email = (String)request.getSession().getAttribute("id_email");
		String addr_zip = request.getParameter("addr_zip");
		String addr_doro = request.getParameter("addr_doro");
		String acaName = request.getParameter("acaName");		
		
		String fNameCompany = request.getParameter("fNameCompany");		
		String fNameOwner = request.getParameter("fNameOwner");
		
		AcademyRegisterBean bean = new AcademyRegisterBean();
		bean.setMemEmail(email);
		bean.setMemAddrZip(addr_zip);
		bean.setMemAddrDoro(addr_doro);
		bean.setAcaName(acaName);
		
		bean.setfNameCompany(fNameCompany);
		bean.setfNameOwner(fNameOwner);
		
		bean.setfSizeCompany("adfafd");
		bean.setfSizeOwner("Sdfdsf");
		
		
		AcademyRegisterDAO dao = new AcademyRegisterDAO();
		int result = dao.RegisterToDB(bean);
		
		if(result == 0){
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('failed');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('success');");
			out.println("location.href='./4index.jsp'");
			out.println("</script>");
			out.close();
			return null;
		}	
		
	}

	
}
