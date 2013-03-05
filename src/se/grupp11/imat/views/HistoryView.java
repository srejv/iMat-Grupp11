package se.grupp11.imat.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;

import java.awt.BorderLayout;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.AbstractListModel;

public class HistoryView extends JPanel {

	/**
	 * Create the panel.
	 */
	public HistoryView() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblHistory = new JLabel("Tidigare Köp");
		add(lblHistory, BorderLayout.NORTH);
		
		IMatDataHandler handler = IMatDataHandler.getInstance();
		JList list = new JList();
		
		java.util.List<Order> ordersList=handler.getOrders();
		
		String[] arr=null;
		
		
		for(int i=0; i<ordersList.size(); i++){
			//arr[i]=((Order)ordersList.get(i))).getOrderNumber();
		}
		
		//add(ordersList, BorderLayout.CENTER);
		

		
		

			
		

	}

}
