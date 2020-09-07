package mango.academy_review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.academy_review.db.AcademyReviewBean;
import mango.academy_review.db.AcademyReviewDAO;
import mango.action.Action;
import mango.action.ActionForward;

// 후기 수정
public class AcaReviewUpdateAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int acaMainNum = Integer.parseInt(request.getParameter("acaMainNum"));
		int reviewNum = Integer.parseInt(request.getParameter("reviewNum"));
		System.out.println("mainNum : " + acaMainNum);
		System.out.println("reviewNum : " + reviewNum);
		
		AcademyReviewBean bean = new AcademyReviewBean();
		
		bean.setMemEmail(request.getParameter("mem_email"));
		bean.setAcaMainNum(acaMainNum);
		bean.setReviewNum(reviewNum);
		bean.setReviewSubject(request.getParameter("review_subject"));
		bean.setReviewTitle(request.getParameter("review_title"));
		bean.setReviewGood(request.getParameter("review_good"));
		bean.setReviewBad(request.getParameter("review_bad"));
		bean.setReviewScore(Integer.parseInt(request.getParameter("review_score")));
		
		AcademyReviewDAO rdao = new AcademyReviewDAO();
		
		// 학원후기 작성
		rdao.UpdateAcademyReview(bean);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("AcademyContentAction.aca?acaMainNum="+acaMainNum+"&pageNum=1");
		
		
		return forward;
	}

	
	
}
