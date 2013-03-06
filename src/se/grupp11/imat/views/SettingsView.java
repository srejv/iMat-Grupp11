package se.grupp11.imat.views;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.text.*;
import se.grupp11.imat.controllers.SettingsController;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class SettingsView extends JPanel {
	private static JTextField textFieldFirstName;
	private static JTextField textFieldLastName;
	private static JTextField textFieldAdress;
	private static JTextField textFieldPostalCode;
	private static JTextField textFieldCity;
	private static JTextField textFieldEmail;
	private static JTextField textFieldCellphone;
	private static JTextField card1;
	private static JTextField card2;
	private static JTextField card3;
	private static JTextField card4;

	/**
	 * Create the panel.
	 */
	public SettingsView() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("140px"),
				ColumnSpec.decode("320px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
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
		
		JLabel lblSettingsTitle = new JLabel("Inställningar");
		lblSettingsTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		add(lblSettingsTitle, "1, 2, 1, 2, default, top");
		
		JLabel lblFirstName = new JLabel("Förnamn");
		add(lblFirstName, "1, 6, right, default");
		
		textFieldFirstName = new JTextField();
		add(textFieldFirstName, "2, 6, fill, default");
		textFieldFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Efternamn");
		add(lblLastName, "1, 8, right, default");
		
		textFieldLastName = new JTextField();
		add(textFieldLastName, "2, 8, fill, default");
		textFieldLastName.setColumns(10);
		
		JLabel lblAdress = new JLabel("Address");
		add(lblAdress, "1, 10, right, default");
		
		textFieldAdress = new JTextField();
		add(textFieldAdress, "2, 10, fill, default");
		textFieldAdress.setColumns(10);
		
		JLabel lblPostalCode = new JLabel("Postnummer");
		add(lblPostalCode, "1, 12, right, default");
		
		textFieldPostalCode = new JTextField();
		add(textFieldPostalCode, "2, 12, fill, default");
		textFieldPostalCode.setColumns(10);
		
		JLabel lblCity = new JLabel("Stad");
		add(lblCity, "1, 14, right, default");
		
		textFieldCity = new JTextField();
		add(textFieldCity, "2, 14, fill, default");
		textFieldCity.setColumns(10);
		
		JLabel lblEmail = new JLabel("El-post");
		add(lblEmail, "1, 18, right, default");
		
		textFieldEmail = new JTextField();
		add(textFieldEmail, "2, 18, fill, default");
		textFieldEmail.setColumns(10);
		
		JLabel lblDinepostse = new JLabel("din@epost.se");
		lblDinepostse.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		add(lblDinepostse, "4, 18");
		
		JLabel lblCellphone = new JLabel("Mobiltelefon");
		add(lblCellphone, "1, 20, right, default");
		
		textFieldCellphone = new JTextField();
		add(textFieldCellphone, "2, 20, fill, default");
		textFieldCellphone.setColumns(10);
		
		JLabel label = new JLabel("0703121212");
		label.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		add(label, "4, 20");
		
		JLabel lblCardNumber = new JLabel("Kortnummer");
		add(lblCardNumber, "1, 24, right, default");
		
		JPanel panel = new JPanel();
		add(panel, "2, 24, fill, fill");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		PlainDocument[] pd = new PlainDocument[4];
		for(int i = 0; i<4; i++){
			pd[i] = new PlainDocument(){
				final int limit = 4;
			    @Override
			    public void insertString(int offs, String str, AttributeSet a)
			            throws BadLocationException {
			        if(getLength() + str.length() <= limit)
			            super.insertString(offs, str, a);
			    }
			};
		}
		
		card1 = new JTextField();
		card1.setDocument(pd[0]);
		panel.add(card1);
		card1.setColumns(4);
		
		card2 = new JTextField();
		card2.setDocument(pd[1]);
		panel.add(card2);
		card2.setColumns(4);
		
		card3 = new JTextField();
		card3.setDocument(pd[2]);
		panel.add(card3);
		card3.setColumns(4);
		
		card4 = new JTextField();
		card4.setDocument(pd[3]);
		panel.add(card4);
		card4.setColumns(4);
		
		JButton btnSave = new JButton("Spara");
		add(btnSave, "2, 28, right, default");
		btnSave.addActionListener(new SettingsController());

	}
	
	
	public static String getFirstName(){
		return textFieldFirstName.getText();
		
	}
	public static String getLastName(){
		return textFieldLastName.getText();
		
	}
	public static String getAdress(){
		return textFieldAdress.getText();
		
	}
	public static String getPostCode(){
		try{
			Integer.parseInt(textFieldPostalCode.getText());
			return textFieldPostalCode.getText();
		}catch(NumberFormatException e){
			return null;
		}
		
	}
	public static String getCity(){
		return textFieldCity.getText();
		
	}
	public static String getEmail(){
		return textFieldEmail.getText();
		
	}
	public static String getCellPhone(){
		try{
			Integer.parseInt(textFieldCellphone.getText());
			return textFieldCellphone.getText();
		}catch(NumberFormatException e){
			return null;
		}
		
	}
	public static String getCardNumber(){
		try{
			
			String cardNbr = card1.getText() + card2.getText() + card3.getText() + card4.getText();
			Long.parseLong(cardNbr);
			return cardNbr;
		}catch(NumberFormatException e){
			return null;
		}
	}

}
