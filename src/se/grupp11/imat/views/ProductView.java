package se.grupp11.imat.views;

import java.awt.Dimension;

import javax.swing.JPanel;

import se.chalmers.ait.dat215.project.Product;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;

public class ProductView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProductView(Product product) {

		
		setMaximumSize(new Dimension(680, 1200));
		setMinimumSize(new Dimension(680, 1200));
		setLayout(null);
		
		JPanel westPanel = new JPanel();
		westPanel.setBounds(48, 150, 182, 354);
		add(westPanel);
		westPanel.setLayout(null);
		
		JLabel label = new JLabel("BILD");
		label.setBounds(20, 17, 120, 141);
		westPanel.add(label);
		
		JLabel lblOrgin = new JLabel("Svergie");
		lblOrgin.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblOrgin.setBounds(20, 234, 61, 16);
		westPanel.add(lblOrgin);
		
		JLabel lblPris = new JLabel("Pris: ");
		lblPris.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPris.setBounds(20, 262, 61, 16);
		westPanel.add(lblPris);
		
		JLabel lblHead = new JLabel("Rubrik");
		lblHead.setBounds(123, 39, 523, 58);
		add(lblHead);
		
	}
}
