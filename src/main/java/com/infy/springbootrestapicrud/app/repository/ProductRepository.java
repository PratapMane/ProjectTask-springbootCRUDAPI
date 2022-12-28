package com.infy.springbootrestapicrud.app.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infy.springbootrestapicrud.app.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	public Optional<Product> findByProductId(String productId);
 
	 

}
