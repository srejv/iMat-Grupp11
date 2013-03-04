package se.grupp11.imat.views;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.JSpinner;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import se.chalmers.ait.dat215.project.*;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
public class ProductSquareItem extends JPanel {

	
	private Product item;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4434560229573347151L;

	/**
	 * Create the panel.
	 */
	public ProductSquareItem(Product item) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.RED));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(null);
			}
		});
		setMaximumSize(new Dimension(170, 300));
		setMinimumSize(new Dimension(170, 300));
		setRequestFocusEnabled(false);
		setLayout(null);
		
		this.item=item;
		
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(55, 6, 128, 128);
		add(lblImage);
		
		JLabel lblNamn = new JLabel("Namn: "+ item.getName());
		lblNamn.setBounds(58, 146, 61, 16);
		add(lblNamn);
		
		JLabel lblPris = new JLabel("Pris:" + item.getPrice() + "kr");
		lblPris.setBounds(58, 174, 61, 16);
		add(lblPris);
		
		JLabel lblJmfPrisper = new JLabel("Jmfpris: " );
		lblJmfPrisper.setBounds(58, 202, 114, 16);
		add(lblJmfPrisper);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(55, 239, 44, 36);
		add(spinner);
		
		setBorder(null);
		this.setOpaque(false);
		
		lblImage.setIcon(new ImageIcon(((new ImageIcon(item.getImageName())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		
		JButton btnLggTillI = new JButton("Köp");
		btnLggTillI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLggTillI.setBounds(106, 239, 91, 36);
		add(btnLggTillI);
	}
	public Dimension getThisSize() {
		return getSize();
	}
	public void setThisSize(Dimension size) {
		setSize(size);
	}
}
