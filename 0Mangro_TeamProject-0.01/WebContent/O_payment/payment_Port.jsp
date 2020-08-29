
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<% 
	
request.setCharacterEncoding("utf-8");	

%>

</head>
<body>


<script type="text/javascript">

	$(function(){
		var IMP = window.IMP; // 생략가능
		IMP.init('imp38355270');  // 가맹점 식별 코드
		
		IMP.request_pay({
		   pg : 'html5_inicis', // 결제방식
		    pay_method : 'card',	// 결제 수단
		    merchant_uid : 'merchant_' + new Date().getTime(),
		   name : '주문명:${param.option}',	// order 테이블에 들어갈 주문명 혹은 주문 번호
		    amount : '${param.money}',	// 결제 금액
		    buyer_email : '${param.email}'	// 구매자 email
		  //buyer_tel :  '01063743155'	// 구매자 전화번호
		 /*    buyer_addr :  '울산광역시',	// 구매자 주소
		    buyer_postcode :  '117-885'	// 구매자 우편번호 */
		}, function(rsp) {
			if ( rsp.success ) { // 성공시
				var msg = '결제가 완료되었습니다.';
				msg += '고유ID : ' + rsp.imp_uid;
				msg += '상점 거래ID : ' + rsp.merchant_uid;
				msg += '결제 금액 : ' + rsp.paid_amount;
				msg += '카드 승인번호 : ' + rsp.apply_num;
				
				     
				$.ajax({
	 				type:"post",
	 				async:true,
	 				url:"InsertPayMent.pay",
	 				data:{email :'${param.email}', option :'${param.option}',money:'${param.money}'},
	 				dataType:"text",
	 				success:function(data,textStatus){
	 			
	 					if(data==1){
	 						
	 						alert("결제 되었습니다");
	 						
	 						opener.location.href="4index.jsp?center=3main.jsp";
	 						window.close();
	 						
	 						
	 					}
	 					
	 					
						
	 				},
	 				error:function(){
	 					alert("에러가 발생했습니다");
						
 	 				}
				
				
				
				
				
 				});		
				
				
			} //if
			else { // 실패시
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
				alert("결제가 취소되었습니다")
				window.close();
			
			}//else
			

		
	})//request_pay
	
	});	//메인
				
		
	


	
	
	
</script>




</body>

</html>