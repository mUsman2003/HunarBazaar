package controllers;

import java.util.ArrayList;
import java.util.List;

import handlers.ChatHandler;

public class ChatController {
	
	private int SellerID;
	public static void insertChatMessage(String message) {
	    try {
	        // Fetch the category-specific chat from chathandler
	        handlers.ChatHandler.insertChatMessage(message);
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	    }
	}
	
	public static List<String> getUserUniqueChats() {
	    List<String> chat = new ArrayList<>(); // Declare and initialize the list
	    try {
	        // Fetch the category-specific chat from chathandler
	        chat = handlers.ChatHandler.getUserUniqueChats();
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	    }
	    return chat; // Return the list of chat
	}
	
	public static List<String> getUserUniqueChatMessages() {
	    List<String> chat = new ArrayList<>(); // Declare and initialize the list
	    try {
	        // Fetch the category-specific chat from chathandler
	        chat = handlers.ChatHandler.getUserUniqueChats();
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	    }
	    
	    return chat; // Return the list of chat
	}
	
	public void SetSellerID(int sellerID2) {
		SellerID=sellerID2;
		
	}
	
	public int getSellerID()
	{
		return SellerID;
	}

	public static int getSellerNamefromChat(int chatId, int user) {
		// TODO Auto-generated method stub
		return ChatHandler.getSelleridofChat(chatId, user);
	}
}
