package se.grupp11.imat.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.List;

import se.grupp11.imat.controllers.ShoppingListController;
import se.grupp11.imat.controllers.ShoppingListHandler;
import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.models.ShoppingListItem;

public class ShoppingListItemTest {


	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(se.chalmers.ait.dat215.project.IMatDataHandler.getInstance().imatDirectory());
		ShoppingListItemTest t = new ShoppingListItemTest();
		t.TestCreate();
		t.TestList();
	}
	
	public void TestCreate() {
		
		ShoppingListItem item = new ShoppingListItem(1,1);
		
		System.out.println("Created item: " + item.getItem().getName() + " amount: " + item.getAmount());
		
	}
	
	public void TestList() {
		List<ShoppingList> lists = ShoppingListHandler.loadAllLists();
		
		for(ShoppingList list : lists) {
			System.out.println("Title: " + list.getTitle() );
		}
		
		/*ShoppingList list = new ShoppingList();
		list.setDescription("HERPDERP");
		list.setTitle("DARP");
		list.addItem(new ShoppingListItem(3, 4));
		list.addItem(new ShoppingListItem(5, 2));
		list.addItem(new ShoppingListItem(2, 1));
		
		ShoppingListHandler.SaveShoppingList(list);*/
		
		
	}
}
