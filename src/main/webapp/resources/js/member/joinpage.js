$(document).ready(function(){	
	
	var error = $(".error_next_box"); // 에러 박스 배열
	var id = $("#mem_id");
	var pwd = $("#mem_pwd");
	var checkpwd = $("#mem_pwd_check");
	
	function checkMemberId() {
		
		// 아이디 패턴은 5~20자의 영어 소문자, 숫자와 특수기호(_, -) 만 사용 가능
		var idPattern = /[a-z0-9-_]{5,20}/;
		var null_message = "아이디를 입력해주세요.";
		var fail_message = "5~20자의 영어 소문자, 숫자와 특수기호(_, -) 만 사용 가능합니다.";
		var success_message = "사용가능한 아이디입니다.";

		if(id.val() == "") {
			console.log("아이디" + id.val());
			error[0].append(null_message);
			id.parent("span").next().css("style", "display:block");
			id.parent("span").next().css("color", "red");
		} else if(!idPattern.test(id.val())) {
			error[0].append(fail_message);
			id.parent("span").next().css("style", "display:block");
			id.parent("span").next().css("color", "red");
		} else if(idPattern.test(id.val())) {
			error[0].append(success_message);
			id.parent("span").next().css("display", "block");
			id.parent("span").next().css("color", "#028651");
		}
		
	}
	
	function checkMemberPwd() {
		var pwdPattern = /^[a-z0-9]/;
			
		var null_message = "비밀번호를 입력해주세요.";
		var fail_message = "8~20자 영문 소문자, 특수문자를 사용하세요.";
		var success_message = "사용 가능한 비밀번호입니다";
		
	}
	
	$("#mem_id").on("focusout", function(e){
		checkMemberId();
	})
	
	$("#mem_id").on("focusin", function(e){
		console.log("focus in");
		id.parent("span").next().empty();
	})
})