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

@WebServlet("/ViewPlayer")
public class ViewPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ArrayList <String> list1=(ArrayList<String>) request.getAttribute("errors");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='StyleSheet' href='Style1.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		if(list1 !=null)
		{
			Iterator <String>itr1=list1.iterator();
			out.println("<ul>");
			while(itr1.hasNext())
			{
				out.println("<li>"+itr1.next()+"</li>");	
			}
			out.println("</ul>");
		}
		out.println("<div class ='nv'>");
	    out.println("<h2> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  Player Details</h2>");
	    out.println("<br><hr>");
	    out.println("<form action='ViewPlayerCont' method= 'post' enctype='multipart/form-data'>");
	    out.println("<input type='text' name='name' placeholder='Name:' Required><br><br>");
	    out.println("<input type='text' name='age'placeholder='Age:' Required><br><br>");
	    out.println("Gender:<input type='radio' name='gender' value='Male'>Male"
	    		+ "<input type='radio' name='gender' value='Female'>Female<br><br>");
	    out.println("<input type='text' name='district' placeholder='District:' Required><br><br>");
	    out.println("<label for='Position'>Position of the Player:</label>");
	    out.println("<select id='Position'>");
	    out.println("<option value='Attacker'>Attacker</option>");
	    out.println("<option value='Defender'>Defender</option>");
	    out.println("<option value='Goal-Keeper'>Goal-Keeper</option>");
	    out.println("</select>");
	    out.println("<input type='text' name='email' placeholder='Email:'Required><br><br>");
	    out.println("Photo<input type='file' name='photo' Required><br><br>");
	    out.println("<input type='submit' name='Submit' style=colour:green><br><br>");
	    out.println("</div>");
	    out.println("</center>");
		out.println("</form></body></html>");
		
	} 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
