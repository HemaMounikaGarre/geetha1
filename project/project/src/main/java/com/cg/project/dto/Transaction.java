package com.cg.project.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name="Transaction")
public class Transaction {
@Id
	private Integer RetailStoreID;
	private List<TransactionDetails> transactionDetails;
	public Transaction(Integer retailStoreID, List<TransactionDetails> transactionDetails) {
		super();
		RetailStoreID = retailStoreID;
		this.transactionDetails = transactionDetails;
	}
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public Integer getRetailStoreID() {
		return RetailStoreID;
	}
	public void setRetailStoreID(Integer retailStoreID) {
		RetailStoreID = retailStoreID;
	}
	public List<TransactionDetails> getTransactionDetails() {
		return transactionDetails;
	}
	public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	@Override
	public String toString() {
		return "Transaction [RetailStoreID=" + RetailStoreID + ", transactionDetails=" + transactionDetails + "]";
	}
	
	
}
