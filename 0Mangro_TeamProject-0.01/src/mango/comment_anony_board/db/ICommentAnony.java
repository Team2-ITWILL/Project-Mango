package mango.comment_anony_board.db;

public interface ICommentAnony {
		
	
	//익명게시판 댓글 작성
	public int insertanonyComment(CommentAnonyBoardBean cab);
	
	
	//댓글 삭제
	public int deleteanonyComment(CommentAnonyBoardBean cab);
	
	
	//댓글 수정
	public int updateanonyComment(CommentAnonyBoardBean cab);
	
	
	
	
	
}
