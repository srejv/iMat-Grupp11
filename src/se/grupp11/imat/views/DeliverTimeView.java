package se.grupp11.imat.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Dimension;

public class DeliverTimeView extends JPanel {

	/**
	 * Create the panel.
	 */
	public DeliverTimeView() {
		setSize(new Dimension(500, 200));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 107, 390, 33);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 6, 438, 89);
		add(panel_1);
		
		JLabel lblDeliveryTime = new JLabel("Delivery Time");
		panel_1.add(lblDeliveryTime);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Today");
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnToday = new JRadioButton("Today + 1");
		panel_1.add(rdbtnToday);
		
		JRadioButton rdbtnToday_1 = new JRadioButton("Today + 2");
		panel_1.add(rdbtnToday_1);
		
		JRadioButton rdbtnToday_2 = new JRadioButton("Today + 3");
		panel_1.add(rdbtnToday_2);
		
		JRadioButton rdbtnToday_3 = new JRadioButton("Today + 4");
		panel_1.add(rdbtnToday_3);
		
		JRadioButton rdbtnToday_4 = new JRadioButton("Today + 5");
		panel_1.add(rdbtnToday_4);
		
		JRadioButton rdbtnToday_5 = new JRadioButton("Today + 6");
		panel_1.add(rdbtnToday_5);

	}

}
