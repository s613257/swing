package swing.project1;

import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import swing.project1.components.MainFrame;

public class Launch {

	private Connection conn;

	try(Connection conn = DriverManager.getConnection(null)){
		System.out.println("連線成功");
	}catch(
	SQLException e)
	{
		e.printStackTrace();
		System.out.println("連線失敗");
	}

	public void createConnection() throws SQLException {
		this.conn = DriverManager.getConnection(null);

		boolean status = !conn.isClosed();
		if (status) {
			System.out.println("連線開啟");
		}

	}

	public void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();
			System.out.println("關閉連線OK");
		}
	}

	public static void main(String[] args) {
		/**
		 * Launch the application.
		 */
		/*
		 * EventQueue.invokeLater(new Runnable() { public void run() { try { MainFrame
		 * mainFrame = new MainFrame(); mainFrame.setVisible(true); } catch (Exception
		 * e) { e.printStackTrace(); } } });
		 */

	}
}
