package mango.audit_request.db;

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
				bean = new AuditRequestBean(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(7)
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
			
			System.out.println(insert.getMemEmail());
			System.out.println(insert.getAcaNum());
			System.out.println(insert.getAcaName());
			
			
			pstmt.setString(1, insert.getMemEmail());
			pstmt.setInt(2, insert.getAcaNum());
			pstmt.setString(3, insert.getAcaName());
			pstmt.setString(4, insert.getAuditSubject());
			pstmt.setString(5, insert.getAuditWishDate());
			pstmt.setString(6, insert.getAuditRequestDate());		
			pstmt.setString(7, insert.getAuditConfirmDate());		
			
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int CheckAuditList(AuditRequestBean check) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ApprovalAudit(AuditRequestBean app) {
		// TODO Auto-generated method stub
		return 0;
	}

}
