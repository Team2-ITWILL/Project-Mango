package mango.payment.db;

import java.sql.Date;


//결제테이블 
public class PaymentBean {

	 // 이메일 
	 private String memEmail;
	
	 // 사용회차 
	 private int pmUseNum;
	
	 // 이용서비스 
	 private String pmName;
	
	 // 결제일자 
	 private Date pmStartDate;
	
	 // 만료예정일자 
	 private Date pmExpDate;
	
	 public String getMemEmail() {
	     return memEmail;
	 }
	
	 public void setMemEmail(String memEmail) {
	     this.memEmail = memEmail;
	 }
	
	 public int getPmUseNum() {
	     return pmUseNum;
	 }
	
	 public void setPmUseNum(int pmUseNum) {
	     this.pmUseNum = pmUseNum;
	 }
	
	 public String getPmName() {
	     return pmName;
	 }
	
	 public void setPmName(String pmName) {
	     this.pmName = pmName;
	 }
	
	 public Date getPmStartDate() {
	     return pmStartDate;
	 }
	
	 public void setPmStartDate(Date pmStartDate) {
	     this.pmStartDate = pmStartDate;
	 }
	
	 public Date getPmExpDate() {
	     return pmExpDate;
	 }
	
	 public void setPmExpDate(Date pmExpDate) {
	     this.pmExpDate = pmExpDate;
	 }
	
}