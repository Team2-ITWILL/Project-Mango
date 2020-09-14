package mango.anony_board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardDAO;

public class ReportAnonyBoardAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ReportAnonyBoardAction excute()");
		
		request.setCharacterEncoding("UTF-8");
		
		int ano_board_num = Integer.parseInt(request.getParameter("ano_board_num"));
		String ano_board_reporter = request.getParameter("ano_board_reporter");
		String ano_board_reason = request.getParameter("ano_board_reason");
		
		AnonyBoardDAO andao = new AnonyBoardDAO();
		
		int checkReportDone = andao.reportANBoard(ano_board_reporter,ano_board_reason,ano_board_num);
		
		// 값 세팅하기
		request.setAttribute("checkReportDone", checkReportDone);
		
		
		PrintWriter out = response.getWriter();
		out.println(checkReportDone);
		
		return null;
		
	}

}
