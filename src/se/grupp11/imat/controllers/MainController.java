package se.grupp11.imat.controllers;

import java.awt.EventQueue;

import se.grupp11.imat.MainWindow;

public class MainController {

	MainWindow window;
	
	ShoppingCartController cartController;
	
	
	public MainController() {
		cartController = new ShoppingCartController();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new MainWindow();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainController c = new MainController();
	}
}
