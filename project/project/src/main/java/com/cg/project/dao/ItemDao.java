package com.cg.project.dao;

import java.util.List;

import javax.xml.bind.JAXBException;

import com.cg.project.dto.Item;
import com.cg.project.dto.PurchaseDetails;
import com.cg.project.dto.Transaction;
import com.cg.project.dto.TransactionDetails;

public interface ItemDao {


	
	
	Transaction create(Transaction transaction) throws JAXBException;
	
	TransactionDetails getOderDetails(Integer sid, Integer oid);
	
	List<PurchaseDetails> findByItemName(String itemName);
	String update(Integer sid, Integer oid, String deliverystatus);
}
