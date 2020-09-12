<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>Courses</title>
<!------------------------------------------ [ 메타데이터 ] --------------------------------------------------------------->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!------------------------------------------ [ 제이쿼리 ] --------------------------------------------------------------->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<!------------------------------------------ [  CSS  ] --------------------------------------------------------------->
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/academy_list.css">
<link rel="stylesheet" type="text/css" href="styles/academy_list_responsive.css">
<link href="styles/table_style.css" rel="stylesheet">
   
       
<style type="text/css">   
form#courses_search_form{
	width: 105.4%;
}
.searchInput{
margin-bottom: 10px;
}

li.firstKey {
    border: 2px solid #66b5dd !important;

}
li.secondKey {
	 border: 2px solid #ff0080 !important;
	
}

li.thirdKey { 
	 border: 2px solid #6f42c1 !important;
}

 .aca_profile_img{
	width: 100px !important;
}

.aca_profile_div
{
	float: left !important;
    width: 150px !important;
    margin-bottom: 20px !important;
    
} 

.course_title{
    float: left !important;
    margin-top: 20px !important;
    margin-right: 10px !important;
}

.course_teacher {
    font-size: 15px !important;
    font-weight: 400 !important;
    color: #384158 !important;
    margin-top: 20px !important;
} 

.course {
    width: 150% !important;
    border-radius: 6px !important;
    background: #FFFFFF !important;
    box-shadow: 0px 1px 10px rgba(29,34,47,0.1) !important;
    top: 50px !important;
} 


</style>



<script type="text/javascript">

	 
	//div태그 클릭 -> 학원정보페이지로 이동
	function ToAcaContent(div, acaMainNum, pageNum){		
		div.onclick = function(){
			
			location.href = "./AcademyContentAction.aca?acaMainNum=" 
					+ acaMainNum 
					+ "&pageNum=" 
					+ pageNum;
					
		};	
	}
		


	$(function(){
		
	var search1=null;
	var search2=null;
	var search3=null;
	var search4=null;
	var search5=null;
	var mainsearch=null;
		
// 		if(${pageNum < 0}|| ${pageNum>pageCount }){
			
// 			alert("없는학원페이지 목록입니다");	
// 			history.back(-1);
			
// 			return false;
// 		}
			
		
		
	
		

		
		$("#courses_search_select1").change(function(){
		// 	j_test(this);
			search1=$("#courses_search_select1 option:selected").val();

		
			console.log(search1);
			
			
			$("#courses_search_select2").empty();
			$("#courses_search_select3").empty();
			$("#courses_search_select4").empty();
			
			$("#courses_search_select3").append("<option value='s3'>읍/면/동</option>");
			
			$.getJSON("getListSearchOne.aca?search1="+search1 ,  function(data){
				
				console.log(data.address);
				
				
				var select2="<option option value='s2'>시/군/구</option>";
				var select4="<option option value='s4'>카테고리</option>"
				$.each(data.address , function (index,item) {
			
					
					
					select2+="<option value='"+item.search2+"'>"+item.search2+"</option>";
					
	
				});
				$.each(data.category , function (index,item) {
			
					
					
					select4+="<option value='"+item.search4+"'>"+item.search4+"</option>";
					
	
				});
				
				$("#courses_search_select2").append(select2);
				$("#courses_search_select4").append(select4);
		
		
			});//getJSON
		
		});//change
		
		
		$("#courses_search_select2").change(function(){
		// 	j_test(this);
			search2=$("#courses_search_select2 option:selected").val();
			
		
			console.log(search2);
			
			
			$("#courses_search_select3").empty();
			$("#courses_search_select4").empty();
			$("#courses_search_select4").append("<option value='s4'>카테고리</option>");
			
			$.getJSON("getListSearchTwo.aca?search1="+search1+"&search2="+search2 ,  function(data){
				
				console.log(data.address);
				
				
				var select3="<option value='s3'>읍/면/동</option>";
				
				var select4="";
				$.each(data.address , function (index,item) {
					
					select3+="<option value='"+item.search3+"'>"+item.search3+"</option>";
			
				});
				$.each(data.category , function (index,item) {
			
							
				select4+="<option value='"+item.search4+"'>"+item.search4+"</option>";
					
	
				});
				
				
				$("#courses_search_select3").append(select3);
				$("#courses_search_select4").append(select4);
		
		
			});//getJSON
		
		});//change
		
		$("#courses_search_select3").change(function(){
		// 	j_test(this);
			search3=$("#courses_search_select3 option:selected").val();
			
		
			console.log(search3);
			
			  
			$("#courses_search_select4").empty();
			
			$.getJSON("getListSearchThr.aca?search1="+search1+"&search2="+search2+"&search3="+search3 ,  function(data){
				
				console.log(data.address);
				
				
				var select4="<option value='s4'>카테고리</option>";
				$.each(data.address , function (index,item) {
					
					select4+="<option value='"+item.search4+"'>"+item.search4+"</option>";

				});
				
				$("#courses_search_select4").append(select4);
		
		
			});//getJSON
		
		});//change		
		
		$("#courses_search_select5").change(function(){
		// 	j_test(this);
			search5=$("#courses_search_select5 option:selected").val();
			
			location.href="${Page}select5="+search5;
			
			
		
		
		});//change			
	
		
		
		
		
		$(".searchBtn").click(function(){
			


			var research="AcademySearchList.aca?";
			
  			search1=$("#courses_search_select1 option:selected").val();
  			search2=$("#courses_search_select2 option:selected").val();
	        search3=$("#courses_search_select3 option:selected").val();
			search4=$("#courses_search_select4 option:selected").val();
			search5=$("#courses_search_select5 option:selected").val();
			mainsearch = $("#mainsearch").val();
			
			
			research+="select5="+search5+"&";
			
			if(search1 != "s1" || search2 != "s2" ||search3 != "s3"||search4 != "s4"||mainsearch !=""){
			
				
				
			if(search1 != "s1"){
				
				
				research+="select1="+search1+"&";
				
			}
			if(search2 != "s2"){
				
				research+="select2="+search2+"&";
				
			}
			if(search3 != "s3"){
				
				research+="select3="+search3+"&";
				
			}
			if(search4 != "s4"){
				
				research+="select4="+search4+"&";
				
			}
			
			
			if(mainsearch !=""){
				
				research+="mainsearch="+mainsearch+"&";
				
				
			}
			
			
			research= research.slice(0,-1);
			
			location.href=research;
			
			return;
			}
			research= research.slice(0,-1);
			
			location.href=research;
			
			
		
			
		
		})
		
		

		
		
	});	//$(function)

	
	
	
	
	
		
	
