package models;

import java.util.List;

public class Buyer extends User {

    // Singleton instance
    private static Buyer instance;

    // Private constructor to restrict instantiation
    private Buyer(int id, String name, String username, String password, List<Order> orders, List<Chats> chats, String location, String phonenumber) {
        super(id, name, username, password, orders, chats, phonenumber, location);
    }

    public Buyer() {
		super();
	}

	// Public method to create or get the singleton instance
    public static Buyer getInstance(int id, String name, String username, String password, List<Order> orders, List<Chats> chats, String location, String phonenumber) {
        if (instance == null) {
            instance = new Buyer(id, name, username, password, orders, chats, location, phonenumber);
        }
        return instance;
    }

    // Getter for the existing instance without resetting
    public static Buyer getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Buyer instance has not been created yet.");
        }
        return instance;
    }

    // Optional reset method for clearing the singleton instance
    public static void resetInstance() {
        instance = null;
    }

    // Additional methods
    public List<Order> getlistoforder() {
        return listoforders;
    }

    public void addOrders(Order neworder) {
        listoforders.add(neworder);
    }

    public List<Chats> getlistofchats() {
        return listofchats;
    }

    public void addChat(Chats newchat) {
        listofchats.add(newchat);
    }

    @Override
    public void setDashboard() {
        System.out.println("Setting up Buyer Dashboard");
    }

    @Override
    public void performingactions() {
        System.out.println("Buyer performing actions");
    }
}
