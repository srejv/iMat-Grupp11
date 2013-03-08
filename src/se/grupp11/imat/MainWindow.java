package se.grupp11.imat;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.grupp11.imat.controllers.ShoppingCartController;
import se.grupp11.imat.controllers.ShoppingListController;
import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.models.CategoriesManual.CatEntry;
import se.grupp11.imat.views.CategoryView;
import se.grupp11.imat.views.CheckOutView;
import se.grupp11.imat.views.HistoryView;
import se.grupp11.imat.views.ListView;
import se.grupp11.imat.views.ListViewEdit;
import se.grupp11.imat.views.ProductView;
import se.grupp11.imat.views.SearchView;
import se.grupp11.imat.views.SettingsView;
import se.grupp11.imat.views.StartPage;
import se.grupp11.imat.views.nav.CategoryLink;
import se.grupp11.imat.views.nav.ListLink;
import se.grupp11.imat.views.nav.NavigationLink;
import se.grupp11.imat.views.nav.NavigationLink.NavType;
import se.grupp11.imat.views.nav.NewListLink;
import se.grupp11.imat.views.nav.SeparationLink;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import se.grupp11.imat.views.ReceiptView;


public class MainWindow{
	private JFrame frame;
	
	private static CardLayout cards;
	private static JPanel panelMainStage;
	private JButton btnBack;
	private JButton editDetails;
	private ShoppingCartController scc;
	private static JList navlist;
	private static List<NavigationLink> leftMenuItems;
	private static List<String> cardIndex;
	
	
	// Main stage pages
	private StartPage startPage;
	private SettingsView settingsView;
	private CheckOutView checkOutView;
	private CategoryView categoryView;
	private SearchView searchView;
	private static ListView listView;
	private static ListViewEdit editListView;
	private static ListView shoppingCartView;
	private static HistoryView historyView;
	private static ProductView productView;
	private JTextField txtSk;
	private static JPanel receiptView;

	/**
	 * Create the application.
	 */
	public MainWindow() {

		this.editDetails = editDetails;
		leftMenuItems = new ArrayList<NavigationLink>();
		fillMenu();

		initialize();
		
		ShoppingList list = new ShoppingList();
		list.setTitle("Shopping Cart");
		shoppingCartView.setShoppingList(list);
		
		
	}
	
	public static void fillMenuAndRefresh() {
		fillMenu();
		navlist.setListData(leftMenuItems.toArray());
	}
	
