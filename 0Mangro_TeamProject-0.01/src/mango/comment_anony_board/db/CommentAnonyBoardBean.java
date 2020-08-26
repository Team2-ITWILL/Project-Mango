package mango.comment_anony_board.db;

import java.sql.Date;

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
  private Date anoCommentDate;

  // 아이피 
  private String anoCommentIp;

  
  // getter/setter
	public int getAnoCommentNum() {
		return anoCommentNum;
	}
	
	public void setAnoCommentNum(int anoCommentNum) {
		this.anoCommentNum = anoCommentNum;
	}
	
	public int getAnoBoardNum() {
		return anoBoardNum;
	}
	
	public void setAnoBoardNum(int anoBoardNum) {
		this.anoBoardNum = anoBoardNum;
	}
	
	public String getAnoCommentContent() {
		return anoCommentContent;
	}
	
	public void setAnoCommentContent(String anoCommentContent) {
		this.anoCommentContent = anoCommentContent;
	}
	
	public String getMemEmail() {
		return memEmail;
	}
	
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	
	public int getAnoReRef() {
		return anoReRef;
	}
	
	public void setAnoReRef(int anoReRef) {
		this.anoReRef = anoReRef;
	}
	
	public int getAnoReLev() {
		return anoReLev;
	}
	
	public void setAnoReLev(int anoReLev) {
		this.anoReLev = anoReLev;
	}
	
	public int getAnoReSeq() {
		return anoReSeq;
	}
	
	public void setAnoReSeq(int anoReSeq) {
		this.anoReSeq = anoReSeq;
	}
	
	public Date getAnoCommentDate() {
		return anoCommentDate;
	}
	
	public void setAnoCommentDate(Date anoCommentDate) {
		this.anoCommentDate = anoCommentDate;
	}
	
	public String getAnoCommentIp() {
		return anoCommentIp;
	}
	
	public void setAnoCommentIp(String anoCommentIp) {
		this.anoCommentIp = anoCommentIp;
	}
	
	  
	  
	  
  
  
  
  
  
  
  
  
  
 

}
