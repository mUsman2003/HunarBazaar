package PersistentStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Buyer;
import models.Gig;
import models.Order;
import models.Seller;
import models.User;

public class OrderRepository implements Repository {
    private final Connection connection;

    public OrderRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM Orders"; // Example table name
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
//                orders.add(rs.getString("orderDetails")); // Example column
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
    
    public List<Order> getordersofSeller(int sellerid) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "Select* from Orders where SellerId = ? or Buyerid = ?"; // Example table name
        PreparedStatement preparedStatement3 = connection.prepareStatement(query);
	    preparedStatement3.setInt(1, sellerid);
	    preparedStatement3.setInt(2, sellerid);
	    Buyer s = Buyer.getInstance();
	    try (ResultSet resultSet3 = preparedStatement3.executeQuery()) {
	        List<Order> orderlist = new ArrayList<>();
	        while (resultSet3.next()) {
	            Order order = new Order();
	            order.setGigId(resultSet3.getInt("GigId"));
	            order.setOrderId(resultSet3.getInt("OrderId"));
	            order.setSellerId(resultSet3.getInt("SellerId"));
	            order.setBuyerId(resultSet3.getInt("BuyerId"));
	            order.setType(resultSet3.getString("OrderStatus"));
	            order.setStartDate(resultSet3.getDate("OrderDate"));
	            orderlist.add(order);
	        }
		        orders = orderlist;
		        s.setlistoforder(orderlist);
		}
        return orders;
    }

	public void setChangeStatus(Order order, String S, String string) throws SQLException{
		String query = "UPDATE orders SET OrderStatus = '"+ string + "' WHERE OrderStatus = '" + S + "' AND orderid = ?";
	    
	    // Prepare the statement
	    PreparedStatement preparedStatement3 = connection.prepareStatement(query);
	    
	    // Set the parameters for the prepared statement
	    preparedStatement3.setInt(1, order.getOrderId());

	    try {
	        // Execute the update query
	        int rowsAffected = preparedStatement3.executeUpdate();
	        
	        // Check if the update was successful
	        if (rowsAffected > 0) {
	            System.out.println("Order " + order.getOrderId() + " status changed to " + S);
	        } else {
	            System.out.println("No order found with the given ID or status is not 'Active'.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error updating order status.");
	    } finally {
	        // Close the PreparedStatement
	        if (preparedStatement3 != null) {
	            preparedStatement3.close();
	        }
	    }
		
	}

	public void setChangeFeedback(int orderId , double feedback) throws SQLException {
		// TODO Auto-generated method stub	
		int f = (int) Math.ceil(feedback);  
		String query = "UPDATE orders SET SellerReview = '"+ f + "' WHERE orderid = ?";
	    
	    // Prepare the statement
	    PreparedStatement preparedStatement3 = connection.prepareStatement(query);
	    
	    // Set the parameters for the prepared statement
	    preparedStatement3.setInt(1, orderId);

	    try {
	        // Execute the update query
	        int rowsAffected = preparedStatement3.executeUpdate();
	        
	        // Check if the update was successful
	        if (rowsAffected > 0) {
	            System.out.println("Feedback added ");
	        } else {
	            System.out.println("No order found with the given ID or status is not 'Active'.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error updating order status.");
	    } finally {
	        // Close the PreparedStatement
	        if (preparedStatement3 != null) {
	            preparedStatement3.close();
	        }
	    }
	}

	public int addnewOrder(Order order) {
		// TODO Auto-generated method stub
		//INSERT INTO Orders (GigID, SellerID, BuyerID, SellerReview, OrderStatus) VALUES    	(1, 1, 20, NULL, 'Pending')
		String insertQuery = "INSERT INTO Orders (GigID, SellerID, BuyerID, SellerReview, OrderStatus) VALUES (?, ?, ?, NULL, 'Active')";
        String idQuery = "SELECT SCOPE_IDENTITY() AS id"; // For SQL Server
        // For MySQL, use: "SELECT LAST_INSERT_ID() AS id";
        int generatedOrderId = -1;

        try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
             PreparedStatement idStmt = connection.prepareStatement(idQuery)) {

            // Set parameters for the INSERT query
            insertStmt.setInt(1, order.getGigId());
            insertStmt.setInt(2, order.getSellerId() );		//There is seller id instead of gig id
            insertStmt.setInt(3, order.getBuyerId());

            // Execute the INSERT query
            int rowsAffected = insertStmt.executeUpdate();

            if (rowsAffected > 0) {
                // Get the auto-generated ID
                try (ResultSet rs = idStmt.executeQuery()) {
                    if (rs.next()) {
                        generatedOrderId = rs.getInt("id");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("New gig id = " + generatedOrderId);
        return generatedOrderId; // Return the auto-generated ID
    
	}

	public List<Order> getListofOrders(int buyerId) {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM Orders WHERE BuyerID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Set the buyerId parameter
            stmt.setInt(1, buyerId);

            // Execute the query and process the result set
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Order order = new Order();

                    // Populate the Order object with data from the result set
                    order.setOrderId(rs.getInt("OrderID"));
                    order.setGigId(rs.getInt("GigID"));
                    order.setSellerId(rs.getInt("SellerID"));
                    order.setBuyerId(rs.getInt("BuyerID"));
                    order.setType(rs.getString("OrderStatus"));
//                    order.setStartDate(rs.getDate("OrderDate"));
                    // Add the Order object to the list
                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders; // Return the list of orders
}
}
