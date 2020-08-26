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
	private String ano_board_date;
	
	// 아이피 
	private String ano_board_ip;

	// 랜덤닉네임
	private String ano_board_nick;
	
	// 이미지 파일
	private String ano_board_file;
	
	
	
	
	
	
	// 생성자

	public AnonyBoardBean(){}






	public AnonyBoardBean(int ano_board_num, String mem_email, String ano_board_title, String ano_board_content,
			int ano_board_read, String ano_board_date, String ano_board_ip, String ano_board_nick,
			String ano_board_file) {
		super();
		this.ano_board_num = ano_board_num;
		this.mem_email = mem_email;
		this.ano_board_title = ano_board_title;
		this.ano_board_content = ano_board_content;
		this.ano_board_read = ano_board_read;
		this.ano_board_date = ano_board_date;
		this.ano_board_ip = ano_board_ip;
		this.ano_board_nick = ano_board_nick;
		this.ano_board_file = ano_board_file;
	}











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




	public String getAno_board_date() {
		return ano_board_date;
	}




	public void setAno_board_date(String ano_board_date) {
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



	
	
	

}