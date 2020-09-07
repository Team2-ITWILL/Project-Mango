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

public class MyAnonyBoardListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			System.out.println("MyAnonyBoardListAction excute()");
	
			request.setCharacterEncoding("UTF-8");
			
			// 이메일 계정 값 세션영역에서 가져오기
			HttpSession session = request.getSession();
			String mem_email = (String)session.getAttribute("id_email");
			
			// DAO와 BEAN 객체 생성
			AnonyBoardDAO andao = new AnonyBoardDAO();
			AnonyBoardBean anBean = new AnonyBoardBean();
			
			// 메소드 사용에 필요한 bean객체에 값 세팅
			anBean.setMem_email(mem_email);
			
			// 해당 계정이 작성한 익명글 목록을 반환하는 메소드 사용
			List<AnonyBoardBean> myAnonyList = new ArrayList<AnonyBoardBean>();
			myAnonyList = andao.getANBoardList(anBean); 
			
			System.out.println("action페이지에서 보는 mem_email"+mem_email);
			// 댓글의 총 개수를 반환하는 메소드 사용
			CommentAnonyBoardDAO commDAO = new CommentAnonyBoardDAO();
			
			// 댓글개수 데이터들 담을 List 객체 선언
			Map<Integer,Integer> comments = new HashMap();
			
			// 글의 개수만큼 반복해서 댓글개수 List에 해당 글의 댓글개수 데이터를 담기
			for(int i=0; i<myAnonyList.size(); i++){
				comments.put(myAnonyList.get(i).getAno_board_num(), commDAO.getCountANBComments(myAnonyList.get(i).getAno_board_num()));
				System.out.println("put("+myAnonyList.get(i).getAno_board_num()+","+commDAO.getCountANBComments(myAnonyList.get(i).getAno_board_num())+")");
			}
					
		
			// 글 List를 request영역에 저장
			request.setAttribute("myAnonyList", myAnonyList);
			request.setAttribute("myAnonyListCount", myAnonyList.size());
			
			System.out.println("myAnonyList 내가 쓴 글리스트 ! "+myAnonyList);
			System.out.println("myAnonyListCount내가 쓴 글갯수 ! "+myAnonyList.size());
			
			// 댓글 개수 정보를 (글번호, 댓글수) HashMap 데이터형태로 request영역에 저장
			request.setAttribute("comments", comments);
			System.out.println(comments);
			
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./4index.jsp?center=O_mypage/my_anony_board.jsp");
			
			return forward;
			
		}

}
