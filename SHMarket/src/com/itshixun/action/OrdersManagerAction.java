package com.itshixun.action;

import java.util.List;
import java.util.Map;

import com.itshixun.entity.Goods;
import com.itshixun.entity.Orders;
import com.itshixun.entity.User;
import com.itshixun.service.GoodsService;
import com.itshixun.service.OrdersService;
import com.itshixun.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class OrdersManagerAction extends ActionSupport {
	public Orders orders;
	public User user;
	public Goods goods;
	public OrdersService ordersService;
	public UserService userService;
	public GoodsService goodsService;
	public List<Orders> ordersList;
	public List<Goods> list;
	public Map<String,Object> session;
	private String msg;


	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public OrdersService getOrdersService() {
		return ordersService;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public List<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}

	public List<Goods> getList() {
		return list;
	}

	public void setList(List<Goods> list) {
		this.list = list;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String registerOrders(){
		msg = null;
		int count = ordersService.insertOrders(orders);
		if(count>0){
			msg = "添加订单成功！";
		}else{
			msg = "添加订单失败！";
		}
		ordersList = ordersService.selectOrders();
		orders = null;
		return "show";
	}
	
	public String selectOrders(){
		msg = null;
		ordersList = ordersService.selectOrders();
		if(ordersList != null){
			orders = null;
			return "show";
		}else{
			return "success";
		}
		
	}
	
	public String selectOneOrdersClient(){
		msg = null;
		orders.setOrderStatu("待付款");
		ordersService.insertOrders(orders);
		orders = ordersService.selectOneOrdersClient();
		goods = goodsService.selectGoodsById(orders.getGoodId());
		user = userService.selectByUserId(goods.getUserId());
		ordersService.updateOrdersOrderChange(orders.getOrderId());
		ordersService.updateOrdersOrderStatu(orders.getOrderId());
		return "clientorder";
	}
	
	public String selectOneOrders(){
		msg = null;
		orders = ordersService.selectByOrderId(orders.getOrderId());
		if(orders == null){
			msg = "该订单不存在！";
			ordersList = ordersService.selectOrders();
		}else{
			ordersList = null;
		}
		return "show";
	}
	public String updateOrdersOrderStatu(){
		msg = null;
		orders.setOrderStatu("待付款");
		ordersService.updateOrdersOrderStatu(orders.getOrderId());
		return "pay";
	}
	public String selectOrdersByUserId(){
		msg = null;
		ordersList = ordersService.selectOrdersByUserId(orders.getUserId());
		if(ordersList != null){
			return "clientmyOrders";
		}else{
			msg = "您还没有订单，先去购买吧！";
			list = goodsService.selectGoodsByUserId(goods.getUserId());
			return "clientpersonalInfo";
		}
		
	}
	
	public String deleteOrders(){
		msg = null;
		int count = ordersService.deleteOrders(orders.getOrderId());
		if(count >0){
			ordersList = ordersService.selectOrders();
			msg = "删除成功！";
		}else{
			msg = "删除失败！";
		}
		orders = null;
		return "show";
	}
	
	public String deleteOrdersForGoods(){
		goods = goodsService.selectGoodsDetail(orders.getGoodId());
		user = userService.selectByUserId(goods.getUserId());
		ordersService.deleteOrders(orders.getOrderId());
		return "clientdetailedInfo";
	}
	
	public String deleteOrdersForUser(){
		ordersService.deleteOrders(orders.getOrderId());
		ordersList = ordersService.selectOrdersByUserId(user.getUserId());
		return "clientmyOrders";
	}
	
	public String updateOrders(){
		msg = null;
		int count = ordersService.updateOrders(orders.getOrderId());
		if(count >0){
			msg = "修改订单成功！";
		}else{
			msg = "修改订单失败！";
		}
		ordersList = ordersService.selectOrders();
		orders = null;
		return "show";
	}
	public String obligationOrdersStation(){
		msg = null;
		ordersList = ordersService.obligationOrdersStation();
		return "obligationOrdersStation";
		
	}
	public String deliveredOrdersStation(){
		msg = null;
		ordersList = ordersService.deliveredOrdersStation();
		return "deliveredOrdersStation";
		
	}
	
	public String receivedOrdersStation(){
		msg = null;
		ordersList = ordersService.receivedOrdersStation();
		return "receivedOrdersStation";
		
	}
	
	public String unvaluedOrdersStation(){
		msg = null;
		ordersList = ordersService.unvaluedOrdersStation();
		return "unvaluedOrdersStation";
		
	}
	
	public String evaluatedOrdersStation(){
		msg = null;
		ordersList = ordersService.evaluatedOrdersStation();
		return "evaluatedOrdersStation";
		
	}
	
	public String updateCountMinus(){
		msg = null;
		int count = ordersService.updateCountMinus(orders.getOrderId());
		if(count >0){
			if(orders.getOrderCount()<0)
			{
				msg = "订单数量不可以小于0！";
			}
			msg = "修改成功！";
		}else{
			msg = "修改失败！";
		}
		ordersList = ordersService.selectOrders();
		orders = null;
		return "show";
	}
	
	public String updateCountPlus(){
		msg = null;
		int count = ordersService.updateCountPlus(orders.getOrderId());
		if(count >0){
			msg = "修改成功！";
		}else{
			msg = "修改失败！";
		}
		ordersList = ordersService.selectOrders();
		orders = null;
		return "show";
	}
	
}
