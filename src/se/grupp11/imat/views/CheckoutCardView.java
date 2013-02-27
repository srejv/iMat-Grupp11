package se.grupp11.imat.views;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CheckoutCardView extends JPanel {

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
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1px"),},
			new RowSpec[] {
				RowSpec.decode("1px"),}));
		
		JLabel lblCardInformation = new JLabel("Card information");
		add(lblCardInformation, "1, 1, fill, fill");
		
		JButton btnEditDetails = new JButton("Edit Details");
		add(btnEditDetails, "1, 1, fill, fill");
		
		JLabel lblYouHavntAdded = new JLabel("You havn't added any card details.");
		add(lblYouHavntAdded, "1, 1, fill, fill");

	}

}
