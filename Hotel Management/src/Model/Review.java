package Model;

import java.io.Serializable;

public class Review implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID =2;
	String review;
	int rating;
	public String retReview() {
		return review;
	}
	public int retRating() {
		return rating;
	}
	public Review(int ra, String re) {
		rating = ra;
		review = re;
	}
}