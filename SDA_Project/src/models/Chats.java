package models;

import java.util.List;

public class Chats {
	private int chatId; 
	private int sellerId; 
	private int buyerId; 
	private String sender;
	private List<String> listofmessage;
	private int senderid;
	private static Chats instance;
	
	public static Chats getInstance() {
        if (instance == null) {
            instance = new Chats();
        }
        return instance;
    }
	
	Chats(int chat, int seller, int buyer, List<String> messages){
		this.chatId = chat;
		this.sellerId = seller;
		this.buyerId = buyer;
		this.listofmessage= messages;
	}

	public Chats() {
		// TODO Auto-generated constructor stub
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public List<String> getListofmessage() {
		return listofmessage;
	}

	public void setListofmessage(List<String> listofmessage) {
		this.listofmessage = listofmessage;
	}
	public void addmessage(String newmessage) {
		this.listofmessage.add(newmessage);
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
	@Override
    public String toString() {
		int senderId = 0;
		if(sender.equalsIgnoreCase("buyer")) {
			senderId = buyerId;
		}
		else if(sender.equalsIgnoreCase("seller")) {
			senderId = sellerId;
		} 
        return "ChatsID: " + chatId + ", SenderID: " + senderId;
    }

	public void setSenderId(int id) {
		// TODO Auto-generated method stub
		senderid = id;
	}

	public int getSenderid() {
		// TODO Auto-generated method stub
		return this.senderid;
	}
	
}
