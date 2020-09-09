package mango.anony_board.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardBean;
import mango.anony_board.db.AnonyBoardDAO;
import mango.comment_anony_board.db.CommentAnonyBoardDAO;

public class AdminAnonyHandleReportedAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdminAnonyHandleReportedAction excute()");
		
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("신고를 위한 액션페이지에 입장함");
		// adnony_management로부터 해당 글의 계정명 받아오기
		String mem_email = request.getParameter("mem_email");
		int ano_board_num = Integer.parseInt(request.getParameter("ano_board_num"));
		
		// adnony_management로부터 처리번호 받아오기
		// 1 = 계정정지 / 2 = 신고삭제
		int procNum = Integer.parseInt(request.getParameter("procNum"));
		
	
		AnonyBoardBean anBean = new AnonyBoardBean();
		AnonyBoardDAO andao = new AnonyBoardDAO();
		
		anBean.setMem_email(mem_email);
		anBean.setAno_board_num(ano_board_num);
		
		int check = andao.handleReportedANBoard(anBean, procNum);
		
		
//		request.setAttribute("check", check);
		PrintWriter out = response.getWriter();
		out.println(check);
		
//		ActionForward forward = new ActionForward();
//		forward.setRedirect(false);
//		forward.setPath("./4index.jsp?center=O_admin/anony_management.jsp");
//		
//		return forward;
//		
		return null;
		
	}

}
