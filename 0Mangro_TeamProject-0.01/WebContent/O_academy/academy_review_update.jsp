<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>회원가입</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Mango project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/academy_review_write.css">
<link rel="stylesheet" type="text/css" href="styles/academy_single_responsive.css">

<!----------------------------[스타일 시트]-------------------------------------------------------->
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
	
</style> 


<!----------------------------[자바스크립트]-------------------------------------------------------->
<!-- 총괄평점 클릭된 라디오버튼(active) 색상변경-->
<script type="text/javascript">
 $(function() {
		$('.sc_one').on('click', function(){
		    $('.sc_one').removeClass('active');
		    $(this).addClass('active');
		});
	});
 function checkz(){
	
	 
	 var chk = document.reviewWrite;
	 var checked_items = 0;
	 for (i=0;i<chk.elements.length;i++) 
	 {
	 if ((chk.elements[i].name == "review_score") &&
	 (chk.elements[i].checked))
	 checked_items++;
	 }
	 if (checked_items == 0)
	 {
	 alert("평점을 선택해주세요.")
	 return false;
	 }
	 return true;
 }
</script>

<c:if test="${id_email == null || id_email eq ''}">
	<script type="text/javascript">
		alert("로그인이 필요한 기능입니다.");
		location.href="./MemberLogin.me";
	</script>
</c:if>


</head>
<!----------------------------[본문]-------------------------------------------------------------->
<body>

	<div class="about">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h4 class="section_title">학원 후기 등록</h4>
						 <span class="title_span">후기는 익명으로 노출됩니다(오타 또는 은어 표기는 일부 수정이 될 수 있습니다)</span>


				      	
				      <!-- form 시작 -->
				      <form class="sign_upClass" name="reviewWrite" 
				      onsubmit="return checkz();" action="./acaReviewWriteAction.arev" method="post">
				      
				      	  <!-- ▼학원지정번호, 작성자계정 hidden으로 보내기 -->
					        <input type="hidden" name="acaMainNum" value="${param.acaMainNum }">
						    <input type="hidden" name="mem_email" value="${id_email}">
				      	  <!-- ▲학원지정번호, 작성자계정 hidden으로 보내기 -->
					        
						      <div class="js-form-message form-group">
						        <label class="form-label aca_name">학원명
						        	<input type="text" class="form-control" name="aca_name" value="${param.acaName}" readonly> 
						        </label>
						        <label class="form-label review_subject">수강과목
						        	<input type="text" class="form-control" name="review_subject" placeholder="ex) 토익 900점반"> 
						        </label>
							  </div>
							  
							  
							  
						      <div class="js-form-message form-group">
						        <label class="form-label review_good">장점
						        	<textarea name="review_good" class="form-control" placeholder="최대500자"> </textarea>
						        </label>
							  </div>
							  
						      <div class="js-form-message form-group">
						        <label class="form-label review_bad">단점
						        	<textarea name="review_bad" class="form-control" placeholder="내용을 입력해주세요."> </textarea>
						        </label>
							  </div>
						      
						      
						      <div class="js-form-message form-group">
						        <label class="form-label review_score">총괄평점 </label>
                  			  
				                  <div class="col-6 btn-group btn-group-toggle btn-review">
				                      <label for="id_score_total_1"
				                             class="btn btn-outline-primary btn-soft-secondary btn-sm sc_one" style="padding:20px !important; text-align: center;">
				                        <input type="radio" name="review_score" value="1" id="id_score_total_1">
				                       		 <i class="fa fa-star" aria-hidden="true"></i>
				                       		 <i class="fa fa-star" aria-hidden="true" style="display: none;"></i>
				                        </label>
				                      <label for="id_score_total_2"
				                             class="btn btn-outline-primary btn-soft-secondary btn-sm sc_one" >
				                        <input type="radio" name="review_score" value="2" id="id_score_total_2" >
				                       		 <i class="fa fa-star" aria-hidden="true"></i>
				                       		 <i class="fa fa-star" aria-hidden="true"></i>
				                      </label>
				                      <label for="id_score_total_3"
				                             class="btn btn-outline-primary btn-outline-primary btn-soft-secondary btn-sm sc_one" >
				                        <input type="radio" name="review_score" value="3" id="id_score_total_3" >
				                       		 <i class="fa fa-star" aria-hidden="true"></i>
				                       		 <i class="fa fa-star" aria-hidden="true"></i>
				                       		 <i class="fa fa-star" aria-hidden="true"></i>
				                      </label>
				                      <label for="id_score_total_4"
				                             class="btn btn-outline-primary btn-soft-secondary btn-sm sc_one" >
				                        <input type="radio" name="review_score" value="4" id="id_score_total_4" >
				                       		 <i class="fa fa-star" aria-hidden="true"></i>
				                       		 <i class="fa fa-star" aria-hidden="true"></i>
				                       		 <i class="fa fa-star" aria-hidden="true"></i>
				                       		 <i class="fa fa-star" aria-hidden="true"></i>
				                      </label>
				                      <label for="id_score_total_5"
				                             class="btn btn-outline-primary btn-soft-secondary btn-sm sc_one" >
				                        <input type="radio" name="review_score" value="5" id="id_score_total_5">
				                       		 <i class="fa fa-star" aria-hidden="true"></i>
				                       		 <i class="fa fa-star" aria-hidden="true"></i>
				                       		 <i class="fa fa-star" aria-hidden="true"></i>
				                       		 <i class="fa fa-star" aria-hidden="true"></i>
				                       		 <i class="fa fa-star" aria-hidden="true"></i>
				                      </label>
				                 </div>
						   </div>   
						      
						      
						      <div class="js-form-message form-group">
						        <label class="form-label review_title">이 학원에 대한 한 줄 요약
						        	<input type="text" class="form-control" name="review_title" 
						        	placeholder="(최대 25자) ex) 수업 내용이 알차고 쉽게 설명해주셔서 좋았어요!" 
						        	maxlength="25" required> 
						        </label>
							  </div>
							  
					      
							    <div class="mb-5 mt-2">
							      	<ul class="audit_notice">
								      	<li>유의사항</li>
								      	<li>다른 사용자들에게 도움이 되는 후기를 작성했는지 충분히 검토 후 제출해주세요.</li>
								      	<li>본 후기에 허위, 조작  및 학원에 대한 근거없는 비방이 포함될 시 망고 운영팀의 검수를 거쳐 통보없이 삭제 될 수 있습니다. </li>
								      	<li>위와 같은 경우 망고 운영팀에서는 해당 계정 정지 또는 영업방해, 명예훼손 등의 건으로 법적인 조치를 취할 수 있습니다.</li>
							      	</ul>
							    </div>
					      
					      
								<div class="col-5 auditBtn" style="padding-left: 0">
						          <button type="submit" class="btn btn-primary">등록하기</button>
						        </div>
					      </form>
					    </div>


				</div> <!-- class="col" -->
			</div> <!-- class="row" -->
		</div> <!-- class="container" -->


</body>
</html>