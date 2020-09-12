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
		
		request.setCharacterEncoding("UTF-8");
		
		// 익명글 상세 정보를 담아갈 AnonyBoardBean 객체 생성
		AnonyBoardBean boardSingle = new AnonyBoardBean();
		
		System.out.println("값 받아옴");
		// 익명글 목록 화면에서 보내온 글번호 정보 받기
		int ano_board_num = Integer.parseInt(request.getParameter("ano_board_num"));
		
		// DAO로 값 전달 후 조회수 증가와 익명글 1개의 정보를 가져오는 메소드 실행
		AnonyBoardDAO andao = new AnonyBoardDAO();
		
		// 조회수 증가 메소드
		andao.updateANBoardRead(ano_board_num);
		
		// 글 1개의 정보를 boardSingle객체로 가져오는 메소드
		boardSingle = andao.getANBoard(ano_board_num);
		
		System.out.println(boardSingle);
		
		String fileName = boardSingle.getAno_board_file();
		
		// 첨부파일이 null값일 경우 "" 처리하여 nullpointer예외 방지
		if(fileName == null) {
			fileName = "";
		}
		
		// 첨부된 파일의 타입을 substring() 함수로 추출
		String fileType = fileName.substring(fileName.lastIndexOf(".")+1);

		// request영역에 boardSingle로 담아 뷰페이지 anony_board_single.jsp로 전송
		request.setAttribute("boardSingle", boardSingle);
		request.setAttribute("fileType", fileType);

		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/4index.jsp?center=O_anony/anony_board_single.jsp");
		
		return forward;
	}

}

