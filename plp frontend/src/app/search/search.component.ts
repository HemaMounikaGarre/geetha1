import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from './Interface';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {



  a: boolean = false;

  show = false;
  data: any;


  buttonDisplay = false;
  saved: boolean;
  constructor(private service: ProductService) { }




  getDetails(storeid,orderid) {

    this.service.getDetails(storeid,orderid).subscribe((value: any) => {




    this.data = value;


      this.a = true;


    })
  };


  update(storeid, orderid, deliveryStatus) {
    this.service.update(storeid, orderid, deliveryStatus).subscribe((data: any) => {
    this.saved = data;


    });
  }

}

