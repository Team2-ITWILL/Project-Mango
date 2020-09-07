<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!------------------------------------------ [ 제이쿼리 ] --------------------------------------------------------------->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<%---------------------[스타일시트 및 css] --------------------------------------------------------------------------------------------%>
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/aca_admin_revise.css">
<link rel="stylesheet" type="text/css" href="styles/academy_single_responsive.css">

<style type="text/css">
	input {height: 50px;}
	.btn-primary {color:#fff !important;background-color: #000 !important;border-color: #000 !important;cursor: pointer !important;}
	.btn-primary:hover {background-color: #6610f2 !important;border-color: #6610f2 !important;}
</style> 


<%---------------------[스크립트영역] 다음 주소API --------------------------------------------------------------------------------%>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	function sample4_execDaumPostcode() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	            var roadAddr = data.roadAddress; // 도로명 주소 변수
	            var extraRoadAddr = ''; // 참고 항목 변수
	
	            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                extraRoadAddr += data.bname;
	            }
	            // 건물명이 있고, 공동주택일 경우 추가한다.
	            if(data.buildingName !== '' && data.apartment === 'Y'){
	               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	            }
	            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	            if(extraRoadAddr !== ''){
	                extraRoadAddr = ' (' + extraRoadAddr + ')';
	            }
	
	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById('sample4_postcode').value = data.zonecode;
	            document.getElementById("sample4_roadAddress").value = roadAddr;
	            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
	            
	            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
	            if(roadAddr !== ''){
	                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
	            } else {
	                document.getElementById("sample4_extraAddress").value = '';
	            }
	
	            var guideTextBox = document.getElementById("guide");
	            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
	            if(data.autoRoadAddress) {
	                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
	                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
	                guideTextBox.style.display = 'block';
	
	            } else if(data.autoJibunAddress) {
	                var expJibunAddr = data.autoJibunAddress;
	                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
	                guideTextBox.style.display = 'block';
	            } else {
	                guideTextBox.innerHTML = '';
	                guideTextBox.style.display = 'none';
	            }
	        }
	    }).open();
	}
</script>
<%---------------------[스크립트영역] 다음 주소API 끝 --------------------------------------------------------------------------------%>


<!---------자바스크립트파일 호출 -------------->
<!-- <script src="/O_aca_admin_page/aca_admin_revise.js"></script> -->

<!-- --------------------------- -->
<script>

	//웹문서를 불러온 후 실행되는 함수(재정의)
	window.onload = function(){
		var imgTag = document.querySelector(".rounded-circle");
		var imgPath = '${profileImg}';
		console.log(imgPath);
		
		if(imgPath == null || imgPath == ''){
			imgTag.src = "./images/aca_profile/aca_image.jpg";
		}else{
			imgTag.src = './' + imgPath;
		}
	
	}

	$(document).ready(function(){
		var hideBtn = document.querySelector(".hideBtn");
		var fileBtn = document.querySelector("#file_img");
		var submitBtn = document.querySelector("#formSubmit");
		
		//사진 변경하기 버튼 클릭 -> FILE태그 실행
		hideBtn.onclick = function(){
			fileBtn.click();		
		}
		
		//FILE태그에 파일이 등록되면 값의 변화를 감지하는 onchange 이벤트를 통해서 썸네일함수 실행
		fileBtn.onchange = function(){
			setThumbnail(this);
			
			/* var fileBtn = document.querySelector("#file_img");
			var filePath = document.querySelector("input[name=mem_profileImg]");
			uploadFile(fileBtn, filePath);	 */
			
			var fileInfo = fileBtn.files[0];
			console.log(fileBtn);
			console.log(fileBtn.name);
			console.log(fileInfo);
		}			
		
		submitBtn.onclick = function(){				
			
			//file태그에 'name'속성 값을 넣어야 전송이 된다!!
			var form = document.querySelector(".academy_reviseFr");			
			form.action = "./AcademyReviseAction.aca";				
			form.submit();	
		} 		
		
	});
	
	//사진 선택 시 미리보기
	function setThumbnail(fileBtn){
	
		var fileInfo = fileBtn.files[0];
		var reader = new FileReader();			
		
		// FileReader.onload : 읽기 동작이 성공적으로 완료 되었을 때마다 발생한다.
		// readAsDataURL( )을 통해 파일을 읽어 들일때 onload가 실행
		reader.onload = function(){
			
			//파일의 URL을 Base64 형태로 가져온다.
			//FileReader.result : 파일의 컨텐츠
			document.querySelector(".rounded-circle").src = reader.result;
			
			//파일 URL정보를 출력
			//var p = document.createElement("p");
			//document.querySelector(".profilespan").appendChild(p).innerHTML = reader.result;
		}
		
		if(fileInfo){
			//readAsDataURL( )을 통해 파일의 URL을 읽어온다.
			reader.readAsDataURL(fileInfo);
		}	
	}
	
	function uploadFile(fileTag, filePath) {

		var formData = new FormData();
		formData.append("file", fileTag.files[0]);
	
		console.log('fileTag.files[0] : ' + fileTag.files[0]);
		console.log('fileTag : ' + fileTag);

		$.ajax({
				data : formData,
				type : "POST",
				url : "./AcademyImgUpload.aca",
				contentType : false,
				processData : false,
				enctype : 'multipart/form-data',
				success : function(data) {
					//파일 경로 및 이름
					filePath.value = data;
					
					//확인용 출력문
					console.log(filePath.value);							
					console.log('data : ' + data);

			}
		});
	}

	
	
