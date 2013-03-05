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
import javax.swing.SpringLayout;
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
		setPreferredSize(new Dimension(160, 248));
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
		
		this.item=item;
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		
		JLabel lblImage = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblImage, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblImage, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblImage, -162, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblImage, 138, SpringLayout.WEST, this);
		add(lblImage);
		
		JLabel lblNamn = new JLabel(""+ item.getName());
		springLayout.putConstraint(SpringLayout.NORTH, lblNamn, 6, SpringLayout.SOUTH, lblImage);
		springLayout.putConstraint(SpringLayout.WEST, lblNamn, 0, SpringLayout.WEST, lblImage);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNamn, -130, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNamn, 71, SpringLayout.WEST, this);
		add(lblNamn);
		
		JLabel lblPris = new JLabel("" + item.getPrice() + "kr");
		springLayout.putConstraint(SpringLayout.NORTH, lblPris, 6, SpringLayout.SOUTH, lblNamn);
		springLayout.putConstraint(SpringLayout.WEST, lblPris, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPris, -108, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblPris, 0, SpringLayout.EAST, lblNamn);
		add(lblPris);
		
		JLabel lblJmfPrisper = new JLabel("Jmfpris: " );
		springLayout.putConstraint(SpringLayout.NORTH, lblJmfPrisper, 6, SpringLayout.SOUTH, lblPris);
		springLayout.putConstraint(SpringLayout.WEST, lblJmfPrisper, 0, SpringLayout.WEST, lblImage);
		springLayout.putConstraint(SpringLayout.SOUTH, lblJmfPrisper, -86, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblJmfPrisper, -14, SpringLayout.EAST, lblImage);
		add(lblJmfPrisper);
		
		JSpinner spinner = new JSpinner();
		springLayout.putConstraint(SpringLayout.NORTH, spinner, 6, SpringLayout.SOUTH, lblJmfPrisper);
		springLayout.putConstraint(SpringLayout.WEST, spinner, 0, SpringLayout.WEST, lblImage);
		springLayout.putConstraint(SpringLayout.SOUTH, spinner, -54, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, spinner, 58, SpringLayout.WEST, this);
		add(spinner);
		
		setBorder(null);
		this.setOpaque(false);
		
		lblImage.setIcon(new ImageIcon(((new ImageIcon(System.getProperty("user.home") + "/.dat215/imat/images/" + item.getImageName())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		
		JButton btnLggTillI = new JButton("Köp");
		springLayout.putConstraint(SpringLayout.NORTH, btnLggTillI, 6, SpringLayout.SOUTH, lblJmfPrisper);
		springLayout.putConstraint(SpringLayout.WEST, btnLggTillI, 0, SpringLayout.WEST, lblImage);
		springLayout.putConstraint(SpringLayout.SOUTH, btnLggTillI, -29, SpringLayout.SOUTH, spinner);
		springLayout.putConstraint(SpringLayout.EAST, btnLggTillI, 151, SpringLayout.WEST, this);
		btnLggTillI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnLggTillI);
	}
	public Dimension getThisSize() {
		return getSize();
	}
	public void setThisSize(Dimension size) {
		setSize(size);
	}
	
	public Product getProduct() {
		return item;
	}
}
