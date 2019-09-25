package com.baizhi.service.impl;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AddressDAO;
import com.baizhi.dao.BookDAO;
import com.baizhi.dao.ItemDAO;
import com.baizhi.dao.OrderDAO;
import com.baizhi.entity.Address;
import com.baizhi.entity.Book;
import com.baizhi.entity.Cartitem;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.baizhi.service.OrderService;
import com.baizhi.util.MybatisUtil;


public class OrderServiceImpl implements OrderService{

	@Override
	public List<Order> selectBackAll() {
		OrderDAO od=(OrderDAO)MybatisUtil.getMapper(OrderDAO.class);
		List<Order> list=od.selectBackAll();
		MybatisUtil.close();
		return list;
	}
	/**
	 * 前台下单成功后的处理方法
	 */
	@Override
	public void addOrder(Address address) {
		OrderDAO od=(OrderDAO)MybatisUtil.getMapper(OrderDAO.class);
		HttpSession session = ServletActionContext.getRequest().getSession();
		User u=(User)session.getAttribute("loginUser");
		Double total=(Double)session.getAttribute("total");	
		Map<String,Cartitem> map=(Map<String,Cartitem>)session.getAttribute("cart");
		BookDAO bd= (BookDAO)MybatisUtil.getMapper(BookDAO.class);
		AddressDAO ad=(AddressDAO)MybatisUtil.getMapper(AddressDAO.class);
		ItemDAO id=(ItemDAO)MybatisUtil.getMapper(ItemDAO.class);
		try {
			//1.处理地址信息订单
			if(address.getAddress_id()==null||address.getAddress_id().equals("")){
				address.setAddress_id(UUID.randomUUID().toString());
				address.setUser_id(u.getUser_id());
				ad.addOneAddress(address);
			}else{
				List<Address> add1 = ad.selectAllByUser(u.getUser_id());
				Address add=null;
				for (Address address2 : add1) {
					if(address2.getAddress_id().equals(address.getAddress_id())){
						add=address2;
						break;
					}
				}
				if(!add.equals(address)){
					ad.updateOne(address);
				}
			}
			//2.订单数据入库
			Order order = new Order();
			order.setOrder_id(UUID.randomUUID().toString());
			Date date = new Date();
			order.setOrder_num(date.getTime()+"");
			order.setTotal(total);
			order.setStatus("未支付");
			order.setAddress_id(address.getAddress_id());
			order.setCreate_date(date);
			order.setUser_id(u.getUser_id());
			od.addOneOrder(order);
			//3.订单项数据入库
			Set<String> keys = map.keySet();
			for (String key : keys) {
				Item item = new Item();
				Cartitem cart = map.get(key);
				item.setItem_id(UUID.randomUUID().toString());
				item.setBook_id(key);
				item.setCount(cart.getCount());
				item.setCreate_date(date);
				item.setOrder_id(order.getOrder_id());
				id.addOneItem(item);
				//修改图书信息
				Book book = bd.selectOneById(key);
				book.setSale(book.getSale()+cart.getCount());
				book.setStock(book.getStock()-cart.getCount());
				bd.updateOneSaleAndStock(book);
			}
			//销毁购物车
			session.removeAttribute("cart");
			session.removeAttribute("save");
			session.setAttribute("order_num", order.getOrder_num());			
			MybatisUtil.commit();				
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
		}
	}
	/**
	 * 订单详细信息
	 */
	@Override
	public Order orderDetail(String id) {
		OrderDAO od=(OrderDAO)MybatisUtil.getMapper(OrderDAO.class);
		Order order=od.orderDetail(id);
		MybatisUtil.close();
		return order;
	}
}
