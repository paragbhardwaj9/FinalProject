package com.itc.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="groc_category")
public class Category {
	@Id
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Category [category=" + category + "]";
	}

	public Category(String category) {
		super();
		this.category = category;
	}

	public Category() {
		super();
	}
	
}
