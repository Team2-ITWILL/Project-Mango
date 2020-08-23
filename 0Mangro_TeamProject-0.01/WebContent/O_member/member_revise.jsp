<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


<style type="text/css">
	input {height: 50px;}
	.btn-primary {color:#fff !important;background-color: #000 !important;border-color: #000 !important;cursor: pointer !important;}
	.btn-primary:hover {background-color: #6610f2 !important;border-color: #6610f2 !important;}
</style> 



</head>
<body>

		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h4 class="section_title">회원정보 수정</h4>


      <!-------------------------------------------- [form태그 시작] -------------------------------------------------------->
			      <form class="member_reFr" action="" method="post" enctype="multipart/form-data">
				      
      					<!-- 파일 선택 후 첨부하면 바뀐 이미지가 rounded-circle안에 미리보기로 가능하도록 구현 -->
						  <img src="images/user_profile/jadu_prifile.jpg" alt="user" class="rounded-circle">
						  
					      <div class="js-form-message form-group">
							        	<label class="form-label" for="anony_file"><span>프로필사진</span></label>
						              	<div class="form-group files">
						                	<input type="file" class="form-control color file"  multiple="">
							          		<button type="button" class="hideBtn" onchange="changeValue(this)">사진변경하기</button>
						              	</div>								
					      </div>


					      <div class="js-form-message form-group">
						        <label class="form-label" for="">이름</label>
						        <input type="text" class="form-control" name="" id="" value="최자두"
						               data-msg="이름을 입력해주세요."
						               data-error-class="form-error"
						               data-success-class="form-success">
						        
					      </div>
					      
					      <div class="js-form-message form-group">
						        <label class="form-label" for="">이메일</label>
						        <input type="email" class="form-control" name="" id="" value="user1@naver.com"
						               data-msg="이메일을 입력해주세요."
						               data-error-class="form-error"
						               data-success-class="form-success">
						        
					      </div>
					      
					      <div class="js-form-message form-group">
						        <label class="form-label" for="">
						          <span class="d-flex justify-content-between align-items-center">비밀번호</span>
						        </label>
						        
						        
						        <input type="password" class="form-control" name="" id="" 
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