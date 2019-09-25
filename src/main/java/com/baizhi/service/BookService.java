package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Book;

public interface BookService {
	/**
	 * 
	 * @return 查询所有图书
	 */
	List<Book> selectAll();
	/**
	 * 
	 * @param 关键字段
	 * @param 关键字
	 * @return 模糊查询结果
	 */
	List<Book> selectByKey(String key, String content);
	/**
	 * 
	 * @param 添加图书
	 */
	void addOneBook(Book book);
	/**
	 * 
	 * @param 根据图书Id删除
	 */
	void deleteOne(String bookId);
	/**
	 * 
	 * @param 根据Id查询返回书
	 * @return 返回一本书
	 */
	Book selectOneById(String bookId);
	/**
	 * 
	 * @param 更改图书
	 */
	void updateOneBook(Book book);
	/**
	 * 
	 * @return 随机推荐
	 */
	List<Book> selectRecommend();
	/**
	 * 
	 * @return 新书推荐
	 */
	List<Book> selectByCreateDate();
	/**
	 * 
	 * @return 热卖推荐
	 */
	List<Book> selectBySale();
	/**
	 * 
	 * @return 新书热卖榜
	 */
	List<Book> selectByCreateDateAndSale();
	/**
	 * 
	 * @param fid 一级Id
	 * @param sid 二级Id
	 * @param pageNum 每页个数
	 * @param pageCode 页码
	 * @return 所对应的所有图书
	 */
	List<Book> selectSecond(String fid, String sid, Integer pageCode, Integer pageNum);
	/**
	 * 
	 * @param fid 一级Id
	 * @param sid 二级Id
	 * @param pageNum 每页个数
	 * @return 总个数
	 */
	Integer selectCountById(String fid, String sid, Integer pageNum);

}
