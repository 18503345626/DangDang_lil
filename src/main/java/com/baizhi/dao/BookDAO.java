package com.baizhi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;

public interface BookDAO {
	/**
	 * 
	 * @return 查询所有图书
	 */
	List<Book> selectAll();
	/**
	 * 
	 * @param key 关键字段
	 * @param content 关键字
	 * @return 模糊查询对象
	 */
	List<Book> selectByKey(@Param("key")String key,@Param("content")String content);
	/**
	 * 
	 * @param 添加一本书
	 */
	void addOneBook(Book book);
	/**
	 * 
	 * @param 根据图书Id删除
	 */
	void deleteOne(String bookId);
	/**
	 * 
	 * @param 根据Id查询一本书
	 * @return 一本书
	 */
	Book selectOneById(String bookId);
	/**
	 * 
	 * @param 修改一本书
	 */
	void updateOneBook(Book book);
	/**
	 * 
	 * @param map 
	 * @return
	 */
	List<Book> selectCodition(Map<String, Object> map);
	/**
	 * 
	 * @param map
	 * @return 二级界面图书
	 */
	List<Book> selectSecondBook(Map<String, Object> map);
	/**
	 * 
	 * @param 获取总数一级或二级类型的总数
	 * @return
	 */
	Integer selectCountById(Map<String, Object> map);
	/**
	 * 
	 * @param book 修改图书的销量和库存
	 */
	void updateOneSaleAndStock(Book book);
	
}
