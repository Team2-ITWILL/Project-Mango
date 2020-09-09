
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
		String select5=request.getParameter("select5");//정렬순
		String keyword=request.getParameter("keyword");//키워드
		
		
		String Page="AcademySearchList.aca?";
		String PageTwo="AcademySearchList.aca?";
		String PageKeyword="AcademySearchList.aca?";
		
		if(select1 != null || select2 != null ||select3 != null ||select4 != null||mainsearch !=null ||select5!=null){
		if(select1==null){//광역시도
			
			System.out.println("이값은 널입니다1");
		
		}else{
			
			Formsearch.put("s1",select1);
			
			Page+="select1="+select1+"&";
			PageTwo+="select1="+select1+"&";
			PageKeyword+="select1="+select1+"&";
		
		}
		
		if(select2==null){//지역구
			
			System.out.println("이값은 널입니다2");
		}else{
			Formsearch.put("s2",select2);
			Page+="select2="+select2+"&";
			PageTwo+="select2="+select2+"&";
			PageKeyword+="select2="+select2+"&";
		
		
		}
		
		if(select3==null){//읍면동
			
			System.out.println("이값은 널입니다3");
		}else{
			Formsearch.put("s3",select3);
			Page+="select3="+select3+"&";
			PageTwo+="select3="+select3+"&";
			PageKeyword+="select3="+select3+"&";
		}
		
		if(select4==null){//카테고리
			
			System.out.println("이값은 널입니다4");
		}else{
			Formsearch.put("s4",select4);
			Page+="select4="+select4+"&";
			PageTwo+="select4="+select4+"&";
			PageKeyword+="select4="+select4+"&";
		}
		
		if(mainsearch==null){//main검색어
			
			System.out.println("이값은 널입니다5");
		
		}else{  
			Formsearch.put("main",mainsearch);
			Page+="mainsearch="+mainsearch+"&";
			PageTwo+="mainsearch="+mainsearch+"&";
			PageKeyword+="mainsearch="+mainsearch+"&";
		}
		
		if(select5==null){//정렬순
			
			System.out.println("이값은 널입니다6");
		
		}else{  
			Formsearch.put("s5",select5);
			PageTwo+="select5="+select5+"&";
			PageKeyword+="select5="+select5+"&";
			
		}
	
	
		
	}//if문
		
		AcademyDAO adao =new AcademyDAO();
		int count;
		String pageNum=request.getParameter("pageNum");		
		if(keyword==null){
			System.out.println("이값은 널입니다7");

		
			 count=adao.getAcademyCount(Formsearch);
			
		
		
		
		
		}else{	//키워드 검색이 있을시에
			
			
			Formsearch.put("key", keyword);
			count=adao.getAcademyKeywordCount(Formsearch);
			PageTwo+="keyword="+keyword+"&";
			Page+="keyword="+keyword+"&";
			
		}
		
		
		
		System.out.println(Page);
	
		System.out.println("Count 수 : "+count);
		
		
		List<AcademyBean> searchList =null;
		
		

		
		int pageSize=15;
		
		
		if(pageNum==null){
			
			pageNum="1";
		
		}
		

		System.out.println(count);
		
		//시작행 번호 구하기
		int currentPage=Integer.parseInt(pageNum);
		
		int startRow =(currentPage-1)*pageSize;
		
		System.out.println("시작페이지" +startRow);
		
		if(count != 0 && keyword ==null){
			
			searchList =adao.getSearchListAcademy(Formsearch, startRow, pageSize);
			
	
		}else if(count != 0 && keyword != null){//키워드가 있을시에
			
			searchList =adao.getSearchKeywordListAcademy(Formsearch, startRow, pageSize);
			
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
				//request.setAttribute("Page","AcademySearchList.aca?select1="+select1+ "&select2="+select2+ "&select3="+select3+ "&select4="+select4+"&mainsearch="+ mainsearch);//페이지명
				request.setAttribute("Page",Page);//페이지명
				request.setAttribute("PageTwo",PageTwo);//페이지명
				request.setAttribute("PageKeyword",PageKeyword);//페이지명
				
				forward.setRedirect(false);
				forward.setPath("4index.jsp?center=O_academy/academy_list.jsp");
				
				return forward;
		
		
		
	
	}

}

