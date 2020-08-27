package mango.anony_board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardBean;
import mango.anony_board.db.AnonyBoardDAO;

public class AnoBoardUpdateAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AnoBoardUpdateAction excute()");
		
		
		int ano_board_num = Integer.parseInt(request.getParameter("ano_board_num"));
		
		System.out.println(ano_board_num);
		AnonyBoardDAO andao = new AnonyBoardDAO();

		AnonyBoardBean anbean = new AnonyBoardBean();
		anbean.setAno_board_content(request.getParameter("ano_board_content"));
		anbean.setAno_board_nick(request.getParameter("nick"));
		anbean.setAno_board_title(request.getParameter("title"));
		anbean.setAno_board_file(request.getParameter("file"));
		
		
		int check = andao.updateANBoard(anbean);
		
		if(check == 1){
			
			System.out.println("수정성공");
			
		}else{
			System.out.println("수정실패");
			
			
		}
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/AnoBoardSingleAction.anob?ano_board_num="+ano_board_num);
		return forward;
	}

}
