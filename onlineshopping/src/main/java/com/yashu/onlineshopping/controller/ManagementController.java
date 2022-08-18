package com.yashu.onlineshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yashu.onlineshopping.validator.ProductValidator;
import com.yashu.shoppingbackend.dao.CategoryDAO;
import com.yashu.shoppingbackend.dao.ProductDAO;
import com.yashu.shoppingbackend.dto.Category;
import com.yashu.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger= LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false)String operation){
		ModelAndView mv= new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product nproduct= new Product();
		
		//set few of the fields
        nproduct.setSupplierId(1);
        nproduct.setActive(true);
        
        mv.addObject("product", nproduct);
        
        if(operation!=null){
        	if(operation.equals("product")){
        		mv.addObject("message", "Product Submitted Successfully!");
        	}
        	
        }
			
		
		return mv;
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid  @ModelAttribute("product") Product mproduct,BindingResult result,Model model){
		
		
		if(mproduct.getId()==0){
		new ProductValidator().validate(mproduct, result);
		}
		else{
			if(!mproduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mproduct, result);
			}
		}
		
		
		//check it there are any errors
		
		if(result.hasErrors()){
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for Product Submission!");
			
			return "page";
		}
		
		
		logger.info(mproduct.toString());
		
		if(mproduct.getId()==0){
			//create a new product record if id is 0
			productDAO.add(mproduct);
		}else{
			// update the product if id is not 0
			productDAO.update(mproduct);
		}
		
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	public String  handleProductActivation(@PathVariable int id ){
		// is going to fetch the product from the database
		Product product= productDAO.get(id);
		boolean isActive=product.isActive();
		// activating and deactivating based on the value of active filed
		product.setActive(!product.isActive());
		// update the product
		productDAO.update(product);
		
		return (isActive)? "You have succesfully deactivated the product with id "+ product.getId():
			"You have succesfully activated the product with id "+ product.getId();
	}

	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id){
		ModelAndView mv= new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		//fetch the product from data base
		Product nproduct= productDAO.get(id);
        
        mv.addObject("product", nproduct);
			
		
		return mv;
	}
	
}
