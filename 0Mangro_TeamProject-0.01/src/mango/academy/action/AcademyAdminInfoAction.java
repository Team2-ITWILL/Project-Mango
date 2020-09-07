package mango.academy.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.academy.db.AcademyBean;
import mango.academy.db.AcademyDAO;
import mango.academy_files.db.AcademyFilesBean;
import mango.academy_files.db.AcademyFilesDAO;
import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberDAO;

public class AcademyAdminInfoAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//--------------로그인 여부 확인--------------------//
		request.setCharacterEncoding("utf-8");
		
		String email = (String)request.getSession().getAttribute("id_email");
		
		if(email == null || email.equals("")){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();			
			out.println("<script>");
			out.println("alert('로그인이 필요합니다!');");
			out.println("history.back();");
			out.println("</script>");
			out.close();	
			return null;
		}		
		
		System.out.println(email);
		
		//=========학원 정보 가져오기==============
		AcademyDAO dao = new AcademyDAO();
		AcademyBean vo = dao.getAcademyContent(email);
		
		request.setAttribute("academyVO", vo);		
		System.out.println(vo.toString());	
		
		//=========프로필 이미지 가져오기==============
		MemberDAO mDAO = new MemberDAO();
		String profileImg = mDAO.getProfileImg(email);
		request.setAttribute("profileImg", profileImg);
		
		
		//=========학원 이미지 파일 가져오기=============
		/*
		AcademyFilesDAO afDAO = new AcademyFilesDAO();
		List<AcademyFilesBean> afList = afDAO.getFilesByAcanum(vo.getAcaMainNum());
		request.setAttribute("afList", afList);
		System.out.println(afList);
		*/
		//==========forwarding===============
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_aca_admin_page/aca_admin_revise.jsp");
		
		return forward;
	}

	
}
