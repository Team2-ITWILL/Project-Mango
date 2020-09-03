<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Mango project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/academy_audit.css">
<link rel="stylesheet" type="text/css" href="styles/academy_single_responsive.css">



<style type="text/css">

	.btn-primary {
	    color:#fff !important;
	    background-color: #000 !important;
	    border-color: #6610f2 !important;
	    cursor: pointer !important;
	    
	    width: 600px;
	    padding: 0;
	    margin: auto;
	    margin-left: 0;
	    
	}
	
	.btn-primary:hover { background-color: #6610f2 !important;}
	.audit_name, .audit_request { width: 297px;}
	.audit_email, .audit_wish{ width: 295px;}
	.audit_subject {width: 600px;}

..faded {
	color: #b3b3b3 !important;
}

</style> 


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
	  var audit_wish = document.getElementById("audit_wish");
	  newJquery(audit_wish).datepicker({		  	
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
</script>

</head>
<body>

<!-- AuditRequestGetAvailSubjectAction.java로부터 데이터를 받아온다 -->
<c:set var="email" value="${requestScope.email}" />
<c:set var="list" value="${requestScope.auditManageList}" />

<script>
	console.log("${email}");
	console.log("${list}");
</script>

		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h4 class="section_title">청강신청</h4>

					      <div class="mb-5 mt-2">
					      	<ul class="audit_notice">
						      	<li>유의사항</li>
						      	<li>청강신청은 청강을 희망하는 날짜 이후로만 선택 가능합니다.</li>
						      	<li>학원 운영상의 사정으로 희망날짜에 청강이 불가할 수 있으므로 정확한 일정은 학원과 연락드릴 예정입니다.</li>
						      	<li>원활한 학원 정보 제공을 위해 이전 청강신청이 승인/취소 되기 전까지 다른 청강신청을 <br> 할 수 없음을 알려드립니다.</li>
					      	</ul>
					      </div>
				      
				      <!-- form 시작 -->
				      <form class="sign_upClass" action="./request.adrq" method="post">
				      
				      	  <!-- 학원지정번호 hidden으로 보내기 -->
				      	  <!-- academy_single.jsp에서 전달받은 request parameter -->
					        <input type="hidden" class="form-control" name="aca_num" value="${list[0].acaNum}" readonly> 
					        
					         <!-- academy_single.jsp에서 전달받은 request parameter -->
						      <div class="js-form-message form-group">
						        <label class="form-label audit_name">청강희망 학원명
						        	<!-- <input type="text" class="form-control" name="aca_name" value="부산학원" readonly> --> 
						        	<input type="text" class="form-control" name="aca_name" value="${list[0].acaName}" readonly> 
						        </label>
						        <label class="form-label audit_email">청강신청계정
						       		<input type="text" class="form-control" name="mem_email" value="${email}" placeholder="이메일" readonly>
						        </label>
							  </div>
						      
						      <div class="js-form-message form-group">
						        <label class="form-label audit_subject">청강신청과목
						       		<select  name="audit_subject" class="form-control">	
						       			<!-- 학원에서 지정한  청강가능과목만 표시 영역-->					       			
							       		<option disabled>과목 선택</option>
							       		
							       		<!-- 등록된 청강과목리스트로의 과목들을 select option으로 등록 -->
							       		<c:forEach var="vo" items="${list}">	
							       			<option>${vo.auditAvailSubj}</option>							       			
										</c:forEach>
										
									</select>	
										
									
						        </label>
							  </div>
							  <div></div>
						      	<span class="faded">청강 희망일자는 가능한 날짜 중에서만 선택가능합니다.</span>
						      <div class="js-form-message form-group">
						        <label class="form-label audit_wish">청강희망일자
							        <input type="text" class="form-control" name="audit_wish_date" id="audit_wish" required>
						        </label>
						        <label class="form-label audit_request">청강신청일자(오늘)
							        <input type="text" class="form-control" name="audit_request_date" value="<%=LocalDate.now()%>" readonly required>
						        </label>
						      </div>
					      
								<div class="col-5 auditBtn" style="padding-left: 0">
						          <button type="submit" class="btn btn-primary">청강신청</button>
						        </div>
					      </form>
					    </div>




				</div> <!-- class="col" -->
			</div> <!-- class="row" -->
		</div> <!-- class="container" -->


</body>
</html>