package mango.member.db;

import mango.connection.db.DBconnection;

public class MemberDAO extends DBconnection{
	
	/* 일반 회원 가입  메서드 */
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
	} // 일반 회원 가입 / insertMember() 끝
	
	
	
	
	/* 네이버 회원 가입  메서드 */
	public boolean insertnaverMember(MemberBean mb){
		
		int result = 0;
		
		try {
			getConnection();
			System.out.println("DB 연결 성공 !!");
			
			sql = "INSERT INTO member (mem_email, mem_name, "
					+ "mem_joindate)"
					+ " VALUES (?,?, now())";

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mb.getMemEmail());
			pstmt.setString(2, mb.getMemName());
			
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
	} // 네이버 회원 가입 / insertnaverMember() 끝
	
	
	
	/* 일반 로그인 메서드 */
	public int loginCheck(MemberBean mb){
		
		int check = 0;
		
		try {
			getConnection();
			
			sql = "SELECT * FROM member WHERE mem_email = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb.getMemEmail());
			rs = pstmt.executeQuery();
			
			if(rs.next()){ // SELECT 결과에 아이디가 있을 때
				
				// 비밀번호가 일치할 때
				if(rs.getString("mem_pwd").equals(mb.getMemPwd())){
						
					// 탈퇴일자 컬럼에 데이터가 존재할 때 로그인 불가
					if(!(rs.getString("mem_baned") == null) ){ 
						check = -2;
						
					// 탈퇴일자 컬럼이 null일 때 로그인 성공
					}else if((rs.getString("mem_baned") == null) ){
						check = 1;
					}
				
				// 비밀벝호가 일치하지 않을 때 (0)
				}else if(!(rs.getString("mem_pwd").equals(mb.getMemPwd())) ){
					check = 0;
				}
				
			}else{
				check = -1; // SELECT 결과에 아이디 없을 때 (-1)
			}

			System.out.println("DB 조회 성공 !!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--> loginCheck()에서 SQL구문 오류 : " + e);
		} finally { // 자원 해제
			resourceClose();
		} // try문 끝
		return check;
	} // 일반 로그인 / loginCheck() 끝
	
	
	
	
	/* 네이버 로그인 메서드 */
	public int naverloginCheck(MemberBean mb){
			
		int check = 0;
		
		try {
			getConnection();
			
			sql = "SELECT * FROM member WHERE mem_email = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb.getMemEmail());
			rs = pstmt.executeQuery();
			
			if(rs.next()){ // SELECT 결과에 아이디가 있을 때
				
				if(rs.getString("mem_email").equals(mb.getMemPwd()) 
				&& rs.getString("mem_name").equals(mb.getMemName()) ){
						
					// 탈퇴일자 컬럼에 데이터가 존재할 때 로그인 불가
					if(!(rs.getString("mem_baned") == null) ){ 
						check = -2;
						
					// 탈퇴일자 컬럼이 null일 때 로그인 성공
					}else if((rs.getString("mem_baned") == null) ){
						check = 1;
					}
				}	
				
			}else{
				check = -1; // SELECT 결과에 아이디 없을 때 (-1)
			}

			System.out.println("DB 조회 성공 !!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--> naverloginCheck()에서 SQL구문 오류 : " + e);
		} finally { // 자원 해제
			resourceClose();
		} // try문 끝
		return check;
	} // 네이버 로그인 / naverloginCheck() 끝
		
	
	
	
	/* 회원 탈퇴 메서드 */
	public int deleteMember(MemberBean mb){
		
		int check = 0;
		
		try {
			getConnection();

			sql = "SELECT * FROM member WHERE mem_email = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb.getMemEmail());
			rs = pstmt.executeQuery();

			if(rs.next()){
				
				if(rs.getString("mem_pwd").equals(mb.getMemPwd())){
					check = 1;
					
					sql = "UPDATE member "
						+ "SET mem_baned = now() "
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
			System.out.println("--> deleteMember()에서 SQL 구문 오류 : "+ e);
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		return check;
	} // 회원 탈퇴 / deleteMember() 끝


	
	
	
	/* 내 정보 페이지에서 회원 정보가 보이는 기능의 메서드 */
	public String selectMember(String email) {
		String name = "";
		
		try {
			getConnection();
			
			sql = "SELECT mem_name "
				+ "FROM member "
				+ "WHERE mem_email = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if(rs.next()){
				name = rs.getString("mem_name");
			}

			System.out.println("회원 이름 조회 완료 !!");

		} catch (Exception e) {
			System.out.println("--> selectMember()에서 SQL 구문 오류 : "+ e);
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		return name;
	} // 내 정보  / selectMember() 끝
	
	
	
	
	/* 회원 정보 수정 메서드 */
	public boolean updateMember(MemberBean mb, String newPw) {
		
		boolean result = false; 
		
		try {
			getConnection();
			System.out.println("DB 연결 성공 !!");
			
			sql = "SELECT * FROM member WHERE mem_email = ? AND mem_pwd = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb.getMemEmail());
			pstmt.setString(2, mb.getMemPwd());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				sql = "UPDATE member SET mem_pwd = ? WHERE mem_email = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, newPw);
				pstmt.setString(2, mb.getMemEmail());
				pstmt.executeUpdate();
				
				result = true;
				System.out.println("회원 정보 수정 완료 !!");
			}else{
				result = false;
			}
			
		} catch (Exception e) {
			System.out.println("--> updateMember()에서 SQL구문 오류 : " + e);
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		return result;
	} // 회원 정보 수정 / updateMember() 끝



	/* 비밀번호 찾기 기능 메서드 */
	public String findPw(String email) {
	
		String pw = "";
		
		try {
			getConnection();
			
			sql = "SELECT mem_pwd FROM member WHERE mem_email = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				pw = rs.getString("mem_pwd");
			}
			
			System.out.println("비밀번호 조회 완료 !!");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--> findPw()에서 SQL구문 오류 : " + e);
		} finally {
			resourceClose();
		}
		return pw;
	}






	
	
	
	
	
	
}