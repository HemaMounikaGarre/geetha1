package com.cg.project.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.dao.ItemDao;
import com.cg.project.dto.Delivery;
import com.cg.project.dto.Item;
import com.cg.project.dto.PurchaseDetails;
import com.cg.project.dto.Transaction;
import com.cg.project.dto.TransactionDetails;


@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemDao itemDao;
	
	
	@Override
	public void insert() throws JAXBException {
		File xmlFile = new File("transactions.xml");
		 
		JAXBContext jaxbContext;
		try
		{
		    jaxbContext = JAXBContext.newInstance(Transaction.class);             
		 
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		 
		    Transaction transaction = (Transaction) jaxbUnmarshaller.unmarshal(xmlFile);
		    
		   
		   itemDao.create(transaction);
		}
		catch (JAXBException e)
		{
		    e.printStackTrace();
		}
		
	}
	
	
	
	public void marsh() {
		try {
			  
			   JAXBContext jaxbContext = JAXBContext.newInstance(Transaction.class);
			   
			   Marshaller marshaller=jaxbContext.createMarshaller();
			 
			   //Items
			  Item i1=new Item(1,"Phone",25000.80,1); 
			  Item i2=new Item(2,"phone",1089.5,2);
			  Item i3=new Item(3,"bluetooth",450.78,2); 
			  List<Item> itemsList1=new ArrayList<Item>(); 
			  itemsList1.add(i1);
			  itemsList1.add(i2);
			  itemsList1.add(i3);
			  
			  Double totalAmount1=0.0; 
			  for (Item item : itemsList1) {
			  totalAmount1+=item.getAmount();
			 }
			
			   
			   //List of items and order Id and Total amount in purchase details
			  PurchaseDetails purchaseDetails1= new PurchaseDetails (101,itemsList1,totalAmount1);
			
			  Delivery delivery=new Delivery("yes", "Completed");
			  
			  
			  TransactionDetails transactionDetails1=new TransactionDetails("2019-07-15",purchaseDetails1,delivery,"cash");
			 
			   //Another Item 
			
			  Item i4=new Item(4,"Laptop",123934.78,1); 
			  Item i5=new Item(5,"Pendrive",1089.89,2);
			  
			  List<Item> itemsList2=new ArrayList<Item>(); 
			  itemsList2.add(i4);
			  itemsList2.add(i5);
			  
			  Double totalAmount2=0.0; 
			  for (Item item : itemsList2) {
			  totalAmount2+=item.getAmount();
			  
			  }
			
			   
			   
			 //List of items and order Id and Total amount in purchase details
			  PurchaseDetails purchaseDetails2=new PurchaseDetails(102,itemsList2,totalAmount2); 
			   
			   
			   Delivery delivery2=new Delivery("yes", "Completed");
			   

			 TransactionDetails transactionDetails2=new TransactionDetails("2019-07-16",purchaseDetails2,delivery2,"debit");
			 
			
			List<TransactionDetails> transactionDetailsList=new ArrayList<>();
			 
			 transactionDetailsList.add(transactionDetails1);
			 transactionDetailsList.add(transactionDetails2);
		
			  
			Transaction transaction=new Transaction(301, transactionDetailsList);
			   marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
			   File file=new File("transactions.xml"); // System.out.println(tr); 
			  marshaller.marshal(transaction,file); //System.out.println(tr); service.create(details);
			
			  
			   } catch (JAXBException e) { e.printStackTrace(); }
		
	}




	@Override
	public List<PurchaseDetails> findByItemName(String itemName) {
		// TODO Auto-generated method stub
		return itemDao.findByItemName(itemName);
	}



	@Override
	public String update(Integer sid, Integer oid, String deliverystatus) {
		// TODO Auto-generated method stub
		return itemDao.update(sid, oid, deliverystatus);
	}



	@Override
	public TransactionDetails getOderDetails(Integer sid, Integer oid) {
		
		return itemDao.getOderDetails(sid, oid);
	}




}
