
package mango.payment.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.payment.db.PayMentDAO;
import mango.payment.db.PaymentBean;


public class InsertPaymentAction implements Action{

	
	
	
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		
		int money =Integer.parseInt(request.getParameter("money"));
		int day=0;
		
		
		PaymentBean pb =new PaymentBean();
		
		pb.setMemEmail(request.getParameter("email"));
		pb.setPmName(request.getParameter("option"));
		pb.setPmCheck("O");
		
		if(money ==7900){
			day=30;
		}else if(money ==12900){
			day=90;
		}
		
		
		System.out.println("여기까지");
		
		PayMentDAO pdao = new PayMentDAO();
		
		int check=pdao.InsertPayment(pb,day);
	
		ActionForward actionForward = new ActionForward(); 
		
		if(check == 1){
			
			System.out.println("여기까지 왔나요??");
			actionForward.setRedirect(true);
			out.print(check);
	
		
		}else{
			out.print(check);
			actionForward.setRedirect(true);
			
			
		}
		
	
		return null;
		

	}

	
	
	

	
}

