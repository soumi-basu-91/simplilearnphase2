<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.travelbyair.pojoclasses.User" %>
<%@page import="com.travelbyair.pojoclasses.FlightInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
 <link rel = "stylesheet" type="text/css" href="AirlineStyle.css">
<meta charset="ISO-8859-1">
<title>Passenger Information</title>
</head>
<body>
<%!int seats=0;%>
<%!String message=""; %>
<%message=(String)request.getAttribute("Key");
seats=(Integer)request.getAttribute("seat");
%>
<%if(message==null){
message="";
}	%>
<%!int i=1; %>
<%!int j=1; %>
<%!User userloggedin; %>
<% userloggedin= (User)session.getAttribute("userlogin");%>

<div class="subheader">
		<b>FlyAway (An Airline Booking Portal)</b>
</div>


<%if(userloggedin!=null){
	i=5;
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
<div class="alphared whitetext">
<%=message %>
	<form action="PassengerInfoServlet" method="post">
	<table cellspacing=30px>
		
		<%
		j=1;
		while(j<=seats){
			%>
		
		<tr>
			<td>Adult <%=j %></td>
		</tr>
		<tr>
			<td><label for="username">First Name </label> <br>
			<input type="text" id="firstname" name="firstname"/></td>
			<td><label for="lastname">Last Name </label> <br>
			<input type="text" id="lastname" name="lastname"/></td>
			<td><label for="contact">Contact Number </label> <br>
			<input type="text" id="contact" name="contact"/></td>
			<td><label for="email">E-mail </label> <br>
			<input type="text" id="email" name="email"/></td>
		</tr>
		
		<% 
		j++;
		} %>
		
		<tr align="right">
			<td><input style="color:rgba(255, 87, 51,1); background-color: white;padding: 10px;font-size:200%;border-radius:20px;" type="submit" name="login" value="Submit" /></td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>