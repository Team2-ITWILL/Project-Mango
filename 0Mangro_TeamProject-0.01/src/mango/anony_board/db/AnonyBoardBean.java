package mango.anony_board.db;

public class AnonyBoardBean{
		//익명 게시판
	// 글번호 
	private int anoBoardNum;
	
	// 이메일 
	private String memEmail;
	
	// 제목 
	private String anoBoardTitle;
	
	// 내용 
	private String anoBoardContent;
	
	// 조회수 
	private int anoBoardRead;
	
	// 작성일자 
	private String anoBoardDate;
	
	// 아이피 
	private String anoBoardIp;
	
	public int getAnoBoardNum() {
	return anoBoardNum;
	}
	
	public void setAnoBoardNum(int anoBoardNum) {
	this.anoBoardNum = anoBoardNum;
	}
	
	public String getMemEmail() {
	return memEmail;
	}
	
	public void setMemEmail(String memEmail) {
	this.memEmail = memEmail;
	}
	
	public String getAnoBoardTitle() {
	return anoBoardTitle;
	}
	
	public void setAnoBoardTitle(String anoBoardTitle) {
	this.anoBoardTitle = anoBoardTitle;
	}
	
	public String getAnoBoardContent() {
	return anoBoardContent;
	}
	
	public void setAnoBoardContent(String anoBoardContent) {
	this.anoBoardContent = anoBoardContent;
	}
	
	public int getAnoBoardRead() {
	return anoBoardRead;
	}
	
	public void setAnoBoardRead(int anoBoardRead) {
	this.anoBoardRead = anoBoardRead;
	}
	
	public String getAnoBoardDate() {
	return anoBoardDate;
	}
	
	public void setAnoBoardDate(String anoBoardDate) {
	this.anoBoardDate = anoBoardDate;
	}
	
	public String getAnoBoardIp() {
	return anoBoardIp;
	}
	
	public void setAnoBoardIp(String anoBoardIp) {
	this.anoBoardIp = anoBoardIp;
	}


}