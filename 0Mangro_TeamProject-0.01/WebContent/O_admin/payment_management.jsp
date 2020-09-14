<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<!------------------------------------------ [ 메타데이터 ] --------------------------------------------------------------->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!------------------------------------------ [ 제이쿼리 ] --------------------------------------------------------------->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tagsinput/0.8.0/bootstrap-tagsinput.min.js"></script>

<!------------------------------------------ [ CSS ] --------------------------------------------------------------->
<link href="styles/assets/libs/fullcalendar/dist/fullcalendar.min.css" rel="stylesheet" />
<link href="styles/dist/css/style.min.css" rel="stylesheet">
<link href="styles/mypage_additional.css" rel="stylesheet">
<link href="styles/table_style.css" rel="stylesheet">
  
    
<style type="text/css">
.prev, .next {font-size: 1em;}
.pagination {
	width: 400px !important;
    margin: auto !important;
}
</style>      
    
</head>

<body>
<!------------------------------------------ [ 페이지로더 ] --------------------------------------------------------------->
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
<!------------------------------------------ [ 탑바 ] --------------------------------------------------------------->
    <div id="main-wrapper" data-theme="light" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full" data-sidebar-position="fixed" data-header-position="fixed" data-boxed-layout="full">
    
    
        <header class="topbar" data-navbarbg="skin6">
            <nav class="navbar top-navbar navbar-expand-md">
                <div class="navbar-header" data-logobg="skin6">
                    <!-- This is for the sidebar toggle which is visible on mobile only -->
                    <a class="nav-toggler waves-effect waves-light d-block d-md-none" href="javascript:void(0)"><i
                            class="ti-menu ti-close"></i></a>
                            
<!------------------------------------------ [ 로고 ] --------------------------------------------------------------->
                    <div class="navbar-brand">
                        <!-- Logo icon -->
                            <span class="logo-text">
                                <h1 class="mypagelogo">관리자 메뉴</h1>
                            </span>
                    </div>
                    
<!------------------------------------------ [ 토글바 ] --------------------------------------------------------------->
                    <a class="topbartoggler d-block d-md-none waves-effect waves-light" href="javascript:void(0)"
                        data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><i
                            class="ti-more"></i></a>
                </div>
<!------------------------------------------ [ 'USER  님, 안녕하세요' 영역 ] --------------------------------------------------------------->
                <div class="navbar-collapse collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav float-right">

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="javascript:void(0)" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <img src="styles/assets/images/users/profile-pic.jpg" alt="user" class="rounded-circle"
                                    width="40">
                                <span class="ml-2 d-none d-lg-inline-block"><span>${id_email}</span> <span
                                        class="text-dark">관리자1</span> 
                            </a>

                        </li>
                    </ul>
                </div>
            </nav>
        </header>
<!------------------------------------------ [ 사이드바 ] --------------------------------------------------------------->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <aside class="left-sidebar" data-sidebarbg="skin6" style="margin-top: 120px">
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar" data-sidebarbg="skin6">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                    
                        
<!---------------------------------------------[설정 및 관리 영역 ]-------------------------------------------------------------->
                        <li class="list-divider"></li> <!-- 구분선 -->
                        
                        <li class="nav-small-cap">
                        	<span class="hide-menu divide">데이터 관리</span>
                        	<span class="rounded p-1 font-footnote border text-primary">관리자</span>
                        	
                        </li>

                        <li class="sidebar-item"> 
                        	<a class="sidebar-link" href="./Management.pay"
                                aria-expanded="false">
                                <i data-feather="sidebar" class="feather-icon"></i>
                                <span class="hide-menu">결제 관리</span>
                            </a>
                        </li>
						
                        <li class="sidebar-item"> <a class="sidebar-link sidebar-link" 	
                        		href="./registerGetList.areg"
                                aria-expanded="false"><i class="fa fa-building-o" aria-hidden="true"></i>
                                <span class="hide-menu">등록 요청 학원관리</span></a>
						</li>

