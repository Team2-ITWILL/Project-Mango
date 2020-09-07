package mango.liked_aca_review.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import mango.action.ActionForward;
import mango.liked_aca_review.db.LikedAcaReviewBean;
import mango.liked_aca_review.db.LikedAcaReviewDAO;

// 후기 좋아요 클릭
@WebServlet("/likeAcaRev")
public class LikeAcaReviewAction extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String data = request.getParameter("data");
		
		PrintWriter out = response.getWriter();
		int result = 0;
		try {
			
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(data);
			
			String email = (String) obj.get("email");
			int revNum = Integer.parseInt((String)obj.get("revNum"));
			
			
			
			
			LikedAcaReviewDAO dao = new LikedAcaReviewDAO();

			int check = dao.checkLikedReview(email,revNum);
			
			LikedAcaReviewBean bean = new LikedAcaReviewBean();
			bean.setReviewNum(revNum);
			bean.setMemEmail(email);
			
			// 안 눌러져있으면
			if(check == 0){
				// 좋아요
				dao.LikeAcaReview(bean);
				result +=1;
			// 이미 눌러져있으면	
			}else if(check == 1){
				// 좋아요 취소
				dao.UnLikeAcaReview(bean);
				
			}else {
				// 오류
				result = 2;
			}
			
			
			int count = dao.getReviewLikeCount(revNum);
			obj.put("result", result);
			obj.put("count",count);
			
			out.print(obj);
			
		} catch (Exception e) {
			System.out.println("LikeAcaReviewAction에서 예외 발생!");
			e.printStackTrace();
		}
		
		
		
		
		
	}

	
	
}
