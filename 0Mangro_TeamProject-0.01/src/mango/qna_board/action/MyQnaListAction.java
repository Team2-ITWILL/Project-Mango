package mango.qna_board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mango.action.Action;
import mango.action.ActionForward;
import mango.qna_board.db.QnaBoardBean;
import mango.qna_board.db.QnaBoardDAO;

public class MyQnaListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   
		
		request.setCharacterEncoding("utf-8");
		
		
		
	    System.out.println("MyQnaListAction 실행");
	    
	    
	    HttpSession session = request.getSession();
		String email = (String)session.getAttribute("id_email");
	    QnaBoardDAO qdao = new QnaBoardDAO();
	    List<QnaBoardBean> qnaboardList = null;
	    
	    
		
	    int pageSize = 5;
	    String pageNum = request.getParameter("pageNum");
	    int count = qdao.getMYQnaCount(email);
	    

	    if (pageNum == null) {
	      pageNum = "1";
	    }
	    
	 
	    int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage-1)*pageSize;
	    int endRow = currentPage * pageSize;

	    if (count != 0) {
	      qnaboardList = qdao.getMyQnaList(startRow, pageSize, email);
	    }

	    int pageCount = count/pageSize + (count % pageSize == 0 ? 0 : 1);
	    int pageBlock = 3;
		int startPage=((currentPage-1)/pageBlock )*pageBlock+1;

		int endPage = startPage+pageBlock-1;

	    if (endPage > pageCount) {
	      endPage = pageCount;
	    }	    
	    

	    request.setAttribute("count", Integer.valueOf(count));
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
	    forward.setPath("./4index.jsp?center=O_mypage/my_qna_board.jsp");

		return forward;	
		
	
	}

}
