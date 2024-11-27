package models;

public class Gig {
	private int gigId;
	private String gigDescription;
	private String gigCategory;
	
	Gig(int id, String Title, String Description, String Category, int Price){
		this.gigId = id; 
		this.gigDescription = Description;
		this.gigCategory = Category;
	}

	
	public Gig() {
		// TODO Auto-generated constructor stub
	}

	public int getGigId() {
		return gigId;
	}

	public void setGigId(int gigId) {
		this.gigId = gigId;
	}

	

	public String getGigDescription() {
		return gigDescription;
	}

	public void setGigDescription(String gigDescription) {
		this.gigDescription = gigDescription;
	}

	public String getGigCategory() {
		return gigCategory;
	}

	public void setGigCategory(int i) {
//	
//		this.gigCategory = i;
	}

	public void showGigs(int SellerId) {
		
	}
	public void showGigDetail(int gigid) {
		
	}


	public void setGigCategory(String text) {
		// TODO Auto-generated method stub
		this.gigCategory = text;
	}
	
}
