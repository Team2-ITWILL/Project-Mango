package mango.qna_board.action;

import java.io.PrintStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mango.action.Action;
import mango.action.ActionForward;
import mango.qna_board.db.QnaBoardDAO;

public class QnaBoardListSearchAction implements Action {

	
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception{
    System.out.println("QnaBoardListSearchAction 실행");

    request.getParameter("UTF-8");

    QnaBoardDAO qdao = new QnaBoardDAO();
    List qnaboardList = null;

    String search_key = request.getParameter("search_key");
    String search_word = request.getParameter("search_word");

    int count = qdao.getSearchQnaBoardCount(search_key, search_word);

    int pageSize = 5;
    String pageNum = request.getParameter("pageNum");

    if (pageNum == null) {
      pageNum = "1";
    }

    int currentPage = Integer.parseInt(pageNum);
    int startRow = (currentPage - 1) * pageSize + 1;
    int endRow = currentPage * pageSize;

    if (count != 0) {
      qnaboardList = qdao.getSearchQnaBoardList(startRow, pageSize, search_key, search_word);
    }

    int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
    int pageBlock = 5;
    int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
    int endPage = startPage + pageBlock - 1;

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