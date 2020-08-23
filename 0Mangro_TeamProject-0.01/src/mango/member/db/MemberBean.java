package mango.member.db;

// 회원 테이블 
public class MemberBean {

    // 회원번호 
    private Integer memNum;

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

    public Integer getMemNum() {
        return memNum;
    }

    public void setMemNum(Integer memNum) {
        this.memNum = memNum;
    }

    public String getMemEmail() {
        return memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemPwd() {
        return memPwd;
    }

    public void setMemPwd(String memPwd) {
        this.memPwd = memPwd;
    }

    public String getMemAdmin() {
        return memAdmin;
    }

    public void setMemAdmin(String memAdmin) {
        this.memAdmin = memAdmin;
    }

    public String getMemJoindate() {
        return memJoindate;
    }

    public void setMemJoindate(String memJoindate) {
        this.memJoindate = memJoindate;
    }

    public String getMemBaned() {
        return memBaned;
    }

    public void setMemBaned(String memBaned) {
        this.memBaned = memBaned;
    }

    public String getMemSeceded() {
        return memSeceded;
    }

    public void setMemSeceded(String memSeceded) {
        this.memSeceded = memSeceded;
    }

}