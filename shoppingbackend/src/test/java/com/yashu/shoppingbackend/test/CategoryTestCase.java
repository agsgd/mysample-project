package com.yashu.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yashu.shoppingbackend.dao.CategoryDAO;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	
	//private Category category;
	
	
	
	@BeforeClass
	public static void init(){
		context= new AnnotationConfigApplicationContext();
		context.scan("com.yashu.shoppingbackend");
		context.refresh();
		categoryDAO= (CategoryDAO) context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory(){
		
		category= new Category();
		category.setName("Mobile");
		category.setDescription("This is the Mobile");
		category.setImageURL("CAT_3.png");
		
		assertEquals("Successfully added  a Category inside the table !",true,categoryDAO.add(category));
	}*/
	
	/*
	@Test
	public void testGetcategory(){
		category=  categoryDAO.get(3);
		assertEquals("Successfully fetched  a single Category from  the table !","Mobile",category.getName());
	}
	*/
	
	/*@Test
	public void testUpdatecategory(){
		category=  categoryDAO.get(3);
		
		category.setName("Phone");
		assertEquals("Successfully updated  a single Category in  the table !",true,categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDeletecategory(){
		category=  categoryDAO.get(3);
		
		category.setName("Phone");
		assertEquals("Successfully deleted  a single Category from  the table !",true,categoryDAO.delete(category));
	
	}*/
	
	@Test
	public void testGetAllcategory(){
		
		assertEquals("Successfully fetched  list of  Categorys from  the table !",2,categoryDAO.list().size());
	
	}
	
	
	
	

}
