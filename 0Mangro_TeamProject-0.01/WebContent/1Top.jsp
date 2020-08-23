<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title></title>
<!---------------------[ 메타데이터 ]----------------------------------------------------------->    
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Mango project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!---------------------[ 제이쿼리 ]------------------------------------------------------------>    
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<!---------------------[  CSS  ]------------------------------------------------------------->    
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">
<link rel="stylesheet" type="text/css" href="styles/common_header.css">
</head>
<body>


<!---------------------------------- [로그인 여부 세션 체크]---------------------------------------->

<!------------- 편의를 위해 admin으로 로그인했다고 가정하고 작성해두었음.--------------------------------------->

<c:set var="id" value="usertop"/>



	<!-- Header -->

	<header class="header">		
		<!-- Top Bar -->
		<div class="top_bar">
			<div class="top_bar_container">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="top_bar_content d-flex flex-row align-items-center justify-content-start">
								<ul class="top_bar_contact_list">
									<li><div class="question">ㅎㅎㅎ</div></li>
									<li>
										<i class="fa fa-phone" aria-hidden="true"></i>
										<div>001-1234-88888</div>
									</li>
									<li>
										<i class="fa fa-envelope-o" aria-hidden="true"></i>
										<div>info.deercreative@gmail.com</div>
									</li>
								</ul>
								<div class="top_bar_login ml-auto">
									<div class="top_bar_button admin-register">
									<a href="4index.jsp?center=O_academy/academy_register.jsp">학원관리자 등록</a>
									</div>
									<div class="top_bar_button sign-up">
										<a href="4index.jsp?center=O_member/member_sign_up.jsp">회원가입</a>
									</div>
									
								<!--  1.아이디가 null값이면 [로그인] 로그인된 상태면 
									  2-1. 관리자라면 [관리자 메뉴] [로그아웃] 표시 	
									  2-2. 회원이면 [마이페이지] [로그아웃] 표시           -->
									<c:choose>
									
										
										<c:when test="${id == null or id == '' }">
											<div class="top_bar_button sign-up sign-in">
												<a href="4index.jsp?center=O_member/member_sign_in.jsp">로그인</a>
											</div>
										</c:when>
										
										<c:when test="${id == 'admin' }">
											<div class="top_bar_button admin_page">
												<a href="">관리자 메뉴</a>
											</div>
											<div class="top_bar_button logout">
												<a href="">로그아웃</a>
											</div>
										</c:when>
										
										<c:otherwise>
											<div class="top_bar_button mypage">
												<a href="4index.jsp?center=O_mypage/mypage_main.jsp">마이페이지</a>
											</div>
											<div class="top_bar_button logout">
												<a href="">로그아웃</a>
											</div>
										</c:otherwise>
										
									</c:choose>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>				
		</div>

		<!-- Header Content -->
		<div class="header_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="header_content d-flex flex-row align-items-center justify-content-start">
							<div class="logo_container">
								<a href="4index.jsp">
									<div class="logo_text">Man<span>go</span></div>
								</a>
							</div>
							<nav class="main_nav_contaner ml-auto">
								<ul class="main_nav">
									<li><a href="4index.jsp?center=about.jsp">소개</a></li>
									<li><a href="4index.jsp?center=O_academy/academy_list.jsp">학원찾기</a></li>
									<li><a href="4index.jsp?center=O_anony/anony_board.jsp">익명사담방</a></li>
									<li><a href="4index.jsp?center=O_aca_admin_page/aca_admin_main.jsp">학원관리자</a></li>
									<li><a href="4index.jsp?center=O_qna/qna_board.jsp">고객센터</a></li>
								</ul>
								
								
								
<!-- 								<div class="search_button"><i class="fa fa-search" aria-hidden="true"></i></div>
 -->
								<!-- 장바구니 아이콘(이용내역페이지 연결) -->

								<div class="shopping_cart" onclick="location.href='4index.jsp?center=O_payment/payment_list.jsp'"><i class="fa fa-shopping-cart" aria-hidden="true"></i></div>
								<div class="hamburger menu_mm">
									<i class="fa fa-bars menu_mm" aria-hidden="true"></i>
									
								</div>
							</nav>

						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Header Search Panel -->
		<div class="header_search_container">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="header_search_content d-flex flex-row align-items-center justify-content-end">
							<form action="#" class="header_search_form">
								<input type="search" class="search_input" placeholder="Search" required="required">
								<button class="header_search_button d-flex flex-column align-items-center justify-content-center">
									<i class="fa fa-search" aria-hidden="true"></i>
								</button>
							</form>
						</div>
					</div>
				</div>
			</div>			
		</div>			
	</header>

	<!-- 반응형일때 Menu -->

	<div class="menu d-flex flex-column align-items-end justify-content-start text-right menu_mm trans_400">
		<div class="menu_close_container"><div class="menu_close"><div></div><div></div></div></div>
		<div class="search">
			<form action="#" class="header_search_form menu_mm">
				<input type="search" class="search_input menu_mm" placeholder="Search" required="required">
				<button class="header_search_button d-flex flex-column align-items-center justify-content-center menu_mm">
					<i class="fa fa-search menu_mm" aria-hidden="true"></i>
				</button>
			</form>
		</div>
		<nav class="menu_nav">
			<ul class="menu_mm">
			
				<li class="menu_mm"><a href="4index.jsp?center=about.jsp">소개</a></li>
				<li class="menu_mm"><a href="4index.jsp?center=O_academy/academy_list.jsp">학원찾기</a></li>
				<li class="menu_mm"><a href="4index.jsp?center=O_anony/anony_board.jsp">익명사담방</a></li>
				<li class="menu_mm"><a href="4index.jsp?center=O_aca_admin_page/aca_admin_main.jsp">학원관리자</a></li>
				<li class="menu_mm"><a href="4index.jsp?center=O_qna/qna_board.jsp">고객센터</a></li>
				<li class="menu_mm"><a href="4index.jsp?center=O_mypage/mypage_main.jsp">마이페이지</a></li>
			</ul>
		</nav>
	</div>
