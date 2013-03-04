package se.grupp11.imat.views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import se.chalmers.ait.dat215.project.IMatDataHandler;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartPage extends JPanel {
	
	IMatDataHandler handler=IMatDataHandler.getInstance();
	private final ProductSquareItem productSquareItem_4=new ProductSquareItem(handler.getProduct(20));

	

	/**
	 * Create the panel.
	 */
	public StartPage() {
		
		
		
		setLayout(new GridLayout(4, 4, 0, 0));
		
		setMaximumSize(new Dimension(680, 1200));
		setMinimumSize(new Dimension(680, 1200));
		
		

	
		ProductSquareItem productSquareItem = new ProductSquareItem(handler.getProduct(20));
		productSquareItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		add(productSquareItem);
		
		ProductSquareItem productSquareItem_1 = new ProductSquareItem(handler.getProduct(20));
		add(productSquareItem_1);
		
		ProductSquareItem productSquareItem_2 = new ProductSquareItem(handler.getProduct(20));
		add(productSquareItem_2);
		
		ProductSquareItem productSquareItem_3 = new ProductSquareItem(handler.getProduct(20));
		add(productSquareItem_3);
		
		ProductSquareItem productSquareItem_5 = new ProductSquareItem(handler.getProduct(20));
		add(productSquareItem_5);
		add(productSquareItem_4);
		
		ProductSquareItem productSquareItem_9 = new ProductSquareItem(handler.getProduct(20));
		add(productSquareItem_9);
		
		ProductSquareItem productSquareItem_13 = new ProductSquareItem(handler.getProduct(20));
		add(productSquareItem_13);
		
		ProductSquareItem productSquareItem_6 = new ProductSquareItem(handler.getProduct(20));
		add(productSquareItem_6);
		
		ProductSquareItem productSquareItem_8 = new ProductSquareItem(handler.getProduct(20));
		add(productSquareItem_8);
		
		ProductSquareItem productSquareItem_10 = new ProductSquareItem(handler.getProduct(20));
		add(productSquareItem_10);
		
		ProductSquareItem productSquareItem_14 = new ProductSquareItem(handler.getProduct(20));
		add(productSquareItem_14);
		
		ProductSquareItem productSquareItem_7 = new ProductSquareItem(handler.getProduct(20));
		add(productSquareItem_7);
		
		ProductSquareItem productSquareItem_11 = new ProductSquareItem(handler.getProduct(20));
		add(productSquareItem_11);
		
		ProductSquareItem productSquareItem_12 = new ProductSquareItem(handler.getProduct(20));
		add(productSquareItem_12);
		
		ProductSquareItem productSquareItem_15 = new ProductSquareItem(handler.getProduct(20));
		add(productSquareItem_15);
		
		



	}
}
