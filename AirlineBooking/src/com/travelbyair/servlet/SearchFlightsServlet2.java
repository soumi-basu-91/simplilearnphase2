package com.travelbyair.servlet;

import java.io.IOException;
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
@WebServlet("/SearchFlightsServlet2")
public class SearchFlightsServlet2 extends HttpServlet {
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
		/*String url="jdbc:mysql://localhost:3306/airlinedatabases";
    	String dbuserid="root";
    	String dbuserpassword="61825";*/
    	try {
			con=DriverManager.getConnection(url, dbuserid, dbuserpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String searchsql="Select * from international_airline where source=? and destination=? and journey_date=?;";
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd= request.getRequestDispatcher("/HomePage2.jsp");
		String from= request.getParameter("from");
		String to= request.getParameter("to");
		String departure= request.getParameter("departure");
		String clas= request.getParameter("class");
		String adult= request.getParameter("adult");
		String child= request.getParameter("child");
		String srcitizen= request.getParameter("srcitizen");
		String miss="";
		
		
		int members=0,adu=0,chi=0,sr=0;
		if(adult!="")
			adu=Integer.parseInt(adult);
		if(child!="")
			chi=Integer.parseInt(child);
		if(srcitizen!="")
			sr=Integer.parseInt(srcitizen);
			
		if(adult!="")
		{
			members=adu;
			if(child!="" && srcitizen!=""){
				members=adu+chi+sr;
			}
			else if(child!=""){
				members=adu+chi;
			}
			else if(srcitizen!=""){
				members=adu+sr;
			}
			
			
		}
		
		
		System.out.println("total members"+members);
		
		HttpSession sess=request.getSession();
		sess.setAttribute("member", members);
		
		//System.out.println(trip);
		//System.out.println(departure+" " +return1);
		

			if(from!="" && to!="" && clas!="" && departure!="" && clas!="" && adult!=""){
				if(from.equalsIgnoreCase(to)){
					miss="source and destination can't be the same..";
					request.setAttribute("user", miss);
					rd.forward(request, response);
					return ;
				}
			
				else{
				
						
						//System.out.println("in try.....");
						
						try {
							pt.setString(1,from);
							pt.setString(2,to);
							pt.setString(3,departure);
							ResultSet rs=pt.executeQuery();
							
							if(rs.next()){
							ArrayList<FlightInfo> flightlist=new ArrayList<FlightInfo>(); 
							//while(rs.next()){
							int flightid=rs.getInt(1);
							String source=rs.getString(4);
							String destination=rs.getString(5);
							String service_provider=rs.getString(2);
							double cost=rs.getDouble(3);
							int seat=rs.getInt(9);
							String journey_date=rs.getString(6);
							String departure_time=rs.getString(7);
							String arrival_time=rs.getString(8);
							
							FlightInfo flight= new FlightInfo(flightid,seat,(float) cost,source,destination,service_provider,journey_date,departure_time,arrival_time);
//							FlightInfo flight= new FlightInfo();
							flightlist.add(flight);			
							
							request.setAttribute("flightlist",flightlist);
							rd.forward(request, response);
							return;								
							}

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						
						
						
						/*rd2= request.getRequestDispatcher("/Search");
						request.setAttribute("from", from);
						request.setAttribute("to", to);
						request.setAttribute("departure", departure);
						rd2.forward(request, response);
						return; */
				}		
			}
			else{
				if(from==""){
					miss="Enter Source";
				}
					else if(to==""){
						miss="Enter Destination";
					}
				
					else if(from!="" && to!="" && from.equalsIgnoreCase(to)){
					miss="Source and destination can't be the same";
				}
				
					else if(departure==""){
						miss="Enter Departure";
					}
					
				
					else if(clas==""){
						miss="Enter class";
					}
				
					else if(adult==""){
						miss="Enter number of Adults";
					}
				
				request.setAttribute("user", miss);
				rd.forward(request, response);
				return ;
			  }
		
	
		
	
		/*request.setAttribute("user", miss);
		rd.forward(request, response);
		return ;*/
		}
		
	}


