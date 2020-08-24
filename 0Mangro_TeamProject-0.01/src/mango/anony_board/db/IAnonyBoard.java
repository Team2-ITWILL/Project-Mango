package mango.anony_board.db;

import java.util.List;

import mango.member.db.MemberBean;

public interface IAnonyBoard {

	
	/*//게시판 글 목록 갖고오기
	public List<BoardBean> getBoardList(int StartRow,int pageSize);
	*/	    
	        
	//게시판 글 저장
	public int InsertBoard(AnonyBoardBean board);
		 
	//게시판 글 수정
	public int UpdateBoard(AnonyBoardBean board);
	
	//게시판 글 삭제
	public int DelelteBoard(AnonyBoardBean board);
	
	//게시판 조회수
	public void updateReadCount(AnonyBoardBean board);

	//게시판 글 내용 갖고오기
	public AnonyBoardBean getBoardContent(AnonyBoardBean board);
	
	//게시판 글 검색
	public List<AnonyBoardBean> SearchBoard(String search);
	
	//게시판 글 있는지 없는 지 확인
	public int getCountBoard();
	
}
