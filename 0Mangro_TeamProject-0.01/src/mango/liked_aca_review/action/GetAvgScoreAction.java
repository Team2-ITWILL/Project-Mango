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

import mango.academy_review.db.AcademyReviewDAO;

// 학원 후기 평균 평점받아오기
@WebServlet("/getAvgScore")
public class GetAvgScoreAction extends HttpServlet{

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
			
			int acaMainNum = Integer.parseInt((String)obj.get("acaMainNum"));
			
			AcademyReviewDAO rdao = new AcademyReviewDAO();
			
			// 소숫점 한자지로 받아옴
			double avgScore = 
					Double.parseDouble(String.format("%.1f",rdao.getAvgReviewScore(acaMainNum)));

			
			obj.put("score", avgScore);
			
			out.print(obj);
			
		} catch (Exception e) {
			System.out.println("GetAvgScoreAction()에서 예외 발생!");
			e.printStackTrace();
		}
		
		
		
		
		
	}

	
	
}
