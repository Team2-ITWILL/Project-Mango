<%@page import="mango.anony_board.db.AnonyBoardBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>고객센터</title> 
<!---------------------------------- 메타데이터  ---------------------------------------------------->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!---------------------------------- CSS  ---------------------------------------------------->
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">


<link rel="stylesheet" type="text/css" href="styles/qna_delete.css">
<!---------------------------------- 제이쿼리  ---------------------------------------------------->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>



<!-- 자바 스크립트 -->
<script type="text/javascript">

	function Check_input(){  

		var qna_board_pwd = $('input[name=qna_board_pwd]').val();
		
		if(qna_board_pwd == ''){
			alert("비밀번호를 입력해주세요.");
			return false;
		}
		
	}


</script>

</head>
<body>

<%

String pageNum = request.getParameter("pageNum");
int qna_board_num = Integer.parseInt(request.getParameter("qna_board_num"));
String qna_board_pwd = request.getParameter("qna_board_pwd");

%>


<div id = "ctWrap">


	<!-- qna_container (s) -->
<!-- 	<div class = "qna_container container"> -->
	<div class = "container">
	
		    
		    
		<div id = "pw_confirm" class = "mbskin">
		    	
		    <p>
		    	<strong>비밀글 기능으로 보호된 글입니다.</strong>
		    	작성자와 관리자만 삭제하실 수 있습니다.<span><br></span>
		    	본인이라면 비밀번호를 입력하세요.
		    </p>
	
	
		    			    				  
		<form name="fboardpassword" action="./QnaBoardDeleteAction.qna?qna_board_num=<%=qna_board_num%>&pageNum=<%=pageNum%>" method="post">
		    
					<input type = "hidden" name = "qna_board_num" value = "<%=qna_board_num%>">
				    
				    <fieldset>
				    	
				    	<label for = "password_wr_password" class = "sound_only">비밀번호<strong>필수</strong></label>
				    	
				    	<input type = "password" name = "qna_board_pwd" id = "password_wr_password"
				    	class = "frm_input required" size = "15" maxlength = "20" placeholder = "비밀번호" >
				    	
				    	<input type = "submit" value = "확인" class = "btn_submit" onclick="javascript:return Check_input()"> 
				   
				    </fieldset>
	    </form>
		    	
		    	
		    </div>
		    
  
	    
	</div>
	<!-- qna_container (e) -->

</div>


</body>
</html>