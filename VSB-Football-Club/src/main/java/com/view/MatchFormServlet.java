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

import com.use.MatchDao;

@WebServlet("/MatchFormServlet")
public class MatchFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MatchFormServlet() {
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
		out.println("<marquee><h2>Upcoming Match Info......... </h2></marquee>");
		out.println("<hr>");
		out.println("<center>");
		out.println("<table border='1'><tr><th>Title</th><th>Place</th><th>Matchdate</th>");
		out.println("</div>");
		out.println("</center>");
		ResultSet rs=new MatchDao().RetrieveMatch();
		try {
			while(rs.next())
			{
				out.println("<tr><th>"+rs.getString("title")+"</th><th>"+rs.getString("place")+"</th><th>"+rs.getString("matchdate")+"</th></tr>");
				
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
