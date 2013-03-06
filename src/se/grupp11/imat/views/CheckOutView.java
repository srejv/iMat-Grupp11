/**
 * 
 */
package se.grupp11.imat.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import se.grupp11.imat.controllers.CheckOutController;

/**
 * @author Hampus Forsvall, forzvall@gmail.com
 *
 */
public class CheckOutView extends JPanel{
	CheckOutController cOC = CheckOutController.getInstance();
	public CheckOutView() {
		setLayout(null);
		setSize(680,1200);
		setMaximumSize(getSize());
		
		CheckoutAdressView checkoutAdressView = new CheckoutAdressView();
		checkoutAdressView.setBounds(9, 6, 464, 150);
		add(checkoutAdressView);
		
		CheckoutCardView checkoutCardView = new CheckoutCardView();
		checkoutCardView.setBounds(9, 168, 497, 130);
		add(checkoutCardView);
		
		DeliverTimeView deliverTimeView = new DeliverTimeView();
		deliverTimeView.setOpaque(false);
		deliverTimeView.setPreferredSize(new Dimension(500, 230));
		deliverTimeView.setSize(new Dimension(500, 230));
		deliverTimeView.setBounds(6, 388, 500, 230);
		add(deliverTimeView);
		
		JButton btnNewButton = new JButton("Slutför Köp");
		btnNewButton.setActionCommand("checkout");
		btnNewButton.addActionListener(cOC);
		btnNewButton.setBounds(376, 601, 207, 43);
		add(btnNewButton);
	}

	public static void updateView(){
		CheckoutAdressView.updateAdressCard();
		CheckoutCardView.updateCardView();
	}
}
