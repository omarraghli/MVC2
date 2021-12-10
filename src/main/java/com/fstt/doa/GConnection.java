package com.fstt.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GConnection {

	private static String url = "jdbc:mysql://localhost:3306/clientcommandeproduit"; 
	private static String user = "root"; 
	private  static String password = "" ;
	
	private static Connection cnx ;
	
	private GConnection() {
		
	}
	
public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		if(cnx == null ) {
			Class.forName("com.mysql.jdbc.Driver") ;
			cnx = DriverManager.getConnection(url, user, password) ;
		}
		return cnx ;
	}
}
