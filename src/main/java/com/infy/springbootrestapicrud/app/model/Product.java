package com.infy.springbootrestapicrud.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	@Id
	private String productId;
	private String productName;
	private Double productPrice;

}
