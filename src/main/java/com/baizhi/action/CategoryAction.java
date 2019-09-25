package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author 大帅比
 *	@category Category分类表
 */
@SuppressWarnings("serial")
public class CategoryAction extends ActionSupport{
	private List<Category> list;
	private Category category;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getList() {
		return list;
	}
	public void setList(List<Category> list) {
		this.list = list;
	}
	public String selectAll(){
		CategoryService csi = new CategoryServiceImpl();
		list=csi.selectAll();	
		return Action.SUCCESS;
	}
	public String addOneFirst(){
		CategoryService csi = new CategoryServiceImpl();
		csi.addOneFirst(category);
		return Action.SUCCESS;	
	}
	public String selectAllFirst(){
		CategoryService csi = new CategoryServiceImpl();
		list=csi.selectAllFirst();
		return Action.SUCCESS;	
	}
	public String addOneSecond(){
		CategoryService csi = new CategoryServiceImpl();
		csi.addOneSecond(category);
		return Action.SUCCESS;	
	}
	public String deleteOne(){
		CategoryService csi = new CategoryServiceImpl();
		csi.deleteOne(id);
		return Action.SUCCESS;
	}
	public String selectAllSecond(){
		CategoryService csi = new CategoryServiceImpl();
		list=csi.selectAllSecond();
		return Action.SUCCESS;	
	}
}
