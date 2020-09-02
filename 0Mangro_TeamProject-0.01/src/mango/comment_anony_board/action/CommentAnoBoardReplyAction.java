package mango.comment_anony_board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.comment_anony_board.db.CommentAnonyBoardBean;
import mango.comment_anony_board.db.CommentAnonyBoardDAO;

public class CommentAnoBoardReplyAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommentAnoBoardReplyAction excute()");
		
		request.setCharacterEncoding("UTF-8");
		int ano_board_num = Integer.parseInt(request.getParameter("ano_board_num"));
		System.out.println("값은 받아옴 ano_board_num = " + ano_board_num );
//		mem_email:$("#session_memEmail").val(), 
//		ano_board_num:$("#init_boardNum").val(),
//		ano_comment_content:$("#init_content").val(),
//		ano_re_ref:ano_comment_num
//		
		
		// DAO에 넘길 값 처리(총 10개 변수 중 6개 메소드 내에서 자체처리)
		CommentAnonyBoardBean commBean = new CommentAnonyBoardBean();
		commBean.setAno_board_num(ano_board_num);
		commBean.setMem_email(request.getParameter("mem_email"));
		commBean.setAno_comment_content(request.getParameter("ano_comment_content"));
		
		commBean.setAno_re_ref(Integer.parseInt(request.getParameter("ano_re_ref")));
		commBean.setAno_re_seq(Integer.parseInt(request.getParameter("ano_re_seq")));
		commBean.setAno_re_lev(Integer.parseInt(request.getParameter("ano_re_lev")));
		
		commBean.setAno_comment_ip((String)request.getRemoteAddr());
		
		// DAO 생성 및 대댓글 insert메소드(replyCommANBoard) 사용
		CommentAnonyBoardDAO commDAO = new CommentAnonyBoardDAO();
		commDAO.replyCommANBoard(commBean);
		
		
		System.out.println("CommentAnoBoardReplyAction에서 대댓글 객체 상태보기"+commBean);
		
		// 댓글 insert 후 해당 게시글로 돌아가기
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/AnoBoardSingleAction.anob?ano_board_num="+ano_board_num);
		
		return forward;
	}
}
