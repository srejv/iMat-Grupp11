package se.grupp11.imat.views;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.grupp11.imat.controllers.CheckOutController;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;

public class CheckoutAdressView extends JPanel {

	CheckOutController al = CheckOutController.getInstance();
	static Customer c = IMatDataHandler.getInstance().getCustomer();
	
	private static JLabel name;
	private static JLabel adress;
	private static JLabel email;
	private static JLabel postcode;
	private static JLabel phone;
	private static JLabel lblYouHavntFilled;
	private static JLabel nameTitle;
	private static JLabel adressTitle;
	private static JLabel emailTitle;
	private static JLabel postcodeTitle;
	private static JLabel phoneTitle;
	
	/**
	 * Create the panel.
	 */
	public CheckoutAdressView() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("25px"),
				ColumnSpec.decode("80px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("223px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("116px"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		name = new JLabel("");
		email = new JLabel("");
		postcode = new JLabel("");
		phone = new JLabel("");
		adress = new JLabel("");
		nameTitle = new JLabel("");
		emailTitle = new JLabel("");
		postcodeTitle = new JLabel("");
		phoneTitle = new JLabel("");
		adressTitle = new JLabel("");
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		add(lblAddress, "2, 2, left, center");
		
		JButton btnEditDetails = new JButton("Ändra");
		add(btnEditDetails, "6, 2, left, top");
		btnEditDetails.addActionListener(al);
		btnEditDetails.setActionCommand("settings");
		
		lblYouHavntFilled = new JLabel("Du har inte fyllt i dina uppgifter!");
		lblYouHavntFilled.setForeground(Color.RED);
		add(lblYouHavntFilled, "4, 6, left, center");
		
		add(name, "4, 4, left, center");
		add(email, "4, 6, left, center");
		add(adress, "4, 8, left, center");
		add(postcode, "4, 10, left, center");
		add(phone, "4, 12, left, center");
		
		add(nameTitle, "2, 4, right, center");
		add(emailTitle, "2, 6, right, center");
		add(adressTitle, "2, 8, right, center");
		add(postcodeTitle, "2, 10, right, center");
		add(phoneTitle, "2, 12, right, center");
		
	}
	
	public static void updateAdressCard(){
		name.setText(c.getFirstName() + " " + c.getLastName());
		adress.setText(c.getAddress());
		email.setText(c.getEmail());
		postcode.setText(c.getPostCode());
		phone.setText(c.getPhoneNumber());
		
		nameTitle.setText("Namn:");
		adressTitle.setText("Adress:");
		emailTitle.setText("Email:");
		postcodeTitle.setText("Postkod:");
		phoneTitle.setText("Tel.nr:");
		lblYouHavntFilled.setText("");
	}

}
