<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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



</head>
<body>

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
				      <form class="sign_upClass" action="" method="post">
				      
				      	  <!-- 학원지정번호 hidden으로 보내기 -->
					        <input type="hidden" class="form-control" name="aca_num" readonly> 
					        
						      <div class="js-form-message form-group">
						        <label class="form-label audit_name">청강희망 학원명
						        	<input type="text" class="form-control" name="aca_name" value="부산학원" readonly> 
						        </label>
						        <label class="form-label audit_email">청강신청계정
						       		<input type="text" class="form-control" name="mem_email" value="user1@naver.com" placeholder="이메일" readonly>
						        </label>
							  </div>
						      
						      <div class="js-form-message form-group">
						        <label class="form-label audit_subject">청강신청과목
						       		<select  name="audit_subject" class="form-control">
						       			<option>과목 선택
						       			<!-- 학원에서 지정한  청강가능과목만 표시 영역-->
						       			<option>망고 영어 회화
						       			<option>망고 중국어 회화
						       			<option>망고 스페인어 회화
<!-- 						       		<input type="text" class="form-control" name="audit_subject" readonly placeholder="ex)망고 영어회화" > -->
									</select>			
						        </label>
							  </div>
							  <div></div>
						      	<span class="faded">청강 희망일자는 가능한 날짜 중에서만 선택가능합니다.</span>
						      <div class="js-form-message form-group">
						        <label class="form-label audit_wish">청강희망일자
							        <input type="date" class="form-control" name="audit_request_date" required>
						        </label>
						        <label class="form-label audit_request">청강신청일자
							        <input type="date" class="form-control" name="audit_request_date" value="2020-08-22" readonly required>
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