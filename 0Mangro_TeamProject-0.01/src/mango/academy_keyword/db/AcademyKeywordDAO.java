package mango.academy_keyword.db;

import java.util.ArrayList;
import java.util.List;
import mango.connection.db.DBconnection;

public class AcademyKeywordDAO extends DBconnection{
	
	
	// 키워드 추가(+중복 검사)
	public int insertAcademyKeyword(AcademyKeywordBean acaKeywordBean){
		int result = 0;
		try {
			getConnection();	
			
			// 관리자 메뉴 - 등록요청 학원 관리 페이지(register_reqManagement.jsp)에서 승인버튼을 누르면
			// academy_register의 승인(confirm_date 변경)과 
			// academy_keyword 테이블에 등록하는 과정을 동시에 하고 있는데
			// 이미 키워드가 등록되어있으면 중복오류가 발생하므로 이를 방지하기 위해서
			// 테이블에 행이 존재하는지 확인(중복검사)
			sql = "select * from academy_keyword "
					+ "where aca_main_num = ? "
					+ "and aca_keyword = ?";
			pstmt = con.prepareStatement(sql);			
			
			pstmt.setInt(1, acaKeywordBean.getAcaMainNum());
			pstmt.setString(2, acaKeywordBean.getAcakeyword());
			
			rs = pstmt.executeQuery();
			
			//1. 중복일 경우 삭제
			if(rs.next()){
				sql = "delete from academy_keyword "
						+ "where aca_main_num = ? "
						+ "and aca_keyword = ?";
				pstmt = con.prepareStatement(sql);				
				pstmt.setInt(1, acaKeywordBean.getAcaMainNum());
				pstmt.setString(2, acaKeywordBean.getAcakeyword());				
				result = pstmt.executeUpdate();		
				
				System.out.println("중복된 키워드를 삭제하였음");
				
				//return result;
			}			
			
			//2. 중복이 아닐 경우 insert			
			//academy 테이블과 academy_register table을 join해서 데이터를 가져오기
			sql = "insert into academy_keyword "
				+ "(select a.aca_main_num, r.aca_keyword "
				+ "from academy as a join academy_register as r "
				+ "where a.aca_name = r.aca_name "
				+ "	and a.aca_main_num = ? "
				+ ")";
			
			//이거 안 해서 계속 nullpointerexception 발생했음!!
			pstmt = con.prepareStatement(sql);			
			
			pstmt.setInt(1, acaKeywordBean.getAcaMainNum());
			
			//keyword는 academy_register 테이블에 등록된 값을 가져옴
			//pstmt.setString(2, acaKeywordBean.getAcakeyword());			
			
			result = pstmt.executeUpdate();		
			
			System.out.println("insertAcademyKeyword() result: " + result);
			System.out.println("키워드 insert 성공");
		
		} catch (Exception e) {
			System.out.println("insertAcademyKeyword()에서 예외발생");	
			e.printStackTrace();
		} finally {
			resourceClose();
		}		
		return result;
		
	} // insertAcademyKeyword() 끝		
	
	
	
	// 키워드 삭제
	public int deleteAcademyKeyword(int acaNum, int flag /*AcademyKeywordBean acaKeywordBean*/){
		int result = 0;
		try {
			getConnection();				
	
			sql = "select * from academy_keyword "
					+ "where aca_main_num = ? ";
//					+ "and aca_keyword = ?";
			pstmt = con.prepareStatement(sql);			
			
			pstmt.setInt(1, acaNum);
			
			rs = pstmt.executeQuery();
			
			//등록된 키워드가 존재하면 삭제 처리
			if(rs.next()){
				sql = "delete from academy_keyword "
						+ "where aca_main_num = ? ";
						//+ "and aca_keyword = ?";
				pstmt = con.prepareStatement(sql);			
				pstmt.setInt(1, acaNum);
				//pstmt.setInt(1, acaKeywordBean.getAcaMainNum());
				//pstmt.setString(2, acaKeywordBean.getAcakeyword());		
				
				// 이미 키워드 삭제 처리된 상태에서 삭제요청을 추가적으로 할 경우
				// 레코드에서 더 이상 삭제할 executeupdate()의 결과가 0이 반환됨
				result = pstmt.executeUpdate();	
				
				System.out.println("deleteAcademyKeyword() result: " + result);
				if(result > 0){					
					System.out.println("키워드 삭제 성공");
				}			
				
			//키워드가 등록되어있지 않다면	
			}else{
				System.out.println("등록된 키워드 없음");
				
				// 이미 취소처리 하여 키워드테이블에 데이터는 없지만 
				// 다시 취소 요청이 들어온 경우
				if(flag == 0){					
					System.out.println("취소 중복 요청");
					return result;
				}
				
				//flag : -1 => 삭제요청인 경우
				//다른 조건과 구분하기 위해서 -1 반환
				return -1;
			}
		
			
//			executeUpdate의 리턴값은 작용한 열의 개수(갱신 카운트로 간주되는)를 나타내는 정수이다.
//			따라서 executeUpdate의 리턴값이 0 일 때, 그것은 다음 두가지 중 하나를 의미할 수 있다.
//			1) 실행된 SQL문은 열들에 영향을 주지 않는 INSERT, UPDATE 또는 DELETE이다.
//			2) 실행된 SQL문이 DDL 문들이다.
			
		} catch (Exception e) {
			System.out.println("deleteAcademyKeyword()에서 예외발생");	
			e.printStackTrace();
		} finally {
			resourceClose();
		}		
		return result;
		
	} // deleteAcademyKeyword() 끝		
	
	
	// 학원번호로 키워드 목록 반환
	public List<AcademyKeywordBean> getAcademyKeyword(int acaMainNum){
		
		List<AcademyKeywordBean> acaKeywordList = new ArrayList<AcademyKeywordBean>();
		
		try {
			getConnection();
			sql = "select * from academy_keyword where aca_main_num = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, acaMainNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				AcademyKeywordBean akBean = new AcademyKeywordBean();
				akBean.setAcaMainNum(rs.getInt(1));
				akBean.setAcakeyword(rs.getString(2));
				
				acaKeywordList.add(akBean);
				
			}
			
		} catch (Exception e) {
			System.out.println("getAcademyKeyword()에서 예외 발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		return acaKeywordList;
	} // getAcademyKeyword() 끝
	
} // AcademyKeywordDAO 클래스 끝
