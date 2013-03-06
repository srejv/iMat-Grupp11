package se.grupp11.imat.views;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;

import se.chalmers.ait.dat215.project.Product;
import se.grupp11.imat.controllers.ShoppingCartController;
import se.grupp11.imat.models.ShoppingListItem;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductView extends JPanel {

	
	JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));
	
	/**
	 * Create the panel.
	 */
	public ProductView(final Product product) {
		spinner.setValue(1);
		
		setMaximumSize(new Dimension(680, 1200));
		setMinimumSize(new Dimension(680, 1200));
		setLayout(null);
		
		JPanel westPanel = new JPanel();
		westPanel.setBorder(null);
		westPanel.setBounds(48, 373, 220, 156);
		add(westPanel);
		westPanel.setLayout(null);
		
		JLabel lblUrsprungSverige = new JLabel("Ursprung: Sverige");
		lblUrsprungSverige.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUrsprungSverige.setBounds(32, 37, 138, 16);
		westPanel.add(lblUrsprungSverige);
		
		JLabel lblPrist = new JLabel("Pris: " + product.getPrice() + "kr");
		lblPrist.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrist.setBounds(32, 65, 138, 37);
		westPanel.add(lblPrist);
		
		JLabel lblHead = new JLabel(product.getName());
		lblHead.setFont(new Font("Georgia", Font.BOLD, 30));
		lblHead.setBounds(47, 6, 448, 58);
		add(lblHead);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setBorder(null);
		eastPanel.setBounds(383, 76, 341, 453);
		add(eastPanel);
		eastPanel.setLayout(null);
		
		JLabel lblIngridienser = new JLabel("<html><p><b>Ingridienser:</b> Socker, kakaosmör, skummjölkspulver, kakaomassa, smörfett, vasslepulver, emulgeringsmedel (sojalecitin), arom. Minst 30% kakao. Kan innehålla spår av mandel, nötter, ägg och vete.</p></html>\n");
		lblIngridienser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngridienser.setBounds(6, 80, 329, 106);
		eastPanel.add(lblIngridienser);
		
		JLabel lblProduktinformationMjlkchokladFrn = new JLabel("<html><p> <b>Produktinformation: </b>Mjölkchoklad från Marabou </p></html> ");
		lblProduktinformationMjlkchokladFrn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProduktinformationMjlkchokladFrn.setBounds(6, 6, 370, 33);
		eastPanel.add(lblProduktinformationMjlkchokladFrn);
		
		JLabel lblNewLabel = new JLabel("<html><b> Näringsvärde per 100g </br></b><table width=\"400\"   >\n<tr><td> Energi: </td><td> 207kJ </td></tr><tr><td> Energi: </td><td> 49kcal </td></tr><tr><td> Protein: </td><td> 8g </td></tr><tr><td> Fett: </td><td> 4.1g </td></tr><tr><td> Kolhydrater: </td><td> 38g </td></tr><tr><td> Fibrer: </td><td> 8g </td></tr><tr><td> D-vitamin: </td><td> 4mg </td></tr><tr><td> D-vitamin: </td><td> 8mg </td></tr><tr><td> Folat: </td><td> 9mg</td></tr><tr><td> Kalcium: </td><td> 0.1mg </td></tr> </html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(6, 204, 309, 243);
		eastPanel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(48, 76, 250, 250);
		add(label);
		
		JButton btnNewButton = new JButton("Lägg till i Kundvagnen >>\n\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product p = product;
				int amount = Integer.parseInt(spinner.getValue().toString());
				ShoppingListItem i = new ShoppingListItem(p, amount);
				ShoppingCartController.getInstance().addItem(i);
				ShoppingCartController.getInstance().getShoppingCartView().updateUI();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(556, 28, 220, 29);
		add(btnNewButton);
		
		label.setIcon(new ImageIcon(((new ImageIcon("/Users/Markus/.dat215/imat/images/" + product.getImageName())).getImage()).getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH)));
		
		this.setBackground(new Color(255,250,250));
		westPanel.setOpaque(false);
		eastPanel.setOpaque(false);
		
		
		spinner.setBounds(507, 28, 37, 28);
		add(spinner);
		
		
		
		JLabel lblSt = new JLabel("st");
		lblSt.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblSt.setBounds(545, 33, 25, 16);
		add(lblSt);
		
		
		
	}
}
