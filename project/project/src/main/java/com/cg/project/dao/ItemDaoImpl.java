package com.cg.project.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.cg.project.dto.Delivery;
import com.cg.project.dto.Item;
import com.cg.project.dto.PurchaseDetails;
import com.cg.project.dto.Transaction;
import com.cg.project.dto.TransactionDetails;

@Repository
public class ItemDaoImpl implements ItemDao{

	@Autowired
	MongoTemplate mongoTemplate;
	
	

	@Override
	public Transaction create(Transaction transaction) throws JAXBException {
		Transaction allCashTransaction=new Transaction();
		 Transaction allCreditTransaction=new Transaction();
		 Transaction allDebitTransaction=new Transaction();
		 JAXBContext content=JAXBContext.newInstance(Transaction.class); 
		 Marshaller marshaller=content.createMarshaller();
		 File file=new File("c://users//vyechuri//Desktop//cash.xml");
		 File file1=new File("c://users//vyechuri//Downloads//credit.xml");
		 File file2=new File("c://users//vyechuri//Documents//debit.xml");
		 
		 List<TransactionDetails> cashTransactions=new ArrayList<>();
		 List<TransactionDetails> creditTransactions=new ArrayList<>();
		 List<TransactionDetails> debitTransactions=new ArrayList<>();
		 System.out.println(cashTransactions);
		 List<TransactionDetails> dt=((Transaction) transaction).getTransactionDetails();
		 for (TransactionDetails transactionDetails : dt) {
		  System.out.println(transactionDetails.getPaymentMode());
		  
		  if(transactionDetails.getPaymentMode().equalsIgnoreCase("cash")) {
		   cashTransactions.add(transactionDetails);
		   allCashTransaction.setTransactionDetails(cashTransactions);
		   allCashTransaction.setRetailStoreID(((Transaction) transaction).getRetailStoreID());
		   marshaller.marshal(allCashTransaction, file);
		   System.out.println(cashTransactions);
		   
		  }
		  else if(transactionDetails.getPaymentMode().equalsIgnoreCase("credit")) {
		   creditTransactions.add(transactionDetails);
		   allCreditTransaction.setTransactionDetails(creditTransactions);
		   allCreditTransaction.setRetailStoreID(((Transaction) transaction).getRetailStoreID());    
		   marshaller.marshal(allCreditTransaction, file1);
		  }
		  else if(transactionDetails.getPaymentMode().equalsIgnoreCase("debit")) {
		   debitTransactions.add(transactionDetails);
		   allDebitTransaction.setTransactionDetails(debitTransactions);
		   allDebitTransaction.setRetailStoreID(((Transaction) transaction).getRetailStoreID());    
		   marshaller.marshal(allDebitTransaction, file2);
		  }
		  
		 }
		 return (Transaction) mongoTemplate.save(transaction);
	}
	
	
	

	public TransactionDetails getOderDetails(Integer sid, Integer oid) {
		 TransactionDetails tdetail1=new TransactionDetails();
		   List<Transaction> transaction=mongoTemplate.findAll(Transaction.class);
		       for (int i = 0; i < transaction.size(); i++) {
		        Transaction tr=transaction.get(i);
		        Integer storeid= tr.getRetailStoreID();
		        
		        if(storeid.equals(sid)) {
		         List<TransactionDetails> td=tr.getTransactionDetails();
		         for (int j = 0; j < td.size(); j++) {
		    TransactionDetails tdetail=td.get(j);
		    PurchaseDetails pd=tdetail.getPurchaseDetails();
		    Integer orderid=pd.getORDERID();
		    if (orderid.equals(oid)) {
		     Delivery deliverydetails=tdetail.getDelivery();
		     tdetail1=tdetail; 
		    }
		   }
		         
		        }
		  
		 }
		 
		 
		 return tdetail1;
		}
	
	
	

	@Override
	public List<PurchaseDetails> findByItemName(String itemName) {
		List<Transaction> transactionlist= mongoTemplate.findAll(Transaction.class);
		List<PurchaseDetails> updatedpdlist=new ArrayList<PurchaseDetails>();
		for (int i = 0; i < transactionlist.size(); i++) {
			Transaction trnsaction= transactionlist.get(i);
			List<TransactionDetails> tdlist=trnsaction.getTransactionDetails();
			for (int j = 0; j < tdlist.size(); j++) {
				TransactionDetails tdetails=tdlist.get(j);
				PurchaseDetails purchasedetails=tdetails.getPurchaseDetails();
				List<Item> itemlist= purchasedetails.getItem();
				List<Item> updatedil=new ArrayList<Item>();
				for (int k = 0; k < itemlist.size(); k++) {
					Item item1= itemlist.get(k);
					if (item1.getItemName().equalsIgnoreCase(itemName)) {	
						updatedil.add(item1);	
					}	
				}
				
				if (updatedil.size()!=0) {
					PurchaseDetails updatedpd=new PurchaseDetails();
					updatedpd.setORDERID(purchasedetails.getORDERID());
					updatedpd.setTotalAmount(purchasedetails.getTotalAmount());
					updatedpd.setItem(updatedil);
					updatedpdlist.add(updatedpd);
				}
				
			}
		}
		return updatedpdlist;
	}
	
	
	
	

	@Override
	public String update(Integer sid, Integer oid, String deliverystatus) {
	       List<Transaction> transaction=mongoTemplate.findAll(Transaction.class);
	       for (int i = 0; i < transaction.size(); i++) {
	    	   Transaction tr=transaction.get(i);
	    	   Integer storeid= tr.getRetailStoreID();
	    	   
	    	   if(storeid.equals(sid)) {
	    		   List<TransactionDetails> td=tr.getTransactionDetails();
	    		   for (int j = 0; j < td.size(); j++) {
					TransactionDetails tdetail=td.get(j);
					PurchaseDetails pd=tdetail.getPurchaseDetails();
					Integer orderid=pd.getORDERID();
					if (orderid.equals(oid)) {
						Delivery deliverydetails=tdetail.getDelivery();
						if (deliverystatus.equalsIgnoreCase("Completed")) {
							deliverydetails.setDeliveryStatus(deliverystatus);
							deliverydetails.setDeliveryvalue("yes");	
							//mongoTemplate.save(tr);
						}
						else {
						deliverydetails.setDeliveryStatus(deliverystatus);
						deliverydetails.setDeliveryvalue("No");
						//mongoTemplate.save(tr);
						}
						mongoTemplate.save(tr);
						return "sucessfullyupdated";
						
					}
				}
	    		   
	    	   }
			
		}
		return "please enter a valid details";
	}

}