<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>Course Details</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/academy_single.css">
<link rel="stylesheet" type="text/css" href="styles/academy_single_responsive.css">

<style type="text/css">

	.cheongang {
	
		margin-top: 20px;
		width: 20%;	
		float:right;
		color: #fff !important;
		background-color: #000;
		border: none;
		padding: 10px;
		margin-bottom:10px;
		
	}

.strength{
	font-size: 18px !important;
    color:#ff6b79 !important;
    font-weight: 500 !important;
} 


.weakness {
	font-size: 18px !important;
    color: #6610f2 !important;
    font-weight: 500 !important;
}


.blind_review {
	background-image: url('images/academy/blind1.PNG');
	background-repeat: no-repeat;
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
    border-radius: 6px !important;
    box-shadow: 0px 1px 10px rgba(29,34,47,0.1) !important;
} 

.course_container{
	border: 1px solid #d0cdcd;
    border-radius: 20px;
    padding: 30px;

}

.sidebar {
    width: 100%;
    padding-left: 40px;
    padding-top: 120px;
    border-radius: 10px;
    border: 1px solid #e2e2e2;
} 

</style>

<%
	
	request.setCharacterEncoding("utf-8");
%>
</head>
<body>



	<!-- Course -->

	<div class="course">
		<div class="container">
			<div class="row">

				<!-- Course -->
				<div class="col-lg-8">
					
					<div class="course_container">
					
						<div class="aca_profile_div" style="display: inline-block;">
							<img src="images/etc/default_mango.png" class="aca_profile_img" width="50">
						</div>					
						<div class="course_title">부산학원</div> 
						<div class="aca_like_button">
						<!---------- 학원 좋아요 버튼 -------------->
							<img src="images/like/like_full.png" width="25">
							<img src="images/like/like_empty.png" width="30">
						<!---------- 학원 좋아요 버튼 -------------->
						</div>
						<div class="course_info_title"><i class="fa fa-map-marker" aria-hidden="true"></i>&nbsp; 부산광역시 부산진구 부전동 동천로 109</div>
						<div class="course_info_title"><i class="fa fa-phone" aria-hidden="true"></i>&nbsp; 051-111-2222</div>
						<div class="cheongang tab_panel_registerBtn"
							 onclick="location.href='4index.jsp?center=O_academy/academy_audit.jsp'"
						>
						청강신청하기
						</div>
						<div class="course_info d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start">



							<!-- Course Info Item -->
							<div class="course_info_item">
								<div class="course_info_title">평점</div>
								<div class="rating_r rating_r_4"><i></i><i></i><i></i><i></i><i></i></div>
							</div>

							<!-- Course Info Item -->
							<div class="course_info_item">
								<div class="course_info_title">카테고리 대분류</div>
								<div class="course_info_text"><a href="#">외국어</a></div>
							</div>
							
							<!-- Course Info Item -->
							<div class="course_info_item">
								<div class="course_info_title">카테고리 소분류</div>
								<div class="course_info_text"><a href="#">영어</a></div>
							</div>

						</div>

						<!-- Course Image -->
						<div class="course_image">
						<img src="images/etc/default_mango.png" width="200">
							<p>등록된 이미지가 없네요. <br>학원 이미지를 올려보세요!</p>
						
						</div>

						<!-- Course Tabs -->
						<div class="course_tabs_container">
							<div class="tabs d-flex flex-row align-items-center justify-content-start">
								<div class="tab active">학원 상세정보</div>
								<div class="tab">커리큘럼</div>
								<div class="tab">후기보기</div>
							</div>
							
							<div class="tab_panels">

								<!-- Description -->
								<div class="tab_panel active">
								
								<!-- 등록되지 않은 학원일 경우 -->
									<div class="tab_panel_title">이 학원의 관리자이신가요?</div>
									<div class="tab_panel_content">
										<div class="tab_panel_text">
											<p>학원 관리자 등록을 통해 학원페이지를 관리하실 수 있습니다</p>
										</div>
									<div class="tab_panel_registerBtn"
										 onclick="location.href='4index.jsp?center=academy/academy_register.jsp'">등록하기</div>
										
										
 										<div class="tab_panel_section">
											<div class="tab_panel_subtitle">Requirements</div>
											<ul class="tab_panel_bullets">
												<li>Lorem Ipsn gravida nibh vel velit auctor aliquet. Class aptent taciti sociosquad litora torquent.</li>
												<li>Cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a.</li>
												<li>Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non mauris vitae erat consequat.</li>
												<li>Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio.</li>
											</ul>
										</div>
										<div class="tab_panel_section">
											<div class="tab_panel_subtitle">What is the target audience?</div>
											<div class="tab_panel_text">
												<p>This course is intended for anyone interested in learning to master his or her own body.This course is aimed at beginners, so no previous experience with hand balancing skillts is necessary Aenean viverra tincidunt nibh, in imperdiet nunc. Suspendisse eu ante pretium, consectetur leo at, congue quam. Nullam hendrerit porta ante vitae tristique. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae.</p>
											</div>
										</div>
										 
										 
										<!-- FAQ -->
 										<div class="tab_panel_faq">
											<div class="tab_panel_title">FAQ</div>

											Accordions
											<div class="accordions">
												
												<div class="elements_accordions">

													<div class="accordion_container">
														<div class="accordion d-flex flex-row align-items-center"><div>Can I just enroll in a single course?</div></div>
														<div class="accordion_panel">
															<p>Lorem ipsun gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a.</p>
														</div>
													</div>

													<div class="accordion_container">
														<div class="accordion d-flex flex-row align-items-center active"><div>I'm not interested in the entire Specialization?</div></div>
														<div class="accordion_panel">
															<p>Lorem ipsun gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a.</p>
														</div>
													</div>

													<div class="accordion_container">
														<div class="accordion d-flex flex-row align-items-center"><div>What is the refund policy?</div></div>
														<div class="accordion_panel">
															<p>Lorem ipsun gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a.</p>
														</div>
													</div>

													<div class="accordion_container">
														<div class="accordion d-flex flex-row align-items-center"><div>What background knowledge is necessary?</div></div>
														<div class="accordion_panel">
															<p>Lorem ipsun gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a.</p>
														</div>
													</div>

													<div class="accordion_container">
														<div class="accordion d-flex flex-row align-items-center"><div>Do i need to take the courses in a specific order?</div></div>
														<div class="accordion_panel">
															<p>Lorem ipsun gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a.</p>
														</div>
													</div>

												</div>

											</div> 
										</div>
									</div>
								</div>

								<!-- Curriculum -->
								

								
								
								
								<div class="tab_panel tab_panel_2">
									<!-- 등록된 커리큘럼이 없을 경우 -->
								<div class="tab_panel_title">아직 등록된 커리큘럼이 없습니다.</div>
									<div class="tab_panel_content">
										<div class="tab_panel_text">
											<p>학원을 등록하고 커리큘럼을 등록해보세요!</p>
										</div>
									<div class="tab_panel_registerBtn">등록하기</div>

											<!-- Dropdowns -->
											<ul class="dropdowns">
												<li class="has_children">
													<div class="dropdown_item">
														<div class="dropdown_item_title"><span>Lecture 1:</span> Lorem Ipsn gravida nibh vel velit auctor aliquet.</div>
														<div class="dropdown_item_text">
															<p>Lorem Ipsn gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus.</p>
														</div>
													</div>
													<ul>
														<li>
															<div class="dropdown_item">
																<div class="dropdown_item_title"><span>Lecture 1.1:</span> Lorem Ipsn gravida nibh vel velit auctor aliquet.</div>
																<div class="dropdown_item_text">
																	<p>Lorem Ipsn gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus.</p>
																</div>
															</div>
														</li>
														<li>
															<div class="dropdown_item">
																<div class="dropdown_item_title"><span>Lecture 1.2:</span> Lorem Ipsn gravida nibh vel velit auctor aliquet.</div>
																<div class="dropdown_item_text">
																	<p>Lorem Ipsn gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus.</p>
																</div>
															</div>
														</li>
													</ul>
												</li>
												<li class="has_children">
													<div class="dropdown_item">
														<div class="dropdown_item_title"><span>Lecture 2:</span> Lorem Ipsn gravida nibh vel velit auctor aliquet.</div>
														<div class="dropdown_item_text">
															<p>Lorem Ipsn gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus.</p>
														</div>
													</div>
													<ul>
														<li>
															<div class="dropdown_item">
																<div class="dropdown_item_title"><span>Lecture 2.1:</span> Lorem Ipsn gravida nibh vel velit auctor aliquet.</div>
																<div class="dropdown_item_text">
																	<p>Lorem Ipsn gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus.</p>
																</div>
															</div>
														</li>
														<li>
															<div class="dropdown_item">
																<div class="dropdown_item_title"><span>Lecture 2.2:</span> Lorem Ipsn gravida nibh vel velit auctor aliquet.</div>
																<div class="dropdown_item_text">
																	<p>Lorem Ipsn gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus.</p>
																</div>
															</div>
														</li>
													</ul>
												</li>
												<li>
													<div class="dropdown_item">
														<div class="dropdown_item_title"><span>Lecture 3:</span> Lorem Ipsn gravida nibh vel velit auctor aliquet.</div>
														<div class="dropdown_item_text">
															<p>Lorem Ipsn gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus.</p>
														</div>
													</div>
												</li>
												<li>
													<div class="dropdown_item">
														<div class="dropdown_item_title"><span>Lecture 4:</span> Lorem Ipsn gravida nibh vel velit auctor aliquet.</div>
														<div class="dropdown_item_text">
															<p>Lorem Ipsn gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus.</p>
														</div>
													</div>
												</li>
												<li>
													<div class="dropdown_item">
														<div class="dropdown_item_title"><span>Lecture 5:</span> Lorem Ipsn gravida nibh vel velit auctor aliquet.</div>
														<div class="dropdown_item_text">
															<p>Lorem Ipsn gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auci elit consequat ipsutis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus.</p>
														</div>
													</div>
												</li>
											</ul>
										</div>
									</div>
								</div>



								<!-- Reviews -->
								<div class="tab_panel tab_panel_3">
									<div class="tab_panel_title">후기 보기</div>

									<!-- Rating -->
									<div class="review_rating_container">
										<div class="review_rating">
											<div class="review_rating_num">4.5</div>
											<div class="review_rating_stars">
												<div class="rating_r rating_r_4"><i></i><i></i><i></i><i></i><i></i></div>
											</div>
											<div class="review_rating_text">28 개의 평가</div>
										</div>
										<div class="review_rating_bars">
											<ul>
												<li><span>5 Star</span><div class="review_rating_bar"><div style="width:90%;"></div></div></li>
												<li><span>4 Star</span><div class="review_rating_bar"><div style="width:75%;"></div></div></li>
												<li><span>3 Star</span><div class="review_rating_bar"><div style="width:32%;"></div></div></li>
												<li><span>2 Star</span><div class="review_rating_bar"><div style="width:10%;"></div></div></li>
												<li><span>1 Star</span><div class="review_rating_bar"><div style="width:3%;"></div></div></li>
											</ul>
										</div>
									</div>
									
								<!-- 등록된 후기가 없을 경우 -->
								
								<div class="tab_panel_title">(등록된후기 없으면)아직 등록된 후기가 없습니다.</div>
									<div class="tab_panel_content">
										<div class="tab_panel_text">
											<p>이 학원의 후기를 작성해 보세요!</p>
										</div>
									<div class="tab_panel_registerBtn"
										 onclick="location.href='4index.jsp?center=O_academy/academy_review_write.jsp'">후기 쓰기</div>
									
									
									
									<!-- Comments -->
									<div class="comments_container">
										<ul class="comments_list">
										
										<!--------------------------------  ▼ 후기 1개 영역-------------------------------------->
											<li>
												<div class="comment_item d-flex flex-row align-items-start jutify-content-start">
													<div class="comment_image"><div><img src="images/comment_1.jpg" alt=""></div></div>
													<div class="comment_content">
														<div class="comment_title_container d-flex flex-row align-items-center justify-content-start">
															<div class="comment_author"><a href="#">주차장이 있어서 편리해요.</a></div>
															<div class="comment_rating"><div class="rating_r rating_r_4"><i></i><i></i><i></i><i></i><i></i></div></div>
															<div class="comment_time ml-auto">2020-09-15</div>
														</div>
														<div class="comment_text">
															결제안한 회원에게 보이는 형태
															<div class="blind_review" width="500">
															<div class="blind_top_div" width="450">
															<!-- 유료회원이면 보이는 형태 -->
															
																<p><span class="strength">장점</span><br>
																	There are many variations of passages of Lorem Ipsum available, 
																</p>
																<p><span class="weakness">단점</span><br>
																	There are many variations of passages of Lorem Ipsum a 
																	but the majority have alteratio
																	There are many variations of passages of Lorem Ipsum a
																	but the majority have alteration in some form, by injected hum
																</p>
															
															</div>
														
														</div>
														<div class="comment_extras d-flex flex-row align-items-center justify-content-start">
														
														
														<!-- 만일 해당 계정으로 도움돼요 했다면 색칠해진 아이콘 -->
															<div class="comment_extra comment_likes"><a href="#"><img src="images/thumb-up.png" width="30"><span>15</span></a></div>
														</div>
													</div>
												</div>
											</li>
										<!--------------------------------  ▲ 후기 1개 영역-------------------------------------->
											
										<!--------------------------------  ▼ 후기 1개 영역-------------------------------------->
											<li>
												<div class="comment_item d-flex flex-row align-items-start jutify-content-start">
													<div class="comment_image"><div><img src="images/comment_1.jpg" alt=""></div></div>
													<div class="comment_content">
														<div class="comment_title_container d-flex flex-row align-items-center justify-content-start">
															<div class="comment_author"><a href="#">주차장이 있어서 편리해요.</a></div>
															<div class="comment_rating"><div class="rating_r rating_r_4"><i></i><i></i><i></i><i></i><i></i></div></div>
															<div class="comment_time ml-auto">2020-09-15</div>
														</div>
														<div class="comment_text">
															결제안한 회원에게 보이는 형태
															<p><img src="images/academy/blind1.PNG" width="500"></p>
															유료회원이면 보이는 형태
															<p><span class="strength">장점</span><br>
																There are many variations of passages of Lorem Ipsum available, 
															</p>
															<p><span class="weakness">단점</span><br>
																There are many variations of passages of Lorem Ipsum a 
																but the majority have alteratio
																There are many variations of passages of Lorem Ipsum a
																but the majority have alteration in some form, by injected hum
															</p>
														
														</div>
														<div class="comment_extras d-flex flex-row align-items-center justify-content-start">
														
														
														<!-- 만일 해당 계정으로 도움돼요 한 적 없다면 색칠 안 된 아이콘 -->
													    <div class="comment_extra comment_likes"><a href="#"><img src="images/thumb-notup.png" width="30" ><span></i><span>15</span></a></div>
														</div>
													</div>
												</div>
											</li>
										<!--------------------------------  ▲ 후기 1개 영역-------------------------------------->
											
											
											
										</ul>
										<div class="add_comment_container">
											<div class="add_comment_title">후기쓰기</div>
											<div class="add_comment_text">후기 작성은 <a href="4index.jsp?center=O_member/member_sign_in.jsp">로그인</a> 후 가능합니다.</div>
										</div>
									</div>
								</div>
							</div> <!-- 3번째 탭 후기 마지막 태그-->
							
							

							
						</div> <!-- 전체 탭 마지막 태그-->
					</div>
				</div>
