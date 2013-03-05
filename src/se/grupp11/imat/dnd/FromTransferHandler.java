package se.grupp11.imat.dnd;

import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.AbstractList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.TransferHandler;

import se.grupp11.imat.views.ProductSquareItem;

public class FromTransferHandler extends TransferHandler {
	
	JList dragFrom;
	AbstractListModel from;
	
	public FromTransferHandler(JList fromList, AbstractListModel f) {
		dragFrom = fromList;
		from = f;
	}
	
    public int getSourceActions(JComponent comp) {
        return COPY_OR_MOVE;
    }

    private int index = 0;

    public Transferable createTransferable(JComponent comp) {
        index = dragFrom.getSelectedIndex();
        if (index < 0 || index >= from.getSize()) {
            return null;
        }
        System.out.println(dragFrom.getSelectedValue().getClass().toString());
        ProductSquareItem o = (ProductSquareItem)dragFrom.getSelectedValue();
        String s = o.getProduct().getProductId() + "|1";

        return new StringSelection(s);
    }
    
    public void exportDone(JComponent comp, Transferable trans, int action) {
        if (action != MOVE) {
            return;
        }

        from.getElementAt(index);
    }
}