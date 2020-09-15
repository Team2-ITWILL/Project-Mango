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

<!-- 제이쿼리 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.min.js" ></script>
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


	function checkBox(event){
		
		
		
		if($("#yackuan-check").is(":checked") == true){
			window.open('./O_member/member_terms_of_use.jsp', '회원가입 약관','width=700, height=700');	
		}
		
	}

//<--------------------------- 회원가입 필수 입력란 확인 ------------------------->
	
	$(function check() {

		var regMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/) // 이메일
		var regPwd = RegExp(/^[a-zA-Z0-9]{8,20}$/); // 비밀번호
		var regName = RegExp(/^[가-힣A-Za-z]{2,20}$/); // 이름
		
		$("#join").submit(function() {
				
			// 이름
			if($("#id_name").val() == ""){
				alert("이름을 입력하세요.");
				$("#id_name").focus();
				return false;
			}
			
			// 이름 유효성 검사
		    if ( !(regName.test( $("#id_name").val() )) ){
				alert("이름을 올바르게 입력하세요.");
		    	$("#id_name").focus();
		    	$("#id_name").val("");
		    	return false;
		    }
			
			// 이메일
			if($("#id_email").val() == ""){
				alert("이메일을 입력하세요.");
				$("#id_email").focus();
				return false;
			}
			
/* 			// 이메일 유효성 검사
		    if ( !(regMail.test( $("#id_email").val() )) ){
				alert("이메일 형식이 올바르지 않습니다.");
		    	$("#id_email").focus();
		    	$("#id_email").val("");
		    	return false;
		    }
 */
			// 비밀번호
			if($("#id_password1").val() == ""){
				alert("비밀번호를 입력하세요.");
				$("#id_password1").focus();
				return false;
			}
		
			// 비밀번호 유효성 체크
			if( !(regPwd.test( $("#id_password1").val() )) ){
				alert("8~20자 영문 대소문자, 숫자를 입력해 주세요.");
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
			
			// 인증 버튼 클릭여부 확인
			if(flag != true) {
		        alert("이메일 인증을 해주세요.");
				return false;
			}
			
			// 정확한 인증번호 입력여부 확인
			if( $("#fromIframe").val() != "success" ){
				alert("인증번호를 정확히 입력 후 인증버튼을 눌러주세요.");
				console.log($("#fromIframe").val());
				return false;
			}
			
		}); // submit() 끝	
			
	}); // check() 끝
	
//<--------------------------- 회원가입 필수 입력란 확인 끝 ------------------------->
	
	
	
//<--------------------------- 이메일 인증 번호 전송  ------------------------->	
	
	var flag = false;
	function emailCheck(){
		
		flag = true; // 전송버튼 클릭했는지 체크
		var email = $("#id_email").val(); 
		var urlVar = "./MemberMailAction.me?email="+$("#id_email").val();
		
		$("#authEmailSpan").removeAttr("style"); // 이메일 인증번호창 활성화 되기까지 대기시간 소요 알림문구 보이게
		$("#iframeHere").attr("src",urlVar); // iframe의 src를 이메일인증창 주소로 연결
		$("#iframeHere").removeAttr("style","display:none;"); // iframe의 숨김표시 해제
		
	}
	
//<--------------------------- 이메일 인증 번호 전송  ------------------------->	



//<--------------------------- 이메일 중복검사시 span태그를 지워주는 메소드  ----------------------------->	

	function clearCorrectTag() {
			$("#idcheckT").attr("style","display:none;");
			$("#idcheckF").attr("style","display:none;");
			$("#emailck").attr("style","display:none;");
			$("#pwdck").attr("style","display:none;");
	}//clearCorrectTag() 

//<--------------------------- 이메일 중복검사시 span태그를 지워주는 메소드  ----------------------------->	

	
	
//<--------------------------- 아이디 중복 확인  ----------------------------->	

	function duplCheck(event){
		
		var regMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/) // 이메일
		
		$.ajax({
				type: "post",
				url: "./MemberIDcheckAction.me",
				data: {email : $("#id_email").val()},
				dataType: "text",
				success: function(data, textStatus){

					if ( !(regMail.test( $("#id_email").val() )) ){
						clearCorrectTag();
						$("#emailck").val("이메일 형식에 맞게 입력하세요.").css("color", "#a64bf4");
						$("#emailck").removeAttr("style","display:none;");
				    	return false;
				    
					} else if( (regMail.test( $("#id_email").val() )) ) {
					
						// 1. 중복검사 결과 이미 가입된 계정일 때
						if(data == 1){
							
							// 이메일 input에 입력값이 없을 때는 span태그 지우기(backspace로 지웠을 때 계속 남아있는걸 방지)
							if($("#id_email").val() == 0){
								clearCorrectTag();
								
							// 이메일 input에 입력값이 있지만 기존에 입력된 idcheckT지우고 idcheckF만 표시되게하기
							}else if($("#idcheckT").val().length != 0){	
								clearCorrectTag();
								$("#idcheckF").val("이미 가입한 회원입니다.").css("color", "#a64bf4");
								//$("#idcheckF").val().css("color", "#a64bf4");
								$("#idcheckF").removeAttr("style","display:none;"); }
						
						// 2. 중복검사 결과 중복이 아닐 때
						}else{
							// 이메일 input에 입력값이 없을 때는 span태그 지우기(backspace로 지웠을 때 계속 남아있는걸 방지)
							if($("#id_email").val() == 0){
								clearCorrectTag();
							}else{
								// 중복된 이메일 계정을 입력 후 새로 입력하는 과정에서 backspace를 사용했을 때
								// 기존에 입력된 idcheckT와 backspace를 감지하고 새로 추가된 idcheckF가 일시적으로 공존되는걸
								// 방지하기 위해 clearCorrectTag()메소드 호출
								clearCorrectTag();
								$("#idcheckT").val("사용 가능한 이메일입니다.").css("color", "#a64bf4");
								//$("#idcheckT").val().css("color", "#a64bf4");
								//$("#id_email").attr("readonly", "readonly");
								$("#idcheckT").removeAttr("style","display:none;");
							
							} // 세번째 if문 끝
						} // 두번째 if문 끝
					} // 첫번째 if문 끝
				}, //success 끝
						
				error: function(data, datastatus){
					console.log("에러 : "+ data + datastatus);
				} // error 끝
			
		}); // $.ajax 끝
			
	} // duplCheck() 끝