<!-------------------------------------------[ 학원 대표 키워드 ]-------------------------------------------------------------->
				<!-- Course Sidebar -->
				<div class="col-lg-4">
					<div class="sidebar">

						<!-- Feature -->
						<div class="sidebar_section">
							<div class="sidebar_section_title">학원을 대표하는 키워드</div>
							<div class="sidebar_feature">
								<div class="course_price">"교통이 편리한 중심지"</div>

								<!-- Features -->
								<div class="feature_list">

									<!-- Feature -->
									<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-subway" aria-hidden="true"></i>
											<span>교통이 편리한</span>
										</div>
									</div>

									<!-- Feature -->
									<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-university" aria-hidden="true"></i>
											<span>시설이 깨끗한</span>
										</div>
									</div>

									<!-- Feature -->
									<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-eye" aria-hidden="true"></i>
											<span>청강신청이 가능한</span>
										</div>
									</div>

									<!-- Feature -->
									<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-cubes" aria-hidden="true"></i>
											<span>스터디룸이 있는</span>
										</div>
									</div>

									<!-- Feature -->
									<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-cutlery" aria-hidden="true"></i>
											<span>식당가 인근</span>
										</div>
									</div>
									
									<!-- Feature -->
									<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-building-o" aria-hidden="true"></i>
											<span>기숙사 있는</span>
										</div>
									</div>

									<!-- Feature -->
									<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-clock-o" aria-hidden="true"></i>
											<span>중장기(6개월)</span>
										</div>
									</div>

									<!-- Feature -->
									<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-bus" aria-hidden="true"></i>
											<span>학원 차량 운행이 있는</span>
										</div>
									</div>

									<!-- Feature -->
									<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-file-text-o" aria-hidden="true"></i>
											<span>레벨 테스트가 있는</span>
										</div>
									</div>

									<!-- Feature -->
									<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-graduation-cap" aria-hidden="true"></i>
											<span>수능 대비 강의가 있는</span>
										</div>
									</div>

								</div>
							</div>
						</div>



						<!-- Latest Course -->
