package mango.liked_academy.db;

import mango.connection.db.DBconnection;

public class LikedAcademyDAO extends DBconnection{
	
	// 학원좋아요 여부확인
	public int checkLikeAca(LikedAcademyBean bean){
		
		int check = 0;
		
		try {
			getConnection();
			sql = "select * from liked_academy where mem_email = ? and aca_main_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getMemEmail());
			pstmt.setInt(2, bean.getAcaMainNum());
			rs = pstmt.executeQuery();
			
			// 좋아요가 눌러져있다면 1 반환
			if(rs.next()){
				check = 1;
			}
			
			
		} catch (Exception e) {
			System.out.println("checkLikeAca()에서 예외 발생 ㅋ.ㅋ");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		return check;
		
	} // checkLikeAca() 끝
	
	// 학원좋아요
	public void likeAca(LikedAcademyBean bean){
		
		try {
			getConnection();
			sql = "insert into liked_academy values (?, ? , ?, now())";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getMemEmail());
			pstmt.setInt(2, bean.getAcaMainNum());
			pstmt.setString(3, bean.getAcaName());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("likeAca()에서 예외 발생 ㅋ.ㅋ");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
	} // likeAca() 끝
	
	// 학원좋아요 취소
	public void unlikeAca(LikedAcademyBean bean){
		
		try {
			getConnection();
			sql = "delete from liked_academy where mem_email = ? and aca_main_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getMemEmail());
			pstmt.setInt(2, bean.getAcaMainNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("unlikeAca()에서 예외 발생 ㅋ.ㅋ");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		
	} // unlikeAca() 끝
	
	
	
} // LikedAcademyDAO class 끝




