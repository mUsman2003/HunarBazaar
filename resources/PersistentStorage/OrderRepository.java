package PersistentStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements Repository {
    private final Connection connection;

    public OrderRepository(Connection connection) {
        this.connection = connection;
    }

    public List<String> getAllOrders() {
        List<String> orders = new ArrayList<>();
        String query = "SELECT * FROM Orders"; // Example table name
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                orders.add(rs.getString("orderDetails")); // Example column
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
