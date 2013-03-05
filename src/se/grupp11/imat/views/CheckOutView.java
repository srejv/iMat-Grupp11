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
		
		CheckoutAdressView checkoutAdressView = new CheckoutAdressView();
		checkoutAdressView.setBounds(9, 6, 427, 74);
		add(checkoutAdressView);
		
		CheckoutCardView checkoutCardView = new CheckoutCardView();
		checkoutCardView.setBounds(9, 85, 484, 112);
		add(checkoutCardView);
		
		DeliverTimeView deliverTimeView = new DeliverTimeView();
		deliverTimeView.setOpaque(false);
		deliverTimeView.setPreferredSize(new Dimension(500, 300));
		deliverTimeView.setSize(new Dimension(500, 300));
		deliverTimeView.setBounds(6, 200, 500, 200);
		add(deliverTimeView);
		
		JButton btnNewButton = new JButton("Slutför Köp");
		btnNewButton.setActionCommand("checkout");
		btnNewButton.addActionListener(cOC);
		btnNewButton.setBounds(374, 401, 207, 43);
		add(btnNewButton);
	}
}
