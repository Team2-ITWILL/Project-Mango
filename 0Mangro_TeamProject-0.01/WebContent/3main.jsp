<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<title>Unicat</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Mango project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">

<style type="text/css">

	/* The Modal (background) */
    .modal {
        display: none; /* Hidden by default */
        position: fixed; /* Stay in place */
        z-index: 1; /* Sit on top */
        left: 0;
        top: 0;
        width: 100%; /* Full width */
        height: 100%; /* Full height */
        overflow: auto; /* Enable scroll if needed */
        background-color: rgb(0,0,0); /* Fallback color */
        background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    }

    /* Modal Content/Box */
    .modal-content {
        background-color: #fefefe;
        margin: 2% auto; /* 15% from the top and centered */
        padding: 20px;
        border: 1px solid #888;
        width: 30%;
    }
    
    .modal_close{
    	cursor:pointer;
    	background-color:#DDDDDD;
    	text-align: center;
    	padding-bottom: 10px;
    	padding-top: 10px;
    	margin-top: 20px;
    }
	
	.modal-content h6{
		margin: 10px auto;
		font-weight: bold;
		color: #e95765;
	}
	
	.modal-content h4{
		margin: 10px auto;
		font-weight: bolder;
		color: #6610f2;
	}
	
	#notice_content{
		color: #76777a;
	}
	

</style>

<script>
	$(document).ready(function(){
		var owl = $('.owl-carousel');
		owl.owlCarousel({
		    items:1,
		    loop:false,
		    margin:10,
		    //autoplay:true,
		    autoplay:false,
		    autoplayTimeout:1000,
		    autoplayHoverPause:true
		});
		$('.play').on('click',function(){
		    owl.trigger('play.owl.autoplay',[1000])
		})
		$('.stop').on('click',function(){
		    owl.trigger('stop.owl.autoplay')
		})
	})
	

	
	$(function(){
		var search1;		
		var search2;
		var search3;
		var i=6;
		var j=7;

		
		$("#add1").change(function(){
		// 	j_test(this);
			search1=$("#add1 option:selected").val();

		
			console.log(search1);
			
			
			$(".sel2").empty();
			$(".sel3").empty();
			
			$(".sel3").append("<option value=''>읍/면/동</option>");
			
			$.getJSON("getListSearchOne.aca?search1="+search1 ,  function(data){
				
				console.log(data.address);
				
				
				var select2="<option option value=''>시/군/구</option>";
				$.each(data.address , function (index,item) {
			
					
					
					select2+="<option value='"+item.search2+"'>"+item.search2+"</option>";
					
				});
		
				$(".sel2").append(select2);
			
		
		
			});//getJSON
		
		});//change
		
		
		$(".sel2").change(function(){
		// 	j_test(this);
			search2=$(".sel2 option:selected").val();
			
		
			console.log(search2);
			
			
			$(".sel3").empty();
		
			
			$.getJSON("getListSearchTwo.aca?search1="+search1+"&search2="+search2 ,  function(data){
				
				console.log(data.address);
				
				
				var select3="<option value=''>읍/면/동</option>";
				
				$.each(data.address , function (index,item) {
					
					select3+="<option value='"+item.search3+"'>"+item.search3+"</option>";
			
				});
				
				
				
				$(".sel3").append(select3);
		
		
			});//getJSON
		
		});//change
		
		
		
		
		
		$('.right').on('click',function(){
		
			
			
			
			$(".home_slider_background").css("background-image","url(images/mainslider"+i+".jpg)")
			i++;
		
			if(i>7){
				i=5;
			}
			
			
			
			
			
			
		})
		$('.left').on('click',function(){
		
			i--;
			if(i<5){
				i=7;
			}
			$(".home_slider_background").css("background-image","url(images/mainslider"+i+".jpg)")
			
		})
	
		
		      
	})
	
	
	
	

	 jQuery(document).ready(function() {
                $('#myModal').show();
        });
        //팝업 Close 기능
        function close_pop(flag) {
             $('#myModal').hide();
      };

</script>

</head>

