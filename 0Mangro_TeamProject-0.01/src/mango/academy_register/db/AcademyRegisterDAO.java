package mango.academy_register.db;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import mango.connection.db.DBconnection;

public class AcademyRegisterDAO extends DBconnection{

	public int RegisterToDB(AcademyRegisterBean bean){
		
		int result = 0;
		try {
			getConnection();
			
			//EMAIL : FK(member table)
			// -> member 테이블에 참조하는 값이 있어야만 register테이블에 데이터 삽입 가능
			
			String sql = "insert into academy_register "
					+ "values(?,?,?,?,?,?,?,?,now(),null, ?)";
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
			pstmt.setString(9, bean.getAca_keyword());
			
			result = pstmt.executeUpdate();		
			
		} catch (Exception e) {
			System.out.println("RegisterToDB()에서 예외 발생");
			e.printStackTrace();
		}finally{
			resourceClose();
		}		
		return result;
	}
	
	// 등록요청이 존재하는지 확인
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
	
	// 관리자인지 확인하는 메서드
	public int CheckAdminUser(String id){
		
		int result = 0;
		try {
			getConnection();
			
			String sql = "select * from member "
					+ "where mem_email=? and "
					+ "mem_admin is not null and "
					+ "mem_admin = 'Y' ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);				
			rs = pstmt.executeQuery();
			
			if(rs.next())
				result = 1; //데이터 존재
			else
				result = 0; //데이터 없음
			
			System.out.println("CheckAdminUser() 수행");
			
		} catch (Exception e) {
			System.out.println("CheckAdminUser()에서 예외 발생");
			e.printStackTrace();
		}finally{
			resourceClose();
		}		
		return result;
	} // CheckAdminUser() 끝
	
	public String getRegisterEmail(String acaName){
		
		String mem_email = "0";
		
		try {
			getConnection();
			sql ="select mem_email from academy_register where aca_name =?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, acaName);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				mem_email = rs.getString(1);
			}
			
		} catch (Exception e) {
			System.out.println("getRegisterEmail()에서 예외 발생");
			e.printStackTrace();
		} finally {
			resourceClose();
		}
		
		
		return mem_email;
		
	} // getRegisterEmail() 끝
	
	public List<AcademyRegisterBean> getAllRegisterList(String id){
		List<AcademyRegisterBean> list = new ArrayList<AcademyRegisterBean>();
		try {
			getConnection();

			String sql = "select * from academy_register";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				//LocalDate이 NULL이면 에러가 발생하기 때문에 미리 처리
				LocalDate register_date = null;
				LocalDate confirm_date = null;
				if(rs.getDate("register_date") != null)		
					register_date = rs.getDate("register_date").toLocalDate();
				if(rs.getDate("confirm_date") != null)		
					confirm_date = rs.getDate("confirm_date").toLocalDate();				

				AcademyRegisterBean vo 
				 = new AcademyRegisterBean
					(
						rs.getString("mem_email"),
						rs.getString("aca_name"),
						rs.getString("mem_addr_zip"),
						rs.getString("mem_addr_doro"),
						rs.getString("f_name_company"),
						rs.getString("f_size_company"),
						rs.getString("f_size_owner"),
						rs.getString("f_name_owner"),
						register_date,
						confirm_date,
						rs.getString("aca_keyword")
					);				

				list.add(vo);
			}

		} catch (Exception e) {
			System.out.println("getAllRegisterList()에서 예외 발생");
			e.printStackTrace();
		}finally{
			resourceClose();
		}		
		return list;
	}

	public int changeConfirmDate(String id, int flag){

		int result = 0;
		try {
			getConnection();

			String sql = null;
			//승인
			if(flag == 1){
				sql = "update academy_register "
					+ "set confirm_date = curdate() "
					+ "where mem_email = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);	

			//승인 취소
			}else if(flag == 0){
				sql = "update academy_register "
					+ "set confirm_date = null "
					+ "where mem_email = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);		
				
			//삭제	
			}else if(flag == -1){
				sql = "delete from academy_register "
						+ "where mem_email = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);		
					
			}else{
				System.out.println("존재하지 않는 flag값 -> error");
				return 0;
			}

			result = pstmt.executeUpdate();				

		} catch (Exception e) {
			System.out.println("changeConfirmDate()에서 예외 발생");
			e.printStackTrace();
		}finally{
			resourceClose();
		}		
		return result;
	}	
	
	//등록 요청 학원 수 얻기
	public int getRegRequestCount(){
		int count = 0;
		try {
			getConnection();

			sql = "select count(*) from academy_register where confirm_date is not null";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println("getRegRequestCount()에서 예외 발생");
			e.printStackTrace();
		}finally{
			resourceClose();
		}		
		return count;
	}		
	
} // AcademyRegisterDAO클래스 끝
