package se.grupp11.imat.controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.models.ShoppingListItem;

public class ShoppingListController implements Observer {
	
	
	public void addItem() throws Exception {
		throw new Exception("Not implemented yet.");
	}
	
	public void removeItem() throws Exception {
		throw new Exception("Not implemented yet.");
	}
	
	public void setDescription(String description) throws Exception {
		throw new Exception("Not implemented yet.");
	}
	
	public void setTitle(String title) throws Exception {
		throw new Exception("Not implemented yet.");
	}
	
	public ShoppingList create() throws Exception {
		throw new Exception("Not implemented yet.");
	}
	
	public void delete() throws Exception {
		throw new Exception("Not implemented yet.");
	}
	
	public void duplicate() throws Exception {
		throw new Exception("Not implemented yet.");
	}
	
	
	public ShoppingListController() {
		_lists = ShoppingListHandler.loadAllLists();
		
		_shoppingCartList = new ShoppingList();
	}
	
	private List<ShoppingList> _lists = null;
	private ShoppingList _shoppingCartList = null;

	public void setList(ShoppingList list) {
		_shoppingCartList = list;
	}
	
	public ShoppingList getList() {
		return _shoppingCartList;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
