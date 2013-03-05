package se.grupp11.imat.views;

import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.TransferHandler;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DropMode;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.grupp11.imat.dnd.ToTransferHandler;
import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.models.ShoppingListItem;

public class ListView extends JPanel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8004426289087487059L;
	private ShoppingList list;
	private JLabel lblListTitle;
	private JList list_1;
	private JLabel lblDescription;
	private Vector list_data;
	

	public void setShoppingList(ShoppingList list) {
		this.list = list;
		this.LoadShoppingList(list);
	}
	
	public ShoppingList getShoppingList() {
		return this.list;
	}
	
	
	public ListView() {
		list_data = new Vector();
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		lblListTitle = new JLabel("ListName");
		springLayout.putConstraint(SpringLayout.NORTH, lblListTitle, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblListTitle, 10, SpringLayout.WEST, this);
		add(lblListTitle);
		
		list_1 = new JList();
		list_1.setDropMode(DropMode.INSERT);
		list_1.setTransferHandler(new ToTransferHandler(TransferHandler.COPY, list_1, list_data));
		list_1.setPreferredSize(new Dimension(200, 500));
		springLayout.putConstraint(SpringLayout.SOUTH, list_1, -10, SpringLayout.SOUTH, this);
		list_1.setDragEnabled(true);
		springLayout.putConstraint(SpringLayout.WEST, list_1, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, list_1, -10, SpringLayout.EAST, this);
		list_1.setCellRenderer(new CustomCellRenderer());
		list_1.setModel(new AbstractListModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -9065824185601074599L;
			public int getSize() { return list_data.size(); }
			public Object getElementAt(int i) { return list_data.get(i); }
		});
		list_1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) { }
			
			@Override
			public void keyReleased(KeyEvent e) { }
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DELETE) {
					int[] indx = list_1.getSelectedIndices();
					if(indx.length > 0) {
						for(int i = indx.length - 1; i >= 0; i-- ) {
							list_data.remove(indx[i]);
						}
						
						list_1.setListData(list_data);
						list_1.setSelectedIndex(-1);
					}
				}
			}
		});
		add(list_1);
		
		lblDescription = new JLabel("Description");
		springLayout.putConstraint(SpringLayout.NORTH, list_1, 6, SpringLayout.SOUTH, lblDescription);
		springLayout.putConstraint(SpringLayout.NORTH, lblDescription, 6, SpringLayout.SOUTH, lblListTitle);
		springLayout.putConstraint(SpringLayout.WEST, lblDescription, 0, SpringLayout.WEST, lblListTitle);
		add(lblDescription);
	}
	
	
	private void LoadShoppingList(ShoppingList newList) {
		lblListTitle.setText(list.getTitle());
		lblDescription.setText(list.getDescription());
		list_data.clear();
		for(ShoppingListItem i : list.getList()) {
			ListRowItem o = new ListRowItem(i);
			list_data.add(o);
		}
		list_1.setListData(list_data);

	}
	public JLabel getLblProductname() {
		return lblListTitle;
	}
	public JList getList() {
		return list_1;
	}
	public JLabel getLblNewLabel() {
		return lblDescription;
	}
	
	class CustomCellRenderer implements ListCellRenderer {
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
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
}
