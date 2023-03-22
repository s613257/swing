package jdbc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	public static Connection createSQLServerConnection() {
		Properties props = new Properties();

		FileInputStream fis = null;
		Connection conn = null;

		try {
			fis = new FileInputStream("project1/db.properties");
			props.load(fis);
			conn = DriverManager.getConnection(
					props.getProperty("MYSQL_DB_URL"), 
					props.getProperty("MYSQL_DB_USER"),
					props.getProperty("MYSQL_DB_PASSWORD"));

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
