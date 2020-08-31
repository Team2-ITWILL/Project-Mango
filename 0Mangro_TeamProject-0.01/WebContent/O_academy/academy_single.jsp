<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
<title>Course Details</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-latest.min.js"></script>

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
	clear : both;
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

.cnt_Like{
 	color: #76777a;
 	font-size: 0.8em;
 	padding-top: 5px;
 	margin-left: 3px;
}

.blind_top_div{
	height: 450px;
}

.no_membership{
	border: 1px solid #6610f2;
    color: #000000 !important;
    background-color : #ffffff;
    font-size: 0.9em;
	width: 360px;
    display: block;
    margin: auto;
    padding : 10px;
    
    text-align: center;
    top: 180px;
    border-radius: 5px;
}

.review_login{
	color: #fff !important;
	border-radius: 5px;
	width : 180px;
	height : 40px;
	text-align: center;
	padding : 5px;
	background-color: #6610f2;
	margin : 10px auto;
	cursor: pointer;
}
.review_btn{
	color: #fff !important;
	border-radius: 5px;
	border : none;
	width : 50px;
	padding : 5px;
	float : right;
	background-color: #6610f2;
	cursor: pointer;
	margin : 0 4px;
}
#mapReport{
	margin-top: 60px;
}
</style>

<%
	
	request.setCharacterEncoding("utf-8");
	String contextPath = request.getContextPath();

	//request.setAttribute("email", "coke@naver.com");
	
