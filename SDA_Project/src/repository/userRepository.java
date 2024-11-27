package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Buyer;
import models.User;

public class userRepository{
	
	
	public static User findUserByUsername(String user, String pass) {
		// TODO Auto-generated method stub
		// Execute the 
		String connectionString = 
	            "jdbc:sqlserver://IRTAZA-KHAN\\SQLEXPRESS:1433;Database=firsttemp;encrypt=false;trustServerCertificate=true;integratedSecurity=true;";

	        // SQL query to find the user
	        String query = "SELECT * FROM Buyer WHERE username = ? AND password = ?";

	        try (Connection connection = DriverManager.getConnection(connectionString)) {
	            System.out.println("Connection established.");

	            // Prepare the SQL statement
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, user);
	            preparedStatement.setString(2, pass);

	            // Execute the query and get the result
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    // If user is found, create a User object and return it
	                    Buyer user1 = new Buyer();
	                    user1.setid(resultSet.getInt("BuyerID")); // Assuming "userID" is a column
	                    user1.setname(resultSet.getString("Fname") + ' ' + resultSet.getString("Lname"));
	                    user1.setusername(resultSet.getString("username"));
	                    user1.setpassword(resultSet.getString("password"));
	                    user1.setphonenumber(resultSet.getString("Phone"));
	                    user1.setlocation(resultSet.getString("BuyerLocation"));
	                    
	                    return user1;
	                } else {
	                    // If no user is found, return null
	                    System.out.println("No user found with the given username and password.");
	                    return null;
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println("Error connecting to the database or executing the query.");
	            e.printStackTrace();
	        }
		return null;
	}
	
}