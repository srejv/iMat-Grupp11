package se.grupp11.imat.views.nav;

import javax.swing.JPanel;

import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.views.nav.NavigationLink.NavType;

public class ListLink extends NavigationLink {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6464452876099858668L;
	private ShoppingList list;
	public ListLink(String text, ShoppingList list) {
		super(text, "List");
		this.list = list;
		type = NavType.ListLink;
	}
	
	public ShoppingList getList() {
		return list;
	}
}
