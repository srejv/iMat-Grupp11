/**
 * 
 */
package se.grupp11.imat.views;

import javax.swing.JPanel;

/**
 * @author Hampus Forsvall, forzvall@gmail.com
 *
 */
public class CheckOutView extends JPanel{
	public CheckOutView() {
		setLayout(null);
		
		CheckoutAdressView checkoutAdressView = new CheckoutAdressView();
		checkoutAdressView.setBounds(9, 6, 427, 74);
		add(checkoutAdressView);
		
		CheckoutCardView checkoutCardView = new CheckoutCardView();
		checkoutCardView.setBounds(9, 85, 484, 112);
		add(checkoutCardView);
	}

}
