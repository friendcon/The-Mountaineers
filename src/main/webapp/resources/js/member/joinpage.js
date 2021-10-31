$(document).ready(function(){	
	
	var error = $(".error_next_box"); // 에러 박스 배열
	var id = $("#mem_id");
	var pwd = $("#mem_pwd");
	var checkpwd = $("#mem_pwd_check");
	var name = $("#mem_name");
	var year = $("#mem_birth");
	var month = $("#mem_month");
	//var month_val = $("#mem_month option:selected").val();
	var day = $("#mem_day");
	var phone = $("#mem_phone");
	var email = $("#mem_email");
	
	function checkMemberId() {
		
		var idPattern = /[a-z0-9-_]{5,20}/;
		var null_message = "아이디를 입력해주세요.";
		var fail_message = "5~20자의 영어 소문자, 숫자와 특수기호(_, -) 만 사용 가능합니다.";
		var success_message = "사용가능한 아이디입니다.";

		if(id.val() == "") {
			error[0].append(null_message);
			id.parent("span").next().css("color", "red");
		} else if(!idPattern.test(id.val())) {
			error[0].append(fail_message);
			id.parent("span").next().css("color", "red");
		} else if(idPattern.test(id.val())) {
			error[0].append(success_message);
			id.parent("span").next().css("color", "#028651");
		}
		
	}
	
	function checkMemberPwd() {
		var pwdPattern = /^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()-_=+])[a-zA-Z0-9!@#$%^&*()-_=+]{8,20}/;
			
		var null_message = "비밀번호를 입력해주세요.";
		var fail_message = "8~20자 영문 소문자, 특수문자를 사용하세요.";
		var success_message = "사용 가능한 비밀번호입니다";

		if(pwd.val() == ""){
			error[1].append(null_message);
			pwd.parent("span").next().css("color", "red");
		} else if(pwdPattern.test(pwd.val())) {
			error[1].append(success_message);
			pwd.parent("span").next().css("color", "#028651");
		} else if(!pwdPattern.test(pwd.val())) {
			error[1].append(fail_message);
			pwd.parent("span").next().css("color", "red");
		}
	}
	
	function checkPwdSame() {
		var null_message = "비밀번호를 입력해주세요.";
		var fail_message = "비밀번호가 일치하지 않습니다.";
		var success_message = "비밀번호가 일치합니다.";
		
		if(pwd.val() == checkpwd.val()) {
			error[2].append(success_message);
			checkpwd.parent("span").next().css("color", "#028651");
		} else if(checkpwd.val() == null) {
			error[2].append(null_message);
			checkpwd.parent("span").next().css("color", "red");
		} else if(checkpwd.val() != pwd.val()) {
			error[2].append(fail_message);
			checkpwd.parent("span").next().css("color", "red");
		}
	}
	
	function checkName() {
		var null_message = "이름을 입력해주세요.";
		var success_message = "멋진 이름이네요.";
		
		if(name.val() == null) {
			error[3].append(null_message)
			name.parent("span").next().css("color", "red");
		} else {
			error[3].append(success_message);
			name.parent("span").next().css("color", "#028651");
		}
	}
	
	function checkYear() {
		var null_message = "태어난 년도 4자리를 정확하게 입력하세요.";
		var fail_message = "다시한번 확인해주세요.";
		
		if(year.val() == "") {
			error[4].append(null_message);
			$("#birth_wrap").next().css("color", "red");
		} else if(year.val() < 1922) {
			error[4].append(fail_message);
			$("#birth_wrap").next().css("color", "red");
		}
	}
	
	function checkMonth() {
		var null_message = "태어난 월을 선택하세요.";
		var month_val = $("#mem_month option:selected").val();

		if(month_val == "") {
			error[4].append(null_message);
		}
	}
	
	function checkDay() {
		var null_message = "태어난 일(날짜) 2자리를 정확하게 입력하세요.";
		var fail_message = "생년월일을 다시 확인해주세요.";
		
		var set31 = new Set([1, 3, 5, 7, 8, 10, 12 ]);
		var set30 = new Set([4, 6, 9, 11]);
		var month_val = $("#mem_month option:selected").val();

		if(day.val() == "" || month_val == "월") {
			console.log(day.val());
			error[4].append(null_message);
			$("#birth_wrap").next().css("color", "red");
		} else if(month_val == 2){
			if((year.val()%4 == 0) && (year.val() % 100 != 0) && (year.val() % 400 == 0)) {
				if(day.val() > 29){
					console.log("윤년");
					error[4].append(fail_message);
				}
			} else {
				console.log("윤년아님");
				if(day.val() > 28){
					error[4].append(fail_message);
				}
			}
		} else if(set30.has(day.val())) {
			console.log("30일");
			if(day > 30) {
				error[4].append(fail_message);
			} 
		} else {
			console.log("31일");
			console.log(month_val);
			console.log(day.val());
			if(day.val() > 31) {
				error[4].append(fail_message);
			}
		}
	}
	
	function checkPhone() {
		var phonePattern = /^\d{3}-\d{3,5}-\d{4}$/;
		
		var null_message = "전화번호를 입력해주세요.";
		var fail_message = "형식에 맞게 전화번호를 입력하세요.(010-0000-0000)";
		if(phone.val() == "") {
			error[5].append(null_message);
		} else if(!phonePattern.test(phone.val())) {
			error[5].append(fail_message);
		}
	}
	
	function checkEmail() {
		var emailPattern = /[a-zA-Z0-9!@#$%^&*()_+-=]@[a-z0-9].[a-z]{2,3}/;
		var null_message = "이메일을 입력해주세요.";
		var fail_message = "형식에 맞게 이메일을 입력하세요.(join@example.com)";
		if(email.val() == "") {
			error[6].append(null_message);
		} else if(!emailPattern.test(email.val())) {
			error[6].append(fail_message);
		}
	}
	
	$("#mem_id").on("focusout", function(e){
		checkMemberId();
	})
	
	$("#mem_id").on("focusin", function(e){
		console.log("focus in");
		id.parent("span").next().empty();
	})
	
	$("#mem_pwd").on("focusout", function(e){
		checkMemberPwd();
	})
	
	$("#mem_pwd").on("focusin", function(e){
		pwd.parent("span").next().empty();
	})
	
	$("#mem_pwd_check").on("focusout", function(e) {
		checkPwdSame();
	})
	
	$("#mem_pwd_check").on("focusin", function(e){
		checkpwd.parent("span").next().empty();
	})
	
	$("#mem_name").on("focusout", function(e) {
		checkName();
	})
	
	$("#mem_name").on("focusin", function(e) {
		name.parent("span").next().empty();
	})
	
	$("#mem_birth").on("focusout", function(e) {
		checkYear();
	})
	
	$("#mem_birth").on("focusin", function(e) {
		$(".birth_wrap").next().empty();
	})
	
	$("#mem_month").on("focusout", function(e) {
		checkMonth();
	})
	
	$("#mem_month").on("focusin", function(e) {
		$(".birth_wrap").next().empty();
	})
	
	$("#mem_day").on("focusout", function(e) {
		checkDay();
	})
	
	$("#mem_day").on("focusin", function(e) {
		$(".birth_wrap").next().empty();
	})
	
	$("#mem_phone").on("focusout", function(e) {
		checkPhone();
	})
	
	$("#mem_phone").on("focusin", function(e) {
		phone.parent("span").next().empty();
	})
	
	$("#mem_email").on("focusout", function(e) {
		checkEmail();
	})
	
	$("#mem_email").on("focusin", function(e) {
		email.parent("span").next().empty();
	})
	
})

