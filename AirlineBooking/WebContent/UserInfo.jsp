<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.travelbyair.pojoclasses.User" %>
<%@page import="com.travelbyair.pojoclasses.FlightInfo" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.travelbyair.pojoclasses.User" %>
<html>
<head>
 
<link rel = "stylesheet" type="text/css" href="AirlineStyle.css">
<meta charset="ISO-8859-1">
<title>User Information Update</title>
</head>
<body>

<%! String message=""; %>
<% message=(String)request.getAttribute("key");%>
<%if(message==null){
		message="";
	}%>
	
<%!User userloggedin; %>
<% userloggedin= (User)session.getAttribute("userlogin");%>

<div class="subheader">
		<b>FlyAway (An Airline Booking Portal)</b>
</div>


<div style="display:inline;" id="navigation">
	<ul>
		<li><a href="HomePage1.jsp">Home</a></li>
		<li><a href="LoginPage.jsp">Sign in</a></li>
		<li><a href="Registration.jsp">Sign Up</a></li>
		<li><a href="Footer.html">Contact Us</a></li>
	</ul>
</div>


<div class="alphared whitetext">
	<form action="RegistrationServlet" method="post">
		* Fields are mandatory <br> <br> <br>
		<%=message %>
		<table cellspacing=30px>
			<tr>
				<td><label for="username">First Name* </label> <br>
				<input type="text" id="firstname" name="firstname" value="<%=userloggedin.getFname()%>"/></td>
				<td><label for="lastname">Last Name* </label> <br>
				<input type="text" id="lastname" name="lastname" value="<%=userloggedin.getLname()%>"/></td>
			</tr>
			
			<tr>
				<td><label for="dob">Date Of Birth* </label> <br>
				<input type="date" id="dob" name="dob" value="<%=userloggedin.getDob()%>"/></td>
			</tr>
			<tr>
				<td><label for="password">Password* </label> <br>
				<input type="text" id="password" name="password" value="<%=userloggedin.getPassword()%>"/></td>
			</tr>
			<tr>
				<td><label for="contact">Contact Number* </label> <br>
				<input type="tel" id="contact" name="contact" value="<%=userloggedin.getMoblie()%>"/></td>
			</tr>
			<tr>
				<td><label for="email">E-mail* </label> <br>
				<input type="text" id="email" name="email" value="<%=userloggedin.getEmail()%>"/></td>
				<td><label for="city">City* </label> <br>
				<input type="text" id="city" name="city" value="<%=userloggedin.getCity()%>"/></td>
			</tr>
			
			<tr>
				<td>Upload your Image (Optional)</td>
				<td><input type="file"/></td>
			</tr>
			
			<tr align="right">
				<td><input style="color:rgba(255, 87, 51,1); background-color: white;padding: 10px;font-size:200%;border-radius:20px;" type="submit" name="login" value="Update" /></td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>