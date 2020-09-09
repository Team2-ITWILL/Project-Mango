package mango.member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.member.db.MemberDAO;

public class MemberManagementAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("MemberManagementAction 이동");
		
		request.setCharacterEncoding("UTF-8");
		
		MemberDAO mdao = new MemberDAO();
		int count = mdao.getMGCount();
		
		
/* ------------------------- 페이징 처리  --------------------------- */
		String pageNum = request.getParameter("pageNum");
		
		int pageSize = 10; // 10페이지까지
		
		if(pageNum == null){
			pageNum="1"; 
		}
		
		System.out.println(count);
		     
		// 현재 페이지
		int currentPage = Integer.parseInt(pageNum);
		
		// 시작 행 번호 구하기
		int startRow = (currentPage - 1) * pageSize;

		List memberlist = null;

		System.out.println("시작페이지 : " +startRow);  
		
		if(count != 0){
			memberlist = mdao.ListAll(startRow,pageSize);
		}

		// 전체 페이지 수
		int pageCount = count / pageSize + (count % pageSize == 0?0:1);
		
		// 페이지 수
		int pageBlock = 5;
		
		// 한 화면에 보여줄 시작페이지 구하기 
		int startPage = ((currentPage - 1) / pageBlock ) * pageBlock + 1;
		
		// 한 화면에 보여줄 끝페이지 구하기
		int endPage = startPage + pageBlock - 1;
		
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		ActionForward forward = new ActionForward();
		
		request.setAttribute("memberlist", memberlist);
		request.setAttribute("count", count);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount); // 전체 페이지 수
		request.setAttribute("pageBlock", pageBlock); // 보여줄 페이지 수
		request.setAttribute("startPage", startPage); // 스타트 페이지수
		request.setAttribute("endPage", endPage); // 마지막 페이지 수
		request.setAttribute("currentPage", currentPage); // 현재 페이지 수
		request.setAttribute("Page","MemberManagementAction.me?");

		forward.setRedirect(false);
		forward.setPath("./MemberManagement.me");
		
		return forward;
	}

}
