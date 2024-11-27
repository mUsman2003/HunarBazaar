package PersistentStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackRepository implements Repository {
    private final Connection connection;

    public FeedbackRepository(Connection connection) {
        this.connection = connection;
    }

    public List<String> getAllFeedbacks() {
        List<String> feedbacks = new ArrayList<>();
        String query = "SELECT * FROM Feedback"; // Example table name
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                feedbacks.add(rs.getString("feedbackContent")); // Example column
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }
}
