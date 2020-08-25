<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="info" action="./auditInfoRegister.adma" method="get">
		<table>
			<tr>
				<td>학원지정번호</td>
				<td><input type="text" name="acaNum" value="301569" readonly></td>
			</tr>
			<tr>
				<td>학원명</td>
				<td><input type="text" name="acaName" value="(주)그루샘수학보습학원" readonly></td>
			</tr>
			<tr>

				<td>청강가능과목</td>
				<td><input type="text" name="auditAvailSubj"></td>
			</tr>
			<tr>
				<td>청강가능일시</td>
				<td><input type="date" name="auditAvailDate"></td>
			</tr>
			<tr>
				<td>해당 수업지속시간</td>
				<td><input type="text" name="auditLastTime"></td>
			</tr>
			<tr>
				<td>청강 가능 인원</td>
				<td><input type="text" name="auditAblemem"></td>
			</tr>
		</table>
		<input type="submit" value="전송">
<!-- 		<input type="button" value="전송" onclick="registerInfo()"> -->
	</form>
	
	<!-- <script>
	function registerInfo(){			
		var formData = new FormData(document.getElementById("info"));
		$.ajax({
				type:'get',
				async:true, 			
				url:'./auditInfoRegister.adma', 
				data:{sendData:formData},				
				success:function(data, status){						
					if(data == 0){
						alert("failed");
						document.getElementById("info").submit();
					}else{
						alert("success");
					}
					
				},
				error:function(error, status){
					alert("에러가 발생했습니다.");
					console.debug(error);		
				}			
		});//ajax()			
	}
	
	</script> -->

</body>
</html>