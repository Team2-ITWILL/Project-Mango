package mango.academy_register.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mango.academy.db.AcademyBean;
import mango.academy.db.AcademyDAO;
import mango.action.Action;
import mango.action.ActionForward;

public class Academy_Register_SearchAca_Action implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		//academy_register.jsp의 ajax 메소드에서 전송한 json데이터 받아오기(key값으로)
		String search = request.getParameter("search");
		System.out.println(search);
		
		AcademyDAO dao = new AcademyDAO();
		//1개 또는 복수의 학원 검색 결과
		JSONArray arr = dao.getAcademyInfoBySearchToJSON(search);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();	
		
		//AJAX 호출 메서드로 값 보내기(String값)	
		out.print(arr.toString());			
		
		//프론트컨트롤러가 인식 못하게 막기
		return null;
	}

	
}
