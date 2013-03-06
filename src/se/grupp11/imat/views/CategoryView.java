package se.grupp11.imat.views;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
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
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;

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
		
		productGrid = new JPanel();
		add(productGrid);
		productGrid.setBackground(new Color(255, 250, 250));
		

	}
	
	
	public void LoadCategory(ProductCategory category) {
		
		productGrid.removeAll();
		List<Product> prodList = IMatDataHandler.getInstance().getProducts(category);
		


		
		productGrid.setLayout(new GridLayout(4,4));
		
		int nulllbls=16-prodList.size();
		for (Product product : prodList) {
			ProductSquareItem i = new ProductSquareItem(product, 1);
			productGrid.add(i);
		}
		for(int i=0; i<nulllbls; i++){
			productGrid.add(new JLabel(""));
		}

		
		this.updateUI();
	}
	
	private JPanel productGrid;

	public JPanel getProductGrid() {
		return productGrid;
	}
}
