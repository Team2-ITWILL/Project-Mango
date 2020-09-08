/*
 * aca_admin_revise.jsp에서 호출하는 함수 모음
 * 
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


$(document).ready(function(){
	var hideBtn = document.querySelector(".hideBtn");
	var fileBtn = document.querySelector("#file_img");
	var submitBtn = document.querySelector("#formSubmit");
	
	//사진 변경하기 버튼 클릭 -> FILE태그 실행
	hideBtn.onclick = function(){
		fileBtn.click();		
	}
	
	//FILE태그에 파일이 등록되면 값의 변화를 감지하는 onchange 이벤트를 통해서 썸네일함수 실행
	fileBtn.onchange = function(){
		setThumbnail(this);
		
		/* var fileBtn = document.querySelector("#file_img");
		var filePath = document.querySelector("input[name=mem_profileImg]");
		uploadFile(fileBtn, filePath);	 */
		
		var fileInfo = fileBtn.files[0];
		console.log(fileBtn);
		console.log(fileBtn.name);
		console.log(fileInfo);
	}			
	
	submitBtn.onclick = function(){				
		
		//file태그에 'name'속성 값을 넣어야 전송이 된다!!
		var form = document.querySelector(".academy_reviseFr");			
		form.action = "./AcademyReviseAction.aca";				
		form.submit();	
	} 		
	
});

//사진 선택 시 미리보기
function setThumbnail(fileBtn){

	var fileInfo = fileBtn.files[0];
	var reader = new FileReader();			
	
	// FileReader.onload : 읽기 동작이 성공적으로 완료 되었을 때마다 발생한다.
	// readAsDataURL( )을 통해 파일을 읽어 들일때 onload가 실행
	reader.onload = function(){
		
		//파일의 URL을 Base64 형태로 가져온다.
		//FileReader.result : 파일의 컨텐츠
		document.querySelector(".rounded-circle").src = reader.result;
		
		//파일 URL정보를 출력
		//var p = document.createElement("p");
		//document.querySelector(".profilespan").appendChild(p).innerHTML = reader.result;
	}
	
	if(fileInfo){
		//readAsDataURL( )을 통해 파일의 URL을 읽어온다.
		reader.readAsDataURL(fileInfo);
	}	
}

function uploadFile(fileTag, filePath) {

	var formData = new FormData();
	formData.append("file", fileTag.files[0]);

	console.log('fileTag.files[0] : ' + fileTag.files[0]);
	console.log('fileTag : ' + fileTag);

	$.ajax({
			data : formData,
			type : "POST",
			url : "./AcademyImgUpload.aca",
			contentType : false,
			processData : false,
			enctype : 'multipart/form-data',
			success : function(data) {
				//파일 경로 및 이름
				filePath.value = data;
				
				//확인용 출력문
				console.log(filePath.value);							
				console.log('data : ' + data);

		}
	});
}


var newJquery = $.noConflict(true);
//기존 라이브러리 : $
//새로운 라이브러리 : newJquery

newJquery(function(){	
	  var aca_start_date = document.querySelector("#aca_start_date");
	  newJquery(aca_start_date).datepicker({		  	
		  changeMonth : true,
		  changeYear : true,
		  nextText : '다음 달',
		  prevText : '이전 달',
		  showButtonPanel : true,
		  currentText : '오늘 날짜',
		  closeText : '닫기',
		  
		  //dateFormat : "yy-mm-dd",		
		  dateFormat : "yymmdd",	
		  
        dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
        dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
        monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	  	  minDate : "+1", // 오늘날짜 이후부터 선택
	  	  maxDate: "+5M +1D" //최대 가능한 날짜
	  });
});	  