<!-- 						<div class="sidebar_section">
							<div class="sidebar_section_title">Latest Courses</div>
							<div class="sidebar_latest">

								Latest Course
								<div class="latest d-flex flex-row align-items-start justify-content-start">
									<div class="latest_image"><div><img src="images/latest_1.jpg" alt=""></div></div>
									<div class="latest_content">
										<div class="latest_title"><a href="course.html">How to Design a Logo a Beginners Course</a></div>
										<div class="latest_price">Free</div>
									</div>
								</div>

								Latest Course
								<div class="latest d-flex flex-row align-items-start justify-content-start">
									<div class="latest_image"><div><img src="images/latest_2.jpg" alt=""></div></div>
									<div class="latest_content">
										<div class="latest_title"><a href="course.html">Photography for Beginners Masterclass</a></div>
										<div class="latest_price">$170</div>
									</div>
								</div>

								Latest Course
								<div class="latest d-flex flex-row align-items-start justify-content-start">
									<div class="latest_image"><div><img src="images/latest_3.jpg" alt=""></div></div>
									<div class="latest_content">
										<div class="latest_title"><a href="course.html">The Secrets of Body Language</a></div>
										<div class="latest_price">$220</div>
									</div>
								</div>

							</div>
						</div> --> <!-- 지울것 --> 

					</div>
				</div>
			</div>
		</div>
	</div>



<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="js/course.js"></script>
</body>
</html>