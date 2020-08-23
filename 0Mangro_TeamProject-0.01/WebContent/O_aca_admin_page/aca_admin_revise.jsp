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
<script type="text/javascript">
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
					      <form class="academy_reviseFr" action="" method="post" enctype="multipart/form-data">
						      
		      					<!-- 파일 선택 후 첨부하면 바뀐 이미지가 rounded-circle안에 미리보기로 가능하도록 구현 -->
								  <img src="images/aca_profile/aca_image.jpg" alt="user" class="rounded-circle">
								  
							      <div class="js-form-message form-group">
									        	<label class="form-label" for="anony_file"><span class="profilespan">프로필사진</span></label>
								              	<div class="form-group files">
								                	<input type="file" class="form-control color file"  multiple="">
									          		<button type="button" class="hideBtn" onchange="changeValue(this)">사진변경하기</button>
								              	</div>								
							      </div>
		
		
							      <div class="js-form-message form-group">
								        <label class="form-label" for=""><span>시도교육청 코드</span></label>
								        <input type="text" class="form-control" name="" id="" value="B10" readonly>
							      </div>
							      
							      <div class="js-form-message form-group">
								        <label class="form-label" for=""><span>학원지정번호</span></label>
								        <input type="text" class="form-control" name="" id="" value="30000011152" readonly>
							      </div>
							      
							      <div class="js-form-message form-group">
								        <label class="form-label" for=""><span>학원/교습소</span></label>
								        <input type="text" class="form-control" name="" id="" value="교습소" readonly>
							      </div>
							      
							      <div class="js-form-message form-group">
								        <label class="form-label" for=""><span>학원명</span></label>
								        <input type="text" class="form-control" name="" id="" value="최자두 프랑스어 학원">
							      </div>
							      
							      <div class="js-form-message form-group">
								        <label class="form-label" for=""><span>학원 관리자 계정</span></label>
								        <input type="text" class="form-control" name="" id="" value="user1@naver.com" readonly>  
							      </div>
							      
							      <div class="js-form-message form-group">
								        <label class="form-label" for=""><span>학원 개설일</span></label>
								        <input type="date" class="form-control" name="" id="" value="2010-08-23">  
							      </div>
							      
							      <div class="js-form-message form-group">
								        <label class="form-label" for=""><span>카테고리(대)</span></label>
								        <input type="text" class="form-control" name="" id="" value="외국어">  
							      </div>
							      
							      <div class="js-form-message form-group">
								        <label class="form-label" for=""><span>카테고리(소)</span></label>
								        <input type="text" class="form-control" name="" id="" value="프랑스어">  
							      </div>
		
		
		<%--------------------------------------[입력란 중 Daum API에서 처리하는 폼영역]-----------------------------------------------------------------%>
									
					        	  <div class="form-group mb-8" style="display: grid; ">
						        		<label class="form-label" for="academy_address" style="margin-bottom:10px;"><span>학원 주소</span></label> 
			
											<input type="text" name="addr_zip" class="input-field form-control" id="sample4_postcode" placeholder="우편번호"> 
											<input type="text" name="addr_doro" class="input-field form-control" id="sample4_roadAddress" placeholder="도로명주소"> 
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
							          <button type="submit" class="btn btn-primary">저장하기</button>
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