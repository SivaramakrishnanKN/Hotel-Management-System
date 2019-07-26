package Controller;

import java.io.Serializable;
import java.util.Date;

import Database.*;
import Model.*;

public class Manager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 33;
	public UserList Users;
	public HotelList Hotels;
	public BookingList bookings;
	public WaitingList waiting;
	public Manager() {
		Users = new UserList();
		Hotels = new HotelList();
		bookings = new BookingList();
		waiting = new WaitingList();
		Date cur = new Date();
		for(int i=0; i<BookingList.bookings.size(); i++) {
			Booking sel = BookingList.bookings.get(i);
			if(cur.after(sel.check_out)) {
				BookingList.removeBooking(sel);
				WaitingList.popBooking(sel.hotel, sel);
				UserList.getUser(sel.usr_name).addDues(sel.hotel.retPrice()*sel.rooms);
			}
			
		}
		System.out.println("Booking List");
		for(int i=0; i<BookingList.bookings.size(); i++)
			BookingList.bookings.get(i).display();
		System.out.println("Waiting List");
		for(int i=0; i<WaitingList.waiting.size(); i++)
			WaitingList.waiting.get(i).display();
		
	}
	
}