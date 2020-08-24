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
		
		AnonyBoardDAO andao = new AnonyBoardDAO();
		List<AnonyBoardBean> anbList = new ArrayList<AnonyBoardBean>();
		
		anbList = andao.getANBoardList();
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("4index.jsp?O_ano/anony_board.jsp");
		
		
		
		
		
		return null;
	}


	
	
}
