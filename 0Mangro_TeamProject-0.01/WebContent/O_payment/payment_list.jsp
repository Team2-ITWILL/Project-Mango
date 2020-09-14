<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/payment_list.css">
<link rel="stylesheet" type="text/css" href="styles/anony_board_single_responsive.css">
<style type="text/css">
	.space_paid{margin-top: 100px; }
	.comments_container {margin-bottom: 100px;}
</style>



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


		$(function() {
			
			
			$(".comments_list").empty();
			
			
			$.getJSON("./getListMyPayMent.pay?email=${email}" ,  function(data){
				
				console.log(data.MyPay);
				
				
				var psys=" ";
				var all="";
				$.each(data.MyPay , function (index,item) {
					
					var result =item.result;
					
					psys+="<li>";
					psys+="<div class='comment_item d-flex flex-row align-items-start jutify-content-start'>";
					psys+="<div class='comment_image'><div><img src='images/etc/MANGO.PNG' alt=''></div></div>";
					psys+="<div class='comment_content'>";
					psys+="<div class='comment_title_container d-flex flex-row align-items-center justify-content-start'>";
				    psys+=	"<div class='comment_author'><span class='span_title'>"+item.pmName+"</span></div>";
				    psys+="</div>";
				    psys+=	"<div class='comment_text'>";
				    psys+=		"<span>시작일 : <span class='service_date'>"+item.pmStartDate+"</span></span>" ;
				    psys+=		"<span>종료일 : <span class='service_date'>"+item.pmExpDate+"</span></span>";
				    psys+=	"</div>";
				    psys+=	"<div class='comment_extras d-flex flex-row align-items-center justify-content-start'>";
				    psys+=		"<div class='comment_extra'>";
				    psys+=				"<img src='images/etc/date.png' width='20'>";
				    psys+=			"남은 이용기간 :&nbsp;<span>"+(result < 0 ? 0:result)+ "일</span>";
				    psys+=			"</div>";
				    psys+=		"</div>";
				    psys+=	"</div>";
				    psys+="</div>";
				    psys+="</li>";
					
				    
				all=item.max;
				
					
					
				});
				
				$(".comments_list").append(psys);
				$(".allpay").text(all);
					
			});
				
				
				
							
			
			
			
			
		});//메인
		
		




</script>



</head>
<body>

		<div class="container">
			<div class="row">
			
<!-------------------------------------------------- [제목영역]  -------------------------------------------------------------------------->
					
					  <div class="space_paid">
						<div class="comments_title">멤버십 이용내역</div>
						<h6 class="svc_use_num">총 <span class="allpay">1</span>회 이용</h6> 
						
 						<div class="paid_service_btn" onclick="location.href='./MainPayMent.pay'">멤버십 결제하기</div>
						
<%-- 						<div class="paid_service_btn" onclick="location.href='NewGetPayMent.pay?email=${email}'">멤버십 결제하기</div> --%>
					  
					  </div>
<!-------------------------------------------------- [멤버십 이용 내역 확인]  -------------------------------------------------------------------------->
					<div class="comments_container">
						<ul class="comments_list"> 
<!-------------------------------------------------------- [▼ 멤버십 1장 ]  -------------------------------------------------------------------------->
<!-------------------------------------------------------- [▲ 멤버십  1장 ]  -------------------------------------------------------------------------->
							
					
<!-- 							<li>  -->
<!-- 								<div class="comment_item d-flex flex-row align-items-start jutify-content-start"> -->
<!-- 									<div class="comment_image"><div><img src="images/etc/MANGO.PNG" alt=""></div></div> -->
<!-- 									<div class="comment_content"> -->
<!-- 										<div class="comment_title_container d-flex flex-row align-items-center justify-content-start"> -->
<!-- 											<div class="comment_author"><span class="span_title">무제한 이용권(30일)</span></div> -->
<!-- 										</div> -->
<!-- 										<div class="comment_text"> -->
<!-- 											<span>시작일 : <span class="service_date">2020-08-20</span></span>  -->
<!-- 											<span>종료일 : <span class="service_date">2020-09-18</span></span> -->
<!-- 										</div> -->
<!-- 										<div class="comment_extras d-flex flex-row align-items-center justify-content-start"> -->
<!-- 											<div class="comment_extra"> -->
<!-- 												<img src="images/etc/date.png" width="20"> -->
<!-- 												남은 이용기간 :&nbsp;<span>30일</span> -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</li>  -->
			
					
					
					

<!-------------------------------------------------------- [▲ 멤버십 쿠폰 1장 ]  -------------------------------------------------------------------------->
						</ul>
					</div>  <!-- comments_container -->
		</div>  <!-- row -->
	</div>  <!-- container -->




<!-------------------------------------------------------- [ 스크립트 영역 ]  -------------------------------------------------------------------------->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="js/blog_single.js"></script>


</body>
</html>