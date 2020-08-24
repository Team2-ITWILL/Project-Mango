package mango.member.db;

import mango.connection.db.DBconnection;

public class MemberDAO extends DBconnection{
	
	DBconnection conn = new DBconnection();
	
	// DB 연결 해제 메서드 오버라이딩
	@Override
	protected void resourceClose() {
	} // resourceClose() 끝

	
	// DB 연결 메서드 오버라이딩
	@Override
	protected void getConnection() throws Exception {
	} // getConnection() 끝

	
	/* 회원 가입  메서드 */
	public void insertMember(MemberBean mb){
		
		try {
			getConnection();
			System.out.println("DB 연결 성공 !!");
			
			sql = "INSERT INTO member (mem_email, mem_name, mem_pwd, mem_admin, "
					+ "mem_joindate, mem_baned)"
					+ " VALUES (?,?,?,?,now(),?)";

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mb.getMemEmail());
			pstmt.setString(2, mb.getMemName());
			pstmt.setString(3, mb.getMemPwd());
			pstmt.setString(4, mb.getMemAdmin());
			pstmt.setString(5, mb.getMemJoindate());
			pstmt.setString(6, mb.getMemBaned());
			
			pstmt.executeUpdate();
			
			System.out.println("회원 가입 완료 !!");
			
		} catch (Exception e) {
			System.out.println("--> insertMember()에 SQL구문 오류" + e);
			e.printStackTrace();
		} finally { // 자원 해제
			resourceClose();
		} // try문 끝
		
	} // 회원 가입 / insertMember() 끝
	
	
	/* 로그인 메서드 */
	public int loginCheck(MemberBean mb){
		
		int check = 0;
		
		try {
			getConnection();
			System.out.println("DB 연결 성공 !!");
			
			sql = "SELECT * FROM member WHERE mem_email = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb.getMemEmail());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				if(rs.getString("id_password1").equals(mb.getMemPwd())){
					check = 1;
				}else{
					check = 0;
				}
				
			}else{
				check = -1;
			}

			System.out.println("로그인 성공 !!");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--> loginCheck()에서 SQL구문 오류 : " + e);
		} finally { // 자원 해제
			resourceClose();
		} // try문 끝
		
		return check;
	} // 로그인 / loginCheck() 끝
	
	
}