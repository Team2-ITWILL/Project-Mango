<%@page import="mango.anony_board.db.AnonyBoardBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>고객센터</title> 
<!---------------------------------- 메타데이터  ---------------------------------------------------->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!---------------------------------- CSS  ---------------------------------------------------->
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">


<link rel="stylesheet" type="text/css" href="styles/qna_page.css">
<!---------------------------------- 제이쿼리  ---------------------------------------------------->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
<!-- qna_container (s) -->
<div class = "qna_container container">
	
	<div id="container">
	
	
	<!-- read box(s)-->
	<article id="bo_v" style="width:100%">
		
		<header>
		
			<h2 id="bo_v_title">
			
			<c:choose>
				
				<c:when test="${not empty re_list}">
					<span class="qnaIco qnaIco2"><i class="fa fa-smile-o" aria-hidden="true"></i> 답변완료</span>
					<strong>
						<a href = "#re_beanlist">
							<i class = "fa fa-commenting-o iconmsg" aria-hidden="true">
								<strong>${fn:length(re_list)}건의 답변이 등록 되었습니다.</strong>
							</i>
						</a>
					</strong>
				</c:when>
				
				<c:when test="${empty re_list and qbean.qna_notice == '0'}">
						<span class="qnaIco qnaIco3">
						<i class="fa fa-spinner" aria-hidden="true"></i> 접수완료</span>
				</c:when>
					
				<c:when test="${empty re_list and qbean.qna_notice == '1'}">
						<span  class="qnaIco">공지사항</span>
				</c:when>
				
			</c:choose>
				
				<span class="bo_v_tit">${qbean.qna_board_title}</span>
				

			</h2>
			
		</header>
			
		<section id="bo_v_info">
			<h2>페이지 정보</h2>
			<span class="sound_only">작성자</span> <strong><span class="sv_guest">${qbean.mem_email}</span></strong>
			<span class="sound_only">조회</span><strong><i class="fa fa-eye" aria-hidden="true"></i> ${qbean.qna_board_read}</strong>
			<strong class="if_date"><span class="sound_only">작성일</span><i class="fa fa-clock-o" aria-hidden="true"></i> 			
				<fmt:formatDate value="${qbean.qna_board_date}" pattern="yyyy.MM.dd HH:mm:ss"/>
			</strong>
		</section>
			
		<section id="bo_v_atc">
			<h2 id="bo_v_atc_title">본문</h2>
			
			<!-- 본문 내용 (s) -->
			<div id="bo_v_con">
				<p>${qbean.qna_board_content}</p>
			</div>
		</section>
			    
		<!-- box button(s)-->
		<div id="bo_v_top">
		
			<!-- 수정 및 삭제 버튼 -->
			<ul class="bo_v_left">

					<c:if test="${id_email == 'admin' || id_email == 'admin@mango.com' || id_email == qbean.mem_email}">
		
						<li>
					
						
						<a href="./QnaBoardUpdate.qna?qna_board_num=${qbean.qna_board_num}&pageNum=${pageNum}" class="btn_b01 btn">
							<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
							수정
						</a>
						
					
					</li>
					
					
					<c:choose>
						<c:when test="${id_email == 'admin' or id_email == 'admin@mango.com'}">
								
							    <li>
							    	<a href="./QnaBoardDeleteAdmin.qna?qna_board_num=${qbean.qna_board_num}&pageNum=${pageNum}" class="btn_b01 btn" onclick="del(this.href); return false;">
							    		<i class="fa fa-trash-o" aria-hidden="true"></i>
							    		삭제
							    	</a>
							    	
							    </li>
							    
						</c:when>
						  
						
						<c:otherwise>
								<li>
							    	<a href="./QnaBoardDelete.qna?qna_board_num=${qbean.qna_board_num}&pageNum=${pageNum}" class="btn_b01 btn" onclick="del(this.href); return false;">
							    		<i class="fa fa-trash-o" aria-hidden="true"></i>
							    		삭제
							    	</a>
							    	
							    </li>
						</c:otherwise>
					</c:choose>    

					    
					    
			    	
			    	</c:if>
			</ul>
			
			<ul class="bo_v_com">
				
				<!-- 목록으로 가기 -->
				<li>
					<a href="./QnaBoard.qna?pageNum=${pageNum}" class="btn_b01 btn"><i class="fa fa-list" aria-hidden="true"></i> 목록</a>
				</li>
			    
			    <!-- 답변 등록 -->
				<c:if test="${id_email == 'admin' || id_email == 'admin@mango.com'}">
				    <li>
				    	<a href="./QnaBoardReWrite.qna?qna_board_num=${qbean.qna_board_num}&qna_re_ref=${qbean.qna_re_ref}&qna_re_lev=${qbean.qna_re_lev}&qna_re_seq=${qbean.qna_re_seq}" class="btn_b02 btn">
				    	<i class="fa fa-pencil" aria-hidden="true"></i> 답변등록</a>	
				    	
				    </li>
			    </c:if>
			</ul>
			
		</div>
		
		
		
		<!-- box button(e)-->
		<hr class="dashHr">
		<button type="button" class="cmt_btn">
			<i class="fa fa-commenting-o"></i> 답변목록
			<i class="fa fa-chevron-up" aria-hidden="true"></i>
			<i class="fa fa-chevron-down" aria-hidden="true"></i>
		</button>
		
		
		
		
		
		<!-- reply(s)-->
		<section id="bo_vc">
		
			<h2>답변목록</h2>
			
			
			<article id = "c_33">
				
				<%--답변이 있을 경우 --%>
				<c:if test="${not empty re_list}">
					
					<c:forEach var = "re_bean" items="${re_list}">
						
						<header style = "z-index:2">
							<h2>${re_bean.mem_email}의 답변</h2>
							<span class = "member">관리자</span>
							<span class = "bo_vc_hdinfo">
								<i class = "fa fa-clock-o" aria-hidden="true"></i>
								<fmt:formatDate value="${re_bean.qna_board_date}" pattern="yyyy.MM.dd HH:mm:ss"/>
							</span>
						</header>
						
						<div class = "cmt_contents">
							<a href ="./QnaBoardContent.qna?qna_board_num=${re_bean.qna_board_num}&pageNum=${pageNum}">
								<p>${re_bean.qna_board_title}</p>
							</a>
						</div>
						
					</c:forEach>
					
				</c:if>




				<c:if test="${empty re_list}">
					<%--답변이 없을 경우 --%>
					<p id="bo_vc_empty">등록된 답변이 없습니다.</p>
				</c:if>
				
			</article>
			
			
		</section>
		<!-- reply(e)-->
	
	</article>
	<!-- read box(e)-->
	</div>
	
	
</div> <!-- qna_container (e) -->



</body>
</html>