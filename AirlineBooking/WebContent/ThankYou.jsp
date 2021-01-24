<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.travelbyair.pojoclasses.User" %>
<%@page import="com.travelbyair.pojoclasses.FlightInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet" type="text/css" href="AirlineStyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thank You</title>
</head>
<body>
<%! float cost=(float) 0.0; %>
<% cost=(Float)request.getAttribute("cost");%>
<%if(cost==0.0){
		cost=(float)0.0;
	}%>
	
	<%!String source="";%>
	<%!int seats=0;%>
	<%!String destination="";%>
	<%!String service="";%>
	<%!String dep_time=""; %>
	
	<%
	seats=(Integer)request.getAttribute("seat");
	source=(String)request.getAttribute("source");
	destination=(String)request.getAttribute("destination");
	service=(String)request.getAttribute("service");
	dep_time=(String)request.getAttribute("dep_time");
	
	%>
	
<%!User userloggedin; %>
<% userloggedin= (User)session.getAttribute("userlogin");%>


<div class="subheader">
		<b>FlyAway (An Airline Booking Portal)</b>
</div>

<%if(userloggedin!=null){
	
%>


<div style="display:inline;" id="navigation">
	<ul>
		<li><a href="HomePage1.jsp">Home</a></li>
		<li><a href="UserInfo.jsp"><%=userloggedin.getUserid() %></a></li>
		<li><a href="LogOutServlet">Log out</a></li>
		<li><a href="Footer.html">Contact Us</a></li>
	</ul>
</div>
<%}else{
	

%>

<div style="display:inline;" id="navigation">
	<ul>
		<li><a href="HomePage1.jsp">Home</a></li>
		<li><a href="LoginPage.jsp">Sign in</a></li>
		<li><a href="Registration.jsp">Sign Up</a></li>
		<li><a href="Footer.html">Contact Us</a></li>
	</ul>
</div>

<%} %>

<div class="whitetext" align="center" style="Font-size: 180%;background:rgba(255, 87, 51,0.3); padding: 15px; border-radius:10px; margin-top: 100px; margin-left: 50px;">
	Thank you for choosing us.. 
</div>

<div class="whitetext" align="center" style="Font-size: 130%;background:rgba(255, 87, 51,0.3); padding: 15px; border-radius:10px; margin-top: 100px; margin-left: 50px;">
	Your E-ticket is..
</div>

<table  class="whitetext">
					
					<tr >
							<th><h3>Source</h3></th>
							<th><h3>Destination</h3></th>
							<th><h3>Service Provider</h3></th>
							<th><h3>Seats Booked</h3></th>
							<th><h3>Total Cost</h3></th>
							<th><h3>Departure Time</h3></th>
							
					</tr>
								
						<tr>	
							<td width="10%" align="center"><%=source %></td>
							<td width="10%" align="center"><%=destination %></td>
							<td width="10%" align="center"><%=service %></td>
							<td width="10%" align="center"><%=seats %></td>
							<td width="10%" align="center"><%=cost %></td>
							<td width="10%" align="center"><%=dep_time %></td>
								
						</tr>			
			</table>

</body>
</html>