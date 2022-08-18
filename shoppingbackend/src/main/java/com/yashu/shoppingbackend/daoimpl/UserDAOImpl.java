package com.yashu.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yashu.shoppingbackend.dao.UserDAO;
import com.yashu.shoppingbackend.dto.Address;
import com.yashu.shoppingbackend.dto.Cart;
import com.yashu.shoppingbackend.dto.User;
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	

	@Override
	public User getByEmail(String email) {
       try{
    	   String findbyemail="From User WHERE email =:EmailId";
    	   
    	   return sessionFactory.getCurrentSession().
    			   createQuery(findbyemail, User.class).
    			   setParameter("EmailId", email).
    			   getSingleResult();
    	   
    	   
       }catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	}

	@Override
	public Address getBillingAddress(User user) {

		String findUserAddress="FROM Address WHERE user =:user AND billing =:isbilling";
		
		try {
			return sessionFactory.getCurrentSession().createQuery(findUserAddress, Address.class)
					.setParameter("user", user).
					setParameter("isbilling", true).getSingleResult();
			
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<Address> listShippingAddress(User user) {
         String findUserAddress="FROM Address WHERE user =:user AND shipping =:isshipping";
		
		try {
			return sessionFactory.getCurrentSession().createQuery(findUserAddress, Address.class)
					.setParameter("user", user).
					setParameter("isshipping", true).getResultList();
			
		} catch (Exception e) {

			return null;
		}
	}

}
