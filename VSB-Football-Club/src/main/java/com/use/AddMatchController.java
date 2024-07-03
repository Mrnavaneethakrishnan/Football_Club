package com.use;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddMatchController")
public class AddMatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddMatchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title").trim();
		String place = request.getParameter("place").trim();
		String date = request.getParameter("date").trim();
		ArrayList<String> list=new ArrayList<String>();
		if(title.length()==0)
		{
			list.add("Enter Title Field");
		}
		if(place.length()==0)
		{
			list.add("Enter Place Field");
		}
		if(!list.isEmpty())
		{
			request.setAttribute("errors", list);
			RequestDispatcher rd=request.getRequestDispatcher("AddMatchForm");
			rd.forward(request, response);
			return;
		}
		Match m=new Match(title,place,date);
		MatchDao md=new MatchDao();
		md.StoreData(m);
		RequestDispatcher rd1 =request.getRequestDispatcher("Acknowlegement.html");
		rd1.forward(request, response);
		
		
		
	}

}
