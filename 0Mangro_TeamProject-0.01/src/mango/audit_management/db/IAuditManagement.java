package mango.audit_management.db;

import java.util.List;

public interface IAuditManagement {
	
	//청강 수업 내용 갖고오기
	public AuditManagementBean getAuditMangement(AuditManagementBean abc);

	//청강  목록 전부다 갖고오기
	public List<AuditManagementBean> getAllListAuditMangement();
	
	//특정 학원이나 과목 갖고오기
	public List<AuditManagementBean> getListAuditMangement(AuditManagementBean abc);
	
	//청강 수업 등록
	public int insertAuditMangement(AuditManagementBean abc);

	//청강수업삭제
	public int delelteAuditMangement(AuditManagementBean abc);
	
	
	
	
	
	
	
}
