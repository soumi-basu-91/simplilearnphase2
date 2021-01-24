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
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	Connection con=null;
	PreparedStatement pt=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	//super.init(config);
    	
    	// frist step to load the driver
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
    	String searchsql="select * from domestic_airline where source=? and destination=? and joourney_date=?;";
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
    	//	Destroy the object... 
    	super.destroy();
    	try {
			pt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String flight=request.getParameter("flight");
		System.out.println("Flight Booked ::" + flight);
		
		HttpSession sess=request.getSession();
		sess.setAttribute("id", flight);
		RequestDispatcher rd= request.getRequestDispatcher("/Travelinfo.jsp");
		rd.forward(request, response);
		
	}

}
