package mango.audit_management.db;

import java.util.ArrayList;
import java.util.List;

import mango.connection.db.DBconnection;

public class AuditManagementDAO extends DBconnection implements IAuditManagement{

	@Override
	public AuditManagementBean getAuditMangement(AuditManagementBean abc) {
	
		return null;
	}

	@Override
	public List<AuditManagementBean> getAllListAuditMangement() {
		
		return null;
		
	}

	@Override
	public List<AuditManagementBean> getListAuditMangement(AuditManagementBean abc) {
		
		List<AuditManagementBean> list = new ArrayList<AuditManagementBean>();
		try {
			getConnection();
			
			//---------DB에 과목이 등록되어 있는지 확인----------------
			String sql = "select audit_avail_subj from audit_management where aca_main_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, abc.getAcaNum());	
			rs = pstmt.executeQuery();
			
			//등록된 과목이 존재하지 않는다면
			if(!rs.next()){
				return null;
			}			
				
			//등록된 과목이 있으면 청강등록 진행				
			//---------DB에 정보 등록-------------
			sql = "select * from audit_management where aca_main_num = ?";			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, abc.getAcaNum());			
			rs = pstmt.executeQuery();	
			
			while(rs.next()){
				AuditManagementBean vo = new AuditManagementBean();
				
				vo.setAcaNum(rs.getInt(1));				
				vo.setAcaName(rs.getString(2));
				vo.setAuditAvailSubj(rs.getString(3));
				vo.setAuditAvailDate(rs.getDate(4).toLocalDate());
				vo.setAuditLastTime(rs.getInt(5));
				vo.setAuditAblemem(rs.getInt(6));
				
				list.add(vo);
			}
		
		} catch (Exception e) {			
			e.printStackTrace();
		} finally{
			resourceClose();
		}	
		return list;
	}

	@Override
	public int delelteAuditMangement(AuditManagementBean abc) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public int insertAuditMangement(AuditManagementBean abc) {
		int result = 0;
		try {
			getConnection();
			
			//---------DB에 등록한 과목이 있는지 확인----------------
			String sql = "select * from audit_management where aca_main_num = ? "
					+ "and audit_avail_subj = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, abc.getAcaNum());
			pstmt.setString(2, abc.getAuditAvailSubj());
			rs = pstmt.executeQuery();
			
			//이미 과목이 등록되었다면(중복)
			if(rs.next()){
				result = -1;
				
			//과목 중복이 아닐 경우	
			}else{				
				
				//---------DB에 정보 등록-------------
				sql = "insert into audit_management values( "
						+ "?,?,?,?,?,?)";
				
				pstmt = con.prepareStatement(sql);
				
				System.out.println(abc.getAcaNum());
				System.out.println(abc.getAcaName());
				System.out.println(abc.getAuditAvailSubj());
				
				pstmt.setInt(1, abc.getAcaNum());
				pstmt.setString(2, abc.getAcaName());
				pstmt.setString(3, abc.getAuditAvailSubj());
				pstmt.setDate(4, java.sql.Date.valueOf(abc.getAuditAvailDate()));
				pstmt.setInt(5, abc.getAuditLastTime());
				pstmt.setInt(6, abc.getAuditAblemem());			
				
				result = pstmt.executeUpdate();
			}
		} catch (Exception e) {			
			e.printStackTrace();
		} finally{
			resourceClose();
		}	
		return result;
	}


	
}
