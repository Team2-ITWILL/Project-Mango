package mango.comment_qna_board.db;

public interface ICommentQna {
		
	
	//문의게시판 댓글 작성
	public int insertQnaComment(CommentQnaBoardBean cqb);
	
	
	//댓글 삭제
	public int deleteQnaComment(CommentQnaBoardBean cqb);
	
	
	//댓글 수정
	public int updateQnaComment(CommentQnaBoardBean cqb);
	
	
	
	
	
}
