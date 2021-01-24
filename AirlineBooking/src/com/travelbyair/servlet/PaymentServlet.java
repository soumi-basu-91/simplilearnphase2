package com.travelbyair.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	Connection con=null;
	PreparedStatement pt=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
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
    	
    	
    }
    
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	super.destroy();
    	try {
			con.close();
			pt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher	rd = request.getRequestDispatcher("Payment.jsp");
		String selectquery="";
		String debit = request.getParameter("debit");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String cvv = request.getParameter("cvv");
		String message="";
		String source="";
		String destination="";
		String service="";
		String dep_time="";
		float cost=(float) 0.0;
		HttpSession session = request.getSession();
		
		String flightID=(String)session.getAttribute("id");
		int flightint=Integer.parseInt(flightID);
		int members=(Integer)session.getAttribute("member");
		
		System.out.println(" gettiing my choice from session "+flightID);
		System.out.println(" gettiing my choice from session "+members);
		//System.out.println(" flight int "+flightint);
		
		if( (flightint ==1509) || (flightint ==4682) || (flightint ==4688) || (flightint ==4699) || (flightint ==7656) || (flightint ==9812)){

		selectquery="select * from domestic_airline where flightid=?;";
	    try {
			pt=con.prepareStatement(selectquery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	    
		else if((flightint ==1235) || (flightint ==4568) || (flightint ==4780)){
			selectquery="select * from international_airline where flightid=?;";
	    	try {
	    		System.out.println("international");
				pt=con.prepareStatement(selectquery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(debit!="" && month!="" && year!="" && cvv!="" ){
			
			
			try {
				pt.setInt(1,flightint);
				ResultSet set=pt.executeQuery();
				if(set.next()){
					cost = set.getFloat(3);
					cost=cost*members;
					source=set.getString(4);
					destination=set.getString(5);
					service=set.getString(2);
					dep_time=set.getString(7);
					request.setAttribute("seat",members);
					request.setAttribute("cost",cost);
					request.setAttribute("source",source);
					request.setAttribute("destination",destination);
					request.setAttribute("service",service);
					request.setAttribute("dep_time",dep_time);
					rd = request.getRequestDispatcher("/ThankYou.jsp");
					System.out.println(" "+debit+" "+month+" "+year);
					rd.forward(request, response);}
				
				else{
					System.out.println("NO id found");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		else{
			message="PLEASE FILL THE FORM COMPLETELY";
			request.setAttribute("Key",message);
			rd.forward(request, response);
		}
		
	}

}
