package se.grupp11.imat.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

public class CheckoutAdressView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CheckoutAdressView() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("25px"),
				ColumnSpec.decode("51px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("223px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("116px"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("29px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblAddress = new JLabel("Address");
		add(lblAddress, "2, 2, left, center");
		
		JButton btnEditDetails = new JButton("Edit Details");
		add(btnEditDetails, "6, 2, left, top");
		
		JLabel lblYouHavntFilled = new JLabel("You havn't filled in your details yet.");
		add(lblYouHavntFilled, "4, 6, left, center");

	}

}
