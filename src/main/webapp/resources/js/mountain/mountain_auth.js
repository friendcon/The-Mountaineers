function success(position) {
	var currentX = position.coords.latitude;
	var currentY = position.coords.longitude;
	console.log(currentX);
	console.log(currentY);
	var mountaincode = document.getElementById("mountain_code").value;
	console.log(mountaincode);
	$.ajax({
		url: '/mountain/compareXY',
		type: 'GET',
		data: {
			  "mountaincode" : mountaincode,
			  "currentX" : currentX,
			  "currentY" : currentY
		},
		contentType:  "application/x-www-form-urlencoded; charset=UTF-8;",
		success: function(result) {
			console.log("성공");
			if(result == 'failauth') {
				alert("위치인증실패");
			} else if(result == 'successauth') {
				alert("위치인증성공");
			}
		}, 
		error: function(request, status, error){
			alert("에러");
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	  }
	})
}
function findMyLocation() {
	if(navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(success);
	} else {
		alert("해당 브라우저에서는 위치정보를 가져올 수 없습니다.");
	}
}

window.onload = function(){
	
	
	var positionButton = document.getElementById("positionButton");
	//console.log(positionButton);
	positionButton.addEventListener("click", function() {
		findMyLocation();
	});
	
}