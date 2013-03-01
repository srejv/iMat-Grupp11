package se.grupp11.imat.views;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTree;
import java.awt.FlowLayout;

public class NavigationView extends JPanel {

	/**
	 * Create the panel.
	 */
	public NavigationView() {
		setLayout(null);
		
		JLabel lblMain = new JLabel("Main");
		lblMain.setBounds(0, 0, 30, 16);
		add(lblMain);
		
		JList listMainNav = new JList();
		listMainNav.setBounds(1, 16, 141, 51);
		add(listMainNav);
		listMainNav.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMainNav.setModel(new AbstractListModel() {
			String[] values = new String[] {"Home", "History", "Settings"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listMainNav.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
			}
		});
		
		JList listCategoryNav = new JList();
		listCategoryNav.setBounds(0, 95, 141, 153);
		add(listCategoryNav);
		listCategoryNav.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCategoryNav.setModel(new AbstractListModel() {
			String[] values = new String[] {"Basvaror", "Bröd", "Chark", "Dryck", "Fisk", "Frukt och grönt", "Färdiglagat", "Godis och fika", "Mejeri"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblLists = new JLabel("Lists");
		lblLists.setBounds(4, 251, 30, 16);
		add(lblLists);
		
		JList listListsNav = new JList();
		listListsNav.setBounds(3, 271, 138, 109);
		add(listListsNav);
		listListsNav.setModel(new AbstractListModel() {
			String[] values = new String[] {"Fredagsmys", "Ny lista"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listListsNav.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblCategories = new JLabel("Categories");
		lblCategories.setBounds(3, 70, 67, 16);
		add(lblCategories);

	}

}
