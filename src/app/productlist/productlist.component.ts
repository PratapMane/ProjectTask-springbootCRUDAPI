import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Product } from '../model/product';
import { CommonService } from '../service/common.service';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit{
 
  constructor(public cs:CommonService,public fb:FormBuilder){}
  updateform:FormGroup;
 
  ngOnInit(){
    this.cs.productlist().subscribe((data:any)=>{
    this.cs.productarr=data.resposedata;
    console.log(this.cs.productarr)
  })
  this.updateform=this.fb.group({
    productId:[],
    productName:[],
    productPrice:[]
  })

   
  }
  editproduct(product:Product){
    console.log(product)
        this.updateform.controls['productId'].setValue(product.productId)
        this.updateform.controls['productName'].setValue(product.productName)
        console.log(product.productId)
        this.updateform.controls['productPrice'].setValue(product.productPrice)
      }

  deleteproduct(productId:string){
    this.cs.deleteproduct(productId).subscribe((data:any)=>
    alert(data.msg));
    window.location.reload();
  }
  

  updateproduct(){
    console.log(this.updateform.controls['productId'].value)
     this.cs.updateproduct(this.updateform.value).subscribe((data:any)=>{alert(data.msg)});
     window.location.reload();
  }


}

 
 