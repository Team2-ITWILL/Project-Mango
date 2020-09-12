package mango.anony_board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardBean;
import mango.anony_board.db.AnonyBoardDAO;

public class AnoBoardToUpdateFormAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("AnoBoardToUpdateFormAction excute()");
		
		request.setCharacterEncoding("UTF-8");
		
		int ano_board_num = Integer.parseInt(request.getParameter("ano_board_num"));
		
		// DAO 생성
		AnonyBoardDAO andao = new AnonyBoardDAO();
		
		// DAO의 랜덤닉네임 생성 메소드 호출 & request영역에 세팅
		String nick = andao.getRandomNickname();
		request.setAttribute("nick", nick);
		
		// 기존에 작성한 글 내용을 불러오는 메소드 호출&request영역에 세팅
		
		AnonyBoardBean anbean = andao.getANBoard(ano_board_num);
		request.setAttribute("anbean", anbean);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_anony/anony_board_revise.jsp");
		
		return forward;
		
	}

}

