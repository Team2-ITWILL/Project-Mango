package mango.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class memberBean {
	// [멤버 변수]
	
    // 회원번호 
    private Integer memNum;

    // 이메일 
    private String memEmail;

    // 이름 
    private String memName;

    // 비밀번호 
    private String memPwd;

    // 가입일자 
    private Timestamp memJoindate;

    // 학원관리자여부 
    private String memAdmin;

    // 계정정지여부 
    private String memBaned;
	
    
	// [DB연결을 위한 객체]
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql = "";
	
	// [DB 연결 메소드]
	private Connection getConnection() throws Exception{
		
		Connection con = null;
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/mango");
		con = ds.getConnection();
		return con;
		
	}//getConnection() : DB연결 메소드
	
	// 브랜치테스트 창하
	
	// [자원 해제 메소드]
		public void resourceClose(){
			
			try {
				if(rs !=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con !=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}//resourceClose() : 자원해제 메소드
	
} // public class memberBean