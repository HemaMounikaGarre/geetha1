package com.cg.project.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Item")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Item {

	private Integer ItemID;
	private String ItemName;
	private Double Amount;
	private Integer Quantity;
	public Item(Integer itemID, String itemName, Double amount, Integer quantity) {
		super();
		ItemID = itemID;
		ItemName = itemName;
		Amount = amount;
		Quantity = quantity;
	}
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public Integer getItemID() {
		return ItemID;
	}
	public void setItemID(Integer itemID) {
		ItemID = itemID;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "Item [ItemID=" + ItemID + ", ItemName=" + ItemName + ", Amount=" + Amount + ", Quantity=" + Quantity
				+ "]";
	}
	
	
}
