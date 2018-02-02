$(function() { 
	$('button[type="button"]').attr('disabled', true);
	$('input[type="text"]').on('keyup',function() {
	    var searchBox = $('input[name="searchBox"]').val();
	    if(searchBox != '') {
	        $('button[type="button"]').attr('disabled' , false);
	    }else{
	        $('button[type="button"]').attr('disabled' , true);
	    }
	});

	//SEARCH EMPLOYEE
	$("#btnSearch").click(function(e) {
		$.ajax({
			type : 'POST',
			url : 'Search',
			data : {
				searchBox : $("#searchBox").val(),
				searchOption : $("#searchOption").val()
			},
		
			success : function(data) {
				var jsonText = JSON.parse(data);
		
				$("#searchResult").empty();
				
				if (jsonText.length > 0) {
					var results = "<div class='floatLeft tablesorter'>Search Result(s): " + jsonText.length + "</div>" +
									"<div class='clear'></div><hr>" +
									"<table id='resultTable'>" + 
									"<tr><th>#</th>" +
									"<th>EmployeeID</th>" +
									"<th>Name</th>" +
									"<th>Seat Code</th></tr>";
					for (var i = 0; i < jsonText.length; i++) {
						results += "<tr>";
						results += "<td>" + (i + 1)	+ "</td>";
						results += "<td>" + jsonText[i].employeeId + "</td>";
						results += "<td>" + jsonText[i].firstName + " " + jsonText[i].lastName + "</td>";
						results += "<td>" + jsonText[i].seatId + "</td>";
						results += "</tr>";
					}
				} else {
					results = 'No Match Found!';
				}
				results += "</table>";
				$("#searchResult").html(results);
			},
			error : function(data) {
				console.log("Error");
			}
		}); //AJAX
	}); // SEARCH BTN

	/*byseatID*/
	$("#btnSearchID").click(function(e) {
		$.ajax({
			type : 'POST',
			url : 'ViewSeatBySeatId',
			data : {
				searchIDBox : $("#searchIDBox").val(),
			},
		
			success : function(data) {
				var jsonText = JSON.parse(data);
		
				$("#tableResult").empty();
				
				if (jsonText.length > 0) {
					var results = "<div class='floatLeft' id='searchResultNo'>Search Result(s): " + jsonText.length + "</div>" +
									"<div class='clear'></div><hr>" +
									"<table id='resultTable'>" + 
									"<tr><th>#</th>" +
									"<th>EmployeeID</th>" +
									"<th>Name</th>" +
									"<th>Seat Code</th></tr>";
					for (var i = 0; i < jsonText.length; i++) {
						results += "<tr>";
						results += "<td>" + (i + 1)	+ "</td>";
						results += "<td>" + jsonText[i].employeeId + "</td>";
						results += "<td>" + jsonText[i].firstName + " " + jsonText[i].lastName + "</td>";
						results += "<td><a href='' class='seatCode'>" + jsonText[i].seatId + "</a></td>";
						results += "</tr>";
					}
				} else {
					results = 'No Match Found!';
				}
				results += "</table>";
				$("#tableResult").html(results);
				
				$(".seatCode").click(function(e) {
					e.preventDefault();
					var seatID = $(this).text(); 
					console.log(seatID);
				    var floorCode = "";

				    if(seatID.match(/PIC/) == "PIC" && seatID.match(/2F/) == "2F"){
				    	floorCode = "2floor";
				    } else if(seatID.match(/PIC/) == "PIC" && seatID.match(/3FA/) == "3FA"){
				    	floorCode = "3floorA";
				    } else if(seatID.match(/PIC/) == "PIC" && seatID.match(/3FB/) == "3FB"){
				    	floorCode = "3floorB";
				    } else if(seatID.match(/PIC/) == "PIC" && seatID.match(/3FC/) == "3FC"){
				    	floorCode = "3floorC";
				    } else if(seatID.match(/PIC/) == "PIC" && seatID.match(/3FD/) == "3FD"){
				    	floorCode = "3floorD";
				    } else if(seatID.match(/PIC/) == "PIC" && seatID.match(/4FA/) == "4FA"){
				    	floorCode = "4floorA";
				    } else if(seatID.match(/PIC/) == "PIC" && seatID.match(/4FB/) == "4FB"){
				    	floorCode = "4floorB";
				    } else if(seatID.match(/PIC/) == "PIC" && seatID.match(/4FC/) == "4FC"){
				    	floorCode = "4floorC";
				    } else if(seatID.match(/PIC/) == "PIC" && seatID.match(/4FD/) == "4FD"){
				    	floorCode = "4floorD";
				    }

				    console.log(floorCode);
				    seatSeatPlanFromId(floorCode);
				    
				});//End of search by ID
			},
			error : function(data) {
				console.log("Error");
			}
		}); //AJAX
	}); // SEARCH BTN
	
	
	
	function seatSeatPlanFromId(location) {
		console.log(location);
		if(location == "Invalid"){
			$("#seatPlan").html("Invalid Seat Code");
		} else {
			console.log("img " +location);
			$("#seatPlanById img").attr("id", "zoom_01");
			$("#seatPlanById img").attr("src", "img/floor/" + location + ".png");
			$("#seatPlanById img").addClass("floorplan");
			$('#zoom_01').elevateZoom({
				responsive: true,
				zoomType	: "lens",
				lensShape : "round", 
				lensSize : 250,
				zoomWindowFadeIn: 500,
				zoomWindowFadeOut: 750,
				scrollZoom : true,
				containLensZoom: true
			}); 
		}
	}
	
});
