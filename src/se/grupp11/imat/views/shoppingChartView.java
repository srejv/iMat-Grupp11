package se.grupp11.imat.views;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class shoppingChartView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public shoppingChartView() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Till kassan! >>\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(38, 341, 117, 43);
		add(btnNewButton);
		
		JLabel lblSumma = new JLabel("SUMMA");
		lblSumma.setBounds(38, 269, 61, 16);
		add(lblSumma);
		
		JLabel label = new JLabel("945:-");
		label.setBounds(116, 269, 61, 16);
		add(label);
		
		JButton btnSparaSomLista = new JButton("Spara som lista");
		btnSparaSomLista.setBounds(38, 297, 117, 43);
		add(btnSparaSomLista);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 19, 184, 237);
		add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Potatis", "Mj\u00F6l", "H\u00E4st", "Get", "Taylor-swift-get", "Get", "get", "Get", "ect", "Get", "Gr\u00F6t", "Get", "Potatis", "Get", "sm\u00F6rget", "ostget", "get", "get"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});

	}
}
