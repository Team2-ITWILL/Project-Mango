package mango.member.db;

import mango.connection.db.DBconnection;

public class MemberDAO extends DBconnection{
	
	DBconnection conn = new DBconnection();
	
	// DB 연결 해체 메서드 오버라이딩
	@Override
	protected void resourceClose() {
	} // resourceClose() 끝

	
	// DB 연결 메서드 오버라이딩
	@Override
	protected void getConnection() throws Exception {
	} // getConnection() 끝

	
	// 회원 가입 기능의 메서드
	public void insertMember(MemberBean memberBean){
		
		try {
			getConnection();
			System.out.println("DB 연결 성공 !!");
			
//			sql = "INSERT INTO VALUES";
//			
//			pstmt = 
			
		} catch (Exception e) {
			System.out.println("--> insertMember()에 SQL구문 오류" + e);
			e.printStackTrace();
			
		} finally { // 자원 해제
			resourceClose();
		} // try문 끝
		
		
		
	} // 회원가입 / insertMember() 끝
	
	
	

}