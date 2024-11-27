package models;

import java.util.List;

public class Seller extends User {

    private long CNIC;
    private Earning earning;
    private List<Gig> listofgigs;
    private Feedback feedback;
    private int gigCategory;

    // Singleton instance
    private static Seller instance;

    // Private constructor to restrict instantiation
    private Seller(int id, String name, String username, String password, List<Order> orders, List<Chats> chats, Earning earn, List<Gig> listofgigs, Feedback feed, String location, String phone, long CNIC, int gigCategory) {
        super(id, name, username, password, orders, chats, phone, location);
        this.earning = earn;
        this.listofgigs = listofgigs;
        this.setFeedback(feed);
        this.CNIC = CNIC;
        this.gigCategory = gigCategory;
    }

    // Default constructor for flexibility (not part of Singleton)
    public Seller() {
        super();
    }

    // Public static method to provide access to the instance
    public static Seller getInstance(int id, String name, String username, String password, List<Order> orders, List<Chats> chats, Earning earn, List<Gig> listofgigs, Feedback feed, String location, String phone, long CNIC, int gigCategory) {
        if (instance == null) {
            instance = new Seller(id, name, username, password, orders, chats, earn, listofgigs, feed, location, phone, CNIC, gigCategory);
        }
        return instance;
    }

    // Getter for existing instance without resetting
    public static Seller getInstance() {
        if (instance == null) {
        	return null;
//            throw new IllegalStateException("Seller instance has not been created yet.");
        }
        return instance;
    }
    
    public static void resetInstance() {
        instance = null;
    }


    // Getters and Setters
    public List<Gig> getListofgigs() {
        return listofgigs;
    }

    public void setListofgigs(List<Gig> listofgigs) {
        this.listofgigs = listofgigs;
    }

    public Earning getEarning() {
        return earning;
    }

    public void setEarning(Earning earning) {
        this.earning = earning;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    @Override
    public void setDashboard() {
        System.out.println("Setting up Seller Dashboard");
    }

    @Override
    public void performingactions() {
        System.out.println("Seller performing actions");
    }

    public long getCNIC() {
        return CNIC;
    }

    public void setCNIC(long cNIC) {
        CNIC = cNIC;
    }

    public int getGigCategory() {
        return gigCategory;
    }

    public String getGigCategoryname() {
    	String categoryName;

        if (gigCategory == 1) {
            categoryName = "Appliance Technician";
        } else if (gigCategory == 2) {
            categoryName = "Blacksmith";
        } else if (gigCategory == 3) {
            categoryName = "Carpenter";
        } else if (gigCategory == 4) {
            categoryName = "Cook";
        } else if (gigCategory == 5) {
            categoryName = "Electrician";
        } else if (gigCategory == 6) {
            categoryName = "Glass Worker";
        } else if (gigCategory == 7) {
            categoryName = "Locksmith";
        } else if (gigCategory == 8) {
            categoryName = "Mechanic";
        } else if (gigCategory == 9) {
            categoryName = "Mason";
        } else if (gigCategory == 10) {
            categoryName = "Painter";
        } else if (gigCategory == 11) {
            categoryName = "Plumber";
        } else if (gigCategory == 12) {
            categoryName = "Pest Control";
        } else if (gigCategory == 13) {
            categoryName = "Plasterer";
        } else if (gigCategory == 14) {
            categoryName = "Sewage Cleaner";
        } else if (gigCategory == 15) {
            categoryName = "Technician";
        } else if (gigCategory == 16) {
            categoryName = "Tiler";
        } else if (gigCategory == 17) {
            categoryName = "Welder";
        } else if (gigCategory == 18) {
            categoryName = "Furniture Repairer";
        } else {
            categoryName = "Unknown Category";
        }
        return categoryName;
    	
    }
    public void setGigCategory(int gigCategory) {
        this.gigCategory = gigCategory;
    }

    public void addGig(Gig newgig) {
        listofgigs.add(newgig);
    }

    public void removeGig(int gigId) {
        listofgigs.removeIf(gig -> gig.getGigId() == gigId);
    }

	
}
