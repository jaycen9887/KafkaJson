package com.kafka.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class Pojo {
	
	private String itemName;
	private String itemDescription;
	private String itemPrice;
	private String itemQuantity;
	private String itemCategory;
	private JsonElement menuElement;
	
	public Pojo(JsonElement el) {
		Gson gson = new Gson();
		String in = el.getAsJsonObject().get("itemName").toString();
		String id = el.getAsJsonObject().get("itemDescription").toString();
		String ip = el.getAsJsonObject().get("itemPrice").toString();
		String iq = el.getAsJsonObject().get("itemQuantity").toString();
		String ic = el.getAsJsonObject().get("itemCategory").toString();
		
		//this.firstName = fn.substring(1, fn.length() - 1);
		this.itemName = in.substring(1, in.length() - 1);
		this.itemDescription = id.substring(1, id.length() - 1);
		this.itemPrice = ip.substring(1, ip.length() - 1);
		this.itemQuantity = iq.substring(1, iq.length() - 1);
		this.itemCategory = ic.substring(1, ic.length() - 1);
		
		menuElement = gson.toJsonTree(this);
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	
	public JsonElement getMenuElement() {
		return menuElement;
	}	
	
	
	
	/*private String firstName;
	private String lastName;
	private int age;
	private String phoneNumber;
	private String email;
	
	public Pojo(JsonElement el) {
		String fn = el.getAsJsonObject().get("firstName").toString();
		String ln = el.getAsJsonObject().get("lastName").toString();
		String a = el.getAsJsonObject().get("age").toString();
		String p = el.getAsJsonObject().get("phoneNumber").toString();
		String e = el.getAsJsonObject().get("email").toString();
		
		this.firstName = fn.substring(1, fn.length() - 1);
		this.lastName = ln.substring(1, ln.length() - 1);
		this.age = Integer.parseInt(a.substring(1, a.length() - 1));
		this.phoneNumber = p.substring(1, p.length() - 1);
		this.email = e.substring(1, e.length() - 1);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}*/
	
	

}
