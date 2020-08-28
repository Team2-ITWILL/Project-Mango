package mango.payment.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mango.action.Action;
import mango.action.ActionForward;
import mango.payment.db.PayMentDAO;
import mango.payment.db.PaymentBean;


public class NewGetPayMentAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		PayMentDAO pdao = new PayMentDAO();
		PaymentBean pbean=new PaymentBean();
		
		pbean.setMemEmail(request.getParameter("email"));
		
		System.out.println("email 확인 :"+pbean.getMemEmail());
		
		
		PaymentBean pb=pdao.getNewPayment(pbean);
		
		System.out.println("이용권 확인"+pb.getPmName());
		
		HttpSession session =request.getSession();
		
		request.setAttribute("newName", pb);
		
		ActionForward af = new ActionForward();
		
		 
		af.setPath("./MainPayMent.pay");
		af.setRedirect(false);
		
		return af;
	
	
	}

}
