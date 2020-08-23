<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지-메인</title>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="styles/assets/images/favicon.png">
    <title>마이페이지-메인</title>
    <!-- Custom CSS -->
    <link href="styles/assets/libs/fullcalendar/dist/fullcalendar.min.css" rel="stylesheet" />
    <!-- Custom CSS -->
    <link href="styles/dist/css/style.min.css" rel="stylesheet">
    <link href="styles/mypage_additional.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>

<body>
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
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
                            
                                <h1 class="mypagelogo">마이페이지</h1>
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
            	<!--     ==============================================================
                End Logo
                ============================================================== -->
                <div class="navbar-collapse collapse" id="navbarSupportedContent">
                <!--     ==============================================================
                    toggle and nav items
                    ============================================================== -->
                    <ul class="navbar-nav float-left mr-auto ml-3 pl-1">
                        <!-- 상단알림바(종모양 톱니바퀴) -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle pl-md-3 position-relative" href="javascript:void(0)"
                                id="bell" role="button" data-toggle="dropdown" aria-haspopup="true"
                                aria-expanded="false">
                                <span><i data-feather="bell" class="svg-icon"></i></span>
                                <span class="badge badge-primary notify-no rounded-circle">5</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-left mailbox animated bounceInDown">
                                <ul class="list-style-none">
                                    <li>
                                        <div class="message-center notifications position-relative">
                                            <!-- Message -->
                                            <a href="javascript:void(0)"
                                                class="message-item d-flex align-items-center border-bottom px-3 py-2">
                                                <div class="btn btn-danger rounded-circle btn-circle"><i
                                                        data-feather="airplay" class="text-white"></i></div>
                                                <div class="w-75 d-inline-block v-middle pl-2">
                                                    <h6 class="message-title mb-0 mt-1">Luanch Admin</h6>
                                                    <span class="font-12 text-nowrap d-block text-muted">Just see
                                                        the my new
                                                        admin!</span>
                                                    <span class="font-12 text-nowrap d-block text-muted">9:30 AM</span>
                                                </div>
                                            </a>
                                            <!-- Message -->
                                            <a href="javascript:void(0)"
                                                class="message-item d-flex align-items-center border-bottom px-3 py-2">
                                                <span class="btn btn-success text-white rounded-circle btn-circle"><i
                                                        data-feather="calendar" class="text-white"></i></span>
                                                <div class="w-75 d-inline-block v-middle pl-2">
                                                    <h6 class="message-title mb-0 mt-1">Event today</h6>
                                                    <span
                                                        class="font-12 text-nowrap d-block text-muted text-truncate">Just
                                                        a reminder that you have event</span>
                                                    <span class="font-12 text-nowrap d-block text-muted">9:10 AM</span>
                                                </div>
                                            </a>
                                            <!-- Message -->
                                            <a href="javascript:void(0)"
                                                class="message-item d-flex align-items-center border-bottom px-3 py-2">
                                                <span class="btn btn-info rounded-circle btn-circle"><i
                                                        data-feather="settings" class="text-white"></i></span>
                                                <div class="w-75 d-inline-block v-middle pl-2">
                                                    <h6 class="message-title mb-0 mt-1">Settings</h6>
                                                    <span
                                                        class="font-12 text-nowrap d-block text-muted text-truncate">You
                                                        can customize this template
                                                        as you want</span>
                                                    <span class="font-12 text-nowrap d-block text-muted">9:08 AM</span>
                                                </div>
                                            </a>
                                            <!-- Message -->
                                            <a href="javascript:void(0)"
                                                class="message-item d-flex align-items-center border-bottom px-3 py-2">
                                                <span class="btn btn-primary rounded-circle btn-circle"><i
                                                        data-feather="box" class="text-white"></i></span>
                                                <div class="w-75 d-inline-block v-middle pl-2">
                                                    <h6 class="message-title mb-0 mt-1">Pavan kumar</h6> <span
                                                        class="font-12 text-nowrap d-block text-muted">Just
                                                        see the my admin!</span>
                                                    <span class="font-12 text-nowrap d-block text-muted">9:02 AM</span>
                                                </div>
                                            </a>
                                        </div>
                                    </li>
                                    <li>
                                        <a class="nav-link pt-3 text-center text-dark" href="javascript:void(0);">
                                            <strong>Check all notifications</strong>
                                            <i class="fa fa-angle-right"></i>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
