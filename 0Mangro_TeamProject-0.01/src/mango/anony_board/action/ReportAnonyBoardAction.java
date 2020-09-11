package mango.anony_board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Member;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardDAO;

public class ReportAnonyBoardAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdminAnoCheckAlreadyBannedAction excute()");
		
		request.setCharacterEncoding("UTF-8");
		
		int ano_board_num = Integer.parseInt(request.getParameter("ano_board_num"));
		String ano_board_reporter = request.getParameter("ano_board_reporter");
		System.out.println("멤버이메일 받아오는지 체크"+ano_board_reporter);
		String ano_board_reason = request.getParameter("ano_board_reason");
		
		AnonyBoardDAO andao = new AnonyBoardDAO();
		
		int checkReportDone = andao.reportANBoard(ano_board_reporter,ano_board_reason,ano_board_num);
		
		//request.setAttribute("checkIfBanned", checkIfBanned);
		
		System.out.println("ano_single 신고를 위한 액션페이지 왔다감");
		
		
		request.setAttribute("checkReportDone", checkReportDone);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./AnonyBoardListAction.anob");
		
		return forward;
		
	}

}
