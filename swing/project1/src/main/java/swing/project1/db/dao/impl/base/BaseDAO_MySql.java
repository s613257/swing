package swing.project1.db.dao.impl.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BaseDAO_MySql {

	private static Connection instance = null;

	public static Connection getConnection() {

		if (instance == null) {
			try {
				Properties props = new Properties();
				FileInputStream fis = new FileInputStream("../project1/db.properties");
				props.load(fis);
				Class.forName(props.getProperty("MYSQL_DB_DRIVERCLASS"));
				instance = DriverManager.getConnection(props.getProperty("MYSQL_DB_URL"),
						props.getProperty("MYSQL_DB_USER"), props.getProperty("MYSQL_DB_PASSWORD"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public static void closeAll(Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
