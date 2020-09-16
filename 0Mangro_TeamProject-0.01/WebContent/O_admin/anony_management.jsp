<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

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
.thead-light tr th {border-right : 1px solid #f5f5f5;}
.board_title, .board_content {text-align: left;padding-left: 20px !important;}
.ban_thisAccount, .restore_thisAccount, .dropReport{
	border: 1px solid #000;
	height: 50px;
	padding-top: 10%;
	font-size: 1em;
	color: #000;
	border-radius: 10px;
	font-weight: 400;
	
	
	
}
.ban_thisAccount:hover,.restore_thisAccount:hover, .dropReport:hover{
	background-color: #000;
	color: #fff;
	font-weight: 700;
}

.pagination {
	width: 300px !important;
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
						
                        <li class="sidebar-item"> <a class="sidebar-link sidebar-link" href="./registerGetList.areg"
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
                        	<a class="sidebar-link sidebar-link" href="4index.jsp?center=O_admin/qna_management.jsp" 
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

                    
                    <!-- (일반회원) 익명 사담글 목록 -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">신고 내역 조회  
	                                <span style="font-size: 0.7em; color: #696a6b; padding-left:10px;">
	                                	총&nbsp;<span style="font-weight: 400">${count}</span>개의 글이 있습니다.
	                                </span>
                                </h4>
                                
                                <h6 class="card-subtitle">익명사담방의 게시글 중 신고된 항목만 최신순으로 표시됩니다.</h6>
                            </div>
                            <div class="table-responsive">
                                <table class="table" style="table-layout: fixed;">
                                    <thead class="thead-light">
                                        <tr style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap; width: 100%">
                                            <th scope="col" style="width:5%;">글 번호</th>
                                            <!-- <th scope="col" style="width:11%;">제목</th> -->
                                            <!-- <th scope="col" style="width:11%;">내용</th> -->
                                            <th scope="col" style="width:11%;">계정</th>
                                            <!-- <th scope="col" style="width:5%;">댓글수</th> -->
                                            <th scope="col" style="width:8%;">조회수</th>
                                            <th scope="col" style="width:8%;">첨부파일</th>
                                            <th scope="col" style="width:13%;">작성일자</th>
                                            <th scope="col" style="width:11%;">신고일자</th>
                                            <th scope="col" style="width:11%;">신고사유</th>
                                            <th scope="col" style="width:11%;">신고계정</th>
                                            <th scope="col" colspan="3" style="width:22%;">처리</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:choose>
                                     <%-- onclick="location.href='./AnoBoardSingleAction.anob?ano_board_num=${reportedAnonyList.ano_board_num}'" --%>
                                    <c:when test="${count != 0 }">
                                    <c:forEach var="reportedAnonyList" items="${reportedAnonyList}">
                                        <tr onclick="buttonFunc('act' , event)" id="goBoard">
                                            <th scope="row" id="ano_board_num">${reportedAnonyList.ano_board_num}</th>
                                           <%--  <td class="board_title">${myAnonyList.ano_board_title}</td> --%>
                                            <%-- <td class="board_content">${myAnonyList.ano_board_content}</td> --%>
                                            <td id="mem_email">${reportedAnonyList.mem_email}</td>
                                            <%-- <td>${comments[reportedAnonyList.ano_board_num]}</td> --%>
                                            <td>${reportedAnonyList.ano_board_read}</td>
                                            <td>${reportedAnonyList.ano_board_file}</td>
                                            <td>
	                                            <fmt:formatDate value="${reportedAnonyList.ano_board_date}" 
					                                            pattern ="yyyy.MM.dd KK:mm:ss" 
					                                            type="both"/>
                                            </td>
                                            <td>${reportedAnonyList.ano_board_reported}</td>
                                            <td>${reportedAnonyList.ano_board_reason}</td>
                                            <td>${reportedAnonyList.ano_board_reporter}</td>
                                            
                                        
                                        <c:choose>
                                         <c:when test="${reportedAnonyList.ano_board_reported ne ''}" >
                                            <td>
       	                                    	<div class="ban_thisAccount" name="ban_${reportedAnonyList.mem_email}" id="ban" onclick="buttonFunc(1,'${reportedAnonyList.ano_board_num}','${reportedAnonyList.mem_email }',event)">계정정지</div>
                                            </td>
                                            <td>
       	                                    	<div class="restore_thisAccount" name="restore_${reportedAnonyList.mem_email}" id="restore" onclick="buttonFunc(3,'${reportedAnonyList.ano_board_num}','${reportedAnonyList.mem_email }',event)">계정복구</div>
                                            </td>
                                            <td>
                                            	<div class="dropReport drop_${reportedAnonyList.ano_board_num}" id="drop" onclick="buttonFunc(2,'${reportedAnonyList.ano_board_num}','${reportedAnonyList.mem_email}',event)">신고삭제</div>
                                            </td>
                                         </c:when>
                                         <c:otherwise>
                                         	<td></td><td></td>
                                         </c:otherwise>
                                        </c:choose>    
										    
                                            
                                        </tr>
                                    </c:forEach>
                                    </c:when>
                                    
                                    <c:otherwise>
                                        <tr>
                                            <th scope="row" colspan="11">신고된 익명사담글이 없습니다.</th>
                                        </tr>
                                    
                                    </c:otherwise>
                                    
                                    </c:choose>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    
 <%-------------------------------------------------- 페이징 영역  ------------------------------------------------------------------------%>
                    
                    <ul class="pagination">
                    
                    <%-- 게시판에 글이 있는 경우 페이지 표시 --%>
                    
                    <c:if test="${count > 0}">
					
							<%-- [  <<  첫페이지(1페이지)로 가기    ] --%>  
							
							  <li class="page-item"> 
							  	<a class="page-link prev" href="./AdminAnonyReportedListAction.anob?clickedPageNum=1">
							  		<i data-feather="chevrons-left" class="svg-icon mr-2 ml-1"></i>
							  	</a>
							  </li>
							  
							<%-- [  <  이전페이지 가기    ] --%>  
							
							  <li class="page-item">
							<%-- 블럭 첫페이지-페이지블록(하나의 블럭에 보여줄 페이지 수)가 0보다 작을 경우 즉, 더이상 전으로 이동할 페이지가 없을 경우 1페이지로----------------%>                    	
								<c:choose>
			                    	<c:when test="${startPage-pageBlock<=0}">
									  	<a class="page-link prev" href="./AdminAnonyReportedListAction.anob?clickedPageNum=1">
									  		<i data-feather="chevron-left" class="svg-icon mr-2 ml-1"></i>
									  	</a>
								  	</c:when>
								  	<c:otherwise>
									  	<a class="page-link prev" href="./AdminAnonyReportedListAction.anob?clickedPageNum=${startPage-pageBlock}">
									  		<i data-feather="chevron-left" class="svg-icon mr-2 ml-1"></i>
									  	</a>
								  	</c:otherwise>
								</c:choose>	  
									  </li>
							  
					  
							<%-- [1] [2] [3] .... --%>  
							<c:if test="${count gt 0 }">
							
							  <c:forEach var="i" begin="${startPage}" end="${endPage}">
							  	<c:choose>
								  	 <c:when test="${i gt endPage}">
									  	<li class="page-item">
									  		<a class="page-link" href="./AdminAnonyReportedListAction.anob?clickedPageNum=${i}">
									  			${i}
									  		</a>
									  	</li>
								  	 </c:when>
								  	 <c:when test="${currentPage == i}">
									  	<li class="page-item  active">
									  		<a class="page-link" href="./AdminAnonyReportedListAction.anob?clickedPageNum=${i}">
									  			${i}
									  		</a>
									  	</li>
								  	 </c:when>
							  	</c:choose>
							  </c:forEach>
							 </c:if> 
					  
					<%-- [  >  다음페이지 가기] .... --%> 
					
					<%-- 블록시작번호+하나의 블럭에 보여질 페이지수=전체 페이지수보다 큰 경우 즉, 더이상 뒤로 갈 페이지가 없는 경우 총페이지개수(마지막페이지) -----------------%>  
							  <li class="page-item">
								<c:choose>
		                    		<c:when test="${startPage+pageBlock > pageCount}">
									  	<a class="page-link next" href="./AdminAnonyReportedListAction.anob?clickedPageNum=${pageCount}">
										  	<i data-feather="chevron-right" class="svg-icon mr-2 ml-1"></i>
										</a>
									</c:when>  
									<c:otherwise>
									  	<a class="page-link next" href="./AdminAnonyReportedListAction.anob?clickedPageNum=${startPage+pageBlock}">
										  	<i data-feather="chevron-right" class="svg-icon mr-2 ml-1"></i>
										</a>
									</c:otherwise>
								</c:choose>
							  </li>
							  
					<%-- [  >>  마지막페이지 가기] .... --%>  
					<%-- 총페이지수(마지막페이지)대입 -----------------%>  
						  <li class="page-item">
						  	<a class="page-link next" href="./AdminAnonyReportedListAction.anob?clickedPageNum=${pageCount}">
							  	<i data-feather="chevrons-right" class="svg-icon mr-2 ml-1"></i>
							</a>
						  </li>
					  </c:if> 
					<%-- 게시판에 글이 있는 경우 페이지 표시 끝 --%>
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
    




<script type="text/javascript">



	function refresh() { location.reload(); }


	// [계정정지 버튼을 클릭했을 때 해당 글 목록으로 이동하기 위해 부모태그인 tr에 걸어둔 location.href 이벤트 실행 방지 ]

	function buttonFunc(procNum ,ano_board_num,mem_email,event) {
		// [일반 tr 태그를 눌렀을 때]
		if(event.target.nodeName == "TD"){
			location.href='./AnoBoardSingleAction.anob?ano_board_num='+ano_board_num;
			
		// [일반 td태그안의 div(신고 처리 버튼 3개 중 하나)를 눌렀을 때]
		}else{
		    
	
		    $.ajax({
		        type: "POST",
		        url : "./AdminAnonyHandleReportedAction.anob?procNum="+procNum,
		        dataType : "text",
		        data: { 
	 	        		ano_board_num : ano_board_num,  
	 	        		mem_email : mem_email  
		        },
		        success : function(data){
		        	
		        	if(data == 1){
			        	alert("계정 정지가 정상적으로 완료되었습니다.");
			        	refresh();
		        	}else if(data == 2){
			        	alert("신고 삭제가 정상적으로 완료되었습니다.");
			        	refresh();
		        	}else{
			        	alert("계정 복구가 정상적으로 완료되었습니다.");
			        	refresh();
		        		
		        	}
		        },
		        error:function(request,status,error){
		            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		            console.log(status);
		       }
		        
		    });//ajax
	
	  }
	
	}// buttonFunc()  끝		
	
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
  	<script src="styles/dist/js/pages/dashboards/dashboard1.min.js"></script>    
    <script src="styles/assets/extra-libs/jvector/jquery-jvectormap-2.0.2.min.js"></script>
    <script src="styles/assets/extra-libs/jvector/jquery-jvectormap-world-mill-en.js"></script>    

    
</body>
</html>