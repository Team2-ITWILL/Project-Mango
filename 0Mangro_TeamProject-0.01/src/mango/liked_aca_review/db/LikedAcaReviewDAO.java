package mango.liked_aca_review.db;

import java.util.List;

import mango.academy_review.db.AcademyReviewBean;
import mango.connection.db.DBconnection;

public class LikedAcaReviewDAO extends DBconnection implements ILikedAcaReview{
	
	// 후기좋아요 누름
	@Override
	public void LikeAcaReview(LikedAcaReviewBean bean) {
		
		try {
			getConnection();
			sql ="insert into liked_aca_review values (?,?,now())";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getReviewNum());
			pstmt.setString(2, bean.getMemEmail());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("LikeAcaReview()에서 예외 발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
	} // LikeAcaReview() 끝
	
	public int checkLikedReview(String email, int revNum){
		
		int result = 0;
		
		try {
			getConnection();
			sql = "select * from liked_aca_review where mem_email = ? and review_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, revNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				// 좋아요 눌러짐
				result = 1;
			}
		} catch (Exception e) {
			System.out.println("checkLikedReview()에서 예외 발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		return result;
	} // checkLikedReview() 끝
	
	// 좋아요 반환
	@Override
	public int getReviewLikeCount(int revNum) {
		
		int result = 0;
		
		try {
			getConnection();
			sql = "select count(*) from liked_aca_review where review_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, revNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getReviewLike()에서 예외 발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		return result;
	} // getReviewLike() 끝

	// 내가 좋아요 한 후기목록 반환
	@Override
	public List<AcademyReviewBean> MyLikeAcaReview(String email) {

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
	public int UnLikeAcaReview(LikedAcaReviewBean bean) {

		try {
			getConnection();
			sql ="delete from liked_aca_review where review_num = ? and mem_email = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getReviewNum());
			pstmt.setString(2, bean.getMemEmail());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("UnLikeAcaReview()에서 예외 발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		return 0;
	} // UnLikeAcaReview() 끝
	
} // LikedAcaReviewDAO 클래스 끝
