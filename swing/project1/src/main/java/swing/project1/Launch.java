package swing.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Launch {
	
	public static void main(String[] args)  {

		DBConnect connection=new DBConnect();
        connection.getData();
	}

}

	class DBConnect {
		private Connection con;
		private Statement st;
		private ResultSet rs;

		public DBConnect() {
			try {
				// Class 的靜態 forName() 方法實現動態加載類別
				Class.forName("com.mysql.jdbc.Driver");
				// 3306|MySQL開放此端口
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1?useUnicode=true&characterEncoding=utf-8", "root", "1234");
				st = con.createStatement();

			} catch (Exception ex) {
				System.out.println("Error: " + ex);
			}
		}
			
			public void getData() {
				try {
					String query = "select animal_Kind,animal_Variety from t_adoption_info limit 10";
					rs = st.executeQuery(query);
					int i = 10;
					while (rs.next() && i > 0) {
						String animal_Kind = rs.getString("animal_Kind");
						String animal_Variety = rs.getString("animal_Variety");
						System.out.println("種類= " + animal_Kind + " 品種= " + animal_Variety);
						i--;
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}	
			
		}

	}

	

/**
 * Launch the application.
 */
/*
 * EventQueue.invokeLater(new Runnable() { public void run() { try { MainFrame
 * mainFrame = new MainFrame(); mainFrame.setVisible(true); } catch (Exception
 * e) { e.printStackTrace(); } } });
 */
