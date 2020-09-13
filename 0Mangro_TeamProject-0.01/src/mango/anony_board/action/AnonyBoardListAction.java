package mango.anony_board.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardBean;
import mango.anony_board.db.AnonyBoardDAO;
import mango.comment_anony_board.db.CommentAnonyBoardDAO;

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
		
		// 댓글의 총 개수를 반환하는 메소드 사용
		CommentAnonyBoardDAO commDAO = new CommentAnonyBoardDAO();
		
		// 댓글개수 데이터들 담을 Map 객체 선언
		Map<Integer,Integer> comments = new HashMap();
		
		// 신고여부 데이터를 담을 Map 객체 선언
		Map<Integer,Integer> reportedCheckList = new HashMap();
		
		// 글의 개수만큼 반복해서 댓글개수 List에 해당 글의 댓글개수 데이터를 담기
		for(int i=0; i<anbList.size(); i++){
			comments.put(anbList.get(i).getAno_board_num(), commDAO.getCountANBComments(anbList.get(i).getAno_board_num()));
			System.out.println("put("+anbList.get(i).getAno_board_num()+","+commDAO.getCountANBComments(anbList.get(i).getAno_board_num())+")");
			
			// 해당글의 신고여부 조회(0이면 신고x 1이면 신고된 글)
			reportedCheckList.put(anbList.get(i).getAno_board_num(),
								  andao.checkIfthisReported(anbList.get(i).getAno_board_num()));
		}
		
		
		// 익명글 전체 개수를 반환하는 메소드 사용
		int anbCount = andao.getAnonyBoardCount(searchKeyword);
		request.setAttribute("anbCount", anbCount);
		
		// 댓글 개수 정보를 (글번호, 댓글수) HashMap 데이터형태로 전송
		request.setAttribute("comments", comments);
		System.out.println(comments);
		
		// 해당 글 번호의 신고여부(글번호,신고여부(날짜))를 HashMap 데이터 형태로 전송
		request.setAttribute("reportedCheckList", reportedCheckList);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_anony/anony_board.jsp");
		
		return forward;
		
	}
}
