package com.yashu.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yashu.shoppingbackend.dao.CategoryDAO;
import com.yashu.shoppingbackend.dto.Category;
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionfactory;

	
	
	
	@Override
	public List<Category> list() {

		String selectActiveCategory="FROM Category WHERE active =:isactive";
		Query query=sessionfactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("isactive", true);
		return query.getResultList();
	}



	@Override
	public Category get(int id) {
		return sessionfactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}



	@Override
	public boolean add(Category category) {
      try{
    	  
    	  sessionfactory.getCurrentSession().persist(category);
    	  return true;
    	  
      }catch (Exception e) {
    	  e.printStackTrace();
    	  return false;
	}
}



	@Override
	public boolean update(Category category) {
		 try{
	    	  
	    	  sessionfactory.getCurrentSession().update(category);
	    	  return true;
	    	  
	      }catch (Exception e) {
	    	  e.printStackTrace();
	    	  return false;
		}
	}



	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		 try{
	    	  
	    	  sessionfactory.getCurrentSession().update(category);
	    	  return true;
	    	  
	      }catch (Exception e) {
	    	  e.printStackTrace();
	    	  return false;
		}
	}

}
