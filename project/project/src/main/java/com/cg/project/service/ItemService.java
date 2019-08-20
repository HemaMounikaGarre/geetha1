package com.cg.project.service;

import java.util.List;

import javax.xml.bind.JAXBException;

import com.cg.project.dto.Item;
import com.cg.project.dto.PurchaseDetails;
import com.cg.project.dto.TransactionDetails;

public interface ItemService {

	void insert() throws JAXBException;
	public void marsh();
	List<PurchaseDetails> findByItemName(String itemName);
	String update(Integer sid, Integer oid, String deliverystatus);
	TransactionDetails getOderDetails(Integer sid, Integer oid);


}
