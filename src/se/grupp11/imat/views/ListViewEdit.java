package se.grupp11.imat.views;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.TransferHandler;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DropMode;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.grupp11.imat.MainWindow;
import se.grupp11.imat.controllers.ShoppingCartController;
import se.grupp11.imat.controllers.ShoppingListController;
import se.grupp11.imat.dnd.ToShoppingCartTransferHandler;
import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.models.ShoppingListItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListViewEdit extends JPanel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8004426289087487059L;
	private ShoppingList list;
	private JTextField textTitle;
	private JTextArea txtDescription;
	

	public void setShoppingList(ShoppingList list) {
		this.list = list;
		this.LoadShoppingList(list);
	}
	
	public ShoppingList getShoppingList() {
		return this.list;
	}
	
	
	public ListViewEdit() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		textTitle = new JTextField();
		textTitle.setText("title");
		springLayout.putConstraint(SpringLayout.NORTH, textTitle, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textTitle, 10, SpringLayout.WEST, this);
		add(textTitle);
		textTitle.setColumns(10);
		
		txtDescription = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, txtDescription, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtDescription, -10, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, txtDescription, 6, SpringLayout.SOUTH, textTitle);
		springLayout.putConstraint(SpringLayout.SOUTH, txtDescription, 89, SpringLayout.SOUTH, textTitle);
		txtDescription.setText("Description");
		add(txtDescription);
		
		JButton btnDoneEditing = new JButton("Spara Ändring");
		btnDoneEditing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListView l = MainWindow.getListPanel();
				list.setTitle(textTitle.getText());
				list.setDescription(txtDescription.getText());
				l.setShoppingList(list);
				MainWindow.fillMenuAndRefresh();
				MainWindow.setCard("List");
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnDoneEditing, 0, SpringLayout.NORTH, textTitle);
		springLayout.putConstraint(SpringLayout.EAST, btnDoneEditing, -10, SpringLayout.EAST, this);
		add(btnDoneEditing);
	}
	
	
	private void LoadShoppingList(ShoppingList newList) {
		textTitle.setText(list.getTitle());
		txtDescription.setText(list.getDescription());

	}

	
	class CustomCellRenderer implements ListCellRenderer {
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			ListRowItem l = (ListRowItem)value;
			if(Integer.parseInt(l.getAmount().getText()) <= 0) {
				return new JLabel("");
			}
			
			Component c = (Component)value;
			if(!isSelected) {
				c.setBackground((index % 2 == 1) ? altRow : row);
			} else {
				c.setBackground(sel);
			}
				
			return c;
		}
		private Color row = Color.getHSBColor(0.f, 0.f, 1.f);
		private Color altRow = Color.getHSBColor(0.f, 0.f, 0.9f);
		private Color sel = Color.getHSBColor(0.3f, 0.1f, 0.9f);
	}
	public JTextArea getTxtDescription() {
		return txtDescription;
	}
}
