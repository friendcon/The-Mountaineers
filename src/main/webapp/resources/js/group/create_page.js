$(document).ready(function(){
	var error = $(".error_next_box"); // 에러 박스 배열
	var group_name = $("#group_name");
	var group_count = $("#group_count");
	var check_label = $(".check_box_label");
	
	var formObject = $("form[role='form']");
	var profile = $("input[type='file']");
	var fileResult;
	
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
		var countPattern = /^[0-9]*$/;
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
	
	function checkFileExtenstion(fileName, fileSize) {
		
		var filePattern = /(.*?)\.(png|jpg|jpeg|gif|JPG|JPEG|PNG|GIF)$/;
		var fileMaxSize = 10485760; // 10MB
		
		console.log(fileName);
		if(!filePattern.test(fileName)){
			console.log("파일확장자");
			return "fileextension";
		} 
		
		if(fileSize >= fileMaxSize){
			console.log("파일크기");
			return "filesize";
		}
		return "possible";
	}
	
	$("#createButton").on("click", function(e) {
		e.preventDefault(); 
		console.log("group create button clicked");
		//console.log("fileResult" + fileResult);
		
		var inputHidden = "";
		if(fileResult == undefined) {
			
		} else {
			inputHidden += "<input type='hidden' name='profile.uuid' value = '" + fileResult.uuid + "'>";
			inputHidden += "<input type='hidden' name='profile.group_photo_path' value = '" + fileResult.group_photo_path + "'>";
			inputHidden += "<input type='hidden' name='profile.group_photo_name' value = '" + fileResult.group_photo_name + "'>";
			inputHidden += "<input type='hidden' name='profile.group_photo_type' value = '" + fileResult.group_photo_type + "'>";
		}
		
		
		
		console.log(inputHidden);
		formObject.append(inputHidden).submit();
	})
	
	$("input[type='file']").on("change", function(e){
		
		var formData = new FormData();
		var extension_message = "해당 확장자의 파일은 업로드 할 수 없습니다.";
		var file_size_over_message = "파일 사이즈를 초과하였습니다. 10MB 크기 이하의 파일을 첨부하세요.";
		var success_message = "해당 파일을 업로드 할 수 있습니다.";
		
		$(".profile_wrap").next().empty();
		
		var uploadFiles = $("input[type='file']");
		var selectFile = uploadFiles[0].files;

		console.log(selectFile);
		if(checkFileExtenstion(selectFile[0].name, selectFile[0].size) == "filesize") {
			error[4].append(file_size_over_message);
			return false;
		} else if(checkFileExtenstion(selectFile[0].name, selectFile[0].size) == "fileextension") {
			error[4].append(extension_message);
			return false;
		} else if(selectFile == null){
			return false;
		} else {
			$(".profile_wrap").next().css("color", "#028651");
			$("#group_profile").val(selectFile[0].name);
			error[4].append(success_message);
			formData.append("uploadFile", selectFile[0]);
			// formData.append("groupId", id.val());
		}
		
		$.ajax({
			url: '/groupprofile/upload',
			processData: false,
			contentType: false,
			data: formData,
			type: 'POST',
			dataType: 'json',
			async:false, 
			success: function(result){
				console.log(result);
				fileResult = result
			},
			error: function(request, status, error){
				console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
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