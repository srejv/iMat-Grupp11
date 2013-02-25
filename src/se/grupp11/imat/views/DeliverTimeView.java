package se.grupp11.imat.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class DeliverTimeView extends JPanel {

	/**
	 * Create the panel.
	 */
	public DeliverTimeView() {
		
		JLabel lblDeliveryTime = new JLabel("Delivery Time");
		add(lblDeliveryTime);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Today");
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnToday = new JRadioButton("Today + 1");
		add(rdbtnToday);
		
		JRadioButton rdbtnToday_1 = new JRadioButton("Today + 2");
		add(rdbtnToday_1);
		
		JRadioButton rdbtnToday_2 = new JRadioButton("Today + 3");
		add(rdbtnToday_2);
		
		JRadioButton rdbtnToday_3 = new JRadioButton("Today + 4");
		add(rdbtnToday_3);
		
		JRadioButton rdbtnToday_4 = new JRadioButton("Today + 5");
		add(rdbtnToday_4);
		
		JRadioButton rdbtnToday_5 = new JRadioButton("Today + 6");
		add(rdbtnToday_5);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JRadioButton radioButton = new JRadioButton("12-16");
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("13-17");
		panel.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("15-19");
		panel.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("16-22");
		panel.add(radioButton_3);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("18-22");
		panel.add(rdbtnNewRadioButton_1);

	}

}
