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
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/form_basic_page.css">
<link rel="stylesheet" type="text/css" href="styles/academy_single_responsive.css">


<style type="text/css">
	.btn-primary {color:#6610f2 !important;border-color: #6610f2 !important;background-color: #fff !important;cursor: pointer !important;}
	.btn-primary:hover {color:#fff !important;background-color: #6610f2 !important;}
	#yackuan-check {margin-left: -25px; z-index: 1; opacity: 1;}
</style> 



</head>

<script type="text/javascript">
/* ----------------------------------- 이메일 입력 확인 ------------------------------- */
	$(function inputchk(){
	
		$("findPw").submit(function(){	
		
			if($("#id_email").val() == ""){
				alert("이메일을 입력하세요.");
				$("#id_email").focus();
				return false;
			}

		}); // submit 끝
		
	}); // inputchk() 끝
/* ----------------------------------- 이메일 입력 확인 ------------------------------- */
</script>


<body>

		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h4 class="section_title">비밀번호 찾기</h4>
      
					      <form class="sign_upClass" action="./MemberFindPwAction.me" method="post">
					      
					      <div class="mb-5 mt-2">
					        <p>가입 시 입력하신 이메일 주소로 비밀번호 재설정 메일이 발송됩니다. <br>메일을 입력 후 전송버튼을 클릭하시고 메일을 확인해주세요.</p>
					      </div>
					      
					      <div class="js-form-message form-group">
					        <label class="form-label" for="id_email">이메일</label>
					        <input type="email" class="form-control" name="id_email" id="id_email" placeholder="이메일" 
					               required
					               data-msg="이메일을 입력해주세요."
					               data-error-class="form-error"
					               data-success-class="form-success">
					        
					      </div>
					
					
					      <div class="row align-items-center mb-5">
					        <div class="col-7">
					          <span class="font-subhead text-muted mb-2">기억나셨나요?</span>
					          	<a href="./MemberLogin.me">로그인</a>
					        </div> 
					        <div class="col-5 text-right">
					          <button type="submit" class="btn btn-primary">전송</button>
					        </div>
					
					      </div>
					      </form>
					    </div>


				</div> <!-- class="col" -->
			</div> <!-- class="row" -->
		</div> <!-- class="container" -->


</body>
</html>