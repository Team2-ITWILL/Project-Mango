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
	public ActionForward excute(HttpServletRequest request, 
								HttpServletResponse response) throws Exception {
		System.out.println("AnonyBoardListAction excute()");

		request.setCharacterEncoding("UTF-8");

		// 검색 키워드 null 처리
		// - 키워드를 입력하지 않았을 경우에는 searchKeyword를 ""빈문자열 처리하여
		//   getANBoardList(searchKeyword)메소드의 반환값은 전체 글목록이 되고,
		//   키워드를 입력했을 시에는 WHERE조건절을 통해 필터링된 검색결과를 반환
		String searchKeyword = request.getParameter("searchKeyword");
		if(searchKeyword != null) {
			request.getSession().setAttribute("searchKeyword", searchKeyword);
		}else{searchKeyword = "";}
		
		
		
		// 익명글 목록을 반환하는 메소드 사용
		AnonyBoardDAO andao = new AnonyBoardDAO();
		List<AnonyBoardBean> anbList = new ArrayList<AnonyBoardBean>();
		anbList = andao.getANBoardList(searchKeyword); 
		
		System.out.println(anbList.toString());
		request.setAttribute("anbList", anbList);
		System.out.println("익명사담방 검색글 가져오기 여기까지 옴  "+anbList);
		
		
		// 익명글 전체 개수를 반환하는 메소드 사용
		int anbCount = andao.getAnonyBoardCount(searchKeyword);
		request.setAttribute("anbCount", anbCount);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_anony/anony_board.jsp");
		
		return forward;
		
	}
}