<body>

	<!-- Home -->

	<div class="home">
		<div class="home_slider_container">
			
			<div id="myModal" class="modal">

			      <!-- Modal content -->
			      <div class="modal-content">
			      <img alt="covid19_notice" src="images/mainModal.png" width="100%">
			                <h6>신종 코로나 바이러스 대비</h6>
			                <h4>청강시 예방 수칙</h4>
			                <p id="notice_content">
			                1. 감염 예방을 위해서 마스크를 반드시 착용해주세요.<br>
			                2. 방문시 직원으로부터 발열 체크를 해주세요.<br>
			                3. 손을 자주 30초 이상 깨끗이 씻도록 해주세요.<br>
			                </p>
			            <div class="modal_close" onClick="close_pop();">
			                <span class="pop_bt">
			                     		닫기
			                </span>
			            </div>
			      </div>
			 
			    </div>
			        <!--End Modal-->
			<!-- Home Slider -->
			<div class="owl-carousel owl-theme home_slider">
				
				<!-- Home Slider Item -->
				<div class="owl-item">
					<div class="home_slider_background" style="background-image:url(images/mainslider5.jpg)"></div>
					<div class="home_slider_content">
						<div class="container">
							<div class="row">
								<div class="col text-center">
									<div class="home_slider_title">우리동네 학원을 찾아보세요.</div>
									<div class="home_slider_subtitle">괜찮은 학원 찾기 Mango가 도와드릴게요.</div>
									<div class="home_slider_form_container">
										<form action="AcademySearchList.aca" id="home_search_form_1" method="post" class="home_search_form d-flex flex-lg-row flex-column align-items-center justify-content-between">
												<input type="hidden" name="select4">
												<input type="hidden" name="select5">
											<div class="d-flex flex-row align-items-center justify-content-start">
												<input type="text" class="home_search_input" placeholder="검색하기" name="mainsearch">
												<select class="dropdown_item_select home_search_input" id="add1" name="select1">
													<option value="">시/도</option>
													<option value="서울특별시">서울특별시</option>
													<option value="부산광역시">부산광역시</option>
													<option value="대구광역시">대구광역시</option>
													<option value="인천광역시">인천광역시</option>
													<option value="광주광역시">광주광역시</option>
													<option value="대전광역시">대전광역시</option>
													<option value="울산광역시">울산광역시</option>
													<option value="세종특별자치시">세종특별자치시</option>
													<option value="경기도">경기도</option>
													<option value="강원도">강원도</option>
													<option value="충청북도">충청북도</option>
													<option value="충청남도">충청남도</option>
													<option value="전라북도">전라북도</option>
													<option value="전라남도">전라남도</option>
													<option value="경상북도">경상북도</option>
													<option value="경상남도">경상남도</option>
													<option value="제주특별자치도">제주특별자치도</option>		
												</select>
												<select class="dropdown_item_select home_search_input sel2"  name="select2">
													<option value="">시/군/구</option>
													
												</select>
												<select class="dropdown_item_select home_search_input sel3"  name="select3">
													<option value="">읍/면/동</option>
												
												</select>
											</div>
											<button type="submit" class="home_search_button">search</button>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Home Slider Item
				<div class="owl-item">
					<div class="home_slider_background" style="background-image:url(images/mainslider7.jpg)"></div>
					<div class="home_slider_content">
						<div class="container">
							<div class="row">
								<div class="col text-center">
									<div class="home_slider_title">우리동네 학원을 찾아보세요.</div>
									<div class="home_slider_subtitle">괜찮은 학원 찾기 Mango가 도와드릴게요.</div>
									<div class="home_slider_form_container">
										<form action="#" id="home_search_form_2" class="home_search_form d-flex flex-lg-row flex-column align-items-center justify-content-between">
											<div class="d-flex flex-row align-items-center justify-content-start">
												<input type="search" class="home_search_input" placeholder="검색하기" required="required">
													<select class="dropdown_item_select home_search_input sel1">
													<option>시/도</option>
													<option value="서울특별시">서울특별시</option>
													<option value="부산광역시">부산광역시</option>
													<option value="대구광역시">대구광역시</option>
													<option value="인천광역시">인천광역시</option>
													<option value="광주광역시">광주광역시</option>
													<option value="대전광역시">대전광역시</option>
													<option value="울산광역시">울산광역시</option>
													<option value="세종특별자치시">세종특별자치시</option>
													<option value="경기도">경기도</option>
													<option value="강원도">강원도</option>
													<option value="충청북도">충청북도</option>
													<option value="충청남도">충청남도</option>
													<option value="전라북도">전라북도</option>
													<option value="전라남도">전라남도</option>
													<option value="경상북도">경상북도</option>
													<option value="경상남도">경상남도</option>
													<option value="제주특별자치도">제주특별자치도</option>		
												</select>
												<select class="dropdown_item_select home_search_input sel2">
													<option>시/군/구</option>
												</select>
												<select class="dropdown_item_select home_search_input sel3">
													<option>읍/면/동</option>
												</select>
											</div>
											<button type="submit" class="home_search_button">search</button>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				Home Slider Item
				<div class="owl-item">
					<div class="home_slider_background" style="background-image:url(images/mainslider5.jpg)"></div>
					<div class="home_slider_content">
						<div class="container">
							<div class="row">
								<div class="col text-center">
									<div class="home_slider_title">우리동네 학원을 찾아보세요.</div>
									<div class="home_slider_subtitle">괜찮은 학원 찾기 Mango가 도와드릴게요.</div>
									<div class="home_slider_form_container">
										<form action="#" id="home_search_form_3" class="home_search_form d-flex flex-lg-row flex-column align-items-center justify-content-between">
											<div class="d-flex flex-row align-items-center justify-content-start">
												<input type="search" class="home_search_input" placeholder="검색하기" required="required">
												<select class="dropdown_item_select home_search_input sea1">
													<option>시/도</option>
													<option value="서울특별시">서울특별시</option>
													<option value="부산광역시">부산광역시</option>
													<option value="대구광역시">대구광역시</option>
													<option value="인천광역시">인천광역시</option>
													<option value="광주광역시">광주광역시</option>
													<option value="대전광역시">대전광역시</option>
													<option value="울산광역시">울산광역시</option>
													<option value="세종특별자치시">세종특별자치시</option>
													<option value="경기도">경기도</option>
													<option value="강원도">강원도</option>
													<option value="충청북도">충청북도</option>
													<option value="충청남도">충청남도</option>
													<option value="전라북도">전라북도</option>
													<option value="전라남도">전라남도</option>
													<option value="경상북도">경상북도</option>
													<option value="경상남도">경상남도</option>
													<option value="제주특별자치도">제주특별자치도</option>		
												</select>
												<select class="dropdown_item_select home_search_input sel2">
													<option>시/군/구</option>
												</select>
												<select class="dropdown_item_select home_search_input sel3">
													<option>읍/면/동</option>
												
												</select>
											</div>
											<button type="submit" class="home_search_button">search</button>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div> -->
			</div>
		</div>

		<!-- Home Slider Nav -->

	
	<div class="home_slider_nav home_slider_prev left"><i class="fa fa-angle-left " aria-hidden="true"></i></div>
	<div class="home_slider_nav home_slider_next right"><i class="fa fa-angle-right" aria-hidden="true"></i></div>
		
	</div>


	<!-- Popular Courses -->

	<div class="courses">
		<div class="section_background parallax-window" data-parallax="scroll" data-speed="0.8"></div>
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h2 class="section_title">인기 많은 학원 TOP 3 </h2>
						<div class="section_subtitle"><p>청강 신청자 수가 많고 학원 평점 순위가 가장 높은 순서대로 노출됩니다.</p></div>
					</div>
				</div>
			</div>
			<div class="row courses_row">
				
				<!-- Course -->
				<div class="col-lg-4 course_col">
					<div class="course">
						<div class="course_image"><img src="images/academy/topaca1.jpg"></div>
						<div class="course_body">
							<h3 class="course_title"><a href="course.jsp">부산학원</a></h3>
							<div class="course_teacher">Mr. John Taylor</div>
							<div class="course_text">
								<p>Lorem ipsum dolor sit amet, consectetur adipi elitsed do eiusmod tempor</p>
							</div>
						</div>
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
						</div>
					</div>
				</div>

				<!-- Course -->
				<div class="col-lg-4 course_col">
					<div class="course">
						<div class="course_image"><img src="images/academy/topaca2.jpg"></div>
						<div class="course_body">
							<h3 class="course_title"><a href="course.html">미래학원</a></h3>
							<div class="course_teacher">Ms. Lucius</div>
							<div class="course_text">
								<p>Lorem ipsum dolor sit amet, consectetur adipi elitsed do eiusmod tempor</p>
							</div>
						</div>
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
						</div>
					</div>
				</div>

				<!-- Course -->
				<div class="col-lg-4 course_col">
					<div class="course">
						<div class="course_image"><img src="images/academy/topaca3.jpg"></div>
						<div class="course_body">
							<h3 class="course_title"><a href="course.html">YMC어학원</a></h3>
							<div class="course_teacher">Mr. Charles</div>
							<div class="course_text">
								<p>Lorem ipsum dolor sit amet, consectetur adipi elitsed do eiusmod tempor</p>
							</div>
						</div>
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
						</div>
					</div>
				</div>

			</div>
			<div class="row">
				<div class="col">
					<div class="courses_button trans_200">
						<a href="4index.jsp?center=O_academy/academy_list.jsp">더 많은 인기학원 보기</a>
					</div>
				</div>
			</div>
		</div>
	</div>








	<!-- Features -->

	<div class="features">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h2 class="section_title">Mango에서 다양한 활동을 즐겨보세요.</h2>
						<div class="section_subtitle"><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel gravida arcu. Vestibulum feugiat, sapien ultrices fermentum congue, quam velit venenatis sem</p></div>
					</div>
				</div>
			</div>
			<div class="row features_row">
				
				<!-- Features Item -->
				<div class="col-lg-3 feature_col">
					<div class="feature text-center trans_400">
						<div class="feature_icon"><img src="images/icon_1.png" alt=""></div>
						<h3 class="feature_title">The Experts</h3>
						<div class="feature_text"><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit</p></div>
					</div>
				</div>

				<!-- Features Item -->
				<div class="col-lg-3 feature_col">
					<div class="feature text-center trans_400">
						<div class="feature_icon"><img src="images/icon_2.png" alt=""></div>
						<h3 class="feature_title">Book & Library</h3>
						<div class="feature_text"><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit</p></div>
					</div>
				</div>

				<!-- Features Item -->
				<div class="col-lg-3 feature_col">
					<div class="feature text-center trans_400">
						<div class="feature_icon"><img src="images/icon_3.png" alt=""></div>
						<h3 class="feature_title">Best Courses</h3>
						<div class="feature_text"><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit</p></div>
					</div>
				</div>

				<!-- Features Item -->
				<div class="col-lg-3 feature_col">
					<div class="feature text-center trans_400">
						<div class="feature_icon"><img src="images/icon_4.png" alt=""></div>
						<h3 class="feature_title">Award & Reward</h3>
						<div class="feature_text"><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit</p></div>
					</div>
				</div>

			</div>
		</div>
	</div>


	<!-- Events -->

	<div class="events">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h2 class="section_title">Mango에서 다양한 활동을 즐겨보세요.</h2>
						<div class="section_subtitle"><p>Mango에서 다양한 활동을 즐겨보세요.Mango에서 다양한 활동을 즐겨보세요. </p></div>
					</div>
				</div>
			</div>
			<div class="row events_row">

				<!-- Event -->
				<div class="col-lg-4 event_col">
					<div class="event event_left">
						<div class="event_image"><img src="images/event_1.jpg" alt=""></div>
						<div class="event_body d-flex flex-row align-items-start justify-content-start">
							<div class="event_date">
								<div class="d-flex flex-column align-items-center justify-content-center trans_200">
									<div class="event_day trans_200">21</div>
									<div class="event_month trans_200">Aug</div>
								</div>
							</div>
							<div class="event_content">
								<div class="event_title"><a href="#">부산학원과 함께하는 <br>유아반 원어민 회화 무료청강</a></div>
								<div class="event_info_container">
									<div class="event_info"><i class="fa fa-clock-o" aria-hidden="true"></i><span>15.00 - 19.30</span></div>
									<div class="event_info"><i class="fa fa-map-marker" aria-hidden="true"></i><span>25 New York City</span></div>
									<div class="event_text">
										<p>Policy analysts generally agree on a need for reform, but not on which path...</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Event -->
				<div class="col-lg-4 event_col">
					<div class="event event_mid">
						<div class="event_image"><img src="images/event_2.jpg" alt=""></div>
						<div class="event_body d-flex flex-row align-items-start justify-content-start">
							<div class="event_date">
								<div class="d-flex flex-column align-items-center justify-content-center trans_200">
									<div class="event_day trans_200">27</div>
									<div class="event_month trans_200">Aug</div>
								</div>
							</div>
							<div class="event_content">
								<div class="event_title"><a href="#">아이디어스와 함께하는 <br>반려동물 키링만들기 행사</a></div>
								<div class="event_info_container">
									<div class="event_info"><i class="fa fa-clock-o" aria-hidden="true"></i><span>09.00 - 17.30</span></div>
									<div class="event_info"><i class="fa fa-map-marker" aria-hidden="true"></i><span>25 Brooklyn City</span></div>
									<div class="event_text">
										<p>This Consumer Action News issue covers topics now being debated before...</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Event -->
				<div class="col-lg-4 event_col">
					<div class="event event_right">
						<div class="event_image"><img src="images/event_3.jpg" alt=""></div>
						<div class="event_body d-flex flex-row align-items-start justify-content-start">
							<div class="event_date">
								<div class="d-flex flex-column align-items-center justify-content-center trans_200">
									<div class="event_day trans_200">01</div>
									<div class="event_month trans_200">Sep</div>
								</div>
							</div>
							<div class="event_content">
								<div class="event_title"><a href="#">컬러링 캔들 무료강좌</a></div>
								<div class="event_info_container">
									<div class="event_info"><i class="fa fa-clock-o" aria-hidden="true"></i><span>13.00 - 18.30</span></div>
									<div class="event_info"><i class="fa fa-map-marker" aria-hidden="true"></i><span>25 New York City</span></div>
									<div class="event_text">
										<p>Policy analysts generally agree on a need for reform, but not on which path...</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>



	<!-- Counter -->

	<div class="counter">
		<div class="counter_background"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="counter_content">
						<h2 class="counter_title">Mango에 학원 등록하고<br> 더 많은 학생을 만나보세요!</h2>
						<div class="counter_text"><p>학생들의 직접 작성된 후기들로 신뢰도 있는 망고! 웹, 모바일 둘다 사용가능해서 <br>언제 어디서든 쉽게 이용할 수 있어요! </p></div>

						<!-- Milestones -->

						<div class="milestones d-flex flex-md-row flex-column align-items-center justify-content-between">
							
							<!-- Milestone -->
							<div class="milestone">
								<div class="milestone_counter" data-end-value="100,000">0</div>
								<div class="milestone_text">학원 정보 노출 학원 수</div>
							</div>

							<!-- Milestone -->
							<div class="milestone">
								<div class="milestone_counter" data-end-value="120,000" data-sign-after="+">0</div>
								<div class="milestone_text">월 평균 방문자수</div>
							</div>

							<!-- Milestone -->
							<div class="milestone">
								<div class="milestone_counter" data-end-value="2,000" data-sign-after="+">0</div>
								<div class="milestone_text">월 후기 작성수</div>
							</div>



						</div>
					</div>

				</div>
			</div>

			<div class="counter_form">
				<div class="row fill_height">
					<div class="col fill_height">   
						<form class="counter_form_content d-flex flex-column align-items-center justify-content-center" action="#">
							<div class="counter_form_title">등록 상담 문의하기</div>
							<input type="text" class="counter_input" placeholder="성함" required="required">
							<input type="tel" class="counter_input" placeholder="연락처" required="required">
							<select name="counter_select" id="counter_select" class="counter_input counter_options">
								<option>신청인</option>
								<option>원장 선생님</option>
								<option>학원 관리자님</option>
								<option>개원을 준비중인 분</option>
							</select>
							<textarea class="counter_input counter_text_input" placeholder="전화상담 가능시간 및 내용" required="required"></textarea>
							<button type="submit" class="counter_form_button">상담접수</button>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>



	<!-- Team -->

