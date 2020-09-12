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


<link rel="stylesheet" type="text/css" href="styles/qna_write.css">
<!---------------------------------- 제이쿼리  ---------------------------------------------------->

<!---------------------------------- CkEditor  -------------------------------------------------->
<script src="./ckeditor/ckeditor.js"></script>


<script src="https://code.jquery.com/jquery-3.4.1.js"></script>



<script type="text/javascript">

	function Check_input(){

		var mem_email = $('input[name=mem_email]').val();
		var qna_board_pwd = $('input[name=qna_board_pwd]').val();
		var qna_board_title = $('input[name=qna_board_title]').val();
		var qna_board_content = $('textarea[name=qna_board_content]').val();
		
		if(mem_email == ''){
			alert("이메일을 입력해주세요.");
			mem_email.focus();
		}
		else if(qna_board_pwd == ''){
			alert("글 비밀번호를 입력해주세요.");
			return false;
		}
		else if(qna_board_title == ''){
			alert("제목을 입력해주세요.");
			return false;
		}
		else if(qna_board_content == null){
			alert("내용을 입력해주세요.");
			return false;
		}
		
	}


</script>
</head>
<body>


<%

int qna_board_num = Integer.parseInt(request.getParameter("qna_board_num"));
int qna_re_ref = Integer.parseInt(request.getParameter("qna_re_ref"));
int qna_re_lev = Integer.parseInt(request.getParameter("qna_re_lev"));
int qna_re_seq =Integer.parseInt(request.getParameter("qna_re_seq"));

%>



<!-- qna_container (s) -->
<div class = "qna_container container">

	<form name="fwrite" id="fwrite" action="./QnaBoardReWriteAction.qna" method="post" autocomplete="off" style="width:100%">
		
		
	    	<input type = "hidden" name = "qna_board_num" value = "<%=qna_board_num%>">
			<input type="hidden" name="qna_re_ref" value = "<%=qna_re_ref%>">
			<input type="hidden" name="qna_re_lev" value = "<%=qna_re_lev%>">
			<input type="hidden" name="qna_re_seq" value = "<%=qna_re_seq%>">
	    
	    
	 	<!-- write box (s) -->
	 	<div class="bo_w_info write_div">
	    	
	    	<label for="wr_name" class="sound_only">이메일<strong>필수</strong></label>
	        <input type="text" name="mem_email"  value = "${id_email}" readonly="readonly" id="wr_name" class="frm_input required">
	    
	        <label for="wr_password" class="sound_only">비밀번호<strong>필수</strong></label>
	        <input type="password" name="qna_board_pwd" id="wr_password" class="frm_input required" placeholder="비밀번호">
	    	
	    	<!-- 관리자인 경우만 공지사항으로 설정할 수 있는 라디오 버튼이 나타남 -->
	    	<c:choose>
		    	<c:when test="${id_email eq 'admin' || id_email eq 'admin@mango.com'}">
			    	<div class = "frm_input required">
				    	<input type = "radio" name = "qna_notice" value = "0" checked="checked" style="display: none;">
						<input type = "radio" name = "qna_notice" value = "1" style="font-family: 'Noto Sans KR', 'sans-serif'">  공지사항으로 설정
			    	</div>
		    	</c:when>
		    	
		    	<c:otherwise>
				    	<input type = "hidden" name = "qna_notice" value = "0" checked="checked" style="display: none;">
						<input type = "hidden" name = "qna_notice" value = "1" style="font-family: 'Noto Sans KR', 'sans-serif'">
			    </c:otherwise>
	    	</c:choose> 
	  	</div>
	
	
	    
	    <div class="bo_w_tit write_div">
	        <label for="wr_subject" class="sound_only">제목<strong>필수</strong></label>
	    	<div id="autosave_wrapper write_div">
	            <input type="text" name="qna_board_title" value="[답변]: " id="wr_subject" class="frm_input full_input required" size="50" maxlength="255" placeholder="제목">
	       	</div>
	    </div>
	    
	    
	
	    <div class="write_div">
	        <label for="wr_content" class="sound_only">내용<strong>필수</strong></label>
	        <div class="wr_content ">
	            <span class="sound_only">웹에디터 시작</span>
	           	
	           	
	           	<textarea id = "wr_content" name = "qna_board_content" style="width:100%;"></textarea>
	            
                <script type="text/javascript">
                  $(function (){
                	  
                	  CKEDITOR.replace('wr_content', {
                		  
                		  height: 400,
                		  removePlugins: 'resize',
                			
                		filebrowserBrowseUrl: '${pageContext.request.contextPath}/ckfinder/ckfinder.html',
                		filebrowserFlashBrowseUrl: '${pageContext.request.contextPath}/ckfinder/ckfinder.html?type=Flash',
                		filebrowserUploadUrl: '${pageContext.request.contextPath}/ckfinder/core/connector/java/connctor.java?command=QuickUpload&type=Files',
                		filebrowserImageUploadUrl: '${pageContext.request.contextPath}/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images',
                		filebrowserFlashUploadUrl: '${pageContext.request.contextPath}/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash'
						
                	  });

                  });
                  </script>
				<span class="sound_only">웹 에디터 끝</span>
			</div>
	        
	    </div>
	
	
	
		
		
		<!-- recaptcha api(s) 로봇이 아닙니다. --> 
        <div class="write_div">
	        <fieldset id="captcha" class="captcha recaptcha"><script src="https://www.google.com/recaptcha/api.js?hl=ko"></script><script src="http://sample.paged.kr/purewhite/plugin/recaptcha/recaptcha.js"></script>
	        <div class="g-recaptcha" data-sitekey="6LeuK0wUAAAAAPjl3Se_sedBwESPliGdmhzhRqgq">
	        <div style="width: 304px; height: 78px;">
	        	<div><iframe src="https://www.google.com/recaptcha/api2/anchor?ar=1&amp;k=6LeuK0wUAAAAAPjl3Se_sedBwESPliGdmhzhRqgq&amp;co=aHR0cDovL3NhbXBsZS5wYWdlZC5rcjo4MA..&amp;hl=ko&amp;v=aUMtGvKgJZfNs4PdY842Qp03&amp;size=normal&amp;cb=8vmngqyp7wey" width="304" height="78" role="presentation" name="a-1mofor49vsoo" frameborder="0" scrolling="no" sandbox="allow-forms allow-popups allow-same-origin allow-scripts allow-top-navigation allow-modals allow-popups-to-escape-sandbox"></iframe>
	        	</div>
	        	<textarea id="g-recaptcha-response" name="g-recaptcha-response" class="g-recaptcha-response" style="width: 250px; height: 40px; border: 1px solid rgb(193, 193, 193); margin: 10px 25px; padding: 0px; resize: none; display: none;"></textarea></div>
	        	<iframe style="display: none;"></iframe>
	        </div>
	        </fieldset>
        </div>
 		<!-- recaptcha api(e) -->   
 		
 		
	    <div class="btn_confirm write_div">
	        <a href="./board.php?bo_table=qna" class="btn_cancel btn">취소</a>
	        <input type="submit" value="작성완료" id="btn_submit" accesskey="s" class="btn_submit btn"
	        onclick="javascript:return Check_input()">
	    </div>
	    
	    
    </form>
    
</div>
<!-- qna_container (e) -->


</body>
</html>