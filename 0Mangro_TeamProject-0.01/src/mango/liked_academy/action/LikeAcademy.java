package mango.liked_academy.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import mango.liked_academy.db.LikedAcademyBean;
import mango.liked_academy.db.LikedAcademyDAO;

// 학원 좋아요 클릭
@WebServlet("/likeAcademy")
public class LikeAcademy extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String info = request.getParameter("info");
		
		PrintWriter out = response.getWriter();
		int result = 2;
		try {
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(info);
			
			String email = (String) obj.get("email");
			int acaMainNum = Integer.parseInt((String) obj.get("acaMainNum"));
			String acaName = (String) obj.get("acaName");
			
			LikedAcademyBean bean = new LikedAcademyBean();
			bean.setMemEmail(email);
			bean.setAcaMainNum(acaMainNum);
			bean.setAcaName(acaName);
			
			LikedAcademyDAO dao = new LikedAcademyDAO();
			int check = dao.checkLikeAca(bean);
			
			// 좋아요 눌러져있으면
			if(check == 1){
				// 좋아요 취소
				dao.unlikeAca(bean);
				result = 0;
			// 좋아요 눌러져있지 않으면
			}else if(check == 0){
				// 좋아요
				dao.likeAca(bean);
				result = 1;
			}
			
			obj.put("result", result);
			
			
			out.print(obj);
			
		} catch (ParseException e) {
			System.out.println("CheckLikedAca에서 예외발생");
			e.printStackTrace();
		}
		
	}
	
}
