<%@page import="mango.qna_board.db.QnaBoardBean"%>
<%@page import="java.util.List"%>
<%@page import="mango.anony_board.db.AnonyBoardBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head> 
<title>고객센터</title>
<!---------------------------------- 메타데이터  ---------------------------------------------------->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!---------------------------------- CSS  ---------------------------------------------------->
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">


<link rel="stylesheet" type="text/css" href="styles/qna_board.css">
<!---------------------------------- 제이쿼리  ---------------------------------------------------->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>


<%

int count = ((Integer)request.getAttribute("count")).intValue();
List<QnaBoardBean> qnaboardList = (List<QnaBoardBean>)request.getAttribute("qnaboardList");
String pageNum = (String)request.getAttribute("pageNum");
int pageCount = ((Integer)request.getAttribute("pageCount")).intValue();
int pageBlock = ((Integer)request.getAttribute("pageBlock")).intValue();
int startPage = ((Integer)request.getAttribute("startPage")).intValue();
int endPage = ((Integer)request.getAttribute("endPage")).intValue();


String id_email = (String)session.getAttribute("id_email");  



if(id_email == null){
	
	id_email = "";
	
}



%>



<c:set var="id" />



<body>





	<!-- qna_container (s) -->
	<div class = "qna_container container">
	
		<div class = "qna_title">
			고객센터
		</div>
	
	
	
	
		
	<!-- board list (s) -->
	<form name="fboardlist" id="fboardlist" action="#" onsubmit="#" method="post">


    
	    <div class="likeTbl">
	       
	       
	        <ul>
	        
				  <li class="likeTblTr likeTblTh">
				  	<div class="mvInlineN">번호</div>
				    <div>제목</div>
				    <div class="mvInlineN">작성자</div>
				    <div class="mvInlineN td_num"><a href="#">조회<i class="fa fa-sort" aria-hidden="true"></i></a></div>
				    <div class="mvInlineN td_datetime"><a href="#">날짜<i class="fa fa-sort" aria-hidden="true"></i></a></div>
				  </li>
				  
				
				
				<%
				
				// 글 리스트가 존재한다면
				if(count != 0 ){
					
								
					for(int i = 0; i < qnaboardList.size(); i++){
						
						
						QnaBoardBean qbean = qnaboardList.get(i);
						
						
						// 들여쓰기 값 초기화
						int wid = 0;
						
				%>
				
				
				
				<!-- --------------------------------- 공지사항 표시 ----------------------------------->
				<%
					// 공지사항의 값은 0과 1으로 구분
					// qna_notice의 값이 1이면 공지사항이고 0이면 일반글
					
					// 공지사항이라면?
					if(qbean.getQna_notice().equals("1")){
				
				%>
					<li class="bo_notice likeTblTr likeTblTd">
					  
					  	<div class="mvInlineN td_num2">
					    	<strong class="notice_icon">
					    		<i class="fa fa-bullhorn" aria-hidden="true"></i>
					    		<span class="sound_only">공지</span>
					    	</strong>
					    </div>
					    
					    
					    <div class="td_subject" style="padding-left:0px">
					    
							<div class="bo_tit">
								<a href="./QnaBoardContent.qna?qna_board_num=<%=qbean.getQna_board_num()%>&pageNum=<%=pageNum%>">
									<%=qbean.getQna_board_title()%>   
									<em> <span class="hot_icon">H<span class="sound_only">인기글</span></span> </em>
								</a>
							</div>
							
						</div>
						
						
						<span class="onlyMvV" style="padding-left:0px"></span>
						
						<div class="mvInlinev td_name sv_use"><span class="sv_member"></span>
							관리자
						</div>
						
						<div class="mvInlinev td_num"><i class="fa fa-eye"></i>
							<%=qbean.getQna_board_read()%>
						</div>
						
						<div class="mvInlinev td_datetime"><i class="fa fa-clock-o"></i>
							<%= new SimpleDateFormat("yyyy.MM.dd").format(qbean.getQna_board_date())%>
						</div>
						
					</li>
				
				<!-- --------------------------------- 공지사항 끝 ----------------------------------->
				<%
					}
					// 만약 일반글이라면?
					else if(qbean.getQna_notice().equals("0")){
				%>
				<!-- --------------------------------- 일반글 시작 ----------------------------------->
				<li class=" likeTblTr likeTblTd">
				
					<div class="mvInlineN td_num2"><%=qbean.getQna_board_num() %></div>
					
					<div class="td_subject" style="padding-left:0px">
					
					
						<div class="bo_tit">
				<%
							// 글 작성자와 세션 아이디가 같다면	=> 글 작성자가 자신의 글을 누르면
							// SecretAction없이 바로 글로 이동 
							if(qbean.getMem_email().equals(id_email) || id_email.equals("admin@mango.com")){
				%>
								<a href="./QnaBoardContent.qna?qna_board_num=<%=qbean.getQna_board_num()%>&pageNum=<%=pageNum%>">
				<%
							} 
							// 글 작성자와 세션 아이디가 다르거나 세션 아이디가 없다면
							// SecretAction으로 글 비밀번호 검증 후 글 확인이 가능
							else{
				%>
								<a href="./QnaBoardSecret.qna?qna_board_num=<%=qbean.getQna_board_num()%>&pageNum=<%=pageNum%>">
				<%
							}
					

							// qna_re_lev가 존재한다면(= 답글이라면) 들여쓰기 값을 지정
							if(qbean.getQna_re_lev() > 0){
								
								wid = qbean.getQna_re_lev() * 10;
				%>
								<img src = "images/qna_img/level.gif" width = "<%=wid%>">
								<img src = "http://sample.paged.kr/purewhite/theme/pagedtheme/skin/board/basic/img/icon_reply.gif" class="icon_reply" alt="답변글">
				<%		
							}	
				%>
								<!-- 제목 출력 -->
								<%= qbean.getQna_board_title() %>
				
				<%		
						// 조회수가 10이 넘는다면 H를 사용하여 인기글 아이콘을 제목 옆에 위치함
						if(qbean.getQna_board_read() >= 10){
				%>  
				
							<span class="hot_icon">H<span class="sound_only">인기글</span></span></em>
				<%
						}
				%>
							</a>
					     </div>
					</div>
							
						<span class="onlyMvV" style="padding-left:0px"></span>
					    <div class="mvInlinev td_name sv_use"><span class="sv_member"><%= qbean.getMem_email() %></span></div>
					    <div class="mvInlinev td_num"><i class="fa fa-eye"></i><%= qbean.getQna_board_read() %></div>
						<div class="mvInlinev td_datetime"><i class="fa fa-clock-o"></i>
							<%= new SimpleDateFormat("yyyy.MM.dd").format(qbean.getQna_board_date()) %>
						</div>
				</li>
					
				<%
						}
					}
				}
					
				%>
				
				
				
			</ul>

		</div> <!-- board list (e) -->
		
		
		
		
		
		
		
		
		
		
		
		<!-- write button (s) -->
		<div class = "bo_fx">
			
			<ul class = "write_btn_user">
				
				<li>
						<%-- 로그인을 했다면 글쓰기 출력 --%>
						<c:if test="${id_email ne null}">

							<a href = "./QnaBoardWrite.qna" class = "btn_write">
								<i class = "fa fa fa-pencil" aria-hidden = "true"></i>
								글쓰기
							</a>
							
						</c:if>
					
				</li>
				
			</ul>
		
		</div>
		<!-- write button (e) -->
		
		
		
	</form>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<!-- search button (s) -->
	<fieldset id = "bo_sch">
	
		<form name = "fsearch" method = "get" action = "./QnaBoardSearch.qna">
		
			
			<label for = "sf1" class = "sound_only">검색대상</label>
			
			<!-- 검색 카테고리 -->
			<select name = "search_key">
				<option value = "qna_board_title">제목</option>
				<option value = "mem_email">이메일</option>
			</select>
			
			<label for = "stx" class = "sound_only">검색어
				<strong>필수</strong>
			</label>
			
			<!-- 검색어 -->
			<input type = "text" name = "search_word" size = "25" class = "sch_input" maxlength="20" placeholder = "검색어를 입력해주세요.">
			
			<button type = "submit" value = "검색" class = "sch_btn">
				<i class = "fa fa-search" aria-hidden = "true"></i>
				<span class = "sound_only">검색</span>
			</button>
			
		</form>
		
	</fieldset>
	<!-- search button (e) -->
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<!-- paging button -->
	<nav class = "pg_wrap">
		<span class = "pg">


