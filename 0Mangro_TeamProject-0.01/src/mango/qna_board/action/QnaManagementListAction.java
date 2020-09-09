package mango.qna_board.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mango.action.Action;
import mango.action.ActionForward;
import mango.qna_board.db.QnaBoardBean;
import mango.qna_board.db.QnaBoardDAO;

public class QnaManagementListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		
	    System.out.println("QnaManagementListAction 실행");

	    
	    QnaBoardDAO qdao = new QnaBoardDAO();
	    List<QnaBoardBean> qnaboardList = null;
	    
		
	    int count = qdao.getQnaManagementCount();
	    int pageSize = 10;
	    String pageNum = request.getParameter("pageNum");
	    

	    if (pageNum == null) {
	      pageNum = "1";
	    }
	    
	 
	    int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage-1)*pageSize;
	    int endRow = currentPage * pageSize;

	    if (count != 0) {
	      qnaboardList = qdao.getQnaManagementList(startRow, pageSize);
	    }

	    int pageCount = count/pageSize + (count % pageSize == 0 ? 0 : 1);
	    int pageBlock = 3;
		int startPage=((currentPage-1)/pageBlock )*pageBlock+1;

		int endPage =startPage+pageBlock-1;

	    if (endPage > pageCount) {
	      endPage = pageCount;
	    }	    
	    

	    request.setAttribute("count", Integer.valueOf(count));
	    request.setAttribute("pageNum", pageNum);
	    request.setAttribute("pageCount", Integer.valueOf(pageCount));
	    request.setAttribute("pageBlock", Integer.valueOf(pageBlock));
	    request.setAttribute("startPage", Integer.valueOf(startPage));
	    request.setAttribute("endPage", Integer.valueOf(endPage));
	    // 모든 고객센터 글 가져옴
	    request.setAttribute("qnaboardList", qnaboardList);

	    ActionForward forward = new ActionForward();
	    forward.setRedirect(false);
	    forward.setPath("./4index.jsp?center=O_admin/qna_management.jsp");
	    
	    System.out.println(startPage);
	    System.out.println(endPage);
		return forward;
	}

	
}
