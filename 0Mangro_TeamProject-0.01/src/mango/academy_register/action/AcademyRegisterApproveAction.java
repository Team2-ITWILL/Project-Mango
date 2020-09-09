package mango.academy_register.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.academy.db.AcademyBean;
import mango.academy.db.AcademyDAO;
import mango.academy_register.db.AcademyRegisterDAO;
import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberDAO;

public class AcademyRegisterApproveAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		//email : 사이트 관리자 계정 이메일
		//String email = (String)request.getSession().getAttribute("id_email");
		
		//regEmail : 학원관리자 등록을 요청한 사용자의 이메일
		String regEmail = request.getParameter("regEmail");
		
		//학원이름
		String acaName = request.getParameter("acaName");
		//confirm_date 값 변경 기준 flag
		int flag = Integer.parseInt(request.getParameter("flag"));	
		int result = 0;
		
		System.out.println(regEmail);
		System.out.println(flag);
		
		//==========1. academy_register에서 승인(confirm_date 변경)
		AcademyRegisterDAO arDAO = new AcademyRegisterDAO();
		result = 0;
		result = arDAO.changeConfirmDate(regEmail, flag);
		if(result == 0){
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('failed changeConfirmDate');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}	
				
		//==========2. member 테이블 mem_admin 컬럼 값 변경=============================
		MemberDAO memDAO = new MemberDAO();		
		result = 0;
		result = memDAO.changeAdmin(regEmail, flag);
		if(result == 0){
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('failed changeAdmin');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}	
				
		
		
		//=============3. academy 테이블 mem_email 컬럼 값 변경=================		
		AcademyBean acaVO = new AcademyBean();
		acaVO.setMem_email(regEmail);
		acaVO.setAcaName(acaName);
		
		AcademyDAO acaDAO = new AcademyDAO();
		result = 0;
		result = acaDAO.changeAcademyEmail(acaVO, flag);
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
			//out.println("location.href = './4index.jsp?center=O_admin/register_reqManagement.jsp';");
			out.println("location.href='./registerGetList.areg';");
			out.println("</script>");
			out.close();
			return null;
		}	
	}

}
