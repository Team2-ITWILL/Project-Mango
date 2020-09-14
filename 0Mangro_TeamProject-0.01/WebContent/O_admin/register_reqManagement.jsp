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
                                <h4 class="card-title">등록 요청 학원 관리</h4>
                                <h6 class="card-subtitle">등록 요청 학원 리스트가 최신순으로 표시됩니다.</h6>
                            </div>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class="thead-light">
                                        <tr>
                                            <th scope="col">신청계정</th>
                                            <th scope="col">학원명</th>
                                            <th scope="col">우편번호</th>
                                            <th scope="col">도로명주소</th>
                                            <th scope="col">사업자등록증 파일</th>
                                            <th scope="col">대표자신분증 파일</th>
                                            <th scope="col">신청일</th>
                                            <th scope="col">승인일</th>
                                            <th scope="col">키워드</th>     
                                            <th scope="col">승인</th>     
                                            <th scope="col">취소</th>     
                                            <th scope="col">삭제</th> 
                                        </tr>                                        
                                    </thead>
                                    <tbody>                                    
                                    <c:forEach var="vo" items="${registerList}">
                                    	<!-- 승인,취소를 구분할 값 -->
                                    	<c:set var="flag" value="0" />
                                    	
                                    	<!-- 클릭 연속적으로 하다가 flag값이 잘못 변경되는 문제 발견. onclick 이벤트에서 직접 1,0,-1값 주는 방향으로 변경 -->
                                    	<%-- 
                                    	<c:choose>                                    		
                                    		<c:when test="${vo.confirmDate eq null}">
                                    			<!-- confirmDate가 null이면 승인 -->
                                    			<div style="display:none;">${flag = 1}</div>                                    			
                                    		</c:when>                                    		
                                    		<c:when test="${vo.confirmDate ne null}">
                                    			<!-- confirmDate가 값이 있으면 승인 취소 -->
                                    			<div style="display:none;">${flag = 0}</div>                                        		
                                    		</c:when>
                                    		<c:otherwise>error</c:otherwise>
                                    	</c:choose>
                                    	 --%>
                                    	 
                                    	<!-- 학원관리자 등록을 요청한 사용자의 이메일, 학원명, confirmDate flag를 전달 -->
                                        <%-- <tr onclick="approveReg('${vo.memEmail}', '${vo.acaName}', '${vo.aca_keyword}', '${flag}')"> --%>
                                        <tr>
                                            <th scope="row">${vo.memEmail}</th>
                                            <td>${vo.acaName}</td>
                                            <td>${vo.memAddrZip}</td>
                                            <td>${vo.memAddrDoro}</td>
                                            <td>
                                           		<button type="button" class="btn btn-info" onclick="viewRegImages(this, '${vo.fNameCompany}', '사업자등록증 파일')">image</button>
                                            </td>
                                            <td>
                                            	<button type="button" class="btn btn-info" onclick="viewRegImages(this, '${vo.fNameOwner}', '대표자신분증 파일')">image</button>
                                            </td>
                                            <td>${vo.registerDate}</td>
                                            <td>${vo.confirmDate}</td>
                                            <td>${vo.aca_keyword}</td>                                            
                                            <td>
                                            	<%-- <button type="button" class="btn btn-primary" onclick="approveReg('${vo.memEmail}', '${vo.acaName}', '${vo.aca_keyword}', '${flag}')">승인</button> --%>
                                            	<button type="button" class="btn btn-primary" onclick="approveReg('${vo.memEmail}', '${vo.acaName}', '${vo.aca_keyword}', 1)">승인</button>
                                            </td>
                                            <td>
                                            	<button type="button" class="btn btn-primary" onclick="approveReg('${vo.memEmail}', '${vo.acaName}', '${vo.aca_keyword}', 0)">취소</button>
                                            </td>
                                            <td>
                                            	<button type="button" class="btn btn-primary" onclick="approveReg('${vo.memEmail}', '${vo.acaName}', '${vo.aca_keyword}', -1)">삭제</button>
                                            </td>
                                        </tr>
                                    </c:forEach>                                         
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
    
    				<!-----------등록한 이미지 보여주는 모달창-------->       
    				<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".imgView">이미지 보기</button> -->
    				         
					<div class="modal fade imgView">
					  <!-- 가로 사이즈 이미지에 맞게 자동으로 조정  -->
					  <div class="modal-dialog" style="width:auto;display:table"> 						 
 						<div class="modal-content">					    
					      <div class="modal-header">
					        <h4 class="modal-title">이미지 보기</h4>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					      </div>
					      <!-- 이미지가 들어갈 태그 -->
					      <div class="modal-body">
					        <div class="modal-Img">
					        	<img class="insertImg" src="#">
					        </div>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					      </div>
					    </div><!-- /.modal-content -->
					  </div><!-- /.modal-dialog -->
					</div><!-- /.modal -->
					
					                    
                    <!-- 페이징 영역 : li class속성에 동적으로 active를 주면 해당 페이지 숫자bgcolor 설정됨 -->
                    <ul class="pagination">
                    <!-- << (첫페이지로 가기) -->
					  <li class="page-item"> 
					  	<a class="page-link prev" href="#">
					  		<i data-feather="chevrons-left" class="svg-icon mr-2 ml-1"></i>
					  	</a>
					  </li>
					  
                    <!-- < (이전페이지 가기)-->
					 <!--  <li class="page-item active"> -->
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

	<!-- 이 파일에 선언된 함수들이 모여있는 자바스크립트 파일 -->
	<script src="./O_admin/register_reqManagement.js"></script>

    
</body>
</html>