package com.baizhi.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.CategoryDAO;
import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.util.MybatisUtil;

public class CategoryServiceImpl implements CategoryService{

	@Override
	public List<Category> selectAll() {
		CategoryDAO cd=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> list=cd.selectAll();
		return list;
	}

	@Override
	public void addOneFirst(Category category) {
		CategoryDAO cd=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		try {
			category.setCategory_Id(UUID.randomUUID().toString());
			category.setLevels(1);
			cd.addOneFirst(category);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Category> selectAllFirst() {
		CategoryDAO cd=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> list=cd.selectAllFirst();
		return list;
	}

	@Override
	public void addOneSecond(Category category) {
		CategoryDAO cd=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		try {
			category.setCategory_Id(UUID.randomUUID().toString());
			category.setLevels(2);
			cd.addOneSecond(category);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOne(String id) {
		CategoryDAO cd=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		try {
			List<Category> list=cd.selectById(id);
			if(list.size()==0){
				cd.deleteOne(id);
			}
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Category> selectAllSecond() {
		CategoryDAO cd=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> list=cd.selectAllSecond();
		MybatisUtil.close();
		return list;
	}

	@Override
	public List<Category> selectFirst() {
		CategoryDAO cd=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> list=cd.selectFirst();
		MybatisUtil.close();
		return list;
	}

	@Override
	public Category selectOneFirst(String fid) {
		CategoryDAO cd=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> list = cd.selectFirst();
		Category cate=null;
		for (Category category : list) {
			if(fid.equals(category.getCategory_Id())){
				cate=category;
				break;
			}
		}
		return cate;
	}


}
