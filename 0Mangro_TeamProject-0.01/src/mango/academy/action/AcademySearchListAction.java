package mango.academy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mango.action.Action;
import mango.action.ActionForward;

public class AcademySearchListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		
		System.out.println(request.getParameter("mainsearch"));
		System.out.println(request.getParameter("select1"));
		System.out.println(request.getParameter("select2"));
		System.out.println(request.getParameter("select3"));
		System.out.println(request.getParameter("select5"));
		
		
		String select4=request.getParameter("select4");
		
		if(select4 ==""){
			
			System.out.println("이값은 널입니다");
		}
		
			
		
		
		
		
		
		
		
		
		return null;
	}

}
