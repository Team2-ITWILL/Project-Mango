package mango.qna_board.action;

import java.io.PrintStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mango.action.Action;
import mango.action.ActionForward;
import mango.qna_board.db.QnaBoardBean;
import mango.qna_board.db.QnaBoardDAO;

public class QnaBoardReWriteAction
  implements Action
{
  public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    System.out.println("QnaBoardReWriteAction 실행");

    request.setCharacterEncoding("UTF-8");

    QnaBoardBean qbean = new QnaBoardBean();
    QnaBoardDAO qdao = new QnaBoardDAO();

    qbean.setMem_email(request.getParameter("mem_email"));
    qbean.setQna_board_num(Integer.parseInt(request.getParameter("qna_board_num")));
    qbean.setQna_re_lev(Integer.parseInt(request.getParameter("qna_re_lev")));
    qbean.setQna_re_ref(Integer.parseInt(request.getParameter("qna_re_ref")));
    qbean.setQna_re_seq(Integer.parseInt(request.getParameter("qna_re_seq")));
    qbean.setQna_board_pwd(request.getParameter("qna_board_pwd"));
    qbean.setQna_board_title(request.getParameter("qna_board_title"));
    qbean.setQna_board_content(request.getParameter("qna_board_content"));
    qbean.setQna_board_ip(request.getRemoteAddr());
    qbean.setQna_notice(request.getParameter("qna_notice"));

    qdao.reInsertQnaBoard(qbean);

    ActionForward forward = new ActionForward();
    forward.setRedirect(true);
    forward.setPath("./QnaBoard.qna");

    return forward;
  }
}