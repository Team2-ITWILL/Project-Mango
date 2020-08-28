package mango.member.db;

import java.util.Date;

// 회원 테이블 
public class MemberBean {

  
    // 이메일 
    private String memEmail;

    // 이름 
    private String memName;

    // 비밀번호 
    private String memPwd;

    // 학원관리자여부 
    private String memAdmin;

    // 가입일자 
    private String memJoindate;

    // 계정정지일자 
    private String memBaned;

    // 탈퇴일자 
    private String memSeceded;

	public String getMemEmail() {return memEmail;}
	public String getMemName() {return memName;}
	public String getMemPwd() {	return memPwd;}
	public String getMemAdmin() {return memAdmin;}
	public String getMemJoindate() {return memJoindate;}
	public String getMemBaned() {return memBaned;}
	public String getMemSeceded() {return memSeceded;}
	
	public void setMemEmail(String memEmail) {this.memEmail = memEmail;}
	public void setMemName(String memName) {this.memName = memName;}
	public void setMemPwd(String memPwd) {this.memPwd = memPwd;}
	public void setMemAdmin(String memAdmin) {this.memAdmin = memAdmin;}
	public void setMemJoindate(String memJoindate) {this.memJoindate = memJoindate;}
	public void setMemBaned(String memBaned) {this.memBaned = memBaned;}
	public void setMemSeceded(String memSeceded) {this.memSeceded = memSeceded;}
	
	@Override
	public String toString() {
		return "MemberBean [memEmail=" + memEmail + ", memName=" + memName + ", memPwd=" + memPwd + ", memAdmin="
				+ memAdmin + ", memJoindate=" + memJoindate + ", memBaned=" + memBaned + ", memSeceded=" + memSeceded
				+ "]";
	}
    
}