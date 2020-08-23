<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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



<style type="text/css">

li.firstKey {
    background-color: #66b5dd !important;

}
li.secondKey {
	background-color: #ff0080 !important;
	
}

li.thirdKey { 
	background-color: #6f42c1 !important;
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
						<form action="" id="courses_search_form" class="courses_search_form">
						
							<div class="searchInput">
								<input type="search" class="courses_search_input typingSearch" placeholder="검색하기" required="required">
								<button action="submit" class="courses_search_button ml-auto searchBtn">검색하기</button>
							</div>
							
							<div class="selectOption">
								<select id="courses_search_select1" class="courses_search_select courses_search_input">
									<option>시/도</option>
									<option>부산광역시</option>
									<option>부산광역시</option>
									<option>부산광역시</option>
								</select>
								<select id="courses_search_select2" class="courses_search_select courses_search_input">
									<option>시/군/구</option>
									<option>사하구</option>
									<option>사하구</option>
									<option>사하구</option>
								</select>
								<select id="courses_search_select3" class="courses_search_select courses_search_input">
									<option>읍/면/동</option>
									<option>남천동</option>
									<option>남천동</option>
									<option>남천동</option>
								</select>
								<select id="courses_search_select4" class="courses_search_select courses_search_input">
									<option>카테고리</option>
									<option>보컬,미술</option>
									<option>외국어</option>
									<option>입시</option>
								</select>
								<select id="courses_search_select4" class="courses_search_select courses_search_input">
									<option>기본순</option>
									<option>좋아요 많은 순</option>
									<option>리뷰많은 순</option>
									<option>평점 높은 순</option>
								</select>
							</div>
						</form>
					</div> <!-- class="courses_search_container" -->




					
					
<!------------------------------------------ [  키워드 표시 영역  ] --------------------------------------------------------------->
					<div class="sidebar_section">
						<!-- <div class="sidebar_section_title">키워드 검색</div> -->
						<div class="sidebar_tags">
							<ul class="tags_list">
								<li class="firstKey"><a href="#">교통이 편리한</a></li>
								<li class="firstKey"><a href="#">스터디룸 있는</a></li>
								<li class="firstKey"><a href="#">시설이 깨끗한</a></li>
								<li class="secondKey"><a href="#">식당가 인근</a></li>
								<li class="secondKey"><a href="#">청강 신청 가능한</a></li>
								<li class="secondKey"><a href="#">기숙사가 있는</a></li>
							</ul>
							<ul class="tags_list">
								<li class="thirdKey"><a href="#">중장기(6개월 이상)</a></li>
								<li class="thirdKey"><a href="#">차량운행이 있는</a></li>
								<li class="thirdKey"><a href="#">레벨테스트가 있는</a></li>
								<li class="thirdKey"><a href="#">수능대비강의가 있는</a></li>
							</ul>
						</div>
					</div>





<!---------------------------------------- [ 학원 1곳 목록 표시 영역 시작] ------------------------------------------------------------------------------------------->
				
							<!-- Course -->
							<div class="courses_container">
								<div class="courses_row">
									<div class="col-md-8 course_col" onclick="location.href='4index.jsp?center=O_academy/academy_single.jsp'">
										<div class="course">
										
												<!-- course_body -->
												<div class="course_body">
													<!-- 학원 사진 -->
													<div class="aca_profile_div" style="display: inline-block;">
														<img src="images/etc/default_mango.png" class="aca_profile_img">
													</div>
													<h3 class="course_title">
														<a href="4index.jsp?center=O_academy/academy_single.jsp">
															부산학원
														</a>
													</h3>
													<div class="course_teacher" style="top: 2px !important;">외국어</div>
													<div class="course_text">
														<div class="course_info_title">
															<i class="fa fa-map-marker" aria-hidden="true"></i>&nbsp; 부산광역시 부산진구 부전동 동천로 109
														</div>
													</div>
												</div> <!-- course_body -->
												
												<!-- course_footer -->
												<div class="course_footer">
													<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
														<div class="course_info">
															<i class="fa fa-graduation-cap" aria-hidden="true"></i>
															누적 청강수<span>79회</span>
														</div>
														<div class="course_info">
															<i class="fa fa-star" aria-hidden="true"></i>
															평균 별점 <span>5</span>
														</div>
														<div class="course_price ml-auto"></div>
													</div>
												</div> <!-- course_footer -->
										</div> <!-- course -->
									</div> <!-- col-md-8 course_col(페이지이동 링크걸린영역) -->
																			
							 </div> <!-- courses_row -->
						</div>  <!-- courses_container -->
						
<!------------------------------------------ [  학원 1곳 목록 표시 영역 끝  ] --------------------------------------------------------------->
<!---------------------------------------- [ 학원 1곳 목록 표시 영역 시작] ------------------------------------------------------------------------------------------->
				
							<!-- Course -->
							<div class="courses_container">
								<div class="courses_row">
									<div class="col-md-8 course_col" onclick="location.href='4index.jsp?center=O_academy/academy_single.jsp'">
										<div class="course">
										
												<!-- course_body -->
												<div class="course_body">
													<!-- 학원 사진 -->
													<div class="aca_profile_div" style="display: inline-block;">
														<img src="images/etc/default_mango.png" class="aca_profile_img">
													</div>
													<h3 class="course_title">
														<a href="4index.jsp?center=O_academy/academy_single.jsp">
															부산학원
														</a>
													</h3>
													<div class="course_teacher" style="top: 2px !important;">외국어</div>
													<div class="course_text">
														<div class="course_info_title">
															<i class="fa fa-map-marker" aria-hidden="true"></i>&nbsp; 부산광역시 부산진구 부전동 동천로 109
														</div>
													</div>
												</div> <!-- course_body -->
												
												<!-- course_footer -->
												<div class="course_footer">
													<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
														<div class="course_info">
															<i class="fa fa-graduation-cap" aria-hidden="true"></i>
															누적 청강수<span>79회</span>
														</div>
														<div class="course_info">
															<i class="fa fa-star" aria-hidden="true"></i>
															평균 별점 <span>5</span>
														</div>
														<div class="course_price ml-auto"></div>
													</div>
												</div> <!-- course_footer -->
										</div> <!-- course -->
									</div> <!-- col-md-8 course_col(페이지이동 링크걸린영역) -->
																			
							 </div> <!-- courses_row -->
						</div>  <!-- courses_container -->
						
<!------------------------------------------ [  학원 1곳 목록 표시 영역 끝  ] --------------------------------------------------------------->
<!---------------------------------------- [ 학원 1곳 목록 표시 영역 시작] ------------------------------------------------------------------------------------------->
				
							<!-- Course -->
							<div class="courses_container">
								<div class="courses_row">
									<div class="col-md-8 course_col" onclick="location.href='4index.jsp?center=O_academy/academy_single.jsp'">
										<div class="course">
										
												<!-- course_body -->
												<div class="course_body">
													<!-- 학원 사진 -->
													<div class="aca_profile_div" style="display: inline-block;">
														<img src="images/etc/default_mango.png" class="aca_profile_img">
													</div>
													<h3 class="course_title">
														<a href="4index.jsp?center=O_academy/academy_single.jsp">
															부산학원
														</a>
													</h3>
													<div class="course_teacher" style="top: 2px !important;">외국어</div>
													<div class="course_text">
														<div class="course_info_title">
															<i class="fa fa-map-marker" aria-hidden="true"></i>&nbsp; 부산광역시 부산진구 부전동 동천로 109
														</div>
													</div>
												</div> <!-- course_body -->
												
												<!-- course_footer -->
												<div class="course_footer">
													<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
														<div class="course_info">
															<i class="fa fa-graduation-cap" aria-hidden="true"></i>
															누적 청강수<span>79회</span>
														</div>
														<div class="course_info">
															<i class="fa fa-star" aria-hidden="true"></i>
															평균 별점 <span>5</span>
														</div>
														<div class="course_price ml-auto"></div>
													</div>
												</div> <!-- course_footer -->
										</div> <!-- course -->
									</div> <!-- col-md-8 course_col(페이지이동 링크걸린영역) -->
																			
							 </div> <!-- courses_row -->
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
</body>
</html>

