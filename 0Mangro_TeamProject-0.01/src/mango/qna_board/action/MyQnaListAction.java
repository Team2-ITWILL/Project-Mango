package mango.qna_board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;

public class MyQnaListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   
		
		
		
		ActionForward forward = new ActionForward();
	    forward.setRedirect(false);
	    forward.setPath("./4index.jsp?center=O_mypage/my_qna_board.jsp");

		return forward;	
		
	
	}

}
