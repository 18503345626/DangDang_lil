package com.baizhi.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.dao.AdminDAO;
import com.baizhi.dao.CategoryDAO;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.BookService;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.util.MybatisUtil;

public class TestTest {
	@Test
	public void test(){
		AdminDAO ad =(AdminDAO) MybatisUtil.getMapper(AdminDAO.class);
		Admin a = ad.login("admin");
		System.out.println(a);
	}
	@Test
	public void test1(){
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> selcetAll = cd.selectAll();
		for (Category category : selcetAll) {
			System.out.println(category);
		}
	}
	@Test
	public void test2(){
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> selcetAll = cd.selectFirst();
		for (Category category : selcetAll) {
			System.out.println(category);
		}
	}
	@Test
	public void test3(){
		BookService bsi = new BookServiceImpl();
		List<Book> list = bsi.selectByCreateDate();
		for (Book book : list) {
			System.out.println(book);
		}
	}
}
