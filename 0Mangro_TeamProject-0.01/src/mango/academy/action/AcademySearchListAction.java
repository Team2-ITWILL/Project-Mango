
package mango.academy.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mango.academy.db.AcademyBean;
import mango.academy.db.AcademyDAO;
import mango.action.Action;
import mango.action.ActionForward;

public class AcademySearchListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HashMap<String,Object> Formsearch  = new HashMap<String,Object>(); 
		   
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		
		String mainsearch=request.getParameter("mainsearch");
		String select1=request.getParameter("select1");
		String select2=request.getParameter("select2");
		String select3=request.getParameter("select3");
		String select4=request.getParameter("select4");  
		System.out.println(request.getParameter("select5"));
		
		
		
		if(select1.equals("") && select1.length()==0){//광역시도
			
			System.out.println("이값은 널입니다");
		
		}else{
			
			Formsearch.put("s1",select1);
		}
		
		if(select2.equals("") && select2.length()==0){//지역구
			
			System.out.println("이값은 널입니다");
		}else{
			Formsearch.put("s2",select2);
		}
		
		if(select3.equals("") && select3.length()==0){//읍면동
			
			System.out.println("이값은 널입니다");
		}else{
			Formsearch.put("s3",select3);
		}
		
		if(select4.equals("") && select4.length()==0){//카테고리
			
			System.out.println("이값은 널입니다");
		}else{
			Formsearch.put("s4",select4);
		}
		
		if(mainsearch.equals("") && mainsearch.length()==0){//main검색어
			
			System.out.println("이값은 널입니다");
		
		}else{  
			Formsearch.put("main",mainsearch);
		}
		
		
		AcademyDAO adao =new AcademyDAO();
		
		
		int count=adao.getAcademyCount( Formsearch);
	
		System.out.println("Count 수 : "+count);
		
		
		List<AcademyBean> searchList =null;
		
		
		String pageNum=request.getParameter("pageNum");

		
		int pageSize=15;
		
		
		if(pageNum==null){
			
			pageNum="1";
		
		}
		

		System.out.println(count);
		
		//시작행 번호 구하기
		int currentPage=Integer.parseInt(pageNum);
		
		int startRow =(currentPage-1)*pageSize;
		
		System.out.println("시작페이지" +startRow);
		
		if(count != 0){
			
			searchList =adao.getSearchListAcademy(Formsearch, startRow, pageSize);
			
	
		}
	
		
		//전체페이지수 구하기
				int pageCount = count/pageSize+(count%pageSize==0?0:1);
				
				// 페이지수 설정
				int pageBlock=5;
				
				//한화면에 보여줄 시작페이지 구하기 1~10 =>1/11~20=>11
				int startPage=((currentPage-1)/pageBlock )*pageBlock+1;
				
				//한 화면에 보여줄끝페이지 구하기
				int endPage =startPage+pageBlock-1;
				
				if(endPage>pageCount){
					
					endPage=pageCount;
					
				}
				
				System.out.println(searchList);
				ActionForward forward = new ActionForward();
				
				request.setAttribute("academyList", searchList);
				request.setAttribute("count", count);
				request.setAttribute("pageNum", pageNum); //String -> Object 저장
				request.setAttribute("pageCount", pageCount);//전체페이지수
				request.setAttribute("pageBlock", pageBlock);//보여줄 페이지 수
				request.setAttribute("startPage", startPage);//스타트페이지수
				request.setAttribute("endPage", endPage);//마지막 페이지수
				request.setAttribute("Page","AcademySearchList.aca?select1="+select1+ "&select2="+select2+ "&select3="+select3+ "&select4="+select4+"&mainsearch="+ mainsearch);//페이지명
				
				forward.setRedirect(false);
				forward.setPath("4index.jsp?center=O_academy/academy_list.jsp");
				
				return forward;
		
		
		
	
	}

}

