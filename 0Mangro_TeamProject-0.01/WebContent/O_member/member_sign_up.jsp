<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>망고 - 회원가입</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<!-- <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css"> -->
<link rel="stylesheet" type="text/css" href="styles/form_basic_page.css">
<link rel="stylesheet" type="text/css" href="styles/academy_single_responsive.css">


<style type="text/css">
	input {height: 50px;}
	.btn-primary {color:#fff !important;background-color: #000 !important;border-color: #000 !important;cursor: pointer !important;}
	.btn-primary:hover {background-color: #6610f2 !important;}
	#yackuan-check {margin-left: -25px; z-index: 1 ; opacity: 1;}
	.right-btn {margin-left: 500px;width: 100px;}
</style>


</head>
<body>
<script type="text/javascript">

	<!------- [회원가입 필수 입력란 확인] --------->
	$(function check() {
		
		$("#join").submit(function() {
				
			// 이름
			if($("#id_name").val() == ""){
				alert("이름을 입력하세요.");
				$("#id_name").focus();
				return false;
			}
			
			// 이메일
			if($("#id_email").val() == ""){
				alert("이메일을 입력하세요.");
				$("#id_email").focus();
				return false;
			}
			
			// 인증번호
			if($("#emailcheck").val == ""){
				alert("인증번호를 확인하세요.");
				$("#emailcheck").focus();
				return false;
			}
			
			// 비밀번호
			if($("#id_password1").val() == ""){
				alert("비밀번호를 입력하세요.");
				$("#id_password1").focus();
				return false;
			}
		
			// 비밀번호 일치 확인
			if($("#id_password1").val() != $("#id_password2").val()){
				alert("비밀번호를 동일하게 입력하세요.");
				$("#id_password1").focus();
				return false;
			}
			
			// 이용약관 체크박스
			if(!($("#yackuan-check").is(":checked")) ){
				alert("이용 약관에 동의해주세요.")
				$("#yackuan-check").focus();
				return false;
			}
	
		}); // submit() 끝	
			
	}); // check() 끝
		
</script>


		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h4 class="section_title">회원가입</h4>
						
						
      <!-------------------------------------------- [form태그 시작] -------------------------------------------------------->
					      <form class="sign_upClass" action="./MemberJoinAction.me" method="post" id="join" onsubmit="check()">
					      
					      <div class="mb-5 mt-2">
					        <p>아래 3개 필수 데이터를 모두 입력해주세요.</p>
					      </div>
					      <div class="social_signup">네이버로 가입하기</div> <br>
					
      
      <!-------------------------------------------- [이름, 이메일, 비밀번호 입력창] -------------------------------------------->
      <!-- class가 form-control일 때 클래스 속성을 하나 더 주어서 입력오류 알림(자바스크립트로 조건에 따라 동적으로 제어하면 됨)
		      	class="form-control is-valid" ===> 정확하게 입력함, 초록색 테두리로 변화, 가입하기 가능
		      	class="form-control is-invalid" ===> 부정확하게 입력함, 붉은색 테두리로 변화, 가입하기 불가
		      	class="form-control" ===> 입력하기 전, 클릭시 파란색 테두리로 표시
		      	
		      	input 바로 아래에 경고문구 "이름을 입력해 주세요" 등 나타나게 하려면
		      	https://www.it-swarm.dev/ko/twitter-bootstrap/%EB%B6%80%ED%8A%B8-%EC%8A%A4%ED%8A%B8%EB%9E%A9%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC-%EC%96%91%EC%8B%9D%EC%97%90-%EC%98%A4%EB%A5%98-%ED%91%9C%EC%8B%9C/1071638209/
		      	링크참고
		      	 											   -->
					      
					      <!-- 이름 -->
					      <div class="form-group">
						        <label class="form-label" for="id_name">이름</label>
						        <input type="text" class="form-control is-valid" name="" id="id_name" placeholder="이름" aria-label="Email address"
						               required
						               data-msg="이름을 입력해주세요."
						               data-error-class="form-error"
						               data-success-class="form-success">
					        
					      </div>
					      
					      <!-- 이메일 -->
					      <div class="js-form-message form-group">
						        <label class="form-label" for="id_email">이메일</label>
						        <input type="email" class="form-control is-invalid" name="" id="id_email" placeholder="이메일" 
						               data-msg="이메일을 입력해주세요."
						               data-error-class="form-error"
						               data-success-class="form-success"> 
						        <button type="button" class="btn btn-primary right-btn" onclick="">전송</button>
					      </div>
					               
					        
					      
					      <!-- 인증번호 버튼 -->
					      <div class="js-form-message form-group">
						        <label class="form-label" for="id_password1">
						          <span class="d-flex justify-content-between align-items-center">인증번호</span>
						        </label>
						        <input type="text" class="form-control" name="" id="emailcheck" placeholder="인증번호 입력"
						               aria-label="인증번호 입력" required
						               data-msg="올바른 비밀번호를 입력해주세요."
						               data-error-class="form-error"
						               data-success-class="form-success">
						        <button type="button" class="btn btn-primary right-btn">확인</button>
					      </div>
					      
						  
					      
					      <!-- 비밀번호 입력 & 비밀번호 확인 -->
					      <div class="js-form-message form-group">
					        <label class="form-label" for="id_password1">
					          <span class="d-flex justify-content-between align-items-center">비밀번호</span>
					        </label>
					        
					        <input type="password" class="form-control" name="" id="id_password1" placeholder="********"
					               aria-label="********" required
					               data-msg="올바른 비밀번호를 입력해주세요."
					               data-error-class="form-error"
					               data-success-class="form-success">
					               
					      <div class="js-form-message form-group">
					        <label class="form-label" for="id_password1">
					          <span class="d-flex justify-content-between align-items-center">비밀번호 확인</span>
					        </label>
					        
					        <input type="password" class="form-control" name="" id="id_password2" placeholder="********"
					               aria-label="********" required
					               data-msg="비밀번호가 일치하지 않습니다."
					               data-error-class="form-error"
					               data-success-class="form-success">
					      </div>
					        
					      <div class="mb-6">
					        <div class="js-form-message">
					          <div class="custom-control custom-checkbox d-flex align-items-center text-muted">
					            <input type="checkbox" class="custom-control-input" id="yackuan-check" name="termsCheckbox" required
					                   data-msg="이용약관, 개인정보 취급방침에 동의해주세요"
					                   data-error-class="form-error"
					                   data-success-class="form-success">
					            <label class="font-subhead custom-control-label" for="termsCheckbox">
					            
					              <p class="m-0">
					                <a class="yackuan" href="#" target="_blank">이용약관</a> 및
					                <a class="gaein" href="#" target="_blank">개인정보취급방침</a>에 동의합니다.
					              </p>
					            </label>
					          </div>
					        </div>
					        <p class="guango">* 본 약관에는 광고성 정보 수신동의가 포함되어있습니다.</p> <br>
					      </div>
					
					      <div class="row align-items-center mb-5">
					        <div class="col-7">
					          <span class="font-subhead text-muted mb-2">이미 계정이 있으신가요?</span>
					          	<a href="4index.jsp?center=O_member/member_sign_in.jsp">로그인</a>
					        </div> 
					        <div class="col-5 text-right">
					          <input type="submit" class="btn btn-primary" value="가입">
					        </div>
					
					      </div>
					      </form>
      <!-------------------------------------------- [form태그 끝] -------------------------------------------------------->
				    </div> <!-- section_title_container text-center -->




				</div> <!-- col -->
			</div> <!-- row -->
		</div> <!-- container -->

</body>
</html>