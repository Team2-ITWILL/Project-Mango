<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>망고 - 로그인</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/form_basic_page.css">
<link rel="stylesheet" type="text/css" href="styles/academy_single_responsive.css">
<script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>

<style type="text/css">
	input {height: 50px;}
	.btn-primary {color:#fff !important;background-color: #000 !important;border-color: #000 !important;cursor: pointer !important;}
	.btn-primary:hover {background-color: #6610f2 !important;}
	#rememberCheck {margin-left: -25px; z-index: 1 ; opacity: 1;}
</style> 



</head>
<script type="text/javascript">

/* ----------------------------------- 로그인 아이디, 비밀번호 필수 입력 확인 ------------------------------- */
	$(function loginCheck() {
		
		var regMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/) // 이메일
		
		$("#login").submit(function(){
			
			// 이메일
			if($("#id_email").val() == ""){
				alert("이메일을 입력하세요.");
				$("#id_email").focus();
				return false;
			}
			
			// 이메일 유효성 검사
		    if ( !(regMail.test( $("#id_email").val() )) ){
				alert("이메일 형식이 올바르지 않습니다.");
		    	$("#id_email").focus();
		    	$("#id_email").val("");
		    	return false;
		    }

			// 비밀번호			
			if($("#id_password1").val() == ""){
				alert("비밀번호를 입력하세요.");
				$("#id_password1").focus();
				return false;
			}
	
		}); // submit() 끝  	
/* ----------------------------------- 로그인 아이디, 비밀번호 필수 입력 확인 ------------------------------- */

	
/* ------------ 이메일 기억하기  : 입력한 이메일을 재작성하지 않고 비밀번호만 재입력하여 로그인 할 수 있게 기능 구현 ------------ */
		
		$("#login").ready(function(){
			
			$("#id_email").val(Cookies.get('key'));
			
			if($("#id_email").val != "") $("#rememberCheck").attr(":checked", true);
				
			$("#rememberCheck").change(function(){
				if($("#rememberCheck").is(":checked")) Cookies.set('key', $("#id_email").val(), {expires:900});
				else Cookies.remove('key');
				
			}); // change() 끝
				
			$("#rememberCheck").keyup(function(){
				if($("#rememberCheck").is("checked")) Cookies.set('key', $("#id_email").val(), {expires:900});
					
			}); // keyup() 끝
			
		 }); // ready() 끝
		  
	}); // loginCheck() 끝
/* --------------------------------------- 이메일 기억하기  --------------------------------------- */
</script>
<body>


		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h4 class="section_title">로그인</h4>


      <!-------------------------------------------- [form태그 시작] -------------------------------------------------------->
			      <form class="sign_upClass" action="./MemberLoginAction.me" method="post" id="login" > <!-- onsubmit="loginCheck()" -->
				      
				      <div class="mb-5 mt-2">
				        <p>반갑습니다. 로그인하고 Mango를 시작해보세요.</p>
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
						callbackUrl: "http://192.168.6.222:8080/0Mangro_TeamProject-0.01/O_member/naverLoginCallBack.jsp",
						isPopup: false, /* 팝업을 통한 연동처리 여부 */
						loginButton: {color: "green", type: 3, height: 60} /* 로그인 버튼의 타입을 지정 */
					}
				);
				
				/*  서비스 URL과 콜백URL을 필수로 기입해야 한다. 서비스 URL은 네아로 버튼이 노출될 페이지의 주소를 적으면 된다.
					네아로 버튼이라고 했지만 사실상 회원가입이나 로그인버튼이다. 
					네이버로 로그인 버튼이 띄워질 페이지의 URL을 적으면 되겠다.
					소셜로그인 API이용시 token이라는 것을 접하게 된다. 
					토큰엔 접근토큰(access_token), 갱신토큰(refrech_token)이 있다. 
					로그인 API에서의 토큰이란 세션과 비슷한 역할을 한다고 보면 된다. 
					이 접근 토큰이 있어야만 네아로로 로그인을 할 수 있다. 
					따라서 접근 토큰을 가져와야 하는데 이 토큰을 받을 페이지를 콜백페이지로 생각하면 된다.
					즉 접근토큰을 받을 페이지의 url을 callback url에 기입하면 된다. */
				
				
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
      

					      <div class="js-form-message form-group">
						        <label class="form-label" for="id_email">이메일</label>
						        <input type="text" class="form-control" name="id_email" id="id_email" placeholder="이메일" 
						               required
						               data-msg="이메일을 입력해주세요."
						               data-error-class="form-error"
						               data-success-class="form-success">
					        
					      </div>
					      <div class="js-form-message form-group">
						        <label class="form-label" for="id_password1">
						          <span class="d-flex justify-content-between align-items-center">비밀번호</span>
						        </label>
						        <div class="col-7 find_password">
						          <span class="font-subhead text-muted mb-2 go_find_pwd">
						          	<a href="./MemberFindPw.me">비밀번호를 잊으셨나요? </a>
						          </span>
						        </div> 
						        
						        <input type="password" class="form-control" name="id_password1" id="id_password1" placeholder="********"
						               aria-label="********" required
						               data-msg="올바른 비밀번호를 입력해주세요."
						               data-error-class="form-error"
						               data-success-class="form-success">
					        
					        
					      </div>
					
					
					      <div class="mb-6">
					        <div class="js-form-message">
					          <div class="custom-control custom-checkbox d-flex align-items-center text-muted">
					            <input type="checkbox" class="custom-control-input" id="rememberCheck" name="rememberCheck">
					            <label class="font-subhead custom-control-label" for="termsCheckbox" id="">이메일 기억하기
					            </label>
					          </div>
					        </div>
					      </div>
					
					
					      <div class="row align-items-center mb-5">
					        <div class="col-7">
					          <span class="font-subhead text-muted mb-2">계정이 없으시다면</span>
					          	<a href="./MemberJoin.me">회원가입</a>
					        </div> 
					        <div class="col-5 text-right">
					          <button type="submit" class="btn btn-primary">로그인</button>
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