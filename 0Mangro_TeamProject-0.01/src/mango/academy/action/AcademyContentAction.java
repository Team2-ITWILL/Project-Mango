package mango.academy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.academy.db.AcademyBean;
import mango.academy.db.AcademyDAO;
import mango.action.Action;
import mango.action.ActionForward;

public class AcademyContentAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int boardNum = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		AcademyDAO dao = new AcademyDAO();
		
		AcademyBean bean = dao.getAcademyContent(boardNum);
		
		request.setAttribute("academyBean", bean);
		request.setAttribute("pageNum", pageNum);;
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_academy/academy_single.jsp");
		
		return forward;
	}

}
