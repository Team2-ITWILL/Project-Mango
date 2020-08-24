package mango.academy.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.academy.db.AcademyBean;
import mango.academy.db.AcademyDAO;
import mango.action.Action;
import mango.action.ActionForward;

public class AcademyListAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AcademyDAO dao = new AcademyDAO();
		List<AcademyBean> list = dao.AllAcademyList(1, 20);
		
		request.setAttribute("list", list);		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		//forward.setPath(");
		
		
		return forward;
	}
	
	

}
