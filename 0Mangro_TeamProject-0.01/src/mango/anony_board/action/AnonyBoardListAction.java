package mango.anony_board.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardBean;
import mango.anony_board.db.AnonyBoardDAO;


// [익명사담방 전체 글목록 불러오는 액션]
public class AnonyBoardListAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("1.익명사담방 전체글목록 불러오기 AnonyBoardListAction excute()");
		
		AnonyBoardDAO andao = new AnonyBoardDAO();
		List<AnonyBoardBean> anbList = new ArrayList<AnonyBoardBean>();
		anbList = andao.getANBoardList();
		System.out.println(anbList.toString());
		
		int anbCount = andao.getAnonyBoardCount();
		
		System.out.println("2.익명사담방 전체글 개수 불러오기 AnonyBoardListAction excute()");
		request.setAttribute("anbList", anbList);
		request.setAttribute("anbCount", anbCount);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_anony/anony_board.jsp");
		
		return forward;
		
		
	}

}
