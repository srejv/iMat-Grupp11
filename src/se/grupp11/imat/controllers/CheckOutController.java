package se.grupp11.imat.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.grupp11.imat.MainWindow;

public class CheckOutController implements ActionListener {

	public static CheckOutController cOC;
	
	private CheckOutController(){
		
	}
	
	public static CheckOutController getInstance(){
		if(cOC == null) cOC = new CheckOutController();
		return cOC;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "settings"){
			MainWindow.setCard("Settings");
		}
		
	}

}
