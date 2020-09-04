<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


<%
	String email=(String)session.getAttribute("id_email");

	if(email==null){
	%>	
	<script type="text/javascript">
	
		alert("로그인을 하셔야 합니다");
	
		location.href="4index.jsp?center=O_member/member_sign_in.jsp";
		
		</script>
		
		
	<%	
	}


%>
	<c:set var="email" value="<%=email%>"/>
<script type="text/javascript">
	
	
	
	
	function MonthPay() {
		
		var money =7900;
		var option="무제한 이용권 (30일)";
		submit(money,option);
		
	}
	
	
	function MemberPay() {
// 	var money =5900;
// 	var option="30일 이용권 정기결제";	
// 	submit(money,option);
		alert("서비스 준비중 입니다")
	}


	function ThMonthPay() {
		var money =12900;
		var option="무제한 이용권 (30일)";	
		submit(money,option);
	}
	
	

	
	$(function(){
		var a =new Date();
		var d =new Date(a.getFullYear(),a.getMonth(),a.getDate());	
		a.setDate(d.getDate()+30)
		$(".month1").text(d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate());
		$(".month2").text(d.getFullYear()+"-"+(d.getMonth()+2)+"-"+a.getDate());
		a.setDate(d.getDate()+90)
		$(".month3").text(d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate());
		$(".month4").text(d.getFullYear()+"-"+(d.getMonth()+4)+"-"+a.getDate());
	
	
	
	
	
		$.ajax({
				type:"post",
				async:true,
				url:"NewGetPayMent.pay",
				data:{email :'${email}'},
				dataType:"text",
				success:function(data,textStatus){
			
					
					var pm = data;
					
					console.log(pm)
					
					if(pm != "null"){
						
						$(".svc_use_num > span").text(pm);
					
					}else{
						
						$(".svc_use_num").text("최근에 사용하신 이용권이 없습니다");
						
					}
					
					
				
				},
				error:function(){
					alert("에러가 발생했습니다");
				
				}
		
		})//ajax
	
	
	
	
	
	
	
	
	
	
	
	
	})	
		
		
	
	
	
	
	
	
		
	
	
	
	
	
		function submit(money,option) {
		
		if(${email != null}){
			
			  $(".money").val(money);
			   $('#frm').attr("action", "PayMentPort.pay");
			   $('#frm').attr("method", "post");
			   $('#frm').attr("target", "formInfo");
			   $(".option").val(option);
			 	 open("","formInfo","width=1100,height=800");
			   $("#frm").submit();		
			
			

	
			}else{
				
				alert("로그인 후 이용해주세요");
				
				
			}
				
	}
		
		
		
		
		
	
	
	

</script>


<body>



	<form id="frm"> 
	<input type="hidden" name="money" class="money" >
	<input type="hidden" name="option" class="option">
	<input type="hidden" name="email" class="email" value="${email}">
	
		<div class="container">
			<div class="row">
					
<!-------------------------------------------------- [제목영역]  -------------------------------------------------------------------------->
				    <div class="space_paid">
						<div class="comments_title">멤버십 결제 선택</div>
							
												
										
									<h6 class="svc_use_num">회원님의 최근 이용 서비스는 <span></span>입니다.</h6> 								
							
								
						
			
							
					
				    
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
											<p>시작일 : <span class="month1"></span></p>  <!-- 현재날짜 -->
											<p>종료일 : <span class="month2"></span></p>  <!-- 현재날짜로부터 30일 후 --> <br><hr>
										</div>
										<div class="comment_extras d-flex flex-row align-items-center justify-content-start">
											<div class="comment_extra">
											<i class="fa fa-credit-card" aria-hidden="true"></i>
												<h2>7,900원</h2>
											</div>
										</div>
									</div>
								</div>
								<div class="paid_service_btn" onclick="MonthPay()">멤버십 결제하기</div>
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
											<p>시작일 : <span class="month1"></span></p>  <!-- 현재날짜 -->
											<p>종료일 : <span class="month2"></span></p>  <!-- 현재날짜로부터 30일 후 --> <br><hr>
										</div>
										<div class="comment_extras d-flex flex-row align-items-center justify-content-start">
											<div class="comment_extra">
											<i class="fa fa-credit-card" aria-hidden="true"></i>
												<h2>5,900원</h2>
											</div>
										</div>
									</div>
								</div>
								<div class="paid_service_btn" onclick="MemberPay()">멤버십 결제하기</div>
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
											<p>시작일 : <span class="month3"></span></p>  <!-- 현재날짜 -->
											<p>종료일 : <span class="month4"></span></p>  <!-- 현재날짜로부터 30일 후 --> <br><hr>
										</div>
										<div class="comment_extras d-flex flex-row align-items-center justify-content-start">
											<div class="comment_extra"> 
											<i class="fa fa-credit-card" aria-hidden="true"></i>
												<h2>12,900원</h2>
											</div>
										</div>
									</div>
								</div>
								
								<div class="paid_service_btn" onclick="ThMonthPay()">멤버십 결제하기</div>
							</li> 
<!-------------------------------------------------------- [▲ 멤버십 쿠폰 1장 ]  -------------------------------------------------------------------------->


						</ul>
					</div> <!-- comments_container -->
			
			</div> <!-- row -->
		</div> <!-- container -->
</form>

</body>
</html>