package com.itshixun.service;

import java.util.List;

import com.itshixun.entity.Orders;

//创建DAO接口【在mybatis中 service就相当于dao】 
public interface OrdersService {
	/**
	 * 作为DAO的接口
	 * @param orders
	 * @return
	 */
	public abstract int insertOrders(Orders orders);
	public  List<Orders> selectOrders();
	public  Orders selectOneOrders();
	public  Orders selectOneOrdersClient();
	public int updateCountMinus(int orderId);
	public int updateCountPlus(int orderId);
	public  List<Orders> selectOrdersByUserId(int userId);
	public abstract int deleteOrders(int orderId);
	public Orders selectByOrderId(int orderId);
	public abstract int updateOrders(int orderId);
	public abstract int updateOrdersOrderStatu(int orderId);
	public abstract int updateOrdersOrderChange(int orderId);
	public List<Orders> obligationOrdersStation();
	public List<Orders> deliveredOrdersStation();
	public List<Orders> receivedOrdersStation();
	public List<Orders> unvaluedOrdersStation();
	public List<Orders> evaluatedOrdersStation();

}
