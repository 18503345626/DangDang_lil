package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Category;

public interface CategoryService {
	/**
	 * 
	 * @return 查询所有的一级分类和二级分类
	 */
	List<Category> selectAll();
	/**
	 * 
	 * @param 添加一级类别
	 */
	void addOneFirst(Category category);
	/**
	 * 
	 * @return 查询所有一级对象类别
	 */
	List<Category> selectAllFirst();
	/**
	 * 
	 * @param 添加二级类别
	 */
	void addOneSecond(Category category);
	/**
	 * 
	 * @param 根据id删除一个
	 */
	void deleteOne(String id);
	/**
	 * 
	 * @return 查询所有二级对象类别
	 */
	List<Category> selectAllSecond();
	/**
	 * 
	 * @return 查询所有的一级分类对象
	 */
	List<Category> selectFirst();
	/**
	 * 
	 * @param fid 一级对象的Id
	 * @return 一个一级对象内含有所有的二级对象
	 */
	Category selectOneFirst(String fid);
	
}
