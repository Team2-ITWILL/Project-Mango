package mango.anony_board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardDAO;

public class AnoBoardDeleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, 
								HttpServletResponse response) throws Exception {
		System.out.println("AnoBoardDeleteAction excute()");
		
		int ano_board_num = Integer.parseInt(request.getParameter("ano_board_num"));
		System.out.println(ano_board_num);
		AnonyBoardDAO andao = new AnonyBoardDAO();
		
		andao.deleteANBoard(ano_board_num);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/AnonyBoardListAction.anob");
		
		return forward;
	}

}
