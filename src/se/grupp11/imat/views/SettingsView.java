package se.grupp11.imat.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class SettingsView extends JPanel {
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldAdress;
	private JTextField textFieldPostalCode;
	private JTextField textFieldCity;
	private JTextField textFieldEmail;
	private JTextField textFieldCellphone;
	private JTextField textFieldCardNumber;

	/**
	 * Create the panel.
	 */
	public SettingsView() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("140px"),
				ColumnSpec.decode("51px:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("16px"),
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblSettingsTitle = new JLabel("Settings");
		lblSettingsTitle.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		add(lblSettingsTitle, "1, 2, 1, 2, left, top");
		
		JLabel lblFirstName = new JLabel("First name");
		add(lblFirstName, "1, 6, right, default");
		
		textFieldFirstName = new JTextField();
		add(textFieldFirstName, "2, 6, fill, default");
		textFieldFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last name");
		add(lblLastName, "1, 8, right, default");
		
		textFieldLastName = new JTextField();
		add(textFieldLastName, "2, 8, fill, default");
		textFieldLastName.setColumns(10);
		
		JLabel lblAdress = new JLabel("Adress");
		add(lblAdress, "1, 10, right, default");
		
		textFieldAdress = new JTextField();
		add(textFieldAdress, "2, 10, fill, default");
		textFieldAdress.setColumns(10);
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		add(lblPostalCode, "1, 12, right, default");
		
		textFieldPostalCode = new JTextField();
		add(textFieldPostalCode, "2, 12, fill, default");
		textFieldPostalCode.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		add(lblCity, "1, 14, right, default");
		
		textFieldCity = new JTextField();
		add(textFieldCity, "2, 14, fill, default");
		textFieldCity.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "1, 18, right, default");
		
		textFieldEmail = new JTextField();
		add(textFieldEmail, "2, 18, fill, default");
		textFieldEmail.setColumns(10);
		
		JLabel lblCellphone = new JLabel("Cellphone");
		add(lblCellphone, "1, 20, right, default");
		
		textFieldCellphone = new JTextField();
		add(textFieldCellphone, "2, 20, fill, default");
		textFieldCellphone.setColumns(10);
		
		JLabel lblCardNumber = new JLabel("Card number");
		add(lblCardNumber, "1, 24, right, default");
		
		textFieldCardNumber = new JTextField();
		add(textFieldCardNumber, "2, 24, fill, default");
		textFieldCardNumber.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		add(btnSave, "2, 28");

	}

}
