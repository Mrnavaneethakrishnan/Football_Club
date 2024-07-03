package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.use.PlayerDao;

@WebServlet("/PlayerFormServlet")
public class PlayerFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public PlayerFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='StyleSheet' href='Style2.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class ='nv'>");
		out.println("<h2>Player Information... </h2>");
		out.println("<hr>");
		out.println("<center>");
		out.println("<table border='1'><tr><th>Name</th><th>Age</th><th>Gender</th><th>District</th><th>Position</th><th>Email</th><th>Photo</th>");
		out.println("</div>");
		out.println("</center>");
		ResultSet rs=new PlayerDao().RetrievePlayer();
		try {
			while(rs.next())
			{
				out.println("<tr><th>"+rs.getString("name")+"</th><th>"+rs.getString("age")+"</th><th>"+rs.getString("gender")+"</th><th>"+rs.getString("district")+"</th><th>"+rs.getString("position")+"</th><th>"+rs.getString("email")+"</th><th>"+rs.getBlob("photo")+"</th></tr>");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
