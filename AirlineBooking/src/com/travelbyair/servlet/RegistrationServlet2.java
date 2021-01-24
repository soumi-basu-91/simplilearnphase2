package com.travelbyair.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;




/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet2")
@MultipartConfig(maxFileSize=1024*1024*5)
public class RegistrationServlet2 extends HttpServlet {
	Connection con=null;
	PreparedStatement pt=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
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
    	String insertsql="INSERT INTO user (fname,lname,userid,password,dob,city,mobile,gender,email) VALUES(?,?,?,?,?,?,?,?,?);";
    	try {
			pt=con.prepareStatement(insertsql);
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		RequestDispatcher	rd = request.getRequestDispatcher("/Registration2.jsp");
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String userid = request.getParameter("userID");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String dob = request.getParameter("dob");
		Part image=request.getPart("image");
		String message="";
		String insertsql="INSERT INTO user (fname,lname,userid,password,dob,city,mobile,gender,email) VALUES(?,?,?,?,?,?,?,?,?);";
    	if(image!=null){
    		 insertsql="INSERT INTO user (fname,lname,userid,password,dob,city,mobile,gender,email,img) VALUES(?,?,?,?,?,?,?,?,?,?);";
    	}
		try {
			pt=con.prepareStatement(insertsql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(fname!=null && lname!=null && gender!=null && userid!=null && password!=null && contact!=null && email!=null && city!=null && dob!=null){
			System.out.println(" "+fname+" "+lname+" "+gender+" "+userid+" "+password+" "+contact+" "+city+" "+dob);
			try {
				System.out.println("in if-try block...");
				pt.setString(1,fname);
				pt.setString(2,lname);
				pt.setString(3,userid);
				pt.setString(4,password);
				pt.setString(5,dob);
				pt.setString(6,city);
				pt.setString(7,contact);
				pt.setString(8,gender);
				pt.setString(9,email);
				if(image!=null){
					pt.setBlob(10,image.getInputStream());
				}
				int row=pt.executeUpdate();
				if(row!=0){
					System.out.println("Sucessful inserted");
					rd = request.getRequestDispatcher("/LoginPage2.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else{
			message="PLEASE FILL THE FORM";
			request.setAttribute("Key",message);
			rd.forward(request, response);
		}
		
	}

}
