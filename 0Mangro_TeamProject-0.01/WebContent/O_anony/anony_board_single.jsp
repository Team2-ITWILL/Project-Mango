<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>익명사담방</title>
<!-- 메타데이터  -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="mango">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 제이쿼리 & js  -->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<!-- 링크목록  -->
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/anony_board_single.css">
<link rel="stylesheet" type="text/css" href="styles/anony_board_single_responsive.css">
<style type="text/css">
	.title-btn{
	    color: #000;
	    text-align: center;
	    display: inline-block;
	    width: 85px;
	    float: right;
	    padding: 10px;
	    font-size: 1em;
	    font-weight: 400;
	   	margin-top: 30px;
	    cursor: pointer;
	    position: relative;
	    z-index: 11;
	}
	.title-btn:hover{cursor: pointer; color: #000;}
	.boardremove:hover, .boardrevise:hover { color: #e95765; cursor:pointer;}
	.boardrevise{ color: #000; margin-left:8px;}
	.cmCount{color:#3094ff;}
	.ifnotwriter{  margin-top: 20px; }	
	
}
	
</style>


<script type="text/javascript">

	// [파일 다운로드 처리 함수 : 첨부파일 클릭시 AnoBoardFileDownAction.anob로 이동 ]
	function fileDown(ano_board_num) {
		var ifrm = document.getElementById("ifrm_filedown");
		ifrm.src ="AnoBoardFileDownAction.anob?ano_board_num="+ano_board_num;
		
	}


</script>


</head>

<body>


	<!-- 익명게시판(댓글목록과 같은 형태의 게시판 - 클릭하면 상세페이지로 이동) -->
		<div class="container">
			<div class="row">

<%-------------------------------------------------- [익명게시글 목록]  --------------------------------------------------------------------------%>
					<div class="comments_container">
						
					  <c:choose>
					  
							<c:when test="${id_email eq boardSingle.mem_email}">
							
								<div class="title-btn tolistBtn boardrevise" onclick="location.href='./AnonyBoardListAction.anob'">
									<span>목록보기</span></div> 
								<div class="title-btn boardrevise" onclick="location.href='./AnoBoardToUpdateFormAction.anob?ano_board_num='+${boardSingle.ano_board_num}">
									<span>수정</span></div>
								<div class="title-btn boardremove" onclick="location.href='./AnoBoardDeleteAction.anob?ano_board_num='+${boardSingle.ano_board_num}">
									<span>삭제</span></div> <br>
							</c:when>	
							
							<c:otherwise>
								<div class="title-btn tolistBtn boardrevise ifnotwriter" onclick="location.href='./AnonyBoardListAction.anob'">
									<span>목록보기</span></div> 
							</c:otherwise>
							
					  </c:choose>		
					  
					  
						<div class="comments_title" id="board_title">${boardSingle.ano_board_title }</div>
							<hr>
						
						<%-- 제목, 닉네임, 조회수, 날짜 --%>
						<i class="fa fa-user" aria-hidden="true"></i> <span class="icons_margin">${boardSingle.ano_board_nick }</span>
						<img src="images/etc/eye.png" width="20"> <span class="icons_margin">${boardSingle.ano_board_read }</span>
						<img src="images/etc/date.png" width="20"> 
							<span class="icons_margin">
							<fmt:formatDate value="${boardSingle.ano_board_date}" pattern ="yyyy.MM.dd KK:mm:ss" type="both"/>
							<%-- ${boardSingle.ano_board_date } --%>
							</span>
						
						<%-- 첨부파일 --%>
						<%-- 아이프레임을 이용한 다운로드 --%>
						<iframe id="ifrm_filedown" style="position:absolute; z-index: 1; visibility: hidden;">
						</iframe>
						
						<%-- 내용 --%>
						<div class="comment_text">
							<%-- 첨부파일이 있는 경우 이미지 표시를 위해 ----%>
							<c:choose>
								<c:when test="${boardSingle.ano_board_file ne null}">
									<p><img src="O_aca_regFiles/${boardSingle.ano_board_file}" width="300"></p>
								</c:when>
							</c:choose>
							
							<p>${boardSingle.ano_board_content }</p> <br><br>
							
							
							<span class="report_comment" onclick="alert('신고할 수 없습니다.');">신고하기</span> <br><br>
						</div>
						
						
						<%-- 첨부파일 다운을 위해 클릭하는 영역 --%>
							<c:choose>
								<c:when test="${boardSingle.ano_board_file ne null}">
									<div onclick="fileDown('${boardSingle.ano_board_num }')">
										<i class="fa fa-download" aria-hidden="true"></i>
										<a style="cursor: pointer;"><span class="fileSpan">${boardSingle.ano_board_file }</span> </a>
									</div>
								</c:when>
							</c:choose>
						
						<hr>
						
						
						
						<div class="comment_total">댓글 <span class="cmCount">108798</span></div>
						<form class="" action="" method="post">
				      		<div class="form-group mb-8">
							<button class="comments_write_button writeBtn" type="submit">댓글달기</button>
								<textarea name="text" class="form-control" placeholder="내용을 입력해주세요."></textarea>
	       					</div>
				      	</form>
						<ul class="comments_list"> 
<!-------------------------------------------------------- [▼ 코멘트 1줄]  -------------------------------------------------------------------------->
							<li> 
								<div class="comment_item d-flex flex-row align-items-start jutify-content-start">
								<!-- ▲ 링크걸어 이동 -->
										<!-- 댓글 프로필사진 -->
										<img src="images/etc/default_mango.png" class="user_profile" width="60" >
									<div class="comment_content">
										<i class="fa fa-user" aria-hidden="true"></i> <span class="icons_margin">#9090  </span> 										
										<!-- 날짜 -->
										<span>2020-08-22 00:29</span>
										
										<img src="images/etc/revise.png" class="comm_icon revise" width="20">
										<img src="images/etc/delete.png" class="comm_icon" width="20">
										<img src="images/etc/reply.png" class="comm_icon" width="20">

										<!-- 내용 -->
										<div class="comment_author">
											<span>오.. 엄청 험난한 2019년을 보냈나본데</span>
										</div>
									</div>
								</div>
								
<!------------------------------[대댓글, 댓글수정 form 표시영역(각 버튼 클릭하면 숨겨져있던 form태그 나타나도록)]  ------------------------------------------------------------>

								<!-- (대댓글 쓰기 form) -->
								<form class="" action="" method="post">
						      		<div class="form-group mb-8">
						      		
										<textarea name="text" class="form-control replytxtarea" placeholder="내용을 입력해주세요."></textarea>
										<button class="comments_write_button comm_btn replytxtbtn" type="submit">댓글달기</button>
			       					</div>
						      	</form>
						      	
<!----------------------------------------------------------------------------------------------------------------------------------------------->
						      	
								<!-- (댓글수정 form) -->
								<form class="" action="" method="post">
						      		<div class="form-group mb-8">
						      		
										<textarea name="text" class="form-control replytxtarea" placeholder="내용을 입력해주세요."></textarea>
										<button class="comments_write_button comm_btn replytxtbtn" type="submit">댓글수정하기</button>
			       					</div>
						      	</form>
							</li> 
<!-------------------------------------------------------- [▲ 코멘트 1줄]  -------------------------------------------------------------------------->

						</ul>
					</div> <!-- comments_container -->
			</div> <!-- row -->
						
		</div> <!-- container -->


<!-------------------------------------------------------- [스크립트 영역]  -------------------------------------------------------------------------->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="js/blog_single.js"></script>
</body>
</html>