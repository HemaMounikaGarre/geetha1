package com.cg.project.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name="TransactionDetails")
public class TransactionDetails {

	private String BusinessDayDate;
	private PurchaseDetails purchaseDetails;
	private Delivery delivery;
	private String PaymentMode;
	public TransactionDetails(String businessDayDate, PurchaseDetails purchaseDetails, Delivery delivery,
			String paymentMode) {
		super();
		BusinessDayDate = businessDayDate;
		this.purchaseDetails = purchaseDetails;
		this.delivery = delivery;
		PaymentMode = paymentMode;
	}
	public String getBusinessDayDate() {
		return BusinessDayDate;
	}
	public void setBusinessDayDate(String businessDayDate) {
		BusinessDayDate = businessDayDate;
	}
	public PurchaseDetails getPurchaseDetails() {
		return purchaseDetails;
	}
	public void setPurchaseDetails(PurchaseDetails purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public String getPaymentMode() {
		return PaymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		PaymentMode = paymentMode;
	}
	
	public TransactionDetails() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TransactionDetails [BusinessDayDate=" + BusinessDayDate + ", purchaseDetails=" + purchaseDetails
				+ ", delivery=" + delivery + ", PaymentMode=" + PaymentMode + "]";
	}
	
	
	
}
