package com.yashu.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yashu.shoppingbackend.dao.ProductDAO;
import com.yashu.shoppingbackend.dto.Product;
@Repository("productDAO")
@Transactional
public class ProductDAOimpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public boolean add(Product product) {
		 try{
	    	  
	    	  sessionfactory.getCurrentSession().persist(product);
	    	  return true;
	    	  
	      }catch (Exception e) {
	    	  e.printStackTrace();
	    	  return false;
		}
	}

	@Override
	public List<Product> list() {
		return sessionfactory.getCurrentSession().createQuery("FROM Product",Product.class).getResultList();
		 
	}

	@Override
	public Product get(int id) {
		try{
		return sessionfactory.getCurrentSession().get(Product.class,Integer.valueOf(id));
		}catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean update(Product product) {
		 try{
	    	  
	    	  sessionfactory.getCurrentSession().update(product);
	    	  return true;
	    	  
	      }catch (Exception e) {
	    	  e.printStackTrace();
	    	  return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		 try{
	    	  
			 return this.update(product);
	    	  
	      }catch (Exception e) {
	    	  e.printStackTrace();
	    	  return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String SelectActiveProducts="FROM Product WHERE active = :active";
		return sessionfactory.getCurrentSession().createQuery(SelectActiveProducts,Product.class)
				.setParameter("active", true)
				.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String SelectActiveProductsByCategorys="FROM Product WHERE active = :active AND categoryId =:categoryid";
		return sessionfactory.getCurrentSession().createQuery(SelectActiveProductsByCategorys,Product.class)
				.setParameter("active", true)
				.setParameter("categoryid", categoryId)
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String getLatestActiveProducts="FROM Product WHERE active = :active ORDER BY id";
		return sessionfactory.getCurrentSession().createQuery(getLatestActiveProducts,Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
