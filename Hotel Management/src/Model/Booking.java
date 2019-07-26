package Model;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 0;
	public Hotel hotel;
	public int rooms;
	public Date check_in;
	public Date check_out;
	public String usr_name;
	public void display() {
		System.out.println(usr_name);
		System.out.println(hotel.retName());
		System.out.println(hotel.retLocation());
		System.out.println(check_in);
		System.out.println(check_out);
		System.out.println(rooms+ "\n");
	}
	public Booking(Hotel h, String usr,int r, Date in, Date out) {
		hotel =h;
		rooms =r;
		check_in = in;
		check_out = out;
		usr_name = usr;
	}
}