<!-- -------------------- 페이징 블록 수정 CSS 수정 ---------------------------------------- -->


<%
		
			
		if(count > 0){
			
			
			if(startPage > pageBlock){
%>
			<a href = "./QnaBoard.qna?pageNum=<%=startPage-pageBlock%>" class = "pg_page">
<!-- 			<img src="images/qna_img/btn_next.png" class = "btnimg"> -->
			Prev
			</a>
<%			
			}
			
			
			for(int i = startPage; i <= endPage; i++){
				
%>			
				<a href = "./QnaBoard.qna?pageNum=<%=i%>" class = "pg_current"><%=i%></a>
<%
			}
			
			if(endPage < pageCount){
%>
			
			<a href="./QnaBoard.qna?pageNum=<%=startPage+pageBlock%>"  class = "pg_page">Next</a>
	
<%
			}
		}
					
%>		

			
<!-- 			<a href = "#" class = "pg_page">2<span class = "sound_only">페이지</span> -->
<!-- 			</a> -->
			
<!-- 			<a href = "#" class = "pg_page pg_end">끝</a> -->
		</span>
	</nav>
	<!-- paging button -->
	
	
	
</div>	<!-- qna_container (e) -->




<!-------------------------------------------------------- [스크립트 링크영역]  -------------------------------------------------------------------------->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="js/blog_single.js"></script>



</body>
</html>