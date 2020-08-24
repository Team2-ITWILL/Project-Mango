package mango.qna_board.db;

import java.util.List;

import mango.anony_board.db.AnonyBoardBean;

public interface IQnaBoard {
	
	//익명게시판이랑 겹침

	/*//게시판 글 목록 갖고오기
	public List<QnaBoardBean> getQnaBoardList(int StartRow,int pageSize);
	*/		
	
	//게시판 글 저장
	public int InsertQnaBoard(QnaBoardBean board);
		
	//게시판 글 수정
	public int UpdateQnaBoard(QnaBoardBean board);
	
	//게시판 글 삭제
	public int DelelteQnaBoard(QnaBoardBean board);
	
	//게시판 조회수
	public void updateReadCount(QnaBoardBean board);

	//게시판 글 내용 갖고오기
	public AnonyBoardBean getQnaBoardContent(QnaBoardBean board);
	
	//게시판 글 검색
	public List<AnonyBoardBean> SearchQnaBoard(String search);
	
	//게시판 글 있는지 없는 지 확인
	public int getCountQnaBoard();
	
	
}
