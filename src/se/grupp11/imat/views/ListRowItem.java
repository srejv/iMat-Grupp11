package se.grupp11.imat.views;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.Box;

import se.chalmers.ait.dat215.project.Product;
import se.grupp11.imat.models.ShoppingListItem;

public class ListRowItem extends JPanel {
	private JLabel lblProductname;
	private JLabel lblAmount;
	private JLabel lblPrice;	
	private ShoppingListItem item;
	/**
	 * Create the panel.
	 */
	public ListRowItem(ShoppingListItem p) {
		item = p;
		initialize();
		updateLabels();
	}
	
	public Product getProduct() {
		return item.getItem();
	}
	
	public ShoppingListItem getShoppingListItem() {
		return item;
	}
	
	public void addAmount() {
		//
	}
	
	private void updateLabels() {
		if(item == null) {
			return;
		}
		int amount =  item.getAmount();
		double price = item.getItem().getPrice();
		lblPrice.setText( (amount * price) + ":-");
		lblAmount.setText(amount + "");
		lblProductname.setText(item.getItem().getName());
	}
	
	public void initialize() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblProductname = new JLabel("ProductName");
		add(lblProductname);
		
		lblAmount = new JLabel("Amount");
		add(lblAmount);
		
		lblPrice = new JLabel("Pris");
		add(lblPrice);
	}

	public JLabel getProductName() {
		return lblProductname;
	}
	public JLabel getAmount() {
		return lblAmount;
	}
	public JLabel getPrice() {
		return lblPrice;
	}
}
