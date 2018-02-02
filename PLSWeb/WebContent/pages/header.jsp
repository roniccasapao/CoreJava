<%@ include file="taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is the Header</title>
</head>
<body>
	<div id="header">
		
		<div class="floatRight" >
			<div id="userPanel" >
				<ul> 
					<li>
						<a>
							${ sessionScope.user.firstName } 
							${ sessionScope.user.lastName } 
							[${ sessionScope.user.role }]
						</a>
						<ul>
							<li><a href="${pageContext.request.contextPath}/Logout">Logout</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
		
		<div>
			<a href="${pageContext.request.contextPath}/Home">
				<img id="logo" src="${pageContext.request.contextPath}/img/Official_Pointwest_Logo_Pantone (299, 151).png" />
			</a>
		</div>
		<div class="floatLeft">
			<h4>People Locator System</h4>
		</div>
		<div class="floatRight" id="dateToday">
			<h4>Today is ${ sessionScope.date }</h4>
		</div>
		<div class="clear"></div>

		<!--  NAV  -->
		<div class="nav">
			<ul>
				<li><a href="${pageContext.request.contextPath}/Home">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/Search">Search Employee</a></li>
				<li><a>View Seatplan</a>
					<ul>
						<li><a>View by Location</a>
							<ul>
								<li><a href="${pageContext.request.contextPath}/ViewSeatByLocation">UP</a></li>
								<li><a>Makati</a></li>
							</ul>
						</li>
						<li><a href="${pageContext.request.contextPath}/ViewSeatBySeatId">View by Employee</a></li> 
					</ul>
				</li>
				<c:if test="${sessionScope.user.role eq 'Admin'}">
					<li><a href="${pageContext.request.contextPath}/Manage">Manage
							Seat</a></li>
				</c:if>
			</ul>
			<div class="clear"></div>
		</div>
	</div>
	<!-- NAV ENDS -->

</body>
</html>