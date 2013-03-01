package se.grupp11.imat.views;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class SingleProductView extends JPanel {
	
	
	
	/**
	 * Create the panel.
	 */
	public SingleProductView() {
		
		JLabel lblImage = new JLabel("Image");
		add(lblImage);
		
		JLabel lblName = new JLabel("Name");
		add(lblName);
		
		JLabel lblJmfPris = new JLabel("Jmf pris");
		add(lblJmfPris);

	}

}
