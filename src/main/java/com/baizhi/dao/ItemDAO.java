package com.baizhi.dao;

import com.baizhi.entity.Item;

/**
 * 
 * @author 大帅
 * @category 订单项表
 */
public interface ItemDAO {
	/**
	 * 
	 * @param item 添加一个订单项表
	 */
	void addOneItem(Item item);

}
