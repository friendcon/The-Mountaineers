function success(position) {
	var currentX = position.coords.latitude;
	var currentY = position.coords.longitude;
	/*var currentX = 37.54827340419427;
	var currentY = 126.82658983577895;*/
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
			var authBtn = document.getElementById("createButton");
			var fileBtn = document.getElementById("fileBtn");
			if(result == 'failauth') {
				alert("위치인증실패");
				authBtn.disabled = true;
				fileBtn.disabled = true;
			} else if(result == 'succesauth') {
				alert("위치인증성공");
				authBtn.disabled = false;
				fileBtn.disabled = false;
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

function getImage() {
	var multi = document.getElementById("fileBtn").files;
	var data = new FormData();
	
	for(var i=0; i<multi.length; i++) {
		data.append('uploadFile', multi[i] );
	}

	$.ajax({
		url: '/mountain/getPath',
		type: 'POST',
		processData: false, 
		contentType: false,
		cache: false,
		dataType: 'json',
		data : data,
		success: function(result) {
			for(var i = 0; i<result.length; i++) {
				var imgContainer = document.getElementById("imgSrcCotainer");
				var slider = document.createElement('div');
				slider.className = "swiper-slide";
				var img = document.createElement('img');
				img.setAttribute("src", result[i]);
				slider.appendChild(img);
				imgContainer.appendChild(slider);
			}
			
		}, 
		error: function(request, status, error){
			alert("에러");
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	})
}

window.onload = function(){
	var positionButton = document.getElementById("positionButton");
	//console.log(positionButton);
	positionButton.addEventListener("click", function() {
		findMyLocation();
	});
	
	var fileButton = document.getElementById("fileBtn");
	console.log(fileButton);
	fileButton.addEventListener("click", function() {
		
	});
	
	var getFile = document.querySelector("input[type='file']");
	console.log(getFile);
	getFile.addEventListener("change", function() {
		getImage(getFile);
	})
	
	var authBtn = document.getElementById("createButton");
	authBtn.addEventListener("click", function(){
		alert("인증 게시글이 등록되었습니다.");
	})
	
	 var swiper = new Swiper(".mySwiper", {
	        effect: "coverflow",
	        grabCursor: true,
	        centeredSlides: true,
	        slidesPerView: "auto",
	        coverflowEffect: {
	          rotate: 50,
	          stretch: 0,
	          depth: 100,
	          modifier: 1,
	          slideShadows: true,
	        },
	        pagination: {
	          el: ".swiper-pagination",
	        },
	      });
}