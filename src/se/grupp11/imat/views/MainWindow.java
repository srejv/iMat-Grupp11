package se.grupp11.imat.views;

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
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MainWindow {

	private JFrame frame;
	private JTextField textField;

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
		frame.setBounds(100, 100, 1087, 705);
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
		panelTop.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panelTop, BorderLayout.NORTH);
		
		JButton btnBack = new JButton("Back");
		panelTop.add(btnBack);
		
		JButton btnForward = new JButton("Forward");
		panelTop.add(btnForward);
		
		textField = new JTextField();
		panelTop.add(textField);
		textField.setColumns(10);
		
		JPanel panelLeftMenu = new JPanel();
		frame.getContentPane().add(panelLeftMenu, BorderLayout.WEST);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Br\u00F6d", "Chark", "Mejeri", "Godis och fika", "Frukt och gr\u00F6nt", "Dryck", "Basvaror"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panelLeftMenu.add(list);
		
		JPanel panelMainStage = new JPanel();
		frame.getContentPane().add(panelMainStage, BorderLayout.CENTER);
		panelMainStage.setLayout(new CardLayout(0, 0));
		
		StartPage startPage = new StartPage();
		startPage.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelMainStage.add(startPage, "");

		
		
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
