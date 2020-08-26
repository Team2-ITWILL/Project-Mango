package mango.liked_aca_review.db;

import java.util.List;

import mango.academy_review.db.AcademyReviewBean;
import mango.connection.db.DBconnection;

public class LikedAcaReviewDAO extends DBconnection implements ILikedAcaReview{
	
	// 후기좋아요 누름
	@Override
	public void LikeAcaReview(LikedAcaReviewBean like) {
		
		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("LikeAcaReview()에서 예외 발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
	} // LikeAcaReview() 끝
	
	// 좋아요 반환
	@Override
	public int getReviewLike(LikedAcaReviewBean like) {
		
		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("getReviewLike()에서 예외 발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		return 0;
	} // getReviewLike() 끝

	// 내가 좋아요 한 후기목록 반환
	@Override
	public List<AcademyReviewBean> MyLikeAcaReview(LikedAcaReviewBean review) {

		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("MyLikeAcaReview()에서 예외 발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		return null;
	} // MyLikeAcaReview() 끝
	
	// 좋아요 취소
	@Override
	public int UnLikeAcaReview(LikedAcaReviewBean review) {

		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("UnLikeAcaReview()에서 예외 발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		return 0;
	} // UnLikeAcaReview() 끝
	
} // LikedAcaReviewDAO 클래스 끝