<!-- 	<div class="team">
		<div class="team_background parallax-window" data-parallax="scroll" data-speed="0.8"></div>
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h2 class="section_title">The Best Tutors in Town</h2>
						<div class="section_subtitle"><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel gravida arcu. Vestibulum feugiat, sapien ultrices fermentum congue, quam velit venenatis sem</p></div>
					</div>
				</div>
			</div>
			<div class="row team_row">
				
				Team Item
				<div class="col-lg-3 col-md-6 team_col">
					<div class="team_item">
						<div class="team_image"><img src="images/team_1.jpg" alt=""></div>
						<div class="team_body">
							<div class="team_title"><a href="#">Jacke Masito</a></div>
							<div class="team_subtitle">Marketing & Management</div>
							<div class="social_list">
								<ul>
									<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				Team Item
				<div class="col-lg-3 col-md-6 team_col">
					<div class="team_item">
						<div class="team_image"><img src="images/team_2.jpg" alt=""></div>
						<div class="team_body">
							<div class="team_title"><a href="#">William James</a></div>
							<div class="team_subtitle">Designer & Website</div>
							<div class="social_list">
								<ul>
									<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				Team Item
				<div class="col-lg-3 col-md-6 team_col">
					<div class="team_item">
						<div class="team_image"><img src="images/team_3.jpg" alt=""></div>
						<div class="team_body">
							<div class="team_title"><a href="#">John Tyler</a></div>
							<div class="team_subtitle">Quantum mechanics</div>
							<div class="social_list">
								<ul>
									<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				Team Item
				<div class="col-lg-3 col-md-6 team_col">
					<div class="team_item">
						<div class="team_image"><img src="images/team_4.jpg" alt=""></div>
						<div class="team_body">
							<div class="team_title"><a href="#">Veronica Vahn</a></div>
							<div class="team_subtitle">Math & Physics</div>
							<div class="social_list">
								<ul>
									<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
									<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div> -->

	<!-- Latest News -->

