package handlers;

import models.User;


import java.sql.SQLException;

import PersistentStorage.AccountRepository;
import PersistentStorage.PersistenceFactory;
import PersistentStorage.SQLServerHandler;
import javafx.scene.control.Alert;


public class AccountHandler 
{
	 
    public static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
	public static User validateUser(String user, String pass) throws SQLException {
		PersistenceFactory factory = new PersistenceFactory();
        SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");

        // Use AccountRepository
        AccountRepository accountRepo = sqlHandler.getAccountRepository();
//        System.out.println("Accounts: " + accountRepo.getAllAccounts());
		User user1 = accountRepo.findUserByUsername(user, pass);
        if (user1 != null && user1.getpassword().equals(pass)) {
        	System.out.println("Account is confirmed");
            return user1;
        }
        sqlHandler.close();
        return null;
	}
	
	public static boolean isUsernameAndPhoneUnique(String user, String phone) throws SQLException {
	    // Initialize the persistence factory and SQL handler
	    PersistenceFactory factory = new PersistenceFactory();
	    SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");

	    try {
	        // Access the account repository
	        AccountRepository accountRepo = sqlHandler.getAccountRepository();

	        // Check if a user already exists with the given username and phone number
	        boolean existingUser = accountRepo.findUserByUsernameAndPhone(user, phone);
	        
	        if (existingUser == true) {
	        	showAlert("Validate error","The username or phone number already exists in the database.");
	            return false; // Return false if either exists
	        }
	        else
	        {
	        	// If no matching user is found
	     
	        	System.out.println("Username and phone number are unique.");
	        	return true; // Return true if both are unique
	        }
	        

	    } finally {
	        // Ensure proper resource cleanup
	        sqlHandler.close();
	    }
	}

	public static boolean addNewBuyer(String Fname, String Lname,String Uname,String phone,String Location,String Password) throws SQLException {
	    // Initialize the persistence factory and SQL handler
	    PersistenceFactory factory = new PersistenceFactory();
	    SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");

	    try {
	        // Access the account repository
	        AccountRepository accountRepo = sqlHandler.getAccountRepository();

	        // Check if a user already exists with the given username and phone number
	        boolean existingUser = accountRepo.addNewBuyer( Fname,  Lname, Uname, phone, Location, Password);
	        
	        if (existingUser == true) {
	            return true; // Return false if either exists
	        }

	        return false; // Return true if both are unique
	    } finally {
	        // Ensure proper resource cleanup
	        sqlHandler.close();
	    }
	}
	
	public static boolean addNewSeller(String CNIC, int Category) throws SQLException {
	    // Initialize the persistence factory and SQL handler
	    PersistenceFactory factory = new PersistenceFactory();
	    SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");

	    try {
	        // Access the account repository
	        AccountRepository accountRepo = sqlHandler.getAccountRepository();

	        // Check if a user already exists with the given username and phone number
	        boolean existingUser = accountRepo.addNewSeller(CNIC,Category);
	        
	        if (existingUser == true) {
	            return true; // Return false if either exists
	        }

	        return false; // Return true if both are unique
	    } finally {
	        // Ensure proper resource cleanup
	        sqlHandler.close();
	    }
	}

	public static String fetchBuyerName(int buyerId) {
		PersistenceFactory factory = new PersistenceFactory();
	    SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        AccountRepository accountRepo = sqlHandler.getAccountRepository();
		return accountRepo.getBuyerNameById(buyerId);
		
	}

	public static String fetchBuyerLocation(int senderid) {
		PersistenceFactory factory = new PersistenceFactory();
	    SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        AccountRepository accountRepo = sqlHandler.getAccountRepository();
		return accountRepo.getBuyerLocationById(senderid);
	}

	public static String fetchBuyerphone(int senderid) {
		PersistenceFactory factory = new PersistenceFactory();
	    SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        AccountRepository accountRepo = sqlHandler.getAccountRepository();
		return accountRepo.getBuyerPhoneById(senderid);
	}

}
