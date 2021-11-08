$(document).ready(function(){
	var error = $(".error_next_box"); // 에러 박스 배열
	var group_name = $("#group_name");
	var group_count = $("#group_count");
	var check_label = $(".check_box_label");
	function groupNameCheck() {
		var null_message = "그룹명을 입력해주세요.";
		var success_message = "멋진 그룹명이네요!";
		console.log(group_name.val());
		if(group_name.val() == "") {
			error[0].append(null_message);
			group_name.parent("span").next().css("color", "red");
		} else {
			error[0].append(success_message);
			group_name.parent("span").next().css("color", "#028651");
		}
	}
	
	function groupCountCheck() {
		var countPattern = /[0-9]{2}/;
		var null_message = "그룹원 수를 입력해주세요.";
		var max_message = "그룹원 수는 최대 50명 까지입니다.";
		var min_message = "그룹원 수는 최소 3명부터 입니다."
		var error_message = "숫자 형식으로 입력해주세요.";
			
		if(group_count.val() == "") {
			error[2].append(null_message);
			group_count.parent("span").next().css("color", "red");
		} else if(!countPattern.test(group_count.val())) {
			error[2].append(error_message);
			group_count.parent("span").next().css("color", "red");
		} else if(group_count.val() > 50) {
			error[2].append(max_message);
			group_count.parent("span").next().css("color", "red");
		} else if(group_count.val() < 3){
			error[2].append(min_message);
			group_count.parent("span").next().css("color", "red");
		}
	}
	
	$(".check_box_label").on("change", function(e){
		var obj = $(this).children("input");
		if(obj.is(":checked")) {
			$(this).css("background-color", "#6B8E23");
			$(this).css("border-color", "#6B8E23");
			console.log("체크됨");
		} else {
			$(this).css("background-color", "#028651");
			$(this).css("border-color", "#028651");
			console.log("체크해제됨");
		}
	})
	
	/*$(".check_box_label").on("mouseover", function(e) {
		$(this).css("background-color", "#6B8E23");
		$(this).css("border-color", "#6B8E23");
	})
	
	$(".check_box_label").on("mouseout", function(e) {
		$(this).css("background-color", "#028651");
		$(this).css("border-color", "#028651");
	})*/
	
	$("#group_name").on("focusout", function(e){
		groupNameCheck();
	})
	
	$("#group_name").on("focusin", function(e){
		group_name.parent("span").next().empty();
	})
	
	$("#group_count").on("focusout", function(e){
		groupCountCheck();
	})
	
	$("#group_count").on("focusin", function(e){
		group_count.parent("span").next().empty();
	})
})