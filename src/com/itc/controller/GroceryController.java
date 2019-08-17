package com.itc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itc.bean.Grocery;
import com.itc.exception.GroceryException;
import com.itc.service.GroceryService;

@Controller
public class GroceryController {
	@Autowired
	private  GroceryService grocService;
	private List<String> catList;
	private List<Grocery> glist;
	@RequestMapping(value="/addGrocery")
	public String goToAddGrocery(Model model) {
        System.out.println("ctrl go to add");
        catList = grocService.getCategoryList();
        if(catList==null){
        catList = new ArrayList<>();
        catList.add("Pulses");
        catList.add("Cereals");
        catList.add("Oil");
        catList.add("Fruits");
        }
        model.addAttribute("clist", catList);
        Grocery groc = new Grocery();
        model.addAttribute("grocery", groc);
        return "groceryForm";
      }
	@RequestMapping(value="/submitGrocery")
	public String addGrocery(@ModelAttribute(value="grocery")@Valid Grocery groc, 
			   BindingResult bResult, Model model) {
		 System.out.println("adding grocery");
			    if(bResult.hasErrors()) {
			        catList = grocService.getCategoryList();
			        model.addAttribute("clist", catList);
			        return "groceryForm";
			    }else{
	//public String addGrocery(@ModelAttribute(value="grocery") Grocery groc, Model model) {
		   Grocery groc1 = grocService.addGroceryItem(groc);
		   if(groc1==null){
			   return "submitFail";
		   }else{
		   model.addAttribute("groceryid", groc1.getId());
		   return "submitSuccess";
		   }
		}
}
	
	@RequestMapping(value = "/retreiveGrocery")
	public String showGrocery(Model model) {
	  glist = grocService.getGroceryList();
	  if(glist==null) {
	      return "retrieveFail";
	  }
	  model.addAttribute("glist", glist);
	  return "showGroceries";
	}
	@RequestMapping(value = "/editGrocery")
	   public String editGrocery(Model model, @RequestParam("grocid")int gid) {
	      Grocery groc = grocService.getGrocery(gid);
	      model.addAttribute("grocery", groc);
	      catList = grocService.getCategoryList();
	      model.addAttribute("clist", catList);
	      return "groceryEditForm";      
	   }
	@RequestMapping(value="/updateGrocery")
	   public String updateGrocery(@ModelAttribute(value="grocery") @Valid Grocery groc, 
	      BindingResult bResult , Model model)  {
	      if(bResult.hasErrors()) {
	         catList = grocService.getCategoryList();
	         model.addAttribute("clist", catList);
	         return "groceryEditForm";
	      }
	      else {         
	         boolean success = grocService.updateGrocery(groc);
	         model.addAttribute("groceryid", groc.getId());
	         if(success)
	            return "editSuccess";
	      }
	      return "editFail";
	   }
	@RequestMapping(value = "/deleteGrocery")
	   public String deleteGrocery(Model model, @RequestParam("grocid")int gid) throws GroceryException {
	      boolean success = grocService.deleteGrocery(gid);
	      model.addAttribute("groceryid", gid);
	      if(success)
	         return "deleteSuccess";

	      return "deleteFail";      
	   }
	@RequestMapping(value = "/goHome")
	public String goToHome(Model model) {
	    return "index";
	}
	@ExceptionHandler(Exception.class)
	public String showError(Exception e) {
	   System.out.println(e);
	   return "error";
	}
}