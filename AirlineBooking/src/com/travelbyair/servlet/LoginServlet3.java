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

import com.travelbyair.pojoclasses.Admin;
//import com.travelbyair.pojoclasses.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet3")
public class LoginServlet3 extends HttpServlet {
	Connection con=null;
	PreparedStatement pt=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
    	String loginquery="select * from Admin where id=?;";
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
		RequestDispatcher rd=request.getRequestDispatcher("/LoginPage3.jsp");
		String AdminID=request.getParameter("AdminID");
		String Adminpassword=request.getParameter("password");
		String msg="";
		try {
			if(AdminID!=null && AdminID!=""){
				pt.setString(1,AdminID);
				ResultSet rs=pt.executeQuery();
				if(rs.next()){
					System.out.println("in if");
					if(Adminpassword.equals(rs.getString(3))){
						msg="";
						int id=rs.getInt(1);
						String name=rs.getString(2);
						String password=rs.getString(3);
						HttpSession session=request.getSession();
						Admin Adminlogin=new Admin(id,name,password);
						session.setAttribute("Adminlogin", Adminlogin);
						rd=request.getRequestDispatcher("/HomePage3.jsp");
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
