package se.grupp11.imat.views;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import se.chalmers.ait.dat215.project.Product;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.JSpinner;

public class ProductView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProductView(Product product) {

		
		setMaximumSize(new Dimension(680, 1200));
		setMinimumSize(new Dimension(680, 1200));
		setLayout(null);
		
		JPanel westPanel = new JPanel();
		westPanel.setBorder(null);
		westPanel.setBounds(48, 373, 220, 156);
		add(westPanel);
		westPanel.setLayout(null);
		
		JLabel lblUrsprungSverige = new JLabel("Ursprung: Sverige");
		lblUrsprungSverige.setBounds(32, 37, 138, 16);
		westPanel.add(lblUrsprungSverige);
		
		JLabel lblPrist = new JLabel("Pris: " + product.getPrice() + "kr");
		lblPrist.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		lblPrist.setBounds(32, 65, 138, 37);
		westPanel.add(lblPrist);
		
		JLabel lblHead = new JLabel(product.getName());
		lblHead.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblHead.setBounds(48, 6, 523, 58);
		add(lblHead);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setBorder(null);
		eastPanel.setBounds(383, 76, 341, 453);
		add(eastPanel);
		eastPanel.setLayout(null);
		
		JLabel lblIngridienser = new JLabel("<html><p><b>Ingridienser:</b> Socker, kakaosmör, skummjölkspulver, kakaomassa, smörfett, vasslepulver, emulgeringsmedel (sojalecitin), arom. Minst 30% kakao. Kan innehålla spår av mandel, nötter, ägg och vete.</p></html>\n");
		lblIngridienser.setBounds(6, 80, 329, 106);
		eastPanel.add(lblIngridienser);
		
		JLabel lblProduktinformationMjlkchokladFrn = new JLabel("<html><p> <b>Produktinformation: </b>Mjölkchoklad från Marabou </p></html> ");
		lblProduktinformationMjlkchokladFrn.setBounds(6, 6, 370, 33);
		eastPanel.add(lblProduktinformationMjlkchokladFrn);
		
		JLabel lblNewLabel = new JLabel("<html><b> Näringsvärde per 100g </br></b><table width=\"400\"   >\n<tr><td> Energi: </td><td> 207kJ </td></tr><tr><td> Energi: </td><td> 49kcal </td></tr><tr><td> Protein: </td><td> 8g </td></tr><tr><td> Fett: </td><td> 4.1g </td></tr><tr><td> Kolhydrater: </td><td> 38g </td></tr><tr><td> Fibrer: </td><td> 8g </td></tr><tr><td> D-vitamin: </td><td> 4mg </td></tr><tr><td> D-vitamin: </td><td> 8mg </td></tr><tr><td> Folat: </td><td> 9mg</td></tr><tr><td> Kalcium: </td><td> 0.1mg </td></tr> </html>");
		lblNewLabel.setBounds(6, 204, 309, 243);
		eastPanel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(48, 76, 250, 250);
		add(label);
		
		JButton btnNewButton = new JButton("Lägg till i Kundvagnen >>\n\n");
		btnNewButton.setBounds(621, 28, 203, 29);
		add(btnNewButton);
		
		label.setIcon(new ImageIcon(((new ImageIcon("/Users/Markus/.dat215/imat/images/" + product.getImageName())).getImage()).getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH)));
		
		this.setBackground(new Color(255,250,250));
		westPanel.setOpaque(false);
		eastPanel.setOpaque(false);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(556, 28, 37, 28);
		add(spinner);
		
		JLabel lblSt = new JLabel("st");
		lblSt.setBounds(596, 33, 25, 16);
		add(lblSt);
		
		
		
	}
}