<!-- 	<div class="news">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h2 class="section_title">Latest News</h2>
						<div class="section_subtitle"><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel gravida arcu. Vestibulum feugiat, sapien ultrices fermentum congue, quam velit venenatis sem</p></div>
					</div>
				</div>
			</div>
			<div class="row news_row">
				<div class="col-lg-7 news_col">
					
					News Post Large
					<div class="news_post_large_container">
						<div class="news_post_large">
							<div class="news_post_image"><img src="images/news_1.jpg" alt=""></div>
							<div class="news_post_large_title"><a href="blog_single.html">Here’s What You Need to Know About Online Testing for the ACT and SAT</a></div>
							<div class="news_post_meta">
								<ul>
									<li><a href="#">admin</a></li>
									<li><a href="#">november 11, 2017</a></li>
								</ul>
							</div>
							<div class="news_post_text">
								<p>Policy analysts generally agree on a need for reform, but not on which path policymakers should take. Can America learn anything from other nations...</p>
							</div>
							<div class="news_post_link"><a href="blog_single.html">read more</a></div>
						</div>
					</div>
				</div>

				<div class="col-lg-5 news_col">
					<div class="news_posts_small">

						News Posts Small
						<div class="news_post_small">
							<div class="news_post_small_title"><a href="blog_single.html">Home-based business insurance issue (Spring 2017 - 2018)</a></div>
							<div class="news_post_meta">
								<ul>
									<li><a href="#">admin</a></li>
									<li><a href="#">november 11, 2017</a></li>
								</ul>
							</div>
						</div>

						News Posts Small
						<div class="news_post_small">
							<div class="news_post_small_title"><a href="blog_single.html">2018 Fall Issue: Credit Card Comparison Site Survey (Summer 2018)</a></div>
							<div class="news_post_meta">
								<ul>
									<li><a href="#">admin</a></li>
									<li><a href="#">november 11, 2017</a></li>
								</ul>
							</div>
						</div>

						News Posts Small
						<div class="news_post_small">
							<div class="news_post_small_title"><a href="blog_single.html">Cuentas de cheques gratuitas una encuesta de Consumer Action</a></div>
							<div class="news_post_meta">
								<ul>
									<li><a href="#">admin</a></li>
									<li><a href="#">november 11, 2017</a></li>
								</ul>
							</div>
						</div>

						News Posts Small
						<div class="news_post_small">
							<div class="news_post_small_title"><a href="blog_single.html">Troubled borrowers have fewer repayment or forgiveness options</a></div>
							<div class="news_post_meta">
								<ul>
									<li><a href="#">admin</a></li>
									<li><a href="#">november 11, 2017</a></li>
								</ul>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div> -->


	
	
<!------------------------------------------------------- 스크립트 영역 ---------------------------------------------------------------------------------->

<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/greensock/TweenMax.min.js"></script>
<script src="plugins/greensock/TimelineMax.min.js"></script>
<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="plugins/greensock/animation.gsap.min.js"></script>
<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="js/custom.js"></script>
</body>
</html>