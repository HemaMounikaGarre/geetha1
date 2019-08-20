import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from './search/Interface';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  product:Product[];

  constructor(private http1:HttpClient) { }
  getDetails(storeid,orderid){
    return this.http1.get("http://localhost:9999/item/GetOderDetails?sid="+storeid+"&oid="+orderid);

  }

  update(storeid,orderid,status){
   
    return this.http1.put("http://localhost:9999/item/update?sid="+storeid+"&oid="+orderid+"&deliverystatus="+status,"");
  }
  getItemDetails(itemName){
    return this.http1.get("http://localhost:9999/item/searchbyitem?ItemName="+itemName)
  }
}