</script>


</head>

<body>





	<!-- Courses -->

	<div class="courses">
		<div class="container">
			<div class="row">

<!------------------------------------------ [  Courses Main Content  ] --------------------------------------------------------------->
				<div class="col">
					<div class="courses_search_container">
					
<!------------------------------------------ [  검색form  ] --------------------------------------------------------------->
						<!-- 타자 검색영역 -->
						<!-- 키워드선택 검색영역 -->     
						<form action="AcademySearchList.aca" id="courses_search_form" class="courses_search_form" method="get" >
				
							<div class="searchInput">
								<input type="text" class="courses_search_input typingSearch" placeholder="검색하기"  id="mainsearch">
								<button type="button"class="courses_search_button ml-auto searchBtn">검색하기</button>
							</div>
							
							<div class="selectOption">
								<select id="courses_search_select1" class="courses_search_select courses_search_input" >
									<option value="s1" >시/도</option> 
										<option value="서울특별시" >서울특별시</option>
										<option value="부산광역시" >부산광역시</option>
										<option value="대구광역시" >대구광역시</option>
										<option value="인천광역시" >인천광역시</option>
										<option value="광주광역시" >광주광역시</option>
										<option value="대전광역시" >대전광역시</option>
										<option value="울산광역시" >울산광역시</option>
										<option value="세종특별자치시" >세종특별자치시</option>
										<option value="경기도" >경기도</option>
										<option value="강원도" >강원도</option>
										<option value="충청북도">충청북도</option>
										<option value="충청남도" >충청남도</option>
										<option value="전라북도" >전라북도</option>
										<option value="전라남도" >전라남도</option>
										<option value="경상북도" >경상북도</option>
										<option value="경상남도">경상남도</option>
											<option value="제주특별자치도">제주특별자치도</option>		
								</select>						
								<select id="courses_search_select2" class="courses_search_select courses_search_input" >
									<option value="s2">시/군/구</option>
								
								</select>
								<select id="courses_search_select3" class="courses_search_select courses_search_input" >
									<option value="s3">읍/면/동</option>
									
								</select>
								<select id="courses_search_select4" class="courses_search_select courses_search_input" >
									<option value="s4">카테고리</option>
									
								</select>
								
							<select id="courses_search_select5" class="courses_search_select courses_search_input" name="select5" >
									<option value="basic">기본순</option>
									<option value="like">좋아요 많은 순</option>
									<option value="review">리뷰많은 순</option>
									<option value="rating">평점 높은 순</option>
							</select>
								
							</div>
						</form>
						
					</div> <!-- class="courses_search_container" -->
							



					
					
