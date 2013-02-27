package se.grupp11.imat.views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

public class StartPage extends JPanel {
	private final ProductSquareItem productSquareItem_4 = new ProductSquareItem();

	/**
	 * Create the panel.
	 */
	public StartPage() {
		setLayout(new MigLayout("", "[190px,grow][190px,grow][190px,grow][190px,grow]", "[561px][grow][grow][grow]"));
		
		
		ProductSquareItem productSquareItem = new ProductSquareItem();
		add(productSquareItem, "cell 0 0,grow");
		
		ProductSquareItem productSquareItem_1 = new ProductSquareItem();
		add(productSquareItem_1, "cell 1 0,grow");
		
		ProductSquareItem productSquareItem_2 = new ProductSquareItem();
		add(productSquareItem_2, "cell 2 0,grow");
		
		ProductSquareItem productSquareItem_3 = new ProductSquareItem();
		add(productSquareItem_3, "cell 3 0,grow");
		
		ProductSquareItem productSquareItem_5 = new ProductSquareItem();
		add(productSquareItem_5, "cell 0 1,grow");
		add(productSquareItem_4, "cell 1 1");
		
		ProductSquareItem productSquareItem_9 = new ProductSquareItem();
		add(productSquareItem_9, "cell 2 1,grow");
		
		ProductSquareItem productSquareItem_13 = new ProductSquareItem();
		add(productSquareItem_13, "cell 3 1,grow");
		
		ProductSquareItem productSquareItem_6 = new ProductSquareItem();
		add(productSquareItem_6, "cell 0 2,grow");
		
		ProductSquareItem productSquareItem_8 = new ProductSquareItem();
		add(productSquareItem_8, "cell 1 2,grow");
		
		ProductSquareItem productSquareItem_10 = new ProductSquareItem();
		add(productSquareItem_10, "cell 2 2,grow");
		
		ProductSquareItem productSquareItem_14 = new ProductSquareItem();
		add(productSquareItem_14, "cell 3 2,grow");
		
		ProductSquareItem productSquareItem_7 = new ProductSquareItem();
		add(productSquareItem_7, "cell 0 3,grow");
		
		ProductSquareItem productSquareItem_11 = new ProductSquareItem();
		add(productSquareItem_11, "cell 1 3,grow");
		
		ProductSquareItem productSquareItem_12 = new ProductSquareItem();
		add(productSquareItem_12, "cell 2 3,grow");
		
		ProductSquareItem productSquareItem_15 = new ProductSquareItem();
		add(productSquareItem_15, "cell 3 3,grow");

	}
}
