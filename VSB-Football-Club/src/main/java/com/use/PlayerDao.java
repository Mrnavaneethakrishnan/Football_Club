package com.use;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDao {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	public PlayerDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vsbdb1","root","root");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet RetrievePlayer()
	{
		String sql="Select name, age, gender, district, position, email, photo from PlayerDetails";
		try {
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public void StoreData(Player p)
	{
		String sql="insert into PlayerDetails(name, age, gender, district, position, email, photo) values(?, ?, ?, ?, ?, ?, ?)";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, p.getName());
			pst.setInt(2, p.getAge());
			pst.setString(3, p.getGender());
			pst.setString(4, p.getDistrict());
			pst.setString(5, p.getPosition());
			pst.setString(6, p.getEmail());
			pst.setBlob(7, p.getPhoto());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
