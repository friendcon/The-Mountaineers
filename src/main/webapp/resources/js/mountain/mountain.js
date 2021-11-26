
// 검색 버튼 클릭시
/*
 * 1. lastmountain value를 nomountain으로 바꿔줘야한다
 * 2. 스크롤 다시 처음으로 이동해야한다
 */
var scrollEnd = false;

function getMountain() {
	
	var lastMountain = document.getElementById("lastmountain").value;
	var keyword = document.getElementById("mountain_search").value;
	console.log(lastMountain);
	console.log(keyword);
	if(scrollEnd == true) {
		return;
	}
	$.ajax({
		  url: '/mountain/getList',
		  type: 'GET',
		  data: {
			  "lastmountain" : lastMountain,
			  "keyword" : keyword
		  },
		  dataType: "json",
		  cache: false,
		  contentType:  "application/x-www-form-urlencoded; charset=UTF-8;",
		  success: function(result) {
			  console.log("hello");
			  var appendHere = $(".append_here");
			  var addMountainHtml = "";
			  
			  for(var i=0; i<result.length; i++) {
				  addMountainHtml += "<div class='mountain_container' data-groupno ='";
				  addMountainHtml += result[i].mouontain_code;
				  addMountainHtml += "'><div class='group_img'><img class='group_profile_image' name='group_profile_image'/>";
				  addMountainHtml += "</div><div class='mountain_content_box'>";
				  addMountainHtml += "<h5><a href='/mountain/view?mountain_code=";
				  addMountainHtml += result[i].mountain_code;
				  addMountainHtml += "'>";
				  addMountainHtml += result[i].mountain_name;
				  addMountainHtml += "</a></h5><p>산 높이 : ";
				  addMountainHtml += result[i].mountain_hight;
				  addMountainHtml += "m<br>";
				  addMountainHtml += result[i].mountain_address;
				  addMountainHtml += "<br>";
				  addMountainHtml += result[i].mountain_phone;
				  addMountainHtml += "</p></div></div>";
			  }
			  
			  if(result.length < 6) {
				  scrollEnd = true;
			}
			  console.log(addMountainHtml);
			  var lastMountainNo = result[result.length-1].mountain_code;
			  console.log(lastMountainNo);
			  $(".append_here").append(addMountainHtml);
			  
			  document.getElementById("lastmountain").value = lastMountainNo;
		  },
		  error: function(request, status, error){
				alert("에러");
				console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		  }
	})
}

window.onload = function(){
	var mountainSearchBtn = document.getElementById("mountainSearchBtn");
	var lastMountain = document.getElementById("lastmountain");
	var keyword = document.getElementById("mountain_search");
	var mountains = $(".append_here");

	mountainSearchBtn.addEventListener("click", function(e) {
		  var scrollEnd = false;
		  var empty = document.getElementById("append_here");
		  lastMountain.value = "nomountain";
		  mountains.empty();
		  getMountain();
	});
}


$(window).on("scroll", function(e){
	var max_height = $(document).height(); // 문서 높이
	var now_height = $(window).scrollTop() + $(window).height();
	if(max_height - 200 < now_height ){
		getMountain();
	}
})