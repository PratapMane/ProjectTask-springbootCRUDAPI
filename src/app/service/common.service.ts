import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor(private http:HttpClient) { }
  product:Product={
    productId: '',
    productName: '',
    productPrice: 0
  }
  productarr:Product[];
  save(product:FormGroup){
    console.log(product)
    return this.http.post("http://localhost:4040/api/product/saveproduct",product)
  }

  productlist(){
    return this.http.get("http://localhost:4040/api/product/getallproduct");
  }

  updateproduct(product:Product){
    return this.http.put("http://localhost:4040/api/product/updateproducet/"+product.productId,product)
  }

  deleteproduct(productId:string){
    return this.http.delete("http://localhost:4040/api/product/deleteproduct/"+productId)
  }

  getproduct(productId:string){
    return this.http.get("http://localhost:4040/api/product/getproduct/"+productId)
  }
}
