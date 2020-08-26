package mango.academy.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.academy.db.AcademyBean;
import mango.academy.db.AcademyDAO;
import mango.academy_keyword.db.AcademyKeywordBean;
import mango.academy_keyword.db.AcademyKeywordDAO;
import mango.academy_review.db.AcademyReviewBean;
import mango.academy_review.db.AcademyReviewDAO;
import mango.action.Action;
import mango.action.ActionForward;

public class AcademyContentAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		int boardNum = Integer.parseInt(request.getParameter("num"));
		/*String id = (String)request.getSession().getAttribute("userid");*/
		
		
		// 학원DAO
		AcademyDAO dao = new AcademyDAO();
		// 학원조아DAO
		
		// 학원후기DAO
		AcademyReviewDAO rdao = new AcademyReviewDAO();
		// 후기좋아요DAO
		
		// 학원키워드DAO
		AcademyKeywordDAO akdao = new AcademyKeywordDAO();
		
		
		AcademyBean bean = dao.getAcademyContent(boardNum);
		int count = rdao.getAcademyReviewCount(boardNum);
		List<AcademyKeywordBean> keyList = null;
		keyList = akdao.getAcademyKeyword(boardNum);
		for(int i=0;i<keyList.size();i++){
			
		}
		
		double avgScore = 
				Double.parseDouble(String.format("%.1f",rdao.getAvgReviewScore(boardNum)));

		System.out.println(avgScore);
		//  한 페이지에 4개 글 목록 반환
		int pageSize = 4;
		
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
		List<AcademyReviewBean> reList = null;
		
		if(count != 0){
			reList = rdao.getAcademyReviewList(boardNum,startRow,pageSize);
		}
		
		//전체 페이지 수 구하기
		int pageCount =count/pageSize+(count%pageSize==0?0:1);
		//한화면에 보여줄 페이지수 설정
		int pageBlock=3;
		// 한화면에 보여줄 시작페이지 구하기  1~4  => 1  /  5~8 => 5
		int startPage=((currentPage-1)/pageBlock)*pageBlock+1;
		// 한화면에 보여줄 끝페이지 구하기
		int endPage=startPage+pageBlock-1;
		if(endPage > pageCount){
			endPage = pageCount;
		}
		int iAvgScore = (int)avgScore;
		System.out.println(iAvgScore);
		
		request.setAttribute("academyBean", bean);
		request.setAttribute("count", count); //모든속성저장 Integer -> Object형저장
		request.setAttribute("reList", reList); // List -> Object 저장
		request.setAttribute("pageNum", pageNum); //String -> Object 저장
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("avgScore", avgScore);
		request.setAttribute("iAvgScore", iAvgScore);
		request.setAttribute("keyList", keyList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_academy/academy_single.jsp");
		
		return forward;
	}

}
