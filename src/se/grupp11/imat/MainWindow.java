package se.grupp11.imat;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

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

import se.chalmers.ait.dat215.project.ProductCategory;
import se.chalmers.ait.dat215.project.ShoppingItem;
import se.grupp11.imat.controllers.*;
import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.models.ShoppingListItem;
import se.grupp11.imat.views.nav.*;
import se.grupp11.imat.views.StartPage;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Dimension;

import se.grupp11.imat.views.CategoryView;
import se.grupp11.imat.views.ListView;
import se.grupp11.imat.views.SettingsView;
import se.grupp11.imat.views.CheckOutView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainWindow{
	private JFrame frame;

	private JTextField textField;
	private static CardLayout cards;
	private static JPanel panelMainStage;
	private JButton btnBack;
	private JButton editDetails;
	private static JList shoppingCartList;
	private ShoppingCartController scc;
	private JList navlist;
	private List<NavigationLink> leftMenuItems;
	
	// Main stage pages
	private StartPage startPage;
	private SettingsView settingsView;
	private CheckOutView checkOutView;
	private CategoryView categoryView;
	private ListView listView;
	

	private JTextField txtSk;


	/**
	 * Create the application.
	 */
	public MainWindow() {
		
		/*ShoppingList l = ShoppingListController.getInstance().create();
		l.setTitle("Åh va götte.");
		l.setDescription("En Fasinerande beskrivning HURRA.");
		l.getList().add(new ShoppingListItem(50,2));
		l.getList().add(new ShoppingListItem(30,3));
		l.getList().add(new ShoppingListItem(6,1));
		ShoppingListController.getInstance().save();*/
		
		this.editDetails = editDetails;
		leftMenuItems = new ArrayList<NavigationLink>();
		fillMenu();
		initialize();
		
		
	}
	
	private void fillMenu() {
		
		leftMenuItems.add(new NavigationLink("Start", "StartPage"));
		//leftMenuItems.add(new NavigationLink("History", history));
		leftMenuItems.add(new NavigationLink("Settings", "Settings"));
		leftMenuItems.add(new NavigationLink("Checkout", "CheckOut"));
		leftMenuItems.add(new SeparationLink());
		leftMenuItems.add(new CategoryLink(ProductCategory.BERRY));
		leftMenuItems.add(new CategoryLink(ProductCategory.BREAD));
		leftMenuItems.add(new CategoryLink(ProductCategory.CABBAGE));
		leftMenuItems.add(new CategoryLink(ProductCategory.CITRUS_FRUIT));
		leftMenuItems.add(new CategoryLink(ProductCategory.COLD_DRINKS));
		leftMenuItems.add(new CategoryLink(ProductCategory.DAIRIES));
		leftMenuItems.add(new CategoryLink(ProductCategory.EXOTIC_FRUIT));
		leftMenuItems.add(new CategoryLink(ProductCategory.FISH));
		leftMenuItems.add(new CategoryLink(ProductCategory.FLOUR_SUGAR_SALT));
		leftMenuItems.add(new CategoryLink(ProductCategory.FRUIT));
		leftMenuItems.add(new CategoryLink(ProductCategory.HERB));
		leftMenuItems.add(new CategoryLink(ProductCategory.HOT_DRINKS));
		leftMenuItems.add(new SeparationLink());
		leftMenuItems.add(new NewListLink());
		for(ShoppingList l : ShoppingListController.getInstance().getAll()) {
			leftMenuItems.add(new ListLink(l.getTitle(), l));
		}
		//new NewListLink()
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
		
		btnBack = new JButton("Back");
		
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
		
		JPanel navPanel = new JPanel();
		frame.getContentPane().add(navPanel, BorderLayout.WEST);
		navPanel.setPreferredSize(new Dimension(100, 10));
		navPanel.setLayout(new BorderLayout(0, 0));
		
		navlist = new JList();
		navlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		navlist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {
					int selectedIndex = navlist.getSelectedIndex();
					Object o = navlist.getSelectedValue();
					if(o instanceof CategoryLink) {
						CategoryLink l = (CategoryLink)o;
						categoryView.LoadCategory(l.getCategory());
						setCard("Category");
					} 
					else if(o instanceof SeparationLink) {
						// no thing
						navlist.setSelectedIndex(-1);
					} 
					else if(o instanceof ListLink)
					{
						// Load list
						ListLink l = (ListLink)o;
						listView.setShoppingList(l.getList());
						setCard("List");
					}
					else {
						NavigationLink link = (NavigationLink) o; 
						setCard(link.getValue());
					}
					panelMainStage.updateUI();
			    }
			}
		});
		navlist.setModel(new AbstractListModel() {
			
			public int getSize() {
				return leftMenuItems.size();
			}
			public Object getElementAt(int index) {
				return leftMenuItems.get(index);
			}
		});
		navlist.setListData(leftMenuItems.toArray());
		
		navPanel.add(navlist);
		
		JPanel ShoppingCartPanel = new JPanel();
		frame.getContentPane().add(ShoppingCartPanel, BorderLayout.EAST);
		ShoppingCartPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		ShoppingCartPanel.add(scrollPane);
		
		shoppingCartList = new JList();
		scrollPane.setViewportView(shoppingCartList);
		shoppingCartList.setModel(new AbstractListModel() {
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
		
		scc = new ShoppingCartController();
		JButton btnRensa = new JButton("Rensa");
		southPanelShoppingCart.add(btnRensa);
		btnRensa.addActionListener(scc);
		btnRensa.setActionCommand("erase");
		
		JButton buyButton = new JButton("Till Kassan");
		southPanelShoppingCart.add(buyButton);
		buyButton.addActionListener(scc);
		buyButton.setActionCommand("buy");
		
		JScrollPane scrollPaneMainStage = new JScrollPane();
		frame.getContentPane().add(scrollPaneMainStage, BorderLayout.CENTER);
		
		panelMainStage = new JPanel();
		scrollPaneMainStage.setViewportView(panelMainStage);
		panelMainStage.setLayout(new CardLayout(0, 0));
		cards = (CardLayout) panelMainStage.getLayout();
		
		
		settingsView = new SettingsView();
		panelMainStage.add(settingsView, "Settings");
		
		checkOutView = new CheckOutView();
		panelMainStage.add(checkOutView, "CheckOut");
		
		categoryView = new CategoryView();
		panelMainStage.add(categoryView, "Category");
		
		listView = new ListView();
		panelMainStage.add(listView, "List");

		
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("");
		
		JLabel label_2 = new JLabel("");
		
		JLabel label_3 = new JLabel("");
		
		startPage = new StartPage();

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
		
		setCard("StartPage");
		
		
		
		
	}

	public static void setCard(String cardID){
		cards.show(panelMainStage, cardID);
	}
	
	public static void eraseShoppingCart(){
		shoppingCartList.removeAll();
	}

	public JFrame getFrame() {
		return frame;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public JList getNavlist() {
		return navlist;
	}
}