%>


	<script type="text/javascript">
		
		$(document).ready(function(){
			var likeList = document.querySelectorAll(".cnt_Like");
			
			console.log("${id_email}");
			checkLikedAca();
			
			if(likeList != null){
				for(var i=0; i<likeList.length; i++) {
					var obj = (likeList[i].id.substr(likeList[i].id.indexOf("_")+1));
					getLikeReviewImg(obj);
					
				}
			}
			
			mainKeyword();
		});
		
		// 대표키워드
		function mainKeyword(){
			var keyword = document.querySelector(".feature_title").getElementsByTagName("span")[0].textContent;
			console.log(keyword);
			if(keyword != null){
				document.querySelector(".course_price").innerText = keyword + " 학원";
			}
		}
		
		// 후기삭제(ajax)
		function reviewDelete(reviewNum){
			
			var result = confirm("후기를 삭제하시겠습니까?");
			var email = "${id_email}";
			var _data = '{"email":"'+email+'","revNum":"'+reviewNum+'"}';
			console.log(reviewNum);
			if(result){
				
				$.ajax({
					
					type : "post",
					url : "${pageContext.request.contextPath}/acaReviewDelete",
					data : {data : _data},
					success : function(data,status){
						var json = JSON.parse(data);
						var check = json.check;
						
						/* 삭제성공 */
						if(check == 1){
							var str = "<div class='alert'>후기가 삭제되었습니다.</div>";						
							$("#reviewNum_" + reviewNum).html(str).fadeOut(3000, function(){
								$(this).remove();
								if(document.querySelector(".comments_list").childElementCount == 0){
									
									var emptyList = '';
									
									emptyList += '<div class="tab_panel_title">아직 등록된 후기가 없습니다.</div>';
									emptyList += '<div class="tab_panel_content">';
									emptyList += '<div class="tab_panel_text">';
									emptyList += '<p>이 학원의 후기를 작성해 보세요!</p>';
									emptyList += '</div>';
									emptyList += '<c:if test="${id_email eq null || id_eamil eq ''}">';
									emptyList += '<div class="add_comment_text">후기 작성은 <a href="4index.jsp?center=O_member/member_sign_in.jsp">로그인</a> 후 가능합니다.</div>';
									emptyList += '</c:if>';
									
									
									
									$(".comments_list").append(emptyList);
								}
							});
						}
						/* 삭제실패 */
						else {
							alert("삭제를 실패하였습니다.\n 다시 시도해주세요.")
						}
					},
					error : function(){
						alert("통신오류가 발생했습니다.");
					}
					
						
				});
			}
		
		}
 
		function likeAcademy(){
			
			var email = "${id_email}";
			var acaMainNum = "${academyBean.acaMainNum }";
			var acaName = "${academyBean.acaName }";
			var _info = '{"email":"'+email+'","acaMainNum":"'+acaMainNum+'","acaName":"'+acaName+'"}';
			
			if(email.length == 0 || email == null){
				alert("로그인이 필요합니다.");
				return;
			}
			
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/likeAcademy",
				data : {info : _info},
				success:function(data,status){
					var json = JSON.parse(data);
					var result = json.result;
					
					if(result == 1){
						var str = '<img src="images/like/like_full.png" width="25" onclick="likeAcademy()">';
						
						document.getElementById("likeAcademy").innerHTML = str;
					} else if(result == 0){
						
						var str = '<img src="images/like/like_empty.png" width="25" onclick="likeAcademy()">';
						
						document.getElementById("likeAcademy").innerHTML = str;
					} else {
						alert("에러가 발생하였습니다.\n다시 시도해주세요.")
					}
				},
				error:function(){
					alert("통신오류가 발생했습니다.");
				}
			});
		}
		
		function checkLikedAca(){
			
			var email = "${id_email}";
			var acaMainNum = "${academyBean.acaMainNum }";
			var acaName = "${academyBean.acaName }";
			var _info = '{"email":"'+email+'","acaMainNum":"'+acaMainNum+'","acaName":"'+acaName+'"}';
			
			/* 
			<div class="aca_like_button">
				<!---------- 학원 좋아요 버튼 -------------->
					<img src="images/like/like_full.png" width="25">
					<img src="images/like/like_empty.png" width="30">
				<!---------- 학원 좋아요 버튼 -------------->
			</div>
			*/
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/checkLikedAca",
				data : {info : _info},
				success:function(data,status){
					var json = JSON.parse(data);
					var result = json.result;
					
					if(result == 1){
						var str = '<img src="images/like/like_full.png" width="25" onclick="likeAcademy()">';
						
						document.getElementById("likeAcademy").innerHTML = str;
					} else{
						
						var str = '<img src="images/like/like_empty.png" width="25" onclick="likeAcademy()">';
						
						document.getElementById("likeAcademy").innerHTML = str;
					}
				},
				error:function(){
					alert("통신오류가 발생했습니다.");
				}
			});
		}
		
		function getLikeReviewImg(obj){
			
			var email = "${id_email}";
			
			var _data = '{"email":"'+email+'","revNum":"'+obj+'"}';
			
			
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/getLikedAcaRev",
				data : {data : _data},
				success:function(data,status){
					var json = JSON.parse(data);
					var count = json.count;
					var check = json.check;
					var revNum = json.revNum;
					var email = json.email;
					document.getElementById("cntLike_"+revNum).innerText = count;
					
					if(check == 1){
						document.getElementById("cntLikeImg_"+revNum).src="images/thumb-up.png";
					}else{
						document.getElementById("cntLikeImg_"+revNum).src="images/thumb-notup.png";
					}
				},
				error : function(){
					alert("통신에러가 발생했습니다.");
				}
			});
		}
			
		
		function likeAcaReview(obj) {
			
			/* 
			thumb-notup.png 좋아요X(클릭시 좋아요)
			thumb-up.png 좋아요반영(클릭시 좋아요취소)
			<div class="comment_extra comment_likes"><a href="#"><img src="images/thumb-notup.png" width="30" ><span></i><span>15</span></a></div>
			*/
			
			var email = "${id_email}";
			
			if(email.length == 0){
				alert("로그인이 필요합니다.");
				return;
			}
			
			var _data = '{"email":"'+email+'","revNum":"'+obj+'"}';
			
			$.ajax({
				type : "post",
				url : "<%=contextPath%>/likeAcaRev",
				data : {data : _data},
				success:function(data,status){
					var json = JSON.parse(data);
					var count = json.count;
					var result = json.result;
					var revNum = json.revNum;
					var email = json.email;
					document.getElementById("cntLike_"+revNum).innerText = count;
					
					
					if(result == 1){
						document.getElementById("cntLikeImg_"+revNum).src="images/thumb-up.png";
					}else if(result == 0){
						document.getElementById("cntLikeImg_"+revNum).src="images/thumb-notup.png";
					}else{
						alert("오류가 발생했습니다.\n다시 시도해주세요.");
					}
				},
				error : function(){
					alert("통신에러가 발생했습니다.");
				}
			});
		}
	</script>

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
						<div class="course_title">${academyBean.acaName }</div> 
						<div class="aca_like_button" id="likeAcademy">
						</div>
						<div class="course_info_title"><i class="fa fa-map-marker" aria-hidden="true"></i>&nbsp; ${academyBean.acaAddrDoro }</div>
						<%-- <div class="course_info_title"><i class="fa fa-phone" aria-hidden="true"></i>&nbsp; ${academyBean.acaAddrDoro }</div> --%>
						<div class="cheongang tab_panel_registerBtn"
							 onclick="location.href='4index.jsp?center=O_academy/academy_audit.jsp?acaMainNum=${academyBean.acaMainNum }&acaName=${academyBean.acaName}'"
						>
						청강신청하기
						</div>
						<br>
						<div class="course_info d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start">

						
							<!-- Course Info Item -->
							<div class="course_info_item">
								<div class="course_info_title">평점</div>
								<div class="rating_r rating_r_${iAvgScore}"><i></i><i></i><i></i><i></i><i></i></div>
							</div>

							<!-- Course Info Item -->
							<div class="course_info_item">
								<div class="course_info_title">카테고리 대분류</div>
								<div class="course_info_text">${academyBean.acaCategory1 }</div>
							</div>
							
							<!-- Course Info Item -->
							<div class="course_info_item">
								<div class="course_info_title">카테고리 소분류</div>
								<div class="course_info_text">${academyBean.acaCategory2 }</div>
							</div>

						</div>

						<!-- Course Image -->
						<div class="course_image" >
							<div id ="map" style="width: 100%; height: 420px;"></div>
							<div id="mapReport">
							<p style="margin-top:-12px">
							    <em class="link">
							        <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
							            혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
							        </a>
							    </em>
							</p>
							</div>
						</div>

						<!-- Course Tabs -->
						<div class="course_tabs_container">
							<div class="tabs d-flex flex-row align-items-center justify-content-start">
								<div class="tab">학원 상세정보</div>
								<div class="tab">커리큘럼</div>
								<div class="tab active">후기보기</div>
							</div>
							
							<div class="tab_panels">

								<!-- Description -->
								<div class="tab_panel">
								
								<!-- 등록되지 않은 학원일 경우 -->
									<div class="tab_panel_title">이 학원의 관리자이신가요?</div>
									<div class="tab_panel_content">
										<div class="tab_panel_text">
											<p>학원 관리자 등록을 통해 학원페이지를 관리하실 수 있습니다</p>
										</div>
									<div class="tab_panel_registerBtn"
										 onclick="location.href='4index.jsp?center=academy/academy_register.jsp'">등록하기</div>
										
										
 										<div class="tab_panel_section">
											<div class="tab_panel_subtitle">당 사이트의 소유권</div>
											<ul class="tab_panel_bullets">
												<li>당 사이트가 제공하는 서비스, 그에 필요한 소프트웨어, 이미지, 마크, 로고, 디자인, 서비스명칭, 정보 및 상표 등과 관련된 지적재산권 및 기타 권리는 당 사이트에 소유권이 있습니다.</li>
												<li>이용자는 당 사이트가 명시적으로 승인한 경우를 제외하고는 전항의 소정의 각 재산에 대한 전부 또는 일부의 수정, 대여, 대출, 판매, 배포, 제작, 양도, 재라이센스, 담보권 설정 행위, 상업적 이용 행위를 할 수 없으며, 제3자로 하여금 이와 같은 행위를 하도록 허락할 수 없습니다.</li>
											</ul>
										</div>
										 
										 
										<!-- FAQ -->
 										<div class="tab_panel_faq">
											<div class="tab_panel_title">정보 이용 약관</div>

											정보 제공 및 홍보물 게재
											<div class="accordions">
												
												<div class="elements_accordions">

													<div class="accordion_container">
														<div class="accordion d-flex flex-row align-items-center"><div>게시물의 내용에 대한 권리</div></div>
														<div class="accordion_panel">
															<p>
															이용자가 게시한 게시물의 내용에 대한 권리는 해당 게시물을 등록한 이용자에게 있습니다.
															</p>
														</div>
													</div>

													<div class="accordion_container">
														<div class="accordion d-flex flex-row align-items-center active"><div>사전 통지 없이 게시물이 삭제되는 경우</div></div>
														<div class="accordion_panel">
															<p>당 사이트는 게시된 내용을 사전 통지 없이 편집, 이동할 수 있는 권리를 보유하며, 다음의 경우 사전 통지 없이 삭제할 수 있습니다.</p>
															
																<ul class="tab_panel_bullets">
																<li>욕설·특정인에 대한 비방 등 인권침해 소지가 있는 경우</li>
																<li>성인 게시물 등 공공질서 및 미풍양속에 위반되는 내용인 경우</li>
																<li>악의적으로 허위사실을 유포한 경우</li>
																<li>제3자의 저작권 등 기타 권리를 침해하는 내용인 경우</li>
																<li>상업적 목적이 있는 경우</li>
																<li>동일한 내용의 반복 게시</li>
																<li>게시자가 자신이 등록한 게시물의 삭제를 요구한 경우</li>
																<li>기타 홈페이지의 정상적인 운영을 저해하는 표현 또는 내용</li>
																</ul>
																
														</div>
													</div>

													<div class="accordion_container">
														<div class="accordion d-flex flex-row align-items-center"><div>게시물이 타인의 저작권을 침해할 경우</div></div>
														<div class="accordion_panel">
															<p>이용자의 게시물이 타인의 저작권을 침해함으로써 발생하는 민, 형사상의 책임은 전적으로 해당 게시물을 등록한 이용자가 부담하여야 합니다.</p>
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
								<div class="tab_panel tab_panel_3 active">
									<div class="tab_panel_title">후기 보기</div>

									<!-- Rating -->
									<div class="review_rating_container">
										<div class="review_rating">
											<div class="review_rating_num">${avgScore}</div>
											<div class="review_rating_stars">
												<div class="rating_r rating_r_${iAvgScore}"><i></i><i></i><i></i><i></i><i></i></div>
											</div>
											<div class="review_rating_text">${count}개의 평가</div>
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
								
							<c:if test="${count eq null || count eq '0'}">
								<div class="tab_panel_title">아직 등록된 후기가 없습니다.</div>
									<div class="tab_panel_content">
										<div class="tab_panel_text">
											<p>이 학원의 후기를 작성해 보세요!</p>
										</div>
									<div class="tab_panel_registerBtn"
										 onclick="location.href='4index.jsp?center=O_academy/academy_review_write.jsp?acaMainNum=${academyBean.acaMainNum }&acaName=${academyBean.acaName}'">후기 쓰기</div>
										 <c:if test="${id_email eq null || id_eamil eq ''}">
									<div class="add_comment_text">후기 작성은 <a href="4index.jsp?center=O_member/member_sign_in.jsp">로그인</a> 후 가능합니다.</div>
									</c:if>
							</c:if>				
									<!-- Comments -->
									<div class="comments_container">
										<ul class="comments_list">
										
										<!--------------------------------  ▼ 후기 1개 영역-------------------------------------->
										<c:forEach var="reBean" items="${reList}">
											<li id="reviewNum_${reBean.reviewNum }">
												<div class="comment_item d-flex flex-row align-items-start jutify-content-start">
													<div class="comment_image"><div><img src="images/comment_1.jpg" alt=""></div></div>
													<div class="comment_content">
														<div class="comment_title_container d-flex flex-row align-items-center justify-content-start">
															<div class="comment_author"><a href="#">${reBean.reviewTitle}</a></div>
															<div class="comment_rating"><div class="rating_r rating_r_${reBean.reviewScore}"><i></i><i></i><i></i><i></i><i></i></div></div>
															<div class="comment_time ml-auto">${reBean.reviewDate}</div>
														</div>
														<div class="comment_text">
															
															<c:if test="${id_email == null || id_email eq ''}">
															결제안한 회원에게 보이는 형태
															<div class="blind_review">
																<div class="blind_top_div">
																	<div class="no_membership">
																		<h6>멤버십 회원이 되어 학원 후기를 확인하세요!<br>
																		회원가입시 3일간 멤버십 혜택이 제공됩니다.</h6>
																		<div class= "review_login" onclick="location.href='./MemberLogin.me'">
																			<h5>로그인</h5>
																		</div>
																	</div>
																</div>
															</div>
															</c:if>
															<!-- 유료회원이면 보이는 형태 -->
															<c:if test="${id_email ne null}">
																<p><span class="strength">장점</span><br>
																	${reBean.reviewGood}
																</p>
																<p><span class="weakness">단점</span><br>
																	${reBean.reviewBad}
																</p>
															</c:if>
														<div class="comment_extras d-flex flex-row align-items-center justify-content-start">
														
														
														<!-- 만일 해당 계정으로 도움돼요 했다면 색칠해진 아이콘 -->
															<div class="comment_extra comment_likes">
															<img id="cntLikeImg_${reBean.reviewNum }" src="images/thumb-up.png" width="22"
																onclick="likeAcaReview(${reBean.reviewNum })" style="cursor:pointer;">
															<span class="cnt_Like" id="cntLike_${reBean.reviewNum }" ></span>
															
															</div>
														</div>
														<c:if test="${id_email ne null}">
															<c:if test="${id_email eq reBean.memEmail}">
																<div>
																<button class = "review_btn"
																onclick="reviewDelete(${reBean.reviewNum})">삭제</button>
																<button class = "review_btn" 
																onclick="location.href='4index.jsp?center=O_academy/academy_review_update.jsp?acaMainNum=${academyBean.acaMainNum }&reviewNum=${reBean.reviewNum }&acaName=${academyBean.acaName}'">수정</button>
																</div>
															</c:if>
														</c:if>
													</div>
												</div>
											</li>
											
											
										</c:forEach>
										</ul>
										<c:if test="${count ne '0'}">
											<div class="add_comment_container">
												<div class="add_comment_title" 
												onclick="location.href='4index.jsp?center=O_academy/academy_review_write.jsp?acaMainNum=${academyBean.acaMainNum }&acaName=${academyBean.acaName}'">
												후기쓰기
												</div>
											</div>
										</c:if>
									
										<!--------------------------------  ▲ 후기 1개 영역-------------------------------------->
											
											
							

									</div>
								</div>
							</div>
						</div> <!-- 전체 탭 마지막 태그-->
					</div>
				</div>
