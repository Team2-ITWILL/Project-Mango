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
        margin: 1% auto; /* 15% from the top and centered */
        padding: 20px;
        border: 1px solid #888;
        width: 30%;
    }
    
    .modal_close{
    	cursor:pointer;
    	background-color:#DDDDDD;
    	text-align: center;
    	padding-bottom: 6px;
    	padding-top: 6px;
    	margin-top: 12px;
    }
	
	.modal-content h6{
		margin: 10px auto;
		font-weight: bold;
		color: #e95765;
	}
	
	.modal-content h4{
		margin: 0 auto;
		margin-bottom: 8px;
		font-weight: bolder;
		color: #6610f2;
	}
	
	#notice_content{
		color: #76777a;
	}
	

</style>

<script>
	$(document).ready(function(){
		
		// 후기 top3 출력
		var topReviewList = document.querySelectorAll(".course_body");
		
		if(topReviewList != null){
			for(var i=0;i<topReviewList.length;i++){
				var obj= (topReviewList[i].id.substr(topReviewList[i].id.indexOf("_")+1));
				reviewTop(obj);
			}
		} 
		
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
			
			$(".sel3").append("<option value='s3'>읍/면/동</option>");
			
			$.getJSON("getListSearchOne.aca?search1="+search1 ,  function(data){
				
				console.log(data.address);
				
				
				var select2="<option option value='s2'>시/군/구</option>";
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
				
				
				var select3="<option value='s3'>읍/면/동</option>";
				
				$.each(data.address , function (index,item) {
					
					select3+="<option value='"+item.search3+"'>"+item.search3+"</option>";
			
				});
				
				
				
				$(".sel3").append(select3);
		
		
			});//getJSON
		
		});//change
		
		
		
		
	
		
		      
	})
	
	
	/* 팝업  */
    $(window).load(function() {
        if (cookiedata.indexOf("maindiv=done") < 0) {
            $('#myModal').show();
        };
    });
		
    //쿠키 셋팅
    function setCookie(name, value, expiredays) {
        var todayDate = new Date();
        todayDate.setDate(todayDate.getDate() + expiredays);
        document.cookie = name + "=" + escape(value) + "; path=/; expires=" + todayDate.toGMTString() + ";"
    }

    //체크하고 닫을시 쿠키 생성후 팝업 히든
    function close_pop() {
        $('#myModal').hide();
        if (document.pop_form.chkbox.checked) {
            setCookie("maindiv", "done", 1);
        }
        document.all['myModal'].style.visibility = "hidden";
    }
    
    /* 팝업 끝  */
    
    // 후기Top3 
    
    function reviewTop(obj){
    	
    	var _data = '{"num":"'+obj+'"}';
    	
    	$.ajax({
    		type : "post",
    		url : "${pageContext.request.contextPath}/reviewTop",
    		data : {data : _data},
    		success:function(data,status){
    			var json = JSON.parse(data);
    			var acaName = json.acaName;
    			var acaMainNum = json.acaMainNum;
    			var avgScore = json.avgScore;
    			var rankNum = json.num;
    			var revCnt = json.revCnt;
    			var title1 = json.title1;
    			var title2 = json.title2;
    			
    			console.log(data);
    			document.getElementById("nameRank_"+rankNum).innerText = acaName;
    			document.getElementById("nameRank_"+rankNum).setAttribute('href','AcademyContentAction.aca?acaMainNum='+acaMainNum+'&pageNum=1')
    			document.getElementById("Rank_"+rankNum+"_title_1").innerText = title1;
    			document.getElementById("Rank_"+rankNum+"_title_2").innerText = title2;
    			document.getElementById("reviewCnt_"+rankNum).innerHTML = " "+revCnt+"개";
    			document.getElementById("avgScore_"+rankNum).innerText = avgScore;
    		},
    		error:function(){
    			alert("통신에러가 발생했습니다.");
    		}
    		
    	});
    	
    }


    
    
    
    
    $(function(){
    
	$(".home_search_button").click(function(){
		
		var research="AcademySearchList.aca?";
		
		var Mainsearch1=$("#add1 option:selected").val();
		var Mainsearch2=$(".sel2 option:selected").val();
        var Mainsearch3=$(".sel3 option:selected").val();
        var Mainsearch5=$("#basic").val();
		var mainsearch = $(".home_search_input").val();
		
		
		research+="select5="+Mainsearch5+"&";
		
		if(Mainsearch1 != "s1" || Mainsearch2 != "s2" ||Mainsearch3 != "s3"||mainsearch !=""){
		
			
		if(Mainsearch1 != "s1"){
			
			
			research+="select1="+Mainsearch1+"&";
			
		}
		if(Mainsearch2 != "s2"){
			
			research+="select2="+Mainsearch2+"&";
			
		}
		if(Mainsearch3 != "s3"){
			
			research+="select3="+Mainsearch3+"&";
			
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
	
    
    });
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

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
			            <div class="modal_close">
			            	<form name="pop_form">
			                <label for="popChk" id="todayClose" style="font-size:0.8em;">오늘 하루동안 보지 않기
			                <input type="checkbox" name="chkbox" value="checkbox" id="popChk" >
			                <br>
			                	<a href="#" onclick="close_pop()">
			                	<span class="pop_bt">
			                	닫기
			                	</span>
			                	</a>
			                </label>
			                </form>
			            </div>
			      </div>
			 
			    </div>
			        <!--End Modal-->
			<!-- Home Slider -->
			<div class="owl-carousel owl-theme home_slider">
				
				<!-- Home Slider Item -->
				<div class="owl-item">
					<div class="home_slider_background">
					      <video muted autoplay loop style="z-index: 999; width: 100%;">
					        <source src="images/etc/main_video4.mp4" type="video/mp4">
					        <strong>Your browser does not support the video tag.</strong>
					      </video>
					</div>
					<div class="home_slider_content">
						<div class="container">
							<div class="row">
								<div class="col text-center">
									<div class="home_slider_title resp767Title">우리동네 학원을 찾아보세요.</div>
									<div class="home_slider_subtitle">당신의 숨은 재능과 잠재력을 찾으러 갈 시간이에요.</div>
									<div class="home_slider_form_container">
										<form action="AcademySearchList.aca" id="home_search_form_1" method="post" class="home_search_form d-flex flex-lg-row flex-column align-items-center justify-content-between">
												<input type="hidden" name="select5" value="basic" id="basic">
											<div class="d-flex flex-row align-items-center justify-content-start">
												<input type="text" class="home_search_input" placeholder="검색하기" name="mainsearch">
												<select class="dropdown_item_select home_search_input" id="add1" name="select1">
													<option value="s1">시/도</option>
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
													<option value="s2">시/군/구</option>
													
												</select>
												<select class="dropdown_item_select home_search_input sel3"  name="select3">
													<option value="s3">읍/면/동</option>
												
												</select>
											</div>
											<button type="button" class="home_search_button">search</button>
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

	
<!-- 	<div class="home_slider_nav home_slider_prev left"><i class="fa fa-angle-left " aria-hidden="true"></i></div>
	<div class="home_slider_nav home_slider_next right"><i class="fa fa-angle-right" aria-hidden="true"></i></div>  -->
		
	</div>


	<%-- TOP3 --%>
	<div class="courses">
		<div class="section_background parallax-window" data-parallax="scroll" data-speed="0.8"></div>
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h2 class="section_title">인기 많은 학원 TOP 3 </h2>
						<div class="section_subtitle"><p>리뷰 수가 가장 많고 학원 평점 순위가 가장 높은 순서대로 노출됩니다.</p></div>
					</div>
				</div>
			</div>
			<div class="row courses_row">
				
				<!-- Course -->
				<div class="col-lg-4 course_col">
					<div class="course_1">
						<div class="course_image"><img src="images/academy/topaca1.jpg"></div>
						<div class="course_body" id="topReview_1">
							<h3 class="course_title"><a href="#" id="nameRank_1"></a></h3>
							<div class="course_text">
							<%-- 후기 한줄요약 노출 (" 쌍따옴표 안에 데이터넣기  ")  --%>
							<%-- 너무 길어서 줄바꿈 표시되면 그냥 ... 으로 표시되게 하기 --%>
								<span id="Rank_1_title_1"></span> <%-- 장점 --%>
								<br><span id="Rank_1_title_2"></span>   <%-- 단점 --%>
							</div>
						</div>
						<div class="course_footer">
							<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
								<div class="course_info">
									<i class="fa fa-graduation-cap" aria-hidden="true"></i>
									리뷰수(후기수)<span id="reviewCnt_1"></span>
								</div>
								<div class="course_info">
									<i class="fa fa-star" aria-hidden="true"></i>
									평균 별점 <span id="avgScore_1"></span>
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
						<div class="course_body" id="topReview_2">
							<h3 class="course_title"><a href="#" id="nameRank_2"></a></h3>
							<div class="course_text">
							<%-- 후기 한줄요약 노출 (" 쌍따옴표 안에 데이터넣기  ")  --%>
							<%-- 너무 길어서 줄바꿈 표시되면 그냥 ... 으로 표시되게 하기 --%>
								<span id="Rank_2_title_1"></span> <%-- 장점 --%>
								<br><span id="Rank_2_title_2"></span>   <%-- 단점 --%>
							</div>
						</div>
						<div class="course_footer">
							<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
								<div class="course_info">
									<i class="fa fa-graduation-cap" aria-hidden="true"></i>
									리뷰수(후기수)<span id="reviewCnt_2"></span>
								</div>
								<div class="course_info">
									<i class="fa fa-star" aria-hidden="true"></i>
									평균 별점 <span id="avgScore_2"></span>
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
						<div class="course_body" id="topReview_3">
							<h3 class="course_title"><a href="#" id="nameRank_3"></a></h3>
							<div class="course_text">
							<%-- 후기 한줄요약 노출 (" 쌍따옴표 안에 데이터넣기  ")  --%>
							<%-- 너무 길어서 줄바꿈 표시되면 그냥 ... 으로 표시되게 하기 --%>
								<span id="Rank_3_title_1"></span> <br> 
								<span id="Rank_3_title_2"></span>
							</div>
						</div>
						<div class="course_footer">
							<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
								<div class="course_info">
									<i class="fa fa-graduation-cap" aria-hidden="true"></i>
									리뷰수(후기수)<span id="reviewCnt_3"></span>
								</div>
								<div class="course_info">
									<i class="fa fa-star" aria-hidden="true"></i>
									평균 별점 <span id="avgScore_3"></span>
								</div>
								<div class="course_price ml-auto"></div>
							</div>
						</div>
					</div>
				</div>
				
			<%-- TOP3 끝--%>	

			</div>
			<div class="row">
				<div class="col">
					<div class="courses_button trans_200">
						<a href="./AcademyList.aca">더 많은 인기학원 보기</a>
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
									<div class="event_month trans_200">Sep</div>
								</div>
							</div>
							<div class="event_content">
								<div class="event_title"><a href="#">부산학원과 함께하는 <br>유아반 원어민 회화 무료청강</a></div>
								<div class="event_info_container">
									<div class="event_info"><i class="fa fa-clock-o" aria-hidden="true"></i><span>15.00 - 19.30</span></div>
									<div class="event_info"><i class="fa fa-map-marker" aria-hidden="true"></i><span>25 New York City</span></div>
									<div class="event_text">
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
									<div class="event_month trans_200">Sep</div>
								</div>
							</div>
							<div class="event_content">
								<div class="event_title"><a href="#">아이디어스와 함께하는 <br>반려동물 키링만들기 행사</a></div>
								<div class="event_info_container">
									<div class="event_info"><i class="fa fa-clock-o" aria-hidden="true"></i><span>09.00 - 17.30</span></div>
									<div class="event_info"><i class="fa fa-map-marker" aria-hidden="true"></i><span>25 Brooklyn City</span></div>
									<div class="event_text">
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
									<div class="event_day trans_200">15</div>
									<div class="event_month trans_200">Sep</div>
								</div>
							</div>
							<div class="event_content">
								<div class="event_title"><a href="#">컬러링 캔들 무료강좌</a></div>
								<div class="event_info_container">
									<div class="event_info"><i class="fa fa-clock-o" aria-hidden="true"></i><span>13.00 - 18.30</span></div>
									<div class="event_info"><i class="fa fa-map-marker" aria-hidden="true"></i><span>25 New York City</span></div>
									<div class="event_text">
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
					  
						<form class="counter_form_content d-flex flex-column align-items-center justify-content-center" action="./SendMail" method="post">
							<div class="counter_form_title">등록 상담 문의하기</div>
							
							<input type="text" class="counter_input" name = "counter_name" placeholder="성함" required="required">
							<input type="text" class="counter_input" name = "counter_tel" placeholder="연락처" required="required">
							
							<select name="counter_select" id="counter_select" class="counter_input counter_options">
								<option>신청인</option>
								<option>원장 선생님</option>
								<option>학원 관리자님</option>
								<option>개원을 준비중인 분</option>
							</select>
							
							<textarea name = "counter_content" class="counter_input counter_text_input" placeholder="전화상담 가능시간 및 내용" required="required"></textarea>
							<button type="submit" class="counter_form_button">상담접수</button>
							
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>





 
 
    <!-- 오늘하루 이창을 열지 않음 2-->
    <script language="Javascript">
        cookiedata = document.cookie;
        if (cookiedata.indexOf("maindiv=done") < 0) {
            document.all['myModal'].style.visibility = "visible";
        } else {
            document.all['myModal'].style.visibility = "hidden";
        }
 
    </script>

	
	
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