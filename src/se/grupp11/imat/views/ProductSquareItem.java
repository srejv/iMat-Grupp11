package se.grupp11.imat.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.JSpinner;
import java.awt.Dimension;

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

	}
	public Dimension getThisSize() {
		return getSize();
	}
	public void setThisSize(Dimension size) {
		setSize(size);
	}
}
