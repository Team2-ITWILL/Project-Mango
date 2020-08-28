package mango.academy.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mango.academy.db.AcademyDAO;
import mango.action.Action;
import mango.action.ActionForward;

public class ListSearchTwoAciton implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		AcademyDAO adao =new AcademyDAO();
		
		JSONArray ja =adao.getListSearchTwo(request.getParameter("search1"),request.getParameter("search2"));
		
		
		JSONObject jo =new JSONObject();
		 
		
		jo.put("address", ja);
		
		out.print(jo);
		
		return null;
	
	}

}
