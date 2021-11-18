
function getSchedule() {
	var group_no = document.getElementById('group_no').value;
	var returnList;
	$.ajax({
		url: '/group/getSchedule',
		data: {
			group_no : group_no,
		},
		async: false,
		dataType: 'json',
		success: function(result){
			returnList = result;
			console.log(returnList);
		}
	})
	return returnList;
}

function addEvent(){
	 var schedule = getSchedule();
	  var schList = [];
	  for(var i=0; i<schedule.length; i++){
		  if(schedule[i].finish_date == "donthave"){
			  var data = {
					  id : schedule[i].climb_no,
					  title: schedule[i].climb_title,
					  start: schedule[i].start_date
			  }
			  schList.push(data);
		  } else {
			  var data = {
					  id : schedule[i].climb_no,
					  title: schedule[i].climb_title,
					  start: schedule[i].start_date,
					  end: schedule[i].finish_date
			  }
			  schList.push(data);
		  }
	  }
	  console.log(schList);
	  return schList;
}

window.addEventListener('load', function() {
        var calendarEl = document.getElementById('calendar');
        var result = getSchedule();
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth',
          selectable: false, // 날짜 드래그 앤 드랍 불가능 
          events: addEvent()
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