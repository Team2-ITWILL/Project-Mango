package mango.academy_register.db;

import mango.connection.db.DBconnection;

public class AcademyRegisterDAO extends DBconnection{

	public int RegisterToDB(AcademyRegisterBean bean){
		
		int result = 0;
		try {
			getConnection();
			
			//EMAIL : FK(member table)
			// -> member 테이블에 참조하는 값이 있어야만 register테이블에 데이터 삽입 가능
//			String sql = "insert into academy_register("
//					+ "mem_email, aca_name, mem_addr_zip, mem_addr_doro, "
//					+ "f_name_company, f_size_company, f_size_owner, f_name_owner, "
//					+ "register_date, confirm_date) "
//					+ " values(?,?,?,?,?,?,?,?,now(),null)";
			
			String sql = "insert into academy_register "
					+ "values(?,?,?,?,?,?,?,?,now(),null)";
			pstmt = con.prepareStatement(sql);
			
			System.out.println(bean.toString());
			
			
			pstmt.setString(1, bean.getMemEmail());
			pstmt.setString(2, bean.getAcaName());
			pstmt.setString(3, bean.getMemAddrZip());
			pstmt.setString(4, bean.getMemAddrDoro());
			pstmt.setString(5, bean.getfNameCompany());
			pstmt.setString(6, bean.getfSizeCompany());
			pstmt.setString(7, bean.getfSizeOwner());
			pstmt.setString(8, bean.getfNameOwner());
			//pstmt.setDate(9, java.sql.Date.valueOf(bean.getRegisterDate()));
			//pstmt.setDate(10, java.sql.Date.valueOf(bean.getConfirmDate()));		
			
			result = pstmt.executeUpdate();		
			
		} catch (Exception e) {
			System.out.println("RegisterToDB()에서 예외 발생");
			e.printStackTrace();
		}finally{
			resourceClose();
		}		
		return result;
	}
	
	public int CheckDataExists(String id){
		
		int result = 0;
		try {
			getConnection();
			
			String sql = "select * from academy_register where mem_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);				
			rs = pstmt.executeQuery();
			
			if(rs.next())
				result = 1; //데이터 존재
			else
				result = 0; //데이터 없음
			
			System.out.println("CheckDataExists() 수행");
			
		} catch (Exception e) {
			System.out.println("CheckDataExists()에서 예외 발생");
			e.printStackTrace();
		}finally{
			resourceClose();
		}		
		return result;
	}
	
	public int CheckAdminUser(String id){
		
		int result = 0;
		try {
			getConnection();
			
			String sql = "select * from member "
					+ "where mem_email=? and "
					+ "mem_admin is not null";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);				
			rs = pstmt.executeQuery();
			
			if(rs.next())
				result = 1; //데이터 존재
			else
				result = 0; //데이터 없음
			
			System.out.println("CheckDataExists() 수행");
			
		} catch (Exception e) {
			System.out.println("CheckDataExists()에서 예외 발생");
			e.printStackTrace();
		}finally{
			resourceClose();
		}		
		return result;
	}
}
