<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Unicat project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!------------------------------------------ [ 제이쿼리 ] --------------------------------------------------------------->
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tagsinput/0.8.0/bootstrap-tagsinput.min.js"></script>
    
<!------------------------------------------ [ CSS ] --------------------------------------------------------------->

	<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
	<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="styles/form_basic_page.css">
	<link rel="stylesheet" type="text/css" href="styles/academy_single_responsive.css">

    <link href="styles/dist/css/style.min.css" rel="stylesheet">
    <link href="styles/mypage_additional.css" rel="stylesheet">
    <link href="styles/table_style.css" rel="stylesheet">
</head>
<body>



      <!-------------------------------------------- [form태그 시작] -------------------------------------------------------->
	
	
        
        
               
        
            
 <!----------------------------------[ 마이페이지 센터영역(표시내용 바뀌는 곳) 시작]---------------------------------------------------------->
            
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->

 
           <div class="container-fluid">
           
                <div class="row">  <!-- 표시하고자 하는 데이터가 row 안에 있어야 함. 삭제x -->
 
 <!----------------------------------[ 테이블]---------------------------------------------------------->

                    
                    <!-- (일반회원)내가 작성한 학원 후기 -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">내가 작성한 학원 후기</h4>
                                <h6 class="card-subtitle">내가 작성한 학원후기목록이 최근순으로 표시됩니다.</h6>
                            </div>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class="thead-light">
                                        <tr>
                                            <th scope="col">후기번호</th>
                                            <th scope="col">학원 지정번호</th>
                                            <th scope="col">학원명</th>
                                            <th scope="col">한줄요약</th>
                                            <th scope="col">장점</th>
                                            <th scope="col">단점</th>
                                            <th scope="col">수강과목</th>
                                            <th scope="col">총괄점수</th>
                                            <th scope="col">작성일자</th>
                                            <th scope="col">승인일자</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">503</th>
                                            <td>1235456</td>
                                            <td>망고학원</td>
                                            <td>매일 망고를 줘서 좋아요.</td>
                                            <td>수업을 재미있게 하네요.</td>
                                            <td>배가고파요.오늘은 망고를 안줌.</td>
                                            <td>에피타이저 베이킹</td>
                                            <td>5</td>
                                            <td>2020-08-20</td>
                                            <td>2020-08-21</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">503</th>
                                            <td>1235456</td>
                                            <td>망고학원</td>
                                            <td>매일 망고를 줘서 좋아요.</td>
                                            <td>수업을 재미있게 하네요.</td>
                                            <td>배가고파요.오늘은 망고를 안줌.</td>
                                            <td>에피타이저 베이킹</td>
                                            <td>5</td>
                                            <td>2020-08-20</td>
                                            <td>2020-08-21</td>
                                        </tr>

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
					  <li class="page-item active">
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




</body>
</html>