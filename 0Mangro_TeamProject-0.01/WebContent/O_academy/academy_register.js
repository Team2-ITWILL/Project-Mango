/**
 * academy_register.jsp에서 호출하는 함수 모음
 */

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

//======================================================================================

//================================학원 찾기======================================
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
				
				//datalist 초기화
				searchList.innerHTML = "";
				//재검색을 위하여 input태그의 기존 검색결과 삭제
				aca_search_result.value = "";
				aca_search_result.removeAttribute('list');
				
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
				}); //aca_search_result.addEventListener
				
				
			} //ajax:success
		}); //ajax
	}); //search_Btn.addEventListener		
	
	
	//=======================키워드 선택==========================
	
	//	https://jsdev.kr/t/document-queryselectorall-addeventlistener/5170/2
	//	document.querySelectorAll 에서는 addEventListener가 왜 안될까요?
	//	document.getElementById는 단일 DOM 객체를 가져오지만, 
	//	document.querySelectorAll은 NodeCollection을 가져오기 때문입니다.
	//	또한 NodeCollection은 숫자 인덱스를 가지고 있고 length property를 가지고 있지만, 
	//	배열은 아니므로 forEach등의 Iterator Function을 호출할 수 없습니다.		

	var keyword = document.querySelector("input[name='keyword']");
	var li = document.querySelectorAll(".tags_list li");	

	//document.querySelectorAll은 은 forEach(for in)문을 사용할 수 없다!!!
	//for(var i in li){		(X)
	for(var i=0; i < li.length; i++){					
		
		li[i].addEventListener("click", function(event){	
			
			//selected 상태이면 해당 클래스 제거
			if($(event.target).hasClass('selected')){
				$(event.target).removeClass('selected');
			//selected 상태가 아니면 키워드 선택	
			}else{
				//list태그 일괄 selected 클래스 제거
				$(li).removeClass('selected');
				
				//이벤트가 발생한(선택한) 키워드를 이용하여 키워드태그 값 변경
				selectKey(event.target);
			}		
		});			
	}			
	
} //window.onload()

function selectKey(selectedTag){
	
	//키워드 값이 들어갈 태그(form태그로 전송)
	var keyword = document.querySelector("input[name='keyword']");
	//키워드 선택란(화면에 보여줄 태그명)
	var keyword_view = document.querySelector("input[name='keyword_view']");
	
	//클래스 속성명
	var attr = selectedTag.getAttribute("class");
	
	//끝점으로부터 처음 만나는 문자열의 위치
	var idx = attr.lastIndexOf("y"); //firstKey, secondKey, thirdKey의 끝인 y	
	
	//'firstKey'를 탐색했을 때 문자열이 존재한다면
	if(	   (attr.indexOf("firstKey") != -1) 
		|| (attr.indexOf("secondKey") != -1) 
		|| (attr.indexOf("thirdKey") != -1))
	{
		//클래스 속성명 중 ~~key 이후의 속성명을 반환받아 keyword(input tag)에 저장		
		keyword.value = attr.substr(idx + 2); 	
		
		//키워드 선택란에 선택한 태그명을 저장
		keyword_view.value = selectedTag.innerText;	
		
		//키워드태그 css 색깔 변경
		$(selectedTag).addClass('selected');
		//$(selectedTag).addClass('active');
		
	}else{
		alert("error! not defined key")
	}
	console.log(keyword.value);
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
	
	//파일 경로 및 이름
	document.getElementsByName(name)[0].value = uploadFile.files[0].name;
	//파일 크기
	document.getElementsByName(size)[0].value = uploadFile.files[0].size;
	
//	console.log(document.getElementsByName(name)[0].value);
//	console.log(document.getElementsByName(size)[0].value);
//	console.log(uploadFile);

//============ajax를 안 쓰고 AcademyRegisterAction에서 일괄 DB에 업로드할 것임==========================
	
/*	
	//=================파일태그에 input된 파일들을 ajax로 서버에 업로드======================
	var formData = new FormData();
	formData.append("file", uploadFile.files[0]);
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
			});  //ajax
	*/
	
	
}//uploadFile()

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

	
//	if (files != null) {
//
//		if (files.length > 1) {
//			alert('파일을 하나만 올려주세요.');
//			return;
//		} else if (files.length < 1) {
//			alert('폴더 업로드 불가');
//			return;
//		}
//
//		//이미지 파일이면 input태그에 값 넣기 & 배경이미지 등록
//		if (files[0].type.match(/image.*/)) {
//			//배경 이미지 등록(css)
//			$(e.target).css(
//					{
//						"background-image" : "url("
//								+ window.URL.createObjectURL(files[0])
//								+ ")",
//						"outline" : "none",
//						"background-size" : "100% 100%"
//					});
//		} else {
//			alert('이미지가 아닙니다.');
//			return;
//		}

		
		
		//이벤트가 발생한 input file태그 value값에 추가
		e.target.val = files[0];
		//input file태그 required 속성 없애기(파일선택버튼으로 추가한 것처럼 처리되게 하기 위함)
		$(e.target).attr('required', false);

		//형제 태그 중 파일이름, 파일크기를 저장할 input태그를 선택하여 upload함수의 매개변수에 넣어줌 	
		var fileTag = document.getElementsByName(e.target.name)[0];
		var fileName = $(e.target).siblings()[1];
		var fileSize = $(e.target).siblings()[2];

		console.log('fileTag : ' + fileTag);
		console.log('fileName : ' + fileName);
		console.log('fileSize : ' + fileSize);
		
		//=============이미지파일 서버에 업로드(ajax)=================
		/*
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
		}); //ajax
		*/

		
	//파일이 없을 경우
//	} else {
//		alert("error");
//	}
}