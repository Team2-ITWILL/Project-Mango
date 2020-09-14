package mango.qna_board.action;

import java.io.PrintStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mango.action.Action;
import mango.action.ActionForward;
import mango.qna_board.db.QnaBoardDAO;

public class QnaBoardDeleteAdminAction implements Action{
	
	
	
  public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception{
	  
	  
    System.out.println("QnaBoardDeleteAdminAction 실행");  

    String pageNum = request.getParameter("pageNum");
    int qna_board_num = Integer.parseInt(request.getParameter("qna_board_num"));

    QnaBoardDAO qdao = new QnaBoardDAO();
    qdao.DeleteQnaBoard_Admin(qna_board_num);
    
    System.out.println("글 삭제 완료");
    
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<script>");
    out.println("alert('글 삭제에 성공하였습니다.');");
    out.println("location.href = './QnaBoard.qna?pageNum=" + pageNum + "'");
    out.println("</script>");
    out.close();

    return null;
  }
  
}