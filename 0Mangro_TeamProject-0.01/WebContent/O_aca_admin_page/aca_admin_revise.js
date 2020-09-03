/**
 * 
 */

function setThumbnail(event){
	
	for(var image of event.target.files){
		var reader = new FileReader();
		
		reader.onload = function(event){
			var img = document.createElement("img");
			img.setAttribute("src", event.target.result);
			document.querySelector(".rounded-circle").appendChild(img);
		
		};
		
		console.log(image);
		reader.readAsDataURL(image);
	}
}

