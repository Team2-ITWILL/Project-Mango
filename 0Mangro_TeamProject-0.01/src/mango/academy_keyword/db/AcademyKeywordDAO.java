package mango.academy_keyword.db;

import java.util.ArrayList;
import java.util.List;

import mango.connection.db.DBconnection;

public class AcademyKeywordDAO extends DBconnection{
	
	
	// 키워드 추가
	public int insertAcademyKeyword(AcademyKeywordBean acaKeywordBean){
		
		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("insertAcademyKeyword()에서 예외발생");	
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		return 0;
	} // insertAcademyKeyword() 끝
	
	// 키워드 반환
	public List<AcademyKeywordBean> getAcademyKeyword(int acaMainNum){
		
		List<AcademyKeywordBean> acaKeywordList = new ArrayList<AcademyKeywordBean>();
		
		try {
			getConnection();
			sql = "select * from academy_keyward where aca_main_num = ?";
			
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
