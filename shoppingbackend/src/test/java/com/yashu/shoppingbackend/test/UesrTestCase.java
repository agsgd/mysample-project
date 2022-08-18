package com.yashu.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yashu.shoppingbackend.dao.UserDAO;
import com.yashu.shoppingbackend.dto.Address;
import com.yashu.shoppingbackend.dto.Cart;
import com.yashu.shoppingbackend.dto.User;

public class UesrTestCase {

	private static AnnotationConfigApplicationContext context;

	private static UserDAO userDAO;

	private User user=null;
	private Cart cart=null;
	private Address address=null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.yashu.shoppingbackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
/*	@Test	
	public void testAdd(){
		
		user= new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmali.com");
		user.setRole("USER");
		user.setPassword("123456");
		user.setContactNumber("7411926717");
		
		assertEquals("Failed to add User!",true,userDAO.addUser(user));
		
		
		address= new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddreddLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashta");
		address.setCountry("India");
		address.setPostalcode("400001");
		address.setBilling(true);
		
		// Link the User with the address using user id

		address.setUserid(user.getId());
		
		assertEquals("Failed to add address!",true,userDAO.addAddress(address));
		
		
		if(user.getRole().equals("USER")){
			cart=new Cart();
			
			cart.setUser(user);
			
			assertEquals("Failed to add cart!",true,userDAO.addCart(cart));

			address= new Address();
			address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
			address.setAddreddLineTwo("Near Kaabil Store");
			address.setCity("Mumbai");
			address.setState("Maharashta");
			address.setCountry("India");
			address.setPostalcode("400001");
			address.setShipping(true);
			address.setUserid(user.getId());
			assertEquals("Failed to add shippiing address!",true,userDAO.addAddress(address));

		}
		
	}
	
	*/
	
	/*// test case for creating Cart if the role UESR  
	
	@Test	
	public void testAdd(){
		
		user= new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmali.com");
		user.setRole("USER");
		user.setPassword("123456");
		user.setContactNumber("7411926717");
		
		
		if(user.getRole().equals("USER")){
			
			// Create a cart for user 
			cart=new Cart();
			
			cart.setUser(user);
			//attach cart with the user
			user.setCart(cart);
			
		}
		
		assertEquals("Failed to add User!",true,userDAO.addUser(user));

		
	}*/
	
	
	// test case for Updating Cart
	
	/*@Test
	public void testupdatecart(){
		
		// fetch the user by using Email.
		
		user=userDAO.getByEmail("hr@gmali.com");
		
		// get the cart from user
		cart=user.getCart();
		
		cart.setGrandTotal(6666);
		cart.setCartLines(2);
		
		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));
		
	}*/
	/*
	@Test
	public void testAddAddress(){
		
		// we need to add an user 
		
		user= new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmali.com");
		user.setRole("USER");
		user.setPassword("123456");
		user.setContactNumber("7411926717");
		
		assertEquals("Failed to add User!",true,userDAO.addUser(user));
		
		
		//we are going to add the address 
		address= new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddreddLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashta");
		address.setCountry("India");
		address.setPostalcode("400001");
		address.setBilling(true);	
		
		// attached the user to the address
		address.setUser(user);
		assertEquals("Failed to add Address!",true,userDAO.addAddress(address));

		//we are also going to add the shipping address
		

		address= new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddreddLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashta");
		address.setCountry("India");
		address.setPostalcode("400001");
		address.setShipping(true);
		address.setUser(user);
		assertEquals("Failed to add shippiing address!",true,userDAO.addAddress(address));
		
	}
	*/
	
	
	@Test
	public void testAddress(){
		
		user = userDAO.getByEmail("hr@gmali.com");
		
		address= new Address();
		address.setAddressLineOne("301/B Jadoo Society, Krissh Nagar");
		address.setAddreddLineTwo("Near Kaabil Store");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPostalcode("400001");
		address.setShipping(true);
		
		
		address.setUser(user);
		assertEquals("Failed to add shippiing address!",true,userDAO.addAddress(address));
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
