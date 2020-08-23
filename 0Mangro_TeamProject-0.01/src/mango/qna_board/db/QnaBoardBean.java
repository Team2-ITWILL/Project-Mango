package mango.qna_board.db;

//문의게시판 
public class QnaBoardBean {

	 // 글번호 
  private int qnaBoardNum;

  // 이메일 
  private String memEmail;

  // 비밀번호 
  private String qnaBoardPwd;

  // 제목 
  private String qnaBoardTitle;

  // 내용 
  private String qnaBoardContent;

  // 조회수 
  private int qnaBoardRead;

  // 작성일자 
  private String qnaBoardDate;

  // 아이피 
  private String qnaBoardIp;


  public int getQnaBoardNum() {
      return qnaBoardNum;
  }

  public void setQnaBoardNum(int qnaBoardNum) {
      this.qnaBoardNum = qnaBoardNum;
  }

  public String getMemEmail() {
      return memEmail;
  }

  public void setMemEmail(String memEmail) {
      this.memEmail = memEmail;
  }

  public String getQnaBoardPwd() {
      return qnaBoardPwd;
  }

  public void setQnaBoardPwd(String qnaBoardPwd) {
      this.qnaBoardPwd = qnaBoardPwd;
  }

  public String getQnaBoardTitle() {
      return qnaBoardTitle;
  }

  public void setQnaBoardTitle(String qnaBoardTitle) {
      this.qnaBoardTitle = qnaBoardTitle;
  }

  public String getQnaBoardContent() {
      return qnaBoardContent;
  }

  public void setQnaBoardContent(String qnaBoardContent) {
      this.qnaBoardContent = qnaBoardContent;
  }

  public int getQnaBoardRead() {
      return qnaBoardRead;
  }

  public void setQnaBoardRead(int qnaBoardRead) {
      this.qnaBoardRead = qnaBoardRead;
  }

  public String getQnaBoardDate() {
      return qnaBoardDate;
  }

  public void setQnaBoardDate(String qnaBoardDate) {
      this.qnaBoardDate = qnaBoardDate;
  }

  public String getQnaBoardIp() {
      return qnaBoardIp;
  }

  public void setQnaBoardIp(String qnaBoardIp) {
      this.qnaBoardIp = qnaBoardIp;
  }

 


}