package se.grupp11.imat.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;

import javax.swing.JPanel;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;
import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.models.ShoppingListItem;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

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
		
		
		

		
		ShoppingList sList=new ShoppingList();
		for(int i=0; i<order.getItems().size(); i++){
			sList.addItem(new ShoppingListItem(order.getItems().get(i).getProduct(), (int)(order.getItems().get(i).getAmount())));
		}
		ListView listV=new ListView();
		listV.getLblPrice().setBackground(Color.WHITE);
		listV.setBackground(Color.GRAY);
		listV.setShoppingList(sList);
		listV.setBounds(25, 140, 216, 349);
		listV.getList().enable(false);
		listV.getBtnEdit().setVisible(false);
		add(listV);
		
		
		

		
		JLabel lblOrder = new JLabel("Order: " + order.getOrderNumber() + " skickad den " + order.getDate().getDay() + "/" + order.getDate().getMonth() + "  "+ "2013");
		lblOrder.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblOrder.setBounds(25, 40, 628, 75);
		add(lblOrder);
		
		JLabel lblStatusLevererad = new JLabel("<html>Status: <b>Levererad</b></html>");
		lblStatusLevererad.setBounds(271, 473, 130, 16);
		add(lblStatusLevererad);
		
		CheckoutAdressView checkoutAdressView = new CheckoutAdressView();
		checkoutAdressView.setBorder(new LineBorder(new Color(0, 0, 0)));
		checkoutAdressView.setBounds(281, 200, 484, 140);
		checkoutAdressView.updateAdressCard();
		add(checkoutAdressView);
		
		JLabel lblLevereatTill = new JLabel("Levereat till:");
		lblLevereatTill.setBounds(282, 183, 95, 16);
		add(lblLevereatTill);
		
		JButton btnSkrivUt = new JButton("Skriv ut");
		btnSkrivUt.setBounds(450, 468, 117, 29);
		add(btnSkrivUt);
		
		JButton btnSkickaTillMail = new JButton("Skicka till Mail");
		btnSkickaTillMail.setBounds(567, 468, 117, 29);
		add(btnSkickaTillMail);
		
		
		

	}
}
