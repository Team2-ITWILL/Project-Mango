
package mango.anony_board.action;

import java.io.File;
import java.sql.Timestamp;

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
		
				AnonyBoardBean anbean = new AnonyBoardBean();
				// [글작성 페이지 폼의 요소들을 BoardBean객체에 저장 ]
			
				// [파일 업로드 처리]
				
				MultipartRequest multi = null;
				
				int sizeLimit = 1000*1024*1024;
				
				//new MultipartRequest(request, realPath, max,"UTF-8",new DefaultFileRenamePolicy());
				
				String realPath = request.getRealPath("/O_aca_regFiles");
				multi = new MultipartRequest
						(request, 
						realPath, sizeLimit, "UTF-8", 
						new DefaultFileRenamePolicy());
				// 제목 본문 파일 (익명닉네임)
				// 조회수 0 날짜String ip
				anbean.setMem_email(multi.getParameter("mem_email"));
				anbean.setAno_board_title(multi.getParameter("ano_board_title"));
				anbean.setAno_board_content(multi.getParameter("ano_board_content"));
				anbean.setAno_board_file(multi.getOriginalFileName(multi.getParameter("ano_board_file")));
				anbean.setAno_board_nick(multi.getParameter("ano_board_nick"));
				
				float f_size = 0;
				
				
				// [만일 파일이 존재한다면 파일의 크기를 얻어오기]
				File f = multi.getFile(multi.getParameter("ano_board_file"));
				if(multi.getParameter("ano_board_file") != null){
					f_size = f.length();
				}
				
				// [글 작성시점과 작성자 IP주소를 처리]
				String ano_board_date = new Timestamp(System.currentTimeMillis()).toString(); 
				String ano_board_ip = (String)request.getRemoteAddr();


				AnonyBoardDAO andao = new AnonyBoardDAO();
				andao.insertANBoard(anbean);
				
				ActionForward forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("./4index.jsp?center=O_anony/anony_board.jsp");
				
				return forward;
		
	}
		

}
