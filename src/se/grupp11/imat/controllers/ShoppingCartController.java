package se.grupp11.imat.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import se.grupp11.imat.MainWindow;

	

import java.util.GregorianCalendar;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.models.ShoppingListItem;

public class ShoppingCartController implements ActionListener{

	private ShoppingList _list; 		// Model
	//private ShoppingCartView _view;		// View
	// need selected products list
	
	
	public ShoppingCartController() {
		_list = new ShoppingList("Shopping Cart");
	}
	
	public void addList(ShoppingList list) { 
		for(ShoppingListItem item : list.getList()) {
			_list.addItem(item);
		}
	}
	
	public void addItem(ShoppingListItem item) {
		_list.addItem(item);
	}
	
	public void deleteItem(ShoppingListItem item) {
		_list.removeItem(item);
	}
	

	
	class AddAction extends AbstractAction {
		public AddAction(String text, ImageIcon icon, String desc, Integer mnemonic) {
			super(text, icon);
			putValue(SHORT_DESCRIPTION, desc);
			putValue(MNEMONIC_KEY, mnemonic);
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class RemoveAction extends AbstractAction {
		public RemoveAction(String text, ImageIcon icon, String desc, Integer mnemonic) {
			super(text, icon);
			putValue(SHORT_DESCRIPTION, desc);
			putValue(MNEMONIC_KEY, mnemonic);
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		}
	}
	
	class DuplicateAction extends AbstractAction {
		public DuplicateAction(String text, ImageIcon icon, String desc, Integer mnemonic) {
			super(text, icon);
			putValue(SHORT_DESCRIPTION, desc);
			putValue(MNEMONIC_KEY, mnemonic);
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		}
	}
	
	class CreateAsNewListAction extends AbstractAction {
		public CreateAsNewListAction(String text, ImageIcon icon, String desc, Integer mnemonic) {
			super(text, icon);
			putValue(SHORT_DESCRIPTION, desc);
			putValue(MNEMONIC_KEY, mnemonic);
		}
			
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ShoppingList newList = new ShoppingList("ShoppingList " + (new GregorianCalendar()).getTime().toString());
			for(ShoppingListItem item : _list.getList()) {
				newList.addItem(item);
			}
			

		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "erase"){
			MainWindow.eraseShoppingCart();
		}
		else if(arg0.getActionCommand() == "buy"){
			MainWindow.setCard("CheckOut");
		}

		
	}
}
