package PersistentStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Buyer;
import models.Chats;
import models.Earning;
import models.Feedback;
import models.Gig;
import models.Order;
import models.Seller;
import models.User;

public class AccountRepository implements Repository {
    private final Connection connection;

    public AccountRepository(Connection connection) {
        this.connection = connection;
    }
    
    public boolean findUserByUsernameAndPhone(String user, String phone) throws SQLException {
        String query = "SELECT * FROM Buyer WHERE username = ? AND Phone = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, phone);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
        	if (resultSet.next()) { 
                System.out.println("User found with the given username and phone number.");
                return true; 
            } else {
                System.out.println("No user found with the given username and phone number.");
                return false; 
            }
        }
    }
    
    public boolean addNewBuyer(String Fname, String Lname, String Uname, String phone, String Location, String Password) {
        String insertQuery = "INSERT INTO Buyer (Fname, Lname, username, Phone, BuyerLocation, password) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
            insertStatement.setString(1, Fname);
            insertStatement.setString(2, Lname);
            insertStatement.setString(3, Uname);
            insertStatement.setString(4, phone);
            insertStatement.setString(5, Location);
            insertStatement.setString(6, Password);

            int rowsInserted = insertStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("New buyer added successfully.");
                return true; 
            } else {
                System.out.println("Failed to add the new buyer.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("An error occurred while adding the buyer: " + e.getMessage());
            e.printStackTrace();
            return false; 
        }
    }

    public User findUserByUsername(String user, String pass) throws SQLException {
	        String query = "SELECT * FROM Buyer WHERE username = ? AND password = ?";
	        PersistenceFactory factory = new PersistenceFactory();
		    SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, user);
	            preparedStatement.setString(2, pass);

	            
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                	int id = resultSet.getInt("BuyerID");
	                    String name = resultSet.getString("Fname") + " " + resultSet.getString("Lname");
	                    String username = resultSet.getString("username");
	                    String password = resultSet.getString("password");
	                    String phone = resultSet.getString("Phone");
	                    String location = resultSet.getString("BuyerLocation");

	                    Buyer buyer = Buyer.getInstance(id, name, username, password, new ArrayList<>(), new ArrayList<>(), location, phone);
	                    OrderRepository orderRepo = sqlHandler.getOrderRepository();
	                    buyer.setlistoforder(orderRepo.getordersofSeller(id));
	                    
//	                    ChatRepository chatRepo = sqlHandler.getChatRepository();
//	                    buyer.setlistofchats(chatRepo.getchatsofSeller(id));
	                    
	                    String query2 = "SELECT * FROM Seller WHERE SellerId = ?";
	    	            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
	    	            preparedStatement2.setInt(1, buyer.getId());
	                    
	    	            try (ResultSet resultSet2 = preparedStatement2.executeQuery()) {
	    	            	if (!resultSet2.next()) {
	    	            		return buyer;
	    	            	}
	    	            	else {
	    	            		Seller seller = null; 
	    	            		try {
	    	            		    System.out.println("Finding Seller1");

	    	            		    seller = Seller.getInstance(resultSet2.getInt("SellerId"), buyer.getname(), buyer.getusername(),  buyer.getpassword(), buyer.getlistoforder(), buyer.getlistofchats(),  new Earning(),new ArrayList<>(),new Feedback(), buyer.getlocation(),buyer.getphonenumber(),resultSet2.getLong("CNIC"),resultSet2.getInt("CategoryId"));
	    	            		    
	    	            		    GigRepository gigRepo = sqlHandler.getGigRepository();
	    	            		    
	    	            		    
	    	            		    
	    	            		    System.out.println("Finding Seller2");
	    	            		    seller.setListofgigs(gigRepo.getGigsofSeller(id));
	    	            		    List<Gig> giglist = seller.getListofgigs();
	    	            		    for (Gig gig : giglist) {
	    	            		        System.out.println("Gig id: " + gig.getGigId());
	    	            		        System.out.println("Gig Description: " + gig.getGigDescription());
	    	            		    }
	    	            		    List<Order> orderlist = seller.getlistoforder();
	    	            		    for (Order order : orderlist) {
	    	            		        System.out.print("Gig id: " + order.getGigId());
	    	            		        System.out.println(" Order id: " + order.getOrderId());
	    	            		    }
//	    	            		    List<Chats> chatlist = seller.getlistofchats();
//	    	            		    for (Chats chat : chatlist) {
//	    	            		        System.out.print("Chat id: " + chat.getChatId());
//	    	            		        System.out.println(" Sender Name: " + chat.getSellerId());
//	    	            		        System.out.println("Message1: " + chat.getListofmessage().getFirst());
//	    	            		    }
	    	            		} catch (Exception e) {
	    	            		    e.printStackTrace();
	    	            		}

	    	                    return seller;
	    	                    
	    	            	}
	    	            	
	    	            }
	    	            
	                } else {
	                    System.out.println("No user found with the given username and password.");
	                    return null;
	                }
	            }
	}
    
    
    public boolean addNewSeller(String CNIC, int Category) throws SQLException {
    	
    	String insertQuery = "INSERT INTO Seller (SellerID, CNIC, CategoryID) VALUES (?, ?, ?)";
    	Buyer U1=Buyer.getInstance();
    	//System.out.print(U1.getname());
    	
    	try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
            // Set the values for the insert query
            insertStatement.setInt(1, U1.getId());    // Set the SellerID (which is the BuyerID)
            insertStatement.setString(2, CNIC);      // Set CNIC for the Seller
            insertStatement.setInt(3, Category);  // Set CategoryID (assumed to be an integer)

            // Execute the insert statement
            int rowsInserted = insertStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("New seller added successfully.");
                return true;  // Indicate that the insertion was successful
            } else {
                System.out.println("Failed to add the new seller.");
                return false; // Indicate failure
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("An error occurred while adding the seller: " + e.getMessage());
            e.printStackTrace();
            return false; // Return false if an exception occurs
        }
    	
    	
    }
    
    public List<String> getAllAccounts() {
        List<String> accounts = new ArrayList<>();
        String query = "SELECT * FROM Accounts"; // Example table name
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                accounts.add(rs.getString("accountName")); // Example column
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

	public String getBuyerNameById(int buyerId) {
	        String buyerName = null;
	        String query = "select FName,LName from buyer where BuyerID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, buyerId);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    buyerName = rs.getString("Fname") + " " + rs.getString("Lname");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
        return buyerName;
	}

	public String getBuyerLocationById(int senderid) {
		String buyerName = null;
        String query = "select buyerlocation from buyer where BuyerID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, senderid);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    buyerName = rs.getString("buyerlocation");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return buyerName;
	}

	public String getBuyerPhoneById(int senderid) {
		String buyerName = null;
        String query = "select phone from buyer where BuyerID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, senderid);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    buyerName = rs.getString("phone");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return buyerName;
	}

	
}
