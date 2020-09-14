package mango.member.db;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import mango.connection.db.DBconnection;
import mango.payment.db.PaymentBean;
public class MemberDAO extends DBconnection{
	
	/* 일반 회원 가입  메서드 */
	public boolean insertMember(MemberBean mb){
		
		int result = 0;
		
		try {
			getConnection();
			System.out.println("DB 연결 성공 !!");
			
			sql = "INSERT INTO member (mem_email, mem_name, mem_pwd, mem_joindate)"
					+ " VALUES (?,?,?, now())";
			
			// [참고] pm_use_num : 사용회차 / 무료 체험도 1번 횟수로 적용
			//       pm_name : 이용권 이름 / 가입 무제한 이용권 (3일)

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb.getMemEmail());
			pstmt.setString(2, mb.getMemName());
			pstmt.setString(3, mb.getMemPwd());
			
			result = pstmt.executeUpdate();
			
			if(result != 0){
				
				getConnection();
				
				sql = "INSERT INTO payment (mem_email, pm_use_num, pm_name, pm_start_date, pm_exp_date, pm_check) "
					+ " VALUES (?, 1,'가입 무제한 이용권 (3일)',now(), DATE_ADD(NOW(), INTERVAL 3 DAY), 'O')";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mb.getMemEmail());
				pstmt.executeUpdate();

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
	public int insertnaverMember(MemberBean mb) {
		
		int result = 0;
		int check = 0;
		
		try {
			getConnection();
			
			check = idCheck(mb.getMemEmail());
			
			System.out.println("@@@@check : "+check);
			
			if(check == 1){
				result = 1;
				return result;
				
			}else if(check == 0){
				
				sql = "INSERT INTO member (mem_email, mem_name, "
						+ "mem_joindate)"
						+ " VALUES (?,?, now())";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mb.getMemEmail());
				pstmt.setString(2, mb.getMemName());
				result = pstmt.executeUpdate();
				
				System.out.println("회원 가입 완료 !!");
				
				return result;
			}
			
		} catch (Exception e) {
			System.out.println("--> insertMember()에 SQL구문 오류" + e);
			e.printStackTrace();
		} finally { // 자원 해제
			resourceClose();
		} // try문 끝
		
		return result;
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
					if(!(rs.getString("mem_seceded") == null)){ 
						check = -2;
					
					// 정지일자 컬럼에 데이터가 존재할 때 로그인 불가	
					}else if(!(rs.getString("mem_baned") == null)){	
						check = -3; 
						
					// 탈퇴일자 컬럼과 정지일자 컬럼에 데이터가 null일 때 로그인 성공
					}else if((rs.getString("mem_seceded") == null) 
						  && (rs.getString("mem_baned") == null)){
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
				
				if(rs.getString("mem_email").equals(mb.getMemEmail()) 
				&& rs.getString("mem_name").equals(mb.getMemName()) ){
						
					// 탈퇴일자 컬럼에 데이터가 존재할 때 로그인 불가
					if(!(rs.getString("mem_seceded") == null)){ 
						check = -2;
					
					// 정지일자 컬럼에 데이터가 존재할 때 로그인 불가	
					}else if(!(rs.getString("mem_baned") == null)){	
						check = -3;
						
					// 탈퇴일자 컬럼과 정지일자 컬럼에 데이터가 null일 때 로그인 성공
					}else if((rs.getString("mem_seceded") == null) 
						  && (rs.getString("mem_baned") == null)){
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
					
					sql = "UPDATE member "
						+ "SET mem_seceded = now() "
						+ "WHERE mem_email = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, mb.getMemEmail());
					pstmt.executeUpdate();

					check = 1;
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
	public MemberBean findPw(String email) {
	
		MemberBean mb = new MemberBean();
		
		try {
			getConnection();
			
			sql = "SELECT mem_pwd FROM member WHERE mem_email = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				mb.setMemPwd(rs.getString("mem_pwd"));
			}
			
			System.out.println("비밀번호 조회 완료 !!");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--> findPw()에서 SQL구문 오류 : " + e);
		} finally {
			resourceClose();
		}
		return mb;
	} // 비밀번호 찾기  / findPw() 끝




	/* 모든 회원 조회 (회원 관리창) 기능 메서드  */
	public ArrayList ListAll(int startRow ,int pageSize) {

		ArrayList memberlist = new ArrayList();
		
		try {
			getConnection();
			
			sql = "SELECT * "
				+ "FROM member "
				+ "LIMIT ?, ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				MemberBean mb = new MemberBean();
				mb.setMemEmail(rs.getString("mem_email"));
				mb.setMemName(rs.getString("mem_name"));
				mb.setMemAdmin(rs.getString("mem_admin"));
				mb.setMemJoindate(rs.getString("mem_joindate"));
				mb.setMemBaned(rs.getString("mem_baned"));
				mb.setMemSeceded(rs.getString("mem_seceded"));
			
				memberlist.add(mb);
			}

			System.out.println("전체 회원 조회 완료 !!");
			
		} catch (Exception e) {
			System.out.println("--> ListAll()에서 SQL구문 오류 :" + e);
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		return memberlist;
	} // 모든 회원 조회 / ListAll() 끝
	
	
	
	
	/* 회원 관리 페이징 처리 기능 메서드 */
	public int getMGCount() {
		
		int count = 0;
		
		try {
			getConnection();

			sql = "SELECT COUNT(*) FROM member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				count = rs.getInt(1);
			}
			
			System.out.println("회원 관리 페이징 처리 완료 !!");
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--> getMGCount()에서 SQL구문 오류 : " + e);
		} finally {
			resourceClose();
		}
		return count;
	} // 회원 관리 페이징 / getMGCount() 끝
	
	
	
	
	// 학원관리자 등록 시 admin값 변경하는 메서드
	public int changeAdmin(String email, int flag){
		int result = 0;		
		try {
			getConnection();
			
			//관리자 등급으로 변경 승인
			if(flag == 1){
				sql = "update member "
						+ "set mem_admin = ? "
						+ "where mem_email = ?";			

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, String.valueOf('Y'));
				//pstmt.setInt(1, 'Y');
				pstmt.setString(2, email);	
				
				
			//flag == 0, -1이면 일반 user등급으로 격하
			}else{
				sql = "update member "
						+ "set mem_admin = ? "
						+ "where mem_email = ?";			

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, String.valueOf('N'));
				//pstmt.setInt(1, 'N');
				pstmt.setString(2, email);	
			}					
			
			result = pstmt.executeUpdate();	
			
		} catch (Exception e) {
			System.out.println("changeAdmin()에서 예외 발생" + e);
			e.printStackTrace();
		} finally {
			resourceClose();
		}		
		return result;		
	}//changeAdmin()
	
	
	
	
	public int updateProfileImg(String imgPath, String email){
		int result = 0;
		try {
			getConnection();
			
			sql = "update member "
					+ "set mem_profileImg = ? "
					+ "where mem_email = ?";			

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, imgPath);			
			pstmt.setString(2, email);
			
			result = pstmt.executeUpdate();	
			
		} catch (Exception e) {
			System.out.println("updateProfileImg()에서 예외 발생" + e);
			e.printStackTrace();
		} finally {
			resourceClose();
		}		
		return result;		
	} // updateProfileImg()
	
	
	
	
	public String getProfileImg(String email){
		String imgPath = null;
		try {
			getConnection();
			
			sql = "select mem_profileImg from member where mem_email = ?";	
			pstmt = con.prepareStatement(sql);			
			pstmt.setString(1, email);			
			rs = pstmt.executeQuery();	
			
			if(rs.next()){
				imgPath = rs.getString("mem_profileImg");
			}
			
		} catch (Exception e) {
			System.out.println("getProfileImg()에서 예외 발생" + e);
			e.printStackTrace();
		} finally {
			resourceClose();
		}		
		return imgPath;		
	} // getProfileImg()
	
	
	
	
	/* 아이디 중복 체크 메서드 */
	public int idCheck(String email) {
		
		int check = 0;
		
		try {
			getConnection();
			
			sql = "SELECT mem_email FROM member WHERE mem_email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				check = 1;
			}

			System.out.println("아이디 중복 체크 완료 !!");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--> idCheck()에서 SQL구문 오류 : " + e);
		} finally {
			resourceClose();
		}
		return check;
	} // 아이디 중복 체크 / idCheck() 끝
	
	
	/* 총 회원수 얻는 메서드 */
	public int getMemberCount() {		
		int count = 0;		
		try {
			getConnection();
			
			sql = "select count(*) from member ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--> getMemberCount()에서 SQL구문 오류 : " + e);
		} finally {
			resourceClose();
		}
		return count;
	} // getMemberCount
	
	
	
	// admin_main.jsp의 회원현황 차트에 이용할 데이터를 가져오는 메서드
	public JSONObject getMemberCountDiff() {		
		JSONObject countObj = new JSONObject();		
		try {
			getConnection();
		/*	sql = "select "
				+ "count(*) as total, "
				+ "count(if(mem_admin <> 0, mem_admin, NULL)) as isAdmin, "
				+ "count(if(mem_admin = 0, mem_admin, NULL)) as isNormal, "
				+ "count(if(mem_baned <> 0, mem_baned, NULL)) as isBaned, "
				+ "count(if(mem_seceded <> 0, mem_seceded, NULL)) as isSeceded "
				+ "	from member ";	*/		
			
			
			// 관리자, 일반, 정지, 탈퇴 회원 구분
			//mem_admin : 'Y', 'N'으로 구분(char)
			//mem_baned, mem_seceded : 정지,금지된 날짜 입력(varchar)			
			sql = "select "
				+ "count(*) as total,"
				+ "count(if(mem_admin = 'Y', mem_admin, NULL)) as isAdmin, " 
				+ "count(if(mem_admin = 'N', mem_admin, NULL)) as isNormal, "
				+ "count(if(mem_baned = NULL, NULL, mem_baned)) as isBaned, "
				+ "count(if(mem_seceded = NULL, NULL, mem_seceded)) as isSeceded "		
				+ "from member ";		
			
			// * SQL에서 COUNT(*) 값은 NULL을 포함한 값을 반환 한다. 
			//   하지만 COUNT(column_name) 을 사용한다면 NULL을 포함하지 않은 값을 반환 한다.
			// COUNT(컬럼명)로 레코드의 NULL값 개수를 가져오려 했지만 계속 0이 나옴
			//-> NULL이 아닌 행의 개수를 세어야 함
	
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()){
				countObj.put("total", rs.getInt(1));
				countObj.put("isAdmin", rs.getInt(2));
				countObj.put("isNormal", rs.getInt(3));
				countObj.put("isBaned", rs.getInt(4));
				countObj.put("isSeceded", rs.getInt(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--> getMemberCountDiff()에서 SQL구문 오류 : " + e);
		} finally {
			resourceClose();
		}
		return countObj;
		
	} // getMemberCountDiff
	
}