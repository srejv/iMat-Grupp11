package se.grupp11.imat.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import se.grupp11.imat.controllers.ShoppingListController;
import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.views.nav.ListLink;
import se.grupp11.imat.views.nav.NavigationLink;
import se.grupp11.imat.views.nav.NavigationLink.NavType;

public class NavigationView extends JPanel implements Observer {

	private JList navlist;
	private List<NavigationLink> leftMenuItems;
	
	public NavigationView() {
		
	}

	
	class NavigationRenderer implements ListCellRenderer {
		private Color category = Color.getHSBColor(22.0f/360.0f, 0.84f, 1.f);
		private Color separator = Color.getHSBColor(0.f, 0.f, 0.9f);
		private Color title = Color.getHSBColor(347.0f/360.0f, 0.87f, 1.f);
		private Color selection = new Color(255,250,250);
		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			NavigationLink c = (NavigationLink)value;
			if (c.type == NavType.Separation) {
				JLabel lblSeparator = new JLabel( );
				lblSeparator.setOpaque(true);
				lblSeparator.setBorder( 
					BorderFactory.createLineBorder(Color.black ) );
					lblSeparator.setPreferredSize( new Dimension( 20, 2 ) );
				return lblSeparator ;
			} else if(c.type == NavType.CategoryLink) {
				c.setBackground(category);
			} else if(c.type == NavType.ListLink) {
				c.setBackground(category);
			} else if (c.type == NavType.NewListLink)  {
				c.setBackground(category);

			} else if(c.type == NavType.NavLink)   {
				c.setBackground(category);
			}
			
			if(index % 2 == 1) {
				Color g = c.getBackground();
				c.setBackground(g.brighter());
			}
			
			if(isSelected) {
				if(c.type == NavType.NewListLink) {
					ShoppingList slist = ShoppingListController.getInstance().create();
					slist.setTitle("A new list");
					slist.setDescription("A whole new list.");
					leftMenuItems.add(new ListLink(slist.getTitle(), slist));
					navlist.setListData(leftMenuItems.toArray());
					navlist.repaint();
					return new JLabel("");
				}
				c.setBackground(selection);
			}
			return c;
		}
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
