package PersistentStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Gig;
import models.Buyer;
import models.Chats;
import models.Seller;
import models.User;

public class ChatRepository implements Repository {
    private final Connection connection;


	public ChatRepository(Connection connection) {
		this.connection = connection;
	}

    public List<Chats> getAllchats() {
        List<Chats> chats = new ArrayList<>();
        String query = "SELECT * FROM chats"; // Example table name
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
//                chats.add(rs.getString("chatDetails")); // Example column
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chats;
    }
    
    public List<Chats> getchatsofSeller(int sellerid) throws SQLException {
        List<Chats> chats = new ArrayList<>();
        String query = "Select* from chat where (Sender = ?)"; // Example table name
        PreparedStatement preparedStatement3 = connection.prepareStatement(query);
	    preparedStatement3.setInt(1, sellerid);
//	    Buyer s = Buyer.getInstance();
	    try (ResultSet resultSet3 = preparedStatement3.executeQuery()) {
	    	System.out.println("Adding Chats " + sellerid );
	        List<Chats> chatlist = new ArrayList<>();
	        while (resultSet3.next()) {
	        	Chats chat = new Chats();
	            chat.setChatId(resultSet3.getInt("ChatId"));
	            chat.setSellerId(resultSet3.getInt("SellerId"));
	            chat.setBuyerId(resultSet3.getInt("BuyerId"));
	            chat.setSender(resultSet3.getString("CurrentUser"));
	            String query2 = "select* from ChatMessages inner join Chat on chatId = msgId where chatId = ? and (Sellerid = ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(query2);
	            preparedStatement.setInt(1, chat.getChatId());
	            preparedStatement.setInt(2, chat.getSellerId());
	            try(ResultSet resultSet = preparedStatement.executeQuery()){
	            	List<String> messages = new ArrayList<>();
	            	String newmessage = new String();
	            	while (resultSet.next()) {
	            		String newMessage = resultSet.getString("MessageDescription");
	            	    messages.add(newMessage);
	            	}
	            	chat.setListofmessage(messages);
	            }
	            chatlist.add(chat);
	        }
	        
	        chats = chatlist;
		}
        return chats;
    }
    
