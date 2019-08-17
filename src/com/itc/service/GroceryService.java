package com.itc.service;

import java.util.List;

import com.itc.bean.Grocery;

public interface GroceryService {

	Grocery addGroceryItem(Grocery groc);

	List<String> getCategoryList();

	List<Grocery> getGroceryList();

	Grocery getGrocery(int gid);

	boolean updateGrocery(Grocery groc);

	boolean deleteGrocery(int gid);

}
