package mango.academy_register.db; 

import mango.connection.db.DBconnection;

public class AcademyRegisterDAO extends DBconnection{

	public int RegisterToDB(AcademyRegisterBean bean){
		
		int result = 0;
		try {
			getConnection();
			
			//EMAIL : FK(member table)
			// -> member 테이블에 참조하는 값이 있어야만 register테이블에 데이터 삽입 가능
			String sql = "insert into academy_register("
					+ "memEmail, acaName, memAddrZip, memAddrDoro, "
					+ "fNameCompany, fSizeCompany, fSizeOwner, fNameOwner, "
					+ "registerDate, confirmDate) "
					+ " values(?, ?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, bean.getMemEmail());
			pstmt.setString(2, bean.getAcaName());
			pstmt.setString(3, bean.getMemAddrZip());
			pstmt.setString(4, bean.getMemAddrDoro());
			pstmt.setString(5, bean.getFNameCompany());
			pstmt.setString(6, bean.getFSizeCompany());
			pstmt.setString(7, bean.getFSizeOwner());
			pstmt.setString(8, bean.getFNameOwner());
			pstmt.setString(9, bean.getRegisterDate());
			pstmt.setString(10, bean.getConfirmDate());
			
			result = pstmt.executeUpdate();		
			
		} catch (Exception e) {
			System.out.println("RegisterToDB()에서 예외 발생");
			e.printStackTrace();
		}finally{
			resourceClose();
		}		
		return result;
	}
	
	
}
