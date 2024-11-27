package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import handlers.GigHandler;
import models.Gig;

public class GigController {
	public void viewgig() {
		
	}
	public void addGig() {
		
	}
	
	public static List<String> getCategoryGigs() {
	    List<String> gigs = new ArrayList<>(); // Declare and initialize the list
	    try {
	        // Fetch the category-specific gigs from GigHandler
	        gigs = handlers.GigHandler.getCategoryGigs();
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	    }
	    return gigs; // Return the list of gigs
	}
	public static int createGig(Gig newgig) {
		// TODO Auto-generated method stub
		return handlers.GigHandler.createGig(newgig);
		
	}
	public static boolean deleteGig(int gigId) {
		// TODO Auto-generated method stub
		return GigHandler.deleteGig(gigId);
		
	}
	public static List<Gig> getListOfGigs(int sellerId) throws SQLException {
//	    List<Gig> gigs = new ArrayList<>();
//	    String connectionString = 
//	            "jdbc:sqlserver://IRTAZA-KHAN\\SQLEXPRESS:1433;Database=SDA_Project;encrypt=false;trustServerCertificate=true;integratedSecurity=true;";
//
//	    String query = "SELECT * FROM gig WHERE sellerid = ?";
//	        try {
//	            try (Connection connection = DriverManager.getConnection(connectionString)) {
//	                System.out.println("Connection established.");
//	                try (PreparedStatement statement = connection.prepareStatement(query)) {
//	        	        statement.setInt(1, sellerId);
//	        	        ResultSet resultSet = statement.executeQuery();
//	        	        while (resultSet.next()) {
//	        	            Gig gig = new Gig();
//	        	            gig.setGigId(resultSet.getInt("gigid"));
//	        	            gig.setGigDescription(resultSet.getString("Gigdescription"));
//	        	            gigs.add(gig);
//	        	        }
//	        	    } catch (SQLException e) {
//	        	        e.printStackTrace();
//	        	    }
//	                // Create a Statement to execute SQL queries
//
//	            } finally {
//				}
//	        } catch (SQLException e) {
//	            System.out.println("Error connecting to the database");
//	            e.printStackTrace();
//	        }
//	    
		List<Gig> gigs = GigHandler.getlistofgigs(sellerId);
	    return gigs;
	}
}
