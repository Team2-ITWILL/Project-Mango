package mango.audit_request.action;


import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.audit_management.db.AuditManagementBean;
import mango.audit_management.db.AuditManagementDAO;
import mango.audit_request.db.AuditRequestBean;
import mango.audit_request.db.AuditRequestDAO;

public class AuditRequestAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		request.setCharacterEncoding("utf-8");
	
		AuditRequestDAO dao = new AuditRequestDAO();			
		
		AuditRequestBean bean 
		 = new AuditRequestBean(
				 0, //auditNum : Auto Increment				 
				 request.getParameter("mem_email"),				 
				 Integer.parseInt(request.getParameter("aca_num")),
				 request.getParameter("aca_name"),	
				 
				 //★★★★audit_management 테이블의 subject를 fk로 등록하였기 때문에 
				 //과목명이 반드시 일치해야한다!!!	
				 request.getParameter("audit_subject"),	
				 
				 //청강신청일 : 언제 듣고 싶은지
				 LocalDate.parse(request.getParameter("audit_wish_date")),
				 
				 //청강신청일 : 신청 당일 날짜
				 LocalDate.parse(request.getParameter("audit_request_date")),
				 
				 //청강승인일자 : 기본값 NULL
				 null			 
				 );
		
		
		//----------청강신청 가용인원, 가용일 확인-------------
		AuditManagementBean formVO = new AuditManagementBean();
		formVO.setAcaNum(Integer.parseInt(request.getParameter("aca_num")));
		
		AuditManagementDAO amDAO = new AuditManagementDAO();
		List<AuditManagementBean> amList = amDAO.getListAuditMangement(formVO);
		
		//과목 당 청강신청이 들어온 수
		int subCount = dao.getAuditCountOfSubject(request.getParameter("audit_subject"));		
		
		for(AuditManagementBean beanOfList : amList){
			//폼에서 선택한 과목이 학원관리자가 등록한 청강신청 가능 과목 목록에 존재한다면
			if(bean.getAuditSubject().equals(beanOfList.getAuditAvailSubj())){
				//최대 청강신청수에 도달하거나 그 이상이라면
				if(subCount >= beanOfList.getAuditAblemem()){					
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('해당 과목은 더 이상 청강 신청을 할 수 없습니다.');");
					out.println("history.back();");
					out.println("</script>");	
					out.close();			
					return null;
				}
				
				System.out.println(bean.getAuditWishDate());
				System.out.println(beanOfList.getAuditAvailDate());
				
				//희망 신청일이 청강신청 가능일 이후라면 신청 불가
				if(bean.getAuditWishDate().isAfter(beanOfList.getAuditAvailDate())){					
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('더 이전 날짜를 선택해주세요. 청강 가능일은 " + beanOfList.getAuditAvailDate() + "입니다');");
					out.println("history.back();");
					out.println("</script>");	
					out.close();			
					return null;
				}
			}
		}
		
		System.out.println("ㅇㅇㅇㅇ");
		
		//--------------과목 중복신청 확인---------------------
		//한 사람당 동일한 과목 중복 신청 불가
		//폼에서 선택한 청강신청과목이 DB에 존재한다면 중복 -> 청강신청 불가
		int isDuplicated = dao.CheckAuditList(bean);
		System.out.println("isDuplicated : " + isDuplicated);
		if(isDuplicated == 0){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이미 등록한 과목입니다. 다른 과목을 선택하세요.');");
			out.println("history.back();");
			out.println("</script>");	
			out.close();			
			return null;
		}
		
		//------------청강 신청------------------
		//중복신청이 아니라면 청강신청 가능
		int result = dao.InsertAudit(bean);			
		if(result == 0){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('register failed');");
			out.println("history.back();");
			out.println("</script>");	
			out.close();			
			return null;		
		}else{				
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('register success');");	
			out.println("location.href='./4index.jsp'");
			out.println("</script>");				
			out.close();				
			return null;	
		}			
		
		
	}
}
	
	


