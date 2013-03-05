package se.grupp11.imat;

import java.awt.EventQueue;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.grupp11.imat.controllers.ShoppingListController;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				ShoppingListController.getInstance().save();
				IMatDataHandler.getInstance().shutDown();
			}
		});
	}
}
