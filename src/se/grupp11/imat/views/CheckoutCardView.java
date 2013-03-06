package se.grupp11.imat.views;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JButton;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.grupp11.imat.controllers.CheckOutController;

public class CheckoutCardView extends JPanel {

	CheckOutController al = CheckOutController.getInstance();
	
	/**
	 * Create the panel.
	 */
	public CheckoutCardView() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
		
		JLabel lblCardInformation = new JLabel("Card information");
		add(lblCardInformation, "2, 2");
		
		JButton btnEditDetails = new JButton("Edit Details");
		add(btnEditDetails, "6, 2");
		btnEditDetails.addActionListener(al);
		btnEditDetails.setActionCommand("settings");
		
		
		if(IMatDataHandler.getInstance().isCustomerComplete()){
			JLabel lblName = new JLabel(IMatDataHandler.getInstance().getCustomer().getFirstName() + " " + IMatDataHandler.getInstance().getCustomer().getFirstName());
			add(lblName, "4, 4");
		}else{
			JLabel lblYouHavntAdded = new JLabel("You havn't added any card details.");
			add(lblYouHavntAdded, "4, 6");
		}
		

	}
	

}
