package com.cg.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;


import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;


import com.cg.project.dto.PurchaseDetails;
import com.cg.project.dto.TransactionDetails;
import com.cg.project.service.ItemService;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins="http://localhost:4200")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	

	
	@PostMapping("/insert")
	public void insertItem() throws JAXBException {
		itemService.insert();
	}
	
	
	
	@PostMapping("/marsh")
	public void marsh() throws JAXBException {
		itemService.marsh();
	}
	
	
	
	@GetMapping("/GetOderDetails")
	public TransactionDetails getOderDetails(@RequestParam("sid") Integer sid,@RequestParam("oid") Integer oid) {
	  
	 return itemService.getOderDetails(sid, oid);

	}
		
	
	
	
	@GetMapping("/searchbyitem")
	public List<PurchaseDetails> searchByItem(@RequestParam("ItemName") String ItemName) throws JAXBException{
		List<PurchaseDetails> pd=itemService.findByItemName(ItemName);
		return pd;
	}
	
	
	
	@PutMapping("/update")
	public boolean update(@RequestParam("sid") Integer sid,@RequestParam("oid") Integer oid,@RequestParam("deliverystatus") String deliverystatus ) {
		
		if(itemService.update(sid, oid, deliverystatus).equalsIgnoreCase("sucessfullyupdated")){
			 return true;
			}
			else if(deliverystatus.isEmpty()){
				return false;
			}
			else {
				return false;
			}
	
	}
	
	
	
	public static boolean validateXMLSchema(){
	      try {
	         SchemaFactory factory =
	            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	            Schema schema = factory.newSchema(new File("demo.xsd"));
	            Validator validator = schema.newValidator();
	            validator.validate(new StreamSource("demo.xml"));
	      } catch (IOException e){
	         System.out.println("Exception: "+e.getMessage());
	         return false;
	      }catch(SAXException e1){
	         System.out.println("SAX Exception: "+e1.getMessage());
	         return false;
	      }
	  
	      return true;
	 
	   }
}
