package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class sqlConnection {

	public Connection databaselink;
	
	public Connection getConnection() {
		
		String databaseName = "trialdb";
		String databaseUser = "system";
		String databasePass = "Nidhi@12345";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			databaselink = DriverManager.getConnection(url, databaseUser, databasePass);
			System.out.println("Connected...");
			
		} catch (Exception e){
			e.printStackTrace();
			databaselink = null;
		}
		return databaselink;
		
	}
}
