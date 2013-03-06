package se.grupp11.imat;

import java.awt.EventQueue;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.grupp11.imat.controllers.ShoppingListController;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				ShoppingListController.getInstance().save();
				IMatDataHandler.getInstance().shutDown();
			}
		});
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
