<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.travelbyair.pojoclasses.Admin" %>
<%@page import="com.travelbyair.pojoclasses.FlightInfo" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Iterator" %>
<html>
<head>
<link rel = "stylesheet" type="text/css" href="AirlineStyle.css">
<meta charset="ISO-8859-1">
<title>Airline Ticket Booking</title>
</head>
<body>

<%! String message="";int m; %>
<% message=(String)request.getAttribute("key");%>
<%if(message==null){
		message="";
	}%>
<%!int i=0; %>

<%! String miss=""; %>
<% miss=(String)request.getAttribute("user");%>
<%if(miss==null){
		miss="";
	}%>

<%!Admin Adminloggedin; %>
<% Adminloggedin= (Admin)session.getAttribute("Adminlogin");%>


<div class="subheader">
		<b>FlyAway (An Airline Booking Portal)</b>
</div>
<%if(Adminloggedin!=null){
	i=5;
%>


<div style="display:inline;" id="navigation">
	<ul>
		<li><a href="HomePage1.jsp">Home</a></li>
		<li><a href="UserInfo.jsp"><%=Adminloggedin.getId() %></a></li>
		<li><a href="LogOutServlet2">Log out ADMIN</a></li>
		<li><a href="Footer.html">Contact Us</a></li>
	</ul>
</div>
<%}else{
	

%>

<div style="display:inline;" id="navigation">
	<ul>
		<li><a href="HomePage1.jsp">Home</a></li>
		<li><a href="LoginPage.jsp">Sign in</a></li>
		<li><a href="LoginPage.jsp">Sign in ADMIN</a></li>
		<li><a href="Registration.jsp">Sign Up</a></li>
		<li><a href="">Contact Us</a></li>
	</ul>
</div>

<%} %>

<div class="alphared whitetext">
<form action="MasterListDomesticServlet" method="post">
<input type = "Submit" value = "Get Master List of Domestic Flights">
</form>

<form action="MasterListInternationalServlet" method="post">
<input type = "Submit" value = "Get Master List of International Flights">
</form>

<form action="CPwdServlet" method="post">
<input type = "Submit" value = "Change User Password">
</form>

<%-- <table >
		<tr>
			<%=message%>
			<td><label for="Enter User ID"> Enter User ID </label> <br>
			<input type="text" id="username" name="userID" placeholder="Enter User ID"/></td>
			<td><label for="Enter New Password">Enter New Password </label> <br>
			<input type="password" id="password" name="password" placeholder="Enter new Password"/></td>
		</tr>
		<tr align="right">
			<td></td>
			<td><input class="button1" type="submit" name="login" value="Change User Password" /></td>
		</tr>
	</table>

</form> --%>


</div>

			
</body>
</html>