//<--------------------------- 아이디 중복 확인  ----------------------------->	
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
	  
	  
	  <!-------------------------------------------- 네이버 아이디로 로그인 버튼 노출 영역  --------------------------------------------------------> 
					  <div id="naverIdLogin">네이버로 로그인하기</div> <br>
	  <!-------------------------------------------- 네이버 아이디로 로그인 버튼 노출 영역  -------------------------------------------------------->
					
					
  
	  <!-------------------------------------------- 네이버 아이디로 로그인 초기화 Script  -------------------------------------------->
	  <script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
	  
	  <script type="text/javascript">
		var naverLogin = new naver.LoginWithNaverId(
			{
				clientId: "rU2ooEzY2CNR72wYidQf",
				callbackUrl: "http://192.168.6.222:8080/0Mangro_TeamProject-0.01/O_member/naverJoinCallBack.jsp",
				isPopup: false, /* 팝업을 통한 연동처리 여부 */
				loginButton: {color: "green", type: 3, height: 60} /* 로그인 버튼의 타입을 지정 */
			}
		);
		
		/* 설정 정보를 초기화하고 연동을 준비 */
		naverLogin.init();
	  </script>
	  <!-------------------------------------------- 네이버 아이디로 로그인 초기화 Script  -------------------------------------------->
      			
      
      
      
      
      
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
						        <input type="text" class="form-control" name="id_name" id="id_name" placeholder="이름" aria-label="Email address">
					        
					      </div>
					      
					      <!-- 이메일 -->
					      <div class="js-form-message form-group">
						        <label class="form-label" for="id_email">이메일 
						        </label>
						        <input type="email" class="form-control" name="id_email" id="id_email" placeholder="이메일" onkeyup="duplCheck(event)"> 
						        <button type="button" class="btn btn-primary right-btn" onclick="emailCheck()">전송</button>
						        
					  	        	<span style="display: none;" id="idcheckT">
						        		 사용 가능한 이메일입니다.
						        	</span>
						        	<span style="display: none;" id="idcheckF">
						        		 이미 가입한 회원입니다.
						        	</span> 
						        	<span style="display: none;" id="emailck">
						        		 이메일 형식에 맞게 입력하세요.
						        	</span> 
						        	<span style="display: none;" id="authEmailSpan">
						        		잠시 후 인증번호창이 활성화되면 <br>
						        		입력한 메일로 전송된 인증번호를 입력하세요.
						        	</span>
					      </div>
					               
						<%-- iframe을 통해 인증번호 입력창 불러오기 --%>							  
						  <iframe src="" id="iframeHere" style="display: none;" width=600 height=150 scrolling="no" frameborder="0"></iframe>
					      
					      
					      <!-- 비밀번호 입력 & 비밀번호 확인 -->
					      <div class="js-form-message form-group">
					        <label class="form-label" for="id_password1">
					          <span class="d-flex justify-content-between align-items-center">비밀번호</span>
					        </label>
					        <input type="password" class="form-control" name="id_password1" id="id_password1" placeholder="********"
					        		style="margin-bottom: 30px;">
					        		
					      </div> 
					               
					      <div class="js-form-message form-group">
					        <label class="form-label" for="id_password1">
					          <span class="d-flex justify-content-between align-items-center">비밀번호 확인</span>
					        </label>
					        
					        <input type="password" class="form-control" name="id_password2" id="id_password2" placeholder="********">
					      </div>
					        
					      <div class="mb-6">
					        <div class="js-form-message">
					          <div class="custom-control custom-checkbox d-flex align-items-center text-muted">
					            <input type="checkbox" class="custom-control-input" id="yackuan-check" name="termsCheckbox" onclick="checkBox(event)">
					            <label class="font-subhead custom-control-label" for="termsCheckbox">
					            
					              <p class="m-0">
					                <a class="yackuan" href="javascript:void(window.open('./O_member/member_terms_of_use.jsp', '회원가입 약관','width=700, height=700'))">이용약관</a> 및
					                <a class="gaein" href="javascript:void(window.open('./O_member/member_terms_of_use.jsp', '회원가입 약관','width=700, height=700'))">개인정보취급방침</a>에 동의합니다.
					              </p>
					            </label>
					          </div>
					        </div>
					        <p class="guango">* 본 약관에는 광고성 정보 수신동의가 포함되어있습니다.</p> <br>
					      </div>
					
					      <div class="row align-items-center mb-5">
					        <div class="col-7">
					          <span class="font-subhead text-muted mb-2">이미 계정이 있으신가요?</span>
					          	<a href="./MemberLogin.me">로그인</a>
					        </div> 
					        <div class="col-5 text-right">
					          <input type="submit" class="btn btn-primary" value="가입하기">
					        </div>
					
					      </div>
					      	 	<input type="hidden" style="display: inline-block;" id="fromIframe" ></div>
					      </form>
      <!-------------------------------------------- [form태그 끝] -------------------------------------------------------->
				    </div> <!-- section_title_container text-center -->




				</div> <!-- col -->
			</div> <!-- row -->
		</div> <!-- container -->

</body>

</html>