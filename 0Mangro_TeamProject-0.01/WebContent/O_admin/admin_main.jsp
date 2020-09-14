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
           
 

<%---------------------------------------------------------- 대시보드 --------------------------------------------------------------%>
			
<%----------------------------------- [회원 데이터] ---------------------------------------------------%>
                <div class="card-group">
                  <%----------------- [총 회원수] ---------------------------------------------%>
                    <div class="card border-right">
                        <div class="card-body">
                            <div class="d-flex d-lg-flex d-md-block align-items-center">
                                <div>
                                    <div class="d-inline-flex align-items-center">                          
                                    
                                    <%-- 총 회원수 --%>
                                        <h2 class="text-dark mb-1 font-weight-medium">
                                        	${memTotal}
                                        </h2>
                                    
                                    </div>
                                    <h6 class="text-muted font-weight-normal mb-0 w-100 text-truncate">
                                    	<span>총 회원수</span>
                                    </h6>
                                </div>
                                <div class="ml-auto mt-md-3 mt-lg-0">
                                    <span class="opacity-7 text-muted"><i data-feather="user-plus"></i></span>
                                </div>
                            </div>
                        </div>
                    </div>                  

<%----------------------------------- [등록 학원 데이터] ---------------------------------------------------%>
                    <div class="card border-right">
                        <div class="card-body">
                            <div class="d-flex d-lg-flex d-md-block align-items-center">
                                <div>
                                    <div class="d-inline-flex align-items-center">
                                    <%-- 총 등록 학원 수 --%>
                                        <h2 class="text-dark mb-1 font-weight-medium">
                                        	${acaCount}                                        	
                                        </h2>
                                    <%-- 총 등록 학원 수 --%>
                                        <span class="badge bg-danger font-12 text-white font-weight-medium badge-pill ml-2 d-md-none d-lg-block">
                                        	<span>전월대비 </span> -2.33% 
                                        </span>
                                    </div>
                                    <h6 class="text-muted font-weight-normal mb-0 w-100 text-truncate">총 학원수</h6>      

                                </div>
                                <div class="ml-auto mt-md-3 mt-lg-0">
                                    <span class="opacity-7 text-muted"><i class="fa fa-handshake-o" aria-hidden="true"></i></span>
                                </div>
                            </div>
                        </div>
                    </div>

 					<div class="card border-right">
                        <div class="card-body">
                            <div class="d-flex d-lg-flex d-md-block align-items-center">
                                <div>
                                    <div class="d-inline-flex align-items-center">
                                    <%-- 등록된 학원 수 --%>
                                        <h2 class="text-dark mb-1 font-weight-medium">
                                        	${registeredCount}                                        	
                                        </h2>
                                    <%-- 등록된 학원 수 --%>
                                        <span class="badge bg-danger font-12 text-white font-weight-medium badge-pill ml-2 d-md-none d-lg-block">
                                        	<span>전월대비 </span> -2.33% 
                                        </span>
                                    </div>
                                    <h6 class="text-muted font-weight-normal mb-0 w-100 text-truncate">등록된 학원수</h6>      

                                </div>
                                <div class="ml-auto mt-md-3 mt-lg-0">
                                    <span class="opacity-7 text-muted"><i class="fa fa-handshake-o" aria-hidden="true"></i></span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card border-right">
                        <div class="card-body">
                            <div class="d-flex d-lg-flex d-md-block align-items-center">
                                <div>
                                    <h2 class="text-dark mb-1 w-100 text-truncate font-weight-medium"><sup
                                            class="set-doller">₩</sup>${MonthMoney}</h2>
                                            
                                         
                                    <h6 class="text-muted font-weight-normal mb-0 w-100 text-truncate"><span>전월 서비스 결제액</span>
                                    </h6>
                                </div>
                                <div class="ml-auto mt-md-3 mt-lg-0">
                                    <span class="opacity-7 text-muted"><i class="fa fa-krw" aria-hidden="true"></i></span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex d-lg-flex d-md-block align-items-center">
                                <div>
                                    <h2 class="text-dark mb-1 font-weight-medium">
                                    	${regCount}
                                    </h2>
                                    <%-- 전월 대비 증가율 --%>
                                        <span class="badge bg-primary font-12 text-white font-weight-medium badge-pill ml-2 d-lg-block d-md-none"
                                              style="float: right;margin-top: -30px;">
                                        	<span>전월대비</span>+18.33%
                                        </span>   
                                    <h6 class="text-muted font-weight-normal mb-0 w-100 text-truncate">
                                     	<span>등록 요청 학원 수</span>
									</h6>
                                </div>
                                <div class="ml-auto mt-md-3 mt-lg-0">
                                    <span class="opacity-7 text-muted"><i class="fa fa-building-o" aria-hidden="true"></i></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <!-- *************************************************************** -->
                <!-- End First Cards -->
                <!-- *************************************************************** -->
                <!-- *************************************************************** -->
                <!-- Start Sales Charts Section -->
                <!-- *************************************************************** -->
                <div class="row">
                	<%----------------------------회원 현황 ---------------------------------------%>
                	<!-- col-lg-x로 너비 조절 -->
                    <!-- <div class="col-lg-4 col-md-12"> -->
                    <div class="col-lg-6 col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title"><span>회원 현황</span></h4>
                                <div id="campaign-v2" class="mt-2" style="height:283px; width:100%;"></div>
                                <!-- <div id="campaign-v2" class="ct-chart" style="height:283px; width:100%;"></div> -->
                                <ul class="list-style-none mb-0">
                                <%-- 회원현황 --%>
                                
                               <%-- 일반 회원 --%>
                                    <li class="mt-3">
                                        <i class="fas fa-circle text-cyan font-10 mr-2"></i>
                                        <span class="text-muted">일반 회원</span>
                                        <span class="text-dark float-right font-weight-medium">${isNormal} 명</span>
                                    </li>
                                    
                                <%-- 학원(관리자)회원 --%>
                                    <li class="mt-3">
                                        <i class="fas fa-circle text-primary font-10 mr-2"></i>
                                        <span class="text-muted">학원 회원</span>
                                        <span class="text-dark float-right font-weight-medium">${isAdmin} 명</span>
                                    </li>
                                    
                                <%-- 정지 회원 --%>
		                            <li class="mt-3">
		                                <i class="fas fa-circle text-warning font-10 mr-2"></i>
		                                <span class="text-muted">정지 회원</span>
		                                <span class="text-dark float-right font-weight-medium">${isBaned} 명</span>
		                            </li>
                                    
                                <%-- 탈퇴회원 --%>
                                    <li class="mt-3">
                                        <i class="fas fa-circle text-danger font-10 mr-2"></i>
                                        <span class="text-muted">탈퇴 회원</span>
                                        <span class="text-dark float-right font-weight-medium">${isSeceded} 명</span>
                                    </li>                              
                                
                                    
                                </ul>
                            </div>
                        </div>
                    </div>
                    
                    <%--------------------------서비스 결제액 추이-------------------------------%>
                    <!-- <div class="col-lg-4 col-md-12"> -->
                    <div class="col-lg-6 col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title"><span>서비스 결제액 추이</span></h4>
                                <div class="net-income mt-4 position-relative" style="height:294px;"></div>
                                <ul class="list-inline text-center mt-5 mb-2">
                                    <li class="list-inline-item text-muted font-italic">Sales for this month</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    
                    <%---------------------Earning by Location ---------------------------%>
                    <!-- 
                    <div class="col-lg-4 col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title mb-4">Earning by Location</h4>
                                <div class="" style="height:180px">
                                    <div id="visitbylocate" style="height:100%"></div>
                                </div>
                                <div class="row mb-3 align-items-center mt-1 mt-5">
                                    <div class="col-4 text-right">
                                        <span class="text-muted font-14">India</span>
                                    </div>
                                    <div class="col-5">
                                        <div class="progress" style="height: 5px;">
                                            <div class="progress-bar bg-primary" role="progressbar" style="width: 100%"
                                                aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                    </div>
                                    <div class="col-3 text-right">
                                        <span class="mb-0 font-14 text-dark font-weight-medium">28%</span>
                                    </div>
                                </div>
                                <div class="row mb-3 align-items-center">
                                    <div class="col-4 text-right">
                                        <span class="text-muted font-14">UK</span>
                                    </div>
                                    <div class="col-5">
                                        <div class="progress" style="height: 5px;">
                                            <div class="progress-bar bg-danger" role="progressbar" style="width: 74%"
                                                aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                    </div>
                                    <div class="col-3 text-right">
                                        <span class="mb-0 font-14 text-dark font-weight-medium">50%</span>
                                    </div>
                                </div>
                                <div class="row mb-3 align-items-center">
                                    <div class="col-4 text-right">
                                        <span class="text-muted font-14">USA</span>
                                    </div>
                                    <div class="col-5">
                                        <div class="progress" style="height: 5px;">
                                            <div class="progress-bar bg-cyan" role="progressbar" style="width: 60%"
                                                aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                    </div>
                                    <div class="col-3 text-right">
                                        <span class="mb-0 font-14 text-dark font-weight-medium">18%</span>
                                    </div>
                                </div>
                                <div class="row align-items-center">
                                    <div class="col-4 text-right">
                                        <span class="text-muted font-14">China</span>
                                    </div>
                                    <div class="col-5">
                                        <div class="progress" style="height: 5px;">
                                            <div class="progress-bar bg-success" role="progressbar" style="width: 50%"
                                                aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                    </div>
                                    <div class="col-3 text-right">
                                        <span class="mb-0 font-14 text-dark font-weight-medium">12%</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                 -->
                 
                <!-- *************************************************************** -->
                <!-- End Sales Charts Section -->
                <!-- *************************************************************** -->


                <!-- *************************************************************** -->
                <!-- Start Top Leader Table -->
                <!-- *************************************************************** -->
     <!--            <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-flex align-items-center mb-4">
                                    <h4 class="card-title">Top Leaders</h4>
                                    <div class="ml-auto">
                                        <div class="dropdown sub-dropdown">
                                            <button class="btn btn-link text-muted dropdown-toggle" type="button"
                                                id="dd1" data-toggle="dropdown" aria-haspopup="true"
                                                aria-expanded="false">
                                                <i data-feather="more-vertical"></i>
                                            </button>
                                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dd1">
                                                <a class="dropdown-item" href="#">Insert</a>
                                                <a class="dropdown-item" href="#">Update</a>
                                                <a class="dropdown-item" href="#">Delete</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="table-responsive">
                                    <table class="table no-wrap v-middle mb-0">
                                        <thead>
                                            <tr class="border-0">
                                                <th class="border-0 font-14 font-weight-medium text-muted">Team Lead
                                                </th>
                                                <th class="border-0 font-14 font-weight-medium text-muted px-2">Project
                                                </th>
                                                <th class="border-0 font-14 font-weight-medium text-muted">Team</th>
                                                <th class="border-0 font-14 font-weight-medium text-muted text-center">
                                                    Status
                                                </th>
                                                <th class="border-0 font-14 font-weight-medium text-muted text-center">
                                                    Weeks
                                                </th>
                                                <th class="border-0 font-14 font-weight-medium text-muted">Budget</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td class="border-top-0 px-2 py-4">
                                                    <div class="d-flex no-block align-items-center">
                                                        <div class="mr-3"><img
                                                                src="../assets/images/users/widget-table-pic1.jpg"
                                                                alt="user" class="rounded-circle" width="45"
                                                                height="45" /></div>
                                                        <div class="">
                                                            <h5 class="text-dark mb-0 font-16 font-weight-medium">Hanna
                                                                Gover</h5>
                                                            <span class="text-muted font-14">hgover@gmail.com</span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="border-top-0 text-muted px-2 py-4 font-14">Elite Admin</td>
                                                <td class="border-top-0 px-2 py-4">
                                                    <div class="popover-icon">
                                                        <a class="btn btn-primary rounded-circle btn-circle font-12"
                                                            href="javascript:void(0)">DS</a>
                                                        <a class="btn btn-danger rounded-circle btn-circle font-12 popover-item"
                                                            href="javascript:void(0)">SS</a>
                                                        <a class="btn btn-cyan rounded-circle btn-circle font-12 popover-item"
                                                            href="javascript:void(0)">RP</a>
                                                        <a class="btn btn-success text-white rounded-circle btn-circle font-20"
                                                            href="javascript:void(0)">+</a>
                                                    </div>
                                                </td>
                                                <td class="border-top-0 text-center px-2 py-4"><i
                                                        class="fa fa-circle text-primary font-12" data-toggle="tooltip"
                                                        data-placement="top" title="In Testing"></i></td>
                                                <td
                                                    class="border-top-0 text-center font-weight-medium text-muted px-2 py-4">
                                                    35
                                                </td>
                                                <td class="font-weight-medium text-dark border-top-0 px-2 py-4">$96K
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="px-2 py-4">
                                                    <div class="d-flex no-block align-items-center">
                                                        <div class="mr-3"><img
                                                                src="../assets/images/users/widget-table-pic2.jpg"
                                                                alt="user" class="rounded-circle" width="45"
                                                                height="45" /></div>
                                                        <div class="">
                                                            <h5 class="text-dark mb-0 font-16 font-weight-medium">Daniel
                                                                Kristeen
                                                            </h5>
                                                            <span class="text-muted font-14">Kristeen@gmail.com</span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-muted px-2 py-4 font-14">Real Homes WP Theme</td>
                                                <td class="px-2 py-4">
                                                    <div class="popover-icon">
                                                        <a class="btn btn-primary rounded-circle btn-circle font-12"
                                                            href="javascript:void(0)">DS</a>
                                                        <a class="btn btn-danger rounded-circle btn-circle font-12 popover-item"
                                                            href="javascript:void(0)">SS</a>
                                                        <a class="btn btn-success text-white rounded-circle btn-circle font-20"
                                                            href="javascript:void(0)">+</a>
                                                    </div>
                                                </td>
                                                <td class="text-center px-2 py-4"><i
                                                        class="fa fa-circle text-success font-12" data-toggle="tooltip"
                                                        data-placement="top" title="Done"></i>
                                                </td>
                                                <td class="text-center text-muted font-weight-medium px-2 py-4">32</td>
                                                <td class="font-weight-medium text-dark px-2 py-4">$85K</td>
                                            </tr>
                                            <tr>
                                                <td class="px-2 py-4">
                                                    <div class="d-flex no-block align-items-center">
                                                        <div class="mr-3"><img
                                                                src="../assets/images/users/widget-table-pic3.jpg"
                                                                alt="user" class="rounded-circle" width="45"
                                                                height="45" /></div>
                                                        <div class="">
                                                            <h5 class="text-dark mb-0 font-16 font-weight-medium">Julian
                                                                Josephs
                                                            </h5>
                                                            <span class="text-muted font-14">Josephs@gmail.com</span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-muted px-2 py-4 font-14">MedicalPro WP Theme</td>
                                                <td class="px-2 py-4">
                                                    <div class="popover-icon">
                                                        <a class="btn btn-primary rounded-circle btn-circle font-12"
                                                            href="javascript:void(0)">DS</a>
                                                        <a class="btn btn-danger rounded-circle btn-circle font-12 popover-item"
                                                            href="javascript:void(0)">SS</a>
                                                        <a class="btn btn-cyan rounded-circle btn-circle font-12 popover-item"
                                                            href="javascript:void(0)">RP</a>
                                                        <a class="btn btn-success text-white rounded-circle btn-circle font-20"
                                                            href="javascript:void(0)">+</a>
                                                    </div>
                                                </td>
                                                <td class="text-center px-2 py-4"><i
                                                        class="fa fa-circle text-primary font-12" data-toggle="tooltip"
                                                        data-placement="top" title="Done"></i>
                                                </td>
                                                <td class="text-center text-muted font-weight-medium px-2 py-4">29</td>
                                                <td class="font-weight-medium text-dark px-2 py-4">$81K</td>
                                            </tr>
                                            <tr>
                                                <td class="px-2 py-4">
                                                    <div class="d-flex no-block align-items-center">
                                                        <div class="mr-3"><img
                                                                src="../assets/images/users/widget-table-pic4.jpg"
                                                                alt="user" class="rounded-circle" width="45"
                                                                height="45" /></div>
                                                        <div class="">
                                                            <h5 class="text-dark mb-0 font-16 font-weight-medium">Jan
                                                                Petrovic
                                                            </h5>
                                                            <span class="text-muted font-14">hgover@gmail.com</span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-muted px-2 py-4 font-14">Hosting Press HTML</td>
                                                <td class="px-2 py-4">
                                                    <div class="popover-icon">
                                                        <a class="btn btn-primary rounded-circle btn-circle font-12"
                                                            href="javascript:void(0)">DS</a>
                                                        <a class="btn btn-success text-white font-20 rounded-circle btn-circle"
                                                            href="javascript:void(0)">+</a>
                                                    </div>
                                                </td>
                                                <td class="text-center px-2 py-4"><i
                                                        class="fa fa-circle text-danger font-12" data-toggle="tooltip"
                                                        data-placement="top" title="In Progress"></i></td>
                                                <td class="text-center text-muted font-weight-medium px-2 py-4">23</td>
                                                <td class="font-weight-medium text-dark px-2 py-4">$80K</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> -->
                <!-- *************************************************************** -->
                <!-- End Top Leader Table -->
                <!-- *************************************************************** -->






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




