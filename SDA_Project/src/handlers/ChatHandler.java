package handlers;

import java.util.ArrayList;
import java.util.List;

import PersistentStorage.ChatRepository;
import PersistentStorage.PersistenceFactory;
import PersistentStorage.SQLServerHandler;

public class ChatHandler {
	
	public void addnewGig() {
		
	}
	public void filterGigs() {
		
	}
	
	public static void insertChatID(String message) {
			
			PersistenceFactory factory = new PersistenceFactory();
	        SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
	        ChatRepository chatRepo = sqlHandler.getChatRepository();
		    List<String> chat = new ArrayList<>(); // Declare and initialize the list
		    try {
		        // Fetch the category-specific gigs from GigHandler
		        chatRepo.insertChatID();
		    } catch (Exception e) {
		        e.printStackTrace(); // Log the exception
		    }
		    
		}

	
	public static void insertChatMessage(String message) {
		
		PersistenceFactory factory = new PersistenceFactory();
        SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        ChatRepository chatRepo = sqlHandler.getChatRepository();
	    List<String> chat = new ArrayList<>(); // Declare and initialize the list
	    try {
	        // Fetch the category-specific gigs from GigHandler
	        chatRepo.insertChatMessage(message);
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	    }
	    
	}


	public static List<String> getUserUniqueChats() {
		
		PersistenceFactory factory = new PersistenceFactory();
        SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        ChatRepository chatRepo = sqlHandler.getChatRepository();
	    List<String> chat = new ArrayList<>(); // Declare and initialize the list
	    try {
	        // Fetch the category-specific gigs from GigHandler
	        chat = chatRepo.getUserUniqueChats();
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	    }
	    return chat; // Return the list of gigs
	}
	
	public static List<String> getUserUniqueChatMessages() {
		
		PersistenceFactory factory = new PersistenceFactory();
        SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        ChatRepository chatRepo = sqlHandler.getChatRepository();
	    List<String> chat = new ArrayList<>(); // Declare and initialize the list
	    try {
	        // Fetch the category-specific gigs from GigHandler
	        chat = chatRepo.getUserUniqueChatMessages();
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	    }
	    
	    return chat; // Return the list of gigs
	}
	public static int getSelleridofChat(int chatId, int user) {
		// TODO Auto-generated method stub
		PersistenceFactory factory = new PersistenceFactory();
        SQLServerHandler sqlHandler = (SQLServerHandler) factory.createPersistenceHandler("SQLServer");
        ChatRepository chatRepo = sqlHandler.getChatRepository();
        return chatRepo.getSellerId(chatId, user);
	}

}
