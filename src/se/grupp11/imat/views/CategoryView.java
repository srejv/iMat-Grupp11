package se.grupp11.imat.views;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import se.chalmers.ait.dat215.project.*;
import se.grupp11.imat.dnd.FromTransferHandler;

import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.TransferHandler;

import java.awt.Component;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class CategoryView extends JPanel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4395863302776044571L;
	/**
	 * Create the panel.
	 */
	public CategoryView() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblCategory, BorderLayout.NORTH);
		
		productVector = new Vector();
		
		productVector.clear();
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		list_1 = new JList();
		panel.add(list_1);
		list_1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list_1.setDragEnabled(true);
		list_1.setBackground(Color.WHITE);
		list_1.setCellRenderer(new CustomCellRenderer());
		AbstractListModelExtension e = new AbstractListModelExtension();
		list_1.setModel(e);
		list_1.setTransferHandler(new FromTransferHandler(list_1, e));

	}
	
	
	public void LoadCategory(ProductCategory category) {
		
		List<Product> prodList = IMatDataHandler.getInstance().getProducts(category);
		for (Product product : prodList) {
			//JPanel p = new JPanel();
			//p.add(new JLabel(product.getName()));
			//productVector.add(p);
			ProductSquareItem i = new ProductSquareItem(product);
			productVector.add(i);
		}
		list_1.setListData(productVector);
		
		this.updateUI();
	}
	
	private Vector productVector;
	private JList list_1;
	private final class AbstractListModelExtension extends AbstractListModel {
		@Override
		public Object getElementAt(int arg0) {
			return productVector.get(arg0);
		}

		@Override
		public int getSize() {
			return productVector.size();
		}
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

	
	public JList getList() {
		return list_1;
	}
}
