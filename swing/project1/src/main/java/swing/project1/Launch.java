package swing.project1;

import java.awt.EventQueue;

import swing.project1.view.MainFrame;

public class Launch {

	public static void main(String[] args) {
		/**
		 * Launch the application.
		 */

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame mainFrame = new MainFrame();
					mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
