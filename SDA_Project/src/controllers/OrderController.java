package controllers;

import java.sql.SQLException;
import java.util.List;

import handlers.OrderHandler;
import models.Order;

public class OrderController {
	public void addOrder() {
		
	}
	public void submitOrder() {
		
	}
	public void cancelOrder() {
		
	}
	public static void setStatus(Order order, String S, String string) throws SQLException {
		// TODO Auto-generated method stub
		handlers.OrderHandler.setStatus(order, S, string);
	}
	public static void setFeedback(int orderid, double feedback) throws SQLException {
		// TODO Auto-generated method stub
		handlers.OrderHandler.setFeedback(orderid, feedback);
	}
	public static int addnewOrder(Order order) {
		// TODO Auto-generated method stub
		return handlers.OrderHandler.addneworder(order);
		
	}
	public static List<Order> getListofOrders(int buyerid) {
		// TODO Auto-generated method stub
		return OrderHandler.getListofOrders(buyerid);
	}
}
