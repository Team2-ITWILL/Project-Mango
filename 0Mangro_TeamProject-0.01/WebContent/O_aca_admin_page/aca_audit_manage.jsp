<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!----------------------------------[ 테이블]---------------------------------------------------------->
	<div class="col-12">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">청강신청 가능일 등록</h4>
				<h6 class="card-subtitle"></h6>
			</div>
			<div class="table-responsive">
				<form id="info" action="./auditInfoRegister.adma" method="get">
					<table class="table">
						<tr>
							<td>학원지정번호</td>
							<td><input type="text" name="acaNum" value="301569" readonly></td>
						</tr>
						<tr>
							<td>학원명</td>
							<td><input type="text" name="acaName" value="(주)그루샘수학보습학원"
								readonly></td>
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
					<input type="submit" class="btn btn-primary" value="전송">
				</form>
			</div>
		</div>
	</div>

</body>
</html>