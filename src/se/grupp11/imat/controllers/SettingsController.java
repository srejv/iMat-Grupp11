package se.grupp11.imat.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.grupp11.imat.MainWindow;
import se.grupp11.imat.views.CheckOutView;
import se.grupp11.imat.views.CheckoutAdressView;
import se.grupp11.imat.views.SettingsView;

public class SettingsController implements ActionListener {

	IMatDataHandler imdh = IMatDataHandler.getInstance();
	Customer c = imdh.getCustomer();

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String firstName = SettingsView.getFirstName();
		String lastName = SettingsView.getLastName();
		String adress = SettingsView.getAdress();
		String city = SettingsView.getCity();
		String email = SettingsView.getEmail();
		String cardNumber = SettingsView.getCardNumber();
		String cellPhone = SettingsView.getCellPhone();
		String postCode = SettingsView.getPostCode();
		if(	firstName == null ||
			lastName == null ||
			adress == null ||
			city == null ||
			email == null ||
			cardNumber == null ||
			cellPhone == null ||
			postCode == null){
			
			JOptionPane.showMessageDialog(null, "Please enter all fields!");
		}else{
			
			//TODO: Finns det fler saker att lägga i customer?
			c.setFirstName(firstName);
			c.setAddress(adress);
			c.setEmail(email);
			c.setLastName(lastName);
			c.setMobilePhoneNumber(cellPhone);
			c.setPostCode(postCode);
			imdh.getCreditCard().setCardNumber(cardNumber);
			
			CheckOutView.updateView();
			JOptionPane.showMessageDialog(null, "Inställningar Sparades!");
			
			
			MainWindow.setCard("StartPage");
		}
		
	}
}
