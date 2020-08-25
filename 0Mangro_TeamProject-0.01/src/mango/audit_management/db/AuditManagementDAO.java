package mango.audit_management.db;

import java.util.List;

import mango.connection.db.DBconnection;

public class AuditManagementDAO extends DBconnection implements IAuditManagement{

	@Override
	public AuditManagementBean getAuditMangement(AuditManagementBean abc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuditManagementBean> getAllListAuditMangement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuditManagementBean> getListAuditMangement(AuditManagementBean abc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertAuditMangement(AuditManagementBean abc) {
		int result = 0;
		try {
			getConnection();
			String sql = "insert into audit_management values( "
					+ "?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			System.out.println(abc.getAcaNum());
			System.out.println(abc.getAcaName());
			System.out.println(abc.getAuditAvailSubj());
			
			pstmt.setInt(1, abc.getAcaNum());
			pstmt.setString(2, abc.getAcaName());
			pstmt.setString(3, abc.getAuditAvailSubj());
			pstmt.setString(4, abc.getAuditAvailDate());
			pstmt.setInt(5, abc.getAuditLastTime());
			pstmt.setInt(6, abc.getAuditAblemem());			
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {			
			e.printStackTrace();
		} finally{
			resourceClose();
		}	
		return result;
	}

	@Override
	public int delelteAuditMangement(AuditManagementBean abc) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
