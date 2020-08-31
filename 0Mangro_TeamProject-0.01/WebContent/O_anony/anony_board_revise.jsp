<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>익명사담방 글쓰기</title>
<!-- 메타데이터  -->
<meta name="description" content="Mango project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 제이쿼리  -->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<!-- 링크목록  -->
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/form_basic_page.css">
<link rel="stylesheet" type="text/css" href="styles/academy_single_responsive.css">

<!------------------------------- [스타일 시트]------------------------------------------------------------------>
<style type="text/css">
	.files input {
	    outline: 5px dashed #f5f5f5;
	    outline-offset: -10px;
	    -webkit-transition: outline-offset .15s ease-in-out, background-color .15s linear;
	    transition: outline-offset .15s ease-in-out, background-color .15s linear;
	    padding: 120px 0px 85px 35%;
	    text-align: center !important;
	    margin: 0;
	    width: 100% !important;
	    color:#fff;
	}
	.files input:focus{     outline: 2px dashed #92b0b3;  outline-offset: -10px;
	    -webkit-transition: outline-offset .15s ease-in-out, background-color .15s linear;
	    transition: outline-offset .15s ease-in-out, background-color .15s linear; border:1px solid #92b0b3;
	 }
	.files{ position:relative}
	.files:after {  pointer-events: none;
	    position: absolute;
	    top: 60px;
	    left: 0;
	    width: 50px;
	    right: 0;
	    height: 56px;
	    content: "";
	    background-image: url('images/etc/dragfile.png');
	    display: block;
	    margin: 0 auto;
	    background-size: 100%;
	    background-repeat: no-repeat;
	}
	.color input{ background-color:#f0f8ff;}
	
	.files:before {
	    position: absolute;
	    bottom: 10px;
	    left: 0;  pointer-events: none;
	    width: 100%;
	    right: 0;
	    height: 57px;
	    content: "드래그 또는 버튼을 통해 파일을 업로드 해보세요.";
	    display: block;
	    margin: 0 auto;
	    color: #000;
	    font-weight: 600;
	    text-transform: capitalize;
	    text-align: center;
	}


</style>

</head>
<body>

		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h4 class="section_title">익명사담방 글 수정하기</h4>
							<br>
<!-------------------------------------------------------- [글쓰기 영역 (form)] ----------------------------------------------------------->
					      <form action="./AnoBoardUpdateAction.anob?ano_board_num=${anbean.ano_board_num }"  class="js-validate w-md-75 w-lg-50 mx-md-auto mb-11" method="post" enctype="multipart/form-data">
					      
					        <%-- 1.세션에 있는 멤버email계정  ---%>
					        <input type="hidden" class="form-control" name="mem_email" id="anony_title" value="${id_email}">
					        <input type="hidden" class="form-control" name="ano_board_num" id="ano_num" value="${anbean.ano_board_num }">
      
						      <div class="js-form-message form-group">
							        <div class="form-group mb-8">
							        <%-- 2.닉네임 ---%>
								        <input type="hidden" class="form-control" name="ano_board_nick" id="anony_board_nick" value="${nick}"> 
								    </div>
								    
								    <%-- ----------------------------------------------------%>
								    
							        <div class="form-group mb-8">
							        <%-- 3.제목 ---%>
								        <label class="form-label" for="anony_title">제목</label>
								        <input type="text" class="form-control" name="ano_board_title" id="anony_title" 
								        	   value="${anbean.ano_board_title }"> 
								    </div>
								    
							        <%-- 4.본문 ---%>
							        <div class="form-group mb-8">
							        	<label class="form-label" for="anony_content">본문</label>
										<textarea name="ano_board_content" class="form-control" data-msg="내용을 입력해주세요." 
										          rows="10" required id="id_text">${anbean.ano_board_content}</textarea>
		       						</div>
				       							 
							        <%-- 5.파일 ---%>
							        	<label class="form-label" for="anony_file">파일업로드</label>
						              	<div class="form-group files">
						                	<input type="file" name="ano_board_file" class="form-control color file" accept="image/*,.pdf" 
						                	       id="anony_file">
							          		<button type="button" class="hideBtn" onchange="changeValue(this)">첨부파일</button>
							         
						              	</div>
		       							 
							        <div class="textwriteBtn">
							          <button type="submit" class="btn btn-write">수정하기</button>
							        </div>
						      </div>
					      </form>
<!-------------------------------------------------------- [글쓰기 영역(form) 끝] ----------------------------------------------------------->
				    </div> <!-- section_title_container text-center -->
				</div> <!-- class="col" -->
			</div> <!-- class="row" -->
		</div> <!-- class="container" -->

<!------------------------------------------------------- [스크립트 영역] -------------------------------------------->

<script type="text/javascript">

	// [input type='file' 버튼 숨기기]
	$(function () {
		$('.hideBtn').click(function (e) {
			$('.file').click();
		});
	});
	
	function changeValue(obj){
	
	    alert(obj.value);
	
	} 

</script>



</body>
</html>