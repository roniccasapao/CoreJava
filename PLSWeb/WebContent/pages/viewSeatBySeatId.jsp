<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/navbar.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/seatView.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.elevateZoom-3.0.8.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/searchEmployee.js"></script>
<title>View Seat</title>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<div class="content">
		<div class="searchByIdContainer">
			<span class="label">Input SeatID: </span>
			<input id="searchIDBox" name="searchIDBox" type="text" class="searchBox" autofocus>
			<button type="button" id="btnSearchID" class="btnSearch">Search</button>
		</div>
	 
		<div id="result">
			<div id="tableResult" class="floatLeft">	
			</div>
			<div id="seatPlanById" class="floatRight">
				<img />
			</div>	
			<div class="clear"></div>	
		</div>
		
	</div>	
			
	
	<jsp:include page="footer.jsp"/>
 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/floorView.js"></script>
</body>
</html>