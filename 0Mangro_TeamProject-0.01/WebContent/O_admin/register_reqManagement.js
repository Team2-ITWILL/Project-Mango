/**
 * register_reqManagement.jsp에 적용되는 자바스크립트 파일
 */

//=====================사업자등록증/신분증 이미지 띄우기==============================

function viewRegImages(btn, filePath, fileType){
	
	var imgSourcePath = "./" + filePath;
	
	//모달창 제목 변경
	var title = document.querySelector(".modal-title");
	title.innerText = fileType;

	//모달창의 이미지태그에 파일 삽입
	var imgTag = document.querySelector(".insertImg");		
	imgTag.src = imgSourcePath;
	//console.log(imgTag);
	
	btn.setAttribute('data-toggle', 'modal');
	btn.setAttribute('data-target', '.imgView');
	
	//console.log(btn);		
}


//=====================승인/취소 처리 액션페이지로 전송=====================
function approveReg(regEmail, acaName, aca_keyword, flag){
	
	// create form tag
	var regForm = document.createElement('form');
	regForm.action = "./regChangeApproval.areg";
	regForm.method = "get";
	
	// create input Tag
	var input1 = document.createElement('input');
	var input2 = document.createElement('input');
	var input3 = document.createElement('input');
	var input4 = document.createElement('input');
	
	// set attribute
	input1.setAttribute('type', 'hidden');
	input1.setAttribute('name', 'flag');
	input1.setAttribute('value', flag);
	
	input2.setAttribute('type', 'hidden');
	input2.setAttribute('name', 'acaName');
	input2.setAttribute('value', acaName);			
	
	input3.setAttribute('type', 'hidden');
	input3.setAttribute('name', 'aca_keyword');
	input3.setAttribute('value', aca_keyword);
	
	input4.setAttribute('type', 'hidden');
	input4.setAttribute('name', 'regEmail');
	input4.setAttribute('value', regEmail);
				
	// append input to Form
	regForm.appendChild(input1);
	regForm.appendChild(input2);
	regForm.appendChild(input3);
	regForm.appendChild(input4);
	
	// append form to body
	document.body.appendChild(regForm);
	
	console.log(regForm);
	
	// submit form
	regForm.submit();				
	
}	


function pagination(selectedTag){
	
	//=================클릭한 태그 active로 변경===============
	$(selectedTag).addClass('active');	
	//console.log(selectedTag);
	
	//=================기존의 active 태그 비활성화=====================
	//<li> 태그들을 가져온다
	var li = document.querySelectorAll('.pagination .page-item');
	for(var i=0; i < li.length; i++){		
		
		//<li> 태그의 자식태그들 중 <a>태그를 찾는다
		var child = li[i].childNodes;
		for(var j=0; j < child.length; j++){
			//nodeName property는 속성명을 대문자로 반환한다
			//속성명이 <a>태그일 경우
			if(child[j].nodeName == 'A'){ 
				//alert('child[j] is <a>');
				//<a>태그의 클래스 속성중 active가 존재할 경우 active 비활성화
				if($(child[j]).hasClass('active')){				
					var activated = child[j];
					$(activated).removeClass('active');
				}
			}
		}		
	}	
}

window.onload = function(){
	
	var li = document.querySelectorAll('.pagination .page-item');
	var active;
	for(var i=0; i < li.length; i++){		
		li[i].addEventListener('click', function(event){			
			pagination(event.target);		
		});			
	}	
	
}//window.onload
