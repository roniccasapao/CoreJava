$(function() {
	//viewSeat byLocation
	$("#submitFloor").click(function() {
		var floor = $("#floorNo").val();
		console.log(floor + "floor");
		if(floor == "2floor") {
			setSeatPlanImage(floor);
		}
		else {
			var quadrant = $("#quadrant").val();
			setSeatPlanImage(floor + quadrant);
		}
	});

	
	function setSeatPlanImage(location) {
		console.log("img "+location);
		$("#seatPlan img").attr("id", "zoom_01");
		$("#seatPlan img").attr("src", "img/floor/" + location + ".png");
		$("#seatPlan img").addClass("floorplan");
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
	
});

