import { Component} from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-searchbyname',
  templateUrl: './searchbyname.component.html',
  styleUrls: ['./searchbyname.component.css']
})
export class SearchbynameComponent  {
  private result:any[]=[];
  constructor(private service:ProductService) { }

  getDetailsByName(itemname){
    this.service.getItemDetails(itemname).subscribe((data:any)=>this.result=data);
    
  }

}
