package se.grupp11.imat.controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.models.ShoppingListItem;

public class ShoppingListController implements Observer {
	
	
	public ShoppingList create() {
		ShoppingList list = new ShoppingList();
		_lists.put(list.getId().toString(), list);
		return list;
	}
	
	public void delete(String id) throws Exception {
		_lists.remove(id);
	}
	
	public ShoppingList duplicate(String id) throws Exception {
		ShoppingList list = new ShoppingList();
		ShoppingList orig = _lists.get(id);
		
		list.setList(orig.getList());
		list.setDescription(orig.getDescription());
		list.setTitle(orig.getTitle());
		
		return list;
	}
	
	
	private ShoppingListController() {
		_lists = new HashMap<String,ShoppingList>();
		List<ShoppingList> lists = ShoppingListHandler.loadAllLists();
		for(ShoppingList l : lists) {
			_lists.put(l.getId().toString(), l);
		}
		_shoppingCartList = new ShoppingList();
	}
	
	private static ShoppingListController _instance;
	public static ShoppingListController getInstance() {
		if(_instance == null) {
			_instance = new ShoppingListController();
		}
		return _instance;
	}
	
	private Map<String,ShoppingList> _lists = null;
	private ShoppingList _shoppingCartList = null;

	public void setList(ShoppingList list) {
		_shoppingCartList = list;
	}
	
	public ShoppingList getList(String id) {
		return _lists.get(id);
	}
	
	public Collection<ShoppingList> getAll()  {
		return _lists.values();
	}
	
	public void save() {
		for(ShoppingList l : _lists.values()) {
			ShoppingListHandler.SaveShoppingList(l);
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
