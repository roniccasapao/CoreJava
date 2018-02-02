$(function() {
	$( "#dialog" ).dialog({
   	 	autoOpen: false
	});
	
	$('button[type="button"]').attr('disabled', true);
	$('input[type="text"]').on('keyup',function() {
	    var searchBox = $('input[name="searchBox"]').val();
	    if(searchBox != '') {
	        $('button[type="button"]').attr('disabled' , false);
	    }else{
	        $('button[type="button"]').attr('disabled' , true);
	    }
	});	
	
	$("#btnSeatId").click(function(e) {
		manageAjax();
		$( "#dialog" ).dialog( "close" );
	});
	
//SEARCH TOM MANAGE	
	$("#btnSearchManage").click(function(e) {
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
				console.log("yay");
				if (jsonText.length > 0) {
					var results = "<div class='floatLeft tablesorter'>Search Result(s): " + jsonText.length + "</div>" +
									"<div class='clear'></div><hr>" +
									"<table id='resultTable'>" + 
									"<tr><th>#</th>" +
									"<th>Assign/Move</th>" +
									"<th>Remove</th>" +
									"<th>EmployeeID</th>" +
									"<th>Name</th>" +
									"<th>Seat Code</th></tr>";
					for (var i = 0; i < jsonText.length; i++) {
						results += "<tr class='dataRow'>";
						results += "<td><b>" + (i + 1)	+ "</b></td>";
						if(jsonText[i].seatId == null || jsonText[i].seatId == "None"){
							results += "<td><input type='button' class='btnManage add' value='Add'/></td>";
							results += "<td></td>";
						} else {
							results += "<td><input type='hidden' id='employeeId'/>";
							results += "<input type='hidden' id='action'/>";
							results += "<input type='button' class='btnManage move' value='Move'/></td>";
							results += "<td><input type='button' class='btnManage remove' value='Remove'/></td>";
						}
						
						results += "<td class='employeeId'>" + jsonText[i].employeeId + "</td>";
						results += "<td>" + jsonText[i].firstName + " " + jsonText[i].lastName + "</td>";
						results += "<td class='seatId'>" + jsonText[i].seatId + "</td>";						
						results += "</tr>";
					}					
				} else {
					results = 'No Match Found!';
				}
				results += "</table>";
				$("#searchResult").html(results);
				
				clickAction();
				
			},
			error : function(data) {
				console.log("Error");
			}
		}); //AJAX
	}); // SEARCH BTN
	
	function manageAjax(){
		console.log("manageajax");
		$.ajax({
			type : 'POST',
			url : 'Manage',
			data : {
				employeeId: $("#employeeId").val(),
				seatId: $("#seatId").val(),
				action: $("#action").val(),
				searchBox : $("#searchBox").val(),
				searchOption : $("#searchOption").val()
			},
			
			success : function(data) {
				var jsonText = JSON.parse(data);
				$("#searchResult").empty();
				console.log("yay");
				if (jsonText.length > 0) {
					var results = "<div class='floatLeft tablesorter'>Search Result(s): " + jsonText.length + "</div>" +
									"<div class='clear'></div><hr>" +
									"<table id='resultTable'>" + 
									"<tr><th>#</th>" +
									"<th>Assign/Move</th>" +
									"<th>Remove</th>" +
									"<th>EmployeeID</th>" +
									"<th>Name</th>" +
									"<th>Seat Code</th></tr>";
					for (var i = 0; i < jsonText.length; i++) {
						results += "<tr class='dataRow'>";
						results += "<td><b>" + (i + 1)	+ "</b></td>";
						if(jsonText[i].seatId == null || jsonText[i].seatId == "None"){
							results += "<td><input type='button' class='btnManage add' value='Add'/></td>";
							results += "<td></td>";
						} else {
							results += "<td><input type='hidden' id='employeeId'/>";
							results += "<input type='hidden' id='action'/>";
							results += "<input type='button' class='btnManage move' value='Move'/></td>";
							results += "<td><input type='button' class='btnManage remove' value='Remove'/></td>";
						}
						
						results += "<td class='employeeId'>" + jsonText[i].employeeId + "</td>";
						results += "<td>" + jsonText[i].firstName + " " + jsonText[i].lastName + "</td>";
						results += "<td class='seatId'>" + jsonText[i].seatId + "</td>";						
						results += "</tr>";
					}					
				} else {
					results = 'No Match Found!';
				}
				results += "</table>";
				$("#searchResult").html(results);
				
				clickAction();
				
			},
			error : function(data) {
				console.log("Error");
			}
		});
	}
	
	function clickAction(){
		$(".add").click(function(e) {
			e.preventDefault();
			$("#employeeId").val($(this).closest(".dataRow").find(".employeeId").text());
			$("#action").val("add");
			$( "#dialog" ).dialog( "open" );
		});
		$(".move").click(function(e) {
			e.preventDefault();
			$("#employeeId").val($(this).closest(".dataRow").find(".employeeId").text());
			$("#action").val("move");
			$( "#dialog" ).dialog( "open" );
		});				
		$(".remove").click(function(e) {
			e.preventDefault();
			$("#employeeId").val($(this).closest(".dataRow").find(".employeeId").text());
			$("#action").val("remove");
			manageAjax();
		});
	}	
});