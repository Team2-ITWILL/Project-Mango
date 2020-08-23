package mango.academy_register.db;

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
	 private String registerDate;
	
	 // 승인일 
	 private String confirmDate;
	
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
	
	 public String getFNameCompany() {
	     return fNameCompany;
	 }
	
	 public void setFNameCompany(String fNameCompany) {
	     this.fNameCompany = fNameCompany;
	 }
	
	 public String getFSizeCompany() {
	     return fSizeCompany;
	 }
	
	 public void setFSizeCompany(String fSizeCompany) {
	     this.fSizeCompany = fSizeCompany;
	 }
	
	 public String getFSizeOwner() {
	     return fSizeOwner;
	 }
	
	 public void setFSizeOwner(String fSizeOwner) {
	     this.fSizeOwner = fSizeOwner;
	 }
	
	 public String getFNameOwner() {
	     return fNameOwner;
	 }
	
	 public void setFNameOwner(String fNameOwner) {
	     this.fNameOwner = fNameOwner;
	 }
	
	 public String getRegisterDate() {
	     return registerDate;
	 }
	
	 public void setRegisterDate(String registerDate) {
	     this.registerDate = registerDate;
	 }
	
	 public String getConfirmDate() {
	     return confirmDate;
	 }
	
	 public void setConfirmDate(String confirmDate) {
	     this.confirmDate = confirmDate;
	 }
	
	 
 
 
}