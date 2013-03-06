package se.grupp11.imat.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import se.chalmers.ait.dat215.project.ShoppingItem;
import se.grupp11.imat.controllers.ShoppingCartController;

public class ShoppingCartView extends JPanel{
	ShoppingCartController scc = ShoppingCartController.getInstance();
	private static JList list;
	public ShoppingCartView() {
		setPreferredSize(new Dimension(200, 680));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(50, 50));
		add(panel);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(50, 100));
		panel.add(scrollPane);
		
		JList list = new JList();
		scrollPane.add(list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(50, 50));
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		
		JButton button = new JButton("Rensa");
		button.setActionCommand("erase");
		panel_1.add(button);
		button.addActionListener(scc);
		
		JButton button_1 = new JButton("Till Kassan");
		button_1.setActionCommand("buy");
		panel_1.add(button_1);
		button_1.addActionListener(scc);
	}
	
	public static void updateCart(ShoppingItem[] si){
		if(si != null) list.setListData(si);
	}

}
