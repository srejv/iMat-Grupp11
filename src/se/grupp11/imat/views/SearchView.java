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

public class SearchView extends JPanel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4395863302776044571L;
	private JLabel lblTitle; 
	/**
	 * Create the panel.
	 */
	public SearchView() {
		setLayout(new BorderLayout(0, 0));
		
		lblTitle = new JLabel("Sökning");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblTitle, BorderLayout.NORTH);
		
		productGrid = new JPanel();
		add(productGrid, BorderLayout.CENTER);
		productGrid.setBackground(new Color(255, 250, 250));
		productGrid.setLayout(new GridLayout(0, 4, 0, 0));
	}
	
	
	public void search(String search) {
		
		lblTitle.setText("<html>Sökning på <b>" + search + "</b></html>");
		productGrid.removeAll();
		List<Product> prodList = IMatDataHandler.getInstance().findProducts(search);
		
		for(int i = 0; i < 16; i++) {
			if(i > prodList.size()) {
				productGrid.add(new JLabel(""));
				continue;
			}
			ProductSquareItem s = new ProductSquareItem(prodList.get(i), 1);
			productGrid.add(s);
		}
		productGrid.setLayout(new GridLayout(0,4));
		
		this.updateUI();
	}
	
	private JPanel productGrid;

	public JPanel getProductGrid() {
		return productGrid;
	}
}
