package mango.anony_board.action;

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

public class AdminAnonyReportedListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdminAnonyReportedListAction excute()");
		
		request.setCharacterEncoding("UTF-8");
		
		// [이메일 계정 값 세션영역에서 가져오기]
		HttpSession session = request.getSession();
		String mem_email = (String)session.getAttribute("id_email");
		
		// [DAO와 BEAN 객체 생성]
		AnonyBoardDAO andao = new AnonyBoardDAO();
		AnonyBoardBean anBean = new AnonyBoardBean();
		
		// [페이징 처리를 위한 값 세팅]--------------------------------------------------------------------------
		
		// [anony_management.jsp로부터 클릭한 페이지번호 받아오기]
		String clickedPageNum = request.getParameter("clickedPageNum");
		
		// [신고글의 총 개수]
		int count = andao.getAnonyBoardCount(anBean);
		request.setAttribute("count", count);
		
		// [클릭한 페이지번호가 null인 경우(처음 페이지 호출된 경우) "1"값 대입]
		if(clickedPageNum == null) {	clickedPageNum = "1";  }
		
		// [클릭으로 인해 현재 보여지는 페이지 번호를 정수타입으로 변경]
		int currentPage = Integer.parseInt(clickedPageNum);
		request.setAttribute("currentPage", currentPage);
		
		// [하나의 페이지에 보여질 글의 최대 갯수 (10행)]
		int eachPageSize = 10;
		request.setAttribute("eachPageSize", eachPageSize);
		
		// [하나의 블럭에 보여줄 페이지 수 ]
		// [<<] [<]  [1] [2] [3] [4] [5]  [>] [>>]
		int pageBlock = 5;
		request.setAttribute("pageBlock", pageBlock);
		
		// [각 페이지마다 첫번째로 보여질 시작 글번호(첫행 번호)]
		// - (현재페이지 - 1)*하나의 페이지의 최대 글(행)수
		// = (5-1)*10 = 40
		// 1번 11번 21번 31번 41번
		int startRow = (currentPage - 1)*eachPageSize;
		request.setAttribute("startRow", startRow);
		
		// [페이지 개수]
		int pageCount = count/eachPageSize+(count%eachPageSize==0?0:1);
		request.setAttribute("pageCount", pageCount);
		
		// [블록의 시작페이지 번호]
		int startPage = ((int) (currentPage/pageBlock) - (currentPage%pageBlock==0?1:0) )*pageBlock+1;
		request.setAttribute("startPage", startPage);
		
		// [블록의 마지막페이지 번호]
		int endPage = startPage+pageBlock-1;
		request.setAttribute("endPage", endPage);
		
		//----------------------------------------------------------------------------------------------
		
		// 해당 계정이 작성한 익명글 목록을 반환하는 메소드 사용
		List<AnonyBoardBean> reportedAnonyList = new ArrayList<AnonyBoardBean>();
		reportedAnonyList = andao.getANBoardList(startRow,eachPageSize,anBean); 
			
		//System.out.println("action페이지에서 보는 mem_email"+mem_email);
		// 댓글의 총 개수를 반환하는 메소드 사용
		CommentAnonyBoardDAO commDAO = new CommentAnonyBoardDAO();
		
		// 댓글개수 데이터들 담을 List 객체 선언
		Map<Integer,Integer> comments = new HashMap();
		
		// 글의 개수만큼 반복해서 댓글개수 List에 해당 글의 댓글개수 데이터를 담기
		// getCountANBComments(전체 글 목록 중 i번째 글번호) : 해당 게시글의 댓글개수를 반환하는 메소드
		
		for(int i=0; i<reportedAnonyList.size(); i++){
			comments.put(reportedAnonyList.get(i).getAno_board_num(), 
						 commDAO.getCountANBComments(reportedAnonyList.get(i).getAno_board_num())
					);
		}
				
		
		// 글 List를 request영역에 저장
		request.setAttribute("reportedAnonyList", reportedAnonyList);
		
		// 댓글 개수 정보를 (글번호, 댓글수) HashMap 데이터형태로 request영역에 저장
		request.setAttribute("comments", comments);
		System.out.println(comments);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./4index.jsp?center=O_admin/anony_management.jsp");
		
		return forward;
		
	}

}// public class 끝
