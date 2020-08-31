package mango.qna_board.action;

import java.io.PrintStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mango.action.Action;
import mango.action.ActionForward;
import mango.qna_board.db.QnaBoardBean;
import mango.qna_board.db.QnaBoardDAO;

// QnaBoard 내용 확인 액션
public class QnaBoardContentAction implements Action{
  public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
    throws Exception{
    System.out.println("QnaBoardContentAction() 실행!");

    int qna_board_num = Integer.parseInt(request.getParameter("qna_board_num"));
    String pageNum = request.getParameter("pageNum");

    QnaBoardDAO qdao = new QnaBoardDAO();

    qdao.UpdateReadCount(qna_board_num);

    QnaBoardBean qbean = qdao.getQnaBoard(qna_board_num);

    request.setAttribute("qbean", qbean);
    request.setAttribute("pageNum", pageNum);

    ActionForward forward = new ActionForward();
    forward.setRedirect(false);
    forward.setPath("./4index.jsp?center=O_qna/qna_page.jsp");

    return forward;
  }
}