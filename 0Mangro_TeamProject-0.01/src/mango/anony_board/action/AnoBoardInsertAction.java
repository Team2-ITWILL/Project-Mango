package mango.anony_board.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardBean;
import mango.anony_board.db.AnonyBoardDAO;

public class AnoBoardInsertAction implements Action {


	@Override
	public ActionForward excute(HttpServletRequest request, 
								HttpServletResponse response) throws Exception {
				System.out.println("AnoBoardInsertAction excute()");
		
				request.setCharacterEncoding("UTF-8");
			
				// [파일 업로드 처리]
				MultipartRequest multi = null;
				
				int sizeLimit = 1000*1024*1024;
				
				//new MultipartRequest(request, realPath, max,"UTF-8",new DefaultFileRenamePolicy());
				
				String realPath = request.getRealPath("/O_anony_Files");
				System.out.println(realPath);
				
				multi = new MultipartRequest
						(request, realPath, sizeLimit, "UTF-8", 
						new DefaultFileRenamePolicy());
				
				
				// [글작성 페이지 폼의 요소들을 BoardBean객체에 저장 ]
				AnonyBoardBean anbean = new AnonyBoardBean();

				anbean.setMem_email(multi.getParameter("mem_email"));
				anbean.setAno_board_nick(multi.getParameter("ano_board_nick"));
				anbean.setAno_board_title(multi.getParameter("ano_board_title"));
				anbean.setAno_board_content(multi.getParameter("ano_board_content"));
				
				anbean.setAno_board_file(multi.getFilesystemName("ano_board_file"));
				
				float f_size = 0;
				
				// [Action에서 처리할 값]
				anbean.setAno_board_ip((String)request.getRemoteAddr());
				AnonyBoardDAO andao = new AnonyBoardDAO();
				andao.insertANBoard(anbean);
				
				ActionForward forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/AnonyBoardListAction.anob");
				
				return forward;
		
	}
		

}

