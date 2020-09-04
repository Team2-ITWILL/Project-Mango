package mango.payment.action;

import java.io.PrintWriter;

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
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		PayMentDAO pdao = new PayMentDAO();
		PaymentBean pbean=new PaymentBean();
		
		pbean.setMemEmail(request.getParameter("email"));
		
		System.out.println("email 확인 :"+pbean.getMemEmail());
		
		
		PaymentBean pb=pdao.getNewPayment(pbean);
		
		System.out.println("이용권 확인 :"+pb.getPmName());
	
		
		out.print(pb.getPmName());
		
		
		 

		return null;
	
	
	}

}
