package com.itshixun.dao;

import java.util.List;

import com.itshixun.entity.Orders;

public interface OrdersDao {
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
