package mango.academy.db;

public class AcademyBean {
	// 학원 테이블 
	
	// 학원 메인번호
	private int acaMainNum;
	
	 // 학원지정번호 
    private String acaNum;

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
    
    //리뷰 점수
    private double reviewScore; 
    
    //누적 청강수 
    private int add_audit;
    
    //학원 프로필사진
    private String memProfileImg;
    
   

    public AcademyBean() { }
    public AcademyBean(
    		int acaMainNum, String acaNum, String acaCode, 
        	String acaSearchAddr1, String acaSearchAddr2, String acaSearchAddr3,
        	String acaAttr, String acaName, String acaStartDate,
        	String acaCategory1, String acaCategory2, 
        	String acaAddrZip, String acaAddrDoro, String acaAddrDetailed,
        	String mem_email, double reviewScore,int add_audit,String memProfileImg
    		) 
    {	
    	this.acaMainNum = acaMainNum;
    	this.acaNum = acaNum;
    	this.acaCode = acaCode;
    	this.acaSearchAddr1 = acaSearchAddr1;
    	this.acaSearchAddr2 = acaSearchAddr2; 
    	this.acaSearchAddr3 = acaSearchAddr3;
    	this.acaAttr = acaAttr;
    	this.acaName = acaName;
    	this.acaStartDate = acaStartDate;
    	this.acaCategory1 = acaCategory1;
    	this.acaCategory2 = acaCategory2;
    	this.acaAddrZip = acaAddrZip;
    	this.acaAddrDoro = acaAddrDoro;
    	this.acaAddrDetailed = acaAddrDetailed;
    	this.mem_email = mem_email; 
    	this.reviewScore = reviewScore;
    	this.add_audit = add_audit;
    	this.memProfileImg = memProfileImg;
    }
    
    
    
    

    
    public String getMemProfileImg() {
		return memProfileImg;
	}
	public void setMemProfileImg(String memProfileImg) {
		this.memProfileImg = memProfileImg;
	}
	public int getAdd_audit() {
		return add_audit;
	}
	public void setAdd_audit(int add_audit) {
		this.add_audit = add_audit;
	}
	// getter, setter
    public int getAcaMainNum() {
		return acaMainNum;
	}
	public void setAcaMainNum(int acaMainNum) {
		this.acaMainNum = acaMainNum;
	}
	public double getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(double reviewScore) {
		this.reviewScore = reviewScore;
	}

    public String getAcaNum() {
		return acaNum;
	}
	public void setAcaNum(String acaNum) {
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
	
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	
	
	@Override
	public String toString() {
		return "AcademyBean [acaMainNum=" + acaMainNum + ", acaNum=" + acaNum + ", acaCode=" + acaCode
				+ ", acaSearchAddr1=" + acaSearchAddr1 + ", acaSearchAddr2=" + acaSearchAddr2 + ", acaSearchAddr3="
				+ acaSearchAddr3 + ", acaAttr=" + acaAttr + ", acaName=" + acaName + ", acaStartDate=" + acaStartDate
				+ ", acaCategory1=" + acaCategory1 + ", acaCategory2=" + acaCategory2 + ", acaAddrZip=" + acaAddrZip
				+ ", acaAddrDoro=" + acaAddrDoro + ", acaAddrDetailed=" + acaAddrDetailed + ", mem_email=" + mem_email
				+ ", reviewScore=" + reviewScore +  "]";
	}
	
	

	
}
	