package se.grupp11.imat.views;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.chalmers.ait.dat215.project.CreditCard;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.grupp11.imat.controllers.CheckOutController;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import java.awt.Font;

public class CheckoutCardView extends JPanel {

	private CheckOutController al = CheckOutController.getInstance();
	private static CreditCard c = IMatDataHandler.getInstance().getCreditCard();
	private static JLabel lblYouHavntAdded;
	private static JLabel cardTitle;
	private static JLabel cvcTitle;
	private static JLabel card;
	private static JTextField cvcTf;
	
	/**
	 * Create the panel.
	 */
	public CheckoutCardView() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblCardInformation = new JLabel("Kort");
		lblCardInformation.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		add(lblCardInformation, "2, 2");
		
		JButton btnEditDetails = new JButton("Ändra");
		add(btnEditDetails, "6, 2");
		btnEditDetails.addActionListener(al);
		btnEditDetails.setActionCommand("settings");
		
		
		
		cardTitle = new JLabel("");
		cvcTitle = new JLabel("");
		card = new JLabel("");
		
		lblYouHavntAdded = new JLabel("Du har inte anget kortnummer!");
		lblYouHavntAdded.setForeground(Color.RED);
		
		add(lblYouHavntAdded, "4, 6, center, center");
		add(cardTitle, "2, 4, right, center");
		add(cvcTitle, "2, 6, right, center");
		add(card, "4, 4, left, center");
		
		cvcTf = new JTextField();
		add(cvcTf, "4, 6, left, default");
		cvcTf.setColumns(3);
		cvcTf.setVisible(false);

	}
	
	public static void updateCardView(){
		lblYouHavntAdded.setText("");
		cardTitle.setText("Kortnr:");
		cvcTitle.setText("CVC:");
		cvcTf.setVisible(true);
		System.out.println(c.getCardNumber());
		card.setText(c.getCardNumber());
	}
	

}
