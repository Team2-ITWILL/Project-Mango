package mango.qna_board.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import mango.qna_board.db.QnaBoardBean;
import mango.qna_board.db.QnaBoardDAO;



// 답변 여부출력
@WebServlet("/QnaReWriteAction")
public class QnaReWriteAction extends HttpServlet{

	
	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

    
    
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	
	
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String data = request.getParameter("data");
		
		PrintWriter out = response.getWriter();
		
		
		try {
			
			
			JSONParser parser = new JSONParser();
			JSONObject obj;
			
			obj = (JSONObject) parser.parse(data);
			int boardNum = Integer.parseInt((String)obj.get("boardnum"));
			QnaBoardDAO qdao = new QnaBoardDAO();
			
		    List<QnaBoardBean> qnaRewriteList = null;
			qnaRewriteList = qdao.SearchReWriteList(boardNum);
			
			if(qnaRewriteList.size() == 0){
				obj.put("check", "없음");
			} else if(qnaRewriteList.size() >= 1){
				obj.put("check", "있음");
			}
			obj.put("boardnum",boardNum);
			out.print(obj);
			
			
		} catch (ParseException e) {
			
			System.out.println("QnaReWriteAction()에서 예외 발생");
			e.printStackTrace();
		}

		
		
			
			
		/*JSONObject totalobObject = new JSONObject();
		JSONArray qnaArray = new JSONArray();*/
		
	/*	for(int i = 0; i < qnaRewriteList.size(); i++){
			
			JSONObject qnaRewriteInfo = new JSONObject();
			QnaBoardBean bean = new QnaBoardBean();
			qnaRewriteInfo.put("title", qnaRewriteList.get(i).getQna_board_title());
			qnaRewriteInfo.put("re_ref", qnaRewriteList.get(i).getQna_re_ref());
			qnaRewriteInfo.put("re_lev", qnaRewriteList.get(i).getQna_re_lev());
			
			qnaArray.add(qnaRewriteInfo);
			
		}
		
		totalobObject.put("qnaList", qnaArray);
		totalobObject.toJSONString();
		out.print(totalobObject.toJSONString());*/
		
	    }

}

