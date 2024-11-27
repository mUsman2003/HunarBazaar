package PersistentStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GigRepository implements Repository {
    private final Connection connection;

    public GigRepository(Connection connection) {
        this.connection = connection;
    }

    public List<String> getAllGigs() {
        List<String> gigs = new ArrayList<>();
        String query = "SELECT * FROM Gigs"; // Example table name
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                gigs.add(rs.getString("gigTitle")); // Example column
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gigs;
    }
}
