package se.grupp11.imat.views.nav;

import java.awt.Font;

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
		this.setOpaque(true);
		type = NavType.NavLink;
		
		this.setFont(new Font("Tohoma", Font.PLAIN, 12));
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
