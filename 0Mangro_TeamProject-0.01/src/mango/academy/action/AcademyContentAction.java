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
import mango.audit_management.db.AuditManagementBean;
import mango.audit_management.db.AuditManagementDAO;

// 학원 상세페이지 출력
public class AcademyContentAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		int acaMainNum = Integer.parseInt(request.getParameter("acaMainNum"));
		/*String id = (String)request.getSession().getAttribute("userid");*/
		
		// 학원DAO
		AcademyDAO dao = new AcademyDAO();
		
		// 학원후기DAO
		AcademyReviewDAO rdao = new AcademyReviewDAO();
		
		// 학원키워드DAO
		AcademyKeywordDAO akdao = new AcademyKeywordDAO();
		
		// 청강 과목 목록Bean,DAO
		AuditManagementBean auditBean = new AuditManagementBean();
		auditBean.setAcaNum(acaMainNum);
		AuditManagementDAO auditDAO = new AuditManagementDAO();
		
		
		
		// 학원 상세내용
		AcademyBean bean = dao.getAcademyContent(acaMainNum);
		// 학원 후기갯수
		int count = rdao.getAcademyReviewCount(acaMainNum);
		
		// 학원 키워드 목록
		List<AcademyKeywordBean> keyList = null;
		keyList = akdao.getAcademyKeyword(acaMainNum);
		
		// 평균점수 (소숫점 한자리)
		double avgScore = 
				Double.parseDouble(String.format("%.1f",rdao.getAvgReviewScore(acaMainNum)));
		
		// 청강목록받기
		List<AuditManagementBean> auditList = null;
		auditList = auditDAO.getListAuditMangement(auditBean);
		
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
		
		
		// 학원 후기 목록 받아오기
		if(count != 0){
			reList = rdao.getAcademyReviewList(acaMainNum,startRow,pageSize);
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
		request.setAttribute("auditList", auditList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_academy/academy_single.jsp");
		
		return forward;
	}

}