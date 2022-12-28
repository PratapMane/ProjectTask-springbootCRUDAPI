import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Product } from '../model/product';
import { CommonService } from '../service/common.service';

@Component({
  selector: 'app-productregister',
  templateUrl: './productregister.component.html',
  styleUrls: ['./productregister.component.css']
})
export class ProductregisterComponent implements OnInit{

  constructor( private fb:FormBuilder,private cs:CommonService){}
  productform:FormGroup
  product:Product={
    productId: '',
    productName: '',
    productPrice: 0
  }
  ngOnInit(): void {
    this.productform=this.fb.group({
    productId:[0],
    productName:['',Validators.required],
    productPrice:['',Validators.required]
  });
  }
  registerproduct(){
    this.cs.save(this.productform.value).subscribe((data:any)=>{alert(data.msg)});
    // window.location.reload();
    
  }

 
}
