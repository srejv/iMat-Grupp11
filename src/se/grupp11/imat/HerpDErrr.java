package se.grupp11.imat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class HerpDErrr {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HerpDErrr window = new HerpDErrr();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HerpDErrr() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextPane txtpnBrev = new JTextPane();
		txtpnBrev.setText("Här skriver du vad du vill ha.");
		frame.getContentPane().add(txtpnBrev, BorderLayout.CENTER);
		
		JButton btnSkrivUt = new JButton("Skriv ut");
		frame.getContentPane().add(btnSkrivUt, BorderLayout.SOUTH);
		
		JLabel lblImat = new JLabel("iMat");
		lblImat.setFont(new Font("PT Sans Caption", Font.BOLD, 39));
		frame.getContentPane().add(lblImat, BorderLayout.NORTH);
	}

}
