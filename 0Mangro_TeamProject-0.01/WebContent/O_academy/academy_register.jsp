<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>익명사담방 글쓰기</title>
<!-- 메타데이터  -->
<meta name="description" content="Mango project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 제이쿼리  -->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<!-- 링크목록  -->
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/form_basic_page.css">
<link rel="stylesheet" type="text/css" href="styles/academy_single_responsive.css">

<!-- 키워드 선택 css -->
<link rel="stylesheet" type="text/css" href="styles/academy_list.css">
<link rel="stylesheet" type="text/css" href="styles/academy_list_responsive.css">
<link href="styles/table_style.css" rel="stylesheet">

<!------------------------------- [스타일 시트]------------------------------------------------------------------>
<style type="text/css">
	.files input {
	    outline: 5px dashed #f5f5f5;
	    outline-offset: -10px;
	    -webkit-transition: outline-offset .15s ease-in-out, background-color .15s linear;
	    transition: outline-offset .15s ease-in-out, background-color .15s linear;
	    padding: 120px 0px 85px 35%;
	    text-align: center !important;
	    margin: 0;
	    width: 100% !important;
	}
	.files input:focus{     outline: 2px dashed #92b0b3;  outline-offset: -10px;
	    -webkit-transition: outline-offset .15s ease-in-out, background-color .15s linear;
	    transition: outline-offset .15s ease-in-out, background-color .15s linear; border:1px solid #92b0b3;
	 }
	.files{ position:relative}
	.files:after {  pointer-events: none;
	    position: absolute;
	    top: 60px;
	    left: 0;
	    width: 50px;
	    right: 0;
	    height: 56px;
	    content: "";
	    background-image: url('images/etc/dragfile.png');
	    display: block;
	    margin: 0 auto;
	    background-size: 100%;
	    background-repeat: no-repeat;
	}
	.color input{ background-color:#f0f8ff;}	
	
	.files:before {
	    position: absolute;
	    bottom: 10px;
	    left: 0;  pointer-events: none;
	    width: 100%;
	    right: 0;
	    height: 57px;
	    content: "드래그 또는 버튼을 통해 파일을 업로드 해보세요.";
	    display: block;
	    margin: 0 auto;
	    color: #000;
	    font-weight: 600;
	    text-transform: capitalize;
	    text-align: center;
	}

.audit_notice {
    border: 1px solid;
    padding: 10px;
    border-radius: 10px;
}

.audit_notice li:FIRST-CHILD {
    font-size: 1em;
    color: #e95765;
    font-weight: 700;
    display: inline-block;
    margin-bottom: 10px;
}

.audit_notice li {
    font-size: 14px;
    margin-bottom: 5px;
}

.content{
    outline: 2px dashed #92b0b3 ;
    outline-offset:-10px;  
    text-align: center;
    transition: all .15s ease-in-out;
    width: 300px;
    height: 300px;
    background-color: gray;
}

li.firstKey {
    /* background-color: #66b5dd !important; */ 
    border: 2px solid #66b5dd;

}
li.secondKey {
	/* background-color: #ff0080 !important; */
	/* background-color: #ff0080; */
	border: 2px solid #ff0080;
	
}

li.thirdKey { 
	/* background-color: #6f42c1 !important; */
	/* background-color: #6f42c1; */
	border: 2px solid #6f42c1;
}

/* 키워드 선택 구분 클래스 */
.selected {	
	background-color: yellow !important;
}


</style>


<%---------------------[스크립트영역] ---------------------------------------------%>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<!-- 사용자 정의 함수를 모아놓은 js파일 호출 -->
<script src="./O_academy/academy_register.js"></script>
<%---------------------[스크립트영역] 끝 ---------------------------------------------%>

</head>
<body>

	<div class="about">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<h4 class="section_title">학원 관리자 등록요청</h4>
							<br>
							

							
							
<!------------------------------------- [form 영역] ----------------------------------------------------------->
					      <form class="js-validate w-md-75 w-lg-50 mx-md-auto mb-11" 
					      		action="./register.areg"
					      		method="post"
					      		enctype="multipart/form-data">					        
      							
						      <div class="js-form-message form-group">
			
<%--------------------------------------[학원 정보 찾아서 가져오기]-----------------------------------------------------------------%>			
							       
							       <div class="form-group mb-8">
							       			<!-- 검색결과가 추가될 리스트 -->
							       			<datalist id = "searchList"></datalist>
											
									        <label class="form-label" for="anony_pwd"><span>DB에 등록된 학원 찾기</span></label>
									        <!-- 학원 검색 태그 -->
									        <input type="text" class="form-control" 
									               name="aca_search" id="aca_search" 									        	  
									        	   placeholder="학원명을 입력하세요" required>
									        <!-- 검색 결과 출력 태그 -->
									        
									        <input type="text" class="form-control" 
									               name="aca_search_result" id="aca_search_result" 
									        	   placeholder="검색 결과(클릭하시면 목록이 출력됩니다)">
									        	   <!-- list="searchList"  -->
									         	   	   
									        <br>
									        <input type="button" class="btn btn-write" onclick="" value="학원 찾기" id="search_aca_btn">
									        <br> 
											
											
								   </div>
						      
<%--------------------------------------[입력란 중 Daum API에서 처리하는 폼영역]-----------------------------------------------------------------%>

						        	<div class="form-group mb-8" style="display: grid; ">
						        		<label class="form-label" for="academy_address" style="margin-bottom:10px;"><span>학원 주소</span></label> 

											<input type="text" name="addr_zip" class="input-field form-control" id="sample4_postcode" placeholder="우편번호" required> 
											<input type="text" name="addr_doro" class="input-field form-control" id="sample4_roadAddress" placeholder="도로명주소" required> 
											<span id="guide" style="color:#999;display:none"></span>
											<!-- ▼ [아래 3개 컬럼]db에 컬럼이 없어 hidden처리함(삭제시 api 작동불능을 방지하기 위해 남겨둠) -->
											<input type="hidden" name="addr_jibun" class="input-field form-control" id="sample4_jibunAddress" placeholder="지번주소(선택)"> <br>
											<input type="hidden" name="addr_detailed" class="input-field form-control" id="sample4_detailAddress" placeholder="상세주소"> 
											<input type="hidden" name="addr_dong" class="input-field form-control" id="sample4_extraAddress" placeholder="참고항목" width="20px">		           
											<!-- ▲ -------------------------------------------------------------------- -->
											<input type="button" class="btn btn-write" onclick="sample4_execDaumPostcode()" value="주소찾기" id="addrCheck_btn"><br>
										
						          		
								 	</div>
						      	      		
<%---------------------[학원 이름]-----------------------------------------------------------------------------------------------%>							    						      		
							        <div class="form-group mb-8">
								        <label class="form-label" for="anony_pwd"><span>학원 이름</span></label>
								        <input type="text" class="form-control" name="acaName" id="acaName" placeholder="ex) 망고학원" required> 
								    </div>
								    
<%---------------------[키워드 선택]-----------------------------------------------------------------------------------------------%>							    
								    
								    <!-- 선택한 keyword -->
									<div class="form-group mb-8">
								        <label class="form-label" for="anony_pwd"><span>키워드 선택</span></label>
								        <input type="text" class="form-control" name="keyword_view" placeholder="선택한 키워드" required> 
										<input type="hidden" name="keyword">
								    </div>
									<div class="sidebar_tags">
										<ul class="tags_list first">
											<li class="firstKey traffic">교통이 편리한</li>
											<li class="firstKey stdRoom">스터디룸 있는</li>
											<li class="firstKey clean">시설이 깨끗한</li>
										</ul>
										<ul class="tags_list second">	
											<li class="secondKey restaurant">식당가 인근</li>
											<li class="secondKey audit">청강 신청 가능한</li>
											<li class="secondKey room">기숙사가 있는</li>
										</ul>
										<ul class="tags_list third">
											<li class="thirdKey long">중장기(6개월 이상)</li>
											<li class="thirdKey car">차량운행이 있는</li>
											<li class="thirdKey level">레벨테스트가 있는</li>
											<li class="thirdKey sat">수능대비강의가 있는</li>
										</ul>
									</div>									
									<br>

								    
<%---------------------[사진첨부 가이드]-----------------------------------------------------------------------------------------------%>
									<div class="mb-5 mt-2">
									<label class="form-label"><span>증빙서류 업로드시 유의사항</span></label> <br>
										<span style="font-size:0.9em; color: #e95765;">
											※ 아래 기재된 개인 정보들은 <b>반드시 마스킹 후 첨부</b>해주세요.
										</span>
									      		<table  class="table-bordered table text-center mt-3 mb-5" style="font-size: 0.8em;">
									      			<tr class="bg-light font-subhead">
										      			<th class="w-25 font-weight-normal text-secondary" scope="col">
										      				서류
										      			</th>
										      			<th class="font-weight-normal text-secondary" scope="col">
										      				가려서 제출해야 할 개인정보
										      			</th>
									      			</tr>
									      			<tr>
										      			<td class="text-secondary align-middle align-middle font-subhead">
										      				사업자등록증
										      			</td>
										      			<td class="align-middle text-secondary font-subhead text-left">
										      				이메일주소(esero/hometax 제외), 전화번호, 팩스번호,계좌번호										      			</td>
									      			</tr>
									      			<tr>
										      			<td class="text-secondary align-middle align-middle font-subhead">
										      				사업자등록증명원
										      			</td>
										      			<td class="align-middle text-secondary font-subhead text-left">
										      				개인사업자의 경우, 주민(법인)등록번호 영역 성별 뒤 6자리
										      			</td>
									      			</tr>
									      			<tr>
										      			<td class="text-secondary align-middle align-middle font-subhead">
										      				재직증명서
										      			</td>
										      			<td class="align-middle text-secondary font-subhead text-left">
										      				재직자의 이름, 소속회사명, 인감 또는 대표자 서명, 제출용도 외 모든 정보
										      			</td>
									      			</tr>
									      		</table>
									      	
							      	</div>
				       							 
							        	<label class="form-label" for="anony_file"><span>사업자 등록증</span></label>
						              	<!-- <div class="form-group files" id="test1"> -->
						              	<div class="form-group files" id="test1">
						              		
						                	<input type="file" class="form-control color file" 
						                		   name="file1"					                		 
						                		   id="file1"
						                		   onchange="uploadFile(this, 'fNameCompany', 'f_size_company')"
						                		   required>
						             
						          			<button type="button" 
						          					class="hideBtn"
						          					onclick="hideFileBtn(this, 'file1')">첨부파일</button>
						          			
						    				<input type="hidden" name="fNameCompany">	
						    				<input type="hidden" name="f_size_company">	
						    				
						              	</div>
						              	
							        	<label class="form-label" for="anony_file"><span>대표자 신분증/재직증명서</span></label>
						              	<div class="form-group files">
						                	<input type="file" class="form-control color file"  
						                	       name="file2"		
						                		   id="file2"
						                		   onchange="uploadFile(this, 'fNameOwner', 'f_size_owner')"
						                		   required>                	
						                		
							          		<button type="button" 
							          				class="hideBtn"
							          				onclick="hideFileBtn(this, 'file2')"
							          				>첨부파일</button>
							          				
							          		<input type="hidden" name="fNameOwner">		
							          		<input type="hidden" name="f_size_owner">		
						              	</div>
		       							 
		       							<span>학원 등록은 신청일로부터 3일 이내로 완료될 예정입니다.</span> 
							        <div class="textwriteBtn">
							          <button type="submit" class="btn btn-write" style="margin-top: 50px;">등록요청</button>
							        </div>
							        
							        <!-- 드래그 테스트용 태그 -->
							        <!-- <p>drag and drop your image!</p>
									<div class="content">
										<h1>test</h1>
										<p>adsfaaf</p>
									</div> -->
																       
						      </div>
					      </form>
				    </div>

				</div> <!-- class="col" -->
			</div> <!-- class="row" -->
		</div> <!-- class="container" -->
	</div> <!-- class="about" -->


<!------------------------------------------------------- [스크립트 영역] -------------------------------------------->
<script src="./styles/dist/js/sidebarmenu.js"></script>

</body>
</html>