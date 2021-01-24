<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.travelbyair.pojoclasses.User" %>
<%@page import="com.travelbyair.pojoclasses.FlightInfo" %>
<!DOCTYPE html>
<html>
<head>

<link rel = "stylesheet" type="text/css" href="AirlineStyle.css">
<meta charset="ISO-8859-1">
<title>Registration Page</title>
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
	<form action="RegistrationServlet" method="post" enctype="multipart/form-data">
		* Fields are mandatory <br> <br> <br>
		<%=message%>
		<table cellspacing=30px>
			<tr>
				<td><label for="username">First Name* </label> <br>
				<input type="text" id="firstname" name="firstname" placeholder="Enter First name"/></td>
				<td><label for="lastname">Last Name* </label> <br>
				<input type="text" id="lastname" name="lastname" placeholder="Enter Last name"/></td>
			</tr>
			<tr>
				<td><input type="radio" id="male" name="gender" value="m"/>
				<label for="male">Male </label></td>
				<td><input type="radio" id="female" name="gender"  value="f"/>
				<label for="female">Female</label></td>
			</tr>
			<tr>
				<td><label for="userID">User ID* </label> <br>
				<input type="text" id="userID" name="userID" placeholder="Enter User ID"/></td>
				<td><label for="dob">Date Of Birth* </label> <br>
				<input type="date" id="dob" name="dob"/></td>
			</tr>
			<tr>
				<td><label for="password">Password* </label> <br>
				<input type="password" id="password" name="password" placeholder="Enter Password"/></td>
			</tr>
			<tr>
				<td><label for="contact">Contact Number* </label> <br>
				<input type="tel" id="contact" name="contact" placeholder="Enter mobile number"/></td>
			</tr>
			<tr>
				<td><label for="email">E-mail* </label> <br>
				<input type="text" id="email" name="email" placeholder="Enter E-mail"/></td>
				<td><label for="city">City* </label> <br>
				<input type="text" id="city" name="city" placeholder="Enter City"/></td>
			</tr>
			
			<tr>
				<td>Upload your Image (Optional)</td>
				<td><input type="file" name="image" value="Browse"/></td>
			</tr>
			
			<tr align="right">
				<td><input style="color:rgba(255, 87, 51,1); background-color: white;padding: 10px;font-size:200%;border-radius:20px;" type="submit" name="login" value="Sign Up" /></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>