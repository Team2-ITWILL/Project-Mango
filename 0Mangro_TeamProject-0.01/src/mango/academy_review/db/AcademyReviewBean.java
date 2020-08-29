package mango.academy_review.db;

//학원후기 테이블 
public class AcademyReviewBean {

		// 후기번호 
	 private int reviewNum;
	
	 // 학원지정번호 
	 private int acaMainNum;
	
	 // 학원명 
	 private String acaName;
	
	 // 한줄요약 
	 private String reviewTitle;
	
	 // 장점 
	 private String reviewGood;
	
	 // 단점 
	 private String reviewBad;
	
	 // 수강과목 
	 private String reviewSubject;
	
	 // 총괄점수 
	 private int reviewScore;
	
	 // 이메일 
	 private String memEmail;
	
	 // 작성일자 
	 private String reviewDate;
	
	
	 public int getReviewNum() {
	     return reviewNum;
	 }
	
	 public void setReviewNum(int reviewNum) {
	     this.reviewNum = reviewNum;
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
	
	 public String getReviewTitle() {
	     return reviewTitle;
	 }
	
	 public void setReviewTitle(String reviewTitle) {
	     this.reviewTitle = reviewTitle;
	 }
	
	 public String getReviewGood() {
	     return reviewGood;
	 }
	
	 public void setReviewGood(String reviewGood) {
	     this.reviewGood = reviewGood;
	 }
	
	 public String getReviewBad() {
	     return reviewBad;
	 }
	
	 public void setReviewBad(String reviewBad) {
	     this.reviewBad = reviewBad;
	 }
	
	 public String getReviewSubject() {
	     return reviewSubject;
	 }
	
	 public void setReviewSubject(String reviewSubject) {
	     this.reviewSubject = reviewSubject;
	 }
	
	 public int getReviewScore() {
	     return reviewScore;
	 }
	
	 public void setReviewScore(int reviewScore) {
	     this.reviewScore = reviewScore;
	 }
	
	 public String getMemEmail() {
	     return memEmail;
	 }
	
	 public void setMemEmail(String memEmail) {
	     this.memEmail = memEmail;
	 }
	
	 public String getReviewDate() {
	     return reviewDate;
	 }
	
	 public void setReviewDate(String reviewDate) {
	     this.reviewDate = reviewDate;
	 }


	   
}