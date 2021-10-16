package com.DAO.noneShop;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class Conexion {

	static String bd = "grupo39_equipo5";
	static String login = "admin";
	static String password="tiendagenericamaoe2";
	//static String url = "jdbc:mysql://localhost/"+bd;
	static String url = "jdbc:mariadb://tiendagenericamaoe2.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/"+bd;

	Connection connection = null;
	
	public Conexion() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");			
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
