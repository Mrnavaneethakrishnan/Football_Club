package com.use;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookTickets")
public class BookTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BookTickets() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ArrayList <String> list=(ArrayList<String>) request.getAttribute("errors");
		out.println("<html>");
		out.println("<body>");
	    out.println("<center>");

		if(list !=null)
		{
			Iterator <String>itr=list.iterator();
			out.println("<ul>");
			while(itr.hasNext())
			{
				out.println("<li>"+itr.next()+"</li>");	
			}
			out.println("</ul>");
		}
	
	    out.println("<h2>Payment Page</h2>");
	    out.println("<hr>");
	    out.println("<form action='AddMatchController' method='post'>");
	    out.println("<input type='text' name='title'><br><br>");
	    out.println("Place<input type='text' name='place'><br><br>");
	    out.println("Match Date<input type='date' name='date'><br><br>");
	    out.println("<input type='submit' name='Submit'><br><br>");
		out.println("</center></form></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
