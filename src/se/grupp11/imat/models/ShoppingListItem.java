package se.grupp11.imat.models;

import java.util.Observable;

import se.chalmers.ait.dat215.project.*;

public class ShoppingListItem extends Observable {

	private Product _item;
	private int _amount;
	
	/**
	 * Constructor
	 * @param item
	 * @param amount
	 */
	public ShoppingListItem(Product item, int amount){
		_item = item;
		_amount = amount;
	}
	
	/**
	 * Constructor for loading GSON
	 * @param id 
	 * @param amount 
	 */
	public ShoppingListItem(int id, int amount) {
		_item = IMatDataHandler.getInstance().getProduct(id);
		_amount = amount;
	}
	
	/**
	 * Add (or remove) items from the shopping list item.
	 * @param amountToAdd
	 */
	public void addAmount(int amountToAdd) {
		_amount += amountToAdd;
		setChanged();
		notifyObservers();
	}
	
	public int getAmount() {
		return _amount;
	}
	
	public Product getItem() {
		return _item;
	}
	
	public String toString() {
		return String.format("id:%d,amount:%d", _item.getProductId(), _amount);	
	}
	
	@Override 
	public boolean equals(Object arg0) {
		if(arg0 instanceof ShoppingListItem) {
			ShoppingListItem o = (ShoppingListItem)arg0;
			return (o.getItem().getProductId() == this.getItem().getProductId()); 
		}
		return false;
	}
}
