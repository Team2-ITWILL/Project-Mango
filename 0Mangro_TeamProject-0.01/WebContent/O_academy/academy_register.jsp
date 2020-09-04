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

<%---------------------[스크립트영역] 다음 주소API ---------------------------------------------%>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
    
</script>



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



</style>

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
					      >
					      <!-- enctype="multipart/form-data"> -->
      
      							
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
									        <input type="button" class="btn btn-write" onclick="" value="학원 찾기" id="search_aca_btn" list="searchList"><br> 
											
											
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
<%---------------------[회원가입 버튼]-----------------------------------------------------------------------------------------------%>
						      
						      		
						      		
							        <div class="form-group mb-8">
								        <label class="form-label" for="anony_pwd"><span>학원 이름</span></label>
								        <input type="text" class="form-control" name="acaName" id="acaName" placeholder="ex) 망고학원" required> 
								    </div>
								    
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

	<script type="text/javascript">	
	
		//===============학원 찾기==================
			
		window.onload = function(){
			
			var search_Btn = document.querySelector("#search_aca_btn"); //학원찾기 버튼
			search_Btn.addEventListener("click", function(event){
				
				var search_val = document.querySelector("input[name='aca_search']").value; 				
				var transferVal = {'search' : search_val}; //JSON형태로 변환				
				//console.log(search_val);
				//console.log(transferVal);
				
				$.ajax({
					data : transferVal,
					type : "GET",
					url : "./registerSearch.areg",			
					success : function(data) {
						//alert('ajax success from registerSearch.areg');
						//console.log('data : ' + data);
						
						var addr_zip = document.querySelector("input[name='addr_zip']");
						var addr_doro = document.querySelector("input[name='addr_doro']");					
						var aca_name = document.querySelector("input[name='acaName']");					
						
						//datalist -> 다시 검색하면 datalist 초기화
						var searchList = document.querySelector("#searchList");
								
						//datalist가 들어갈 input 태그
						var aca_search_result = document.querySelector("input[name='aca_search_result']");
						
						//재검색을 위하여 input태그의 기존 검색결과 삭제
						searchList.innerHTML = "";
						aca_search_result.value = "";
						
						//data : JSONArray
						//학원 명이 여러 개 검색될 경우 처리 -> datalist
						for(var i in data){
							//option 태그 생성 및 검색한 학원명을 삽입
							var opt = document.createElement("option");
							opt.value = data[i].aca_name;
							
							//option 태그를 datalist 태그에 삽입
							searchList.appendChild(opt);						
						}
						//datalist를 input태그 list 속성에 추가
						aca_search_result.setAttribute('list', 'searchList');	//태그id로 속성값 부여				
						
						//console.log(searchList);
						//console.log(aca_search_result);		
						
						//검색결과창에서 값을 선택하면 주소,이름 태그에 가져온 값 대입
						aca_search_result.addEventListener('change', function(){
							for(var i in data){
								if(aca_search_result.value == data[i].aca_name){									
									addr_zip.value = data[i].aca_addr_zip;
									addr_doro.value = data[i].aca_addr_doro;	
									aca_name.value = data[i].aca_name;	
								}								
							}
						});
						
					}
				});
			});
			
			
			
			
			
			
		}
	
	//////////////////////////////////////////////////////////////
		// [input type='file' 버튼 숨기기] -> hideBtn 뒤에 가려짐
		function hideFileBtn(hideBtn, fileTagID){				 
			 document.getElementById(fileTagID).click();	
		}			
		
		// 파일선택 시 배경이미지 변경 함수
		function changeImg(files, target) {
			//var files = uploadFile.files;

			if (files != null) {

				if (files.length > 1) {
					alert('파일을 하나만 올려주세요.');
					return;
				} else if (files.length < 1) {
					alert('폴더 업로드 불가');
					return;
				}

				//이미지 파일이면 input태그에 값 넣기 & 배경이미지 등록
				if (files[0].type.match(/image.*/)) {
					//배경 이미지 등록(css)
					$(target).css(
							{
								"background-image" : "url("
										+ window.URL.createObjectURL(files[0])
										+ ")",
								"outline" : "none",
								"background-size" : "100% 100%"
							});
				} else {
					alert('이미지가 아닙니다.');
					return;
				}

			}
		}

		//file태그에 파일이 선택된 후에 변화된 값을 인지하는 onchange이벤트가 발생할 때 uploadFile 함수 실행
		// -> onclick이벤트에 업로드함수를 실행하면 파일선택보다 먼저 수행되어 첨부파일버튼을 다시 클릭해야 업로드가 실행되는 문제 발생
		
		function uploadFile(uploadFile, name, size) {

			//파일선택 후 배경이미지 변경 함수
			var files = uploadFile.files;
			changeImg(files, uploadFile);

			var formData = new FormData();
			formData.append("file", uploadFile.files[0]);
			//formData.append("file", $("#file1")[0].files[0]);		
			//var uploadPath = './O_aca_regFiles/upload/images/';
			console.log('uploadFile.files[0] : ' + uploadFile.files[0]);
			console.log('uploadFile : ' + uploadFile);

			$.ajax({
						data : formData,
						type : "POST",
						url : "./registerUpload.areg",
						contentType : false,
						processData : false,
						enctype : 'multipart/form-data',
						success : function(data) {
	
							console.log('data : ' + data);
	
							//파일 경로 및 이름
							document.getElementsByName(name)[0].value = data;
							//파일 크기
							document.getElementsByName(size)[0].value = uploadFile.files[0].size;
	
							//확인용 출력문
							console.log(name
											+ ': '
											+ document.getElementsByName(name)[0].value);
							console.log(size
											+ ': '
											+ document.getElementsByName(size)[0].value);
							console.log('size : '
									+ document.getElementsByName(size)[0].value
									/ 1024 + "kb");
							console.log('data : ' + data);
	
						}
					});
		}

		//드래그앤드롭 이벤트
		//$('.content')
		$('.files')
			.on('dragover', dragOver)
			.on('dragleave', dragOver)
			.on('drop', uploadFiles);

		// dragover/dragleave event
		// e.target : 이벤트가 발생한 div태그
		function dragOver(e) {
			e.stopPropagation(); //현재 이벤트가 상위로 전파되지 않도록 중단함
			e.preventDefault(); //현재 이벤트의 기본동작을 중단함			

			if (e.type == 'dragover') {
				//e.target : 이벤트가 발생한 div태그
				$(e.target).css({
					'background-color' : 'gray',
					'outline-offset' : '-20px'
				});
			} else {
				$(e.target).css({
					'background-color' : 'white',
					'outline-offset' : '-10px'
				});
			}
		}

		//drop event
		function uploadFiles(e) {
			e.stopPropagation();
			e.preventDefault();

			//드래그오버 이벤트(css) 
			dragOver(e);

			var files = e.originalEvent.dataTransfer.files;
			changeImg(files, e.target);

			if (files != null) {

				if (files.length > 1) {
					alert('파일을 하나만 올려주세요.');
					return;
				} else if (files.length < 1) {
					alert('폴더 업로드 불가');
					return;
				}

				//이미지 파일이면 input태그에 값 넣기 & 배경이미지 등록
				if (files[0].type.match(/image.*/)) {
					//배경 이미지 등록(css)
					$(e.target).css(
							{
								"background-image" : "url("
										+ window.URL.createObjectURL(files[0])
										+ ")",
								"outline" : "none",
								"background-size" : "100% 100%"
							});
				} else {
					alert('이미지가 아닙니다.');
					return;
				}

				//이벤트가 발생한 input file태그 value값에 추가
				e.target.val = files[0];
				//input file태그 required 속성 없애기
				$(e.target).attr('required', false);

				//형제 태그 중 파일이름, 파일크기를 저장할 input태그를 선택하여 upload함수의 매개변수에 넣어줌 	
				var fileTag = document.getElementsByName(e.target.name)[0];
				var fileName = $(e.target).siblings()[1];
				var fileSize = $(e.target).siblings()[2];

				//console.log('fileTag : ' + fileTag);
				//console.log('fileName : ' + fileName);
				//console.log('fileSize : ' + fileSize);

				/////////////////////////////////////////
				//이미지파일 서버에 업로드(ajax)
				var formData = new FormData();
				formData.append("file", e.target.val);
				$.ajax({
					data : formData,
					type : "POST",
					url : "./registerUpload.areg",
					contentType : false,
					processData : false,
					enctype : 'multipart/form-data',
					success : function(data) {
						//파일 경로 및 이름
						fileName.value = data;
						//파일 크기
						fileSize.value = e.target.size;

						//확인용 출력문
						//console.log('name : ' + fileName.value);
						//console.log('size : ' + fileSize.value);
						//console.log('data : ' + data);
					}
				});

			} else {
				alert("error");
			}
		}
	</script>
</body>
</html>