<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<!------------------------------------------ [ 메타데이터 ] --------------------------------------------------------------->
    <meta name="viewport" content="width=device-width, initial-scale=1">
<!------------------------------------------ [ 제이쿼리 ] --------------------------------------------------------------->
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<!------------------------------------------ [ CSS ] --------------------------------------------------------------->
    <link href="styles/assets/libs/fullcalendar/dist/fullcalendar.min.css" rel="stylesheet" />
    <link href="styles/dist/css/style.min.css" rel="stylesheet">
    <link href="styles/mypage_additional.css" rel="stylesheet">
    <link href="styles/table_style.css" rel="stylesheet">
  
  
    
</head>     





<script type="text/javascript">


	$(document).ready(function(){
		
		
		var boardnum = $(".board_num");
		// boardnum.length -> board_num의 수만큼 반복
		
		
		for(var i = 0; i < boardnum.length; i++){
			check_rewrite(boardnum.eq(i).val());
		}
		
		
	});
	
	
	
		
	function check_rewrite(boardnum){
		
		var _data = '{"boardnum":"'+boardnum+'"}';
		
		$.ajax({
			
			type: "post",
			url: "./QnaReWriteAction",
			data: {"data": _data},
	
			success: function(data, textStatus){
				
	            var jsonInfo = JSON.parse(data);
	            var check = jsonInfo.check;
				var boardnum = jsonInfo.boardnum;
				
				document.getElementById("recheck_"+boardnum).innerText = check;
				
			}, 
			
			error: function(data, textStatus){
				
				alert("에러 발생"+ data + textStatus);
				console.log(data);
				
			} // error 끝
			
		});
	}
		
		




</script>


<body>
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
                                <span class="ml-2 d-none d-lg-inline-block"><span>${id_email}</span> <span
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
                    
                        
<!---------------------------------------------[설정 및 관리 영역 ]-------------------------------------------------------------->
                        <li class="list-divider"></li> <!-- 구분선 -->
                        
                        <li class="nav-small-cap">
                        	<span class="hide-menu divide">설정 및 관리</span>
                        	<span class="rounded p-1 font-footnote border text-primary">일반인</span>
                        	
                        </li>

                        <li class="sidebar-item"> 
                        	<a class="sidebar-link" href="4index.jsp?center=O_payment/payment_list.jsp"
                                aria-expanded="false">
                                <i data-feather="sidebar" class="feather-icon"></i>
                                <span class="hide-menu">멤버십 결제</span>
                            </a>
                        </li>
                        
                        
                                    
                        <li class="sidebar-item"> 
                        	<a class="sidebar-link sidebar-link" 
                        	   href="./MemberUpdate.me"
                                aria-expanded="false"><i data-feather="user" class="feather-icon"></i><span
                                    class="hide-menu">내 정보</span></a></li>

