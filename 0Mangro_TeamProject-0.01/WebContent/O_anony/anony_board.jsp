<%@page import="mango.anony_board.db.AnonyBoardBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>익명사담방</title>
<!---------------------------------- 메타데이터  ---------------------------------------------------->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!---------------------------------- 제이쿼리  ---------------------------------------------------->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<!---------------------------------- CSS  ---------------------------------------------------->
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/anony_board.css">
<link rel="stylesheet" type="text/css" href="styles/anony_board_single_responsive.css">
</head>

<style>
	.comments_list li .comment_item {border-bottom: solid 1px #e5e5e5;border: 1px solid #e5e5e5;border-radius: 10px;padding: 20px;margin-top: 40px;margin-bottom: 20px;}
	.comment_content {width: 100%;padding-left: 20px;margin-top: -7px;}
	.widthAdjust {width: 1100px;}
	@media only screen and (max-width: 767px)
	{.widthAdjust {width: 550px;}}
	.boardCount{margin-top:10px; display: inline-block;margin-left: 20px;}
	.comments_title {display: inline-block; padding-top:100px;}
	.exstboard_title {padding-top:0;}
	.span-title{ font-size: 1.2em; font-weight: 700;	}
	.prevent_overflow_content {
		overflow: hidden;
	    text-overflow: ellipsis;
	    white-space: nowrap;
	    width: 60%;
	}
	.po_title { width: 100%; 	}
	@media only screen and (max-width: 767px)
	{.comments_write_button {
			    bottom: 5px;
    			width: 110px;}
	 .comment_tail {margin-right: 0;}
	 .po_title {width: 70%;}
	}
	
</style>



<body>



<script type="text/javascript">

	// [익명사담방 글쓰기 버튼 클릭시 로그인 여부 검사 ] 
	var id_email = "<c:out value='${id_email}'/>";
	
		function writeBtnClicked() {
			// 값을 받아오는지 확인
			// alert("<c:out value='${id_email}'/>");
			
			if(id_email == null || id_email == ""){
				
				alert("로그인이 필요한 서비스입니다.");
				location.href='./MemberLogin.me';
				
			}else{ location.href='./AnoBoardWriteAction.anob'; } //if
			
		}


	
	
	
</script>




	<!-- 익명게시판(댓글목록과 같은 형태의 게시판 - 클릭하면 상세페이지로 이동) -->
		<div class="container">
			<div class="row">
			   <c:choose>
<%---------------------------------------------------- [익명게시글 목록]  -------------------------------------------------------------------------%>
				  <c:when test="${anbCount == 0 or anbCount == '0'}">
				   <%-- 글이 하나도 없을 때 --%>
					<div class="comments_container">
						<div class="comments_title noboard">익명사담방</div> <br>
						<img class="noboard_img" src="images/etc/noboard.png" width="100">
						<h5 class="boardCount noboard_text">등록된 글이 하나도 없네요!&nbsp;&nbsp; 첫 글을 등록 해 보세요!</h5>
						<div class="comments_write_button noboard_btn" onclick="writeBtnClicked()">글쓰기</div>
					</div>
				  </c:when>	
				  
				   <%-- 글이 있을 때 --%>
				  <c:otherwise>
					<div class="comments_container">
						
						<div class="comments_write_button exstboard_btn" onclick="writeBtnClicked()">글쓰기</div>
						<div class="comments_title exstboard_title" >익명사담방</div>
						<h6 class="boardCount exstboard_text">총 <span>${anbCount}</span>개의 글이 있습니다.</h6>
						
						<%-- 검색영역 --%>
						<hr>
						<div class="input-group col-12 p-0 mb-3">
						  <form action="./AnonyBoardListAction.anob" method="post" class="form-control searchForm">
							<input type="search" id="query" name="searchKeyword" class="form-control" style="padding:10px; cursor: pointer;"
								   placeholder="검색">
								   
							<%-- 검색Button--%>
							<button type="submit" class="btn font-subhead btn-outline-primary text-nowrap width-100 search-btn" style="height: 60px; cursor: pointer;">
								<i class="fa fa-search" aria-hidden="true"></i>
							</button>
						  </form>
						</div>
						
						<ul class="comments_list"> 
<%---------------------------------------------------------- [▼ 코멘트 1줄]  --------------------------------------------------------------------------%>
						
						<c:forEach var="anbList" items="${anbList}">
						<%-- onclick="location.href='./AnoBoardSingleAction.anob?ano_board_num=${anbList.ano_board_num}'"  --%>
						<%-- 	<li class="widthAdjust" onclick="location.href='./AnoBoardSingleAction.anob?ano_board_num=${anbList.ano_board_num}'" id="enterAnoSingle"> --%>
								<li class="widthAdjust" onclick="enterCheck( ${anbList.ano_board_num}, ${reportedCheckList[anbList.ano_board_num]} )" id="enterAnoSingle"> 
								<div class="comment_item d-flex flex-row align-items-start jutify-content-start">
									<img src="images/etc/default_mango.png" class="user_profile" width="60" >

									
									<div class="comment_content">
										<div class="comment_title_container d-flex flex-row align-items-center justify-content-start">
											<div class="comment_author">

										<%------ 랜덤닉네임 ----%>
												<i class="fa fa-user-circle-o" aria-hidden="true"></i>
												<span class="icons_margin">${anbList.ano_board_nick}</span>
												
										<%------ 글제목 ----%>
										
										<c:choose>
											<%-- 신고가 진행중인 글=1, 열람가능한 글 = 0 --%>
											<c:when test="${reportedCheckList[anbList.ano_board_num] ne 0}">
												<p style="padding-top: 10px; color:#000 !important;" class="prevent_overflow po_title">
													<span class="span-title">신고된 글입니다. 열람이 제한됩니다.</span>
												</p>
											</c:when>
											
											<c:otherwise>
												<p style="padding-top: 10px; color:#000 !important;" class="prevent_overflow po_title">
													<span class="span-title">${anbList.ano_board_title}</span>
												</p>
											
											</c:otherwise>
												
										</c:choose>
											</div>
										</div>
										<%------ 글번호 hidden ----%>
										<input type="hidden" value="${anbList.ano_board_num}" id="hiddenAnoNum">
										
										
										<%------ 글내용 ----%>
										<c:choose>
										<%-- 신고가 진행중인 글 내용 = 1, 열람가능한 글 내용 = 0 --%>
										
											<c:when test="${reportedCheckList[anbList.ano_board_num] ne 0}">
												<div class="comment_text">
													<p class="prevent_overflow_content"></p>
												</div>
											</c:when>
											
											<c:otherwise>
												<div class="comment_text">
													<p class="prevent_overflow_content">${anbList.ano_board_content}</p>
												</div>
											</c:otherwise>
											
										</c:choose>										
										
										<div class="comment_extras d-flex flex-row align-items-center justify-content-start">
											<div class="comment_extra comment_tail">
												<img src="images/etc/comment.png" width="20">
												
										<%------ 댓글수 ----%>
												<span>${comments[anbList.ano_board_num]}</span>
											</div> &nbsp;&nbsp;&nbsp;
											
											<div class="comment_extra comment_tail">
												<img src="images/etc/eye.png" width="20">
												<!-- 조회수  -->

												
												<span>${anbList.ano_board_read}</span>
												
											</div>&nbsp;&nbsp;&nbsp;
											
											<div class="comment_extra comment_tail dateDiv">
												<img src="images/etc/date.png" width="20">
												
										<%------ 날짜 ----%>
										<%------ 오늘 날짜 객체 생성 ----%>
										<jsp:useBean id="today" class="java.util.Date"></jsp:useBean>
										<fmt:parseNumber value="${today.time / (1000 * 60 * 60 * 24)}" 
										                 var="nowDays" integerOnly="true" /> 
										
										<%------ DB에 저장된 글의 날짜 객체 생성 ----%>
										<fmt:parseNumber value="${anbList.ano_board_date.time / (1000 * 60 * 60 * 24)}" 
										                 var="regDays" integerOnly="true" />
										                 
										<%------ 두 날짜의 차를 변수 dayDiff에 저장----%>
										<c:set value="${nowDays - regDays }" var="dayDiff" />
										
										<c:choose>
										
										
										
										<%------ 두 날짜의 차가 0일때(오늘 쓴 글일 때) New 표시----%>
											<c:when test="${dayDiff == 0}">
											<fmt:formatDate value="${anbList.ano_board_date}" pattern ="yyyy.MM.dd KK:mm:ss" type="both"/>
												<span><img src="images/etc/new.png" width="30"></span>
											</c:when>
											
										<%------ 오늘 쓴 글이 아닐 때 날짜만 표시----%>
											<c:otherwise>
											<fmt:formatDate value="${anbList.ano_board_date}" pattern ="yyyy.MM.dd KK:mm:ss" type="both"/>
											</c:otherwise>
										</c:choose>
										
										
										<%------ 첨부파일이 있을 때 표시----%>
											<c:if test="${anbList.ano_board_file ne null }">
												<span><img src="images/etc/file.png" width="15"></span>
											</c:if>
																				
											</div>&nbsp;&nbsp;&nbsp;
										</div>
									</div> 
								</div>
							</li>
						</c:forEach>
<%---------------------------------------------------------- [▲ 코멘트 1줄]  --------------------------------------------------------------------------%>
						</ul> 
						
					</div>  <!-- comments_container -->
				</c:otherwise>	
				
			  </c:choose>
			</div> <!-- row -->
		</div> <!-- container -->







<%---------------------------------------------------------- [스크립트 링크영역]  --------------------------------------------------------------------------%>

<script type="text/javascript">

	var checkIfReported =  "<c:out value='${checkIfReported}'/>";
	var	enterAnoSingle = document.getElementById("enterAnoSingle");
	var urlAddr = "";
	
		function enterCheck(ano_board_num, reportedCheck) {

			if(reportedCheck == 1 ){
				alert("신고된 글이므로 열람이 제한됩니다. 이용에 불편을 드려 죄송합니다.");
			}
			
			if(reportedCheck == 0 ){
				location.href="./AnoBoardSingleAction.anob?ano_board_num="+ano_board_num; 
				
			}
			
		}


</script>


<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="js/blog_single.js"></script>
</body>
</html>