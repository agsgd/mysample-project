package com.yashu.shoppingbackend.dao;

import java.util.List;

import com.yashu.shoppingbackend.dto.Address;
import com.yashu.shoppingbackend.dto.Cart;
import com.yashu.shoppingbackend.dto.User;

public interface UserDAO {
	
	
	//add a user
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	//add an Address
	boolean addAddress(Address address);
	//alternative 
	//Address getBillingAddress(int userid);
	//List<Address> listShippingAddress(int userid);
	
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user); 
	
	// update a cart
	

}
