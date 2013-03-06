package se.grupp11.imat.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.grupp11.imat.MainWindow;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HistoryView extends JPanel {
	private JTable table;
	private Object[][] model;
	private java.util.List<Order> ordersList;
	private JLabel lblHistory;

	/**
	 * Create the panel.
	 */
	public HistoryView() {
		setLayout(new BorderLayout(0, 0));

		setMaximumSize(new Dimension(680, 1200));
		setMinimumSize(new Dimension(680, 1200));

		setBackground(new Color(255, 250, 250));

		lblHistory = new JLabel("Tidigare Köp");
		lblHistory.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(lblHistory, BorderLayout.NORTH);




		updateView();
		

		 

	}
	


	public void updateView() {	
		// Gettings data to model [][] and names[]
		ordersList = IMatDataHandler.getInstance().getOrders();
		
		model = new String[ordersList.size()][2];
		for (int i = 0; i < ordersList.size(); i++) {
			model[i][0] = ordersList.get(i).getDate().toString();
			model[i][1] = "" + ordersList.get(i).getOrderNumber();
		}
		if(table != null)
			this.remove(table);
		
		Object[] names = { "Datum", "OrderNr" };
		
		DefaultTableModel tableModel = new DefaultTableModel(model, names);
		
		table = new JTable(tableModel){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			  public boolean isCellEditable(int rowIndex, int colIndex) {
				  return false;
			  }
		};
		


		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(table, BorderLayout.CENTER);

		
		System.out.println(""+ tableModel.isCellEditable(1,1));
		
		 table.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
			      if (e.getClickCount() == 2) {
			         JTable target = (JTable)e.getSource();
			         int row = target.getSelectedRow();
			         int o=Integer.parseInt((String) table.getValueAt(row, 1));
			         MainWindow.setReceiptView(new ReceiptView(o));
			         MainWindow.setCard("ReceiptView");

			      }
			   }
		 });
		
	
		this.updateUI();
	}

}
