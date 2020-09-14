<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Mango project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/academy_audit.css">
<link rel="stylesheet" type="text/css" href="styles/academy_single_responsive.css">
<link rel="stylesheet" type="text/css" href="styles/aca_audit_manage.css">



<!-- jQuery UI CSS파일  -->
<link rel="stylesheet"  href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" /> 

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
	  var availDate = document.getElementById("auditAvailDate");
	  
	  newJquery(availDate).datepicker({		  	
		  changeMonth : true,
		  changeYear : true,
		  nextText : '다음 달',
		  prevText : '이전 달',
		  showButtonPanel : true,
		  currentText : '오늘 날짜',
		  closeText : '닫기',
		  dateFormat : "yy-mm-dd",		
          dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
          dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
          monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
          monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	  	  minDate : "+1", // 오늘날짜 이후부터 선택
	  	  maxDate: "+5M +1D" //최대 가능한 날짜
	  });
  });	 
     
  //================input태그 숫자만 입력가능하도록 설정=============================
	function inNumber(event){
	  if(event.keyCode < 48 || event.keyCode > 57){
		  event.returnValue = false;
	  }
	}
  
  window.onload = function(){
	  var auditLastTime = document.querySelector("input[name='auditLastTime']");
	  var auditAblemem = document.querySelector("input[name='auditAblemem']");
	  
	  auditLastTime.addEventListener('keypress', function(event){
		 inNumber(event);
	  });
	  
	  auditAblemem.addEventListener('keypress', function(event){
			 inNumber(event);
	  });

  };
	  
	  
</script>

</head>
<body>	


	
	<!---------------[가져온 회원정보(from AcademyGetInfoAction.java)]------- -->
	<c:set var="vo" value="${academyBean}" />
	
	<!---------------[테이블]---------------------------------------------------------->
	<div class="container">
	
		<div class="section_title_container text-center">
		
			<div class="card-body">
				<h4 class="section_title">청강신청 가능일 등록</h4>
				<h6 class="card-subtitle"></h6>
			</div>
			
			
			<div class="table-responsive">
			
				<form id="info" action="./auditInfoRegister.adma" method="get">
				
					<table class="tb_audit">
					
						<tr>
							<td>학원지정번호</td>
							<td><input type="text" name="acaNum" value="${vo.acaMainNum}" readonly class="inputaudit readonly"></td>
						</tr>
						
						<tr>
							<td>학원명</td>
							<td><input type="text" name="acaName" value="${vo.acaName}" readonly class="inputaudit readonly"></td>
						</tr>
						
						<tr>

							<td>청강가능과목</td>
							<td><input type="text" name="auditAvailSubj" class="inputaudit"></td>
						</tr>
						
						<tr>
							<td>청강가능일시</td>
							<td><input type="text" name="auditAvailDate" id="auditAvailDate" class="inputaudit"></td>
						</tr>
						<tr>
							<td>해당 수업지속시간</td>
							<td>
								<input type="text" name="auditLastTime" class="inputaudit" 
								       onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
							</td>
						</tr>
						
						<tr>
							<td>청강 가능 인원</td>
							<td>
								<input type="text" name="auditAblemem" class="inputaudit"
								       onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
							</td>
						</tr>
						
					</table>
					
					<input type="submit" class="btn btn-primary1" value="청강신청 가능일 등록">
				</form>
				
			</div>
		</div>
	</div>

</body>
</html>