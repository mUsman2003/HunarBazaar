package PersistentStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Gig;
import models.Seller;
import models.category;

public class GigRepository implements Repository {
    private final Connection connection;

    public GigRepository(Connection connection) {
        this.connection = connection;
    }
    
    public List<Gig> getGigsofSeller(int sellerid) throws SQLException {
        List<Gig> gigs = new ArrayList<>();
	    String query3 = "SELECT * FROM gig WHERE SellerID = ?";
	    PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
	    preparedStatement3.setInt(1, sellerid);
	    Seller s = Seller.getInstance();
	    try (ResultSet resultSet3 = preparedStatement3.executeQuery()) {
	        List<Gig> giglist = new ArrayList<>();
	        while (resultSet3.next()) {
	            Gig gig = new Gig();
	            gig.setGigId(resultSet3.getInt("GigID"));
	            gig.setGigDescription(resultSet3.getString("GigDescription"));
	            if (s != null) {
 	            	gig.setGigCategory(s.getGigCategory());
	            }
	            else {
	            	gig.setGigCategory("");
	            }
	            giglist.add(gig);
	        }
	        gigs = giglist;
	    }

        return gigs;
    }

    public List<String> getAllGigs() {
        category c = category.getInstance(); // Get singleton instance
        int categoryID = c.getValue(); // Get the current category ID

        List<String> gigs = new ArrayList<>();
        String query = 
            "SELECT " +
            "   s.SellerID, " +
            "   b.FNAME + ' ' + b.LNAME AS SellerName, " +
            "   b.BuyerLocation AS SellerLocation, " +
            "   ROUND(AVG(CAST(o.SellerReview AS FLOAT)), 2) AS AvgSellerReview, " +
            "   g.GigDescription, " +
            "   c.CategoryType AS Category " +
            "FROM " +
            "   Orders o " +
            "JOIN " +
            "   Seller s ON o.SellerID = s.SellerID " +
            "JOIN " +
            "   Buyer b ON s.SellerID = b.BuyerID " +
            "JOIN " +
            "   Gig g ON o.GigID = g.GigID " +
            "JOIN " +
            "   Category c ON s.CategoryID = c.CategoryID " +
            "WHERE " +
            "   o.OrderStatus = 'Completed' AND s.CategoryID = ? " +
            "GROUP BY " +
            "   s.SellerID, b.FNAME, b.LNAME, b.BuyerLocation, g.GigDescription, c.CategoryType " +
            "ORDER BY " +
            "   AvgSellerReview DESC";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Set the category ID parameter in the query
            stmt.setInt(1, categoryID);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Retrieve values from the result set
                    int sellerID = rs.getInt("SellerID");
                    String sellerName = rs.getString("SellerName");
                    String sellerLocation = rs.getString("SellerLocation");
                    double avgReview = rs.getDouble("AvgSellerReview");
                    String gigDescription = rs.getString("GigDescription");
                    String category = rs.getString("Category");

                    // Format the gig details as a single string
                    String gigDetails = String.format(
                        "SellerID: %d; Seller: %s; Location: %s; Avg Review: %.2f; Description: %s; Category: %s",
                        sellerID, sellerName, sellerLocation, avgReview, gigDescription, category
                    );
                    gigs.add(gigDetails); // Add formatted gig details to the list
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log exception
        }

        return gigs;
    }
    
    
    public int createNewGig(Gig newgig) {
		// TODO Auto-generated method stub
	        String insertQuery = "INSERT INTO Gig (GigDescription, SellerID) VALUES (?, ?)";
	        String idQuery = "SELECT SCOPE_IDENTITY() AS id"; // For SQL Server
	        // For MySQL, use: "SELECT LAST_INSERT_ID() AS id";
	        int generatedGigId = -1;

	        try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
	             PreparedStatement idStmt = connection.prepareStatement(idQuery)) {

	            // Set parameters for the INSERT query
	            insertStmt.setString(1, newgig.getGigDescription());
	            insertStmt.setInt(2, newgig.getGigId() );		//There is seller id instead of gig id

	            // Execute the INSERT query
	            int rowsAffected = insertStmt.executeUpdate();

	            if (rowsAffected > 0) {
	                // Get the auto-generated ID
	                try (ResultSet rs = idStmt.executeQuery()) {
	                    if (rs.next()) {
	                        generatedGigId = rs.getInt("id");
	                    }
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        System.out.println("New gig id = " + generatedGigId);
	        return generatedGigId; // Return the auto-generated ID
	    
	}

	public boolean deleteGig(int gigId) {
		// TODO Auto-generated method stub
        String deleteQuery = "DELETE FROM Gig WHERE Gigid = ?";

        try (PreparedStatement stmt = connection.prepareStatement(deleteQuery)) {
            // Set the parameter for the DELETE query
            stmt.setInt(1, gigId);

            // Execute the DELETE query
            int rowsAffected = stmt.executeUpdate();
             if (rowsAffected > 0) {
            	 return true;
             }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
	}

	
	
}