<!------------------------------------------ [  키워드 표시 영역  ] --------------------------------------------------------------->
					<div class="sidebar_section">
						<!-- <div class="sidebar_section_title">키워드 검색</div> -->
						<div class="sidebar_tags">
							<ul class="tags_list">
								<li class="firstKey"><a href="${PageKeyword}keyword=traffic">교통이 편리한</a></li>
								<li class="firstKey"><a href="${PageKeyword}keyword=stdRoom">스터디룸 있는</a></li>
								<li class="firstKey"><a href="${PageKeyword}keyword=clean">시설이 깨끗한</a></li>
								<li class="secondKey"><a href="${PageKeyword}keyword=restaurant">식당가 인근</a></li>
								<li class="secondKey"><a href="${PageKeyword}keyword=audit">청강 신청 가능한</a></li>
								<li class="secondKey"><a href="${PageKeyword}keyword=room">기숙사가 있는</a></li>
							</ul>
							<ul class="tags_list">
								<li class="thirdKey"><a href="${PageKeyword}keyword=long">중장기(6개월 이상)</a></li>
								<li class="thirdKey"><a href="${PageKeyword}keyword=car">차량운행이 있는</a></li>
								<li class="thirdKey"><a href="${PageKeyword}keyword=level">레벨테스트가 있는</a></li>
								<li class="thirdKey"><a href="${PageKeyword}keyword=sat">수능대비강의가 있는</a></li>
							</ul>
						</div>
					</div>





