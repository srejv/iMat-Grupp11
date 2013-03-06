package se.grupp11.imat.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;

import javax.swing.JPanel;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class ReceiptView extends JPanel {
	
	

	/**
	 * Create the panel.
	 */
	public ReceiptView(int orderNbr) {
		
		System.out.println("Recept skapat");

		
		// Formating
		setMaximumSize(new Dimension(680, 1200));
		setMinimumSize(new Dimension(680, 1200));
		this.setBackground(new Color(255,250,250));
		setLayout(null);
		

		
		// Getting the order
		java.util.List<Order> ordersList = IMatDataHandler.getInstance().getOrders();
		Order order=new Order();
		for(Order tmp: ordersList){
			if(tmp.getOrderNumber()==orderNbr)
				order=tmp;
		}
		
		
		// Setting List of items
		int size=order.getItems().size();
		String[] valuesString = new String[size];
		for(int i=0; i < size; i++){
			valuesString[i]=order.getItems().get(i).getAmount() + " st " + order.getItems().get(i).getProduct().getName() ;
		}
		
		final String[] valuesFinal=valuesString;
		
		
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 13));
		list.setBackground(Color.WHITE);
		list.setModel(new AbstractListModel() {
			String[] values=valuesFinal;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		list.setBounds(25, 140, 216, 349);
		add(list);
		
		JLabel lblOrder = new JLabel("Order: " + order.getOrderNumber() + " skickad den " + order.getDate().getDay() + "/" + order.getDate().getMonth() + "  "+ order.getDate().getYear());
		lblOrder.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblOrder.setBounds(25, 40, 628, 75);
		add(lblOrder);
		
		JLabel lblStatusLevererad = new JLabel("<html>Status: <b>Levererad</b></html>");
		lblStatusLevererad.setBounds(271, 473, 130, 16);
		add(lblStatusLevererad);
		
		CheckoutAdressView checkoutAdressView = new CheckoutAdressView();
		checkoutAdressView.setBorder(new LineBorder(new Color(0, 0, 0)));
		checkoutAdressView.setBounds(253, 188, 484, 140);
		checkoutAdressView.updateAdressCard();
		add(checkoutAdressView);
		
		JLabel lblLevereatTill = new JLabel("Levereat till:");
		lblLevereatTill.setBounds(271, 167, 95, 16);
		add(lblLevereatTill);
		

	}
}
