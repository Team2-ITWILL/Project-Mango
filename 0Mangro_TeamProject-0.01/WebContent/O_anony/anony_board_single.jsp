<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>익명사담방</title>
<%-- 메타데이터  --%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="mango">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%-- 제이쿼리 & js  --%>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<%-- 링크목록 --%>
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
	.nickWidth { display: inline-block; width: 250px;}
	#replyLev { margin-left: 50px; }

	
	.thumbnail_img{
		background-color: #b1b1b1 !important;
	    width: 500px !important;
	    height: 100px !important;
	    text-align: center !important;
	    padding-top: 40px !important;
	    margin-top: 100px !important;
	    border: 5px dotted #dcdcdc !important;
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


	<%-- 익명게시판(댓글목록과 같은 형태의 게시판 - 클릭하면 상세페이지로 이동)--%>
		<div class="container">
			<div class="row">

<%-------------------------------------------------- [익명게시글 목록]  --------------------------------------------------------------------------%>
					<div class="comments_container">
						
					  <c:choose>
					  
							<c:when test="${id_email eq boardSingle.mem_email or id_email eq 'admin@mango.com'} ">
							
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
						<input type="hidden" id="ano_board_num" value="${boardSingle.ano_board_num }">
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
							<c:if test="${boardSingle.ano_board_file ne null }">
								
								<c:choose>
								
								<c:when test="${fileType eq 'jpg' or fileType eq 'jpeg' or fileType eq 'png' or fileType eq 'gif' or fileType eq 'JPG' or fileType eq 'JPEG' or fileType eq 'PNG' or fileType eq 'GIF'}">
									<p><img src="O_anony_Files/${boardSingle.ano_board_file}" width="300"></p>
								</c:when>
								
								<c:otherwise>
									<div class="thumbnail_img">
										<span style="color:#fff;">이미지 미리보기를 지원하지 않는 형식의 파일입니다.</span>
									</div>
								
								</c:otherwise>
								
								</c:choose>
								
							</c:if>
							<p>${boardSingle.ano_board_content }</p> <br><br>
							
							<input type="hidden" value="${id_email }" id="hidden_email"> 
							
							<span id="reportBtn" class="report_comment" data-toggle="modal" onclick="openReport()">신고하기</span> <br><br>
						</div>
<%-------------------------------------------------------- [▼ 신고하기 모달창 영역 ]  --------------------------------------------------------------------------%>

					
        <div class="modal fade" id="modal_report" role="dialog" aria-labelledby="introHeader" aria-hidden="true" tabindex="-1">
            <div class="modal-dialog" style="width: auto; display: table;">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title reportH1">게시글 신고하기</h1>
                    </div>
                    <div class="modal-body">
                        <span class="modalSpan boldSpan">신고는 반대의견을 표시하는 기능이 아닙니다.</span> <br>
                        <span class="modalSpan" >신고 대신 반대 의견이나 [댓글]을 적어보시는 것은 어떨까요?</span><br>
                        <div class="reportTBarea">
                        	<table>
								<tr>
									<td>
										<label for="rea1" id="reason1">
											<input type="radio" name="reason4report" id="rea1" value="영리목적/홍보성">
											<span class="modalSpan">영리목적/홍보성</span>
										</label>
									</td>
									<td>
										<label for="rea2" id="reason2">
											<input type="radio" name="reason4report" id="rea2" value="불법정보">
											<span class="modalSpan">불법정보</span>
										</label>
									</td>
								</tr>                        	
								<tr>
									<td>
										<label for="rea3" id="reason3">
											<input type="radio" name="reason4report" id="rea3" value="음란성/선정성">
											<span class="modalSpan">음란성/선정성</span>
										</label>
									</td>
									<td>
										<label for="rea4" id="reason4">
											<input type="radio" name="reason4report" id="rea4" value="욕설/인신공격">
											<span class="modalSpan">욕설/인신공격</span>
										</label>
									</td>
								</tr>                        	
								<tr>
									<td>
										<label for="rea5" id="reason5">
											<input type="radio" name="reason4report" id="rea5" value="개인정보 노출">
											<span class="modalSpan">개인정보 노출</span>
										</label>
									</td>
									<td>
										<label for="rea6" id="reason2">
											<input type="radio" name="reason4report" id="rea6" value="반복게시(도배)">
											<span class="modalSpan">반복게시(도배)</span>
										</label>
									</td>
								</tr>                        	
								<tr>
									<td colspan="2">
										<label for="rea7" id="reason7">
											<input type="radio" name="reason4report" id="rea7" onclick="onETCRadio()" value="$('#hiddenInput').val()">
											<span class="modalSpan">기타</span> <br>
											<textarea id="hiddenInput" placeholder="100자 이내로 입력해주세요." style="display: none;">
											</textarea>
										</label>
									</td>
								</tr>                        	
                        	</table>
                        </div>
                        
                        <span class="modalSpan">신고가 진행중인 글은 운영규정 및 Mango운영진의 판단에 따라 삭제될 수 있으며, </span> <br>
                        <span class="modalSpan">운영규정에 위배되는 글을 게시하여 신고된 회원은 계정정지 조치가 취해집니다.</span> <br>
                        <span class="modalSpan">신고에 부적합한 글을 지속적으로 신고하는 회원에게는 제한 조치가 취해질 수 있습니다.</span>
                        
						                        
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">창닫기</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal" id="reportSubmit"
                                onclick="reportFunc('${boardSingle.ano_board_num}',event)">신고하기</button> 
                    </div>
                </div>
            </div>
        </div>

						
<%-------------------------------------------------------- [▲ 신고하기 모달창 영역 ]  --------------------------------------------------------------------------%>
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
						
						
<%-------------------------------------------------------- [▼ 댓글달기 영역 ]  --------------------------------------------------------------------------%>
						<div class="comment_total">댓글 <span class="cmCount"></span></div>
						<form action="" method="post" name="comm_insertFr">  
						<%-- 현재페이지에서 액션페이지로 보낼 값 : 작성자, 글번호, 댓글내용 --%>
				      		<div class="form-group mb-8">
								<input type="hidden" name="mem_email" id="session_memEmail" value="${id_email}">
								<input type="hidden" name="ano_board_num" id="init_boardNum" value="${boardSingle.ano_board_num}">
					      		
						<%-- 댓글달기 버튼 클릭시 ajax를 통해 댓글 insert + 비동기식 댓글 리스트 불러오기 --%>
								<button class="comments_write_button writeBtn" type="button" 
								        onclick="add_comment(${boardSingle.ano_board_num})">
								댓글달기
								</button>
					      		<textarea name="ano_comment_content" id="init_content" class="form-control" id="comm_content"></textarea>
	       					</div>
				      	</form>
				      	
						<ul class="comments_list"> 

<%------------------------------------ ↑    [ajax로 댓글 동적 생성되는 영역 : ul태그 사이]      ↓ ----------------------------------------------- --%>


						</ul>
					</div> <!-- comments_container -->
			</div> <!-- row -->
						
		</div> <!-- container -->

<%-------------------------------------------------------- [스크립트 영역]  --------------------------------------------------------------------------%>

<script type="text/javascript">




//---[1] 실시간 댓글달기(ajax) ----------------------------------------------------------------------------------------------------------------

	
	function add_comment(ano_board_num){
		
		// [댓글 내용 여부 검증 & 로그인여부 처리]
		
		if( $("#session_memEmail").val() == ""){
			alert("로그인이 필요한 서비스 입니다.");
			location.href="./MemberLogin.me";
			return;
		}
		
		if($("#init_content").val() == ""){
			alert("댓글 내용을 입력하세요.");
			return;
		}

		// [ajax를 통한 댓글 insert작업 후 게시글의 댓글 전부를 비동기식으로 불러오기]		
	    $.ajax({
	        type: "POST",
	        url : "./CommentAnoBoardInsertAction.cano",
	        data: { 
	        		mem_email:$("#session_memEmail").val(), 
	        		ano_board_num:$("#init_boardNum").val(),
	        		ano_comment_content:$("#init_content").val()
	        },
	        success : function(data){
	               // 댓글 insert후 댓글 내용 입력창 비워주기
	               $("#init_content").val("");
	               getCommentList();
	        },
	        error:function(request,status,error){
	            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	            console.log(status);
	       }
	        
	    });
		
	}//add_comment() func 끝
	
	 
//---[2] 실시간 댓글수정(ajax) ----------------------------------------------------------------------------------------------------------------
	 
	
	// [ajax를 통한 댓글 update작업 후 게시글의 댓글 전부를 비동기식으로 불러오기]		
	function update_comment(ano_comment_num){		

		// [4] 수정댓글 내용 여부 검증 & 로그인여부 처리
		if($("#update_content"+ano_comment_num).val() == ""){
			alert("댓글 내용을 입력하세요.");
			return;
			
		}		
		
	    $.ajax({
	        type: "POST",
	        url : "./CommentAnoBoardUpdateAction.cano",
	        data: { 
	        		ano_comment_num : ano_comment_num,
	        		ano_board_num : $("#init_boardNum").val(),
	        		ano_comment_content : $("#update_content"+ano_comment_num).val()
	        },
	        success : function(data){
	               //alert("ajax로 댓글 수정하기 성공");
	               
	               // 댓글 수정 후 댓글 내용 입력창 비워주기
	               $("#update_content"+ano_comment_num).val("");
	               
	               // 댓글 수정창 없애기
	               $("#updateCommFR"+ano_comment_num).attr("style","display:none;");
	               getCommentList();
	        },
	        error:function(request,status,error){
	            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	            console.log(status);
	       }
	        
	    });
		
	}//update_comment() func 끝
	
	
//---[3] 실시간 댓글삭제(ajax) ----------------------------------------------------------------------------------------------------------------
	 

	// [ajax를 통한 댓글  delete작업 후 게시글의 댓글 전부를 비동기식으로 불러오기	]	
	function delete_comment(ano_comment_num){		
		
	    $.ajax({
	        type: "POST",
	        url : "./CommentAnoBoardDeleteAction.cano",
	        data: { 
	        		ano_comment_num : ano_comment_num,
	        		ano_board_num : $("#init_boardNum").val()
	        },
	        success : function(data){
	               //alert("ajax로 댓글 삭제하기 성공");
	               
	               getCommentList();
	        },
	        error:function(request,status,error){
	            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	            console.log(status);
	       }
	        
	    });
		
	}//delete_comment() func 끝
	
	 
	 
	 
	 
//---[4] 실시간 대댓글달기(ajax) ----------------------------------------------------------------------------------------------------------------

	
	function reply_comment(ano_comment_num){
		// [대댓글 내용 여부 검증 & 로그인여부 처리]
		if( $("#reply_content"+ano_comment_num).val() == ""){
			alert("댓글 내용을 입력하세요.");
			return;
			
		}else if( $("#session_memEmail").val() == ""){
			alert("로그인이 필요한 서비스 입니다.");
			location.href="./MemberLogin.me";
			return;
		}		
		
		

		// [ajax를 통한 대댓글 INSERT 작업 후 게시글의 댓글 전부를 비동기식으로 불러오기]		
	    $.ajax({
	        type: "POST",
	        url : "./CommentAnoBoardReplyAction.cano",
	        data: { 
	        		mem_email:$("#session_memEmail").val(), 
	        		ano_board_num:$("#init_boardNum").val(),
	        		ano_comment_content:$("#reply_content"+ano_comment_num).val(),
	        		ano_re_ref:ano_comment_num,
	        		ano_re_lev:0, // 나중에 제값 넣어주기
	        		ano_re_seq:0 // 나중에 제값 넣어주기
	        },
	        success : function(data){
	               //alert("ajax로 대댓글 달기 성공");
	               // 댓글 insert후 대댓글 내용 입력창 비워주기
	               $("#reply_content"+ano_comment_num).val("");
	               // 대댓글 입력창 없애기
	               $("#replyCommFR"+ano_comment_num).attr("style","display:none;");
	               getCommentList();
	        },
	        error:function(request,status,error){
	            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	            console.log(status);
	       }
	        
	    });
		
	}//reply_comment() func 끝
		 
	 
	 
	 
//---[5] 실시간 댓글 전체목록 불러오기(ajax) ----------------------------------------------------------------------------------------------------------------
// - 초기 페이지 로딩시 댓글 불러오기 메서드 getCommentList() 호출
	
 	$(function(){
	    getCommentList();
	}); 

	// [ajax를 통해 댓글 전부를 비동기식으로 불러오기]		
 	function getCommentList(){
	    
	    $.ajax({
	        type:'get',
	        url : "./CommentAnoBoardListAction.cano",
	        dataType : "text",
	        data: { ano_board_num:$("#init_boardNum").val() },
	        //contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
	        success : function(data, textStatus){
	        	//alert("댓글 데이터 가져오기 성공!"+data);
	        	//console.log(data.length + "댓글갯수");
	        	$(".comments_list").empty(); 
				$(".cmCount").empty(); 
	        	var jsonData = JSON.parse(data);
	        	var allComments = jsonData.commentArray;
	        	
	        	var commentsHTML = ""; // 데이터를 불러와 댓글을 생성하는 html코드를 저장
	        		
		        	for(var i=0; i<allComments.length; i++){
		        	
		        	// ▶ li시작 
		        	commentsHTML += "<li class='comment"+allComments[i].ano_comment_num+"'> ";
		        	
		        	// [if문] - 대댓글인 경우
		        	if(allComments[i].ano_re_lev > 0){
			        	commentsHTML +=  "<div class='comment_item d-flex flex-row align-items-start jutify-content-start' id='replyLev' ><img src='images/etc/repArrow.png' width='50' style='margin-right:20px;'> ";
		        	}else{
			        	commentsHTML +=  "<div class='comment_item d-flex flex-row align-items-start jutify-content-start'> ";
		        	}
		        	
		        	// ▶ 프로필사진(망고) 
		        	commentsHTML +=   "<img src='images/etc/default_mango.png' class='user_profile' width='60' > ";
		        	commentsHTML +=   "<div class='comment_content'> ";
		        	// ▶ 랜덤닉네임 
		        	commentsHTML +=   "<i class='fa fa-user' aria-hidden='true'></i> ";
		        	commentsHTML +=   "<span class='icons_margin nickWidth'>"+allComments[i].ano_board_nick+"</span> ";
		        	// ▶ 날짜 
		        	commentsHTML +=   "<span>"+allComments[i].ano_comment_date+"</span> ";
		        	
		        	
		        	// [if문] - 본인인 경우
		        	if(allComments[i].mem_email == "<c:out value='${id_email}' />") {
			        	// ▶ 댓글 수정 버튼
			        	commentsHTML +=   "<img src='images/etc/revise.png' id='comm_modify' class='comm_icon revise' width='20' " ;
			        	commentsHTML +=   "onclick='upCommentOpen("+allComments[i].ano_comment_num+")'>";
			        	
			        	// ▶ 댓글 삭제 버튼
			        	commentsHTML +=   "<img src='images/etc/delete.png' id='comm_delete' class='comm_icon' width='20' " ;
			        	commentsHTML +=   "onclick='delete_comment("+allComments[i].ano_comment_num+")' >";
		        	}

		        	// [if문] - 대댓글에 댓글을 달기 방지
		        	if(allComments[i].ano_re_lev == 0 ) {
		        	// ▶ 대댓글 버튼
		        	commentsHTML +=   "<img src='images/etc/reply.png' id='comm_reply' class='comm_icon' width='20' " ;
		        	commentsHTML +=   "onclick='repCommentOpen("+allComments[i].ano_comment_num+")' >";
		        	
		        	}		        	
		        	// ▶ 내용
		        	commentsHTML +=   "<div class='comment_author'>" ;
		        	commentsHTML +=   "<span>"+allComments[i].ano_comment_content+"</span>";
		        	
		        	// ▶ 댓글 리스트 영역 끝 
		        	commentsHTML +=   "</div>  </div>  </div>" ;
		        	
		        	// [대댓글 작성form, 댓글수정 form 영역 시작] 
		        	// ▶ 대댓글 작성form (replyCommFR)
		        	//commentsHTML +=   "<form method='post' style='display: none;' id='replyCommFR"+allComments[i].ano_comment_num+"'>" ;
		        	commentsHTML +=     "<div class='form-group mb-8' style='display: none;' id='replyCommFR"+allComments[i].ano_comment_num+"' >";
		        	
		        	// ▶ 대댓글 작성form 중 ref,lev,seq 등 대댓글을 위한 hidden영역
		        	commentsHTML +=      "<input type='hidden' name='ano_re_ref' value='"+allComments[i].ano_re_ref+"'>";
		        	commentsHTML +=      "<input type='hidden' name='ano_re_lev' value='"+allComments[i].ano_re_lev+"'>";
		        	commentsHTML +=      "<input type='hidden' name='ano_re_seq' value='"+allComments[i].ano_re_seq+"'>";
		        	
		        	// ▶ 대댓글 작성form 중 textarea
		        	commentsHTML +=      "<textarea name='reply_content' class='form-control replytxtarea' ";
		        	commentsHTML +=       "id='reply_content"+allComments[i].ano_comment_num+"' placeholder='내용을 입력해주세요.'></textarea>";
		        	commentsHTML +=      "<button class='comments_write_button comm_btn replytxtbtn' type='button' ";
		        	commentsHTML +=       "onclick='reply_comment("+allComments[i].ano_comment_num+")'>댓글달기 </button> </div>";
		        		             // "</form>";

		        	//--------------------------------------------------------------------------------------------------------	              
		        		              
		        		              
		        	// ▶ 댓글 수정form (replyCommFR)
		        	//commentsHTML +=   "<form method='post' style='display: none;' id='updateCommFR"+allComments[i].ano_comment_num+"'>" ;
		        	commentsHTML +=     "<div class='form-group mb-8' style='display: none;' id='updateCommFR"+allComments[i].ano_comment_num+"' >";
		        	
		        	// ▶ 댓글 수정form 중 textarea
		        	commentsHTML +=      "<textarea name='ano_comment_content' class='form-control replytxtarea' ";
		        	commentsHTML +=       "id='update_content"+allComments[i].ano_comment_num+"' placeholder='내용을 입력해주세요.'></textarea>";
		        	commentsHTML +=      "<button class='comments_write_button comm_btn replytxtbtn' type='button' ";
		        	commentsHTML +=       "onclick='update_comment("+allComments[i].ano_comment_num+")'>댓글수정하기 </button> </div>";
		        		              //"</form>";
		          		
		        	// ▶ li 영역 끝
		        	commentsHTML += "</li>  <hr>";
		        		
		        	}//if 
		        	
		        	$(".comments_list").append(commentsHTML); // <ul class="comments_list">
	        		$(".cmCount").append(allComments.length); // 댓글 총 개수

	            
	        },
	        error:function(request,status,error){
	        	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		            console.log(status);
	       }
	        
	    });
	}	
	
	
	
//---[6] [수정버튼(연필아이콘)과 대댓글버튼(말풍선아이콘)이 공유하는 메소드]----------------------------------------------------------------------------------------------------------------
	// - 클릭시 숨겨진 각각의 form창 open
	function repCommentOpen(ano_comment_num) {
		if( $("#session_memEmail").val() == ""){
			alert("로그인이 필요한 서비스 입니다.");
			location.href="./MemberLogin.me";
		}else{
			$("#replyCommFR"+ano_comment_num).toggle();
		}
	}
	
	function upCommentOpen(ano_comment_num) {
			$("#updateCommFR"+ano_comment_num).toggle();
		
	}


//----------[신고하기]---------------------------------------------------------------------------------------------------------------------------

	// [1] 모달창 열기 함수

	// 세션영역의 아이디 값을 변수에 저장 
	var loginSession = document.getElementById("hidden_email").value;
	
	function openReport() {
	// 미 로그인 시
		if(loginSession == ""){
			alert("로그인 후에 이용가능한 서비스입니다.");
			location.href="./MemberLogin.me";
			return;
			
	// 로그인시 '신고하기'버튼에 모달창이 열리는 클래스 속성 부여
		}else {document.getElementById("reportBtn").setAttribute("data-target", "#modal_report");}
		
	}//openReport()

	
	// [라디오 버튼 선택시 Ajax로 Action페이지 이동]
	function reportFunc(num, event) {
		
	    $.ajax({
	        type: "POST",
	        url : "./ReportAnonyBoardAction.anob",
	        data: { 
	        		ano_board_num : num,
	        		ano_board_reporter : $("#session_memEmail").val(),
	        		ano_board_reason : $("input:radio[name='reason4report']:checked").val()
	        },
	        success : function(data){
	               //alert("ajax로 ReportAnonyBoardAction.anob에 값 보내기 성공"+data);
	               // 값이 1이면 정상접수 , 0이면 실패
	               if(data == 1){
	            	   alert("신고 접수가 정상적으로 완료되었습니다.");
	            	   location.href='./AnonyBoardListAction.anob';
	               }else{
	            	   alert("신고 접수가 완료되지 않았습니다. 다시 시도해 주세요.");
	            	   history.go(-1);
	               }
	        },
	        error:function(request,status,error){
	            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	            console.log(status);
	       }
	        
	    });
		
	}//reportFunc(num, event)
		
	
	
	
	
	
	
	

</script>

<%-------------------------------------------------------- [스크립트 링크 영역]  --------------------------------------------------------------------------%>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="js/blog_single.js"></script>
</body>
</html>