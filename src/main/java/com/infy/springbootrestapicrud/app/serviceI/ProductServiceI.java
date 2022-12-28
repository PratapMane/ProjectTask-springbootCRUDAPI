package com.infy.springbootrestapicrud.app.serviceI;

import java.util.Optional;

import com.infy.springbootrestapicrud.app.model.Product;

public interface ProductServiceI {

	public Product saveproductdetails(Product product);

	public Optional<Product> getproductbyid(String productId);

//	public  void deleteproduct(Product produ);

	public void deleteproduct(String productId);

	public Product saveproduct(Product product);

	public Iterable<Product> getallproducts();

	 

}
