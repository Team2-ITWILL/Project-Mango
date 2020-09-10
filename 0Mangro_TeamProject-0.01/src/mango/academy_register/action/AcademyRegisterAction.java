package mango.academy_register.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.academy.db.AcademyBean;
import mango.academy.db.AcademyDAO;
import mango.academy_register.db.AcademyRegisterBean;
import mango.academy_register.db.AcademyRegisterDAO;
import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberDAO;

public class AcademyRegisterAction implements Action{

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
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		AcademyRegisterDAO dao = new AcademyRegisterDAO();
		
		//---------------학원관리자 계정인지 확인(임시)-------------------------//
		//---------------학원관리자 승인 페이지 만들게되면 삭제-----------------//
		/*int isAdmin = dao.CheckAdminUser(email);
		System.out.println("isAdmin : " + isAdmin);
		if(isAdmin == 0){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			
			out.println("<script>");
			out.println("alert('학원 관리자가 아닙니다!');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}*/
		
	
		//--------------DB에 학원관리자정보가 등록되어있는지 확인---------------------//
		
		int exists = dao.CheckDataExists(email);
		//DB에 데이터가 존재할 경우 등록 진행 불가
		if(exists == 1){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			
			out.println("<script>");
			out.println("alert('DB에 등록된 정보가 있습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}	
		
		
		//------------DB에 등록된 데이터가 없을경우 등록 진행-----------------//	
		int result = 0;
		
		//=============1. academy_register 테이블에 등록==========================
		String addr_zip = request.getParameter("addr_zip");
		String addr_doro = request.getParameter("addr_doro");
		String acaName = request.getParameter("acaName");		
		
		String fNameCompany = request.getParameter("fNameCompany");		
		String f_size_company = request.getParameter("f_size_company");	
		
		String fNameOwner = request.getParameter("fNameOwner");
		String f_size_owner = request.getParameter("f_size_owner");		
		
		String keyword = request.getParameter("keyword");
		
		AcademyRegisterBean bean = new AcademyRegisterBean();
		bean.setMemEmail(email);
		bean.setMemAddrZip(addr_zip);
		bean.setMemAddrDoro(addr_doro);
		bean.setAcaName(acaName);		
		bean.setfNameCompany(fNameCompany);
		bean.setfNameOwner(fNameOwner);		
		bean.setfSizeCompany(f_size_company);
		bean.setfSizeOwner(f_size_owner);		
		bean.setAca_keyword(keyword);
		
		//result 초기화
		result = 0;
		result = dao.RegisterToDB(bean);		
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
		
		//=============아래 코드들은 AcademyRegisterApproveAction에서 수행======================
		
		//==========2. member 테이블 mem_admin 컬럼 값 변경=============================
		/*
		MemberDAO memDAO = new MemberDAO();
		result = 0;
		result = memDAO.changeAdmin(email);
		if(result == 0){
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('failed');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}	
		*/
		
		//=============3. academy 테이블 mem_email 컬럼 값 변경=================	
		/*
		AcademyBean acaVO = new AcademyBean();
		acaVO.setMem_email(email);
		acaVO.setAcaName(acaName);
		
		AcademyDAO acaDAO = new AcademyDAO();
		result = 0;
		result = acaDAO.changeAcademyEmail(acaVO);
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
		*/
	}

	
}
