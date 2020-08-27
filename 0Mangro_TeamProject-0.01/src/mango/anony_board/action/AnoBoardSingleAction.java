package mango.anony_board.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardBean;
import mango.anony_board.db.AnonyBoardDAO;

public class AnoBoardSingleAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, 
								HttpServletResponse response) throws Exception {
		System.out.println("AnoBoardSingleAction excute()");
		
		// 글 상세 정보를 담아갈 AnonyBoardBean 객체 생성
		AnonyBoardBean boardSingle = new AnonyBoardBean();
		
		// 글 상세 내용 불러오기
		
		// 글 목록 화면에서 보내온 글번호 정보 받기
		int ano_board_num = Integer.parseInt(request.getParameter("ano_board_num"));
		
		// DAO로 값 전달 후 글 1개의 정보를 가져오는 메소드 실행
		AnonyBoardDAO andao = new AnonyBoardDAO();
		boardSingle = andao.getANBoard(ano_board_num);
		
		System.out.println(boardSingle);
		
		// request영역에 boardSingle로 담아 뷰페이지 anony_board_single.jsp로 전송
		request.setAttribute("boardSingle", boardSingle);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/4index.jsp?center=O_anony/anony_board_single.jsp");
		
		return forward;
	}

}
