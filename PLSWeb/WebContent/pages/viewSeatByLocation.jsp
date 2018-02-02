<%@ include file="taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/navbar.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/seatView.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.elevateZoom-3.0.8.min.js"></script>
<title>View Seat plan</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
 
 	<div class="content">
		<h2>UP Seat Plan</h2> 
		<div class="floorMenu">
			<form>
				<span class="label">Select Floor: </span>
				<select name="floorNo" class="dropDown" id="floorNo">
					<option value="4floor">4th Floor</option>
					<option value="3floor">3rd Floor</option>
					<option value="2floor">2nd Floor</option>
				</select>
				<select name="quadrant" class="dropDown" id="quadrant">	
					<option value="w" selected="selected" >Whole Floor</option>
					<option value="A" >Quadrant A</option>
					<option value="B" >Quadrant B</option>
					<option value="C" >Quadrant C</option>
					<option value="D" >Quadrant D</option>
				</select>
				<input type="button" class="btnGo" id="submitFloor" value="Go"/>

			</form>
		</div>
		
		<div id="seatPlan">
			<img />
		</div>
	</div>
 
 	<jsp:include page="footer.jsp"/>
 	
 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/floorView.js"></script>
</body>
</html>