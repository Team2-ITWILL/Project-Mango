package mango.payment.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.payment.db.PayMentDAO;

public class CheckPayIdaction implements Action{

	
	
	
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		request.setCharacterEncoding("UTF-8");
		
		PayMentDAO pdao = new PayMentDAO();
		
	
		int check=pdao.checkPayId();
		
		
		
		
		
		
		return null;
	}

	
	
	
	
}
