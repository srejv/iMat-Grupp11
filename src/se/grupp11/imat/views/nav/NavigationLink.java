package se.grupp11.imat.views.nav;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NavigationLink extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2073622911797281209L;

	public enum NavType { NavLink, Separation, CategoryLink, ListLink, NewListLink };
	public NavType type;
	
	String value;
	
	public NavigationLink(String text, String value) {
		this.setText(text);
		this.value = value;
		type = NavType.NavLink;
	}
	
	public void setValue(String text) {
		this.value = text;
	}
	
	public String getValue() {
		return this.value;
	}
	

	@Override 
	public String toString() {
		return getText();
	}
}
