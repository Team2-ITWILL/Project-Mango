package mango.payment.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mango.action.Action;
import mango.action.ActionForward;
import mango.payment.db.PayMentDAO;
import mango.payment.db.PaymentBean;

public class ListMypayMentaciton implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		PayMentDAO dao = new PayMentDAO();//dao생성
		
		String email=request.getParameter("email");//email 리퀘스트영역에서 꺼낸다음
		
		
		System.out.println(email);
		PaymentBean pb = new PaymentBean();//paymentBean생성
		
		pb.setMemEmail(email);
		
		JSONArray jdao=dao.getListMyPayMent(pb);
	
		
		ActionForward forward =new ActionForward();
		
		JSONObject jo = new JSONObject();
//		forward.setRedirect(false);
//		forward.setPath("4index.jsp?center=O_payment/payment_list.jsp");
//		
		
		
		jo.put("MyPay", jdao);
		
		out.print(jo);
		
		
		
		return null;

	}

}
