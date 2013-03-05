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

public class ListRowItem extends JPanel {
	private JLabel lblProductname;
	private JLabel lblAmount;
	private JLabel lblPrice;	
	private Product prod;
	/**
	 * Create the panel.
	 */
	public ListRowItem(Product p) {
		prod = p;
		initialize();
		updateLabels();
	}
	
	public Product getProduct() {
		return prod;
	}
	
	private void updateLabels() {
		if(prod == null) {
			return;
		}
		
		lblPrice.setText(prod.getPrice() + ":-");
		lblAmount.setText("1");
		lblProductname.setText(prod.getName());
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
