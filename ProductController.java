package com.infy.springbootrestapicrud.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.springbootrestapicrud.app.model.BaseResponse;
import com.infy.springbootrestapicrud.app.model.Product;
import com.infy.springbootrestapicrud.app.serviceI.ProductServiceI;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	ProductServiceI productService;
	
	@PostMapping("/saveproduct")
	public ResponseEntity<BaseResponse<Product>> saveproductdetails(@RequestBody Product product){
		Product prod=productService.saveproductdetails(product);
		BaseResponse<Product> base=new BaseResponse<Product>(200,"Product details is stored",prod);
		return new ResponseEntity<BaseResponse<Product>>(base,HttpStatus.CREATED);
	}
	
	@GetMapping("/getproduct/{productId}")
	public ResponseEntity<BaseResponse<Optional<Product>>> getproductdetailsbyid(@PathVariable ("productId") String productId){
		Optional<Product> prod= productService.getproductbyid(productId);
		if(prod.isEmpty())
		{
			BaseResponse<Optional<Product>> base=new BaseResponse<Optional<Product>>(404,"Required product is not present",null);
			return new ResponseEntity<BaseResponse<Optional<Product>>>(base,HttpStatus.NOT_FOUND);
			
		}
		else {
			BaseResponse<Optional<Product>> base=new BaseResponse<Optional<Product>>(201,"Required product is present",prod);
			return new ResponseEntity<BaseResponse<Optional<Product>>>(base,HttpStatus.OK);
		}
		
	}
	
	@DeleteMapping("/deleteproduct/{productId}")
	public ResponseEntity<BaseResponse<Optional<Product>>>deleteproductdetailsbyid(@PathVariable ("productId") String productId){
		Optional<Product> prod= productService.getproductbyid(productId);
		if(prod.isEmpty())
		{
			BaseResponse<Optional<Product>> base=new BaseResponse<Optional<Product>>(404,"Required product is not present",null);
			return new ResponseEntity<BaseResponse<Optional<Product>>>(base,HttpStatus.NOT_FOUND);
		}
		else {
			 productService.deleteproduct(productId);
			BaseResponse<Optional<Product>> base=new BaseResponse<Optional<Product>>(201,"Product is deleted",prod);
			return new ResponseEntity<BaseResponse<Optional<Product>>>(base,HttpStatus.OK);
		}
		
	}
	
	@PutMapping("/updateproducet/{productId}")
	public ResponseEntity<BaseResponse<Product>> updateproductdetailsbyid(@PathVariable ("productId") String productId,@RequestBody Product product){
		Optional<Product> prod= productService.getproductbyid(productId);
		if(prod.isEmpty())
		{
			BaseResponse<Product> base=new BaseResponse<Product>(404,"Required product is not present",null);
			return new ResponseEntity<BaseResponse<Product>>(base,HttpStatus.NOT_FOUND);
		}
		else
		{
			product.setProductId(prod.get().getProductId());
			Product produ=productService.saveproduct(product);
			BaseResponse<Product> base=new BaseResponse<Product>(200,"Product details is stored",produ);
			return new ResponseEntity<BaseResponse<Product>>(base,HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/getallproduct")
	public ResponseEntity<BaseResponse<Iterable<Product>>> getallproduct(){
		Iterable<Product> product=productService.getallproducts();
		BaseResponse<Iterable<Product>> base=new BaseResponse<>(200," List of Products",product);
		return new ResponseEntity<BaseResponse<Iterable<Product>>>(base,HttpStatus.OK);
	}

}
