package com.travelbyair.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.travelbyair.pojoclasses.FlightInfo;

/**
 * Servlet implementation class SearchFlightsServlet
 */
@WebServlet("/MasterListDomesticServlet")
public class MasterListDomesticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	PreparedStatement pt=null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			Class.forName(config.getServletContext().getInitParameter("driverpath"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url=config.getServletContext().getInitParameter("dburl");
		String dbuserid=config.getServletContext().getInitParameter("dbid");
		String dbuserpassword=config.getServletContext().getInitParameter("dbpass");
    	try {
			con=DriverManager.getConnection(url, dbuserid, dbuserpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String searchsql="select * from domestic_airline;";
    	try {
			pt=con.prepareStatement(searchsql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		try {
			pt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			response.setContentType("text/html");
			
			ResultSet rs=pt.executeQuery();
			PrintWriter out = response.getWriter();
			out.println("<html><body><table border = '1'><tr><td>FlightNo</td><td>Seat</td><td>Cost</td><td>Source</td><td>Destination</td><td>ServiceProvider</td><td>JourneyDate</td><td>DepartureTime</td><td>ArrivalTime</td></tr>");
			
			while(rs.next())
			{
				out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getInt(9)+"</td><td>"+ rs.getDouble(3) + "</td><td>"+ rs.getString(4) + "</td><td>"+ rs.getString(5) + "</td><td>"+ rs.getString(2)+"</td><td>"+ rs.getString(6) + "</td><td>" + rs.getString(7) + "</td><td>" + rs.getString(8) + "</td></tr>" );				
																	
			}
			out.println("</table></body></html>");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

	
		
	


