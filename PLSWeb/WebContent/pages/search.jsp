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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/searchEmployee.js"></script>
<title>Search</title>
</head>
<body>
	<jsp:include page="header.jsp"/>

	<div class="content">
		<div class="searchMain floatLeft">
			<div class="label">Search Employee: </div>
			<input id="searchBox" name="searchBox" type="text" class="searchBox" autofocus>
			<div class="buttonContainer">
	
				<select id="searchOption" name="searchOption">
				  <option value="byId">by Employee ID</option>
				  <option value="byName">by Name</option>
				</select>
				<button type="button" id="btnSearch" class="btnSearch">Search</button>
			</div>
		</div>
	

		<div class="floatLeft" id="resultContainer">
			<div id="searchResult" >
				
			</div>
		</div>

	</div>
			<div class="clear"></div>
		</div>
	<jsp:include page="footer.jsp"/>

</body>
</html>