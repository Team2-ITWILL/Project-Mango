package mango.academy_register.db;

import java.time.LocalDate;

//학원등록요청 테이블 

public class AcademyRegisterBean {

	// 이메일
	private String memEmail;

	// 학원명
	private String acaName;

	// 우편번호
	private String memAddrZip;

	// 도로명주소
	private String memAddrDoro;

	// 파일명(사업자원본)
	private String fNameCompany;

	// 파일크기(사업자)
	private String fSizeCompany;

	// 파일크기(대표자)
	private String fSizeOwner;

	// 파일명(대표자원본)
	private String fNameOwner;

	// 신청일
	private LocalDate registerDate;

	// 승인일
	private LocalDate confirmDate;

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getAcaName() {
		return acaName;
	}

	public void setAcaName(String acaName) {
		this.acaName = acaName;
	}

	public String getMemAddrZip() {
		return memAddrZip;
	}

	public void setMemAddrZip(String memAddrZip) {
		this.memAddrZip = memAddrZip;
	}

	public String getMemAddrDoro() {
		return memAddrDoro;
	}

	public void setMemAddrDoro(String memAddrDoro) {
		this.memAddrDoro = memAddrDoro;
	}

	public String getfNameCompany() {
		return fNameCompany;
	}

	public void setfNameCompany(String fNameCompany) {
		this.fNameCompany = fNameCompany;
	}

	public String getfSizeCompany() {
		return fSizeCompany;
	}

	public void setfSizeCompany(String fSizeCompany) {
		this.fSizeCompany = fSizeCompany;
	}

	public String getfSizeOwner() {
		return fSizeOwner;
	}

	public void setfSizeOwner(String fSizeOwner) {
		this.fSizeOwner = fSizeOwner;
	}

	public String getfNameOwner() {
		return fNameOwner;
	}

	public void setfNameOwner(String fNameOwner) {
		this.fNameOwner = fNameOwner;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public LocalDate getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(LocalDate confirmDate) {
		this.confirmDate = confirmDate;
	}

	@Override
	public String toString() {
		return "AcademyRegisterBean [memEmail=" + memEmail + ", acaName=" + acaName + ", memAddrZip=" + memAddrZip
				+ ", memAddrDoro=" + memAddrDoro + ", fNameCompany=" + fNameCompany + ", fSizeCompany=" + fSizeCompany
				+ ", fSizeOwner=" + fSizeOwner + ", fNameOwner=" + fNameOwner + ", registerDate=" + registerDate
				+ ", confirmDate=" + confirmDate + "]";
	}
	
	
	

}