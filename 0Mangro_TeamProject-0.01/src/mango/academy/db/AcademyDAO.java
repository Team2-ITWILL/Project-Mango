package mango.academy.db;

import java.util.ArrayList;
import java.util.List;

import mango.connection.db.DBconnection;

public class AcademyDAO extends DBconnection implements IAcademy{

	@Override
	public List<AcademyBean> AllAcademyList(int StartRow, int pageSize) {
		List<AcademyBean> list = new ArrayList<AcademyBean>();
		try {
			getConnection();
			AcademyBean bean;
			String sql = "select * from academy limit ?, ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, StartRow);
			pstmt.setInt(2, pageSize);			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				bean = new AcademyBean(
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)
						);	
				
				list.add(bean);				
			}			
			
		} catch (Exception e) {
			System.out.println("AllAcademyList()에서 예외 발생");
			e.printStackTrace();
		} finally{
			resourceClose();
		}
		
		return list;
	}

	@Override
	public List<AcademyBean> getOnlySearch(AcademyBean search) {

		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("getOnlySearch()에서 예외 발생");
			e.printStackTrace();
		}finally {
			resourceClose();
		}
		
		return null;
	}

	@Override
	public List<AcademyBean> getAllSearch(AcademyBean search) {
		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("getAllSearch()에서 예외 발생");
			e.printStackTrace();
		}finally {
			resourceClose();
		}
		return null;
	}

	@Override
	public List<AcademyBean> getListSearch(AcademyBean address) {
		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("getListSearch()에서 예외 발생");
			e.printStackTrace();
		}finally {
			resourceClose();
		}
		
		return null;
	}
	
	// 학원 정보 출력
	@Override
	public AcademyBean getAcademyContent(int acaNum) {
		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("getAcademyContent()에서 예외 발생");
			e.printStackTrace();
		}finally {
			resourceClose();
		}
		
		return null;
	}

	@Override
	public void DeleteAcademy(AcademyBean ab) {
		try {
			getConnection();
		} catch (Exception e) {
			System.out.println("DeleteAcademy()에서 예외 발생");
			e.printStackTrace();
		}finally {
			resourceClose();
		}
		
		
	}
	
}
