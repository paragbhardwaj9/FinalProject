package com.itc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.bean.Grocery;
import com.itc.dao.GroceryDao;

@Service
public class GroceryServiceImpl implements GroceryService {
	@Autowired
	private GroceryDao gDao;

	@Override
	public Grocery addGroceryItem(Grocery groc) {
		return gDao.addGroceryItem(groc);
	}

	@Override
	public List<String> getCategoryList() {
		return gDao.getCategoryList();
	}

	@Override
	public List<Grocery> getGroceryList() {
		return gDao.getGroceryList();
	}

	@Override
	public Grocery getGrocery(int gid) {
		return gDao.getGrocery(gid);
	}

	@Override
	public boolean updateGrocery(Grocery groc) {
		return gDao.updateGrocery(groc);
	}

	@Override
	public boolean deleteGrocery(int gid) {
		return gDao.deleteGrocery(gid);
	}
}