<!---------------------------------------- [ 학원 1곳 목록 표시 영역 시작] ------------------------------------------------------------------------------------------->
				
				
				
						<c:if test="${count != 0}">		<!-- 학원리스트가 있을때 -->		
							<!-- Course -->
							
							<c:forEach var="i" items="${requestScope.academyList}">
							<div class="courses_container" onclick="location.href='./AcademyContentAction.aca?acaMainNum=${i.acaMainNum}&pageNum=${pageNum}'">
								<div class="courses_row">
									<div class="col-md-8 course_col">
										<div class="course">
										
												<!-- course_body -->
												<div class="course_body" onclick="ToAcaContent(this, ${i.acaMainNum}, ${pageNum})">
													<!-- 학원 사진 -->
													<div class="aca_profile_div" style="display: inline-block;">
														<img src="${i.memProfileImg}" class="aca_profile_img">
													</div>
													<h3 class="course_title">
														<a href="./AcademyContentAction.aca?acaMainNum=${i.acaMainNum}&pageNum=${pageNum}">
															${i.acaName}
														</a>
													</h3>
													<div class="course_teacher" style="top: 2px !important;">${i.acaCategory1}</div>
													<div class="course_text">
														<div class="course_info_title">
															<i class="fa fa-map-marker" aria-hidden="true"></i>&nbsp; ${i.acaAddrDoro}
														</div>
													</div>
												</div> <!-- course_body -->
												
												<!-- course_footer -->
												<div class="course_footer">
													<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
														<div class="course_info">
															<i class="fa fa-graduation-cap" aria-hidden="true"></i>
															누적 청강수<span>${i.add_audit}회</span>
														</div>
														<div class="course_info">
															<i class="fa fa-star" aria-hidden="true"></i>
															평균 별점 <span>${i.reviewScore}</span>
														</div>
														<div class="course_price ml-auto"></div>
													</div>
												</div> <!-- course_footer -->
										</div> <!-- course -->
									</div> <!-- col-md-8 course_col(페이지이동 링크걸린영역) -->
																			
							 </div> <!-- courses_row -->
						</div>  <!-- courses_container -->
						</c:forEach>
					</c:if>
					<c:if test="${count == 0}"><!-- 학원리스트가 없을때 -->
						<!-- Course -->
							<div class="courses_container">
								<div class="courses_row">
									<div class="col-md-8 course_col">
										<div class="course">
										
												<!-- course_body -->
												<div class="course_body">
													<!-- 학원 사진 -->
													<div class="aca_profile_div" style="display: inline-block;">
														<img src="images/etc/default_mango.png" class="aca_profile_img">
													</div>
													<h3 class="course_title">
														<a href="./AcademyContentAction.aca?acaMainNum=1&pageNum=1">
															등록된 학원의 정보가 없습니다
														</a>
													</h3>
													
												
												</div> <!-- course_body -->
												
												<!-- course_footer -->
												<div class="course_footer">
													<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
														
													</div>
												</div> <!-- course_footer -->
										</div> <!-- course -->
									</div> <!-- col-md-8 course_col(페이지이동 링크걸린영역) -->
																			
							 </div> <!-- courses_row -->
						</div>  <!-- courses_container -->
					
					</c:if>

							 
							 
							 <ul class="pagination">
                    <!-- << (첫페이지로 가기) -->
					  <li class="page-item"> 
					  	<a class="page-link prev" href="${PageTwo}pageNum=1">
					  		<i data-feather="chevrons-left" class="svg-icon mr-2 ml-1"></i>
					  	</a>
					  </li>
					  
					<c:if test="${count!=0}"> 
                    <!-- < (이전페이지 가기) 설정-->
					  <li class="page-item">
					  	<c:if test="${startPage-pageBlock<0}">
					  		<c:set var="pN" value="1"/>
					  	</c:if>
					  	
					  	<c:if test="${startPage-pageBlock>0}">
					  		<c:set var="pN" value="${startPage-pageBlock}"/>
					  	</c:if>
					  
					  	<a class="page-link prev" href="${PageTwo}pageNum=${pN}">
					  		<i data-feather="chevron-left" class="svg-icon mr-2 ml-1"></i>
					  	</a>	
					  
					  
					  </li>
					
					
					<c:forEach var="i" begin="${startPage}" end="${endPage}">			  
					  <li class="page-item ${pageNum == i ? 'active' : ''}"><a class="page-link" href="${PageTwo}pageNum=${i}">${i}</a></li>
					 
					</c:forEach>	
		
					  <!-- 끝 페이지 앞으로가기 설정 -->
					   	<c:if test="${startPage+pageBlock>pageCount}">
					  		<c:set var="pP" value="${pageCount}"/>
					  	</c:if>
					  	
					  	<c:if test="${startPage+pageBlock<pageCount}">
					  		<c:set var="pP" value="${startPage+pageBlock}"/>
					  	</c:if>
					  
					  <li class="page-item"><%--다음 페이지 --%>
					  	<a class="page-link next" href="${PageTwo}pageNum=${pP}">
						  	<i data-feather="chevron-right" class="svg-icon mr-2 ml-1"></i>
						</a>
					  </li>
                    
                    
                    
                    
                    
                    <!-- >> (마지막페이지 가기)-->
					  <li class="page-item">
					  	<a class="page-link next" href="${PageTwo}pageNum=${pageCount}">
						  	<i data-feather="chevrons-right" class="svg-icon mr-2 ml-1"></i>
						</a>
					  </li>
					</c:if>		 
					</ul>  
				 
							 
						</div>  <!-- courses_container -->
						
<!------------------------------------------ [  학원 1곳 목록 표시 영역 끝  ] --------------------------------------------------------------->

				</div>  <!-- Courses Main Content col-->
																			
			
		</div> <!--  class="row" -->
	</div>  <!-- class="container" -->
</div> <!-- courses -->









<!------------------------------------------ [ 자바스크립트 링크 ] --------------------------------------------------------------->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="js/courses.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tagsinput/0.8.0/bootstrap-tagsinput.min.js"></script>
 <script src="styles/assets/libs/jquery/dist/jquery.min.js"></script>
<script src="styles/assets/extra-libs/taskboard/js/jquery.ui.touch-punch-improved.js"></script>
<script src="styles/assets/extra-libs/taskboard/js/jquery-ui.min.js"></script>
<script src="styles/assets/libs/popper.js/dist/umd/popper.min.js"></script>
<script src="styles/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- apps -->
<script src="styles/dist/js/app-style-switcher.js"></script>
<script src="styles/dist/js/feather.min.js"></script>
<script src="styles/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
<script src="styles/dist/js/sidebarmenu.js"></script>
<!--Custom JavaScript -->
<script src="styles/dist/js/custom.min.js"></script>
</body>
</html>

