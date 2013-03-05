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
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.event.MouseAdapter;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import se.chalmers.ait.dat215.project.*;
import se.grupp11.imat.controllers.ShoppingCartController;
import se.grupp11.imat.models.ShoppingListItem;

import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.border.LineBorder;
import javax.swing.SpringLayout;
public class ProductSquareItem extends JPanel implements Transferable, 
				DragSourceListener, DragGestureListener {

	
	private Product item;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4434560229573347151L;
	private JSpinner spinner;

	/**
	 * Create the panel.
	 */
	public ProductSquareItem(Product item2) {
		setPreferredSize(new Dimension(160, 246));
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
		
		item=item2;
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		
		JLabel lblImage = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblImage, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblImage, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblImage, 138, SpringLayout.WEST, this);
		add(lblImage);
		
		JLabel lblNamn = new JLabel(""+ item.getName());
		springLayout.putConstraint(SpringLayout.NORTH, lblNamn, 136, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNamn, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNamn, -89, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblImage, -6, SpringLayout.NORTH, lblNamn);
		add(lblNamn);
		
		JLabel lblPris = new JLabel("" + item.getPrice() + "kr");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNamn, -6, SpringLayout.NORTH, lblPris);
		springLayout.putConstraint(SpringLayout.NORTH, lblPris, 168, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblPris, 0, SpringLayout.WEST, lblImage);
		springLayout.putConstraint(SpringLayout.EAST, lblPris, -89, SpringLayout.EAST, this);
		add(lblPris);
		
		JLabel lblJmfPrisper = new JLabel("Jmfpris: " );
		springLayout.putConstraint(SpringLayout.NORTH, lblJmfPrisper, 190, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPris, -6, SpringLayout.NORTH, lblJmfPrisper);
		springLayout.putConstraint(SpringLayout.WEST, lblJmfPrisper, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblJmfPrisper, -36, SpringLayout.EAST, this);
		add(lblJmfPrisper);
		
		spinner = new JSpinner();
		springLayout.putConstraint(SpringLayout.SOUTH, lblJmfPrisper, -6, SpringLayout.NORTH, spinner);
		springLayout.putConstraint(SpringLayout.EAST, spinner, 58, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, spinner, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.WEST, spinner, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, spinner, 212, SpringLayout.NORTH, this);
		add(spinner);
		
		setBorder(null);
		this.setOpaque(false);
		
		lblImage.setIcon(new ImageIcon(((new ImageIcon(System.getProperty("user.home") + "/.dat215/imat/images/" + item.getImageName())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		
		JButton btnLggTillI = new JButton("Köp");
		springLayout.putConstraint(SpringLayout.NORTH, btnLggTillI, 7, SpringLayout.SOUTH, lblJmfPrisper);
		springLayout.putConstraint(SpringLayout.WEST, btnLggTillI, 6, SpringLayout.EAST, spinner);
		springLayout.putConstraint(SpringLayout.SOUTH, btnLggTillI, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnLggTillI, 92, SpringLayout.EAST, spinner);
		btnLggTillI.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Product p = item;
				int amount = Integer.parseInt(spinner.getValue().toString());
				ShoppingListItem i = new ShoppingListItem(p, amount);
				ShoppingCartController.getInstance().addItem(i);
				ShoppingCartController.getInstance().getShoppingCartView().updateUI();
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
	public JSpinner getSpinner() {
		return spinner;
	}
	@Override
	public void dragGestureRecognized(DragGestureEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dragDropEnd(DragSourceDropEvent arg0) {
		repaint();
	}
	@Override
	public void dragEnter(DragSourceDragEvent arg0) {	}
	@Override
	public void dragExit(DragSourceEvent arg0) {	}
	@Override
	public void dragOver(DragSourceDragEvent arg0) {	}
	@Override
	public void dropActionChanged(DragSourceDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object getTransferData(DataFlavor arg0)
			throws UnsupportedFlavorException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DataFlavor[] getTransferDataFlavors() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isDataFlavorSupported(DataFlavor arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
