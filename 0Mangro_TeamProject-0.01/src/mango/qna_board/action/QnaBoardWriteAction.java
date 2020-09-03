package mango.qna_board.action;

import java.io.PrintStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mango.action.Action;
import mango.action.ActionForward;
import mango.qna_board.db.QnaBoardBean;
import mango.qna_board.db.QnaBoardDAO;

public class QnaBoardWriteAction
  implements Action
{
  public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    System.out.println("QnaBoardWriteAction 실행");

    request.getParameter("UTF-8");

    QnaBoardBean qbean = new QnaBoardBean();

    qbean.setMem_email(request.getParameter("mem_email"));
    qbean.setQna_board_pwd(request.getParameter("qna_board_pwd"));
    qbean.setQna_board_title(request.getParameter("qna_board_title"));
    qbean.setQna_board_content(request.getParameter("qna_board_content"));
    qbean.setQna_board_ip(request.getRemoteAddr());
    qbean.setQna_notice(request.getParameter("qna_notice"));
    
    
    QnaBoardDAO qdao = new QnaBoardDAO();
    qdao.insertQnaBoard(qbean);

    System.out.println("QnaBoardWriteAction 글 작성 완료");

    ActionForward forward = new ActionForward();
    forward.setRedirect(true);
    forward.setPath("./QnaBoard.qna");

    return forward;
  }
}