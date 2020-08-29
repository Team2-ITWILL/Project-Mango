package mango.academy.action;

import java.io.PrintWriter;
import java.util.HashMap;

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
		
		HashMap<String,Object> add=new HashMap<String,Object>();
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		AcademyDAO adao =new AcademyDAO();
		
		add.put("One", request.getParameter("search1"));
		add.put("Two", request.getParameter("search2"));
		
		
		JSONArray ja1 =adao.getListSearchTwo(request.getParameter("search1"),request.getParameter("search2"));
		JSONArray ja2 =adao.getCategory(add);
		
		JSONObject jo =new JSONObject();
		 
		
		jo.put("address", ja1);
		jo.put("category", ja2);
		
		out.print(jo);
		
		return null;
	
	}

}
