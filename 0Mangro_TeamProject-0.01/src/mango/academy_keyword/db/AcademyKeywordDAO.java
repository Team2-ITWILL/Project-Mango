package mango.academy_keyword.db;

import java.util.ArrayList;
import java.util.List;
import mango.connection.db.DBconnection;

public class AcademyKeywordDAO extends DBconnection{
	
	
	// 키워드 추가
	public int insertAcademyKeyword(AcademyKeywordBean acaKeywordBean){
		int result = 0;
		try {
			getConnection();	
			
			//테이블에 행이 존재하는지 확인(중복검사)
			sql = "select * from academy_keyward "
					+ "where aca_main_num = ? "
					+ "and aca_keyword = ?";
			pstmt = con.prepareStatement(sql);			
			
			pstmt.setInt(1, acaKeywordBean.getAcaMainNum());
			pstmt.setString(2, acaKeywordBean.getAcakeyword());
			
			rs = pstmt.executeQuery();
			
			//1. 중복일 경우
			if(rs.next()){
				sql = "delete from academy_keyward "
						+ "where aca_main_num = ? "
						+ "and aca_keyword = ?";
				pstmt = con.prepareStatement(sql);				
				pstmt.setInt(1, acaKeywordBean.getAcaMainNum());
				pstmt.setString(2, acaKeywordBean.getAcakeyword());				
				result = pstmt.executeUpdate();		
				
				return result;
			}			
			
			//2. 중복이 아닐 경우
			
			//academy 테이블과 academy_register table을 join해서 데이터를 가져오기
			sql = "insert into academy_keyward "
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
		
		} catch (Exception e) {
			System.out.println("insertAcademyKeyword()에서 예외발생");	
			e.printStackTrace();
		} finally {
			resourceClose();
		}		
		return result;
		
	} // insertAcademyKeyword() 끝
	
	
	// 테이블에 행이 있는 경우(중복) 삭제
	public int deleteIfDuplicate(AcademyKeywordBean acaKeywordBean){
		int result = 0;
		try {
			getConnection();	
			
			//academy 테이블과 academy_register table을 join해서 데이터를 가져오기
			sql = "insert into academy_keyward "
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
		
		} catch (Exception e) {
			System.out.println("insertAcademyKeyword()에서 예외발생");	
			e.printStackTrace();
		} finally {
			resourceClose();
		}		
		return result;
		
	} // insertAcademyKeyword() 끝
	
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
