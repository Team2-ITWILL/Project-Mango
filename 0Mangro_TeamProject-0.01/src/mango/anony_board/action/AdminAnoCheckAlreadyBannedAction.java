package mango.anony_board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardDAO;

public class AdminAnoCheckAlreadyBannedAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdminAnoCheckAlreadyBannedAction excute()");
		
		request.setCharacterEncoding("UTF-8");
		String mem_email = request.getParameter("mem_email");
		
		AnonyBoardDAO andao = new AnonyBoardDAO();
		
		// 0 : 계정정지x  1: 계정정지 o  2: 계정정지o+삭제o
		int checkIfBanned = andao.checkIfAlreadyBanned(mem_email);
		
		//request.setAttribute("checkIfBanned", checkIfBanned);
		
		System.out.println("계정정지여부 액션페이지 왔다감");
		
		PrintWriter out = response.getWriter();
		System.out.println("계정정지여부 액션페이지의 값"+checkIfBanned);
		out.println(checkIfBanned);		
//		ActionForward forward = new ActionForward();
//		forward.setRedirect(false);
//		forward.setPath("./AdminAnonyReportedListAction.anob");
//		
		return null;
//		
	}
}