<!---------------------------------------------[내 컨텐츠 영역 ]-------------------------------------------------------------->
                        <li class="list-divider"></li> <!-- 구분선 -->
                        
                        <li class="nav-small-cap"><span class="hide-menu divide" >고객 관리</span></li>
                        
                        <li class="sidebar-item"> 
                        	<a class="sidebar-link sidebar-link" href="./MemberManagementAction.me"
                                aria-expanded="false"><i data-feather="users" class="feather-icon"></i>
                                <span class="hide-menu">회원관리</span>
                            </a>
						</li>
                                    
                        <li class="sidebar-item"> 
                        	<a class="sidebar-link sidebar-link" href="./QnaManagement.qna" 
                        	   aria-expanded="false" >
                        	
                        	<i data-feather="edit" class="feather-icon"></i><span
                                    class="hide-menu">문의답변관리</span>
							</a>
                                    
						</li>
						                                  
                        
                        <li class="list-divider"></li> <!-- 구분선 -->
                        <li class="nav-small-cap"><span class="hide-menu divide">계정 관리</span></li>


                        <li class="sidebar-item"> 
                        	<a class="sidebar-link sidebar-link" href="./AdminAnonyReportedListAction.anob"
                                aria-expanded="false"><i class="fa fa-thumb-tack" aria-hidden="true"></i>
                                <span class="hide-menu">회원 신고</span>
                            </a>
						</li>

                    </ul>
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>
        
        
        
        
 <!----------------------------------[ Page wrapper]---------------------------------------------------------->
        
        <div class="page-wrapper">
        
 <!----------------------------------[ 마이페이지 센터영역(표시내용 바뀌는 곳)  Container fluid]---------------------------------------------------------->
            
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->

 
           <div class="container-fluid">
           
 

<%---------------------------------------------------------- 테이블 --------------------------------------------------------------%>

                    
                    <%--- (일반회원)내가 작성한 문의글 --%>
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">서비스 결제 현황</h4>
                                <h6 class="card-subtitle">서비스 결제 현황이 무료회원 포함 최신순으로 표시됩니다.</h6>
                            </div>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class="thead-light">
                                        <tr>
                                            <th scope="col">결제계정</th>
                                            <th scope="col">사용회차</th>
                                            <th scope="col">서비스명</th>
                                            <th scope="col">시작일</th>
                                            <th scope="col">만료일</th>
                                            <th scope="col">유효여부</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                 <c:if test="${count >0}">   
                                 
                                 <c:forEach  var="i" items="${PayMentlist}">
                                        <tr>
                                            <th scope="row">${i.memEmail}</th>
                                            <td>${i.pmUseNum}</td>
                                            <td>${i.pmName}</td>
                                            <td>${i.pmStartDate}</td>
                                            <td>${i.pmExpDate}</td>
                                            <td>${i.pmCheck}</td>
                                        </tr>
                                 </c:forEach>       
                                        
                                </c:if>
                                    
                                 <c:if test="${count==0}">   
                                 
                                        <tr>
                                            <th scope="row" colspan="5">이용권을 사용하고 있는 회원목록이 없습니다</th>
                                        </tr>
                                        
                                </c:if>
                                
                                
                                
                                 
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    

                    
                    <!-- 페이징 영역 : li class속성에 동적으로 active를 주면 해당 페이지 숫자bgcolor 설정됨 -->
                    <ul class="pagination">
                    <!-- << (첫페이지로 가기) -->
					  <li class="page-item"> 
					  	<a class="page-link prev" href="${Page}&pageNum=1">
					  		<i data-feather="chevrons-left" class="svg-icon mr-2 ml-1"></i>
					  	</a>
					  </li>
					 
					<c:if test="${count!=0}">   
                    <!-- < (이전페이지 가기)-->
					     <!-- < (이전페이지 가기) 설정-->
					  <li class="page-item">
					  	<c:if test="${startPage-pageBlock<0}">
					  		<c:set var="pN" value="1"/>
					  	</c:if>
					  	
					  	<c:if test="${startPage-pageBlock>0}">
					  		<c:set var="pN" value="${startPage-pageBlock}"/>
					  	</c:if>
					  
					  	<a class="page-link prev" href="${Page}&pageNum=${pN}">
					  		<i data-feather="chevron-left" class="svg-icon mr-2 ml-1"></i>
					  	</a>	
					  </li>
					  
					  
					 <c:forEach var="i" begin="${startPage}" end="${endPage}">			  
					  <li class="page-item ${pageNum == i ? 'active' : ''}"><a class="page-link" href="${Page}&pageNum=${i}">${i}</a></li>
					 
					</c:forEach>	
		
					  
					  
					  
					  <!-- 끝 페이지 앞으로가기 설정 -->
					   	<c:if test="${startPage+pageBlock>pageCount}">
					  		<c:set var="pP" value="${pageCount}"/>
					  	</c:if>
					  	
					  	<c:if test="${startPage+pageBlock<pageCount}">
					  		<c:set var="pP" value="${startPage+pageBlock}"/>
					  	</c:if>
					  
					  <li class="page-item"><%--다음 페이지 --%>
					  	<a class="page-link next" href="${Page}&pageNum=${pP}">
						  	<i data-feather="chevron-right" class="svg-icon mr-2 ml-1"></i>
						</a>
					  </li>
                    
                    <!-- >> (마지막페이지 가기)-->
					  <li class="page-item">
					  	<a class="page-link next" href="${Page}&pageNum=${pageCount}">
						  	<i data-feather="chevrons-right" class="svg-icon mr-2 ml-1"></i>
						</a>
					  </li>
					  
					  </c:if>
					</ul>                    
                 
                    



















 <!----------------------------------[ 마이페이지 센터영역(표시내용 바뀌는 곳) 끝 ]---------------------------------------------------------->
           
                
            </div> <!-- container-fluid -->



        </div> <!-- page-wrapper -->
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
    </div> <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
    



	<!-- Partners -->
