package mango.qna_board.db;

import java.sql.Date;
import java.sql.Timestamp;

public class QnaBoardBean
{
  private int qna_board_num;
  private String mem_email;
  private String qna_board_pwd;
  private String qna_board_title;
  private String qna_board_content;
  private int qna_board_read;
  private Timestamp qna_board_date;
  private String qna_board_ip;
  private int qna_re_lev;
  private int qna_re_ref;
  private int qna_re_seq;
  private String qna_notice;

  public int getQna_board_num()
  {
    return this.qna_board_num;
  }

  public void setQna_board_num(int qna_board_num) {
    this.qna_board_num = qna_board_num;
  }

  public String getMem_email() {
    return this.mem_email;
  }

  public void setMem_email(String mem_email) {
    this.mem_email = mem_email;
  }

  public String getQna_board_pwd() {
    return this.qna_board_pwd;
  }

  public void setQna_board_pwd(String qna_board_pwd) {
    this.qna_board_pwd = qna_board_pwd;
  }

  public String getQna_board_title() {
    return this.qna_board_title;
  }

  public void setQna_board_title(String qna_board_title) {
    this.qna_board_title = qna_board_title;
  }

  public String getQna_board_content() {
    return this.qna_board_content;
  }

  public void setQna_board_content(String qna_board_content) {
    this.qna_board_content = qna_board_content;
  }

  public int getQna_board_read()
  {
    return this.qna_board_read;
  }

  public void setQna_board_read(int qna_board_read) {
    this.qna_board_read = qna_board_read;
  }


  public Timestamp getQna_board_date() {
	return qna_board_date;
	}
	
	public void setQna_board_date(Timestamp qna_board_date) {
		this.qna_board_date = qna_board_date;
	}

public String getQna_board_ip() {
    return this.qna_board_ip;
  }

  public void setQna_board_ip(String qna_board_ip) {
    this.qna_board_ip = qna_board_ip;
  }

  public int getQna_re_lev() {
    return this.qna_re_lev;
  }

  public void setQna_re_lev(int qna_re_lev) {
    this.qna_re_lev = qna_re_lev;
  }

  public int getQna_re_ref() {
    return this.qna_re_ref;
  }

  public void setQna_re_ref(int qna_re_ref) {
    this.qna_re_ref = qna_re_ref;
  }

  public int getQna_re_seq() {
    return this.qna_re_seq;
  }

  public void setQna_re_seq(int qna_re_seq) {
    this.qna_re_seq = qna_re_seq;
  }

public String getQna_notice() {
	return qna_notice;
}

public void setQna_notice(String qna_notice) {
	this.qna_notice = qna_notice;
}

}