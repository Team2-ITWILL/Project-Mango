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
		} finally {
			resourceClose();
		}
		
		return result;
	} // getAcademyReviewCount() 끝

	
	// 학원후기 목록반환 (학원 상세보기)
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
	
	
	// 학원 후기 작성
	@Override
	public void InsertAcademyReview(AcademyReviewBean ab) {
		// review_num
		int num = 0;
		
		try {
			getConnection();
			sql = "select max(review_num) from academy_review";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				// review_num 구하기
				num =rs.getInt(1) +1;
			}
			System.out.println("review_num : "+num);
			sql = "insert into academy_review (review_num, aca_main_num, aca_name, review_title, "
					+ "review_good, review_bad, review_subject, "
					+ "review_score, mem_email, review_date) "
					+ "values (?,?,?,?,?,?,?,?,?,now())";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, ab.getAcaMainNum());
			pstmt.setString(3, ab.getAcaName());
			pstmt.setString(4, ab.getReviewTitle());
			pstmt.setString(5, ab.getReviewGood());
			pstmt.setString(6, ab.getReviewBad());
			pstmt.setString(7, ab.getReviewSubject());
			pstmt.setInt(8, ab.getReviewScore());
			pstmt.setString(9, ab.getMemEmail());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("InsertAcademyReview()에서 예외발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		
	} // InsertAcademyReview() 끝
	
	// 학원 후기 삭제
	@Override
	public int DeleteAcademyReview(int reviewNum) {
		
		try {
			getConnection();
			sql = "delete from academy_review where review_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reviewNum);
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("DeleteAcademyReview()에서 예외발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		return 0;
		
	} // DeleteAcademyReview()끝
	
	// 후기 수정
	@Override
	public void UpdateAcademyReview(AcademyReviewBean ab) {

		try {
			getConnection();
			sql = "update academy_review set review_title = ?, review_good = ?, "
					+ "review_bad = ?, review_subject = ?, review_score = ?, "
					+ "review_date = now() where review_num = ? and aca_main_num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ab.getReviewTitle());
			pstmt.setString(2, ab.getReviewGood());
			pstmt.setString(3, ab.getReviewBad());
			pstmt.setString(4, ab.getReviewSubject());
			pstmt.setInt(5, ab.getReviewScore());
			pstmt.setInt(6, ab.getReviewNum());
			pstmt.setInt(7, ab.getAcaMainNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("UpdateAcademyReview()에서 예외발생");	
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
	} //UpdateAcademyReview() 끝
	
	/* 메인 학원 후기 3개 반환 */
	
	// 학원 이름
	public String getAcaNameTop(int rank){
		
		String acaName = ""; 
		
		try {
			getConnection();
			sql = "select aca_name from academy_review group by aca_main_num "
					+ "having count(*) > 1 order by avg(review_score) desc, count(*) desc limit ?,1";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rank);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				acaName = rs.getString(1);
			}
			
		} catch (Exception e) {
			System.out.println("getAcaNameTop()에서 예외발생");	
			e.printStackTrace();
		}  finally {
			resourceClose();
		}
		
		
		return acaName;
	} // getAcaNameTop() 끝
	
	// 학원 번호
	public int getAcaMainNumTop(String acaName){
		
		int acaMainNum = 0; 
		
		try {
			getConnection();
			sql = "select aca_main_num from academy_review where aca_name = ? limit 1;";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, acaName);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				acaMainNum = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println("getAcaMainNumTop()에서 예외발생");	
			e.printStackTrace();
		}  finally {
			resourceClose();
		}
		
		
		return acaMainNum;
	} // getAcaNameTop() 끝
	
	// 후기 갯수
	public int getReviewCntTop(String acaName){
		
		int count = 0; 
		
		try {
			getConnection();
			sql = "select count(*) from academy_review where aca_name = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, acaName);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println("getReviewCntTop()에서 예외발생");	
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		
		return count;
	} // getReviewCntTop() 끝
	
	// 후기 갯수
	public double getAvgScoreTop(int acaMainNum){
		
		double score = 0.0; 
		
		try {
			getConnection();
			sql = "select avg(review_score) from academy_review group by aca_main_num having aca_main_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, acaMainNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				score = rs.getDouble(1);
			}
			
		} catch (Exception e) {
			System.out.println("getAvgScoreTop()에서 예외발생");	
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		
		return score;
	} // getAvgScoreTop() 끝
	
	// 제목 두개 받아오기
	public List<String> getReviewTitle(String acaName){
		
		List<String> titleList = new ArrayList<String>();
		
		try {
			getConnection();
			sql = "select review_title from academy_review "
					+ "where aca_name = ? order by review_score desc limit 0,2;";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, acaName);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String title = rs.getString(1);
				titleList.add(title);
			}
			
		} catch (Exception e) {
			System.out.println("getReviewTitle()에서 예외발생");	
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		return titleList;
	} // getReviewTitle() 끝
	
	/* 메인 학원 후기 3개 반환 끝 */
	
	// 학원후기 목록반환(내가 쓴 후기목록)
	public List<AcademyReviewBean> getAcademyReviewList(String mem_email, int startRow,int pageSize) {
		List<AcademyReviewBean> reviewList = new ArrayList<AcademyReviewBean>();
		
		try {
			getConnection();
			sql = "select * from academy_review where mem_email = ? order by review_num desc limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_email);
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
	
	// 후기 평점별 갯수
	public int getReviewScoreCnt(int acaMainNum, int score){
		
		int count = 0; 
		
		try {
			getConnection();
			sql = "select count(*) from academy_review where aca_main_num = ? and review_score=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, acaMainNum);
			pstmt.setInt(2, score);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println("getReviewScoreCnt()에서 예외발생");	
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		
		return count;
	} // getReviewScoreCnt() 끝

	
} // AcademyReviewDAO 클래스 끝
