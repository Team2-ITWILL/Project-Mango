package mango.anony_board.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardBean;
import mango.anony_board.db.AnonyBoardDAO;

public class AdminAnonyHandleReportedAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdminAnonyHandleReportedAction excute()");
		
		request.setCharacterEncoding("UTF-8");
		
		int ano_board_num = Integer.parseInt(request.getParameter("ano_board_num"));
		
		String mem_email = request.getParameter("mem_email");
		System.out.println(mem_email);
		
		// adnony_management로부터 처리번호 받아오기
		// 1 = 계정정지 / 2 = 신고삭제 / 3 = 계정복구
		int procNum = Integer.parseInt(request.getParameter("procNum"));
		System.out.println("넘어온 작업번호 "+procNum);
	
		AnonyBoardBean anBean = new AnonyBoardBean();
		AnonyBoardDAO andao = new AnonyBoardDAO();
		
		int result = andao.handleReportedANBoard(ano_board_num, procNum);
		
		int checkIfBanned = 0;
		
		if(result == 1) {
			checkIfBanned = andao.checkIfAlreadyBanned(mem_email);
		}
		
			request.setAttribute("result", result);
			request.setAttribute("ano_board_num", ano_board_num);
			request.setAttribute("mem_email", mem_email);
			request.setAttribute("checkIfBanned", checkIfBanned);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./AdminAnonyReportedListAction.anob");
		
		return forward;
		
		
		
	}

}
