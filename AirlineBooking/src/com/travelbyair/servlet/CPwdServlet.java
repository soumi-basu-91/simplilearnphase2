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
@WebServlet("/CPwdServlet")
public class CPwdServlet extends HttpServlet {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String query = "UPDATE user SET user.password = \"test2\" WHERE user.fname = \"Moumi\";";
		try {
			pt=con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	showTable( query, out);
	}

	
	public void showTable( String query, PrintWriter out) {
		try {
			pt.executeUpdate();
			query = "SELECT * FROM user;";
			ResultSet resultSet = pt.executeQuery(query);
			while(resultSet.next()) {
				out.print("User Password Changed Successfully.. "+ "<br>");

				out.print("User ID= " + resultSet.getString("userID") + "<br>");
				out.print("User Name= " + resultSet.getString("fname")+ "<br>");
				out.print("Password= " + resultSet.getString("password")+ "<br>");
				out.print("Email ID= " + resultSet.getString("email")+ "<br>");
				}
			
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

	
		
		
	


