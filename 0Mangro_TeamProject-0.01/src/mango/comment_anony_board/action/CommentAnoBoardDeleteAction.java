package mango.comment_anony_board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.comment_anony_board.db.CommentAnonyBoardDAO;

public class CommentAnoBoardDeleteAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommentAnoBoardDeleteAction excute()");
		
		request.setCharacterEncoding("UTF-8");
		int ano_comment_num = Integer.parseInt(request.getParameter("ano_comment_num"));
		int ano_board_num = Integer.parseInt(request.getParameter("ano_board_num"));	
		System.out.println("CommentAnoBoardDeleteAction 잘 왔고 값은 "+ano_board_num + " 와 "+ano_comment_num);
		// DAO생성 및 댓글 delete 메소드 사용
		CommentAnonyBoardDAO commDAO = new CommentAnonyBoardDAO();
		commDAO.deleteCommANBoard(ano_comment_num);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/AnoBoardSingleAction.anob?ano_board_num="+ano_board_num);
				
		return forward;
	}
}
