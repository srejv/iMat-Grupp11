package se.grupp11.imat.views.nav;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import se.grupp11.imat.controllers.ShoppingCartController;
import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.views.nav.NavigationLink.NavType;

public class ListLink extends NavigationLink {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6464452876099858668L;
	private ShoppingList list;
	private JPopupMenu popupMenu;
	
	public void setPopupMenu() {
		popupMenu = new JPopupMenu();
		JMenuItem menuItem = new JMenuItem("Add to cart");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ShoppingCartController.getInstance().addList(list);
			}
		});
		popupMenu.add(menuItem);
		this.addMouseListener(new PopClickListener());
		this.setComponentPopupMenu(popupMenu);
		setToolTipText("Lista " + list.getTitle() + " med " + list.getAmount() + " produkter för " + list.getPrice() + " kr");
	}
	
	public ListLink(String text, ShoppingList list) {
		super(text, "List");
		this.list = list;
		type = NavType.ListLink;
		setPopupMenu();
	}
	
	public ShoppingList getList() {
		return list;
	}
	
	class PopClickListener extends MouseAdapter {
	    public void mousePressed(MouseEvent e){
	        if (e.isPopupTrigger())
	            doPop(e);
	    }

	    public void mouseReleased(MouseEvent e){
	        if (e.isPopupTrigger())
	            doPop(e);
	    }

	    private void doPop(MouseEvent e){
	    	popupMenu.show(e.getComponent(), e.getX(), e.getY());
	    }
	}

}
