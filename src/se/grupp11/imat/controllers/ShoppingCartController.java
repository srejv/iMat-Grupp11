package se.grupp11.imat.controllers;

import java.awt.Color;
import java.awt.Font;
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
import se.grupp11.imat.views.ListView;

public class ShoppingCartController implements ActionListener{

	private ShoppingList _list; 		// Model
	private ListView _view;
	
	
	private ShoppingCartController() {
		_list = new ShoppingList("Shopping Cart");
		_view = new ListView();
		_view.setShoppingList(_list);
		_view.setBackground(Color.WHITE);
		_view.setFont(new Font("Tahoma", Font.BOLD, 15));
	}
	
	private static ShoppingCartController _instance;
	public static ShoppingCartController getInstance() {
		if(_instance == null) {
			_instance = new ShoppingCartController();
		}
		return _instance;
	}
	
	public ListView getShoppingCartView() {
		return _view;
	}
	
	public void addList(ShoppingList list) { 
		_list = _view.getShoppingList();
		for(ShoppingListItem item : list.getList()) {
			_list.addItem(item);
		}
		_view.setShoppingList(_list);
		_view.updateUI();
	}
	
	public void addItem(ShoppingListItem item) {
		_list = _view.getShoppingList();
		_list.addItem(item);
		_view.setShoppingList(_list);
		_view.updateUI();
	}
	
	public void deleteItem(ShoppingListItem item) {
		_list = _view.getShoppingList();
		_list.removeItem(item);
		_view.setShoppingList(_list);
		_view.updateUI();
	}
	
	public ShoppingList getList() {
		return _list;
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
			_list = _view.getShoppingList();
			for(ShoppingListItem item : _list.getList()) {
				_list.removeItem(item);
			}

			_view.setShoppingList(_list);
			_view.updateUI();
		}
		
		else if(arg0.getActionCommand() == "buy"){
			MainWindow.setCard("CheckOut");
		}

		
	}

	public void addItem(Product item, int amount) {
		addItem(new ShoppingListItem(item, amount));
	}
}
