package com.cg.project.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name="PurchaseDetails")
public class PurchaseDetails {
       @Id
	private Integer ORDERID;
	private List<Item> item;
	private Double TotalAmount;
	public PurchaseDetails(Integer oRDERID, List<Item> item, Double totalAmount) {
		super();
		ORDERID = oRDERID;
		this.item = item;
		TotalAmount = totalAmount;
	}
	
	public PurchaseDetails() {
		// TODO Auto-generated constructor stub
	}

	public Integer getORDERID() {
		return ORDERID;
	}

	public void setORDERID(Integer oRDERID) {
		ORDERID = oRDERID;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public Double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		TotalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "PurchaseDetails [ORDERID=" + ORDERID + ", item=" + item + ", TotalAmount=" + TotalAmount + "]";
	}
	
}