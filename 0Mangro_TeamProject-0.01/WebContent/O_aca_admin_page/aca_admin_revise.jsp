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


<%---------------------[스크립트영역]--------------------------------------------------------------------------------%>

<!-- jQuery UI CSS파일  -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" /> 

<!-- jQuery 기본 js파일 -->
<!-- jquery js와 UI버전이 같아야 datepicker가 정상적으로 작동한다!! -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  

<!-- jQuery UI 라이브러리 js파일 -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
<!-- DatePicker Library -->

<!-- 다음주소API 관련 js 파일 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<!---------사용자 정의 자바스크립트파일 호출 -------------->
<script src="./O_aca_admin_page/aca_admin_revise.js"></script>

<script>
//프로필 이미지 호출 함수
//js파일에 EL문법 인식이 되지 않아 여기서 사용
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
</script>
<%---------------------[스크립트영역] 끝 --------------------------------------------------------------------------------%>

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