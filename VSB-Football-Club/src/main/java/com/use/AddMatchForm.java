package com.use;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat.Style;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddMatchForm")
public class AddMatchForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddMatchForm() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ArrayList <String> list=(ArrayList<String>) request.getAttribute("errors");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='StyleSheet' href='Style.css'>");
		out.println("</head>");
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
	    out.println("<div class ='nv'>");
	    out.println("<h2 style='color:black'>&nbsp &nbsp &nbsp Add Match Details...</h2>");
	    out.println("<hr>");
	    out.println("<br>");
	    out.println("<form action='AddMatchController' method='post'>");
	    out.println("<input type='text' name='title' placeholder='Title'><br><br>");
	    out.println("<input type='text' name='place' placeholder='Place'><br><br>");
	    out.println("<input type='date' name='date' placeholder='Match Date'><br><br>");
	    out.println("<input type='submit' name='Submit' class='btn'><br><br>");
	    out.println("</div>");
		out.println("</center></form></body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
