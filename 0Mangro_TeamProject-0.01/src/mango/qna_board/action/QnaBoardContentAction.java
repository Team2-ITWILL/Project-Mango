package mango.qna_board.action;

import java.io.PrintStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mango.action.Action;
import mango.action.ActionForward;
import mango.qna_board.db.QnaBoardBean;
import mango.qna_board.db.QnaBoardDAO;

// QnaBoard 내용 확인 액션
public class QnaBoardContentAction implements Action{
	
	
  public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception{
	  
	  
    System.out.println("QnaBoardContentAction() 실행!");

    int qna_board_num = Integer.parseInt(request.getParameter("qna_board_num"));
    String pageNum = request.getParameter("pageNum");

    QnaBoardDAO qdao = new QnaBoardDAO();
    
    // 조회수 증가 시킴
    qdao.UpdateReadCount(qna_board_num);
    
    // 글 상세정보를 가져옴
    QnaBoardBean qbean = qdao.getQnaBoard(qna_board_num);
    
    // 해당 글의 답변글 리스트를 가져옴
    List<QnaBoardBean> re_list = qdao.SearchReWriteList(qna_board_num);
    
    request.setAttribute("qbean", qbean);
    request.setAttribute("pageNum", pageNum);
    request.setAttribute("re_list", re_list);

    ActionForward forward = new ActionForward();
    forward.setRedirect(false);
    forward.setPath("./4index.jsp?center=O_qna/qna_page.jsp");

    return forward;
    
    
  }
  
  
  
}