

package mango.anony_board.action;

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
		
			
				// [파일 업로드 처리]
				MultipartRequest multi = null;
				
				int sizeLimit = 1000*1024*1024;
				
				//new MultipartRequest(request, realPath, max,"UTF-8",new DefaultFileRenamePolicy());
				
				String realPath = request.getRealPath("/O_aca_regFiles");
				multi = new MultipartRequest
						(request, 
						realPath, sizeLimit, "UTF-8", 
						new DefaultFileRenamePolicy());
				
				
				// [글작성 페이지 폼의 요소들을 BoardBean객체에 저장 ]
				AnonyBoardBean anbean = new AnonyBoardBean();

//				mem_email varchar(20) 
//				ano_board_nick varchar(100) 
//				ano_board_title varchar(45) 
//				ano_board_content varchar(500) 
//				ano_board_file varchar(25
//				[ano_board_write.jsp 뷰페이지에서 form으로 받아온 값 5개 세팅]
				// 제목 본문 파일 (익명닉네임)
				// 조회수 0 날짜String ip
				anbean.setMem_email(multi.getParameter("mem_email"));
				anbean.setAno_board_nick(multi.getParameter("ano_board_nick"));
				anbean.setAno_board_title(multi.getParameter("ano_board_title"));
				anbean.setAno_board_content(multi.getParameter("ano_board_content"));
				anbean.setAno_board_file(multi.getOriginalFileName(multi.getParameter("ano_board_file")));
				
				//float f_size = 0;
				
				
				// [만일 파일이 존재한다면 파일의 크기를 얻어오기]
//				File f = multi.getFile(multi.getParameter("ano_board_file"));
//					if(multi.getParameter("ano_board_file") != null){
//						f_size = f.length();
//					}
				
				
//				[ dao로 처리할 값]
//				ano_board_num int(11) AI PK 
//				ano_board_read int(11) 
				
				// [Action에서 처리할 값]
				Timestamp ano_board_date = new Timestamp(System.currentTimeMillis().);
				String ano_board_ip = (String)request.getRemoteAddr();
				AnonyBoardDAO andao = new AnonyBoardDAO();
				andao.insertANBoard(anbean);
				
				
				
				ActionForward forward = new ActionForward();
				forward.setRedirect(false);
				//forward.setPath("./4index.jsp?center=O_anony/anony_board.jsp");
				forward.setPath("/AnonyBoardListAction.anob");
				
				return forward;
		
	}
		

}

