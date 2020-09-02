package mango.comment_anony_board.db;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import mango.anony_board.db.AnonyBoardDAO;
import mango.connection.db.DBconnection;

public class CommentAnonyBoardDAO extends DBconnection{

	AnonyBoardDAO andao = new AnonyBoardDAO();
	
	// [INSERT 댓글 저장 메소드] : CommentAnoBoardInsertAction에서 호출
	public void insertCommANBoard(CommentAnonyBoardBean commBean){
		int ano_comment_num = 0;
		
		// 댓글번호 증가 작업
		try {
			getConnection();
			sql = "SELECT max(ano_comment_num) FROM comment_anony_board";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){ // 테이블에 댓글이 있다면 +1
				ano_comment_num = rs.getInt(1)+1; 
			}else { // 테이블에 댓글이 없다면 1부터 시작
				ano_comment_num = 1; 
			}
			
			
		} catch (Exception e) {
			System.out.println(" insertCommANBoard()메소드에서 예외 발생 : "+ e);				
			e.printStackTrace();
		}
		
		
		
		// 댓글 1개의 정보 db insert 작업
		try{
			sql = "INSERT INTO comment_anony_board "
				 + "(ano_comment_num, " 
				 + "ano_board_num, "
				 + "ano_comment_content, " 
				 + "mem_email, "
				 + "ano_re_ref, "
				 + "ano_re_lev, "
				 + "ano_re_seq, "
				 + "ano_comment_date, "
				 + "ano_comment_ip, "
				 + "ano_board_nick) "
				 + "VALUES(?,?,?,?,?,?,?,now(),?,?) "; 
			
			
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, ano_comment_num);
		pstmt.setInt(2, commBean.getAno_board_num());
		pstmt.setString(3, commBean.getAno_comment_content() );
		pstmt.setString(4, commBean.getMem_email());
		pstmt.setInt(5, 0); // re_ref 부모댓글번호
		pstmt.setInt(6, 0); // re_lev 들여쓰기값
		pstmt.setInt(7, 0); // re_seq 부모댓글 내 순번
		
		pstmt.setString(8, commBean.getAno_comment_ip());
		
		// 댓글 닉네임 생성을 위해 AnonyBoardDAO의 getRandomNickname() 사용
		AnonyBoardDAO andao = new AnonyBoardDAO();
		pstmt.setString(9, andao.getRandomNickname()); 
		
		
		pstmt.executeUpdate();
		
		}catch(Exception e){
			System.out.println("insertCommANBoard()메소드 두번째 쿼리에서 예외 발생 : "+ e);				
			e.printStackTrace();
		}finally { resourceClose();}
		
		
	}//insertCommANBoard()
	

	
	// [UPDATE 댓글 수정 메소드]
	public void updateCommANBoard(CommentAnonyBoardBean commBean){

		try {
			getConnection();
			
			sql = "UPDATE comment_anony_board "
				+ "SET ano_comment_content=? "
				+ "WHERE ano_comment_num=?";
			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, commBean.getAno_comment_content());
			pstmt.setInt(2, commBean.getAno_comment_num());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updateComment()메소드에서 sql예외 "+e);
		} catch (Exception e) {
			System.out.println("updateComment()메소드에서 예외 "+e);
		} finally { resourceClose(); }
		
		
	}//updateCommANBoard()	
	
	
	
	
	// [DELETE 댓글 삭제 메소드] : CommentAnoBoardDeleteAction에서 호출
	
	public void deleteCommANBoard(int ano_comment_num){
		
		try {
			getConnection();
					
			sql = "DELETE FROM comment_anony_board  "
				+ "WHERE ano_comment_num=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ano_comment_num);
			
			pstmt.executeUpdate();
					
			
		} catch (Exception e) {
			System.out.println("deleteCommANBoard()메소드에서 예외 발생 : "+ e);
			e.printStackTrace();
			
		} finally {
			resourceClose();
		}//try~catch 끝
		
				
		
	}//deleteCommANBoard()
		
	
	

	
	
	
	// [SELECT 해당 글 번호의 모든 댓글 정보를 가져오는 메소드] : GetAllCommentsAnoBoardAction에서 호출
	public List<CommentAnonyBoardBean> getAllCommentsANBoard(int ano_board_num){
		
		List<CommentAnonyBoardBean> commentList = new ArrayList<CommentAnonyBoardBean>();
		
		
		try {
			getConnection();
			
			sql = "SELECT * FROM comment_anony_board "
				+ "WHERE ano_board_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ano_board_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				// 댓글1개의 정보를 저장할 commBean 객체 생성
				CommentAnonyBoardBean commBean = new CommentAnonyBoardBean();
				
				commBean.setAno_comment_num(rs.getInt("ano_comment_num"));
				commBean.setAno_comment_content(rs.getString("ano_comment_content"));
				commBean.setMem_email(rs.getString("mem_email"));;
				commBean.setAno_re_ref(rs.getInt("ano_re_ref"));
				commBean.setAno_re_lev(rs.getInt("ano_re_lev"));
				commBean.setAno_re_seq(rs.getInt("ano_re_seq"));
				commBean.setAno_board_nick(rs.getString("ano_board_nick"));
				commBean.setAno_comment_date(rs.getTimestamp("ano_comment_date"));
				
				// commBean객체 1개를 List객체 commentList에 담기 
				commentList.add(commBean);
				//-------------------------
				
			}//if
		} catch (SQLException e) {
			System.out.println("getSingleComment()메소드에서 sql예외 발생 : "+ e);
			
		} catch (Exception e) {
			System.out.println("getSingleComment()메소드에서 예외 발생 : "+ e);
		} finally {
			resourceClose();
		}
		
		// 특정 게시글의 전체 댓글 정보가 담긴 List형태의 commentList 객체 리턴
		return commentList;
		
		
	}//getSingleCommANBoard()
	
	
	// [전체 코멘트 개수를 int로 반환하는 메소드]
	public int getCountANBComments(int ano_board_num){
		int comm_count = 0;
		
		try {
			getConnection();
			
			sql="SELECT count(*) FROM comment_anony_board "
			   +"WHERE ano_board_num = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ano_board_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				comm_count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println("getCountComments()메소드에서 예외발생"+e);
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		return comm_count;
	}//getCountComments()
	
	
	

	
}//CommentAnonyBoardDAO