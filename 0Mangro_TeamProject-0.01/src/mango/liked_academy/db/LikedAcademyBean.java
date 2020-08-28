package mango.liked_academy.db;

//학원좋아요 테이블 
public class LikedAcademyBean {

	 // 이메일 
	 private String memEmail;
	
	 // 학원메인번호
	 private int acaMainNum;
	
	 // 학원명 
	 private String acaName;
	
	 // 좋아요일자 
	 private String likedAcaDate;
	
	 public String getMemEmail() {
	     return memEmail;
	 }
	
	 public void setMemEmail(String memEmail) {
	     this.memEmail = memEmail;
	 }
	 
	 public int getAcaMainNum() {
		return acaMainNum;
	}

	public void setAcaMainNum(int acaMainNum) {
		this.acaMainNum = acaMainNum;
	}

	public String getAcaName() {
	     return acaName;
	 }
	
	 public void setAcaName(String acaName) {
	     this.acaName = acaName;
	 }
	
	 public String getLikedAcaDate() {
	     return likedAcaDate;
	 }
	
	 public void setLikedAcaDate(String likedAcaDate) {
	     this.likedAcaDate = likedAcaDate;
	 }
	
}