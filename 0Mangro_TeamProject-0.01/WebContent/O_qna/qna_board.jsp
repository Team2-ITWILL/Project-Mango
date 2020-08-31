<%@page import="mango.qna_board.db.QnaBoardBean"%>
<%@page import="java.util.List"%>
<%@page import="mango.anony_board.db.AnonyBoardBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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



%>


<body>


	<!-- qna_container (s) -->
	<div class = "qna_container container">
	
		<div class = "qna_title">
			고객센터 	-> 테스트용 지울 것 [전체 글 개수 ${count}]
		</div>
	
	
		
	<!-- board list (s) -->
	<form name="fboardlist" id="fboardlist" action="#" onsubmit="#" method="post">


   		<h2 class="sound_only">기본게시판 목록</h2>
    
    
    
	    <div class="likeTbl">
	       
	        <ul>
			  
				  <li class="likeTblTr likeTblTh">
				  	<div class="mvInlineN">번호</div>
				    <div>제목</div>
				    <div class="mvInlineN">작성자</div>
				    <div class="mvInlineN td_num"><a href="#">조회<i class="fa fa-sort" aria-hidden="true"></i></a></div>
				    <div class="mvInlineN td_datetime"><a href="#">날짜<i class="fa fa-sort" aria-hidden="true"></i></a></div>
				  </li>
				  
				  
				<!-- 공지사항 -->
				<li class="bo_notice likeTblTr likeTblTd">
				  
				  	<div class="mvInlineN td_num2">
				    	<strong class="notice_icon">
				    		<i class="fa fa-bullhorn" aria-hidden="true"></i>
				    		<span class="sound_only">공지</span>
				    	</strong>
				    </div>
				    
				    
				    <div class="td_subject" style="padding-left:0px">
						<div class="bo_tit">
					    	<a href="#none">
								공지사항 - 제목                       
								<em> <span class="hot_icon">H<span class="sound_only">인기글</span></span> </em>
								<span class="sound_only">댓글</span><span class="cnt_cmt">+ 1</span><span class="sound_only">개</span>
							</a>
						</div>
					</div>
					
					<span class="onlyMvV" style="padding-left:0px"></span>
					<div class="mvInlinev td_name sv_use"><span class="sv_member">작성자</span></div>
					<div class="mvInlinev td_num"><i class="fa fa-eye"></i>조회수</div>
					<div class="mvInlinev td_datetime"><i class="fa fa-clock-o"></i> 00-00</div>
		
				</li>
				
				
				<%
					
				if(count != 0 ){
					
					for(int i = 0; i < qnaboardList.size(); i++){
						
						QnaBoardBean qbean = qnaboardList.get(i);
						
						int wid = 0;
						
						
				%>
 
				       
				<!-- 일반글 --> 
				<li class=" likeTblTr likeTblTd">
				
					<div class="mvInlineN td_num2"><%=qbean.getQna_board_num() %></div>
					
					<div class="td_subject" style="padding-left:0px">
						<div class="bo_tit">
						<a href="./QnaBoardContent.qna?qna_board_num=<%=qbean.getQna_board_num()%>&pageNum=<%=pageNum%>">
				<%
						if(qbean.getQna_re_lev() > 0){
							
							wid = qbean.getQna_re_lev() * 10;
				%>
					
					<!-- ---------------- 경로 수정하기 -------------------- -->
					<img src = "images/qna_img/level.gif" width = "<%=wid%>">
					<img src = "http://sample.paged.kr/purewhite/theme/pagedtheme/skin/board/basic/img/icon_reply.gif" class="icon_reply" alt="답변글">
						
				<%		
						}
				
				%>  
							<%= qbean.getQna_board_title() %>
    
								<em><i class="fa fa-link" aria-hidden="true"></i><span class="hot_icon">H<span class="sound_only">인기글</span></span></em>
							</a>
					     </div>
					</div>
							
						<span class="onlyMvV" style="padding-left:0px"></span>
					    <div class="mvInlinev td_name sv_use"><span class="sv_member"><%= qbean.getMem_email() %></span></div>
					    <div class="mvInlinev td_num"><i class="fa fa-eye"></i><%= qbean.getQna_board_read() %></div>
						<div class="mvInlinev td_datetime"><i class="fa fa-clock-o"></i><%= qbean.getQna_board_date() %></div>
				</li>
					
				<%
					}
				}
				
					
				%>
				
					
				<!-- 일반글2 -->
				<li class=" likeTblTr likeTblTd">
					
					<div class="mvInlineN td_num2">글번호</div>
					
					<!-- 글제목 -->
					<div class="td_subject" style="padding-left:0px">
						<div class="bo_tit">
							<a href="#none">
								첨부파일 + 이미지 첨부 + 인기글
								<em><i class="fa fa-download" aria-hidden="true"></i><i class="fa fa-link" aria-hidden="true"></i><span class="hot_icon">H<span class="sound_only">인기글</span></span></em></a>
					    </div>
					</div>
					
					<span class="onlyMvV" style="padding-left:0px"></span>
				    <div class="mvInlinev td_name sv_use"><span class="sv_member">글쓴이</span></div>
				    <div class="mvInlinev td_num"><i class="fa fa-eye"></i>조회수</div>
				    <div class="mvInlinev td_datetime"><i class="fa fa-clock-o"></i>날짜</div>
				
				</li>
				
				
				<li class=" likeTblTr likeTblTd">
					<div class="mvInlineN td_num2">글번호</div>
					<div class="td_subject" style="padding-left:0px">
						<div class="bo_tit">
							<a href="#none">
								글제목
								<em><i class="fa fa-download" aria-hidden="true"></i><i class="fa fa-link" aria-hidden="true"></i><span class="hot_icon">H<span class="sound_only">인기글</span></span></em>
								<span class="sound_only">댓글</span><span class="cnt_cmt">+ 8</span><span class="sound_only">개</span>
							</a>
						</div>
					</div>
						<span class="onlyMvV" style="padding-left:0px"></span>
				        <div class="mvInlinev td_name sv_use"><span class="sv_member">글쓴이</span></div>
				        <div class="mvInlinev td_num"><i class="fa fa-eye"></i>조회수</div>
				        <div class="mvInlinev td_datetime"><i class="fa fa-clock-o"></i>날짜</div>
				</li>
				
				
				
				<li class=" likeTblTr likeTblTd">
					<div class="mvInlineN td_num2">글번호</div>
					
					<div class="td_subject" style="padding-left:10px">
				    	<div class="bo_tit">
				        	<a href="#none">
				            	<img src="http://sample.paged.kr/purewhite/theme/pagedtheme/skin/board/basic/img/icon_reply.gif" class="icon_reply" alt="답변글">
				                Re: 답변글                       
								<em><span class="hot_icon">H<span class="sound_only">인기글</span></span></em>
							</a>
				        </div>
				
					</div>
						<span class="onlyMvV" style="padding-left:10px"></span>
				        <div class="mvInlinev td_name sv_use"><span class="sv_member">글쓴이</span></div>
				        <div class="mvInlinev td_num"><i class="fa fa-eye"></i>조회수</div>
				        <div class="mvInlinev td_datetime"><i class="fa fa-clock-o"></i>날짜</div>
				 </li>
				        
				        
				        
				 <li class=" likeTblTr likeTblTd">
				 
				 	<div class="mvInlineN td_num2">글번호</div>
				 	
				    <div class="td_subject" style="padding-left:20px">
				    	<div class="bo_tit">
				        	<a href="#none">
				            	<img src="http://sample.paged.kr/purewhite/theme/pagedtheme/skin/board/basic/img/icon_reply.gif" class="icon_reply" alt="답변글">
				                Re: Re: 다답변글            
								<em><span class="hot_icon">H<span class="sound_only">인기글</span></span></em></a>
				        </div>
					</div>
					
						<span class="onlyMvV" style="padding-left:20px"></span>
				        <div class="mvInlinev td_name sv_use"><span class="sv_member">글쓴이</span></div>
				        <div class="mvInlinev td_num"><i class="fa fa-eye"></i>조회수</div>
				        <div class="mvInlinev td_datetime"><i class="fa fa-clock-o"></i>날짜</div>
				</li>
			</ul>

		</div><!-- board list (e) -->
		
		
		<!-- write button -->
		<div class = "bo_fx">
			
			<ul class = "write_btn_user">
				<li>
			<%
				
				String mem_email = (String)session.getAttribute("mem_email");
				
				if(mem_email != null){
			
			%>
					<a href = "#" class = "btn_write">
						<i class = "fa fa fa-pencil" aria-hidden = "true"></i>
						글쓰기
					</a>
			<%
				}
			%>
				</li>
			</ul>
		
		</div>
		
		
		
		
	</form>
	
	
	
	
	
	
	
	
	<!-- search button -->
	<fieldset id = "bo_sch">
		<form name = "fsearch" method = "get" action = "./QnaBoardSearch.qna">
		
			<input type = "hidden" name = "">
			<input type = "hidden" name = "">
			<input type = "hidden" name = "">
			
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
	</fieldset>	<!-- search button (e) -->
	
	
	
	
	<!-- paging button -->
	<nav class = "pg_wrap">
		<span class = "pg">



<!-- -------------------- 페이징도 다시 수정---------------------------------------- -->
			
			<a href = "#" class = "pg_page pg_start">처음</a>
			
<%
		if(count != 0){
			
			if(startPage > pageBlock){
%>
			
			<a href = "./QnaBoard.qna?pageNum=<%=startPage-pageBlock%>" class = "pg_page">1<span class = "sound_only">페이지</span>
			</a>
<%			
		}
			for(int i = startPage; i <= endPage; i++){
				
%>
			<a href = "./QnaBoard.qna?pageNum=<%=i%>" class = "pg_page"><%=i%><span class = "sound_only">페이지</span>
			</a>
<%
		}
			
			if(endPage < pageCount){
%>
			
			<a href="./QnaBoard.qna?pageNum=<%=startPage+pageBlock%>">Next</a>
	
<%
		}
	}
%>		

			
			<a href = "#" class = "pg_page">2<span class = "sound_only">페이지</span>
			</a>
			
			<a href = "#" class = "pg_page pg_end">끝</a>
		</span>
	</nav>
	
	
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