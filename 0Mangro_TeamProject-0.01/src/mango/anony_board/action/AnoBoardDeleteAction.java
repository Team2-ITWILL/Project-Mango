package mango.anony_board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;

public class AnoBoardDeleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, 
								HttpServletResponse response) throws Exception {
		
		System.out.println("AnoBoardDeleteAction excute()");
		
		
		ActionForward forward = new ActionForward();
		
		
		return forward;
	}

}
