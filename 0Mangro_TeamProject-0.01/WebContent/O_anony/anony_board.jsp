<%@page import="mango.anony_board.db.AnonyBoardBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>익명사담방</title>
<!---------------------------------- 메타데이터  ---------------------------------------------------->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!---------------------------------- CSS  ---------------------------------------------------->
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/anony_board.css">
<link rel="stylesheet" type="text/css" href="styles/anony_board_single_responsive.css">
<!---------------------------------- 제이쿼리  ---------------------------------------------------->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>

<style>
	.comments_list li .comment_item {border-bottom: solid 1px #e5e5e5;border: 1px solid #e5e5e5;border-radius: 10px;padding: 20px;margin-top: 40px;margin-bottom: 20px;}
	.comment_content {width: 100%;padding-left: 20px;margin-top: -7px;}
	.widthAdjust {width: 1100px;}
	@media only screen and (max-width: 767px)
	{.widthAdjust {width: 550px;}}
	.boardCount{margin-top:10px; display: inline-block;margin-left: 20px;}
	.comments_title {display: inline-block; padding-top:100px;}
	.span-title{ font-size: 1.2em; font-weight: 700;	}
	
	
</style>



<body>




	<!-- 익명게시판(댓글목록과 같은 형태의 게시판 - 클릭하면 상세페이지로 이동) -->
		<div class="container">
			<div class="row">

<!-------------------------------------------------- [익명게시글 목록]  -------------------------------------------------------------------------->
					<div class="comments_container">
						<div class="comments_write_button" onclick="location.href='./AnoBoardWriteAction.anob'">글쓰기</div>
						<div class="comments_title">익명사담방</div>
						<h6 class="boardCount">총 <span>${anbCount}</span>개의 글이 있습니다.</h6>
						
						<ul class="comments_list"> 
<!-------------------------------------------------------- [▼ 코멘트 1줄]  -------------------------------------------------------------------------->
						
						<c:forEach var="anbList" items="${anbList}">
							<li class="widthAdjust" onclick="location.href='./AnoBoardSingleAction.anob?ano_board_num=${anbList.ano_board_num}'">
								<div class="comment_item d-flex flex-row align-items-start jutify-content-start" onclick="#">
									<img src="images/etc/default_mango.png" class="user_profile" width="60" >

									
									<div class="comment_content">
										<div class="comment_title_container d-flex flex-row align-items-center justify-content-start">
											<div class="comment_author">

												<!-- 익명사담방 랜덤 닉네임 -->
												<i class="fa fa-user" aria-hidden="true"></i> 
												<span class="icons_margin">${anbList.ano_board_nick}</span>
												<!-- 익명사담방 글제목 -->
												<p><span class="span-title">${anbList.ano_board_title}</span></p>
												
											</div>
										</div>
										
										
											<!-- 익명사담방 글내용 -->
										<div class="comment_text">
											<p>${anbList.ano_board_content}</p>
										</div>
										
										
										<div class="comment_extras d-flex flex-row align-items-center justify-content-start">
											<div class="comment_extra comment_tail">
												<img src="images/etc/comment.png" width="20">
												<!-- 댓글수  -->
												<span>미구현</span>
											</div> &nbsp;&nbsp;&nbsp;
											
											<div class="comment_extra comment_tail">
												<img src="images/etc/eye.png" width="20">
												<!-- 조회수  -->


												
												<span>${anbList.ano_board_read}</span>
												
											</div>&nbsp;&nbsp;&nbsp;
											
											<div class="comment_extra comment_tail">
												<img src="images/etc/date.png" width="20">
												<!-- 날짜  --> 
												<span>${anbList.ano_board_date}</span>
											</div>&nbsp;&nbsp;&nbsp;
										</div>
									</div> 
								</div>
							</li>
							 
						</c:forEach>
<!-------------------------------------------------------- [▲ 코멘트 1줄]  -------------------------------------------------------------------------->
						</ul> 
						
					</div>  <!-- comments_container -->
				</div> <!-- row -->
			</div> <!-- container -->





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