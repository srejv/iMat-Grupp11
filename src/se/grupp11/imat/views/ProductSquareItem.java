package se.grupp11.imat.views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class ProductSquareItem extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4434560229573347151L;

	/**
	 * Create the panel.
	 */
	public ProductSquareItem() {
		setMaximumSize(new Dimension(200, 150));
		setMinimumSize(new Dimension(200, 150));
		setRequestFocusEnabled(false);
		setLayout(null);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setBounds(6, 6, 128, 128);
		add(lblImage);
		
		JLabel lblNamn = new JLabel("Namn");
		lblNamn.setBounds(146, 6, 61, 16);
		add(lblNamn);
		
		JLabel lblPris = new JLabel("Pris");
		lblPris.setBounds(146, 34, 61, 16);
		add(lblPris);
		
		JLabel lblJmfPrisper = new JLabel("Jmf pris (per kilo?)");
		lblJmfPrisper.setBounds(146, 62, 114, 16);
		add(lblJmfPrisper);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(146, 90, 37, 28);
		add(spinner);
		
		setBorder(BorderFactory.createLineBorder(Color.black));

	}
	public Dimension getThisSize() {
		return getSize();
	}
	public void setThisSize(Dimension size) {
		setSize(size);
	}
}