<!---------------------------------------------[내 컨텐츠 영역 ]-------------------------------------------------------------->
                         <li class="list-divider"></li> <!-- 구분선 -->
                        
                        <li class="nav-small-cap"><span class="hide-menu divide" >내 컨텐츠</span></li>
                        
                        <li class="sidebar-item"> 
                        	<a class="sidebar-link sidebar-link" href="LikedAcaListAction.laca?pageNum=1"
                                aria-expanded="false"><i data-feather="heart" class="feather-icon"></i><span
                                    class="hide-menu">좋아요 한 학원 목록</span>
                            </a>
						</li>
                                    
                        <li class="sidebar-item"> 
                        	<a class="sidebar-link sidebar-link" href="#"
                                aria-expanded="false"><i data-feather="edit" class="feather-icon"></i><span
                                    class="hide-menu">내가 작성한 글</span>
							</a>
                                    
                            <ul aria-expanded="false" class="collapse first-level base-level-line">
                                <li class="sidebar-item">
                                	<a href="myReviewListAction.arev?pageNum=1" class="sidebar-link">
                                		<span class="hide-menu">학원후기</span>
                                	</a>
                                </li>            
                                <li class="sidebar-item">
                                	<a href="./MyAnonyBoardListAction.anob" class="sidebar-link">
                                		<span class="hide-menu">익명사담글</span>
                                	</a>
                                </li>            
                                <li class="sidebar-item">
                                	<a href="./MyQnaList.qna" class="sidebar-link">
                                		<span class="hide-menu">문의게시글</span>
                                	</a>
                                </li>            
                        	</ul>
                                    
						</li>
                        <li class="sidebar-item"> 
                        	<a class="sidebar-link sidebar-link" 
                        		href="./AuditListToMypage.adrq"
                                aria-expanded="false"><i data-feather="book" class="feather-icon"></i>
                                <span class="hide-menu">청강신청 현황</span>
                            </a>
						</li>
                                    
                        
                        <li class="list-divider"></li> <!-- 구분선 -->
                        <li class="nav-small-cap"><span class="hide-menu divide">계정관련</span></li>


                        <li class="sidebar-item"> 
                        	<a class="sidebar-link sidebar-link" href="./MemberLogout.me"
                                aria-expanded="false"><i data-feather="log-out" class="feather-icon"></i>
                                <span class="hide-menu">로그아웃</span>
                            </a>
						</li>

                        <li class="sidebar-item"> 
                        	<a class="sidebar-link sidebar-link"
                                href="./MemberDelete.me" aria-expanded="false">
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
                                            <th scope="col">작성자(계정)</th>
                                            <th scope="col">제목</th>
                                            <th scope="col">내용</th>
                                            <th scope="col">조회수</th>
                                            <th scope="col">작성일자</th>
                                            <th scope="col">답변여부</th>
                                        </tr>
                                    </thead>
                                    
                                    
																								                                            
					                   <c:if test="${count eq 0}">
					                  		<td></td><td></td><td></td>
					                  		<td>문의글이 없습니다.</td>
					                  		<td></td><td></td><td></td>
					                   </c:if>
                                    
                                    <tbody>
                                    
                                    
                                    	<c:if test="${count != 0}">
                                    		
                                    		
                                    		<c:forEach var = "qnaboardList" items="${qnaboardList}">
				                                  
				                    			<c:if test="${qnaboardList.qna_re_lev eq 0}">
				                                  
			                                        <tr id = "qnarewrite" onclick="location.href='./QnaBoardContent.qna?qna_board_num=${qnaboardList.qna_board_num}&pageNum=${pageNum}'">
			                                        	<input type = "hidden" class = "board_num" value = "${qnaboardList.qna_board_num}">
			                                            <th scope="row">${qnaboardList.qna_board_num}</th>
			                                            <td>${qnaboardList.mem_email}</td>
			                                            <td>${qnaboardList.qna_board_title}</td>
			                                            <td>${qnaboardList.qna_board_content}</td>
			                                            <td>${qnaboardList.qna_board_read}</td>
			                                            <td>${qnaboardList.qna_board_date}</td>
			                                            
			                                     		<td id="recheck_${qnaboardList.qna_board_num}" class = "check"></td>
			                                        </tr>
		                                        
		                                        </c:if>
		                                        
		                                        											
                                        	</c:forEach>
                                        	
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
					  	<a class="page-link prev" href="MyQnaList.qna?mem_email=${id_email}&pageNum=1">
					  		<i data-feather="chevrons-left" class="svg-icon mr-2 ml-1"></i>
					  	</a>
					  </li>
					 
					<c:if test="${count!=0}">   
                    <!-- < (이전페이지 가기)-->
					     <!-- < (이전페이지 가기) 설정-->
					  <li class="page-item active">
					  	<c:if test="${startPage-pageBlock<0}">
					  		<c:set var="pN" value="1"/>
					  	</c:if>
					  	
					  	<c:if test="${startPage-pageBlock>0}">
					  		<c:set var="pN" value="${startPage-pageBlock}"/>
					  	</c:if>
					  
					  	<a class="page-link prev" href="MyQnaList.qna?mem_email=${id_email}&pageNum=${pN}">
					  		<i data-feather="chevron-left" class="svg-icon mr-2 ml-1"></i>
					  	</a>	
					  </li>
					  
					  
					 <c:forEach var="i" begin="${startPage}" end="${endPage}">			  
					  	<li class="page-item active">
					  		<a class="page-link" href="MyQnaList.qna?mem_email=${id_email}&pageNum=${i}">${i}</a>
					  	</li>
					 </c:forEach>	
		
					  
					  
					  
					  <!-- 끝 페이지 앞으로가기 설정 -->
					   	<c:if test="${startPage+pageBlock>pageCount}">
					  		<c:set var="pP" value="${pageCount}"/>
					  	</c:if>
					  	
					  	<c:if test="${startPage+pageBlock<pageCount}">
					  		<c:set var="pP" value="${startPage+pageBlock}"/>
					  	</c:if>
					  
					  <li class="page-item"><%--다음 페이지 --%>
					  	<a class="page-link next" href="MyQnaList.qna?&mem_email=${id_email}&pageNum=${pP}">
						  	<i data-feather="chevron-right" class="svg-icon mr-2 ml-1"></i>
						</a>
					  </li>
                    
                    <!-- >> (마지막페이지 가기)-->
					  <li class="page-item">
					  	<a class="page-link next" href="MyQnaList.qna?&mem_email=${id_email}&pageNum=${pageCount}">
						  	<i data-feather="chevrons-right" class="svg-icon mr-2 ml-1"></i>
						</a>
					  </li>
					  
					  </c:if>
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
    
    
<!----------------------------------------[자바스크립트 영역------------------------------------------------------------------->    
    
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