package models;

public class Feedback {
	private double rating;
	private String comment;
	
	Feedback(double rating, String comment){
		this.setRating(rating);
		this.setComment(comment);
	}

	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
