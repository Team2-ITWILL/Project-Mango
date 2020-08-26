package mango.anony_board.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardBean;
import mango.anony_board.db.AnonyBoardDAO;


// [익명사담방 전체 글목록과 전체 글 개수를 불러오는 액션] 
// - 데이터 전송경로 : O_anony/anony_board.jsp
public class AnonyBoardListAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AnonyBoardListAction excute()");

		// 글 목록 불러오기


		AnonyBoardDAO andao = new AnonyBoardDAO();
		List<AnonyBoardBean> anbList = new ArrayList<AnonyBoardBean>();
		anbList = andao.getANBoardList();
		System.out.println(anbList.toString());
		request.setAttribute("anbList", anbList);
		
		
		// 글 전체 개수 불러오기
		int anbCount = andao.getAnonyBoardCount();
		request.setAttribute("anbCount", anbCount);

		// db에 저장된 글의 닉네임 불러오기
		// - 아직 db에 컬럼이 없음
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_anony/anony_board.jsp");
		
		return forward;
		
		
	}
}
