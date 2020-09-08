package mango.anony_board.db;

import java.sql.Timestamp;

public class AnonyBoardBean{
		//익명 게시판
	// 글번호 
	private int ano_board_num;
	
	// 이메일 
	private String mem_email;
	
	// 제목 
	private String ano_board_title;
	
	// 내용 
	private String ano_board_content;
	
	// 조회수 
	private int ano_board_read;
	
	// 작성일자 
	private Timestamp ano_board_date;
	
	// 아이피 
	private String ano_board_ip;

	// 랜덤닉네임
	private String ano_board_nick;
	
	// 이미지 파일
	private String ano_board_file;
	
	// 신고여부
	private String ano_board_reported;
	
	// 신고자
	private String ano_board_reporter;
	
	// 신고사유
	private String ano_board_reason;
	
	


	// setter/getter

	public int getAno_board_num() {
		return ano_board_num;
	}

	public void setAno_board_num(int ano_board_num) {
		this.ano_board_num = ano_board_num;
	}


	public String getMem_email() {
		return mem_email;
	}


	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getAno_board_title() {
		return ano_board_title;
	}

	public void setAno_board_title(String ano_board_title) {
		this.ano_board_title = ano_board_title;
	}


	public String getAno_board_content() {
		return ano_board_content;
	}

	public void setAno_board_content(String ano_board_content) {
		this.ano_board_content = ano_board_content;
	}




	public int getAno_board_read() {
		return ano_board_read;
	}

	public void setAno_board_read(int ano_board_read) {
		this.ano_board_read = ano_board_read;
	}


	public Timestamp getAno_board_date() {
		return ano_board_date;
	}

	public void setAno_board_date(Timestamp ano_board_date) {
		this.ano_board_date = ano_board_date;
	}

	public String getAno_board_ip() {
		return ano_board_ip;
	}


	public void setAno_board_ip(String ano_board_ip) {
		this.ano_board_ip = ano_board_ip;
	}


	public String getAno_board_nick() {
		return ano_board_nick;
	}


	public void setAno_board_nick(String ano_board_nick) {
		this.ano_board_nick = ano_board_nick;
	}



	public String getAno_board_file() {
		return ano_board_file;
	}



	public void setAno_board_file(String ano_board_file) {
		this.ano_board_file = ano_board_file;
	}

	public String getAno_board_reported() {
		return ano_board_reported;
	}
	
	
	public void setAno_board_reported(String ano_board_reported) {
		this.ano_board_reported = ano_board_reported;
	}
	
	
	public String getAno_board_reporter() {
		return ano_board_reporter;
	}


	
	
	
	// toString() 메소드

	public void setAno_board_reporter(String ano_board_reporter) {
		this.ano_board_reporter = ano_board_reporter;
	}


	public String getAno_board_reason() {
		return ano_board_reason;
	}


	public void setAno_board_reason(String ano_board_reason) {
		this.ano_board_reason = ano_board_reason;
	}


	@Override
	public String toString() {
		return "AnonyBoardBean [ano_board_num=" + ano_board_num + ", mem_email=" + mem_email + ", ano_board_title="
				+ ano_board_title + ", ano_board_content=" + ano_board_content + ", ano_board_read=" + ano_board_read
				+ ", ano_board_date=" + ano_board_date + ", ano_board_ip=" + ano_board_ip + ", ano_board_nick="
				+ ano_board_nick + ", ano_board_file=" + ano_board_file + ", ano_board_reported=" + ano_board_reported
				+ ", ano_board_reporter=" + ano_board_reporter + ", ano_board_reason=" + ano_board_reason + "]";
	}
	

	
	
	
	
}