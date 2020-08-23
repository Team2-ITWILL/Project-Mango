package mango.audit_management.db;

public class AuditManagementBean {
	
	// 학원지정번호 
    private int acaNum;

    // 학원명 
    private String acaName;

    // 청강가능과목1 
    private String auditAvailSubj1;

    // 청강가능일시 
    private String auditAvailDate;

    // 해당 수업지속시간 
    private int auditLastTime;
    
    //청강 가능 인원
    private int auditAblemem;

    public int getAuditAblemem() {
		return auditAblemem;
	}

	public void setAuditAblemem(int auditAblemem) {
		this.auditAblemem = auditAblemem;
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

    public String getAuditAvailSubj1() {
        return auditAvailSubj1;
    }

    public void setAuditAvailSubj1(String auditAvailSubj1) {
        this.auditAvailSubj1 = auditAvailSubj1;
    }

    public String getAuditAvailDate() {
        return auditAvailDate;
    }

    public void setAuditAvailDate(String auditAvailDate) {
        this.auditAvailDate = auditAvailDate;
    }

    public int getAuditLastTime() {
        return auditLastTime;
    }

    public void setAuditLastTime(int auditLastTime) {
        this.auditLastTime = auditLastTime;
    }


}