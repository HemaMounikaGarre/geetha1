package com.cg.project.dto;

public class Delivery {

	private String Deliveryvalue;
	private String DeliveryStatus;
	public Delivery(String deliveryvalue, String deliveryStatus) {
		super();
		Deliveryvalue = deliveryvalue;
		DeliveryStatus = deliveryStatus;
	}
	public String getDeliveryvalue() {
		return Deliveryvalue;
	}
	public void setDeliveryvalue(String deliveryvalue) {
		Deliveryvalue = deliveryvalue;
	}
	public String getDeliveryStatus() {
		return DeliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		DeliveryStatus = deliveryStatus;
	} 
	public Delivery() {
		
	}
}