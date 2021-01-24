package com.travelbyair.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class PassengerInfoServlet
 */
@WebServlet("/PassengerInfoServlet")
public class PassengerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassengerInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher	rd = request.getRequestDispatcher("/PassengerInfo.jsp");
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String message="";

		
		if(fname!=null && lname!=null && contact!=null && email!=null && 
				fname!="" && lname!="" && contact!="" && email!="" ){
			rd = request.getRequestDispatcher("/Payment.jsp");
			System.out.println(" "+fname+" "+lname+" "+contact);
			rd.forward(request, response);
			
			
		}
		else{
			message="PLEASE FILL THE FORM COMPLETELY";
			request.setAttribute("Key",message);
			rd.forward(request, response);
		}
		
		
	}

}
