package mango.academy.db;

public class AcademyBean {
	// 학원 테이블 
		
	 // 학원지정번호 
    private int acaNum;

    // 시도교육청코드 
    private String acaCode;

    // 검색(시도) 
    private String acaSearchAddr1;

    // 검색(시군구) 
    private String acaSearchAddr2;

    // 검색(읍면동) 
    private String acaSearchAddr3;

    // 학원/교습소 등 분류(학원 속성) 
    private String acaAttr;

    // 학원명 
    private String acaName;

    // 학원개설일 
    private String acaStartDate;

    // 분류(대) 
    private String acaCategory1;

    // 분류(소) 
    private String acaCategory2;

    // 우편번호 
    private String acaAddrZip;

    // 도로명주소 
    private String acaAddrDoro;

    // 상세주소 
    private String acaAddrDetailed;
    
    //학원 관리자
    private String mem_email;

    public String getMem_Email() {
		return mem_email;
	}

	public void setMem_Email(String mem_email) {
		this.mem_email = mem_email;
	}

	public int getAcaNum() {
        return acaNum;
    }

    public void setAcaNum(int acaNum) {
        this.acaNum = acaNum;
    }

    public String getAcaCode() {
        return acaCode;
    }

    public void setAcaCode(String acaCode) {
        this.acaCode = acaCode;
    }

    public String getAcaSearchAddr1() {
        return acaSearchAddr1;
    }

    public void setAcaSearchAddr1(String acaSearchAddr1) {
        this.acaSearchAddr1 = acaSearchAddr1;
    }

    public String getAcaSearchAddr2() {
        return acaSearchAddr2;
    }

    public void setAcaSearchAddr2(String acaSearchAddr2) {
        this.acaSearchAddr2 = acaSearchAddr2;
    }

    public String getAcaSearchAddr3() {
        return acaSearchAddr3;
    }

    public void setAcaSearchAddr3(String acaSearchAddr3) {
        this.acaSearchAddr3 = acaSearchAddr3;
    }

    public String getAcaAttr() {
        return acaAttr;
    }

    public void setAcaAttr(String acaAttr) {
        this.acaAttr = acaAttr;
    }

    public String getAcaName() {
        return acaName;
    }

    public void setAcaName(String acaName) {
        this.acaName = acaName;
    }

    public String getAcaStartDate() {
        return acaStartDate;
    }

    public void setAcaStartDate(String acaStartDate) {
        this.acaStartDate = acaStartDate;
    }

    public String getAcaCategory1() {
        return acaCategory1;
    }

    public void setAcaCategory1(String acaCategory1) {
        this.acaCategory1 = acaCategory1;
    }

    public String getAcaCategory2() {
        return acaCategory2;
    }

    public void setAcaCategory2(String acaCategory2) {
        this.acaCategory2 = acaCategory2;
    }

    public String getAcaAddrZip() {
        return acaAddrZip;
    }

    public void setAcaAddrZip(String acaAddrZip) {
        this.acaAddrZip = acaAddrZip;
    }

    public String getAcaAddrDoro() {
        return acaAddrDoro;
    }

    public void setAcaAddrDoro(String acaAddrDoro) {
        this.acaAddrDoro = acaAddrDoro;
    }

    public String getAcaAddrDetailed() {
        return acaAddrDetailed;
    }

    public void setAcaAddrDetailed(String acaAddrDetailed) {
        this.acaAddrDetailed = acaAddrDetailed;
    }

	
}
	