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
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>




<!-- qna_container (s) -->
<div class = "qna_container container">

	<form name="fwrite" id="fwrite" action="./QnaBoardWriteAction.qna" enctype="multipart/form-data" autocomplete="off" style="width:100%">
		
	    
	 	<!-- write box (s) -->
	 	<div class="bo_w_info write_div">
	    	
	    	<label for="wr_name" class="sound_only">이메일<strong>필수</strong></label>
	        <input type="text" name="mem_email" value = "${id_email}" id="wr_name" class="frm_input required disa" 
	        readonly="readonly">
	    
	        <label for="wr_password" class="sound_only">비밀번호<strong>필수</strong></label>
	        <input type="password" name="qna_board_pwd" id="wr_password" class="frm_input required" placeholder="비밀번호">
	    
	  	</div>
	
	
	    
	    <div class="bo_w_tit write_div">
	        <label for="wr_subject" class="sound_only">제목<strong>필수</strong></label>
	    	<div id="autosave_wrapper write_div">
	            <input type="text" name="qna_board_title" value="" id="wr_subject" required="" class="frm_input full_input required" size="50" maxlength="255" placeholder="제목">
	       	</div>
	    </div>
	    
	    
	
	    <div class="write_div">
	        <label for="wr_content" class="sound_only">내용<strong>필수</strong></label>
	        <div class="wr_content ">
	            <span class="sound_only">웹에디터 시작</span>
				<textarea id="wr_content" name="qna_board_content" class="" maxlength="65536" style="width:100%;height:300px" placeholder="내용을 입력해 주세요."></textarea>
				<span class="sound_only">웹 에디터 끝</span>
			</div>
	        
	    </div>
	
	
	
		<div class="bo_w_info"><b>관련링크</b><span>(유투브 공유링크를 삽입하시면 글보기 페이지에 유투브 영상이 출력됩니다.)</span></div>
	        <div class="bo_w_link write_div">
	        <label for="wr_link1"><i class="fa fa-link" aria-hidden="true"></i><span class="sound_only"> 링크  #1</span></label>
	        <input type="text" name="wr_link1" value="" id="wr_link1" class="frm_input full_input" size="50" placeholder="링크를 입력해 주세요.">
	    </div>
	        <div class="bo_w_link write_div">
	        <label for="wr_link2"><i class="fa fa-link" aria-hidden="true"></i><span class="sound_only"> 링크  #2</span></label>
	        <input type="text" name="wr_link2" value="" id="wr_link2" class="frm_input full_input" size="50" placeholder="링크를 입력해 주세요.">
	    </div>
	    
	    
	    
	    <div class="bo_w_flie write_div">
	        <div class="file_wr write_div">
	            <label for="bf_file_1" class="lb_icon"><i class="fa fa-download" aria-hidden="true"></i><span class="sound_only"> 파일 #1</span></label>
	            <input type="file" name="bf_file[]" id="bf_file_1" title="파일첨부 1 : 용량 1,048,576 바이트 이하만 업로드 가능" class="frm_file ">
	        </div>       
	    </div>
    	<!-- write box (e) -->
		
		
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
	        <input type="submit" value="작성완료" id="btn_submit" accesskey="s" class="btn_submit btn">
	    </div>
	    
	    
    </form>
    
</div>
<!-- qna_container (e) -->


</body>
</html>