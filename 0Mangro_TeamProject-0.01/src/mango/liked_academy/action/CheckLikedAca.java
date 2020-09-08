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

// 좋아요 누른 학원인지 확인
@WebServlet("/checkLikedAca")
public class CheckLikedAca extends HttpServlet{

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
			int result = dao.checkLikeAca(bean);
			
			obj.put("result", result);
			
			
			out.print(obj);
			
		} catch (ParseException e) {
			System.out.println("CheckLikedAca에서 예외발생");
			e.printStackTrace();
		}
		
	}
	
	
}




