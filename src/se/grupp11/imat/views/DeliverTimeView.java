package se.grupp11.imat.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.Font;

public class DeliverTimeView extends JPanel {

	/**
	 * Create the panel.
	 */
	public DeliverTimeView() {
		setSize(new Dimension(500, 200));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 128, 390, 33);
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
		panel_1.setBounds(6, 27, 438, 89);
		add(panel_1);
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Idag");
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnToday = new JRadioButton("Idag + 1");
		panel_1.add(rdbtnToday);
		
		JRadioButton rdbtnToday_1 = new JRadioButton("Idag + 2");
		panel_1.add(rdbtnToday_1);
		
		JRadioButton rdbtnToday_2 = new JRadioButton("Idag + 3");
		panel_1.add(rdbtnToday_2);
		
		JRadioButton rdbtnToday_3 = new JRadioButton("Idag + 4");
		panel_1.add(rdbtnToday_3);
		
		JRadioButton rdbtnToday_4 = new JRadioButton("Idag + 5");
		panel_1.add(rdbtnToday_4);
		
		JRadioButton rdbtnToday_5 = new JRadioButton("Idag + 6");
		panel_1.add(rdbtnToday_5);
		
		
		
		JLabel lblDeliveryTime = new JLabel("Leveranstid");
		lblDeliveryTime.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblDeliveryTime.setBounds(6, 6, 109, 16);
		add(lblDeliveryTime);

	}

}
