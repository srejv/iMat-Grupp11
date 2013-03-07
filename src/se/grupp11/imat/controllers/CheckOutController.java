package se.grupp11.imat.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.grupp11.imat.MainWindow;
import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.models.ShoppingListItem;
import se.grupp11.imat.views.ReceiptView;

public class CheckOutController implements ActionListener {

	public static CheckOutController cOC;
	public static ShoppingCartController scc = ShoppingCartController.getInstance();
	
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
		if(arg0.getActionCommand() == "checkout"){
			ShoppingList sList = scc.getList();
			
			for(ShoppingListItem i :sList.getList()){
				IMatDataHandler.getInstance().getShoppingCart().addItem(i.toShoppingItem());
			}
			
			Order order=IMatDataHandler.getInstance().placeOrder(true);
			JOptionPane.showMessageDialog(null ,"Köpet slutfört!");
			
			MainWindow.getHistory().updateView();
			MainWindow.setReceiptView(new ReceiptView(order.getOrderNumber()));
			MainWindow.setCard("ReceiptView");
			
			System.out.println(IMatDataHandler.getInstance().getOrders().size());
		}
	}

}
