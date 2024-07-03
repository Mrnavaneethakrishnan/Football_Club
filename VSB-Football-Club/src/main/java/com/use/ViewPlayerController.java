package com.use;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/ViewPlayerCont")
@MultipartConfig(maxFileSize = 16177215)
public class ViewPlayerController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	String driver ="com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/vsbdb1";
	String unm="root";
	String pwd ="root";
	
    public ViewPlayerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name").trim();
		String a = request.getParameter("age").trim();
		String gender = request.getParameter("gender").trim();
		String district = request.getParameter("district").trim();
		String position = request.getParameter("position");
		String email = request.getParameter("email").trim();
		int age=0;
		age=Integer.parseInt(a);
		InputStream istrm=null;
		Part fp=request.getPart("photo");
		if(fp!=null)
		{
			System.out.println(fp.getName());
			System.out.println(fp.getSize());
			System.out.println(fp.getContentType());
			istrm = fp.getInputStream();
		}
		Connection con =null;
		String msg=null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con=DriverManager.getConnection(url ,unm ,pwd);
			String sql ="insert into PlayerDetails(name, age, gender, district, position, email, photo)" + "values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setString(3, gender);
			pst.setString(4, district);
			pst.setString(5, position);
			pst.setString(6, email);
			
			if(istrm!=null)
			{
				pst.setBlob(7, istrm);
			}
			int res= pst.executeUpdate();
			if(res>0)
			{
				msg="Player Data Uploaded Successfully..!!!!!!";
			}
			
			con.close();
		}
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Player p=new Player(name, age, gender, district, position, email, istrm);
		PlayerDao n=new PlayerDao();
		n.StoreData(p);
		request.setAttribute("msg", msg);
		getServletContext().getRequestDispatcher("/Ack.html").forward(request, response);
		

		
		}
	}