<%-- [자바스크립트] --%>    
<script>

window.onload = function(){
	
	
	// ==============================================================
    // 회원 현황
    // c3.js library
    // https://c3js.org/samples/chart_donut.html
    // https://c3js.org/reference.html
    // ==============================================================
    var isNormal = ${isNormal};
    var isAdmin = ${isAdmin};
    var isBaned = ${isBaned};
    var isSeceded = ${isSeceded};
    
    var memMap = new Map();
    memMap.set('isNormal', isNormal);
    memMap.set('isAdmin', isAdmin);
    memMap.set('isBaned', isBaned);
    memMap.set('isSeceded', isSeceded);    
    
    // DB로부터 받아온 값이 null이면 0으로 처리
    memMap.forEach(function(value, key){
    	//console.log('value : '+value + ', key : '+key);
    	if(value == null){
    		value = 0;
    	}    	
    });    
    //console.log(memMap);
    	
	var pieData = {
			 '일반 회원': memMap.get('isNormal'),
             '학원 회원': memMap.get('isAdmin'),
             '정지 회원': memMap.get('isBaned'),
             '탈퇴 회원': memMap.get('isSeceded')
	};	
	
	//console.log(pieData); 
	

    var chart1 = c3.generate({
        bindto: '#campaign-v2',
        data: {
        	
        	json: [pieData],
        	keys: {
        		value: Object.keys(pieData),
        	},            
            type: 'donut',
            tooltip: {
                show: true
            },
        	
        },
        donut: {
            label: {
                show: false
            },
            title: '회원 현황',
            width: 22
        },
        

        legend: {
            hide: true
        },
        color: {
            pattern: [
                '#2EFEF7',
                '#5f76e8',
                '#F4FA58',                
               	'#FA5858'
               	//'#edf2f6',
                //'#5f76e8',
               	//'#ff4f70',
                //'#01caf1'
            ]
        }
    });   
        
    d3.select('#campaign-v2 .c3-chart-arcs-title').style('font-family', 'Rubik');
	
}; 

</script>  
    
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
    
    <!-- 관리자메뉴 chartist 라이브러리 설정 파일 : 일반파일, 축약파일(min.js) 중 택일 -->
    <script src="./O_admin/admin_main_dashboard.js"></script>    
    <!-- <script src="styles/dist/js/pages/dashboards/dashboard1.js"></script> -->   
    <!-- <script src="styles/dist/js/pages/dashboards/dashboard1.min.js"></script>  -->   
    
    <script src="styles/assets/extra-libs/jvector/jquery-jvectormap-2.0.2.min.js"></script>
    <script src="styles/assets/extra-libs/jvector/jquery-jvectormap-world-mill-en.js"></script>    

    
</body>
</html>