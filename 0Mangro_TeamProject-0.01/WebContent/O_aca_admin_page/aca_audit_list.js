/**
 * 	[aca_audit_list.jsp에 적용되는 자바스크립트 파일]
 */

function fncApprove(audit_num, aca_num){
	location.href = "./AuditApproval.adrq?"
			+ "audit_num=" + audit_num
			+ "&aca_num=" + aca_num
			+ "&check=" + "approve";
	}	

function fncReject(audit_num, aca_num){
	location.href = "./AuditApproval.adrq?"
		+ "audit_num=" + audit_num
		+ "&aca_num=" + aca_num
		+ "&check=" + "reject";
	}	 

function fncDelete(audit_num, aca_num){
	location.href = "./AuditApproval.adrq?"
		+ "audit_num=" + audit_num
		+ "&aca_num=" + aca_num
		+ "&check=" + "delete";
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