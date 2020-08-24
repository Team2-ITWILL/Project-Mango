package mango.anony_board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;




// 1. 게시판 insert
// 2. 게시판 delete
// 3. 게시글 조회수 증가
// 4. 해당 글 넘버의 글정보 가져오기
public class AnonyBoardDAO {
	// [멤버변수 선언]
	Connection con;
	DataSource ds;
	String sql;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	// [DB연결 공통메소드]
	private Connection getConnection() throws Exception {
		con = null;
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/mango");
		
		con = ds.getConnection();
		
		return con;
		
	}//getConnection()------------------------------------
	
	
	
	
	
	// [공용 자원해제 메소드]
	public void resourceClose(){
		// ResultSet 자원해제
		try{
			if(rs != null) rs.close();
		}catch(Exception e){
			System.out.println("ResultSet 자원해제 중 예외 발생 !");
		}
		
		// PreparedStatement 자원해제
		try{
			if(pstmt != null) pstmt.close();
		}catch(Exception e){
			System.out.println("PreparedStatement 자원해제 중 예외 발생 !");
		}
		
		// Connection 자원해제
		try{
			if(con != null) con.close();
		}catch(Exception e){
			System.out.println("Connection 자원해제 중 예외 발생 !");
		}
		
		
	}//공용 자원해제 메소드 resourceClose()-----------------------------------
	
	
	// [INSERT 게시판 글 저장 메소드]
	public void InsertANBoard(AnonyBoardBean anb){
		
		int num = 0;
		
		try {
			
			sql = "INSERT INTO anony_board "
				 + "(ano_board_num, " 
				 + " mem_email, " 
			+		"ano_board_title, " 
			+		"ano_board_content, "
			+		"ano_board_read, "
			+		"ano_board_date, "
			+		"ano_board_ip) "
			+		"VALUES(?,?,?,?,?,?,?)"; 
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, anb.getAno_board_num()); // 익명사담방 글번호
			pstmt.setString(2, anb.getMem_email());
			pstmt.setString(3, anb.getAno_board_title());
			pstmt.setString(4, anb.getAno_board_content());
			pstmt.setInt(5, anb.getAno_board_read());  // 조회수
			pstmt.setString(6, anb.getAno_board_date());
			pstmt.setString(7, anb.getAno_board_ip());
			
			pstmt.executeUpdate();
			
			
			
		}catch(SQLException se){
			System.out.println("InsertANBoard메소드에서 SQL 예외 발생 : "+ se);				
			
		}catch(Exception e){
			System.out.println("InsertANBoard메소드 쿼리에서 예외 발생 : "+ e);				
			
		}finally {
			resourceClose();
		}
		
		
		
	};
	
	// [조회수 증가메소드]
	public void updateANBoardRead(int ano_board_num){
		try {
			con = getConnection();
			sql = "UPDATE anony_board "
					+ "SET ano_board_read=ano_board_read + 1 "
					+ "WHERE ano_board_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ano_board_num);
			
			pstmt.executeUpdate();
			
		}catch (SQLException se){
			System.out.println("updateANBoardRead메소드에서 SQL 예외 발생 : "+ se);				
			
		}catch (Exception e) {
			System.out.println("updateANBoardRead메소드 쿼리에서 예외 발생 : "+ e);				
			
		} finally {
			resourceClose();
		}
		
		
	}//updateANBoardRead()
	
	
	
	// [게시판 글 삭제] : 비밀번호 없이 글번호만 매개변수로 전달받음.
	public void DeleteANBoard(int ano_board_num){
		
		try {
			
			con = getConnection();
			sql = "DELETE FROM anony_board "
					+ "WHERE ano_board_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ano_board_num);
			
			pstmt.executeUpdate();
			
			
		}catch (SQLException se){
			System.out.println("DeleteANBoard메소드에서 SQL 예외 발생 : "+ se);				
			
		}catch (Exception e) {
			System.out.println("DeleteANBoard메소드 쿼리에서 예외 발생 : "+ e);				
			
		} finally {
			resourceClose();
		}
			
		
		
	};
	
	//------------------------게시글 불러오기---------------------------
	
	// [게시판 글 불러오기]
	public AnonyBoardBean getANBoard(int ano_board_num){
		
		AnonyBoardBean anb = null;
		
		try{
			con = getConnection();
			sql = "SELECT * FROM anony_board "
					+ "WHERE ano_board_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ano_board_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				anb = new AnonyBoardBean();
				
				anb.setAno_board_num(rs.getInt("ano_board_num"));
				anb.setMem_email(rs.getString("mem_email"));
				anb.setAno_board_title(rs.getString("ano_board_title"));
				anb.setAno_board_content(rs.getString("ano_board_content"));
				anb.setAno_board_read(rs.getInt("ano_board_read"));
				anb.setAno_board_date(rs.getString("ano_board_date"));
				anb.setAno_board_ip(rs.getString("ano_board_ip"));
				
			}// if
			
		}catch (Exception e) {
			System.out.println("getANBoard메소드 쿼리에서 예외 발생 : "+ e);				
			
		} finally {
			resourceClose();
		}
		
		return anb;
		
	}// getANBoard() 메소드
	
	
	
	// [게시판 전체 글목록 불러오기 ]
	public List<AnonyBoardBean> getANBoardList(){
		List<AnonyBoardBean> anbList = new ArrayList<AnonyBoardBean>();
		
		try {
			con = getConnection();
			sql = "SELECT * FROM anony_board ";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				AnonyBoardBean anb = new AnonyBoardBean();
				anb.setAno_board_num(rs.getInt("ano_board_num"));
				anb.setMem_email(rs.getString("mem_email"));
				anb.setAno_board_title(rs.getString("ano_board_title"));
				anb.setAno_board_content(rs.getString("ano_board_content"));
				anb.setAno_board_read(rs.getInt("ano_board_read"));
				anb.setAno_board_date(rs.getString("ano_board_date"));
				anb.setAno_board_ip(rs.getString("ano_board_ip"));
				
				anbList.add(anb);
				
			}//while 끝
			
			
		} catch (Exception e) {
			System.out.println("getANBoardList()메소드 쿼리에서 예외 발생 : "+ e);				
			
		} finally {
			resourceClose();
		}
			
		return anbList;
	}
	
	// [전체 글 개수 반환 메소드]
	public int getAnonyBoardCount(){
		int count = 0;
		
		try {
			con = getConnection();
			sql = "SELECT count(*) FROM anony_board ";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}//if
			
			
		}catch(Exception e){
			System.out.println("getAnonyBoardCount()메소드 쿼리에서 예외 발생 : "+ e);				
			
		}finally {
			resourceClose();
		}
		
		return count;
		
	}//getAnonyBoardCount()
	
	

		
}