<!-- 임시저장
	<div class="partners">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="partners_slider_container">
						<div class="owl-carousel owl-theme partners_slider">
							Partner Item
							<div class="owl-item partner_item"><img src="images/partner_1.png" alt=""></div>
							Partner Item
							<div class="owl-item partner_item"><img src="images/partner_2.png" alt=""></div>
							Partner Item
							<div class="owl-item partner_item"><img src="images/partner_3.png" alt=""></div>
							Partner Item
							<div class="owl-item partner_item"><img src="images/partner_4.png" alt=""></div>
							Partner Item
							<div class="owl-item partner_item"><img src="images/partner_5.png" alt=""></div>
							Partner Item
							<div class="owl-item partner_item"><img src="images/partner_6.png" alt=""></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
 -->





    
    
    
<!----------------------------------------[자바스크립트 영역------------------------------------------------------------------->    
    <script src="styles/assets/libs/jquery/dist/jquery.min.js"></script>
    <script src="styles/assets/libs/popper.js/dist/umd/popper.min.js"></script>
    <script src="styles/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- apps -->
    <script src="styles/dist/js/app-style-switcher.js"></script>
    <script src="styles/dist/js/feather.min.js"></script>
    <script src="styles/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
    <script src="styles/assets/extra-libs/sparkline/sparkline.js"></script>
    <script src="styles/dist/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="styles/dist/js/custom.min.js"></script>
    <!--This page JavaScript -->
    <script src="styles/assets/libs/moment/min/moment.min.js"></script>
    
    <script src="styles/assets/extra-libs/c3/d3.min.js"></script>
    <script src="styles/assets/extra-libs/c3/c3.min.js"></script>
    <script src="styles/assets/libs/chartist/dist/chartist.min.js"></script>
    <script src="styles/assets/libs/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>
    
    <script src="styles/dist/js/pages/dashboards/dashboard1.min.js"></script>    
    <script src="styles/assets/extra-libs/jvector/jquery-jvectormap-2.0.2.min.js"></script>
    <script src="styles/assets/extra-libs/jvector/jquery-jvectormap-world-mill-en.js"></script>    

    
</body>
</html>