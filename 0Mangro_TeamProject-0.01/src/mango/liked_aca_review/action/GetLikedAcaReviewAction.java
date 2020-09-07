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
import mango.liked_aca_review.db.LikedAcaReviewDAO;

// 좋아요 누른 후기인지 확인
@WebServlet("/getLikedAcaRev")
public class GetLikedAcaReviewAction extends HttpServlet{

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
		
		try {
			
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(data);
			
			String email = (String) obj.get("email");
			int revNum = Integer.parseInt((String)obj.get("revNum"));
			
			LikedAcaReviewDAO dao = new LikedAcaReviewDAO();

			int check = dao.checkLikedReview(email,revNum);
			int count = dao.getReviewLikeCount(revNum);
			
			
			obj.put("check", check);
			obj.put("count",count);
			
			out.print(obj);
			
		} catch (Exception e) {
			System.out.println("GetLikedAcaReviewAction()에서 예외 발생!");
			e.printStackTrace();
		}
		
		
		
		
		
	}

	
	
}
