package mango.liked_aca_review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import mango.action.Action;
import mango.action.ActionForward;

public class GetLikedAcaReviewAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String email = (String)request.getAttribute("email");
		System.out.println(email);
		
		
		JSONObject jsonObj = new JSONObject();
		
		return null;
	}
	
	
}
