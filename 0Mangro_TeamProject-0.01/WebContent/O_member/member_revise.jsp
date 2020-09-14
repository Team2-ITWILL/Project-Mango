<%@page import="mango.member.db.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mango.member.db.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/member_revise.css">
<link rel="stylesheet" type="text/css" href="styles/academy_single_responsive.css">

<!------------------------------------------ [ 제이쿼리 ] --------------------------------------------------------------->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript" src="js/bootstrap-filestyle.min.js"> </script>

<style type="text/css">
	input {height: 50px;}
	.btn-primary {color:#fff !important;background-color: #000 !important;border-color: #000 !important;cursor: pointer !important;}
	.btn-primary:hover {background-color: #6610f2 !important;border-color: #6610f2 !important;}
</style> 



</head>
<%
// <------------------ 로그인 세션 값 여부 ---------------------->
	String email = (String)session.getAttribute("id_email");
	if(email == null){
		response.setContentType("text/html; charset=utf-8");
		out.print("<script>");
		out.print("window.alert('로그인 시 사용 가능한 페이지입니다.');");
		out.print("location.href='./MemberLogin.me';");
		out.print("</script>");
	}
// <------------------ 로그인 세션 값 여부 ---------------------->
%>
<body>
<% 	
// <------------------ 회원정보 + 프로필 가져오기 ----------------------->	
	MemberDAO mdao = new MemberDAO();
	String name = mdao.selectMember(email);
	String profileImg1 = mdao.getProfileImg(email);
	if(profileImg1 == null){
		profileImg1 = "./images/etc/default_mango.png";
	}
// <------------------ 회원정보 + 프로필 가져오기 ----------------------->	
%>	


<script type="text/javascript">
// <----------------- 회원 정보 수정 필수 입력 -------------------->

	$(function update_chk(){
		
		var regPwd = RegExp(/^[a-zA-Z0-9]{8,20}$/); // 비밀번호
		
		$("#update_chk").submit(function(){
			
			if($("#id_pwd").val() == ""){
				alert("현재 비밀번호를 입력하세요.");
				$("#id_pwd").focus;
				return false;
			}
			
			if($("#newPw1").val() == ""){
				alert("변경할 비밀번호를 입력하세요.");
				$("#newPw1").focus;
				return false;
			}
			
			if($("#newPw2").val() == ""){
				alert("변경할 비밀번호 입력하세요.");
				$("#newPw2").focus;
				return false;
			}
			
			// 변경할 비밀번호 유효성 체크
			if( !(regPwd.test( $("#newPw1").val() )) ){
				alert("8~20자 영문 대소문자, 숫자를 입력해 주세요.");
				$("#newPw1").focus();
				return false;
			}
			
			if($("#newPw2").val() != $("#newPw1").val() ){
				alert("비밀번호가 일치하지 않습니다.");
				$("#newPw2").focus();
				return false;
			}
			
			if($("#id_pwd").val() == $("#newPw1").val()){
				alert("이전 비밀번호와 동일하게 변경할 수 없습니다.");
				$("#newPw1").focus;
				return false;
			}
			
		}); // submit() 끝
	}); // update_chk() 끝
	
// <----------------- 회원 정보 수정 필수 입력 -------------------->
	
	
	
// <----------------- 회원 정보 프로필 수정  --------------------->

/* 	window.onload = function(){
	
	var imgTag = document.querySelector(".rounded-circle");
	var imgPath = '${profileImg}';
	console.log(imgPath);
	
		if(imgPath == null || imgPath == ''){
			imgTag.src = "./images/user_profile/jadu_prifile.jpg";
		}else{
			imgTag.src = './' + imgPath;
		}

	}
	 */
	
	
	/* 변경하기 버튼 파일 선택 버튼으로 변경 */
	$(document).ready(function(){
		var hideBtn = document.querySelector(".rounded-circle");
		var fileBtn = document.querySelector("#file_img");
		var submitBtn = document.querySelector(".hideBtn");
		
		hideBtn.onclick = function(){
			fileBtn.click();		
		}
		
		fileBtn.onchange = function(){
			setThumbnail(this);
			
			var fileInfo = fileBtn.files[0];
			console.log(fileBtn);
			console.log(fileBtn.name);
			console.log(fileInfo);
		}			
		
		submitBtn.onclick = function(){				
			
			var form = document.querySelector(".member_reFr");			
			form.action = "./MemberProfileAction.me";				
			form.submit();	
		} 		
		
	}); // .ready() 끝

	
	
	/* 사진 선택 시 미리보기 */
 	function setThumbnail(fileBtn){

		var fileInfo = fileBtn.files[0];
		var reader = new FileReader();			
		
		reader.onload = function(){
			document.querySelector(".rounded-circle").src = reader.result;
		}
		
		if(fileInfo){
			reader.readAsDataURL(fileInfo);
		}	
	
	} // setThumbnail() 끝
	
	
	
	/* 사진 업로드 */
	function uploadFile(fileTag, filePath) {

		var formData = new FormData();
		formData.append("file", fileTag.files[0]);

		console.log('fileTag.files[0] : ' + fileTag.files[0]);
		console.log('fileTag : ' + fileTag);

		$.ajax({
				data : formData,
				type : "POST",
				url : "./MemberProfileAction.me",
				contentType : false,
				processData : false,
				enctype : 'multipart/form-data',
				success : function(data) {
					filePath.value = data;
					
					// 확인용 출력문
					console.log(filePath.value);							
					console.log('data : ' + data);
				}
		}); // $.ajax 끝
		
	} // uploadFile() 끝 

// <----------------- 회원 정보 프로필 수정 ---------------------->
</script>







		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h4 class="section_title">회원정보 수정</h4>


      <!-------------------------------------------- [form태그 시작] -------------------------------------------------------->
			      <form class="member_reFr" action="./MemberUpdateAction.me" method="post" enctype="multipart/form-data" id="update_chk" onsubmit="update_chk()">

			      
      					<!-- 파일 선택 후 첨부하면 바뀐 이미지가 rounded-circle안에 미리보기로 가능하도록 구현 -->
						  <img src="<%=profileImg1%>" alt="user" class="rounded-circle" >
						  
					      <div class="js-form-message form-group">
							        	<label class="form-label" for="anony_file"><span>프로필사진</span></label>
						              	<div class="form-group files">
						                	<input type="file" 
						                		   class="form-control color file" 
						                		   id="file_img" 
						                		   name="file_img" 
						                		   multiple=""
						                	>
						                	<input type="hidden" name="mem_profileImg" id="mem_profileImg">
							          		<button type="button" class="hideBtn" onclick="profileck()">사진변경하기</button>
						              	</div>								
					      </div>


					      <div class="js-form-message form-group">
						        <label class="form-label" for="">이름</label>
						        <input type="text" class="form-control" name="memName" id="id_name" value="<%=name%>"
						               data-msg="이름을 입력해주세요."
						               data-error-class="form-error"
						               data-success-class="form-success"
						               readonly="readonly">
						        
					      </div>
					      
					      <div class="js-form-message form-group">
						        <label class="form-label" for="">이메일</label>
						        <input type="email" class="form-control" name="memEmail" id="id_email" value="${sessionScope.id_email}"
						               readonly="readonly"
						               data-msg="이메일을 입력해주세요."
						               data-error-class="form-error"
						               data-success-class="form-success">
						        
					      </div>
					      
					      <div class="js-form-message form-group">
						        <label class="form-label" for="">
						          <span class="d-flex justify-content-between align-items-center">현재 비밀번호</span>
						        </label>
						        
						        
						        <input type="password" class="form-control" name="memPwd" id="id_pwd" 
						        	   placeholder="********"
						               aria-label="********" 
						               data-msg="올바른 비밀번호를 입력해주세요."
						               data-error-class="form-error"
						               data-success-class="form-success">
					      </div>
					      
					      <div class="js-form-message form-group">
						        <label class="form-label" for="">
						          <span class="d-flex justify-content-between align-items-center">변경할 비밀번호</span>
						        </label>
						        
						        
						        <input type="password" class="form-control" name="newPw1" id="newPw1" 
						        	   placeholder="********"
						               aria-label="********" 
						               data-msg="올바른 비밀번호를 입력해주세요."
						               data-error-class="form-error"
						               data-success-class="form-success">
					      </div>
					      
					      <div class="js-form-message form-group">
						        <label class="form-label" for="">
						          <span class="d-flex justify-content-between align-items-center">변경할 비밀번호 확인</span>
						        </label>
						        
						        
						        <input type="password" class="form-control" name="newPw2" id="newPw2" 
						        	   placeholder="********"
						               aria-label="********" 
						               data-msg="올바른 비밀번호를 입력해주세요."
						               data-error-class="form-error"
						               data-success-class="form-success">
					      </div>
					      
					      
					
					      <div class="row align-items-center mb-5" style="float:right;">
					        <div class="col-5 text-right">
					          <button type="submit" class="btn btn-primary">저장하기</button>
					        </div>
					      </div>
					      
			      </form>
      <!-------------------------------------------- [form태그 끝] -------------------------------------------------------->
				</div>




				</div> <!-- class="col" -->
			</div> <!-- class="row" -->
		</div> <!-- class="container" -->


</body>
</html>