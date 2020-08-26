package mango.anony_board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardDAO;

public class AnonyBoardWriteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("익명사담방 글작성 하기 AnonyBoardWriteAction excute()");
		AnonyBoardDAO andao = new AnonyBoardDAO();
		
		
		
		
		return null;
	}

}