    public void insertChatMessage(String message)
	{
		Chats c=Chats.getInstance();
		Buyer b=Buyer.getInstance();
		String query = "INSERT INTO ChatMessages (ChatID, Sender, MessageDescription) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        // Set the values for the placeholders in the query
	        stmt.setInt(1, c.getChatId()); // Set the ChatID
	        stmt.setInt(2, b.getId()); // Set the Sender ID (buyer ID)
	        stmt.setString(3, message); // Set the message content

	        // Execute the insert statement
	        int rowsAffected = stmt.executeUpdate();

	        // Check if the insertion was successful
	        if (rowsAffected > 0) {
	            System.out.println("Message inserted successfully.");
	        } else {
	            System.out.println("Failed to insert message.");
	        }
	    } catch (SQLException e) {
	        // Handle any exceptions (e.g., connection errors, SQL issues)
	        e.printStackTrace();
	    }
	}
    
    public void insertChatID() {
        Buyer buyer = Buyer.getInstance(); // Get Buyer instance
        String currentUser = "Seller"; // Static value for CurrentUser
        
        String query = "INSERT INTO Chat (Sender, Reciver, CurrentUser) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Set the placeholders in the query
            stmt.setInt(1, buyer.getId()); // Set Sender (Buyer's ID)
            stmt.setInt(2, this.getSellerID()); // Set Receiver (Seller's ID from method)
            stmt.setString(3, "Buyer"); // Set CurrentUser (e.g., 'Seller')

            // Execute the query
            int rowsAffected = stmt.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                System.out.println("Chat entry inserted successfully.");
            } else {
                System.out.println("Failed to insert chat entry.");
            }
        } catch (SQLException e) {
            // Handle exceptions
            System.err.println("Error while inserting into Chat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void insertChatIDSeller(int SellerID) {
        Buyer buyer = Buyer.getInstance(); // Get Buyer instance
        String currentUser = "Seller"; // Static value for CurrentUser
        
        String query = "INSERT INTO Chat (Sender, Reciver, CurrentUser) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Set the placeholders in the query
            stmt.setInt(1, buyer.getId()); // Set Sender (Buyer's ID)
            stmt.setInt(2, SellerID); // Set Receiver (Seller's ID from method)
            stmt.setString(3, "Seller"); // Set CurrentUser (e.g., 'Seller')

            // Execute the query
            int rowsAffected = stmt.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                System.out.println("Chat entry inserted successfully.");
            } else {
                System.out.println("Failed to insert chat entry.");
            }
        } catch (SQLException e) {
            // Handle exceptions
            System.err.println("Error while inserting into Chat: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void insertChatIDBuyer(int SellerID) {
        Buyer buyer = Buyer.getInstance(); // Get Buyer instance
        String currentUser = "Seller"; // Static value for CurrentUser
        
        String query = "INSERT INTO Chat (Sender, Reciver, CurrentUser) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Set the placeholders in the query
            stmt.setInt(1, buyer.getId()); // Set Sender (Buyer's ID)
            stmt.setInt(2, SellerID); // Set Receiver (Seller's ID from method)
            stmt.setString(3, "Buyer"); // Set CurrentUser (e.g., 'Seller')

            // Execute the query
            int rowsAffected = stmt.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                System.out.println("Chat entry inserted successfully.");
            } else {
                System.out.println("Failed to insert chat entry.");
            }
        } catch (SQLException e) {
            // Handle exceptions
            System.err.println("Error while inserting into Chat: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    public List<String> getUserUniqueChats() {
	    List<String> uniqueChats = new ArrayList<>();
	    
	    Buyer buyer = Buyer.getInstance(); // Get the current logged-in buyer instance
	    int userId = buyer.getId(); // Get the current user's ID

	    String query = "{CALL GetUserUniqueChatsWithOppositeUser(?)}"; // Stored procedure call

	    try (CallableStatement stmt = connection.prepareCall(query)) {
	        stmt.setInt(1, userId); // Set the user ID parameter

	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                int chatId = rs.getInt("ChatID"); // Get the chat ID
	                String oppositeUserName = rs.getString("OppositeUserName"); // Get the opposite user's name
	                
	                // Format the chat details
	                String chatDetails = String.format("Chat ID: %d, Opposite User: %s", chatId, oppositeUserName);
	                
	                uniqueChats.add(chatDetails); // Add formatted chat details to the list
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Log the exception
	    }

	    return uniqueChats; // Return the list of unique chats
	}
    
    public List<String> getUserUniqueChatMessages() {
	    List<String> uniqueChats = new ArrayList<>();
	    
	    Buyer buyer = Buyer.getInstance(); // Get the current logged-in buyer instance
	    Chats chat = Chats.getInstance();
	    int userId = buyer.getId(); // Get the current user's ID

	    String query = "{CALL GetChatMessagesWithSender(?, ?)}"; // Stored procedure call to get chat messages with sender

	    try (CallableStatement stmt = connection.prepareCall(query)) {
	        stmt.setInt(1, chat.getChatId()); // Set the user ID parameter (this would typically be the userID of the logged-in user)
	        stmt.setInt(2, userId); // Second parameter could be used to filter the chat by the sender ID, if needed.

	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                int chatId = rs.getInt("MessageID"); // Get the chat ID
	                String message = rs.getString("MessageDescription"); // Get the message content
	                Timestamp timestamp = rs.getTimestamp("Timestamp"); // Get the timestamp
	                int senderId = rs.getInt("Sender"); // Get the sender's ID

	                // Format the chat message details
	                String chatDetails = String.format("Chat ID: %d, Sender ID: %d, Message: %s",
	                    chatId, senderId, message);

	                uniqueChats.add(chatDetails); // Add formatted chat details to the list
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Log the exception
	    }
	    

	    return uniqueChats; // Return the list of chat messages with sender details
	}
    
    private int SellerID;
   	public void SetSellerID(int sellerID2) {
   		SellerID=sellerID2;
   		
   	}
   	public int getSellerID()
   	{
   		return SellerID;
   	}

	public int getSellerId(int chatId, int user) {
		// TODO Auto-generated method stub
		String query = "SELECT CASE WHEN sender = ? THEN reciver WHEN reciver = ? THEN sender END AS OppositeUserID FROM Chat WHERE ChatID = ?"; // Stored procedure call
		int id = 0;
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, user);
	            stmt.setInt(2, user);
	            stmt.setInt(3, chatId);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                	id = rs.getInt("OppositeUserID");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	    } 
	    return id;
	}
   	

}
