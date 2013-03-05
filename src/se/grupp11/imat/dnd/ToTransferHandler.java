package se.grupp11.imat.dnd;

import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.TransferHandler;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.grupp11.imat.views.ListRowItem;

public class ToTransferHandler extends TransferHandler {
    int action;
    JList target;
    Vector data2;
    
    public ToTransferHandler(int action, JList listtarget, Vector listdata) {
        this.action = action;
        this.target = listtarget;
        this.data2 = listdata;
    }
    
    public boolean canImport(TransferHandler.TransferSupport support) {
        // for the demo, we'll only support drops (not clipboard paste)
        if (!support.isDrop()) {
            return false;
        }

        // we only import Strings
        if (!support.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return false;
        }

        boolean actionSupported = (action & support.getSourceDropActions()) == action;
        if (actionSupported) {
            support.setDropAction(action);
            return true;
        }

        return false;
    }

    public boolean importData(TransferHandler.TransferSupport support) {
        // if we can't handle the import, say so
        if (!canImport(support)) {
            return false;
        }

        // fetch the drop location
        JList.DropLocation dl = (JList.DropLocation)support.getDropLocation();

        int index = dl.getIndex();

        // fetch the data and bail if this fails
        String data;
        try {
            data = (String)support.getTransferable().getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            return false;
        } catch (java.io.IOException e) {
            return false;
        }
        System.out.println(data);
        String[] d = data.split("\\|");
        if(d.length != 2) {
        	return false;
        }
        int pid = Integer.parseInt(d[0]);
        int amount = Integer.parseInt(d[1]);
        ListRowItem i = new ListRowItem(IMatDataHandler.getInstance().getProduct(pid));
        
        JList list = (JList)support.getComponent();
        data2.insertElementAt(i, index);
        list.setListData(data2);

        Rectangle rect = list.getCellBounds(index, index);
        list.scrollRectToVisible(rect);
        list.setSelectedIndex(index);
        list.requestFocusInWindow();

        return true;
    }  
}