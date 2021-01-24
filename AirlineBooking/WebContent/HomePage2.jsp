<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.travelbyair.pojoclasses.User" %>
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
		<li><a href="LoginPage.jsp">Sign in Admin</a></li>
		<li><a href="Registration.jsp">Sign Up</a></li>
		<li><a href="">Contact Us</a></li>
	</ul>
</div>

<%} %>




<div class="alphared whitetext">
	
	<div class="subheader">
		<b>Book International flight tickets</b>
	</div>
	<br>
	<%=miss%>
	<form action="SearchFlightsServlet2" method="post">
	<table style="font-size:150%;" cellspacing=20px align="center">
		<tr>
			<td><a href="HomePage1.jsp"><input class="button1" type="button" name="Dflights" value="Domestic Flights"/></a></td>
			<td><a href="HomePage2.jsp"><input class="button1" type="button" name="Iflights" value="International Flights"/></a></td>
		</tr>
		
		<tr>
			<td>From <br>
			<select name="from" style="border-radius:50px;padding:7px;"> 
				<option value ="Kolkata">Kolkata</option> 
				<option value ="Dhaka">Dhaka</option> 
				<option value ="London">London</option> 
				<option value ="Newyork">Newyork</option> 
			</select>
			<td>To <br>
			<select name="to" style="border-radius:50px;padding: 7px;"> 
				<option value ="Kolkata">Kolkata</option> 
				<option value ="Dhaka">Dhaka</option> 
				<option value ="London">London</option> 
				<option value ="Newyork">Newyork</option> 
			</select>
		</tr>
		<tr>
			<td><label for="departure">Departure </label> <br>
			<input type="date" id="departure" name="departure" placeholder="dd-mm-yyyy"/></td>
			
	
			<td>Class <br>
			<select name="class" style="border-radius:50px;padding:7px;"> 
				<option value ="Economy">Economy</option> 
				<option value ="Business">Business</option>
				<option value ="FirstClass">First Class</option> 
			</select> </td>
		</tr>
		<tr>
			<td><label for="Adult">Adult </label> <br>
			<input type="number" id="adult" name="adult" placeholder="Number of Adults"/></td>
			<td><label for="child">Child </label><br>
			<input type="number" id="child" name="child" placeholder="Number of Childs"/></td>
			<td><label for="srcitizen">Senior Citizen </label><br>
			<input type="number" id="srcitizen" name="srcitizen" placeholder="Number of Sr Citizen"/></td>
		</tr>
		<tr>
			<td><input class="button1" type="submit" name="Submit" value="Search Flights"/></td>
		</tr>
	</table>
	</form>
</div>


<form action="Search" method="post">	
			<div class="alphared"  style="font-size: 200%">
			<font class="whitetext" align="center">
						List of Available Flights
			</font>
			</div>
			<table margin=50px class="whitetext">
					
				
					<%
			
					ArrayList<FlightInfo> flightlist = (ArrayList<FlightInfo>) request.getAttribute("flightlist");
					if(flightlist!=null && flightlist.size()>0){
						Iterator<FlightInfo> iter = flightlist.iterator();
						while(iter.hasNext()){
								/* session.removeAttribute("PDFBOOK"); */
								
								FlightInfo flight = iter.next();
								//byte[] image = books.getImage();
								 //session.setAttribute("key", image);
								/* session.removeAttribute("key"); */
								
					%>		
						<thead>
					<tr >
							<th><h3></h3></th>
							<th><h3>Flight ID</h3></th>
							<th><h3>Source</h3></th>
							<th><h3>Destination</h3></th>
							<th><h3>Service Provider</h3></th>
							<th><h3>Cost</h3></th>
							<th><h3>Seat</h3></th>
							<th><h3>Journey</h3></th>
							<th><h3>Departure time</h3></th>
					</tr>
								
						<tr>	
							<td width="10%" align="center" ><input type="radio" id="<%=flight.getFlightid() %>" name="flight" value="<%=flight.getFlightid() %>"/> </td>
							<td width="10%" align="center" > <%=flight.getFlightid() %></td>
							<td width="10%" align="center"><%=flight.getSource() %></td>
							<td width="10%" align="center"><%=flight.getDestination() %></td>
							<td width="10%" align="center"><%=flight.getService_provider() %></td>
							<td width="10%" align="center"><%=flight.getTicket_cost() %></td>
							<td width="10%" align="center"><%=flight.getSeat() %></td>
							<td width="10%" align="center"><%=flight.getDeparture_date() %></td>
							<td width="10%" align="center"><%=flight.getArrival_time() %></td> 
								
							
						</tr>
					
					<%	}%>

						<tr align="right">
	
			<td width="10%" align="center"><input class="button1" type="submit" name="Submit" value="Book Flight"/></td>
		</tr>
		
		
						
					<%}
					else{	
					
					%>
					
						<tr align="center"> <td align="center" colspan="4"><font style="font-size: large;a"> <b> No flights found</b></font></td> </tr>
				
					<%
					}
					%>
				</thead>
			
			</table>
</form>	








</body>
</html>