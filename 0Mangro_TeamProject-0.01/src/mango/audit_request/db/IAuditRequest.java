package mango.audit_request.db;

import java.util.List;

public interface IAuditRequest {

	
	// 학원 하나당 청강 신청 목록 갖고오기(학원관리자)
	public List<AuditRequestBean> getAuditList(AuditRequestBean aab);

	// 청강신청 목록 전부다 갖고오기(사이트관리자페이지)
	public List<AuditRequestBean> getAllAuditList();
	
	// 청강 신청
	public int InsertAudit(AuditRequestBean insert);
	
	// 청강 신청 취소
	public int DeleteAudit(AuditRequestBean delete);
	
	// 청강 신청 할 수 있는지 체크(중복체크)
	public int CheckAuditList(AuditRequestBean check);

	//청강 신청 승인(학원관리자)
	public int ApprovalAudit(AuditRequestBean app, String check);
	
	//누적 청강수 불러오기
	public int getAuditCount();
	
	//승인된 청강 개수
	public int getAuditCountApproval();
	
	
	
	
	
}
