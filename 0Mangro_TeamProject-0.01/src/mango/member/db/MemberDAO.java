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
					+ " VALUES (?,?,?, now())";

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
			
			if(rs.next()){ // SELECT 결과에 아이디가 있을 때
				
				// 비밀번호가 일치할 때
				if(mb.getMemPwd().equals(rs.getString("mem_pwd"))){
						
					 // 탈퇴일자와 계정정지일자 모두 데이터가 null일 때 로그인 성공
					if(rs.getString("mem_seceded").equals(null)  
					   && rs.getString("mem_baned").equals(null) ){ 
						check = 1;
						
					// 탈퇴일자 혹은 계정정지일자 둘 중에 하나라도 데이터가 존재할 때 로그인 불가
					}else if(!(rs.getString("mem_seceded").equals(null) ) ||
							(!rs.getString("mem_baned").equals(null) ) ){ 
						check = -2; 
					}
				
				// 비밀벝호가 일치하지 않을 때 (0)
				}else if(!(rs.getString("mem_pwd").equals(mb.getMemPwd())) ){
					check = 0;
				}
				
			}else{
				check = -1; // SELECT 결과에 아이디 없을 때 (-1)
			}

			System.out.println(check);
			
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
			
			sql = "SELECT * FROM member WHERE mem_email = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mb.getMemEmail());
//			pstmt.setString(2, mb.getMemPwd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				if(rs.getString("mem_pwd").equals(mb.getMemPwd())){
					check = 1;
					
					sql = "UPDATE member "
						+ "SET mem_seceded = now(), mem_baned = now()"
						+ "WHERE mem_email = ?";
					 
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, mb.getMemEmail());

					pstmt.executeUpdate();
					
				}else{
					check = 0;
				}
				
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