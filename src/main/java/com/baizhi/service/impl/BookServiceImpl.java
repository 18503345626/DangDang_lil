package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.baizhi.dao.BookDAO;
import com.baizhi.entity.Book;
import com.baizhi.service.BookService;
import com.baizhi.util.MybatisUtil;

public class BookServiceImpl implements BookService {

	@Override
	public List<Book> selectAll() {
		BookDAO bd=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list=bd.selectAll();
		MybatisUtil.close();
		return list;
	}

	@Override
	public List<Book> selectByKey(String key, String content) {
		BookDAO bd=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list=bd.selectByKey(key,content);
		MybatisUtil.close();
		return list;
	}

	@Override
	public void addOneBook(Book book) {
		BookDAO bd=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		try {
			book.setBook_id(UUID.randomUUID().toString());
			book.setSale(0);
			book.setCreate_date(new Date());
			bd.addOneBook(book);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
		}
	}

	@Override
	public void deleteOne(String bookId) {
		BookDAO bd=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		try {
			bd.deleteOne(bookId);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
		}
		
	}

	@Override
	public Book selectOneById(String bookId) {
		BookDAO bd=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		Book book=bd.selectOneById(bookId);
		MybatisUtil.close();
		return book;
	}

	@Override
	public void updateOneBook(Book book) {
		BookDAO bd=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		try {
			bd.updateOneBook(book);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
		}	
	}

	@Override
	public List<Book> selectRecommend() {
		BookDAO bd=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("create_date", "create_date");
		map.put("sale", null);
		List<Book> list1=bd.selectCodition(map);
		List<Book> list = new ArrayList<Book>();
		int a=new Random().nextInt(list1.size());
		int b=new Random().nextInt(list1.size());
		while(true){
			if(a==b){
				b=new Random().nextInt(list1.size());
			}else{
				break;
			}
		}
		list.add(list1.get(a));
		list.add(list1.get(b));
		MybatisUtil.close();
		return list;
	}

	@Override
	public List<Book> selectByCreateDate() {
		BookDAO bd=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("create_date", "create_date");
		map.put("sale", null);
		List<Book> list1=bd.selectCodition(map);
		List<Book> list = new ArrayList<Book>();
		if(list1.size()>7){
			for(int i=0;i<8;i++){
				list.add(list1.get(i));
			}
		}else{
			for(int i=0;i<list1.size();i++){
				list.add(list1.get(i));
			}
		}
		MybatisUtil.close();
		return list;
	}

	@Override
	public List<Book> selectBySale() {
		BookDAO bd=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("create_date",null);
		map.put("sale", "sale");
		List<Book> list1=bd.selectCodition(map);
		List<Book> list = new ArrayList<Book>();
		if(list1.size()>7){
			for(int i=0;i<8;i++){
				list.add(list1.get(i));
			}
		}else{
			for(int i=0;i<list1.size();i++){
				list.add(list1.get(i));
			}
		}
		MybatisUtil.close();
		return list;
	}

	@Override
	public List<Book> selectByCreateDateAndSale() {
		BookDAO bd=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("create_date", "create_date");
		map.put("sale", "sale");
		List<Book> list1=bd.selectCodition(map);
		List<Book> list = new ArrayList<Book>();
		if(list1.size()>7){
			for(int i=0;i<8;i++){
				list.add(list1.get(i));
			}
		}else{
			for(int i=0;i<list1.size();i++){
				list.add(list1.get(i));
			}
		}
		MybatisUtil.close();
		return list;
	}

//	@Override
//	public List<Book> selectSecond(String fid, String sid) {
//		BookDAO bd=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("fid", fid);
//		map.put("sid", sid);
//		List<Book> list=bd.selectSecondBook(map);
//		return list;
//	}

	@Override
	public List<Book> selectSecond(String fid, String sid, Integer pageCode,
			Integer pageNum) {
		Integer begin=(pageCode-1)*pageNum+1;
		Integer end=pageCode*pageNum;
		BookDAO bd=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("fid", fid);
		map.put("sid", sid);
		map.put("begin", begin);
		map.put("end", end);
		List<Book> list=bd.selectSecondBook(map);
		MybatisUtil.close();
		return list;
	}

	@Override
	public Integer selectCountById(String fid, String sid, Integer pageNum) {
		BookDAO bd=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("fid", fid);
		map.put("sid", sid);	
		Integer c=bd.selectCountById(map);
		Integer count=c%pageNum==0?c/pageNum:c/pageNum+1;
		MybatisUtil.close();
		return count;
	}

}
