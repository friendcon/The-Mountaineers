window.onload = function(){
	var authBtn = document.getElementById("climbauth");
	var mountainCode = document.getElementById("mountain_code").value;
	console.log(authBtn);
	authBtn.addEventListener("click", function() {
		location.href="/mountain/auth?mountain_code=" + mountainCode;
	});
}