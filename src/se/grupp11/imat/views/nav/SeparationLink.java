package se.grupp11.imat.views.nav;

import se.grupp11.imat.views.nav.NavigationLink.NavType;

public class SeparationLink extends NavigationLink {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4807965523370504040L;

	public SeparationLink() {
		super("-", null);
		type = NavType.Separation;
	}
}
