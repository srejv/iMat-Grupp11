/**
 * 
 */
package se.grupp11.imat.views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import se.grupp11.imat.controllers.CheckOutController;
import java.awt.FlowLayout;

/**
 * @author Hampus Forsvall, forzvall@gmail.com
 *
 */
public class CheckOutView extends JPanel{
	CheckOutController cOC = CheckOutController.getInstance();
	public CheckOutView() {
		setLayout(null);
		setSize(730,1200);
		setMaximumSize(getSize());
		
		DeliverTimeView deliverTimeView = new DeliverTimeView();
		deliverTimeView.setOpaque(false);
		deliverTimeView.setPreferredSize(new Dimension(500, 230));
		deliverTimeView.setSize(new Dimension(500, 230));
		deliverTimeView.setBounds(9, 361, 500, 177);
		add(deliverTimeView);
		
		JButton btnNewButton = new JButton("Slutför Köp");
		btnNewButton.setActionCommand("checkout");
		btnNewButton.addActionListener(cOC);
		btnNewButton.setBounds(517, 495, 207, 43);
		add(btnNewButton);
		
		JButton settingsBtn = new JButton("Ändra");
		settingsBtn.addActionListener(CheckOutController.getInstance());
		settingsBtn.setActionCommand("settings");
		settingsBtn.setBounds(389, 310, 117, 29);
		add(settingsBtn);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setBounds(9, 6, 500, 345);
		panel.setBackground(new Color(255,250,250));
		add(panel);
		panel.setLayout(null);
		
		CheckoutCardView checkoutCardView = new CheckoutCardView();
		checkoutCardView.setBounds(6, 158, 484, 102);
		CheckoutCardView.updateCardView();
		panel.add(checkoutCardView);
		
		CheckoutAdressView checkoutAdressView = new CheckoutAdressView();
		checkoutAdressView.setBounds(6, 6, 484, 140);
		CheckoutAdressView.updateAdressCard();
		panel.add(checkoutAdressView);
		
		
	}

	public static void updateView(){
		CheckoutAdressView.updateAdressCard();
		CheckoutCardView.updateCardView();
	}
}
