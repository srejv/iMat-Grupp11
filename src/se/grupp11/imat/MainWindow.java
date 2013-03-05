package se.grupp11.imat;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
<<<<<<< HEAD
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
=======
>>>>>>> origin/nuclear--markus
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import se.grupp11.imat.controllers.ShoppingCartController;
import se.grupp11.imat.views.CheckOutView;
import se.grupp11.imat.views.SettingsView;
import se.grupp11.imat.views.ShoppingCartView;
import se.grupp11.imat.views.StartPage;

public class MainWindow{

	private JList list;
	private JFrame frame;

	private JTextField textField;
	private static CardLayout cards;
	private static JPanel panelMainStage;
	private JButton btnBack;
	private JButton editDetails;
	private ShoppingCartController scc;
	

	private JTextField txtSk;


	/**
	 * Create the application.
	 */
	public MainWindow(){
		this.editDetails = editDetails;
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
		mntmToCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cards.show(panelMainStage, "CheckOut");
			}
		});
		mnFile.add(mntmToCheckout);
		
		JMenuItem mntmEmptyShoppingCart = new JMenuItem("Empty Shopping Cart");
		mnFile.add(mntmEmptyShoppingCart);
		
		JSeparator separator_4 = new JSeparator();
		mnFile.add(separator_4);
		
		JMenuItem mntmSettings = new JMenuItem("Settings\n");
		mnFile.add(mntmSettings);
		mntmSettings.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainWindow.setCard("Settings");
				
			}
			
		});
		
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
		mntmForward.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow.cards.next(MainWindow.panelMainStage);
				
			}
			
		});
		
		JMenuItem mntmBack = new JMenuItem("Back");
		mnView.add(mntmBack);
		mntmBack.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Test");
				MainWindow.cards.previous(MainWindow.panelMainStage);
				
			}
			
		});
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About...");
		mnHelp.add(mntmAbout);
		
		JPanel panelTop = new JPanel();
		frame.getContentPane().add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new BorderLayout(0, 0));
		
		JPanel westPanel = new JPanel();
		panelTop.add(westPanel, BorderLayout.WEST);
		
		btnBack = new JButton("Back");
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow.cards.previous(MainWindow.panelMainStage);
				
			}
			
		});

		westPanel.add(btnBack);
		btnBack.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnForward = new JButton("Forward");
		westPanel.add(btnForward);
		btnForward.setHorizontalAlignment(SwingConstants.LEFT);
		btnForward.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow.cards.next(MainWindow.panelMainStage);
				
			}
			
		});
		
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
		
		list = new JList();
		list.addMouseListener(new MouseAdapter() {
			/**
			 * List item clicked
			 */
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(list.getSelectedValue());
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
		
		JScrollPane scrollPaneMainStage = new JScrollPane();
		frame.getContentPane().add(scrollPaneMainStage, BorderLayout.CENTER);
		
		panelMainStage = new JPanel();
		scrollPaneMainStage.setViewportView(panelMainStage);
		panelMainStage.setLayout(new CardLayout(0, 0));
		cards = (CardLayout) panelMainStage.getLayout();
		
		
		

<<<<<<< HEAD
		startPage.setPreferredSize(new Dimension(680, 1200));
		startPage.setMinimumSize(new Dimension(680, 1200));
		panelMainStage.add(startPage, "StartPage");
=======
>>>>>>> origin/nuclear--markus
		
		SettingsView settingsView = new SettingsView();
		panelMainStage.add(settingsView, "Settings");
		
		CheckOutView checkOutView = new CheckOutView();
		panelMainStage.add(checkOutView, "CheckOut");
		

<<<<<<< HEAD
		
=======

>>>>>>> origin/nuclear--markus
		
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("");
		
		JLabel label_2 = new JLabel("");
		
		JLabel label_3 = new JLabel("");
		
		StartPage startPage = new StartPage();

		startPage.setPreferredSize(new Dimension(1000, 1000));
		startPage.setMinimumSize(new Dimension(1000, 1000));
		panelMainStage.add(startPage, "StartPage");
		startPage.setPreferredSize(new Dimension(680, 1200));
		startPage.setMinimumSize(new Dimension(680, 1200));
		
		westPanel.setBackground(new Color(255,33,81));
		centerPanel.setBackground(new Color(255,33,81));
		eastPanel.setBackground(new Color(255,33,81));
		
		Color c=new Color(255, 250, 250);
		startPage.setBackground(c);
		
<<<<<<< HEAD
		ShoppingCartView shoppingCartView = new ShoppingCartView();
		shoppingCartView.setMinimumSize(new Dimension(680, 400));
		frame.getContentPane().add(shoppingCartView, BorderLayout.EAST);
		
		MainWindow.setCard("StartPage");
=======
		setCard("StartPage");
		
>>>>>>> origin/nuclear--markus
	}

	public static void setCard(String cardID){
		cards.show(panelMainStage, cardID);
	}
	
	

	public JFrame getFrame() {
		return frame;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
}
