package mango.member.db;

import mango.connection.db.DBconnection;

public class MemberDAO extends DBconnection{
	
	/* 회원 가입  메서드 */
	public boolean insertMember(MemberBean mb){
		
		int result = 0;
		
		try {
			getConnection();
			System.out.println("DB 연결 성공 !!");
			
			sql = "INSERT INTO member (mem_email, mem_name, mem_pwd, "
					+ "mem_joindate)"
					+ " VALUES (?,?,?,now())";

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mb.getMemEmail());
			pstmt.setString(2, mb.getMemName());
			pstmt.setString(3, mb.getMemPwd());
			
			System.out.println(mb);
			
			result = pstmt.executeUpdate();
			
			if(result != 0){
				return true;
			}
			
			System.out.println("회원 가입 완료 !!");
			
		} catch (Exception e) {
			System.out.println("--> insertMember()에 SQL구문 오류" + e);
			e.printStackTrace();
		} finally { // 자원 해제
			resourceClose();
		} // try문 끝
		
		return false;
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
				
				if(rs.getString("mem_pwd").equals(mb.getMemPwd())){
					check = 1;
				}else{
					check = 0;
				}
				
			}else{
				check = -1;
			}

			System.out.println("DB 조회 성공 !!");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--> loginCheck()에서 SQL구문 오류 : " + e);
		} finally { // 자원 해제
			resourceClose();
		} // try문 끝
		
		return check;
	} // 로그인 / loginCheck() 끝
	
	
	/* 회원 탈퇴 메서드 */
	public int deleteMember(MemberBean mb){
		
		int check = 0;
		
		try {
			getConnection();
			
			sql = "DELETE FROM member WHERE mem_email = ? "
					+ "AND mem_pwd = ? ";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mb.getMemEmail());
			pstmt.setString(2, mb.getMemPwd());
			
			pstmt.executeUpdate();
			
			if(mb.getMemPwd().equals("mem_pwd")){
				check = 1;
			}else{
				check = 0;
			}
			
			System.out.println("회원 탈퇴 완료 !!");
			
		} catch (Exception e) {
			System.out.println("deleteMember()에서 SQL 구문 오류 : "+ e);
			e.printStackTrace();
			
		} finally {
			resourceClose();
		}
		
		return check;
	} // 회원 탈퇴 / deleteMember() 끝
	
	
	
	
	
	
}