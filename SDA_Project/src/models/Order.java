package models;

import java.util.Date;

public class Order {
	private int orderId;
	private Date startDate;
	private Date endDate;
	private int sellerId;
	private int buyerId;
	private int price;
	private int gigId;
	private String type;
	
	
	Order(int order, Date start, Date end, int seller, int buyer, int price , int gig, String type){
		this.orderId = order; 
		this.startDate = start;
		this.endDate = end;
		this.sellerId = seller;
		this.buyerId = buyer;
		this.price = price;
		this.gigId = gig;
		this.type = type;
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getGigId() {
		return gigId;
	}
	public void setGigId(int gigId) {
		this.gigId = gigId;
	}
	
	public void displayorders(int orderID) {
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
