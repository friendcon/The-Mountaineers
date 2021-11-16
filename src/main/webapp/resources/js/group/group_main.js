
$(document).ready(function(){
	let scroll_end = false;
	let hashLists = [];
	let keyword = "";
	let hashSet = new Set();
	var append_here = $('.append_here');
	
	
	var swiper = new Swiper(".mySwiper", {
		cssMode: true,
		autoplay: {
		 	delay: 3000,
		 },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
        pagination: {
          el: ".swiper-pagination",
        },
        mousewheel: true,
        keyboard: true,
	});
	
	function getGroupList() {
		if(scroll_end == true) {
			return;
		}
		
		console.log("list : " + hashLists);
		
		console.log("keyword : " + keyword);
		var lastone = $('input[type="hidden"]').val();
		console.log("마지막 요소 : " + lastone);

		if(lastone == 0){
			lastone = $('.group_container:last').data("groupno");
			console.log("처리후 마지막 요소: " + lastone); 
		}
		
		$.ajax({
			url: '/group/getlist',
			type: 'GET',
			data: {
				"hashList" : hashLists,
				"lastGroup" : lastone,
				"keyword" : keyword
			},
			dataType : "json",
			cache: false,
			contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
			success: function(result){
				console.log("몇번오니");
				var addGroupHtml = "";
				var group_list_container = $('group_list_container');
				
				for(var i=0; i<result.length; i++) {
					addGroupHtml += "<div class='group_container' data-groupno='" + result[i].group_no + "'>" +
							"<div class='group_img'>";
					addGroupHtml += "<img class='group_profile_image' name='group_profile_image' src='/group/getImg/";
					addGroupHtml += result[i].group_no;
					addGroupHtml += "'/></div><div class='group_content_box'><h5><a href=''>";
					addGroupHtml += result[i].group_name;
					addGroupHtml += "</a></h5>";
					addGroupHtml += "<label class='level";
					addGroupHtml += result[i].group_level;
					addGroupHtml += "'> Level ";
					addGroupHtml += result[i].group_level;
					addGroupHtml += "</label><p>"
					addGroupHtml += result[i].group_content;
					addGroupHtml += "</p></div></div>"
				}

				if(result.length < 6) {
					scroll_end = true;
				}
				
				var lastGroupNo = result[result.length-1].group_no;

				$('input[type="hidden"]').val(lastGroupNo);
				$(".append_here").append(addGroupHtml);

				
			},
			error: function(request, status, error){
				alert("에러");
				console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

			}
		})
	};
	
	function getCheckBox(){
		hashLists = [];
		$('input[type="checkbox"]:checked').each(function(){
			hashLists.push($(this).val());
		});
	}
	
	$(".searchButton").on("click", function(e){
		scroll_end = false;
		getCheckBox();
		keyword = $("input[id='group_search']").val();
		console.log(keyword);
		$(".append_here").empty();
		$('input[type="hidden"]').val(0);
		getGroupList();
	})
	
	$(window).on("scroll", function(e){
		var max_height = $(document).height(); // 문서 높이
		var now_height = $(window).scrollTop() + $(window).height();
		if(max_height - 200 < now_height ){
			getGroupList();
		}
	})

	$(".region").on("change", function(e){
		scroll_end = false;
		getCheckBox();
		console.log(hashLists);
		var obj = $(this).children("input");
		if(obj.is(":checked")) {
			$(this).css("background-color", "#ffa8a8");
			$(this).css("border-color", "#ffa8a8");
			$(".append_here").empty();
			$('input[type="hidden"]').val(0);
			getGroupList();
			console.log("체크됨");
		} else {
			$(this).css("background-color", "#FF7F7F");
			$(this).css("border-color", "#FF7F7F");
			$(".append_here").empty();
			$('input[type="hidden"]').val(0);
			getGroupList();
			console.log("체크해제됨");
		}
	})
	
	$(".age").on("change", function(e){
		scroll_end = false;
		getCheckBox();
		var obj = $(this).children("input");
		if(obj.is(":checked")) {
			$(this).css("background-color", "#ffd793");
			$(this).css("border-color", "#ffd793");
			$(".append_here").empty();
			$('input[type="hidden"]').val(0);
			getGroupList();
			console.log("체크됨");
		} else {
			$(this).css("background-color", "#FFA000");
			$(this).css("border-color", "#FFA000");
			$(".append_here").empty();
			$('input[type="hidden"]').val(0);
			getGroupList();
			console.log("체크해제됨");
		}
	})
	
	$(".time").on("change", function(e){
		scroll_end = false;
		getCheckBox();
		var obj = $(this).children("input");
		if(obj.is(":checked")) {
			$(this).css("background-color", "#f7e7a6");
			$(this).css("border-color", "#f7e7a6");
			$(".append_here").empty();
			$('input[type="hidden"]').val(0);
			getGroupList();
			console.log("체크됨");
		} else {
			$(this).css("background-color", "#eecc42");
			$(this).css("border-color", "#eecc42");
			$(".append_here").empty();
			$('input[type="hidden"]').val(0);
			getGroupList();
			console.log("체크해제됨");
		}
	})
	
	$(".type").on("change", function(e){
		scroll_end = false;
		getCheckBox();
		var obj = $(this).children("input");
		if(obj.is(":checked")) {
			$(this).css("background-color", "#a0d6a4");
			$(this).css("border-color", "#a0d6a4");
			$(".append_here").empty();
			$('input[type="hidden"]').val(0);
			getGroupList();
			console.log("체크됨");
		} else {
			$(this).css("background-color", "#81c784");
			$(this).css("border-color", "#81c784");
			$(".append_here").empty();
			$('input[type="hidden"]').val(0);
			getGroupList();
			console.log("체크해제됨");
		}
	})
	
	$(".features").on("change", function(e){
		scroll_end = false;
		getCheckBox();
		var obj = $(this).children("input");
		if(obj.is(":checked")) {
			$(this).css("background-color", "#bbc6ff");
			$(this).css("border-color", "#bbc6ff");
			$(".append_here").empty();
			$('input[type="hidden"]').val(0);
			getGroupList();
			console.log("체크됨");
		} else {
			$(this).css("background-color", "#8C9EFF");
			$(this).css("border-color", "#8C9EFF");
			$(".append_here").empty();
			$('input[type="hidden"]').val(0);
			getGroupList();
			console.log("체크해제됨");
		}
	})
	
	$(".grade").on("change", function(e){
		scroll_end = false;
		getCheckBox();
		var obj = $(this).children("input");
		if(obj.is(":checked")) {
			$(this).css("background-color", "#c5b3e3");
			$(this).css("border-color", "#c5b3e3");
			$(".append_here").empty();
			$('input[type="hidden"]').val(0);
			getGroupList();
			console.log("체크됨");
		} else {
			$(this).css("background-color", "#9575cd");
			$(this).css("border-color", "#9575cd");
			$(".append_here").empty();
			$('input[type="hidden"]').val(0);
			getGroupList();
			console.log("체크해제됨");
		}
	})
});