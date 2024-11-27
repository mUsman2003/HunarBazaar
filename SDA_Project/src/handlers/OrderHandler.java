package handlers;

import java.sql.SQLException;
import java.util.List;

import PersistentStorage.AccountRepository;
import PersistentStorage.OrderRepository;
import PersistentStorage.PersistenceFactory;
import PersistentStorage.SQLServerHandler;
import models.Order;

public class OrderHandler {
	public void submitOrder() {
		
	}
	public void cancelOrder() {
		
	}
	public void pendingOrder() {
		
	}
	public void acceptOrderRequest() {
		
	}
	public static void setStatus(Order order, String S, String string) throws SQLException {
		PersistenceFactory factory = new PersistenceFactory();
	    SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        OrderRepository orderRepo = sqlHandler.getOrderRepository();
		orderRepo.setChangeStatus(order, S, string);
	}
	public static void setFeedback(int orderid, double feedback) throws SQLException {
		// TODO Auto-generated method stub
		PersistenceFactory factory = new PersistenceFactory();
	    SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        OrderRepository orderRepo = sqlHandler.getOrderRepository();
		orderRepo.setChangeFeedback(orderid,feedback);
	}
	public static int addneworder(Order order) {
		// TODO Auto-generated method stub
		PersistenceFactory factory = new PersistenceFactory();
	    SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        OrderRepository orderRepo = sqlHandler.getOrderRepository();
		return orderRepo.addnewOrder(order);
	}
	public static List<Order> getListofOrders(int buyerid) {
		// TODO Auto-generated method stub
		PersistenceFactory factory = new PersistenceFactory();
	    SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        OrderRepository orderRepo = sqlHandler.getOrderRepository();
		return orderRepo.getListofOrders(buyerid);
	}
}
