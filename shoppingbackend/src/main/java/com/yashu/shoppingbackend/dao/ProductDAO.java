package com.yashu.shoppingbackend.dao;

import java.util.List;

import com.yashu.shoppingbackend.dto.Product;

public interface ProductDAO {
	
	boolean add(Product product);
	List<Product> list();
	Product get(int id);
	boolean update(Product product);
	boolean delete(Product product);
	
	//business methods
	
	List<Product> listActiveProducts();
	List<Product>listActiveProductsByCategory(int categoryId);
	List<Product>getLatestActiveProducts(int count);

}
