<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.travelbyair.pojoclasses.User" %>
<%@page import="com.travelbyair.pojoclasses.FlightInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel = "stylesheet" type="text/css" href="AirlineStyle.css">
<meta charset="ISO-8859-1">
<title>Email Confirmation</title>
</head>
<body>
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
	<form action="LoginServlet2" method="POST">
	<table style="font-size:150%;" cellspacing=20px align="center">
		<tr>
			<td><label for="coninfo">Contact Information </label> <br>
			<input type="text" id="coninfo" name="coninfo" placeholder="enter e-mail address"/></td>
		</tr>
		<tr>
			<td><a href="Registration2.jsp"><input class="button1" type="button" name="Guest" value="Cotinue as Guest"/></a></td>
			<td>Or</td>
			<td><a href="LoginPage.jsp"><input class="button1" type="submit" name="login" value="Login"/></a></td>
		</tr>
	</table>
	</form>
</div>


</body>
</html>