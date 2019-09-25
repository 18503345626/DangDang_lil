package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Category implements Serializable{
	private String category_Id;
	private	String name;
	private	String parent_Id;
	private Integer levels;
	private Category category;
	private List<Category> son;
	public List<Category> getSon() {
		return son;
	}
	public void setSon(List<Category> son) {
		this.son = son;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCategory_Id() {
		return category_Id;
	}
	public void setCategory_Id(String category_Id) {
		this.category_Id = category_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent_Id() {
		return parent_Id;
	}
	public void setParent_Id(String parent_Id) {
		this.parent_Id = parent_Id;
	}
	public Integer getLevels() {
		return levels;
	}
	public void setLevels(Integer levels) {
		this.levels = levels;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Category [category_Id=" + category_Id + ", name=" + name
				+ ", parent_Id=" + parent_Id + ", levels=" + levels
				+ ", category=" + category + ", son=" + son + "]";
	}
	
}
