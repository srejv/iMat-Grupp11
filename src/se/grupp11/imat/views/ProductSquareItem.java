package se.grupp11.imat.views;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;
import se.grupp11.imat.MainWindow;
import se.grupp11.imat.controllers.ShoppingCartController;
public class ProductSquareItem extends JPanel {

	
	private Product item;
	private IMatDataHandler imdh = IMatDataHandler.getInstance();
	private ShoppingCart sc = imdh.getShoppingCart();
	private ShoppingCartController scc = ShoppingCartController.getInstance();
	public static JSpinner spinner;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4434560229573347151L;

	/**
	 * Create the panel.
	 */
	public ProductSquareItem(final Product item) {
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
		
		this.setItem(item);
		
		sc.addShoppingCartListener(scc);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(55, 6, 128, 128);
		add(lblImage);
		
		JLabel lblNamn = new JLabel(""+ item.getName());
		lblNamn.setBounds(58, 146, 61, 16);
		add(lblNamn);
		
		JLabel lblPris = new JLabel("" + item.getPrice() + "kr");
		lblPris.setBounds(58, 174, 61, 16);
		add(lblPris);
		
		JLabel lblJmfPrisper = new JLabel("Jmfpris: " );
		lblJmfPrisper.setBounds(58, 202, 114, 16);
		add(lblJmfPrisper);
		
		spinner = new JSpinner();
		spinner.setBounds(55, 239, 44, 36);
		add(spinner);
		
		setBorder(null);
		this.setOpaque(false);
		
		lblImage.setIcon(new ImageIcon(((new ImageIcon("/Users/HForsvall/.dat215/imat/images/" + item.getImageName())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		
		JButton btnLggTillI = new JButton("Köp");
		btnLggTillI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sc.addProduct(item);
				sc.fireShoppingCartChanged(new ShoppingItem(item, (double) Double.parseDouble(spinner.getValue().toString())), true);
				System.out.println(sc.getTotal());
			}
		});
		btnLggTillI.setBounds(106, 239, 91, 36);
		add(btnLggTillI);
		
		this.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        if (evt.getClickCount() == 2) {
		            MainWindow.setProductView(item);
		            MainWindow.setCard("productView");
		        }
		    }
		});
	}
	public Dimension getThisSize() {
		return getSize();
	}
	public void setThisSize(Dimension size) {
		setSize(size);
	}
	public Product getItem() {
		return item;
	}
	public void setItem(Product item) {
		this.item = item;
	}
}
