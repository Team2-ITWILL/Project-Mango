package mango.qna_board.action;

import java.io.PrintStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mango.action.Action;
import mango.action.ActionForward;
import mango.qna_board.db.QnaBoardDAO;

public class QnaBoardSecretAction implements Action{
	
	
  public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception{
    
	  
	  
    System.out.println("QnaBoardSecretAction 실행");

    String pageNum = request.getParameter("pageNum");
    int qna_board_num = Integer.parseInt(request.getParameter("qna_board_num"));
    String qna_board_pwd = request.getParameter("qna_board_pwd");

    QnaBoardDAO qdao = new QnaBoardDAO();

    int check = qdao.SecretQnaBoard(qna_board_num, qna_board_pwd);

    if (check == 0){
    	
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<script>");
      out.println("alert('비밀번호가 일치하지 않습니다.');");
      out.println("history.back();");
      out.println("</script>");
      out.close();

      return null;
    }

    if (check == -1){
    	
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<script>");
      out.println("alert('비밀번호가 일치하지 않습니다.');");
      out.println("history.back();");
      out.println("</script>");
      out.close();

      return null;
    }

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<script>");
    out.println("location.href = './QnaBoardContent.qna?qna_board_num="+ qna_board_num + "&pageNum=" + pageNum + "'");
    out.println("</script>");
    out.close();

    return null;
  }
  
}