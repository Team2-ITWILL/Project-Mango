package mango.anony_board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardBean;
import mango.anony_board.db.AnonyBoardDAO;

public class AnoBoardUpdateAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, 
								HttpServletResponse response) throws Exception {
		
		System.out.println("AnoBoardUpdateAction excute()");
		
		request.setCharacterEncoding("UTF-8");

		
		// [파일 업로드 처리]
		MultipartRequest multi = null;
		
		int sizeLimit = 1000*1024*1024;
		String realPath = request.getRealPath("/O_anony_Files");
		
		multi = new MultipartRequest(
				request, realPath, sizeLimit, "UTF-8",
				new DefaultFileRenamePolicy());
		
		// [글수정 페이지 폼의 요소들을 저장할 anbean객체에 생성]
		AnonyBoardBean anbean = new AnonyBoardBean();
		
		// [수정할 글 번호 받아오기]
		int ano_board_num = Integer.parseInt(multi.getParameter("ano_board_num"));
		

		// [수정할 정보 anbean객체에 저장]
		anbean.setAno_board_num(ano_board_num);
		anbean.setAno_board_title(multi.getParameter("ano_board_title"));
		anbean.setAno_board_content(multi.getParameter("ano_board_content"));
		anbean.setAno_board_file(multi.getFilesystemName("ano_board_file"));
		
		// [수정할 정보 중 ip]
		anbean.setAno_board_ip((String)request.getRemoteAddr());
		
		
		// [글 수정 쿼리실행을 위해 DAO 생성]
		AnonyBoardDAO andao = new AnonyBoardDAO();
		int check = andao.updateANBoard(anbean);
		
		if(check == 1){
			System.out.println("업데이트 성공");
			
		}else{
			System.out.println("업데이트 실패");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/AnoBoardSingleAction.anob?ano_board_num="+ano_board_num);
		return forward;
	}

}

