<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16" href="images/favicon/favicon.ico">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/common_header.css">
<link rel="stylesheet" type="text/css" href="styles/common_footer.css">
<title>Mango</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>

<!------------------------------- [ 카카오 톡상담 & top버튼 style태그 ] ----------------------------------------------->
<style type="text/css">

	/* 카카오톡 상담버튼 (pc 화면) */
	@media (min-width: 768px) {
	    #kakao-talk-channel-chat-button {
	    position: fixed;
	    z-index: 999;
	    right: 30px; /* 화면 오른쪽으로부터의 거리 */
	    bottom: 30px; /* 화면 아래쪽으로부터의 거리 */
	    }
	}
	
	/* 카카오톡 상담버튼 (모바일 화면) */
	@media (max-width:767px) {
	    #kakao-talk-channel-chat-button {
	    position: fixed;
	    z-index: 999;
	    right: 15px; /* 화면 오른쪽으로부터의 거리 */
	    bottom: 30px; /* 화면 아래쪽으로부터의 거리 */
	    }
	}
	
	
	
	/* 카카오톡 상담버튼 (top버튼) */
	@media (min-width: 768px) {
	    #top_btn {
	    position:fixed;
	    z-index: 999;
	    right: 30px; /* 화면 오른쪽으로부터의 거리 */
	    bottom: 200px; /* 화면 아래쪽으로부터의 거리 */
	    cursor: pointer;
	    }
	}
	/* 카카오톡 상담버튼 (top버튼) */
	@media (max-width:767px) {
	
	
	    #top_btn {
	    position:fixed;
	    z-index: 999;
	    right: 15px; /* 화면 오른쪽으로부터의 거리 */
	    bottom: 200px; /* 화면 아래쪽으로부터의 거리 */
	    cursor: pointer;
	    }
	}


</style>

<!------------------------------- [ 카카오톡상담 버튼div & 자바스크립트 ] ----------------------------------------------->

<div id="kakao-talk-channel-chat-button"></div>

<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('55194aa4c6155a17ae45a0f20ab60d67');
    // 카카오톡 채널 1:1채팅 버튼을 생성합니다.
    Kakao.Channel.createChatButton({
      container: '#kakao-talk-channel-chat-button',
      channelPublicId: '_ieyqK' // 카카오톡 채널 홈 URL에 명시된 id로 설정합니다.
    });
  //]]>
</script>



<!--------------------------- [ top 버튼 자바스크립트 ] ------------------------------------------------------>

<script type="text/javascript">

    $(function() {
    	
        $(window).scroll(function() {
            if ($(this).scrollTop() > 300) {
                $('#top_btn').show();
            } else {
                $('#top_btn').hide();
            }
        });
        
        $("#top_btn").click(function() {
            $('html, body').animate({
                scrollTop : 0
            }, 800);
            return false;
        });
    });
    
</script>




<body>
<!--------------------------- [ top 버튼  ] ------------------------------------------------------>
	<a id="top_btn"><img src="images/etc/top_button.png" width="56px" ></a>

<!---------------------------------- [ Top 영역 ] --------------------------------------------------->

	<jsp:include page="1Top.jsp"/>
		
<!---------------------------------- [ Center 영역 ] --------------------------------------------------->

	<c:set var="center" value="${param.center}"/>
	
	<c:if test="${center == null}"> 
		<c:set var="center" value="3main.jsp"/>
	</c:if>
	
	<!-- center 영역의 공통 콘텐츠 영역 틀 -->
	<div class="super_container"> 
		<jsp:include page="${center}"/>
	</div> 

<!---------------------------------- [ Bottom 영역 ] --------------------------------------->
	<jsp:include page="2Bottom.jsp"/>

</body>
</html>