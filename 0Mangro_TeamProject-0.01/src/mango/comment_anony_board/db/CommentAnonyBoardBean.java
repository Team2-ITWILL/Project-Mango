package mango.comment_anony_board.db;

//익명게시판
public class CommentAnonyBoardBean {
	
	// 댓글번호 
  private int anoCommentNum;

  // 글번호 
  private int anoBoardNum;

  // 댓글내용 
  private String anoCommentContent;

  // 이메일 
  private String memEmail;

  // 그룹번호(부모댓글번호) 
  private int anoReRef;

  // 대댓글 들여쓰기 정도값 
  private int anoReLev;

  // 그룹순번(부모댓글 내 대댓글의 순번) 
  private int anoReSeq;

  // 작성일자 
  private String anoCommentDate;

  // 아이피 
  private String anoCommentIp;

  public int getanoCommentNum() {
      return anoCommentNum;
  }

  public void setanoCommentNum(int anoCommentNum) {
      this.anoCommentNum = anoCommentNum;
  }

  public int getanoBoardNum() {
      return anoBoardNum;
  }

  public void setanoBoardNum(int anoBoardNum) {
      this.anoBoardNum = anoBoardNum;
  }

  public String getanoCommentContent() {
      return anoCommentContent;
  }

  public void setanoCommentContent(String anoCommentContent) {
      this.anoCommentContent = anoCommentContent;
  }

  public String getMemEmail() {
      return memEmail;
  }

  public void setMemEmail(String memEmail) {
      this.memEmail = memEmail;
  }

  public int getanoReRef() {
      return anoReRef;
  }

  public void setanoReRef(int anoReRef) {
      this.anoReRef = anoReRef;
  }

  public int getanoReLev() {
      return anoReLev;
  }

  public void setanoReLev(int anoReLev) {
      this.anoReLev = anoReLev;
  }

  public int getanoReSeq() {
      return anoReSeq;
  }

  public void setanoReSeq(int anoReSeq) {
      this.anoReSeq = anoReSeq;
  }

  public String getanoCommentDate() {
      return anoCommentDate;
  }

  public void setanoCommentDate(String anoCommentDate) {
      this.anoCommentDate = anoCommentDate;
  }

  public String getanoCommentIp() {
      return anoCommentIp;
  }

  public void setanoCommentIp(String anoCommentIp) {
      this.anoCommentIp = anoCommentIp;
  }

}
