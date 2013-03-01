package se.grupp11.imat;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

import se.grupp11.imat.views.StartPage;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Dimension;

public class MainWindow {

	private JFrame frame;
	private JTextField txtSk;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1193, 696);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewList = new JMenuItem("New List");
		mnFile.add(mntmNewList);
		
		JMenuItem mntmToCheckout = new JMenuItem("To Checkout");
		mnFile.add(mntmToCheckout);
		
		JMenuItem mntmEmptyShoppingCart = new JMenuItem("Empty Shopping Cart");
		mnFile.add(mntmEmptyShoppingCart);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmUndo = new JMenuItem("Undo");
		mnEdit.add(mntmUndo);
		
		JMenuItem mntmRedo = new JMenuItem("Redo");
		mnEdit.add(mntmRedo);
		
		JSeparator separator_1 = new JSeparator();
		mnEdit.add(separator_1);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mnEdit.add(mntmDelete);
		
		JSeparator separator_2 = new JSeparator();
		mnEdit.add(separator_2);
		
		JMenuItem mntmSelectAll = new JMenuItem("Select All");
		mnEdit.add(mntmSelectAll);
		
		JMenuItem mntmDeselectAll = new JMenuItem("Deselect All");
		mnEdit.add(mntmDeselectAll);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmMinimize = new JMenuItem("Minimize");
		mnView.add(mntmMinimize);
		
		JMenuItem mntmMaximize = new JMenuItem("Maximize");
		mnView.add(mntmMaximize);
		
		JSeparator separator_3 = new JSeparator();
		mnView.add(separator_3);
		
		JMenuItem mntmForward = new JMenuItem("Forward");
		mnView.add(mntmForward);
		
		JMenuItem mntmBack = new JMenuItem("Back");
		mnView.add(mntmBack);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About...");
		mnHelp.add(mntmAbout);
		
		JPanel panelTop = new JPanel();
		frame.getContentPane().add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new BorderLayout(0, 0));
		
		JPanel westPanel = new JPanel();
		panelTop.add(westPanel, BorderLayout.WEST);
		
		
		JButton btnBack = new JButton("Back");
		westPanel.add(btnBack);
		btnBack.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnForward = new JButton("Forward");
		westPanel.add(btnForward);
		btnForward.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel centerPanel = new JPanel();
		
		FlowLayout flowLayout = (FlowLayout) centerPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTop.add(centerPanel, BorderLayout.CENTER);
		
		txtSk = new JTextField();
		txtSk.setText("Sök…");
		centerPanel.add(txtSk);

		txtSk.setColumns(20);
		
		JPanel eastPanel = new JPanel();
		panelTop.add(eastPanel, BorderLayout.EAST);
		
		
		JPanel panelLeftMenu = new JPanel();
		frame.getContentPane().add(panelLeftMenu, BorderLayout.WEST);
		panelLeftMenu.setLayout(new GridLayout(0, 1, 0, 0));
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			/**
			 * List item clicked
			 */
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		list.setSize(500, 100);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Test1 längre text...", "Test2", "Test3", "Test4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panelLeftMenu.add(list);
		
		JPanel ShoppingCartPanel = new JPanel();
		frame.getContentPane().add(ShoppingCartPanel, BorderLayout.EAST);
		ShoppingCartPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		ShoppingCartPanel.add(scrollPane);
		
		JList ShoppingCart = new JList();
		scrollPane.setViewportView(ShoppingCart);
		ShoppingCart.setModel(new AbstractListModel() {
			String[] values = new String[] {"Testitem 1\t|\tprice", "Testitem 2\t|\tprice", "Testitem 3\t|\tprice", "Testitem 4\t|\tprice", "Testitem 1\t|\tprice", "Testitem 2\t|\tprice", "Testitem 3\t|\tprice", "Testitem 4\t|\tpriceTestitem 1\t|\tprice", "Testitem 2\t|\tprice", "Testitem 3\t|\tprice", "Testitem 4\t|\tpriceTestitem 1\t|\tprice", "Testitem 2\t|\tprice", "Testitem 3\t|\tprice", "Testitem 4\t|\tpriceTestitem 1\t|\tprice", "Testitem 2\t|\tprice", "Testitem 3\t|\tprice", "Testitem 4\t|\tpriceTestitem 1\t|\tprice", "Testitem 2\t|\tprice", "Testitem 3\t|\tprice", "Testitem 4\t|\tpriceTestitem 1\t|\tprice", "Testitem 2\t|\tprice", "Testitem 3\t|\tprice", "Testitem 4\t|\tprice"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JPanel southPanelShoppingCart = new JPanel();
		southPanelShoppingCart.setBackground(new Color(255, 255, 255));
		ShoppingCartPanel.add(southPanelShoppingCart);
		
		JButton btnRensa = new JButton("Rensa");
		southPanelShoppingCart.add(btnRensa);
		
		JButton buyButton = new JButton("Till Kassan");
		southPanelShoppingCart.add(buyButton);
		
		JScrollPane scrollPaneMainStage = new JScrollPane();
		frame.getContentPane().add(scrollPaneMainStage, BorderLayout.CENTER);
		
		JPanel panelMainStage = new JPanel();
		scrollPaneMainStage.setViewportView(panelMainStage);
		panelMainStage.setLayout(new BorderLayout(0, 0));
		
		StartPage startPage = new StartPage();
		startPage.setPreferredSize(new Dimension(680, 1200));
		startPage.setMinimumSize(new Dimension(680, 1200));
		panelMainStage.add(startPage, BorderLayout.CENTER);
		
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("");
		
		JLabel label_2 = new JLabel("");
		
		JLabel label_3 = new JLabel("");
		
		
		westPanel.setBackground(new Color(255,33,81));
		centerPanel.setBackground(new Color(255,33,81));
		eastPanel.setBackground(new Color(255,33,81));
		
		Color c=new Color(255, 250, 250);
		startPage.setBackground(c);
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
