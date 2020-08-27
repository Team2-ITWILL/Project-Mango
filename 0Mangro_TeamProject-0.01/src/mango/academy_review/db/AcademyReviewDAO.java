package mango.academy_review.db;

import java.util.ArrayList;
import java.util.List;

import mango.connection.db.DBconnection;

public class AcademyReviewDAO extends DBconnection implements IAcademyReview{
	
	
	// 학원후기갯수 반환
	@Override
	public int getAcademyReviewCount(int acaMainNum) {
		int result = 0;
		try {
			getConnection();
			sql = "select count(*) from academy_review where aca_main_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, acaMainNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println("getAcademyReviewCount()에서 예외발생");
			e.printStackTrace();
		}
		
		return result;
	} // getAcademyReviewCount() 끝

	
	// 학원후기 목록반환
	@Override
	public List<AcademyReviewBean> getAcademyReviewList(int acaMainNum, int startRow,int pageSize) {
		List<AcademyReviewBean> reviewList = new ArrayList<AcademyReviewBean>();
		
		try {
			getConnection();
			sql = "select * from academy_review where aca_main_num = ? order by review_num desc limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, acaMainNum);
			pstmt.setInt(2, startRow-1);
			pstmt.setInt(3, pageSize);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				AcademyReviewBean arBean = new AcademyReviewBean();
				arBean.setReviewNum(rs.getInt(1));
				arBean.setAcaMainNum(rs.getInt(2));
				arBean.setAcaName(rs.getString(3));
				arBean.setReviewTitle(rs.getString(4));
				arBean.setReviewGood(rs.getString(5));
				arBean.setReviewBad(rs.getString(6));
				arBean.setReviewSubject(rs.getString(7));
				arBean.setReviewScore(rs.getInt(8));
				arBean.setMemEmail(rs.getString(9));
				arBean.setReviewDate( rs.getString(10).substring(0, 10));
				reviewList.add(arBean);
			}
		} catch (Exception e) {
			System.out.println("getAcademyReviewList()에서 예외 발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		return reviewList;
	} // getAcademyReviewList() 끝
	
	
	// 평균 후기점수 반환
	public double getAvgReviewScore(int acaMainNum){
		double result = 0;
		
		try {
			getConnection();
			sql = "select avg(review_score) from academy_review group by aca_main_num having aca_main_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, acaMainNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result = rs.getDouble(1);
			}
			
		} catch (Exception e) {
			System.out.println("getAvgReviewScore()에서 예외발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		return result;
	} // getAvgReviewScore() 끝
	
	@Override
	public int InsertAcademyReview(AcademyReviewBean ab) {
		
		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("InsertAcademyReview()에서 예외발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		
		return 0;
	} // InsertAcademyReview() 끝

	@Override
	public int DeleteAcademyReview(int reviewNum) {
		
		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("DeleteAcademyReview()에서 예외발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		
		return 0;
	} // DeleteAcademyReview()끝

	@Override
	public int UpdateAcademyReview(AcademyReviewBean ab) {

		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("UpdateAcademyReview()에서 예외발생");	
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		return 0;
	} //UpdateAcademyReview() 끝

	
} // AcademyReviewDAO 클래스 끝
