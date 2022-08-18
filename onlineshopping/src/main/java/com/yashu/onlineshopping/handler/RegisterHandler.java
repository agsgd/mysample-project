package com.yashu.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.yashu.onlineshopping.model.RegisterModel;
import com.yashu.shoppingbackend.dao.UserDAO;
import com.yashu.shoppingbackend.dto.Address;
import com.yashu.shoppingbackend.dto.Cart;
import com.yashu.shoppingbackend.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public RegisterModel init(){
		
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user){
		registerModel.setUser(user);
	}
	
	
	public void addAddress(RegisterModel registerModel, Address billing){
		registerModel.setBilling(billing);
	}
	
	
	
	public String validateUser(User user, MessageContext message) {
		
		String transitionValue="success";
		
		if(!(user.getPassword().equals(user.getConfirmPassword()))){
			
			message.addMessage(new MessageBuilder().error().source("confirmPassword")
					.defaultText("Password does not match the Confirm Password!").build());
			
			transitionValue="failure";
		}
		
		// check the uniqueness of the email id
		
		if(userDAO.getByEmail(user.getEmail())!=null){
			
			message.addMessage(new MessageBuilder().error().source("email")
					.defaultText("Email Address is alreday used!").build());
			
			transitionValue="failure";
			
		}
		

		return transitionValue;
	}
	
	
	
	
	
	public String saveAll(RegisterModel model){
		String transitionValue="success";
		// fetch the user
		User usser=model.getUser();
		if(usser.getRole().equals("USER")){
			Cart cart= new Cart();
			cart.setUser(usser);
			usser.setCart(cart);
		}
		
		//encode the password
		
		usser.setPassword(passwordEncoder.encode(usser.getPassword()));
		
		// save the user
		userDAO.addUser(usser);
		
		// get the Address
		Address billing= model.getBilling();
		billing.setUser(usser);
		billing.setBilling(true);
		
		userDAO.addAddress(billing);
		return transitionValue;
		
		
	}
	

}
