package mango.comment_qna_board.db;

import java.sql.Date;

public class CommentQnaBoardBean {
	 // 댓글번호 
    private int qnaCommentNum;

    // 글번호 
    private int qnaBoardNum;

    // 댓글내용 
    private String qnaCommentContent;

    // 이메일 
    private String memEmail;

    // 그룹번호(부모댓글번호) 
    private int qnaReRef;

    // 대댓글 들여쓰기 정도값 
    private int qnaReLev;

    // 그룹순번(부모댓글 내 대댓글의 순번) 
    private int qnaReSeq;

    // 작성일자 
    private Date qnaCommentDate;

    // 아이피 
    private String qnaCommentIp;

    
    
    // getter/setter
	public int getQnaCommentNum() {
		return qnaCommentNum;
	}

	public void setQnaCommentNum(int qnaCommentNum) {
		this.qnaCommentNum = qnaCommentNum;
	}

	public int getQnaBoardNum() {
		return qnaBoardNum;
	}

	public void setQnaBoardNum(int qnaBoardNum) {
		this.qnaBoardNum = qnaBoardNum;
	}

	public String getQnaCommentContent() {
		return qnaCommentContent;
	}

	public void setQnaCommentContent(String qnaCommentContent) {
		this.qnaCommentContent = qnaCommentContent;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public int getQnaReRef() {
		return qnaReRef;
	}

	public void setQnaReRef(int qnaReRef) {
		this.qnaReRef = qnaReRef;
	}

	public int getQnaReLev() {
		return qnaReLev;
	}

	public void setQnaReLev(int qnaReLev) {
		this.qnaReLev = qnaReLev;
	}

	public int getQnaReSeq() {
		return qnaReSeq;
	}

	public void setQnaReSeq(int qnaReSeq) {
		this.qnaReSeq = qnaReSeq;
	}

	public Date getQnaCommentDate() {
		return qnaCommentDate;
	}

	public void setQnaCommentDate(Date qnaCommentDate) {
		this.qnaCommentDate = qnaCommentDate;
	}

	public String getQnaCommentIp() {
		return qnaCommentIp;
	}

	public void setQnaCommentIp(String qnaCommentIp) {
		this.qnaCommentIp = qnaCommentIp;
	}

    
    
    
    

}
