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
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.SpinnerNumberModel;
import javax.swing.TransferHandler;

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
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
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
import se.grupp11.imat.controllers.ShoppingListController;
import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.models.ShoppingListItem;

import se.grupp11.imat.MainWindow;

import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.border.LineBorder;
import javax.swing.SpringLayout;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;
import java.awt.Font;
public class ProductSquareItem extends JPanel implements Transferable, 
				DragSourceListener, DragGestureListener, ActionListener, ChangeListener, MouseListener {

	
	private Product item;
	private int amount;
	private DragSource source;
	private TransferHandler t;
	private JPopupMenu _popupMenu;

	/**
	 * 
	 */
	private static final long serialVersionUID = -4434560229573347151L;
	private JSpinner spinner;
	

	/**
	 * Create the panel.
	 */

	public ProductSquareItem(Product item2, int amount) {
		this(item2);
		this.amount = amount;
	}
	
	
	/**
	 * @wbp.parser.constructor
	 */
	public ProductSquareItem(final Product item) {
		setPreferredSize(new Dimension(160, 300));
		this.amount=1;
		
		_popupMenu = new JPopupMenu();
		fillPopupMenu();
		MouseListener popupListener = new PopupListener();
		this.addMouseListener(popupListener);
		
			
		
		
		// Hover-effect
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
		
		//sizes
		setMaximumSize(new Dimension(170, 300));
		setMinimumSize(new Dimension(170, 300));
		setRequestFocusEnabled(false);

		this.setItem(item);

		setLbls();
		
		setBorder(null);
		this.setOpaque(false);

		

		t = new TransferHandler() {
			public Transferable createTransferable(JComponent c) {
				return new ProductSquareItem(item, amount); 
			}
		};
		setTransferHandler(t);
		
		source = new DragSource();
		source.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY, this);
		
		this.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent evt) {
	        if (evt.getClickCount() == 2) {
	            MainWindow.setProductView(item);
	            MainWindow.setCard("productView");
	        }
	    }
	});
	}

	private void setLbls() {
		setLayout(null);
		// Labels
		// TODO jmf-pris??
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(10, 10, 180, 180);
		add(lblImage);
		
		JLabel lblNamn = new JLabel(""+ item.getName());
		lblNamn.setBounds(63, 202, 100, 26);
		lblNamn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNamn);
		
		JLabel lblPris = new JLabel("" + item.getPrice() + "kr");
		lblPris.setBounds(63, 230, 61, 16);
		lblPris.setForeground(Color.DARK_GRAY);
		lblPris.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		add(lblPris);
		
		JLabel lblJmfPrisper = new JLabel();
		lblJmfPrisper.setBounds(64, 190, 86, 16);
		add(lblJmfPrisper);
		
		spinner = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));
		spinner.setBounds(22, 264, 48, 26);
		spinner.addChangeListener(this);
		spinner.setValue(this.amount);
		add(spinner);
		
		
		lblImage.setIcon(new ImageIcon(((new ImageIcon(System.getProperty("user.home") + "/.dat215/imat/images/" + item.getImageName())).getImage()).getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH)));
		
		JButton btnLggTillI = new JButton("Köp");
		btnLggTillI.setBounds(91, 264, 99, 26);
		btnLggTillI.addActionListener(this);
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
		source.startDrag(arg0, DragSource.DefaultCopyDrop, new ProductSquareItem(item, amount), this);
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
		
		String s = item.getProductId()+"|"+amount;
		return s;
	}
	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return new DataFlavor[] { DataFlavor.stringFlavor };
	}
	@Override
	public boolean isDataFlavorSupported(DataFlavor arg0) {
		return arg0 == DataFlavor.stringFlavor;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Product p = item;
		int amount = Integer.parseInt(spinner.getValue().toString());
		ShoppingListItem i = new ShoppingListItem(p, amount);
		ShoppingCartController.getInstance().addItem(i);
		ShoppingCartController.getInstance().getShoppingCartView().updateUI();
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		JSpinner s = (JSpinner)e.getSource();
		amount = (Integer)s.getValue();
	}
	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
	    
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		int onmask = MouseEvent.CTRL_DOWN_MASK | MouseEvent.BUTTON1_DOWN_MASK;
	    int offmask = MouseEvent.SHIFT_DOWN_MASK;
	    if ((event.getModifiersEx() & (onmask | offmask)) == onmask) {
	        ShoppingCartController.getInstance().addItem(item, amount);
	    }
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	class PopupListener extends MouseAdapter {
	    public void mousePressed(MouseEvent e) {
	        maybeShowPopup(e);
	    }

	    public void mouseReleased(MouseEvent e) {
	        maybeShowPopup(e);
	    }

	    private void maybeShowPopup(MouseEvent e) {
	        if (e.isPopupTrigger()) {
	            _popupMenu.show(e.getComponent(),
	                       e.getX(), e.getY());
	        }
	    }
	}

	public Product getItem() {
		return item;
	}
	public void setItem(Product item) {
		this.item = item;
	}
	
	private void fillPopupMenu() {
		JMenuItem menuItem = new JMenuItem("Add to cart");
		menuItem.addActionListener(this);
		_popupMenu.add(menuItem);
		
		for(ShoppingList l : ShoppingListController.getInstance().getAll()) {
			menuItem = new JMenuItem("Add to: " + l.getTitle());
			menuItem.setActionCommand(l.getId().toString());
			menuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Shopping cart
					ShoppingListController.getInstance()
						.getList(e.getActionCommand())
						.addItem(new ShoppingListItem(item, amount));
				}
			});
			_popupMenu.add(menuItem);
		}
	}

}
