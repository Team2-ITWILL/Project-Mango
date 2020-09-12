package mango.anony_board.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;
import mango.anony_board.db.AnonyBoardBean;
import mango.anony_board.db.AnonyBoardDAO;

public class AnoBoardFileDownAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, 
								HttpServletResponse response) throws Exception {
		
		System.out.println("AnoBoardFileDownAction excute()");		
		
		request.setCharacterEncoding("UTF-8");
		
		// [익명글 상세페이지에서 글 번호 받아오기]
		int ano_board_num = Integer.parseInt(request.getParameter("ano_board_num"));
		
		// [DAO생성]
		AnonyBoardDAO andao = new AnonyBoardDAO();
		
		// [1개의 글 정보를 anbean객체에 담아 저장]
		AnonyBoardBean anbean = andao.getANBoard(ano_board_num);
		
		// [anbean객체로 부터 해당 글의 파일명 얻기]
		String filename = anbean.getAno_board_file();
		
		// [파일이 저장된 경로와 파일 이름을 붙이기]
		String uploadFileName 
			= request.getRealPath("/O_anony_Files") + 
			  "/" + filename;
		
		// [해당 파일 객체 생성하기]
		File fileForDown = new File(uploadFileName);
		
		// [다운로드 처리]
		
		// 
		if(fileForDown.exists() && fileForDown.isFile()){
			try {
				// [파일 사이즈]
				long fileSize = fileForDown.length();
				
				// [content타입 및 헤어 세팅 후 파일 출력]
				response.setContentType("application/octet-stream");
				response.setContentLength((int)fileSize);
				String strClient = request.getHeader("User-agent");
				
				if(strClient.indexOf("MSID 5.5") != -1){
					response.setHeader("Content-Disposition","filename=" + filename +";");
					
				}else{
					response.setHeader("Content-Disposition", "attachment;filename="+filename+";");
				}
				
				response.setHeader("Content-Length", String.valueOf(fileSize));
				response.setHeader("Content-Transfer-Encoding", "binary");
				response.setHeader("Pragma", "no-cache");
				response.setHeader("Cache-Control", "private");
				
				
				// [사용자에게 보내주기 위해 스트림객체 생성]
				byte b[] = new byte[1024];
				
				// [인풋 객체 생성]
				BufferedInputStream fin = new BufferedInputStream(
						new FileInputStream(fileForDown));
				
				// [응답 객체 생성]
				BufferedOutputStream outs = new BufferedOutputStream(
						response.getOutputStream());
				
				int read = 0;
				
				
				while ((read = fin.read(b)) != -1) {
					outs.write(b, 0, read);
				}
				
				
				outs.flush();
				outs.close();
				fin.close();
				
			}catch(Exception e){
				System.out.println("AnoBoardFileDownAction에서 다운로드 처리 예외 발생");
				e.printStackTrace();
			}
		}else {
			System.out.println("AnoBoardFileDownAction에서 다운로드할 파일에 문제가 있음"+
							   " [ "+fileForDown+" ] ");
			
		}// if문 끝
		
		
		// [별도로 리턴할 페이지가 필요없으므로 null 처리]
		return null;
	}

}
