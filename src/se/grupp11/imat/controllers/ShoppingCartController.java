package se.grupp11.imat.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import se.grupp11.imat.MainWindow;

public class ShoppingCartController implements ActionListener{
	private JButton erase;
	private JButton buy;
	
	public ShoppingCartController(){
		/*this.erase = erase;
		this.buy = buy;
		this.erase.addActionListener(this);
		this.erase.setActionCommand("erase");
		this.buy.addActionListener(this);*/
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand() == "erase"){
			MainWindow.eraseShoppingCart();
		}
		else if(e.getActionCommand() == "buy"){
			MainWindow.setCard("CheckOut");
		}
	}
}
