package com.itc.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;



@Entity
@Table(name="groc_sp")
public class Grocery {
  @Id
  @TableGenerator(name="id_gen",table="id_gen_sp",pkColumnName="gen_name", 
		    valueColumnName="gen_val",pkColumnValue="ad_gen",initialValue=1001,allocationSize=1)
  @GeneratedValue(strategy=GenerationType.TABLE,generator="id_gen")
  private int id;
  private String name;
  private float price;
  private String category;
  private int quantity;
  private String unit;
  private String description;
  public int getId() {
			return id;
		}
	public void setId(int id) {
			this.id = id;
		}
	
	@NotEmpty(message="Write name of item")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Range(min=1,max=1000,message="Enter the price")
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Pattern(regexp = "^(?:(?!Select).)*$", message = "Select a category")
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Range(min=1,max=1000,message="Enter a Quantity")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Grocery(int id, String name, float price, String category, int quantity, String unit, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
		this.unit = unit;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Grocery [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", quantity="
				+ quantity + ", unit=" + unit + ", description=" + description + "]";
	}
	public Grocery() {
		super();
	}
	public void copy(Grocery groc) {
		id = groc.getId();
		name = groc.getName();
		price = groc.getPrice();
		category = groc.getCategory();
		quantity = groc.getQuantity();
		unit = groc.getUnit();
		description = groc.getDescription();
	}
}
