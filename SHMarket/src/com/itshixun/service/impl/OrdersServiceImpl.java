package com.itshixun.service.impl;

import java.util.List;

import com.itshixun.dao.OrdersDao;
import com.itshixun.entity.Orders;
import com.itshixun.service.OrdersService;

public class OrdersServiceImpl implements OrdersService{

	public OrdersDao ordersDao = null;
	
	public OrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}


	public int insertOrders(Orders orders) {
		// TODO Auto-generated method stub
		return ordersDao.insertOrders(orders);
	}

	public  List<Orders> selectOrders(){
		return ordersDao.selectOrders();
	}


	public int deleteOrders(int orderId) {
		// TODO Auto-generated method stub
		return ordersDao.deleteOrders(orderId);
	}


	public Orders selectByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return ordersDao.selectByOrderId(orderId);
	}


	public int updateOrders(int orderId) {
		// TODO Auto-generated method stub
		return  ordersDao.updateOrders(orderId);
	}

	@Override
	public Orders selectOneOrdersClient() {
		// TODO Auto-generated method stub
		return ordersDao.selectOneOrdersClient();
	}
	
	@Override
	public Orders selectOneOrders() {
		// TODO Auto-generated method stub
		return ordersDao.selectOneOrders();
	}

	@Override
	public int updateOrdersOrderChange(int orderId) {
		// TODO Auto-generated method stub
		return ordersDao.updateOrdersOrderChange(orderId);
	}

	public int updateOrdersOrderStatu(int orderId) {
		// TODO Auto-generated method stub
		return ordersDao.updateOrdersOrderStatu(orderId);
	}
	@Override
	public List<Orders> selectOrdersByUserId(int userId) {
		// TODO Auto-generated method stub
		return ordersDao.selectOrdersByUserId(userId);
	}
	
	public List<Orders> obligationOrdersStation() {
		// TODO Auto-generated method stub
		return ordersDao.obligationOrdersStation();
	}

	public List<Orders> deliveredOrdersStation() {
		// TODO Auto-generated method stub
		return ordersDao.deliveredOrdersStation();
	}



	public List<Orders> receivedOrdersStation() {
		// TODO Auto-generated method stub
		return ordersDao.receivedOrdersStation();
	}

	public List<Orders> unvaluedOrdersStation() {
		// TODO Auto-generated method stub
		return ordersDao.unvaluedOrdersStation();
	}

	public List<Orders> evaluatedOrdersStation() {
		// TODO Auto-generated method stub
		return ordersDao.evaluatedOrdersStation();
	}
	
	public int updateCountMinus(int orderId) {
		// TODO Auto-generated method stub
		return ordersDao.updateCountMinus(orderId);
	}

	public int updateCountPlus(int orderId) {
		// TODO Auto-generated method stub
		return ordersDao.updateCountPlus(orderId);
	}




}
