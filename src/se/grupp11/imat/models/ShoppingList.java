package se.grupp11.imat.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import se.chalmers.ait.dat215.project.Product;

import com.google.gson.Gson;

public class ShoppingList {

	
	private UUID _id;
	private String _title;
	private String _description;
	private List<ShoppingListItem> _listitems;
	
	public ShoppingList() {
		
		_listitems = new ArrayList<ShoppingListItem>();
		_id = UUID.randomUUID();
		_title = "";
		_description = "";
	}
	
	public ShoppingList(String title) {
		_title = title;
		_id = UUID.randomUUID();
		_listitems = new ArrayList<ShoppingListItem>();
		_description = "";
	}
	
	public ShoppingList(UUID id, String title, String description) {
		_id = id;
		_title = title;
		_description = description;
		_listitems = new ArrayList<ShoppingListItem>();
	}

	public void addItem(ShoppingListItem item) {
		boolean found = false;
		for(ShoppingListItem listitem : _listitems) {
			if(item.equals(listitem)) {
				listitem.addAmount(item.getAmount());
				found = true;
				break;
			}
		}
		
		if(!found) {
			_listitems.add(item);
		}
	}
	
	public void removeItem(ShoppingListItem item) {
		for(ShoppingListItem listitem : _listitems) {
			if(item.getItem().equals(listitem.getItem())) {
				listitem.addAmount(-item.getAmount());
				
				if(listitem.getAmount() < 0) {
					_listitems.remove(listitem);
				}
				break;
			}
		}
	}
	
	public String toString() {
		return String.format("title:%s,id:%s,description:%s,items:%s", _title, _id, _description, _listitems);	
	}

	public UUID getId() {
		return _id;
	}

	public void setId(UUID _id) {
		this._id = _id;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String _title) {
		this._title = _title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String _description) {
		this._description = _description;
	}
	
	public void setList(List<ShoppingListItem> list) {
		this._listitems = list;
	}
	
	public List<ShoppingListItem> getList() {
		return this._listitems;
	}
	
}
