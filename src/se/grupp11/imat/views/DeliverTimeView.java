package se.grupp11.imat.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DeliverTimeView extends JPanel {

	/**
	 * Create the panel.
	 */
	public DeliverTimeView() {
		setSize(new Dimension(400, 200));
		setLayout(null);
		
		this.setBackground(new Color(255,250,250));
		JPanel panel = new JPanel();
		panel.setBounds(6, 122, 390, 33);
		panel.setBackground(new Color(255,250,250));
		add(panel);
		
		
		JRadioButton radioButton = new JRadioButton("12-16");
		radioButton.setSelected(true);
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
		panel_1.setBounds(6, 25, 390, 89);
		
		panel_1.setBackground(new Color(255,250,250));
		
		ButtonGroup bg1 = new ButtonGroup();
		
		bg1.add(radioButton);
		bg1.add(radioButton_1);
		bg1.add(radioButton_2);
		bg1.add(radioButton_3);
		bg1.add(rdbtnNewRadioButton_1);
		
		add(panel_1);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Torsdag");
		rdbtnNewRadioButton.setSelected(true);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnToday = new JRadioButton("Fredag");
		panel_1.add(rdbtnToday);
		
		JRadioButton rdbtnToday_1 = new JRadioButton("Måndag");
		panel_1.add(rdbtnToday_1);
		
		JRadioButton rdbtnToday_2 = new JRadioButton("Tisdag");
		panel_1.add(rdbtnToday_2);
		
		JRadioButton rdbtnToday_3 = new JRadioButton("Onsdag");
		panel_1.add(rdbtnToday_3);
		
		JRadioButton rdbtnToday_4 = new JRadioButton("Torsdag");
		panel_1.add(rdbtnToday_4);
		
		JRadioButton rdbtnToday_5 = new JRadioButton("Fredag");
		panel_1.add(rdbtnToday_5);
		
		ButtonGroup bg2 = new ButtonGroup();
		
		bg2.add(rdbtnNewRadioButton);
		bg2.add(rdbtnToday);
		bg2.add(rdbtnToday_1);
		bg2.add(rdbtnToday_2);
		bg2.add(rdbtnToday_3);
		bg2.add(rdbtnToday_4);
		bg2.add(rdbtnToday_5);
		
		JLabel lblDeliveryTime = new JLabel("Leveranstid");
		lblDeliveryTime.setBounds(6, 6, 91, 19);
		add(lblDeliveryTime);
		lblDeliveryTime.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		
		

	}

}
