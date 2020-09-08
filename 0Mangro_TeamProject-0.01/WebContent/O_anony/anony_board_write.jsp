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
	.dragArea input {
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
	.dragArea input:focus{     outline: 2px dashed #92b0b3;  outline-offset: -10px;
	    -webkit-transition: outline-offset .15s ease-in-out, background-color .15s linear;
	    transition: outline-offset .15s ease-in-out, background-color .15s linear; border:1px solid #92b0b3;
	 }
	.dragArea{ position:relative}
	.dragArea:after {  pointer-events: none;
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
	
	.dragArea:before {
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
						<h4 class="section_title">익명사담방 글쓰기</h4>
							<br>
<!-------------------------------------------------------- [글쓰기 영역 (form)] ----------------------------------------------------------->
					      <form action="./AnoBoardInsertAction.anob" name="writeAnoFR" class="js-validate w-md-75 w-lg-50 mx-md-auto mb-11" method="post" enctype="multipart/form-data">
					      
					         <%-- 1.세션에 있는 멤버email계정  ---%>
					        <input type="hidden" class="form-control" name="mem_email" id="anony_email" value="${id_email}">
      
						      <div class="js-form-message form-group">
							        <div class="form-group mb-8">
							        
					         <%-- 2.닉네임 ---%>
								        <input type="hidden" class="form-control" name="ano_board_nick" id="anony_board_nick" value="${nick}"> 
								    </div>
								    
								    
								    <%-- ----------------------------------------------------%>
								    
							        <div class="form-group mb-8">
					         <%-- 3.제목 ---%>
								        <label class="form-label" for="anony_title">제목</label>
								        <input type="text" class="form-control" name="ano_board_title" id="anony_title" placeholder="제목을 입력해 주세요.(30자 이내)" > 
								    </div>
								    
					         <%-- 4.본문 ---%>
							        <div class="form-group mb-8">
							        	<label class="form-label" for="anony_content">본문</label>
										<textarea name="ano_board_content" class="form-control" id="anony_content" placeholder="내용을 입력해주세요." rows="10" id="id_text"></textarea>
		       						</div>
				       							 
					         <%-- 5.파일 ---%>
							        	<label class="form-label" for="anony_file">파일업로드</label>
						              	<div class="form-group dragArea" id="dragArea">
						                	<input type="file" name="ano_board_file" class="form-control color file" 
						                		   accept="image/jpg, image/jpeg, image/gif, image/png, image/bmp" 
						                		   id="anony_file" onchange="changeValue(obj)">
							          		<button type="button" class="hideBtn" style="z-index: 99;" onclick="hideBtnClick();">
							          			첨부파일
							          		</button>
							         

						              	</div>
		       							 
							        <div class="textwriteBtn">
							          <button type="button" class="btn btn-write" onclick="submitCheck();">글쓰기</button>
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


	// [hideBtn을 클릭했을 떄 input type='file' 클릭된 효과 ]
	function hideBtnClick() {
		$('#anony_file').click();
		
	}
	
 	// 변경된 값 감지 후 alert
	function changeValue(obj){
	
	    alert(obj.value);
	
	} 

	
	//---- 클래스명이 dragArea인 영역에 drag&drop이벤트 발생 시 
	//     실행될 사용자 정의 함수를 바인딩 
	
	
	$('.dragArea')
	.on('dragover', dragOver) // dragover이벤트시 dragFile()메소드 실행
	.on('dragleave', dragOver);
	 // dragover이벤트시 dragFile()메소드 실행
	 // drop(파일을 드래그 해서 놓기)이벤트시 fileUP()메소드 실행	 
	
	// dragover와 dragleave 이벤트를 하나의 function()에 묶기
	// dragOver함수 중 이벤트가 drop일 경우 드래그된 첨부파일이 자동으로 file로 바인딩
	function dragOver(e) {
		e.stopPropagation();  
		e.preventDefault(); 			

		// 발생한 이벤트의 종류 : dragover
		if (e.type == "dragover") {
			// 이벤트의 타겟(input type='file' 태그)
			$(e.target).css({
				"background-color" : "aliceblue",
				"outline-offset" : "-20px"
			});
			//console.log(e.target.id);
			//alert(e.target.id +"드래그!");	
			
			//console.log(e.target.id);
			//alert(e.target +"드래그!");	
			
		
		} else {
			$(e.target).removeAttr("style");
			//alert("드랍되었음"+e.target.value);
		}
	}// dragOver

	
	// [제목, 내용 입력여부 및 각 30자, 500자가 넘은 상태로 글쓰기 버튼 클릭 시 작성한 제목을 일정 문자열 개수만 남기고 지우는 함수]
	function submitCheck() {
		// 남길  제목 문자열 30자
		var titleLimit = document.getElementById("anony_title").value.substring(0,30);
		// 남길  제목 문자열 30자
		var contentLimit = document.getElementById("anony_content").value.substring(0,500);
		
		
		// [제목 30자 이상 삭제]
		if(document.getElementById("anony_title").value.length <= 0 ){
			alert("제목을 입력해 주세요.");
			document.getElementById("anony_title").focus();
			return;
		}
		
		if(document.getElementById("anony_title").value.length > 30){
			alert("제목은 30자 이하로 작성해 주세요.");
			document.getElementById("anony_title").value = titleLimit;
			return;
			
		}
		
		// [내용 500자 이상 삭제]
		if(document.getElementById("anony_content").value.length <= 0 ){
			alert("내용을 입력해 주세요.");
			document.getElementById("anony_content").focus();
			return;
		}
		
		if(document.getElementById("anony_content").value.length > 500) {
			alert("내용은 500자 이하로 작성해 주세요.");
			document.getElementById("anony_content").value = contentLimit;
			return;
		}
		
		
		
		// [업로드 파일 검증]
		
		// - 업로드 된 파일명
 		var anony_file = document.getElementById("anony_file").value;	
		
		// - 업로드 된 파일의 확장자를 찾기위해 "."의 다음 인덱스를 찾기
	 	var dotIndex = document.getElementById("anony_file").value.indexOf(".")+1; // 자르기 용도
	 	
		// - 파일확장자를 소문자로 저장
	 	var fileType = anony_file.substring(dotIndex).toLowerCase();
	 	var fileTypeArr = new Array('jpg', 'gif', 'png', 'jpeg', 'bmp');
			
		//var uploadedFiles = e.originalEvent.dataTransfer.files;
			
			// 업로드 하려는 파일이 있을  때(1개만 허용)
			if(anony_file.length > 0) {
				
				// 업로드 할 파일이 이미지 확장자 배열안에 없는 확장자를 가졌다면
				//  (즉, 허용된 이미지 파일이 아니라면)
				if(fileTypeArr.indexOf(fileType) == -1 ) {
					alert("1개 이내의 이미지 파일(jpg, jpeg, gif, png, bmp)만 업로드 가능합니다.");
					anony_file = "";
					return;
				}
					
			}	 	
		

		
		// 모든조건 충족시 form submit 
		writeAnoFR.submit();
		

	}// submitCheck()	
	
</script>



</body>
</html>