
$(document).ready(function(){
	var swiper = new Swiper(".mySwiper", {
		cssMode: true,
		autoplay: {
		 	delay: 3000,
		 	//disableOnInteraction: false,
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
	
	$(".region").on("change", function(e){
		var obj = $(this).children("input");
		if(obj.is(":checked")) {
			$(this).css("background-color", "#ffa8a8");
			$(this).css("border-color", "#ffa8a8");
			console.log("체크됨");
		} else {
			$(this).css("background-color", "#FF7F7F");
			$(this).css("border-color", "#FF7F7F");
			console.log("체크해제됨");
		}
	})
	
	$(".age").on("change", function(e){
		var obj = $(this).children("input");
		if(obj.is(":checked")) {
			$(this).css("background-color", "#ffd793");
			$(this).css("border-color", "#ffd793");
			console.log("체크됨");
		} else {
			$(this).css("background-color", "#FFA000");
			$(this).css("border-color", "#FFA000");
			console.log("체크해제됨");
		}
	})
	
	$(".time").on("change", function(e){
		var obj = $(this).children("input");
		if(obj.is(":checked")) {
			$(this).css("background-color", "#f7e7a6");
			$(this).css("border-color", "#f7e7a6");
			console.log("체크됨");
		} else {
			$(this).css("background-color", "#eecc42");
			$(this).css("border-color", "#eecc42");
			console.log("체크해제됨");
		}
	})
	
	$(".type").on("change", function(e){
		var obj = $(this).children("input");
		if(obj.is(":checked")) {
			$(this).css("background-color", "#a0d6a4");
			$(this).css("border-color", "#a0d6a4");
			console.log("체크됨");
		} else {
			$(this).css("background-color", "#81c784");
			$(this).css("border-color", "#81c784");
			console.log("체크해제됨");
		}
	})
	
	$(".features").on("change", function(e){
		var obj = $(this).children("input");
		if(obj.is(":checked")) {
			$(this).css("background-color", "#bbc6ff");
			$(this).css("border-color", "#bbc6ff");
			console.log("체크됨");
		} else {
			$(this).css("background-color", "#8C9EFF");
			$(this).css("border-color", "#8C9EFF");
			console.log("체크해제됨");
		}
	})
	
	$(".grade").on("change", function(e){
		var obj = $(this).children("input");
		if(obj.is(":checked")) {
			$(this).css("background-color", "#c5b3e3");
			$(this).css("border-color", "#c5b3e3");
			console.log("체크됨");
		} else {
			$(this).css("background-color", "#9575cd");
			$(this).css("border-color", "#9575cd");
			console.log("체크해제됨");
		}
	})
});