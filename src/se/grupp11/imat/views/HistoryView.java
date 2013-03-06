package se.grupp11.imat.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import java.awt.Font;

public class HistoryView extends JPanel {
	private JTable table;
	private Object[][] model;
	private java.util.List<Order> ordersList;
	private JLabel lblHistory;

	/**
	 * Create the panel.
	 */
	public HistoryView() {
		setLayout(new BorderLayout(0, 0));

		setMaximumSize(new Dimension(680, 1200));
		setMinimumSize(new Dimension(680, 1200));

		setBackground(new Color(255, 250, 250));

		lblHistory = new JLabel("Tidigare Köp");
		lblHistory.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(lblHistory, BorderLayout.NORTH);

		IMatDataHandler handler = IMatDataHandler.getInstance();
		JList list = new JList();

		ordersList = handler.getOrders();

		model = new String[ordersList.size()][2];

		ordersList = IMatDataHandler.getInstance().getOrders();
		
		for (int i = 0; i < ordersList.size(); i++) {
			model[i][0] = ordersList.get(i).getDate().toString();
			model[i][1] = "" + ordersList.get(i).getOrderNumber();
		}
		Object[] names = { "Datum", "OrderNr" };

		table = new JTable((Object[][]) (model), names);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(table, BorderLayout.CENTER);
		
	}

	public void updateView() {		
		ordersList = IMatDataHandler.getInstance().getOrders();
		
		for (int i = 0; i < ordersList.size(); i++) {
			model[i][0] = ordersList.get(i).getDate().toString();
			model[i][1] = "" + ordersList.get(i).getOrderNumber();
		}
		this.remove(table);
		
		Object[] names = { "Datum", "OrderNr" };

		table = new JTable((Object[][]) (model), names);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(table, BorderLayout.CENTER);
		
		this.updateUI();
	}

}
