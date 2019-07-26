package Model;

import java.io.Serializable;
import java.util.*;

public class Hotel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	String name;
	int total_rooms;	
	float price;
	String amenities;
	String location;
	public ArrayList <Review> reviews;
	
	// constructor for a Hotel object
	public Hotel(String n, String l, int t, float  p) {
		name = n;
		location = l;
		price = p;
		total_rooms = t;

		reviews = new ArrayList<Review>();
	}
	public int retRooms() {
		return total_rooms;
	}
	public String retName() {
		return name;
	}
	public float retPrice() {
		return price;
	}
	public String retAmenities() {
		return amenities;
	}
	public String retLocation() {
		return location;
	}
	// adds a review and rating to the review vector
	public void addReview(int rate, String rev) {
		Review temp = new Review(rate, rev);
		reviews.add(temp);
	}
	/*
	public int roomAvailable(Date in, Date out) {
		for(int i=0; i<rooms.size(); i++) {
			if(in.before(rooms.get(i).check_in) && out.before(rooms.get(i).check_in)) {
				return i;
			}
			else if(in.after(rooms.get(i).check_out)) {
				return i;
			}			
		}
		return -1;	
	}
	
	
	*/
	public void addAmenities(String a) {
		amenities = a;
	}
	// use this to show color coded availability:
	// Green: if < 0.5  (Available)
	// Orange: if > 0.5 (Filling Fast)
	// Red: if 1 (Full)
	/*
	public float retAvailability() {
		return total_rooms-rooms.size();
	}
	*/
	public void showReviews() {
		for(int i=0; i<reviews.size(); i++) {
			System.out.println(reviews.get(i).review);
			System.out.println(reviews.get(i).rating);
		}
	}
	
	// try to draw corresponding number of stars
	// or draw a fill-up bar
	public float retRating() {
		float avg =0;
		for(int i=0; i<reviews.size(); i++) {
			avg+=reviews.get(i).rating;
		}
		return avg/reviews.size();
	}
	
}