<!--                         End Notification
                        ==============================================================
                        create new
                        ============================================================== -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i data-feather="settings" class="svg-icon"></i>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>

                    </ul>
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
                                <span class="ml-2 d-none d-lg-inline-block"><span>user1</span> <span
                                        class="text-dark">님, 안녕하세요.</span> <i data-feather="chevron-down"
                                        class="svg-icon"></i></span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right user-dd animated flipInY">
                                <a class="dropdown-item" href="javascript:void(0)"><i data-feather="user"
                                        class="svg-icon mr-2 ml-1"></i>
                                    My Profile</a>
                                <a class="dropdown-item" href="javascript:void(0)"><i data-feather="credit-card"
                                        class="svg-icon mr-2 ml-1"></i>
                                    My Balance</a>
                                <a class="dropdown-item" href="javascript:void(0)"><i data-feather="mail"
                                        class="svg-icon mr-2 ml-1"></i>
                                    Inbox</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="javascript:void(0)"><i data-feather="settings"
                                        class="svg-icon mr-2 ml-1"></i>
                                    Account Setting</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="javascript:void(0)"><i data-feather="power"
                                        class="svg-icon mr-2 ml-1"></i>
                                    Logout</a>
                                <div class="dropdown-divider"></div>
                                <div class="pl-4 p-3"><a href="javascript:void(0)" class="btn btn-sm btn-info">View
                                        Profile</a></div>
                            </div>
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
                    
                        <li class="sidebar-item"> 
                        	<a class="sidebar-link sidebar-link" href="4index.jsp?center=3main.jsp"
                                aria-expanded="false"><i data-feather="home" class="feather-icon"></i>
                                <span class="hide-menu">메인으로 가기</span>
                            </a>
                        </li>
                        
<!---------------------------------------------[설정 및 관리 영역 ]-------------------------------------------------------------->
                        <li class="list-divider"></li> <!-- 구분선 -->
                        
                        <li class="nav-small-cap">
                        	<span class="hide-menu">설정 및 관리</span>
                        	<span class="rounded p-1 font-footnote border text-primary">일반인</span>
                        	
                        </li>

                        <li class="sidebar-item"> 
                        	<a class="sidebar-link" href="4index.jsp?center=mypage/paid_service_list.jsp"
                                aria-expanded="false">
                                <i data-feather="sidebar" class="feather-icon"></i>
                                <span class="hide-menu">멤버십 결제</span>
                            </a>
                        </li>
                        
                        
                                    
                        <li class="sidebar-item"> <a class="sidebar-link sidebar-link" href="temp/html/app-calendar.html"
                                aria-expanded="false"><i data-feather="user" class="feather-icon"></i><span
                                    class="hide-menu">내 정보</span></a></li>

