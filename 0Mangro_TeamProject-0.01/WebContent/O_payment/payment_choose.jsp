<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>Blog Single</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!------------------------- [ 제이쿼리 ] ------------------------------------------------------->
<script src="js/jquery-3.2.1.min.js"></script>
<!------------------------- [ 자바스크립트 ] ------------------------------------------------------->
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="js/blog_single.js"></script>

<!------------------------- [ CSS ] ------------------------------------------------------->
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/payment_choose.css">
<link rel="stylesheet" type="text/css" href="styles/anony_board_single_responsive.css">
<style>
	.comments_list li {   display: table-cell; }
	.space_paid{margin-top: 100px; }
	.comments_container {margin-bottom: 100px;}
</style>
</head>


<body>

		<div class="container">
			<div class="row">


					
<!-------------------------------------------------- [제목영역]  -------------------------------------------------------------------------->
				    <div class="space_paid">
						<div class="comments_title">멤버십 결제 선택</div>
						<h6 class="svc_use_num">회원님의 최근 이용 서비스는 <span>무제한 이용권 30일</span>입니다.</h6> 
				    </div>
<!-------------------------------------------------- [멤버십 이용권 표시]  -------------------------------------------------------------------------->
				    
				    
					<div class="comments_container">
						<ul class="comments_list"> 
<!-------------------------------------------------------- [▼ 멤버십 이용권 30일 ]  -------------------------------------------------------------------------->
							<li> 
								<div class="use_thirty">30일 이용권</div>
								
								<div class="comment_item d-flex flex-row align-items-start jutify-content-start">
									<div class="comment_content">
									<div class="comment_image">
										<div><img src="images/etc/MANGO.PNG" width="150"></div>
									</div>
									<hr>
										<div class="comment_title_container d-flex flex-row align-items-center justify-content-start">
											<div class="comment_author"><span class="span_title">무제한 이용권<br>(30일)</div>
										</div>
										<div class="comment_text start_end_date">
											<p>시작일 : <span>2020-08-20</span></p>  <!-- 현재날짜 -->
											<p>종료일 : <span>2020-09-18</span></p>  <!-- 현재날짜로부터 30일 후 --> <br><hr>
										</div>
										<div class="comment_extras d-flex flex-row align-items-center justify-content-start">
											<div class="comment_extra">
											<i class="fa fa-credit-card" aria-hidden="true"></i>
												<h2>7,900원</h2>
											</div>
										</div>
									</div>
								</div>
								<div class="paid_service_btn" onclick="">멤버십 결제하기</div>
							</li> 
<!-------------------------------------------------------- [▲ 멤버십 30일 ]  -------------------------------------------------------------------------->
<!-------------------------------------------------------- [▼ 멤버십 30일(정기결제)]  -------------------------------------------------------------------------->
							<li> 
								<div class="use_thirty" id="period">30일 이용권[정기결제]</div>
								
								<div class="comment_item d-flex flex-row align-items-start jutify-content-start">
									<div class="comment_content">
									<div class="comment_image">
										<div><img src="images/etc/MANGO.PNG" width="150"></div>
									</div>
									<hr>
										<div class="comment_title_container d-flex flex-row align-items-center justify-content-start">
											<div class="comment_author"><span class="span_title">무제한 이용권<br>(30일)<br></div> 
										</div>
										<div class="comment_text start_end_date">
											<p>시작일 : <span>2020-08-20</span></p>  <!-- 현재날짜 -->
											<p>종료일 : <span>2020-09-18</span></p>  <!-- 현재날짜로부터 30일 후 --> <br><hr>
										</div>
										<div class="comment_extras d-flex flex-row align-items-center justify-content-start">
											<div class="comment_extra">
											<i class="fa fa-credit-card" aria-hidden="true"></i>
												<h2>5,900원</h2>
											</div>
										</div>
									</div>
								</div>
								<div class="paid_service_btn" onclick="">멤버십 결제하기</div>
							</li> 
<!-------------------------------------------------------- [▲ 멤버십 이용권 30일(정기결제) ]  -------------------------------------------------------------------------->
<!-------------------------------------------------------- [▼ 멤버십 이용권 90일 ]  -------------------------------------------------------------------------->
							<li> 
								<div class="use_thirty" id="ninety_use">90일 이용권</div>
								
								<div class="comment_item d-flex flex-row align-items-start jutify-content-start">
									<div class="comment_content">
									<div class="comment_image">
										<div><img src="images/etc/MANGO.PNG" width="150"></div>
									</div>
									<hr>
										<div class="comment_title_container d-flex flex-row align-items-center justify-content-start">
											<div class="comment_author"><span class="span_title">무제한 이용권<br>(90일)</div>
										</div>
										<div class="comment_text start_end_date">
											<p>시작일 : <span>2020-08-20</span></p>  <!-- 현재날짜 -->
											<p>종료일 : <span>2020-09-18</span></p>  <!-- 현재날짜로부터 30일 후 --> <br><hr>
										</div>
										<div class="comment_extras d-flex flex-row align-items-center justify-content-start">
											<div class="comment_extra"> 
											<i class="fa fa-credit-card" aria-hidden="true"></i>
												<h2>12,900원</h2>
											</div>
										</div>
									</div>
								</div>
								
								<div class="paid_service_btn" onclick="">멤버십 결제하기</div>
							</li> 
<!-------------------------------------------------------- [▲ 멤버십 쿠폰 1장 ]  -------------------------------------------------------------------------->


						</ul>
					</div> <!-- comments_container -->
			
			</div> <!-- row -->
		</div> <!-- container -->


</body>
</html>