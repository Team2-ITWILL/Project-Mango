package mango.comment_anony_board.db;

import java.sql.Timestamp;

  // [익명사담방 댓글]
public class CommentAnonyBoardBean {
	
  // [멤버변수]
  	
  // 댓글번호 
  private int ano_comment_num;

  // 글번호 
  private int ano_board_num;

  // 댓글내용 
  private String ano_comment_content;

  // 이메일 
  private String mem_email;

  // 그룹번호(부모댓글번호) 
  private int ano_re_ref;

  // 대댓글 들여쓰기 정도값 
  private int ano_re_lev;

  // 그룹순번(부모댓글 내 대댓글의 순번) 
  private int ano_re_seq;

  // 작성일자 
  private Timestamp ano_comment_date;

  // 아이피 
  private String ano_comment_ip;

  // 닉네임
  private String ano_board_nick;

  
  
  
  // [getter/setter]
	public int getAno_comment_num() {
		return ano_comment_num;
	}
	
	public void setAno_comment_num(int ano_comment_num) {
		this.ano_comment_num = ano_comment_num;
	}
	
	public int getAno_board_num() {
		return ano_board_num;
	}
	
	public void setAno_board_num(int ano_board_num) {
		this.ano_board_num = ano_board_num;
	}
	
	public String getAno_comment_content() {
		return ano_comment_content;
	}
	
	public void setAno_comment_content(String ano_comment_content) {
		this.ano_comment_content = ano_comment_content;
	}
	
	public String getMem_email() {
		return mem_email;
	}
	
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	
	public int getAno_re_ref() {
		return ano_re_ref;
	}
	
	public void setAno_re_ref(int ano_re_ref) {
		this.ano_re_ref = ano_re_ref;
	}
	
	public int getAno_re_lev() {
		return ano_re_lev;
	}
	
	public void setAno_re_lev(int ano_re_lev) {
		this.ano_re_lev = ano_re_lev;
	}
	
	public int getAno_re_seq() {
		return ano_re_seq;
	}
	
	public void setAno_re_seq(int ano_re_seq) {
		this.ano_re_seq = ano_re_seq;
	}
	
	public Timestamp getAno_comment_date() {
		return ano_comment_date;
	}
	
	public void setAno_comment_date(Timestamp ano_comment_date) {
		this.ano_comment_date = ano_comment_date;
	}
	
	public String getAno_comment_ip() {
		return ano_comment_ip;
	}
	
	public void setAno_comment_ip(String ano_comment_ip) {
		this.ano_comment_ip = ano_comment_ip;
	}
	
	public String getAno_board_nick() {
		return ano_board_nick;
	}
	
	public void setAno_board_nick(String ano_board_nick) {
		this.ano_board_nick = ano_board_nick;
	}


	

	
	// [toString 오버라이딩]
	
	  
	@Override
	public String toString() {
		return "CommentAnonyBoardBean [ano_comment_num=" + ano_comment_num + ", ano_board_num=" + ano_board_num
				+ ", ano_comment_content=" + ano_comment_content + ", mem_email=" + mem_email + ", ano_re_ref="
				+ ano_re_ref + ", ano_re_lev=" + ano_re_lev + ", ano_re_seq=" + ano_re_seq + ", ano_comment_date="
				+ ano_comment_date + ", ano_comment_ip=" + ano_comment_ip + ", ano_board_nick=" + ano_board_nick + "]";
	}
	  
  
  
 

}
