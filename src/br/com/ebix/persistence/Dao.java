package br.com.ebix.persistence;

import java.sql.*;

public class Dao {
	
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	public void open() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_segurado?useTimezone=true&serverTimezone=UTC", "root", "root");
		System.out.println("Conectado!");
	}
	
	public void close() throws Exception{
		con.close();
	}
}
