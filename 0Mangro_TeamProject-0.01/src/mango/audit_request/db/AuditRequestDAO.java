package mango.audit_request.db;

import java.util.List;

import mango.connection.db.DBconnection;

public class AuditRequestDAO extends DBconnection implements IAuditRequest{

	@Override
	public List<AuditRequestBean> getAuditList(AuditRequestBean aab) {
		// TODO Auto-generated method stub
		return null;
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
			String sql = "insert into audit_request values(null, ?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, insert.getMemEmail());
			pstmt.setInt(2, insert.getAcaNum());
			pstmt.setString(3, insert.getAcaName());
			pstmt.setString(4, insert.getAuditSubject());
			pstmt.setString(5, insert.getAuditRequestDate());
			pstmt.setString(6, insert.getAuditWishDate());
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
