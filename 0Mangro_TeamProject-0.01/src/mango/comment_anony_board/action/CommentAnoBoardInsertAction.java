package mango.comment_anony_board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.comment_anony_board.db.CommentAnonyBoardBean;
import mango.comment_anony_board.db.CommentAnonyBoardDAO;

//[ano_board_single.jsp의 댓글달기 ajax로부터 값을 얻어와 DAO에 INSERT]
public class CommentAnoBoardInsertAction implements Action {
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommentAnoBoardInsertAction excute()");
		
		request.setCharacterEncoding("UTF-8");
		int ano_board_num = Integer.parseInt(request.getParameter("ano_board_num"));
		
		// DAO에 넘길 값 처리(총 10개 변수 중 6개 메소드 내에서 자체처리)
		CommentAnonyBoardBean commBean = new CommentAnonyBoardBean();
		commBean.setAno_board_num(ano_board_num);
		commBean.setMem_email(request.getParameter("mem_email"));
		commBean.setAno_comment_content(request.getParameter("ano_comment_content"));
		commBean.setAno_comment_ip((String)request.getRemoteAddr());
		
		// DAO 생성 및 댓글 insert메소드 사용
		CommentAnonyBoardDAO commDAO = new CommentAnonyBoardDAO();
		commDAO.insertCommANBoard(commBean);
		
		
		System.out.println(commBean);
		
		// 댓글 insert 후 해당 게시글로 돌아가기
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/AnoBoardSingleAction.anob?ano_board_num="+ano_board_num);
		
		return forward;
	}

}
