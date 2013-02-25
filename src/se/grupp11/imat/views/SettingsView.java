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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		
		JLabel lblNewLabel = new JLabel("Settings");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		add(lblNewLabel, "1, 2, 1, 2, left, top");
		
		JLabel lblNewLabel_1 = new JLabel("First name");
		add(lblNewLabel_1, "1, 6, right, default");
		
		textField = new JTextField();
		add(textField, "2, 6, fill, default");
		textField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last name");
		add(lblLastName, "1, 8, right, default");
		
		textField_1 = new JTextField();
		add(textField_1, "2, 8, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Adress");
		add(lblNewLabel_2, "1, 10, right, default");
		
		textField_2 = new JTextField();
		add(textField_2, "2, 10, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Postal Code");
		add(lblNewLabel_3, "1, 12, right, default");
		
		textField_3 = new JTextField();
		add(textField_3, "2, 12, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		add(lblCity, "1, 14, right, default");
		
		textField_4 = new JTextField();
		add(textField_4, "2, 14, fill, default");
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		add(lblNewLabel_4, "1, 18, right, default");
		
		textField_5 = new JTextField();
		add(textField_5, "2, 18, fill, default");
		textField_5.setColumns(10);
		
		JLabel lblCellphone = new JLabel("Cellphone");
		add(lblCellphone, "1, 20, right, default");
		
		textField_6 = new JTextField();
		add(textField_6, "2, 20, fill, default");
		textField_6.setColumns(10);
		
		JLabel lblCardNumber = new JLabel("Card number");
		add(lblCardNumber, "1, 24, right, default");
		
		textField_7 = new JTextField();
		add(textField_7, "2, 24, fill, default");
		textField_7.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		add(btnSave, "2, 28");

	}

}
