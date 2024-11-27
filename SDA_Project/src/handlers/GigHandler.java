package handlers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PersistentStorage.AccountRepository;
import PersistentStorage.GigRepository;
import PersistentStorage.PersistenceFactory;
import PersistentStorage.SQLServerHandler;
import models.Gig;

public class GigHandler {
	public void addnewGig() {
		
	}
	public void filterGigs() {
		
	}
	public static List<String> getCategoryGigs() {
		
		PersistenceFactory factory = new PersistenceFactory();
        SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        GigRepository gigRepo = sqlHandler.getGigRepository();
	    List<String> gigs = new ArrayList<>(); // Declare and initialize the list
	    try {
	        // Fetch the category-specific gigs from GigHandler
	        gigs = gigRepo.getAllGigs();
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	    }
	    return gigs; // Return the list of gigs
	}
	public static int createGig(Gig newgig) {
		// TODO Auto-generated method stub
		PersistenceFactory factory = new PersistenceFactory();
        SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        GigRepository gigRepo = sqlHandler.getGigRepository();
        return gigRepo.createNewGig(newgig);
	}
	public static boolean deleteGig(int gigId) {
		// TODO Auto-generated method stub
		PersistenceFactory factory = new PersistenceFactory();
        SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        GigRepository gigRepo = sqlHandler.getGigRepository();
        return gigRepo.deleteGig(gigId);
	}
	public static List<Gig> getlistofgigs(int sellerId) throws SQLException {
		PersistenceFactory factory = new PersistenceFactory();
        SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        GigRepository gigRepo = sqlHandler.getGigRepository();
        return gigRepo.getGigsofSeller(sellerId);
	}
}