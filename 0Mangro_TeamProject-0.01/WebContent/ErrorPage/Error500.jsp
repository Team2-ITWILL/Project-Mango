<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mango - 망고</title>
<!---------------------------------- 메타데이터  ---------------------------------------------------->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!---------------------------------- CSS  ---------------------------------------------------->
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">

<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=Kanit:200" rel="stylesheet">

<!-- Font Awesome Icon -->
<link type="text/css" rel="stylesheet" href="ErrorPage/css/font-awesome.min.css" />

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="ErrorPage/css/errorcss.css" />

</head>
<body>

<c:if test="${requestScope['javax.servlet.error.status_code'] == 500}">

	<jsp:include page="../1Top.jsp"/>
	
		<div id="notfound">
			<div class="notfound">
				<div class="notfound-404">
					<h1>500</h1>
				</div>
				<h2>Oops! Internet Server Error.</h2>
				<p>죄송합니다. 기술적인 문제로 일시적으로 서비스에 접속이 되지 않았습니다. <br>
				잠시 후 다시 이용 부탁드리며 이용에 불편을 드려 죄송합니다. <br>
				궁금한 점이 있으시면 고객센터를 통해 문의해 주시기 바랍니다.<br>
				감사합니다. <br> <br>
				<a href="4index.jsp" class = "return1">Return to MANGO !</a></p>
				<div class="notfound-social">
					<a href="#"><i class="fa fa-facebook"></i></a>
					<a href="#"><i class="fa fa-twitter"></i></a>
					<a href="#"><i class="fa fa-pinterest"></i></a>
					<a href="#"><i class="fa fa-google-plus"></i></a>
				</div>
			</div>
		</div>
	
	<jsp:include page="../2Bottom.jsp"/>
	
	
</c:if>

</body>
</html>