package vn.iotstar.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnectMySQL {
	private static Connection con = null;
	private static String USERNAME = "root";
	private static String PASSWORD = "root";
	private static String URL ="jdbc:mysql://localhost:3306/w3";
	
	public static Connection getDatabaseCOnnection() throws IOException{
		con = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		}catch(SQLException ex) {
			Logger.getLogger(DBConnectMySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return (con);
		}
	
	public static void main(String[] args) {
		try {
			Connection c = getDatabaseCOnnection();
			if(c==null) {
				System.out.println("Sthing wrong");
			} else {
				System.out.println("ok");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}