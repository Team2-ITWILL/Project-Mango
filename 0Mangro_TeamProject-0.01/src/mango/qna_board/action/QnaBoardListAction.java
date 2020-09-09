package mango.qna_board.action;

import java.io.PrintStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mango.action.Action;
import mango.action.ActionForward;
import mango.qna_board.db.QnaBoardBean;
import mango.qna_board.db.QnaBoardDAO;

public class QnaBoardListAction implements Action {
	
	
  public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception{
	  
	  
    System.out.println("QnaBoardListAction excute() 실행");

    QnaBoardDAO qbao = new QnaBoardDAO();
    List<QnaBoardBean> qnaboardList = null;
    
    
    int count = qbao.getQnaBoardCount();
    int pageSize = 10;
    String pageNum = request.getParameter("pageNum");

    if (pageNum == null) {
      pageNum = "1";
    }

    int currentPage = Integer.parseInt(pageNum);
    int startRow = (currentPage-1)*pageSize+1;
    int endRow = currentPage * pageSize;

    if (count != 0) {
      qnaboardList = qbao.getQnaBoardList(startRow, pageSize);
    }

    int pageCount = count/pageSize + (count % pageSize == 0 ? 0 : 1);
    int pageBlock = 5;
    int startPage = ((currentPage-1)/pageBlock) * pageBlock + 1;

    int endPage = startPage + pageBlock-1;

    if (endPage > pageCount) {
      endPage = pageCount;
    }

    request.setAttribute("count", Integer.valueOf(count));
    request.setAttribute("qnaboardList", qnaboardList);
    request.setAttribute("pageNum", pageNum);
    request.setAttribute("pageCount", Integer.valueOf(pageCount));
    request.setAttribute("pageBlock", Integer.valueOf(pageBlock));
    request.setAttribute("startPage", Integer.valueOf(startPage));
    request.setAttribute("endPage", Integer.valueOf(endPage));

    ActionForward forward = new ActionForward();
    forward.setRedirect(false);
    forward.setPath("./4index.jsp?center=O_qna/qna_board.jsp");

    return forward;
  }
  
}