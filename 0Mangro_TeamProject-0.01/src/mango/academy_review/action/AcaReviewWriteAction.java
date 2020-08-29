package mango.academy_review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;

public class AcaReviewWriteAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int acaMainNum = Integer.parseInt(request.getParameter("acaMainNum"));
		
		System.out.println(acaMainNum);
		
		return null;
	}

	
	
}
