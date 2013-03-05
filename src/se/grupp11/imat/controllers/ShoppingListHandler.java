package se.grupp11.imat.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import se.grupp11.imat.models.ShoppingList;
import se.grupp11.imat.models.ShoppingListItem;

public class ShoppingListHandler {

	private static String listPath = "shoppinglists/";
	
	private static void writeFile(String title, String content) {
        try {
        	BufferedWriter out = new BufferedWriter(new FileWriter("shoppinglists/" + title + ".json" ));
        	
        	out.write(content.toString());
            out.close();
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }
	}
	
	private static String readFile(String path) throws IOException {
		FileInputStream stream = new FileInputStream(new File(path));
		try {
			FileChannel fc = stream.getChannel();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
			/* Instead of using default, pass in a decoder. */
			return Charset.defaultCharset().decode(bb).toString();
		}
		finally {
			stream.close();
		}
	}
	
	public static List<ShoppingList> loadAllLists()  {
		List<ShoppingList> lists = new ArrayList<ShoppingList>();
		String files;
		File folder = new File(listPath);
		File[] listOfFiles = folder.listFiles(); 
		 
		for (int i = 0; i < listOfFiles.length; i++) 
		{
			if (listOfFiles[i].isFile()) 
			{
				files = listOfFiles[i].getName();
				if (files.toLowerCase().endsWith(".json"))
				{
					try {
						String json = readFile(listPath + files);
						lists.add(LoadShoppingList(json));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
			}
		}
		return lists;
	}
	
	public static void SaveShoppingList(ShoppingList list) {
		Gson gson = new Gson();
		String json = gson.toJson(list);
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append("'title':'" + list.getTitle() + "',");
		buffer.append("'id':'" + list.getId().toString() + "',");
		buffer.append("'description':'" + list.getDescription() + "',");
		buffer.append("'items' : [");
		for(ShoppingListItem i : list.getList()) {
			buffer.append("{");
			buffer.append("'id':" + i.getItem().getProductId() + ",");
			buffer.append("'amount':" + i.getAmount());
			buffer.append("},");
		}
		buffer.append("]}");
		
		System.out.println("SAVING: " + buffer.toString());

		ShoppingListHandler.writeFile(list.getId() + "", buffer.toString());
	}
	
	public static ShoppingList LoadShoppingList(String json) {
		ShoppingList list = null;
		// Set up 
		JsonParser parser = new JsonParser();
		
		System.out.println("LOADING: " + json);
		
		// Get json array
		JsonObject obj = parser.parse(json).getAsJsonObject();
		UUID id = UUID.fromString(obj.get("id").getAsString());
		String title = obj.get("title").getAsString();
		String description = obj.get("description").getAsString();
		// Get parameters
	    
	    list = new ShoppingList(id,title,description);
	    
	    // Get list content
	    JsonArray listitems = obj.get("items").getAsJsonArray();
	    for(int i = 0; i < listitems.size(); i++) {
	    	if(listitems.get(i).isJsonNull()) {
	    		continue;
	    	}
    		int pid = listitems.get(i).getAsJsonObject().get("id").getAsInt();
    		int amount = listitems.get(i).getAsJsonObject().get("amount").getAsInt();
    		ShoppingListItem item = new ShoppingListItem(pid, amount);
    		list.addItem(item);
	    }
		return list;
	}
}