<!-------------------------------------------[ 학원 대표 키워드 ]-------------------------------------------------------------->
				<!-- Course Sidebar -->
				
			<c:if test="${empty keyList}">
			</c:if>
			<c:if test="${not empty keyList}">
				<div class="col-lg-4">
					<div class="sidebar">
						
						<!-- Feature -->
						<div class="sidebar_section">
						
							<div class="sidebar_section_title">학원을 대표하는 키워드</div>
							<div class="sidebar_feature">
								<div class="course_price" style="font-size: 20px;"></div>

								<!-- Features -->
								<div class="feature_list">
				<c:forEach var="keywordVO" items="${keyList}">
									
						<c:choose>
						
							
							<c:when test="${keywordVO.acakeyword eq 'traffic'}">
								<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-subway" aria-hidden="true"></i>
											<span>교통이 편리한</span>
										</div>
									</div>
							</c:when>
							
							<c:when test="${keywordVO.acakeyword eq 'long'}">
								<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-clock-o" aria-hidden="true"></i>
											<span>중장기(6개월)</span>
										</div>
									</div>
							</c:when>
							
							
							<c:when test="${keywordVO.acakeyword eq 'clean'}">
								<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-university" aria-hidden="true"></i>
											<span>시설이 깨끗한</span>
										</div>
									</div>
							</c:when>
							
							<c:when test="${keywordVO.acakeyword eq 'audit'}">
								<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-eye" aria-hidden="true"></i>
											<span>청강신청이 가능한</span>
										</div>
									</div>
							</c:when>
							
							<c:when test="${keywordVO.acakeyword eq 'stdRoom'}">
								<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-cubes" aria-hidden="true"></i>
											<span>스터디룸이 있는</span>
										</div>
									</div>
							</c:when>
							
							<c:when test="${keywordVO.acakeyword eq 'restaurant'}">
								<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-cutlery" aria-hidden="true"></i>
											<span>식당가 인근</span>
										</div>
									</div>
							</c:when>
							
							<c:when test="${keywordVO.acakeyword eq 'room'}">
								<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-building-o" aria-hidden="true"></i>
											<span>기숙사 있는</span>
										</div>
									</div>
							</c:when>
							
							<c:when test="${keywordVO.acakeyword eq 'car'}">
								<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-bus" aria-hidden="true"></i>
											<span>학원 차량 운행이 있는</span>
										</div>
									</div>
							</c:when>
							
							<c:when test="${keywordVO.acakeyword eq 'level'}">
								<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-file-text-o" aria-hidden="true"></i>
											<span>레벨 테스트가 있는</span>
										</div>
									</div>
							</c:when>
							
							<c:when test="${keywordVO.acakeyword eq 'sat'}">
								<div class="feature d-flex flex-row align-items-center justify-content-start">
										<div class="feature_title"><i class="fa fa-graduation-cap" aria-hidden="true"></i>
											<span>수능 대비 강의가 있는</span>
										</div>
									</div>
							</c:when>
							
										
						</c:choose>
						
					</c:forEach>
					
								</div>
							</div>
						</div>
					</div>
				</div>
			
			
	</c:if>
	
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

					
		
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=56b68041fba795d6cb8db4e217e7d909&libraries=services"></script>
	<script>
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	var geocoder = new kakao.maps.services.Geocoder();
	
	var myAddress = "${academyBean.acaAddrDoro}";
	var acaName = "${academyBean.acaName }";
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(myAddress, function(result, status) {

	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {

	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });

	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+acaName+'</div>'
	        });
	        infowindow.open(map, marker);

	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	});    
	</script>	


<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="js/course.js"></script>
<script>

</script>
</body>
</html>