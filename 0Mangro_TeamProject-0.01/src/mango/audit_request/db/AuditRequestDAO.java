package mango.audit_request.db;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import mango.connection.db.DBconnection;

public class AuditRequestDAO extends DBconnection implements IAuditRequest{

	@Override
	public List<AuditRequestBean> getAuditList(AuditRequestBean aab) {		
		List<AuditRequestBean> list = new ArrayList<AuditRequestBean>();
		try {
			getConnection();
			String sql = "select * from audit_request "
					+ "where aca_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, aab.getAcaNum());
			
			rs = pstmt.executeQuery();		
			
			AuditRequestBean bean;
			
			
			
			while(rs.next()){
//				System.out.println("localdate6 : " + rs.getDate(6).toLocalDate());
//				System.out.println("localdate7 : " + rs.getDate(7).toLocalDate());
//				System.out.println("localdate8 : " + rs.getDate(8).toLocalDate());
				
				java.time.LocalDate confirmDate = null;				
				if(rs.getDate(8) != null)
					confirmDate = rs.getDate(8).toLocalDate();
				else
					confirmDate = null;
				
				bean = new AuditRequestBean(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDate(6).toLocalDate(),
						rs.getDate(7).toLocalDate(),						
						confirmDate
						
						);
				list.add(bean);
			}
		
		} catch (Exception e) {			
			e.printStackTrace();
		} finally{
			resourceClose();
		}	
		return list;	
	}

	@Override
	public List<AuditRequestBean> getAllAuditList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int InsertAudit(AuditRequestBean insert) {
		int result = 0;
		try {
			getConnection();
			String sql = "insert into audit_request("
					+ "mem_email, aca_num, aca_name, "
					+ "audit_wish_subject, audit_wish_date, "
					+ "audit_request_date, "
					+ "audit_confirm_date) "					
					+ " values(?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);	
			
//			System.out.println(insert.getMemEmail());
//			System.out.println(insert.getAcaNum());
//			System.out.println(insert.getAcaName());

			
			pstmt.setString(1, insert.getMemEmail());
			pstmt.setInt(2, insert.getAcaNum());
			pstmt.setString(3, insert.getAcaName());
			pstmt.setString(4, insert.getAuditSubject());
			pstmt.setDate(5, java.sql.Date.valueOf(insert.getAuditWishDate()));
			pstmt.setDate(6, java.sql.Date.valueOf(insert.getAuditRequestDate()));		
			pstmt.setDate(7, null);		//가입승인날짜는 최초에 null
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("InsertAudit()에서 예외 발생");
			e.printStackTrace();
		} finally{
			resourceClose();
		}		
		return result;
	}

	@Override
	public int DeleteAudit(AuditRequestBean delete) {
		int result = 0;
		try {
			getConnection();
			String sql = "update audit_request "
					+ "set audit_confirm_date = null "
					+ "where aca_num = ?";
			
			pstmt = con.prepareStatement(sql);	
			pstmt.setInt(1, delete.getAcaNum());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("DeleteAudit()에서 예외 발생");
			e.printStackTrace();
		} finally{
			resourceClose();
		}		
		return result;
	}
	

	@Override
	public int CheckAuditList(AuditRequestBean check) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ApprovalAudit(AuditRequestBean app) {
		
		int result = 0;
		try {
			getConnection();
			String sql = "update audit_request "
					+ "set audit_confirm_date = curdate() "
					+ "where aca_num = ?";
			
			pstmt = con.prepareStatement(sql);	
			pstmt.setInt(1, app.getAcaNum());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("ApprovalAudit()에서 예외 발생");
			e.printStackTrace();
		} finally{
			resourceClose();
		}		
		return result;
	}

}
