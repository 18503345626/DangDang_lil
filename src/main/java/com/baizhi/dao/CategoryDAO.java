package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Category;

public interface CategoryDAO {
	/**
	 * 
	 * @return 查询所有分类
	 */
	List<Category> selectAll();
	/**
	 * 
	 * @param 添加一级类别
	 */
	void addOneFirst(Category category);
	/**
	 * 
	 * @return 查询所有一级
	 */
	List<Category> selectAllFirst();
	/**
	 * 
	 * @param 添加二级类别
	 */
	void addOneSecond(Category category);
	/**
	 * 
	 * @param id进行删除
	 */
	void deleteOne(String id);
	/**
	 * 
	 * @param 根据id查询所有含有此id的父id的对象
	 * @return 含有此id的父id的对象
	 */
	List<Category> selectById(String id);
	/**
	 * 
	 * @return 查询所有二级
	 */
	List<Category> selectAllSecond();
	/**
	 * 
	 * @return 查询所有一级
	 */
	List<Category> selectFirst();
	
}
