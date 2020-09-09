package mango.qna_board.action;

import java.io.PrintStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mango.action.Action;
import mango.action.ActionForward;
import mango.qna_board.db.QnaBoardBean;
import mango.qna_board.db.QnaBoardDAO;

public class QnaBoardUpdateAction
  implements Action
{
  public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    System.out.println("QnaBoardUpdateAction 실행");

    request.setCharacterEncoding("UTF-8");

    String pageNum = request.getParameter("pageNum");

    QnaBoardBean qbean = new QnaBoardBean();
    QnaBoardDAO qdao = new QnaBoardDAO();

    qbean.setQna_board_num(Integer.parseInt(request.getParameter("qna_board_num")));
    qbean.setMem_email(request.getParameter("mem_email"));
    qbean.setQna_board_pwd(request.getParameter("qna_board_pwd"));
    qbean.setQna_board_title(request.getParameter("qna_board_title"));
    qbean.setQna_board_content(request.getParameter("qna_board_content"));
    qbean.setQna_notice(request.getParameter("qna_notice"));

    int check = qdao.UpdateQnaBoard(qbean);

    if (check == 0)
    {
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.print("<script>");
      out.print("alert('비밀번호가 일치하지 않습니다.');");
      out.print("history.back();");
      out.print("</script>");
      out.close();
      return null;
    }

    if (check == -1)
    {
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.print("<script>");
      out.print("alert('오류입니다.');");
      out.print("history.back();");
      out.print("</script>");
      out.close();
      return null;
    }

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.print("<script>");
    out.print("alert('글 수정 성공하였습니다.');");
    out.print("location.href = './QnaBoard.qna?pageNum=" + pageNum + "';");
    out.print("</script>");
    out.close();

    System.out.println("check = " + check);

    return null;
  }
}