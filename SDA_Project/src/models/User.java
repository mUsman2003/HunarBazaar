package models;

import java.util.List;

public abstract class User {
	protected int userId;
	protected String name;
	protected String username;
	protected String password;
	protected String phonenumber;
	protected String location;
	protected List<Order> listoforders;
	protected List<Chats> listofchats;
	
	
	User(int id, String name, String username, String password, List<Order> orders, List<Chats> chats, String phonenumber, String location){
		this.userId =id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.listoforders = orders;
		this.listofchats = chats;
		this.phonenumber = phonenumber;
		this.location = location;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public void setid(int userid) {
		this.userId = userid;
	}
	public void setname(String name) {
		this.name = name;
	}
	public void setusername(String username) {
		this.username= username;
	}
	public void setpassword(String pass) {
		this.password = pass;
	}
	public void setlistoforder(List<Order> newlist){
		this.listoforders = newlist;
	}
	
	public void setlistofchats(List<Chats> newlist){
		this.listofchats = newlist;
	}
	public List<Order> getlistoforder(){
		return listoforders;
	}
	public List<Chats> getlistofchats(){
		return listofchats;
	}
	public void setphonenumber(String phone) {
		this.phonenumber = phone;
	}
	public void setlocation (String location) {
		this.location = location;
	}
	
	public int getId(){
		return this.userId;
	}
	public String getname() {
		return this.name;
	}
	public String getusername() {
		return this.username;
	}
	public String getpassword() {
		return this.password;
	}
	public void addOrders(Order neworder) {
		listoforders.add(neworder);
	}
	public void addChat(Chats newchat) {
		listofchats.add(newchat);
	}
	public String getphonenumber() {
		return this.phonenumber;
	}
	public String getlocation() {
		return this.location;
	}
	
	
	
	public abstract void setDashboard();
	public abstract void performingactions();
}
