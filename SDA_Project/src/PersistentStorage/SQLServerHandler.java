package PersistentStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Gig;

public class SQLServerHandler implements PersistenceHandler {

	private final Connection connection;
	
	public SQLServerHandler() {
        try {
            connection = SQLServerConnectionManager.getConnection();
            System.out.println("SQL Server connection established.");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to SQL Server", e);
        }
    }

    public AccountRepository getAccountRepository() {
        return new AccountRepository(connection);
    }

    public GigRepository getGigRepository() {
        return new GigRepository(connection);
    }

    public OrderRepository getOrderRepository() {
        return new OrderRepository(connection);
    }

    public FeedbackRepository getFeedbackRepository() {
        return new FeedbackRepository(connection);
    }
    
    public ChatRepository getChatRepository() {
        return new ChatRepository(connection);
    }

    @Override
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void saveData(String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String loadData() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
