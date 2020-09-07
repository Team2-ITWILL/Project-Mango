package mango.comment_anony_board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.comment_anony_board.db.CommentAnonyBoardBean;
import mango.comment_anony_board.db.CommentAnonyBoardDAO;

public class CommentAnoBoardUpdateAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommentAnoBoardUpdateAction excute()");
		
		request.setCharacterEncoding("UTF-8");
		int ano_board_num = Integer.parseInt(request.getParameter("ano_board_num"));		
		int ano_comment_num = Integer.parseInt(request.getParameter("ano_comment_num"));
		String ano_comment_content = request.getParameter("ano_comment_content");
		
		// commBean 객체 생성
		CommentAnonyBoardBean commBean = new CommentAnonyBoardBean();
		commBean.setAno_comment_content(ano_comment_content);
		commBean.setAno_comment_num(ano_comment_num);
		commBean.setAno_board_num(ano_board_num);
		
		System.out.println("CommentAnoBoardUpdateAction 내부에서 commbean : "+commBean);
		
		// DAO생성 및 댓글 update 메소드 사용
		CommentAnonyBoardDAO commDAO = new CommentAnonyBoardDAO();
		commDAO.updateCommANBoard(commBean);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/AnoBoardSingleAction.anob?ano_board_num="+ano_board_num);
				
		return forward;
	}

	
	
}
