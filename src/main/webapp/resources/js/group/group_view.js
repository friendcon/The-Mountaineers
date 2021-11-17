document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth',
          selectable: false, // 날짜 드래그 앤 드랍 불가능 
          events: [
        	  
          ]
        });
        calendar.render();
});

$(document).ready(function(e){
	$(".climb-schedule-button").on("click", function(e){
		var group_no = $("input[name='group_no']").val();
		location.href = '/group/schedulePage?group_no=' + group_no;
	})
	
	$(".climb-schedule-button").on("mouseover", function(e){
		$(this).css("background-color", "#9575CD");
		$(this).css("border-color", "#9575CD");
	})
	
	$(".climb-schedule-button").on("mouseout", function(e){
		console.log("hi");
		$(this).css("background-color", "#7e57c2");
		$(this).css("border-color", "#7e57c2");
	})
})