</script>

<!-- jQuery UI CSS파일  -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" /> 

<!-- jQuery 기본 js파일 -->
<!-- jquery js와 UI버전이 같아야 datepicker가 정상적으로 작동한다!! -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  

<!-- jQuery UI 라이브러리 js파일 -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
<!-- DatePicker Library -->
<script>
  var newJquery = $.noConflict(true);
  //기존 라이브러리 : $
  //새로운 라이브러리 : newJquery

  newJquery(function(){	
	  var aca_start_date = document.querySelector("#aca_start_date");
	  newJquery(aca_start_date).datepicker({		  	
		  changeMonth : true,
		  changeYear : true,
		  nextText : '다음 달',
		  prevText : '이전 달',
		  showButtonPanel : true,
		  currentText : '오늘 날짜',
		  closeText : '닫기',
		  
		  //dateFormat : "yy-mm-dd",		
		  dateFormat : "yymmdd",	
		  
          dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
          dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
          monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
          monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	  	  minDate : "+1", // 오늘날짜 이후부터 선택
	  	  maxDate: "+5M +1D" //최대 가능한 날짜
	  });
  });	  
</script>

</head>
<body>

		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h4 class="section_title">학원 정보 수정</h4>

						<span class="noticeSpan">모든 정보는 누락없이 기입하셔야 합니다.</span> 
						<span class="noticeSpan">* 표시 정보는 사이트 관리자를 통해 확인 작업 후 변경 가능합니다.</span> <br>
      <!-------------------------------------------- [form태그 시작] -------------------------------------------------------->
					      <!-- <form class="academy_reviseFr" action="./AcademyReviseAction.aca" id="reviseForm" method="post" enctype="multipart/form-data"> -->
					      <form class="academy_reviseFr" action="" method="post" enctype="multipart/form-data">
						      
						      <img src="" alt="user" class="rounded-circle">
		      					<!-- 파일 선택 후 첨부하면 바뀐 이미지가 rounded-circle안에 미리보기로 가능하도록 구현 -->								  
								  <%-- <c:choose>
								  	<c:when test="${profileImg eq null}">
								  		<% $(".rounded-circle").src("images/aca_profile/aca_image.jpg"); %>
								  	</c:when>
								  	<c:when test="${profileImg ne null}">
								  		<img src="./${profileImg}" alt="user" class="rounded-circle">
								  	</c:when>
								  </c:choose> --%>
								  
								  <!-- 학원 프로필사진 변경 -->
							      <div class="js-form-message form-group">
							        	<label class="form-label" for="anony_file"><span class="profilespan">프로필사진</span></label>
						              	<div class="form-group files">
						                	<input type="file" 
						                		   class="form-control color file" 
						                		   id="file_img" 
						                		   name="file_img" 
						                		   multiple=""
						                	>
						                	<input type="hidden" name="mem_profileImg">
							          		<button type="button" class="hideBtn">사진변경하기</button>
						              	</div>								
							      </div>
							      
							      <!-- 사진 멀티업로드(갤러리) -->
							      <%-- <div class="js-form-message form-group">
							        	<label class="form-label" for="anony_file"><span class="profilespan">학원 갤러리</span></label>
						              	<br>l						              	
						              	
								      	<c:forEach var="afVO" items="${afList}">
									      	<div class="form-group" style="float:left;">
									      		<img src="${afVO.stored_file_name}"
									      			 style="width:100px; height:100px;">
									      		<br>fileNo:${afVO.file_no}
									      	</div>							      		
								      	</c:forEach>
						              	
						              	<div class="form-group files">
						                	<input type="file" 
						                		   class="form-control color file" 						                		   
						                		   name="gallary_imgs" 
						                		   multiple="3"
						                	>
						                	<input type="hidden" name="aca_gallaryImgs">
							          		<button type="button" class="hideBtn">갤러리 사진 등록</button>
						              	</div>						            									      						
							      </div>
							       --%>
							      
							     
		
									<!-- clear:both로 임시 수정 -->
							      <div class="js-form-message form-group" style="clear:both;">
							      <!-- <div class="js-form-message form-group"> -->
								        <label class="form-label" for=""><span>시도교육청 코드</span></label>
								        <input type="text" class="form-control" name="aca_code" id="aca_code" value="${academyVO.acaCode}" readonly>
							      </div>
							      
							      <div class="js-form-message form-group">
								        <label class="form-label" for=""><span>학원지정번호</span></label>
								        <input type="text" class="form-control" name="aca_num" id="aca_num" value="${academyVO.acaNum}" readonly>
								        
								        <!-- AcademyReviseAction으로 보낼 학원번호 -->
								        <input type="hidden" name="aca_main_num" value="${academyVO.acaMainNum}">
							      </div>
							      
							      <div class="js-form-message form-group">
								        <label class="form-label" for=""><span>학원/교습소</span></label>
								        <input type="text" class="form-control" name="aca_attr" id="aca_attr" value="${academyVO.acaAttr}" readonly>
							      </div>
							      
							      <div class="js-form-message form-group">
								        <label class="form-label" for=""><span>학원명</span></label>
								        <input type="text" class="form-control" name="aca_name" id="aca_name" value="${academyVO.acaName}">
							      </div>
							      
							      <div class="js-form-message form-group">
								        <label class="form-label" for=""><span>학원 관리자 계정</span></label>
								        <input type="text" class="form-control" name="mem_email" id="mem_email" value="${academyVO.mem_email}" readonly>  
							      </div>
							      
							      <div class="js-form-message form-group">
								        <label class="form-label" for=""><span>학원 개설일</span></label>
								        <%-- <fmt:parseDate var="startDate" value="${academyVO.acaStartDate}" pattern="yyyy-MM-dd" /> --%>
								        <input type="text" class="form-control" name="aca_start_date" id="aca_start_date" value="${academyVO.acaStartDate}">  
							      </div>
							      
							      <div class="js-form-message form-group">
								        <label class="form-label" for=""><span>카테고리(대)</span></label>
								        <input type="text" class="form-control" name="aca_category1" id="aca_category1" value="${academyVO.acaCategory1}">  
							      </div>
							      
							      <div class="js-form-message form-group">
								        <label class="form-label" for=""><span>카테고리(소)</span></label>
								        <input type="text" class="form-control" name="aca_category2" id="aca_category2" value="${academyVO.acaCategory2}">  
							      </div>
		
		
		<%--------------------------------------[입력란 중 Daum API에서 처리하는 폼영역]-----------------------------------------------------------------%>
									
					        	  <div class="form-group mb-8" style="display: grid; ">
						        		<label class="form-label" for="academy_address" style="margin-bottom:10px;"><span>학원 주소</span></label> 
			
											<input type="text" name="addr_zip" class="input-field form-control" id="sample4_postcode" value="${academyVO.acaAddrZip}" placeholder="우편번호"> 
											<input type="text" name="addr_doro" class="input-field form-control" id="sample4_roadAddress" value="${academyVO.acaAddrDoro}" placeholder="도로명주소"> 
											<span id="guide" style="color:#999;display:none"></span>
											<!-- ▼ [아래 3개 정보] db에 컬럼이 없어 hidden처리함(삭제시 api 작동불능을 방지하기 위해 남겨둠) -->
											<input type="hidden" name="addr_jibun" class="input-field form-control" id="sample4_jibunAddress" placeholder="지번주소(선택)"> <br>
											<input type="hidden" name="addr_detailed" class="input-field form-control" id="sample4_detailAddress" placeholder="상세주소"> 
											<input type="hidden" name="addr_dong" class="input-field form-control" id="sample4_extraAddress" placeholder="참고항목" width="20px">		           
											<!-- ▲ --------------------------------------------------------------------- -->
											<input type="button" class="btn btn-write" onclick="sample4_execDaumPostcode()" value="주소찾기" id="addrCheck_btn"><br>
									
							 	  </div>
		
							      
		
							      
							      <span class="warningSpan"> 허위사실을 기재하여 정보를 수정하는 경우 「학원의 설립ㆍ운영 및 과외교습에 관한 법률」에 의거
							      		  민·형사상의 처벌을 받을 수 있음을 알려드립니다.</span>
							
							
							      <div class="row align-items-center mb-5" style="float:right;">
							        <div class="col-5 text-right">
							          <button type="submit" class="btn btn-primary" id="formSubmit">저장하기</button>
							        </div>
							      </div>
							      
					      </form>
      <!-------------------------------------------- [form태그 끝] -------------------------------------------------------->
					</div> <!-- section_title_container text-center -->


				</div> <!-- class="col" -->
			</div> <!-- class="row" -->
		</div> <!-- class="container" -->


</body>
</html>