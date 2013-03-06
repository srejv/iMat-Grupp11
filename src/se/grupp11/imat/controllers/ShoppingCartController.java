package se.grupp11.imat.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;
import se.grupp11.imat.MainWindow;
import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.models.ShoppingListItem;
import se.grupp11.imat.views.ShoppingCartView;

public class ShoppingCartController implements ActionListener,
		ShoppingCartListener {

	private static ShoppingCartController scc;
	private ShoppingList _list; // Model
	private IMatDataHandler imdh = IMatDataHandler.getInstance();
	private ShoppingCart sc = imdh.getShoppingCart();

	// private ShoppingCartView _view; // View
	// need selected products list

	ShoppingCartController() {
		_list = new ShoppingList("Shopping Cart");
	}

	public static ShoppingCartController getInstance() {
		if (scc == null)
			scc = new ShoppingCartController();
		return scc;

	}

	public void addList(ShoppingList list) {
		for (ShoppingListItem item : list.getList()) {
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
		public AddAction(String text, ImageIcon icon, String desc,
				Integer mnemonic) {
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
		public RemoveAction(String text, ImageIcon icon, String desc,
				Integer mnemonic) {
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
		public DuplicateAction(String text, ImageIcon icon, String desc,
				Integer mnemonic) {
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
		public CreateAsNewListAction(String text, ImageIcon icon, String desc,
				Integer mnemonic) {
			super(text, icon);
			putValue(SHORT_DESCRIPTION, desc);
			putValue(MNEMONIC_KEY, mnemonic);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ShoppingList newList = new ShoppingList("ShoppingList "
					+ (new GregorianCalendar()).getTime().toString());
			for (ShoppingListItem item : _list.getList()) {
				newList.addItem(item);
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getActionCommand() == "buy") {
			MainWindow.setCard("CheckOut");
		}

	}

	@Override
	public void shoppingCartChanged(CartEvent arg0) {
		/*List<ShoppingItem> listOfItems = sc.getItems();
		ShoppingItem[] siList = new ShoppingItem[listOfItems.size()];
		siList[0] = new ShoppingItem(imdh.getProduct(1),10);
		Iterator<ShoppingItem> it = listOfItems.iterator();
		int i = 0;
		while(it.hasNext()){
			siList[i] = it.next();
			
			if(i>=siList.length) break;
		}*/
		
		//ShoppingCartView.updateCart(siList);
		
	}
}
