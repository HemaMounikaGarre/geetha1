import * as tslib_1 from "tslib";
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
let ProductService = class ProductService {
    constructor(http1) {
        this.http1 = http1;
    }
    getDetails(orderid) {
        return this.http1.get("http://localhost:9999/item/searchbyid?ORDERID=" + orderid);
    }
    update(storeid, orderid, status) {
        return this.http1.put("http://localhost:9999/item/update/", { params: {
                sid: storeid,
                oid: orderid,
                deliverystatus: status
            } });
    }
    getItemDetails(itemName) {
        return this.http1.get("http://localhost:9999/item/searchbyitem?ItemName=" + itemName);
    }
};
ProductService = tslib_1.__decorate([
    Injectable({
        providedIn: 'root'
    }),
    tslib_1.__metadata("design:paramtypes", [HttpClient])
], ProductService);
export { ProductService };
//# sourceMappingURL=product.service.js.map