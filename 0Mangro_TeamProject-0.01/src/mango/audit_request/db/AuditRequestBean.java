package mango.audit_request.db;

import java.time.LocalDate;

public class AuditRequestBean {

    // 예약번호 
    private int auditNum;

    // 이메일 
    private String memEmail;

    // 학원지정번호 
    private int acaNum;

    // 학원명 
    private String acaName;

    // 청강희망과목 
    private String auditSubject;
    
    // 청강희망일자 
    private LocalDate auditWishDate;

    // 청강신청일자 
    private LocalDate auditRequestDate;  

    // 청강승인일자 
    private LocalDate auditConfirmDate;
    
    public AuditRequestBean(){ }
    public AuditRequestBean(
    		int auditNum, String memEmail, 
    		int acaNum, String acaName, String auditSubject,
    		LocalDate auditWishDate, LocalDate auditRequestDate, LocalDate auditConfirmDate
    		){
    	this.auditNum = auditNum;
    	this.memEmail = memEmail;
    	this.acaNum = acaNum;
    	this.acaName = acaName;
    	this.auditSubject = auditSubject;
    	this.auditWishDate = auditWishDate;
    	this.auditRequestDate = auditRequestDate;    
    	this.auditConfirmDate = auditConfirmDate;    	
    }
    
    
	public int getAuditNum() {
		return auditNum;
	}
	public void setAuditNum(int auditNum) {
		this.auditNum = auditNum;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public int getAcaNum() {
		return acaNum;
	}
	public void setAcaNum(int acaNum) {
		this.acaNum = acaNum;
	}
	public String getAcaName() {
		return acaName;
	}
	public void setAcaName(String acaName) {
		this.acaName = acaName;
	}
	public String getAuditSubject() {
		return auditSubject;
	}
	public void setAuditSubject(String auditSubject) {
		this.auditSubject = auditSubject;
	}
	public LocalDate getAuditRequestDate() {
		return auditRequestDate;
	}
	public void setAuditRequestDate(LocalDate auditRequestDate) {
		this.auditRequestDate = auditRequestDate;
	}
	public LocalDate getAuditWishDate() {
		return auditWishDate;
	}
	public void setAuditWishDate(LocalDate auditWishDate) {
		this.auditWishDate = auditWishDate;
	}
	public LocalDate getAuditConfirmDate() {
		return auditConfirmDate;
	}
	public void setAuditConfirmDate(LocalDate auditConfirmDate) {
		this.auditConfirmDate = auditConfirmDate;
	}
	@Override
	public String toString() {
		return "AuditRequestBean [auditNum=" + auditNum + ", memEmail=" + memEmail + ", acaNum=" + acaNum + ", acaName="
				+ acaName + ", auditSubject=" + auditSubject + ", auditWishDate=" + auditWishDate
				+ ", auditRequestDate=" + auditRequestDate + ", auditConfirmDate=" + auditConfirmDate + "]";
	}
	

    

   
 
}