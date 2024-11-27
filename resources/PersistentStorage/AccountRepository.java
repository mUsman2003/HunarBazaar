package PersistentStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements Repository {
    private final Connection connection;

    public AccountRepository(Connection connection) {
        this.connection = connection;
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
}
