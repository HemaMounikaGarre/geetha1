import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { ProductService } from '../product.service';
let SearchComponent = class SearchComponent {
    constructor(service) {
        this.service = service;
        this.result = [];
        this.a = false;
        this.m = false;
        this.buttonDisplay = false;
    }
    ngOnInit() {
    }
    //private result:any[];
    getDetails(orderid) {
        console.log(orderid);
        //this.a=true;
        this.service.getDetails(orderid).subscribe((data) => {
            this.result = data;
            console.log(this.result);
        });
        //this.service.getDetails(orderid).subscribe((data:any)=>console.log(data));
    }
};
SearchComponent = tslib_1.__decorate([
    Component({
        selector: 'app-search',
        templateUrl: './search.component.html',
        styleUrls: ['./search.component.css']
    }),
    tslib_1.__metadata("design:paramtypes", [ProductService])
], SearchComponent);
export { SearchComponent };
//# sourceMappingURL=search.component.js.map