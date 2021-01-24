<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.travelbyair.pojoclasses.User" %>
<%@page import="com.travelbyair.pojoclasses.FlightInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel = "stylesheet" type="text/css" href="AirlineStyle.css">
<meta charset="ISO-8859-1">
<title>Payment Gateway</title>
</head>
<body>


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
		<li><a href="">Contact Us</a></li>
	</ul>
</div>

<%} %>
<div class="alphared whitetext">
<form action="PaymentServlet" method="post">
	<span class="whitetext">Adult 1</span>
	<table cellspacing=30px>
		<tr>
			<td><label for="debit">Debit Card Nymber </label> <br>
			<input type="text" id="debit" name="debit" placeholder="xxxx-xxxx-xxxx-xxxx"/></td>
		</tr>
		<tr>
			<td>Month <br>
			<select name="month" style="border-radius:50px;padding:7px;"> 
				<option value ="1">1</option> 
				<option value ="2">2</option> 
				<option value ="3">3</option> 
				<option value ="4">4</option> 
				<option value ="5">5</option> 
				<option value ="6">6</option> 
				<option value ="7">7</option> 
				<option value ="8">8</option>
				<option value ="9">9</option> 
				<option value ="10">10</option> 
				<option value ="11">11</option> 
				<option value ="12">12</option>  
			</select>
			</td>
			<td>Year <br>
			<select name="year" style="border-radius:50px;padding:7px;"> 
				<option value ="2017">2017</option> 
				<option value ="2018">2018</option> 
				<option value ="2019">2019</option> 
				<option value ="2020">2020</option> 
				<option value ="2021">2021</option> 
				<option value ="2022">2022</option> 
				<option value ="2023">2023</option> 
				<option value ="2024">2024</option>
				<option value ="2025">2025</option> 
				<option value ="2026">2026</option> 
				<option value ="2027">2028</option> 
				<option value ="2028">2029</option>  
			</select>
			</td>
			<td><label for="cvv">CVV </label> <br>
			<input type="text" id="cvv" name="cvv" placeholder="xxx"/></td>
		</tr>
		<tr align="right">
			<td><input style="color:rgba(255, 87, 51,1); background-color: white;padding: 10px;font-size:200%;border-radius:20px;" type="submit" name="login" value="Confirm Booking" /></td>
		</tr>
	</table>
	
</form>	
</div>
</body>
</html>