	private static void fillMenu() {
		leftMenuItems.clear();
		
		leftMenuItems.add(new NavigationLink("Start", "StartPage"));
		leftMenuItems.add(new NavigationLink("Historik", "HistoryView"));
		leftMenuItems.add(new NavigationLink("Inställningar", "Settings"));
		leftMenuItems.add(new NavigationLink("Till Kassan", "CheckOut"));
		leftMenuItems.add(new SeparationLink());
		leftMenuItems.add(new CategoryLink(CatEntry.BASEFOOD));
		leftMenuItems.add(new CategoryLink(CatEntry.BREAD));
		leftMenuItems.add(new CategoryLink(CatEntry.CANDYANDFIKA));
		leftMenuItems.add(new CategoryLink(CatEntry.CHARK));
		leftMenuItems.add(new CategoryLink(CatEntry.DAIRY));
		leftMenuItems.add(new CategoryLink(CatEntry.DRINK));
		leftMenuItems.add(new CategoryLink(CatEntry.FRUITANDBERRIES));
		leftMenuItems.add(new CategoryLink(CatEntry.VEG));
		
		leftMenuItems.add(new SeparationLink());
		leftMenuItems.add(new NewListLink());
		for(ShoppingList l : ShoppingListController.getInstance().getAll()) {
			leftMenuItems.add(new ListLink(l.getTitle(), l));
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		scc = ShoppingCartController.getInstance();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1193, 696);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Arkiv");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewList = new JMenuItem("Ny Lista");
		mntmNewList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShoppingList slist = ShoppingListController.getInstance().create();
				slist.setTitle("Ny lista");
				slist.setDescription("En ny härlig lista!");
				fillMenuAndRefresh();
			}
		});
		mntmNewList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFile.add(mntmNewList);
		
		JMenuItem mntmToCheckout = new JMenuItem("Till Kassan");
		mntmToCheckout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_MASK));
		mntmToCheckout.addActionListener(scc);
		mntmToCheckout.setActionCommand("buy");
		mnFile.add(mntmToCheckout);
		
		JMenuItem mntmEmptyShoppingCart = new JMenuItem("Töm Kundvagnen");
		mntmEmptyShoppingCart.addActionListener(scc);
		mntmEmptyShoppingCart.setActionCommand("erase");
		mntmEmptyShoppingCart.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mnFile.add(mntmEmptyShoppingCart);
		
		JSeparator separator_4 = new JSeparator();
		mnFile.add(separator_4);
		
		JMenuItem mntmSettings = new JMenuItem("Inställningar");
		mnFile.add(mntmSettings);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Avsluta");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Redigera");
		menuBar.add(mnEdit);
		
		JMenuItem mntmUndo = new JMenuItem("Ångra");
		mntmUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.META_MASK));
		mnEdit.add(mntmUndo);
		
		JMenuItem mntmRedo = new JMenuItem("Upprepa");
		mntmRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.SHIFT_MASK | InputEvent.META_MASK));
		mnEdit.add(mntmRedo);
		
		JSeparator separator_1 = new JSeparator();
		mnEdit.add(separator_1);
		
		JMenuItem mntmCut = new JMenuItem("Klipp ut");
		mntmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.META_MASK));
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Kopiera");
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.META_MASK));
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Klistra in");
		mntmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.META_MASK));
		mnEdit.add(mntmPaste);
		
		JMenuItem mntmDelete = new JMenuItem("Ta bort");
		mntmDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, InputEvent.META_MASK));
		mnEdit.add(mntmDelete);
		
		JMenuItem mntmSelectAll = new JMenuItem("Markera alla");
		mntmSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.META_MASK));
		mnEdit.add(mntmSelectAll);
		
		JMenu mnView = new JMenu("Vy");
		menuBar.add(mnView);
		
		JMenuItem mntmMinimize = new JMenuItem("Minimera");
		mnView.add(mntmMinimize);
		
		JMenuItem mntmMaximize = new JMenuItem("Maximera");
		mnView.add(mntmMaximize);
		
		JSeparator separator_3 = new JSeparator();
		mnView.add(separator_3);
		
		JMenuItem mntmForward = new JMenuItem("Framåt");
		mnView.add(mntmForward);
		
		JMenuItem mntmBack = new JMenuItem("Bakåt");
		mnView.add(mntmBack);
		
		JMenu mnHelp = new JMenu("Hjälp");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("Om...");
		mnHelp.add(mntmAbout);
		
		JPanel panelTop = new JPanel();
		frame.getContentPane().add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new BorderLayout(0, 0));
		
		JPanel westPanel = new JPanel();
		panelTop.add(westPanel, BorderLayout.WEST);
		
		btnBack = new JButton("<");
		btnBack.setToolTipText("gå ett steg bakåt");
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setPreferredSize(new Dimension(45, 29));
		btnBack.setFont(new Font("Comic Sans", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cards.previous(panelMainStage);
				
			}
			
		});
		
		cardIndex = new LinkedList<String>();
		
		westPanel.add(btnBack);
		
		
		JButton btnForward = new JButton(">");
		btnForward.setToolTipText("Gå ett steg framåt");
		btnForward.setPreferredSize(new Dimension(45, 29));
		btnForward.setFont(new Font("Sens Serif", Font.BOLD, 15));
		westPanel.add(btnForward);
		btnForward.setHorizontalTextPosition(SwingConstants.LEFT);
		btnForward.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cards.next(panelMainStage);
				
			}
			
		});
		
		JPanel centerPanel = new JPanel();
		
		FlowLayout flowLayout = (FlowLayout) centerPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTop.add(centerPanel, BorderLayout.CENTER);
		
		txtSk = new JTextField();
		txtSk.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchView.search(txtSk.getText());
					setCard("Search");
				}
			}
		});
		txtSk.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtSk.selectAll();
			}
		});
		txtSk.setText("Sök…");
		centerPanel.add(txtSk);

		txtSk.setColumns(20);
		
		JPanel eastPanel = new JPanel();
		panelTop.add(eastPanel, BorderLayout.EAST);
		

		JPanel navPanel = new JPanel();
		navPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(navPanel, BorderLayout.WEST);
		navPanel.setPreferredSize(new Dimension(170, 10));
		navPanel.setLayout(new BorderLayout(0, 0));
		
		navlist = new JList();
		navlist.setForeground(Color.BLACK);
		navlist.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		navlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		navlist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {
					int selectedIndex = navlist.getSelectedIndex();
					Object o = navlist.getSelectedValue();
					if(o instanceof CategoryLink) {
						CategoryLink l = (CategoryLink)o;
						categoryView.LoadCategory(l.getCategory());
						panelMainStage.add(categoryView, "Category");
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
					panelMainStage.revalidate();
			    }
			}
		});
		
		navlist.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON3) {
					int idx = navlist.locationToIndex(e.getPoint());
					navlist.setSelectedIndex(idx);
					
					NavigationLink sel = (NavigationLink)navlist.getSelectedValue();
					if(sel.type == NavType.ListLink) {
						String listid = ((ListLink)sel).getList().getId().toString();
						JPopupMenu contextMenu = new JPopupMenu();
						JMenuItem menuItem = new JMenuItem("Add to cart");
						menuItem.setActionCommand(listid);
						menuItem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent ae) {
								ShoppingCartController.getInstance()
									.addList(ShoppingListController.getInstance().getList(ae.getActionCommand()));
							}
						});
						contextMenu.add(menuItem);
						menuItem = new JMenuItem("Delete list");
						menuItem.setActionCommand(listid);
						menuItem.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent ae) {
								ShoppingListController.getInstance().delete(ae.getActionCommand());
								fillMenu();
								navlist.setListData(leftMenuItems.toArray());
							}
						});
						contextMenu.add(menuItem);
						contextMenu.show(e.getComponent(), e.getX(), e.getY());
					}
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});




		navlist.setCellRenderer(new NavigationRenderer());
		navlist.setListData(leftMenuItems.toArray());
		
		navPanel.add(navlist);
		
		JPanel ShoppingCartPanel = new JPanel();
		frame.getContentPane().add(ShoppingCartPanel, BorderLayout.EAST);
		ShoppingCartPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("208px"),},
			new RowSpec[] {
				RowSpec.decode("570px"),
				RowSpec.decode("42px"),
				}));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Dra produkter till kundvagnen för att lägga till!");
		ShoppingCartPanel.add(scrollPane, "1, 1, fill, fill");
		scrollPane.setBackground(Color.WHITE);
		
		shoppingCartView = ShoppingCartController.getInstance().getShoppingCartView();
		scrollPane.setViewportView(shoppingCartView);
		
		JPanel southPanelShoppingCart = new JPanel();
		southPanelShoppingCart.setBackground(new Color(255, 255, 255));
		ShoppingCartPanel.add(southPanelShoppingCart, "1, 2, fill, fill");
		
		JButton btnRensa = new JButton("Rensa");
		btnRensa.setToolTipText("Ta bort allt i kundvagnen");
		southPanelShoppingCart.add(btnRensa);
		btnRensa.addActionListener(scc);
		btnRensa.setActionCommand("erase");
		
		JButton buyButton = new JButton("Till Kassan");
		buyButton.setToolTipText("Gå vidare till kassan");
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

		editListView = new ListViewEdit();
		panelMainStage.add(editListView, "EditList");
		
		searchView = new SearchView();
		panelMainStage.add(searchView, "Search");
		
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
		panelMainStage.setBackground(c);
		this.categoryView.setBackground(c);
		this.checkOutView.setBackground(c);
		this.settingsView.setBackground(c);
		
		historyView = new HistoryView();
		panelMainStage.add(historyView, "HistoryView");
		
		receiptView =  new JPanel();
		panelMainStage.add(receiptView, "ReceiptView");
		
		
		setCard("StartPage");
		

		
	}

	public static void setCard(String cardID){
		//cardIndex.add(cardID);
		cards.show(panelMainStage, cardID);
	}
	
	public static ListView getListPanel() {
		return listView;
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
	
	class NavigationRenderer implements ListCellRenderer {
		private Color category = new Color(255, 119, 41);
		private Color selection = new Color(255,250,250);
		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			NavigationLink c = (NavigationLink)value;
			if (c.type == NavType.Separation) {
				JLabel lblSeparator = new JLabel( );
				lblSeparator.setOpaque(true);
				lblSeparator.setBorder( 
					BorderFactory.createLineBorder(Color.black ) );
					lblSeparator.setPreferredSize( new Dimension( 20, 2 ) );
				return lblSeparator ;
			} else if(c.type == NavType.CategoryLink) {
				c.setBackground(category);
			} else if(c.type == NavType.ListLink) {
				c.setBackground(category);
			} else if (c.type == NavType.NewListLink)  {
				c.setBackground(category);

			} else if(c.type == NavType.NavLink)   {
				c.setBackground(category);
			}
			
			if(index % 2 == 1) {
				Color g = c.getBackground();
				c.setBackground(g.brighter());
			}
			
			if(isSelected) {
				if(c.type == NavType.NewListLink) {
					ShoppingList slist = ShoppingListController.getInstance().create();
					slist.setTitle("A new list");
					slist.setDescription("A whole new list.");
					leftMenuItems.add(new ListLink(slist.getTitle(), slist));
					navlist.setListData(leftMenuItems.toArray());
					navlist.repaint();
					return new JLabel("");
				}
				c.setBackground(selection);
			}
			
			return c;
		}
	}

	public static ListViewEdit getListEditPanel() {
		return editListView;
	}
	
	public static void setProductView(Product item){
		productView=new ProductView(item);
		panelMainStage.add(productView, "productView");
	}
	
	public static HistoryView getHistory() {
		return historyView;
	}

	public static JPanel getReceiptView() {
		return receiptView;
	}

	public static void setReceiptView(ReceiptView receiptView) {
		MainWindow.receiptView = receiptView;
		panelMainStage.add(receiptView, "ReceiptView");
	}
}
