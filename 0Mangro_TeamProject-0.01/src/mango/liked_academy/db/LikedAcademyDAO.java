package mango.liked_academy.db;

import java.util.ArrayList;
import java.util.List;

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
	
	// 학원후기갯수 반환
	public int getLikeAcademyCount(String mem_email) {
		int result = 0;
		try {
			getConnection();
			sql = "select count(*) from liked_academy where mem_email = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_email);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println("getLikeAcademyCount()에서 예외발생");
			e.printStackTrace();
		}  finally {
			resourceClose();
		}
		
		return result;
	} // getLikeAcademyCount() 끝
	
	// 내가 좋아요한 학원 번호리스트
	public List<Integer> likedAcaNumList(String mem_email, int startRow,int pageSize){
		
		List<Integer> amNumList = new ArrayList<Integer>();
		
		try {
			getConnection();
			sql ="select aca_main_num from liked_academy where mem_email = ? "
					+ "order by liked_aca_date desc limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_email);
			pstmt.setInt(2, startRow-1);
			pstmt.setInt(3, pageSize);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				amNumList.add(rs.getInt(1));
			}
			
		} catch (Exception e) {
			System.out.println("likedAcaNumList()에서 예외 발생 ㅋ.ㅋ");
			e.printStackTrace();
		}  finally {
			resourceClose();
		}
		
		return amNumList;
		
	} // likedAcaNumList() 끝
	
	
} // LikedAcademyDAO class 끝




