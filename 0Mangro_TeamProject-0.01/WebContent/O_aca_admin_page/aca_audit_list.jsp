<%@page import="mango.util.StringToDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<!------------------------------------------ [ 메타데이터 ] --------------------------------------------------------------->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!------------------------------------------ [ 제이쿼리 ] --------------------------------------------------------------->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<!------------------------------------------ [ CSS ] --------------------------------------------------------------->
<link href="styles/assets/libs/fullcalendar/dist/fullcalendar.min.css" rel="stylesheet" />
<link href="styles/dist/css/style.min.css" rel="stylesheet">
<link href="styles/aca_admin_page.css" rel="stylesheet">
<link href="styles/table_style.css" rel="stylesheet">
  
  
  <style type="text/css">
  
  	input[type=radio] {display: none; margin:10px;}
	input[type=radio] + label {
		display: inline-block;
		margin: -2px;
		padding: 8px 19px;
		background-color: #f5f5f5;
		border: 1px solid #ccc;
		font-size: 13px !important;
		width: 110px;
		text-align: center;
	}
  
	input[type=radio] {
		background-image: none;
		color: #fff;
	}
	
	input[type=radio]:checked {
  		background-color: black;
	}
	
	
  	label {
	  	padding: 10px;
	    color: #fff;
	    border-radius: 10px;
  	
  	}
  	
  	.audit_yes {background-color: #378ffd;}
  	.audit_no {background-color: #fff; border: 1px solid; color: #000;}
  
	.prev, .next {font-size: 1em;}
	.pagination {
		width: 400px !important;
	    margin: auto !important;
	}
	
  </style>  	  

</head>

<body>
<%----------------------------JSTL 변수 설정----------------------------%>
<%-- <c:set var="email" value="${email}"/> --%>

<%-------------------------------------------------------------------%>
<!------------------------------------------ [ 페이지로더 ] --------------------------------------------------------------->
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
<!------------------------------------------ [ 중앙영역 ] --------------------------------------------------------------->
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper" data-theme="light" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full" data-sidebar-position="fixed" data-header-position="fixed" data-boxed-layout="full">
    
    
    <!--     ==============================================================
        Topbar header - style you can find in pages.scss
        ============================================================== -->
        <header class="topbar" data-navbarbg="skin6">
            <nav class="navbar top-navbar navbar-expand-md">
                <div class="navbar-header" data-logobg="skin6">
                    <!-- This is for the sidebar toggle which is visible on mobile only -->
                    <a class="nav-toggler waves-effect waves-light d-block d-md-none" href="javascript:void(0)"><i
                            class="ti-menu ti-close"></i></a>
                    <!-- ==============================================================
                    Logo
                    ============================================================== -->
                    <div class="navbar-brand">
                        <!-- Logo icon -->
                            <span class="logo-text">
                            
                                <h1 class="mypagelogo">학원 관리 페이지</h1>
                            </span>
                    </div>
                    <!-- ==============================================================
                    End Logo
                    ==============================================================
                    ==============================================================
                    Toggle which is visible on mobile only
                    ============================================================== -->
                    <a class="topbartoggler d-block d-md-none waves-effect waves-light" href="javascript:void(0)"
                        data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><i
                            class="ti-more"></i></a>
                </div>
<!------------------------------------------ [ 'USER  님, 안녕하세요' 영역 ] --------------------------------------------------------------->
                <div class="navbar-collapse collapse" id="navbarSupportedContent">
<!--                     ==============================================================
                    Right side toggle and nav items
                    ============================================================== -->
                    <ul class="navbar-nav float-right">

<!--                         ==============================================================
                        User profile and search
                        ============================================================== -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="javascript:void(0)" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <img src="styles/assets/images/users/profile-pic.jpg" alt="user" class="rounded-circle"
                                    width="40">
                                <span class="ml-2 d-none d-lg-inline-block"><span>${email}</span> <span
                                        class="text-dark">님, 안녕하세요.</span> <i data-feather="chevron-down"
                                        class="svg-icon"></i></span>
                            </a>
                        </li>
<!--                         ==============================================================
                        User profile and search
                        ============================================================== -->
                    </ul>
                </div>
            </nav>
        </header>
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
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
                        	<span class="hide-menu divide">개인설정 및 관리</span>
                        	<span class="rounded p-1 font-footnote border text-primary" style="margin-left: 30px; color:#6610f2 !important" >
                        		학원관리자
                        	</span>
                        	
                        </li>

                        <li class="sidebar-item"> 
                        	<a class="sidebar-link" href="./MyListPayment.pay"
                                aria-expanded="false">
                                <i data-feather="sidebar" class="feather-icon"></i>
                                <span class="hide-menu">멤버십 결제</span>
                            </a>
                        </li>
                        
                        
                                    
                        <li class="sidebar-item"> 
                        	<a class="sidebar-link sidebar-link" href="./MemberUpdate.me"
                                aria-expanded="false"><i data-feather="user" class="feather-icon"></i>
                                <span class="hide-menu">내 정보</span>
							</a>
						</li>
						
						

<!---------------------------------------------[내 컨텐츠 영역 ]-------------------------------------------------------------->
                        <li class="list-divider"></li> <!-- 구분선 -->
                        
						
                        <li class="nav-small-cap"><span class="hide-menu divide" >학원관리</span></li>
                        
                        <li class="sidebar-item"> 
                       	 	<a class="sidebar-link sidebar-link" 
                       	 		href="./AcademyGetAdminInfo.aca"
                           		aria-expanded="false">
                                <i class="fa fa-building-o" aria-hidden="true"></i>
                                <span class="hide-menu">학원 정보</span>
							</a>
						</li>
                                    
                        <li class="sidebar-item"> 
                        	<a class="sidebar-link sidebar-link"
                        		href="./auditGetInfo.adma"            
                                aria-expanded="false"><i data-feather="edit" class="feather-icon"></i>
                                <span class="hide-menu">청강신청 가능일 등록 </span>
							</a>
						</li>
						
						<!-- 청강신청현황 버튼 클릭 시 AuditList 가져오는 서블릿 페이지 실행 -->
                        <li class="sidebar-item"> 
                       <!--  href="4index.jsp?center=O_aca_admin_page/aca_audit_list.jsp" -->
                        	<a class="sidebar-link sidebar-link" 
                        		href="./ListAction.adrq"
                                aria-expanded="false"><i data-feather="book" class="feather-icon"></i>
                                <span class="hide-menu">청강신청 현황</span>
                            </a>
						</li>
                                    
                        
                        <li class="list-divider"></li> <!-- 구분선 -->
                        <li class="nav-small-cap"><span class="hide-menu divide">계정관련</span></li>


                        <li class="sidebar-item"> 
                        	<a class="sidebar-link sidebar-link" href=""
                                aria-expanded="false"><i data-feather="log-out" class="feather-icon"></i>
                                <span class="hide-menu">로그아웃</span>
                            </a>
						</li>

                        <li class="sidebar-item"> 
                        	<a class="sidebar-link sidebar-link"
                                href="4index.jsp?center=member/member_secede.jsp" aria-expanded="false">
                                <i data-feather="box" class="feather-icon"></i>
                                <span class="hide-menu">회원탈퇴</span>
                            </a>
                        </li>
                    </ul>
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        
        
        
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
        
        
        
 <!----------------------------------[ 마이페이지 센터영역(표시내용 바뀌는 곳) ]---------------------------------------------------------->
            
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->

 
           <div class="container-fluid">
           
                <div class="row">   <!-- 표시하고자 하는 데이터가 row 안에 있어야 함. 삭제x -->
 
 <!----------------------------------[ 테이블]---------------------------------------------------------->


                    <!-- 청강 신청 목록 -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">청강신청 현황</h4>
                                <h6 class="card-subtitle">학원의 청강신청내역이 최근순으로 표시됩니다.</h6>
                                <h6 style="text-decoration: underline;">총 신청 수 : ${total}, &nbsp;&nbsp; 승인된 청강 수 : ${count_approved} </h6>
                                
                            </div>
                            <div class="table-responsive">         
                                <table class="table">
                                    <thead class="thead-light">
                                        <tr>
                                            <th scope="col">예약번호</th>
                                            <th scope="col">신청자(계정)</th>
                                            <th scope="col">학원지정번호</th>
                                            <th scope="col">학원명</th>
                                            <th scope="col">청강신청과목</th>
                                            <th scope="col">청강신청일자</th>
                                            <th scope="col">청강희망일자</th>
                                            <th scope="col">청강승인일자</th>
                                            <th scope="col">승인</th>
                                            <th scope="col">취소</th>
                                            <th scope="col">삭제</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<!-- 각 행별로 check값을 구분할 변수 -->
                                    	<c:set var="idx" value="0" />	                                    	
                                    	<c:forEach var="list" items="${requestScope.AuditList}">	                                    	                                 
                                        <tr>	                                          
                                            <th scope="row">${list.auditNum}</th>
                                            <td>${list.memEmail}</td>
                                            <td>${list.acaNum}</td>	
                                            <td>${list.acaName}</td>
                                            <td>${list.auditSubject}</td>
                                            <td>${list.auditRequestDate}</td>
                                            <td>${list.auditWishDate}</td>
                                            <td>${list.auditConfirmDate}</td>                     
                                            <td>            
                                                <label class="audit_yes">승인                                     		
	                                            	<input type="radio" name="audit_check" id="approve" 
	                                          			onclick="fncApprove(${list.auditNum}, ${list.acaNum})">
                                            	</label>                                                 	
                                            </td>
                                            <td>
                                            	<label class="audit_no">취소
                                            		<input type="radio" name="audit_check" id="reject" 
	                                            		onclick="fncReject(${list.auditNum}, ${list.acaNum})">
                                            	</label>
                                            </td>  	 
                                            <td>
                                            	<label class="audit_no">삭제
                                            		<input type="radio" name="audit_check" id="delete" 
	                                            		onclick="fncDelete(${list.auditNum}, ${list.acaNum})">
                                            	</label>
                                            </td>  	                                               
                                        </tr>     
                                        <c:set var="idx" value="${idx + 1}" />                         
                                       </c:forEach> 
                                     
                                       
                                        <!-- <tr>
                                            <th scope="row">12345678</th>
                                            <td>user1@naver.com</td>
                                            <td>456541</td>
                                            <td>망고학원</td>
                                            <td>망고영어회화</td>
                                            <td>2020-08-20</td>
                                            <td>2020-08-25</td>
                                            <td></td>
                                            <td>
                                            	<label class="audit_yes">승인
	                                            	<input type="radio" name="a" >
                                            	</label>
                                            </td>
                                            <td>
                                            	<label class="audit_no">취소
	                                            	<input type="radio" name="a">
                                            	</label>
                                            </td>
                                        </tr>                     
                                       
                                      -->

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
 


                    <!-- 페이징 영역 : li class속성에 동적으로 active를 주면 해당 페이지 숫자bgcolor 설정됨 -->
                    <ul class="pagination">
                    <!-- << (첫페이지로 가기) -->
					  <li class="page-item"> 
					  	<a class="page-link prev" href="#">
					  		<i data-feather="chevrons-left" class="svg-icon mr-2 ml-1"></i>
					  	</a>
					  </li>
					  
                    <!-- < (이전페이지 가기)-->
					  <!-- <li class="page-item active"> -->
					  <li class="page-item">
					  	<a class="page-link prev" href="#">
					  		<i data-feather="chevron-left" class="svg-icon mr-2 ml-1"></i>
					  	</a>
					  </li>
					  
					  <li class="page-item"><a class="page-link" href="#">1</a></li>
					  <li class="page-item"><a class="page-link" href="#">2</a></li>
					  <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <!-- > (다음페이지 가기)-->
					  <li class="page-item">
					  	<a class="page-link next" href="#">
						  	<i data-feather="chevron-right" class="svg-icon mr-2 ml-1"></i>
						</a>
					  </li>
                    <!-- >> (마지막페이지 가기)-->
					  <li class="page-item">
					  	<a class="page-link next" href="#">
						  	<i data-feather="chevrons-right" class="svg-icon mr-2 ml-1"></i>
						</a>
					  </li>
					</ul>
          

		


 <!----------------------------------[ 마이페이지 센터영역(표시내용 바뀌는 곳) 끝 ]---------------------------------------------------------->
                </div> <!-- row (해당 태그 이하는 삭제 x )-->     
           
                
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
    <script src="styles/assets/libs/jquery/dist/jquery.min.js"></script>
    <script src="styles/assets/extra-libs/taskboard/js/jquery.ui.touch-punch-improved.js"></script>
    <script src="styles/assets/extra-libs/taskboard/js/jquery-ui.min.js"></script>
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
    <script src="styles/assets/libs/fullcalendar/dist/fullcalendar.min.js"></script>
    <script src="styles/dist/js/pages/calendar/cal-init.js"></script>
    
	<!-- 여기서 쓸 함수들이 정의된 자바스크립트 파일 -->    
	<script src="./O_aca_admin_page/aca_audit_list.js"></script>
    
</body>

</html>