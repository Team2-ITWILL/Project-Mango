<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>익명사담방</title>
<!-- 메타데이터  -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 링크목록  -->
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/anony_board.css">
<link rel="stylesheet" type="text/css" href="styles/anony_board_single_responsive.css">
<!-- 제이쿼리  -->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>

<style>
	
.comments_list li .comment_item {
    border-bottom: solid 1px #e5e5e5;
    border: 1px solid #e5e5e5;
    border-radius: 10px;
    padding: 20px;
    margin-top: 40px;
    margin-bottom: 20px;
}

.comment_content {
    width: 100%;
    padding-left: 20px;
    margin-top: -7px;
    
}
</style>



<body>




	<!-- 익명게시판(댓글목록과 같은 형태의 게시판 - 클릭하면 상세페이지로 이동) -->
		<div class="container">
			<div class="row">

<!-------------------------------------------------- [익명게시글 목록]  -------------------------------------------------------------------------->
					<div class="comments_container">
						<div class="comments_write_button" onclick="location.href='4index.jsp?center=O_anony/anony_board_write.jsp'">글쓰기</div>
						<div class="comments_title">익명사담방</div>
						<h6>총 <span>30</span>개의 글이 있습니다.</h6>
						
						<ul class="comments_list"> 
<!-------------------------------------------------------- [▼ 코멘트 1줄]  -------------------------------------------------------------------------->
							<li> 
								<div class="comment_item d-flex flex-row align-items-start jutify-content-start"
								     onclick="location.href='4index.jsp?center=O_anony/anony_board_single.jsp'">
								<!-- ▲ 링크걸어 이동 -->
								
									<img src="images/etc/default_mango.png" class="user_profile" width="60" >								
								
									<div class="comment_content">
										<div class="comment_title_container d-flex flex-row align-items-center justify-content-start">
											<div class="comment_author">
												<a href="4index.jsp?center=O_anony/anony_board_single.jsp">2020년은 인간적으로 1년 더 살고 싶다.</a>
											</div>
										</div>
										<div class="comment_text">
											<p>There are many variations of passages of Lorem Ipsum available, but the majority have alteration in some form, by injected humour.</p>
										</div>
										<div class="comment_extras d-flex flex-row align-items-center justify-content-start">
											<div class="comment_extra comment_tail">
												<img src="images/etc/comment.png" width="20">
												<span>20</span>
											</div> &nbsp;&nbsp;&nbsp;
											<div class="comment_extra comment_tail">
												<img src="images/etc/eye.png" width="20">
												<span>3</span>
											</div>&nbsp;&nbsp;&nbsp;
											<div class="comment_extra comment_tail">
												<img src="images/etc/date.png" width="20">
												<span>2020-08-18</span>
											</div>&nbsp;&nbsp;&nbsp;
										</div>
									</div>
								</div>
							</li> 
<!-------------------------------------------------------- [▲ 코멘트 1줄]  -------------------------------------------------------------------------->
<!-------------------------------------------------------- [▼ 코멘트 1줄]  -------------------------------------------------------------------------->
							<li>
								<div class="comment_item d-flex flex-row align-items-start jutify-content-start" onclick="#">
									<img src="images/etc/default_mango.png" class="user_profile" width="60" >
									
									<div class="comment_content">
										<div class="comment_title_container d-flex flex-row align-items-center justify-content-start">
											<div class="comment_author">
												<a href="#">다들 조금만 힘 내 이제 곧 끝나가</a>
											</div>
										</div>
											<div class="comment_text">
											<p>There are many variations of passages of Lorem Ipsum available, but the majority have alteration in some form, by injected humour.</p>
										</div>
										<div class="comment_extras d-flex flex-row align-items-center justify-content-start">
											<div class="comment_extra comment_tail">
												<img src="images/etc/comment.png" width="20">
												<span>20</span>
											</div> &nbsp;&nbsp;&nbsp;
											<div class="comment_extra comment_tail">
												<img src="images/etc/eye.png" width="20">
												<span>3</span>
											</div>&nbsp;&nbsp;&nbsp;
											<div class="comment_extra comment_tail">
												<img src="images/etc/date.png" width="20">
												<span>2020-08-18</span>
											</div>&nbsp;&nbsp;&nbsp;
										</div>
									</div>
								</div>
							</li> 
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