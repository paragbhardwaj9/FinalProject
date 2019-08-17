package com.itc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.itc.bean.Grocery;

@Transactional
@Repository
public class GroceryDaoImpl implements GroceryDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Grocery addGroceryItem(Grocery groc) {
		try{
		 entityManager.persist(groc);
		return groc;
		}catch (Exception e){
		}
		return null;
	}

	@Override
	public List<String> getCategoryList() {
			   try {
			       String sql = "SELECT cat.category from Category cat";
			       TypedQuery<String> query = entityManager.createQuery(sql, String.class);
			       return query.getResultList();
			   } catch (Exception e) {      
			   }
			   return null;
			}

	@Override
	public List<Grocery> getGroceryList() {
		List<Grocery> grocList = null;
		String jpql = "Select groc from Grocery groc";
		TypedQuery<Grocery> query = entityManager.createQuery(jpql, Grocery.class); 
		grocList = query.getResultList();
		return grocList;
	}

	@Override
	public Grocery getGrocery(int gid) {
		Grocery groc = null;
	      groc = entityManager.find(Grocery.class, gid);
	      return groc;
	}

	@Override
	public boolean updateGrocery(Grocery groc) {
		
		      boolean success=false;
		      try {
		        Grocery groc1 = entityManager.find(Grocery.class, groc.getId());
		        // Copy values from modified object into managed object
		        groc1.copy(groc);
		        entityManager.merge(groc1);
		        success = true;
		      }
		      catch (Exception e) {
		         e.printStackTrace();
		      }
		      return success;
	}

	@Override
	public boolean deleteGrocery(int gid) {
		 boolean success=false;
	      try {
	         Grocery groc = entityManager.find(Grocery.class, gid);
	         entityManager.remove(groc);
	         success = true;
	      }
	      catch (Exception e) {
	      }
	      return success;
	}
	}
