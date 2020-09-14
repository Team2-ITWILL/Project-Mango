package mango.audit_request.db;

import java.util.List;

public interface IAuditRequest {

	
	// 학원 하나당 청강 신청 목록 갖고오기(학원관리자)
	public List<AuditRequestBean> getAuditList(AuditRequestBean aab);

	// 청강신청 목록 전부다 갖고오기(사이트관리자페이지)
	public List<AuditRequestBean> getAllAuditList();
	
	// 승인된 청강신청 목록 전부다 갖고오기(사이트관리자페이지) - 학원관리자마다 각각의데이터 불러옴
	public List<AuditRequestBean> getAllAuditListApproved(int aca_main_num);	
	
	// 청강신청 목록 전부다 갖고오기(Mypage)
	public List<AuditRequestBean> getAllAuditListOfUser(String email);
	
	// 승인된 청강신청 목록 전부다 갖고오기(Mypage)
	public List<AuditRequestBean> getAllAuditListApprovedOfUser(String email);
	
	// 청강 신청
	public int InsertAudit(AuditRequestBean insert);
	
	// 청강 신청 취소
	public int DeleteAudit(AuditRequestBean delete);
	
	// 청강 신청 할 수 있는지 체크(중복체크)
	public int CheckAuditList(AuditRequestBean check);

	//청강 신청 승인(학원관리자)
	public int ApprovalAudit(AuditRequestBean app, String check);
	
	//과목 당 청강신청이 들어온 개수
	public int getAuditCountOfSubject(String subject, String aca_name);
	
	//누적 청강수 불러오기(학원관리자)
	public int getAuditCount(int acaNum, String email);
	
	//승인된 청강 개수(학원관리자)
	public int getAuditCountApproval(int acaNum, String email);
	
	//누적 청강수 불러오기(Mypage)
	public int getAuditCountOfUser(String email);
		
	//승인된 청강 개수(Mypage)
	public int getAuditCountApprovalOfUser(String email);
	
	//청강신청 시 누적청강수 증가
	public int addAuditCount(int acaNum, int auditNum);
	
	
	
	
	
}
