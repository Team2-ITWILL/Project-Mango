package mango.payment.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.payment.db.PayMentDAO;
import mango.payment.db.PaymentBean;

public class AdminAllListaciton implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		
		request.setCharacterEncoding("UTF-8");
	
		

		PayMentDAO pmd =new PayMentDAO();
		
		
		
		int count= pmd.getPaymentCount();
		
		
		
		
		
		String pageNum=request.getParameter("pageNum");

		
		
		
		
		int pageSize=10;
		
		if(pageNum == null){
			
			pageNum="1"; 
		
		}
		
		
		System.out.println(count);
		     
		//시작행 번호 구하기
		int currentPage=Integer.parseInt(pageNum);
		
		int startRow =(currentPage-1)*pageSize;
		
		
		List<PaymentBean> PayMentlist =null;
		
		System.out.println("시작페이지" +startRow);  
		
		
		if(count != 0){
			
			PayMentlist = pmd.getadminAllList(startRow,pageSize);
	
		}
		//전체페이지수 구하기
		int pageCount = count/pageSize+(count%pageSize==0?0:1);
		
		// 페이지수 설정
		int pageBlock=5;
		
		//한화면에 보여줄 시작페이지 구하기 1~10 =>1/11~20=>11
		int startPage=((currentPage-1)/pageBlock )*pageBlock+1;
		
		//한 화면에 보여줄끝페이지 구하기
		int endPage =startPage+pageBlock-1;
		
		if(endPage>pageCount){
			
			endPage=pageCount;
			   
		}
		
		
		System.out.println(PayMentlist);
		ActionForward forward = new ActionForward();
		
		request.setAttribute("PayMentlist", PayMentlist);
		request.setAttribute("count", count);
		request.setAttribute("pageNum", pageNum); //String -> Object 저장
		request.setAttribute("pageCount", pageCount);//전체페이지수
		request.setAttribute("pageBlock", pageBlock);//보여줄 페이지 수
		request.setAttribute("startPage", startPage);//스타트페이지수
		request.setAttribute("endPage", endPage);//마지막 페이지수
		request.setAttribute("Page","Management.pay?");
		forward.setRedirect(false);
		forward.setPath("4index.jsp?center=O_admin/payment_management.jsp");
		
		
		
		return forward;
		
		
	}

}
