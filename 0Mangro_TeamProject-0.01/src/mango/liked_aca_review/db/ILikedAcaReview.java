package mango.liked_aca_review.db;

import java.util.List;

import mango.academy_review.db.AcademyReviewBean;
import mango.member.db.MemberBean;
 
public interface ILikedAcaReview {
	
	
	//리뷰 좋아요 실행 메서드
	public void LikeAcaReview(LikedAcaReviewBean bean);
	
	//각 글 마다 해당 좋아요 갯수를 갖고오는 메서드
	public int getReviewLikeCount(int revNum);
	
	//자신이 좋아요 한 리뷰 리스트를 갖고오는 메서드
	public List<AcademyReviewBean> MyLikeAcaReview(String email);
	
	//리뷰 좋아요 취소 메서드 
	public int UnLikeAcaReview(LikedAcaReviewBean bean);

	
	
	
}
