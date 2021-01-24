package com.travelbyair.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.travelbyair.pojoclasses.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet2")
public class LoginServlet2 extends HttpServlet {
	Connection con=null;
	PreparedStatement pt=null;
	private static final long serialVersionUID = 1L;
       
	
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
    	String loginquery="select * from user where userid=?;";
    	try {
			pt=con.prepareStatement(loginquery);
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
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		RequestDispatcher rd=request.getRequestDispatcher("/LoginPage2.jsp");
		String userID=request.getParameter("userID");
		String userpassword=request.getParameter("password");
		String msg="";
		HttpSession sess = request.getSession();
		int members=(Integer)sess.getAttribute("member");
		
		try {
			if(userID!=null && userID!=""){
				pt.setString(1,userID);
				ResultSet rs=pt.executeQuery();
				if(rs.next()){
					System.out.println("in if");
					if(userpassword.equals(rs.getString(5))){
						msg="";
						System.out.println("password field");
						int id=rs.getInt(1);
						String fname=rs.getString(2);
						String lname=rs.getString(3);
						String userid=rs.getString(4);
						String password=rs.getString(5);
						String dob=rs.getString(6);
						String city=rs.getString(7);
						String moblie=rs.getString(9);
						String gender=rs.getString(10);
						String email=rs.getString(8);
						byte[] image=rs.getBytes(11);
						HttpSession session=request.getSession();
						User userlogin=new User(id,fname,lname,userid,password,dob,city,moblie,gender,email);
						if(image!=null){
							userlogin.setImage(image);
						}
						session.setAttribute("userlogin", userlogin);
						request.setAttribute("seat",members);
						rd=request.getRequestDispatcher("/PassengerInfo.jsp");
						rd.forward(request, response);
					}
					else{
						msg="Wrong password !! Please Enter your Correct Pasword";
						request.setAttribute("key",msg);
						rd.forward(request, response);
					}
				}
				else{
					msg="Wrong user ID !! Please Enter your Correct User ID";
					request.setAttribute("key",msg);
					rd.forward(request, response);
				}
			}
			else{
				msg="INVALID !! Please Enter your User ID";
				request.setAttribute("key",msg);
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