<!---------------------------------------------[내 컨텐츠 영역 ]-------------------------------------------------------------->
                        <li class="list-divider"></li> <!-- 구분선 -->
                        
                        <li class="nav-small-cap"><span class="hide-menu">내 컨텐츠</span></li>
                        
                        <li class="sidebar-item"> <a class="sidebar-link sidebar-link" href="javascript:void(0)"
                                aria-expanded="false"><i data-feather="heart" class="feather-icon"></i><span
                                    class="hide-menu">좋아요 한 학원 목록</span></a></li>
                                    
                        <li class="sidebar-item"> <a class="sidebar-link sidebar-link" href="javascript:void(0)"
                                aria-expanded="false"><i data-feather="edit" class="feather-icon"></i><span
                                    class="hide-menu">내가 작성한 글</span></a>
                                    
                            <ul aria-expanded="false" class="collapse first-level base-level-line">
                                <li class="sidebar-item">
                                	<a href="javascript:void(0)" class="sidebar-link">
                                		<span class="hide-menu">학원후기</span>
                                	</a>
                                </li>            
                                <li class="sidebar-item">
                                	<a href="javascript:void(0)" class="sidebar-link">
                                		<span class="hide-menu">익명사담글</span>
                                	</a>
                                </li>            
                                <li class="sidebar-item">
                                	<a href="javascript:void(0)" class="sidebar-link">
                                		<span class="hide-menu">문의게시글</span>
                                	</a>
                                </li>            
                        	</ul>
                                    
						</li>
                                    
                        
                        <li class="list-divider"></li>
                        <li class="nav-small-cap"><span class="hide-menu">계정관련</span></li>


                        <li class="sidebar-item"> <a class="sidebar-link sidebar-link" href=""
                                aria-expanded="false"><i data-feather="log-out" class="feather-icon"></i>
                                <span class="hide-menu">로그아웃</span></a>
						</li>

                        <li class="sidebar-item"> <a class="sidebar-link sidebar-link"
                                href="4index.jsp?center=member/member_secede.jsp" aria-expanded="false">
                                <i data-feather="box" class="feather-icon"></i>
                                <span class="hide-menu">회원탈퇴</span></a>
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
        
        
        
        
        
        
        
        
        
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
<!--             <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-7 align-self-center">
                        <h4 class="page-title text-truncate text-dark font-weight-medium mb-1">Calendar</h4>
                        <div class="d-flex align-items-center">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb m-0 p-0">
                                    <li class="breadcrumb-item text-muted active" aria-current="page">Apps</li>
                                    <li class="breadcrumb-item text-muted" aria-current="page">Calendar</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                    <div class="col-5 align-self-center">
                        <div class="customize-input float-right">
                            <select class="custom-select custom-select-set form-control bg-white border-0 custom-shadow custom-radius">
                                <option selected>Aug 19</option>
                                <option value="1">July 19</option>
                                <option value="2">Jun 19</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div> -->
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            
 <!----------------------------------[ 마이페이지 센터영역(표시내용 바뀌는 곳) ]---------------------------------------------------------->
            
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->

 
           <div class="container-fluid">
           
                <div class="row">
 
 <!----------------------------------[ 일반회원 관련 데이터 테이블]---------------------------------------------------------->
                    <!-- (일반회원)내가 좋아요한 학원 목록 -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">좋아요 한 학원 목록</h4>
                                <h6 class="card-subtitle">내가 좋아요한 학원목록이 최근순으로 표시됩니다.</h6>
                            </div>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class="thead-light">
                                        <tr>
                                            <th scope="col">학원명</th>
                                            <th scope="col">우편번호</th>
                                            <th scope="col">학원주소(도로명)</th>
                                            <th scope="col">좋아요 한 날짜</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">부산학원</th>
                                            <td>45652</td>
                                            <td>부산광역시 부산진구 부산진구길 12로</td>
                                            <td>2020-08-20</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">부산학원</th>
                                            <td>45652</td>
                                            <td>부산광역시 부산진구 부산진구길 12로</td>
                                            <td>2020-08-20</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">부산학원</th>
                                            <td>45652</td>
                                            <td>부산광역시 부산진구 부산진구길 12로</td>
                                            <td>2020-08-20</td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    
                    <!-- (일반회원)내가 작성한 학원 후기 -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">좋아요 한 학원 목록</h4>
                                <h6 class="card-subtitle">내가 좋아요한 학원목록이 최근순으로 표시됩니다.</h6>
                            </div>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class="thead-light">
                                        <tr>
                                            <th scope="col">학원명</th>
                                            <th scope="col">우편번호</th>
                                            <th scope="col">학원주소(도로명)</th>
                                            <th scope="col">좋아요 한 날짜</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">부산학원</th>
                                            <td>45652</td>
                                            <td>부산광역시 부산진구 부산진구길 12로</td>
                                            <td>2020-08-20</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">부산학원</th>
                                            <td>45652</td>
                                            <td>부산광역시 부산진구 부산진구길 12로</td>
                                            <td>2020-08-20</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">부산학원</th>
                                            <td>45652</td>
                                            <td>부산광역시 부산진구 부산진구길 12로</td>
                                            <td>2020-08-20</td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    
                    
                    <!-- (일반회원)내가 작성한 문의글 -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">내가 작성한 문의글</h4>
                                <h6 class="card-subtitle">작성한 문의게시글이 최근순으로 표시됩니다.</h6>
                            </div>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class="thead-light">
                                        <tr>
                                            <th scope="col">글번호</th>
                                            <th scope="col">조회수</th>
                                            <th scope="col">작성자(계정)</th>
                                            <th scope="col">제목</th>
                                            <th scope="col">내용</th>
                                            <th scope="col">댓글수</th>
                                            <th scope="col">작성일자</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td>2</td>
                                            <td>user1@naver.com</td>
                                            <td>멤버십 결제 환불 언제 되나요?</td>
                                            <td>3일전에 결제했다가 바로취소했는데 아직 환불이 안됐네요.</td>
                                            <td>1</td>
                                            <td>2020-08-21</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td>2</td>
                                            <td>user1@naver.com</td>
                                            <td>멤버십 결제 환불 언제 되나요?</td>
                                            <td>3일전에 결제했다가 바로취소했는데 아직 환불이 안됐네요.</td>
                                            <td>1</td>
                                            <td>2020-08-21</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td>2</td>
                                            <td>user1@naver.com</td>
                                            <td>멤버십 결제 환불 언제 되나요?</td>
                                            <td>3일전에 결제했다가 바로취소했는데 아직 환불이 안됐네요.</td>
                                            <td>1</td>
                                            <td>2020-08-21</td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    

                    
                    
                 
                    

                    
                    
                    <!-- (일반회원) 익명 사담글 목록 -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">내가 작성한 익명사담글</h4>
                                <h6 class="card-subtitle">내가 작성한 익명사담방의 게시글이 최신순으로 표시됩니다.</h6>
                            </div>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class="thead-light">
                                        <tr>
                                            <th scope="col">글번호</th>
                                            <th scope="col">제목</th>
                                            <th scope="col">내용</th>
                                            <th scope="col">조회수</th>
                                            <th scope="col">작성일자</th>
                                            <th scope="col">댓글수</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td>다들 충분히 잘 하고 있어. 좋은 일이 있을거야.</td>
                                            <td>만약 오늘 힘든 일이 있었더라도 내일은 다르길 바라</td>
                                            <td>101</td>
                                            <td>2020-08-20</td>
                                            <td>15</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td>다들 충분히 잘 하고 있어. 좋은 일이 있을거야.</td>
                                            <td>만약 오늘 힘든 일이 있었더라도 내일은 다르길 바라</td>
                                            <td>101</td>
                                            <td>2020-08-20</td>
                                            <td>15</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">1</th>
                                            <td>다들 충분히 잘 하고 있어. 좋은 일이 있을거야.</td>
                                            <td>만약 오늘 힘든 일이 있었더라도 내일은 다르길 바라</td>
                                            <td>101</td>
                                            <td>2020-08-20</td>
                                            <td>15</td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

 <!----------------------------------[ 학원 관리자 관련 데이터 테이블]---------------------------------------------------------->
                    <!-- (학원 관리자 회원, 일반회원 공용) 청강 신청 목록 -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">청강신청목록</h4>
                                <h6 class="card-subtitle">학원의 청강신청내역이 최근순으로 표시됩니다.</h6>
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
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">12345678</th>
                                            <td>user1@naver.com</td>
                                            <td>456541</td>
                                            <td>망고학원</td>
                                            <td>망고영어회화</td>
                                            <td>2020-08-20</td>
                                            <td>2020-08-25</td>
                                            <td>2020-08-23</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">12345678</th>
                                            <td>user1@naver.com</td>
                                            <td>456541</td>
                                            <td>망고학원</td>
                                            <td>망고영어회화</td>
                                            <td>2020-08-20</td>
                                            <td>2020-08-25</td>
                                            <td>2020-08-23</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">12345678</th>
                                            <td>user1@naver.com</td>
                                            <td>456541</td>
                                            <td>망고학원</td>
                                            <td>망고영어회화</td>
                                            <td>2020-08-20</td>
                                            <td>2020-08-25</td>
                                            <td>2020-08-23</td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
 
 
 
 <!----------------------------------[ 사이트 관리자 관련 데이터 테이블]---------------------------------------------------------->
                    <!-- 멤버십 결제내역 -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">멤버십 결제현황</h4>
                                <h6 class="card-subtitle">회원들의 멤버십 결제내역이 표시됩니다.</h6>
                            </div>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class="thead-light">
                                        <tr>
                                            <th scope="col">회원번호</th>
                                            <th scope="col">계정</th>
                                            <th scope="col">사용회차</th>
                                            <th scope="col">이용서비스</th>
                                            <th scope="col">결제일자</th>
                                            <th scope="col">만료예정일자</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">451215</th>
                                            <td>user1@naver.com</td>
                                            <td>1</td>
                                            <td>무제한 이용권(30일)</td>
                                            <td>2020-08-21</td>
                                            <td>2020-09-21</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">451215</th>
                                            <td>user1@naver.com</td>
                                            <td>1</td>
                                            <td>무제한 이용권(30일)</td>
                                            <td>2020-08-21</td>
                                            <td>2020-09-21</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">451215</th>
                                            <td>user1@naver.com</td>
                                            <td>1</td>
                                            <td>무제한 이용권(30일)</td>
                                            <td>2020-08-21</td>
                                            <td>2020-09-21</td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    
                    
                    <!-- 학원 등록 요청내역 -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">학원 등록 요청 현황</h4>
                                <h6 class="card-subtitle">현재까지 등록요청된 학원 목록이 표시됩니다.</h6>
                            </div>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class="thead-light">
                                        <tr>
                                            <th scope="col">계정</th>
                                            <th scope="col">학원명</th>
                                            <th scope="col">우편번호</th>
                                            <th scope="col">도로명주소</th>
                                            <th scope="col">첨부파일(사업자)</th>
                                            <th scope="col">파일크기</th>
                                            <th scope="col">첨부파일(대표자)</th>
                                            <th scope="col">파일크기</th>
                                            <th scope="col">신청일</th>
                                            <th scope="col">승인일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">user1@naver.com</th>
                                            <td>망고 학원</td>
                                            <td>45161</td>
                                            <td>부산광역시 남구 수영로203</td>
                                            <td>망고학원 사업자.jpg</td>
                                            <td>1.2kb</td>
                                            <td>망고학원 대표자.jpg</td>
                                            <td>2.2kb</td>
                                            <td>2020-09-21</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">user1@naver.com</th>
                                            <td>망고 학원</td>
                                            <td>45161</td>
                                            <td>부산광역시 남구 수영로203</td>
                                            <td>망고학원 사업자.jpg</td>
                                            <td>1.2kb</td>
                                            <td>망고학원 대표자.jpg</td>
                                            <td>2.2kb</td>
                                            <td>2020-09-21</td>
                                            <td>2020-09-23</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">user1@naver.com</th>
                                            <td>망고 학원</td>
                                            <td>45161</td>
                                            <td>부산광역시 남구 수영로203</td>
                                            <td>망고학원 사업자.jpg</td>
                                            <td>1.2kb</td>
                                            <td>망고학원 대표자.jpg</td>
                                            <td>2.2kb</td>
                                            <td>2020-09-21</td>
                                            <td></td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    
                    <!-- 전체 회원 정보 목록 -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">회원 정보 조회</h4>
                                <h6 class="card-subtitle">현재까지 가입한 회원의 정보가 모두 표시됩니다.</h6>
                            </div>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class="thead-light">
                                        <tr>
                                            <th scope="col">회원번호</th>
                                            <th scope="col">계정(이메일)</th>
                                            <th scope="col">이름</th>
                                            <th scope="col">비밀번호</th>
                                            <th scope="col">학원관리자여부</th>
                                            <th scope="col">가입일자</th>
                                            <th scope="col">계정정지일자</th>
                                            <th scope="col">탈퇴일자</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">4651231</th>
                                            <td>user1@naver.com</td>
                                            <td>최자두</td>
                                            <td>chlwken12</td>
                                            <td>0</td>
                                            <td>2020-08-01</td>
                                            <td></td>
                                            <td>2020-08-21</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">4545221</th>
                                            <td>user2@naver.com</td>
                                            <td>이자두</td>
                                            <td>chlwken12</td>
                                            <td>1</td>
                                            <td>2020-08-01</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>


                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                     
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
   


                </div>       <!-- row -->     
           
 <!--               <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="">
                                <div class="row">
                                    <div class="col-lg-3 border-right pr-0">
                                        <div class="card-body border-bottom">
                                            <h4 class="card-title mt-2">Drag & Drop Event</h4>
                                        </div>
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div id="calendar-events" class="">
                                                        <div class="calendar-events mb-3" data-class="bg-info"><i
                                                                class="fa fa-circle text-info mr-2"></i>Event One</div>
                                                        <div class="calendar-events mb-3" data-class="bg-success"><i
                                                                class="fa fa-circle text-success mr-2"></i> Event Two
                                                        </div>
                                                        <div class="calendar-events mb-3" data-class="bg-danger"><i
                                                                class="fa fa-circle text-danger mr-2"></i>Event Three
                                                        </div>
                                                        <div class="calendar-events mb-3" data-class="bg-warning"><i
                                                                class="fa fa-circle text-warning mr-2"></i>Event Four
                                                        </div>
                                                    </div>
                                                    checkbox
                                                    <div class="custom-control custom-checkbox">
                                                        <input type="checkbox" class="custom-control-input"
                                                            id="drop-remove">
                                                        <label class="custom-control-label" for="drop-remove">Remove
                                                            after drop</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-9">
                                        <div class="card-body b-l calender-sidebar">
                                            <div id="calendar"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> -->
            </div> <!-- container-fluid -->

























 <!----------------------------------[ 마이페이지 센터영역(표시내용 바뀌는 곳) ]---------------------------------------------------------->
        </div>
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
    </div>
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
    
    
    <!-- 테이블 관련 js  -->
    <script src="../assets/extra-libs/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="../dist/js/pages/datatable/datatable-basic.init.js"></script>
    
    
</body>
</html>