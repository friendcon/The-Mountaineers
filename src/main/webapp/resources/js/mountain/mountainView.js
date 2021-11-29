/*var check = false;
function viewPath(count) {	
	var pathId = "path" + count;
	var xyArr = document.getElementById(pathId).value.split("/");
	var linePath = [];
	console.log(xyArr.length);
	for(var i=0; i<xyArr.length - 1; i++) {
		var splitPoint = xyArr[i].split(",");
		var point = new kakao.map.LatLng(splitPoint[0], splitPoint[1]);
	}
	

	var polyline = new kakao.maps.Polyline({
	    path: linePath, // 선을 구성하는 좌표배열 입니다
	    strokeWeight: 5, // 선의 두께 입니다
	    strokeColor: '#FFAE00', // 선의 색깔입니다
	    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
	    strokeStyle: 'solid' // 선의 스타일입니다
	});
	
	polyline.setMap(map);
}*/

window.onload = function(){
	/*var pathViewButton = document.getElementsByClassName('viewpath');
	console.log(pathViewButton.length);
	for(var i=0; i<pathViewButton.length; i++) {
		pathViewButton[i].addEventListener("click", viewPath(i+1));
	}*/
	
	/*for(var i=0; i<pathViewButton.length; i++) {
		console.log("sdasasd");
		pathViewButton[i].addEventListener("click", viewPath(i+1));
	}*/
}