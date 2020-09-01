package mango.audit_management.db;

import java.time.LocalDate;
import java.util.Date;


// 과목 하나를 관리하는 객체

public class AuditManagementBean {
	
	// 학원지정번호 (실제 컬럼 : aca_main_num)
    private int acaNum;

    // 학원명 
    private String acaName;

    // 청강가능과목
    private String auditAvailSubj;

    // 청강가능일시 
    private LocalDate auditAvailDate;

    // 해당 수업지속시간 
    // 목적?????
    private int auditLastTime;
    
    //청강 가능 인원
    private int auditAblemem;

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

	public String getAuditAvailSubj() {
		return auditAvailSubj;
	}

	public void setAuditAvailSubj(String auditAvailSubj) {
		this.auditAvailSubj = auditAvailSubj;
	}

	public LocalDate getAuditAvailDate() {
		return auditAvailDate;
	}

	public void setAuditAvailDate(LocalDate auditAvailDate) {
		this.auditAvailDate = auditAvailDate;
	}

	public int getAuditLastTime() {
		return auditLastTime;
	}

	public void setAuditLastTime(int auditLastTime) {
		this.auditLastTime = auditLastTime;
	}

	public int getAuditAblemem() {
		return auditAblemem;
	}

	public void setAuditAblemem(int auditAblemem) {
		this.auditAblemem = auditAblemem;
	}
    
    

    
}