package mango.comment_anony_board.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mango.action.Action;
import mango.action.ActionForward;
import mango.comment_anony_board.db.CommentAnonyBoardBean;
import mango.comment_anony_board.db.CommentAnonyBoardDAO;

public class CommentAnoBoardListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommentAnoBoardListAction excute()");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int ano_board_num = Integer.parseInt(request.getParameter("ano_board_num"));
		
		System.out.println("받아온 글 번호 : "+ano_board_num);
		// [댓글 목록을 담아 반환할 List 선언 및 초기화 & DAO 선언 및 초기화]
		List<CommentAnonyBoardBean> commentList = new ArrayList<CommentAnonyBoardBean>();
		CommentAnonyBoardDAO commDAO = new CommentAnonyBoardDAO();
		
		// [해당 게시글 댓글 전체 개수 불러오는 메소드 실행]
		int comm_count = commDAO.getCountANBComments(ano_board_num);
		System.out.println("받아온 댓글 전체 개수 : "+comm_count);
		
		// [해당 게시글 댓글 전체 목록 불러오는 메소드 실행]
		commentList = commDAO.getAllCommentsANBoard(ano_board_num);
		
		System.out.println("내보낼 전체 댓글 내용 : "+commentList);
		System.out.println("내보낼 전체 댓글 개수 : "+commentList.size());
		
		// [개별 댓글을 담을 제이슨object]
		JSONObject singleComment;
		
		// [개별 댓글을 담을 배열객체]
		JSONArray commentArray = new JSONArray();
		
		// [제이슨 객체 전체를 담을 컨테이너]
		JSONObject allComments = new JSONObject();
		
		// [for문 안에서 댓글1개의 각 요소를 저장할 변수를 선언]
		
		int DB_ano_comment_num = 0;
		int DB_ano_board_num  = 0;
		String DB_ano_comment_content = null;
		
		String DB_mem_email = null;
		Timestamp DB_ano_comment_date = null;
		String DB_ano_comment_ip = null;
		String DB_ano_board_nick = null;
		
		int DB_ano_re_lev = 0;
		int DB_ano_re_ref = 0;
		int DB_ano_re_seq = 0;
		
		
		for( int i=0; i<commentList.size(); i++) {
			singleComment = new JSONObject();
			
			// dao메소드에서 반환된 List객체로부터 개별 댓글의 요소를 전체 댓글수만큼 
			// 반복하여 꺼내오기
			DB_ano_comment_num = commentList.get(i).getAno_comment_num();
			DB_ano_board_num = commentList.get(i).getAno_board_num();
			DB_ano_comment_content = commentList.get(i).getAno_comment_content();
			
			DB_mem_email = commentList.get(i).getMem_email();
			DB_ano_comment_date = commentList.get(i).getAno_comment_date();
			DB_ano_comment_ip = commentList.get(i).getAno_comment_ip();
			DB_ano_board_nick = commentList.get(i).getAno_board_nick();
			
			DB_ano_re_lev = commentList.get(i).getAno_re_lev();
			DB_ano_re_ref = commentList.get(i).getAno_re_ref();
			DB_ano_re_seq = commentList.get(i).getAno_re_seq();
			
			// List에서 꺼내온 각 댓글 요소를 제이슨 객체 singleComment에 옮겨담기
			
			singleComment.put("ano_comment_num", DB_ano_comment_num);
			singleComment.put("ano_board_num", DB_ano_board_num);
			singleComment.put("ano_comment_content", DB_ano_comment_content);
			singleComment.put("mem_email", DB_mem_email);
			
			singleComment.put("ano_comment_date", DB_ano_comment_date.toString().substring(0,19));
			singleComment.put("ano_comment_ip", DB_ano_comment_ip);
			singleComment.put("ano_board_nick", DB_ano_board_nick);
			
			singleComment.put("ano_re_lev", DB_ano_re_lev);
			singleComment.put("ano_re_ref", DB_ano_re_ref);
			singleComment.put("ano_re_seq", DB_ano_re_seq);
			
			
			// 각 댓글을 commentArray 제이슨 배열객체에 차례대로 저장
			commentArray.add(singleComment);
		}// for문 끝-------------------------------------------------		
		
		// [allComments 제이슨 객체에 댓글 전체목록 담기]
		allComments.put("commentArray", commentArray);
		String jsonData = allComments.toJSONString();
		System.out.println("내보낼 제이슨 객체 : "+commentArray);		
		System.out.println("내보낼 객체 크기 : "+commentArray.size());		
		
		// [제이슨 객체 내보내기]
		PrintWriter out = response.getWriter();
		out.println(jsonData);
		
		
		return null;
	}

}
