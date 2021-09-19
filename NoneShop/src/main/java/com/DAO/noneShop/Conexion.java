package com.DAO.noneShop;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class Conexion {

	static String bd = "tiendap";
	static String login = "root";
	static String password="root";
	static String url = "jdbc:mysql://localhost/"+bd;

	Connection connection = null;
	
	public Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			connection = DriverManager.getConnection(url,login,password);
			
			if(connection!=null) {
				System.out.println("Conexión ok");
			}
			
			
		} catch (SQLException e) {
			System.out.println(e);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public Connection getConnection() {
		return connection;
		
	}
	public void desconectar() {
		connection =null;
	}
	
	
}
