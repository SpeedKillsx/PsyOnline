package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDonnee {


private static final String SQCONN  = "jdbc:sqlite:cabinet.db";

public static Connection getConnection() throws SQLException  {
	
	try {
		
	Class.forName("org.sqlite.JDBC");
		return DriverManager.getConnection(SQCONN);
	} catch (ClassNotFoundException e) {
		// TODO: handle exception
		
	}
	return null;
}

}
