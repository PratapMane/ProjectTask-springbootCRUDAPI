package com.infy.springbootrestapicrud.app.serviceImpl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.springbootrestapicrud.app.model.Product;
import com.infy.springbootrestapicrud.app.repository.ProductRepository;
import com.infy.springbootrestapicrud.app.serviceI.ProductServiceI;
@Service
public class ProductServiceImpl implements ProductServiceI {
	
	@Autowired
	ProductRepository productRepository;
	 

	@Override
	public Product saveproductdetails(Product product) {
		// TODO Auto-generated method stub
		Random rn=new Random();
		product.setProductId("Prod-"+rn.nextInt(999));
		return productRepository.save(product) ;
	}


	@Override
	public Optional<Product> getproductbyid(String productId) {
		// TODO Auto-generated method stub
		return  productRepository.findByProductId(productId) ;
	}


	@Override
	public void deleteproduct(String productId) {
		// TODO Auto-generated method stub
		  productRepository.deleteById(productId);
		 
	}


	@Override
	public Product saveproduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}


	@Override
	public Iterable<Product> getallproducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}


	 

	 

	 

}
