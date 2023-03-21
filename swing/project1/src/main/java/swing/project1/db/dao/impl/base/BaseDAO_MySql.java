package swing.project1.db.dao.impl.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO_MySql {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/project1?useUnicode=true&characterEncoding=utf-8";
	private static String user = "root";
	private static String password = "1234";

	private static Connection instance = null;

	public static Connection getConnection() {
		if (instance == null) {
			try {
				Class.forName(driver);
				instance = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException se) {
				se.printStackTrace();
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
