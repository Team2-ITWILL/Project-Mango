package mango.academy_review.action;

import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import mango.academy.db.AcademyDAO;
import mango.academy_review.db.AcademyReviewBean;
import mango.academy_review.db.AcademyReviewDAO;
import mango.action.Action;
import mango.action.ActionForward;


// 내가 쓴 후기 목록
public class myReviewListAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		String mem_email = (String) session.getAttribute("id_email");
		
		
		request.setCharacterEncoding("utf-8");
		
		
		// 학원DAO
		AcademyDAO dao = new AcademyDAO();
		
		// 후기 DAO
		AcademyReviewDAO rdao = new AcademyReviewDAO();
		
		
		
		

		//  한 페이지에 4개 글 목록 반환
		int pageSize = 10;
		
		// 페이지 가져오기 
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null){
			pageNum="1";
		}
		
		// 시작행번호 구하기 1페이지  1번행   2p  5번행   3p  9번행
		int currentPage=Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*pageSize+1;
		
		// 끝행번호
		int endRow=currentPage*pageSize;
		
		// 내가 쓴 후기 리스트반환
		List<AcademyReviewBean> revList = rdao.getAcademyReviewList(mem_email, startRow, pageSize);
		
		// 내가 쓴 후기 갯수
		int count = revList.size();
		
		
		
		
		//전체 페이지 수 구하기
		int pageCount =count/pageSize+(count%pageSize==0?0:1);
		//한화면에 보여줄 페이지수 설정
		int pageBlock=3;
		// 한화면에 보여줄 시작페이지 구하기  1~10  => 1  /  11~20 => 11
		int startPage=((currentPage-1)/pageBlock)*pageBlock+1;
		// 한화면에 보여줄 끝페이지 구하기
		int endPage=startPage+pageBlock-1;
		if(endPage > pageCount){
			endPage = pageCount;
		}
		System.out.println(startPage);
		System.out.println(endPage);
		
		request.setAttribute("count", count); //모든속성저장 Integer -> Object형저장
		request.setAttribute("revList", revList); // List -> Object 저장
		request.setAttribute("pageNum", pageNum); //String -> Object 저장
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_mypage/my_academy_review.jsp");
		
		return forward;
	}

}