package com.yashu.onlineshopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yashu.onlineshopping.model.UserModel;
import com.yashu.shoppingbackend.dao.CartLineDAO;
import com.yashu.shoppingbackend.dto.Cart;
import com.yashu.shoppingbackend.dto.CartLine;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	
	@Autowired
	private HttpSession session;
	
	private Cart getCart() {
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	
	
	public List<CartLine> getCartLines() {

		return cartLineDAO.list(getCart().getId());

	}

}
