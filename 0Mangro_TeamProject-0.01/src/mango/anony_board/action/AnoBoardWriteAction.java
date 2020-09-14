

package mango.anony_board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardDAO;

public class AnoBoardWriteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

			System.out.println("AnoBoardWriteAction excute()");
	
			request.setCharacterEncoding("UTF-8");
			
			// 랜덤 닉 보내기
			AnonyBoardDAO andao = new AnonyBoardDAO();
			String nick = andao.getRandomNickname();
			
			request.setAttribute("nick", nick);
			
			ActionForward forward = new ActionForward();
			
			forward.setRedirect(false);
			forward.setPath("./4index.jsp?center=O_anony/anony_board_write.jsp");
			
			return forward;
		}

		

	
	

}
