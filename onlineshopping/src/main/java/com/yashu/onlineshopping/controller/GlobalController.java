package com.yashu.onlineshopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.yashu.onlineshopping.model.UserModel;
import com.yashu.shoppingbackend.dao.UserDAO;
import com.yashu.shoppingbackend.dto.User;

@ControllerAdvice
public class GlobalController {
	
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel=null;
	
	
	@ModelAttribute("userModel")
	public UserModel getUserModel(){
		
		if(session.getAttribute("userModel")==null){
			// add user model
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			User user=userDAO.getByEmail(authentication.getName());
			if(user!=null){
				
				userModel= new UserModel();
				userModel.setFullName(user.getFirstName()+""+ user.getLastName());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				
				if(user.getRole().equals("USER")){
					userModel.setCart(user.getCart());
				}
				
				// set user model in the session
				session.setAttribute("userModel", userModel);
				
				return userModel;
			}
		}
		
		return (UserModel)session.getAttribute("userModel");
	}
	

}
