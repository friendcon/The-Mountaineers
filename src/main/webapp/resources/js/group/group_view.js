var events = [];

function getSchedule() {
	var group_no = document.getElementById('group_no').value;
	var returnList;
	$.ajax({
		url: '/group/getSchedule',
		data: {
			"group_no" : group_no
		},
		async: false,
		dataType: 'json',
		success: function(result){
			returnList = result;
			console.log(returnList);
			console.log("성공");
		}, error : function(xhr, status, error) {
	        console.log(status, error);
	        console.log("실패");
	    }
	})
	return returnList;
}

function addEvent() {
		console.log("호출!!!!!!!!!");
		var schedule = getSchedule();
		/*var date = "now";
		
		if(str == null) {
			console.log("시발2");
			schedule = getSchedule(date);
		} else {
			console.log("존나2");
			date = getCurrentPageDate(str);
			schedule = getSchedule(date);
		}*/

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

/*function getCurrentPageDate(calendar) {
	console.log(calendar);
	var date = calendar.getDate() + "";
	console.log(date);
	var arr = date.split(" ");
	//console.log(dateResult);
	var year = arr[3];
	var month = 0;
	switch(arr[1]) {
		case 'Jan':
			month = "01";
			break;
		case 'Feb':
			month = '02';
			break;
		case 'Mar':
			month = '03';
			break;
		case 'Apr':
			month = '04';
			break;
		case 'May':
			month = '05';
			break;
		case 'Jun':
			month = '06';
			break;
		case 'Jul':
			month = '07';
			break;
		case 'Aug':
			month = '08';
			break;
		case 'Sep':
			month = '09';
			break;
		case 'Oct':
			month = '10';
			break;
		case 'Nov':
			month = '11';
			break;
		case 'Dec':
			month = '12';
			break;
	}
	var currentPageDate = year + "-" + month;
	console.log(currentPageDate);
	return currentPageDate;
}*/

function calendarRender() {
	var calendarEl = document.getElementById('calendar');
	var currentDate = "";
	var returnVal = [];
	var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        headerToolbar: {
        	left: 'prevCustom',
        	center: 'title',
        	right: 'nextCustom'
        },
        titleFormat: {
        	month: '2-digit',
        	year: 'numeric'
        },
        customButtons: {
        	prevCustom: {
        		text: '<',
        		click: function() {
        			calendar.prev();
        		}
        	},
        	nextCustom: {
        		text: '>',
        		click: function() {
        			calendar.next();
        		}
        	}
        },
        selectable: false, // 날짜 드래그 앤 드랍 불가능 
        events: addEvent(calendar)

    });
	console.log("하ㅣ히");
	calendar.render();
}

window.addEventListener('load', function() {        
        calendarRender();
});




$(document).ready(function(e){
	var obj = $("button.fc-next-button");

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