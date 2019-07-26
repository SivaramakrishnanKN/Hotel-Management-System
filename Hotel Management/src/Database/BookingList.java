package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Model.*;

public class BookingList implements Serializable{
	public static ArrayList <Booking> bookings = new ArrayList<Booking>();
	
	public BookingList() {
		getBookingList();
	}
	public static void getBookingList(){
        
        InputStream fileIs = null;
        ObjectInputStream objIs = null;
        try {
            fileIs = new FileInputStream("BookingList.txt");
            objIs = new ObjectInputStream(fileIs);
            Object obj = objIs.readObject();
            if(obj instanceof ArrayList<?>)
            	bookings = (ArrayList<Booking>) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(objIs != null) objIs.close();
            } catch (Exception ex){
                 
            }
        }         
    }
	
	public static ArrayList<Booking> retBooking(User usr) {
		ArrayList<Booking> h = new ArrayList<Booking>();
		for(int i=0; i<bookings.size(); i++) {
			if(bookings.get(i).usr_name.equals(usr.getUserName())==true) {
				h.add(bookings.get(i));
			}
		}
		return h; 
	}
	public static void removeBooking(Booking booking) {
		System.out.println("Deleted"+ booking.usr_name+ booking.hotel.retName()+ booking.hotel.retLocation() + booking.check_in +" " + booking.check_out);
		OutputStream ops = null;
        ObjectOutputStream objOps = null;
        try {
        	bookings.remove(booking);
        	bookings.trimToSize();
            ops = new FileOutputStream("BookingList.txt");
            objOps = new ObjectOutputStream(ops);
            objOps.writeObject(bookings);
            
            objOps.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(objOps != null) objOps.close();
            } catch (Exception ex){
                 
            }
        }
         
    }
	
	static void showbookings(ArrayList<Booking> b) {
		for(int i=0; i<b.size(); i++) {
			b.get(i).display();
		}
	}
	
	
	public static ArrayList <Booking> getList(Hotel hotel) {		
		ArrayList <Booking> temp = new ArrayList <Booking>();
		for(int i=0; i<bookings.size(); i++) {
			if(bookings.get(i).hotel.retName().equals(hotel.retName())==true&&bookings.get(i).hotel.retLocation().equals(hotel.retLocation())==true) {
				temp.add(bookings.get(i));
				bookings.get(i).display();
			}
		}	
		showbookings(temp);
		return temp;
	}
	
	
	public static int roomsAvailable(Booking booking, Hotel h) {
		
		int avail = h.retRooms();
		
    	ArrayList <Booking> temp = BookingList.getList(h);    	
    	for(int i=0; i<temp.size(); i++) {      		
    		if((booking.check_in.compareTo(temp.get(i).check_in)>=0)&&(booking.check_in.compareTo(temp.get(i).check_out)<=0)) {
    			avail-=temp.get(i).rooms;
    		}
    		else if((booking.check_in.compareTo(temp.get(i).check_in)<=0)&&(booking.check_out.compareTo(temp.get(i).check_out)>=0)) {
    			avail-=temp.get(i).rooms;
    		}
    		else if((booking.check_in.compareTo(temp.get(i).check_in)<=0)&&(booking.check_out.compareTo(temp.get(i).check_out)<=0)) {
    			avail-=temp.get(i).rooms;
    		}
    	}
    	return avail;
	}
	
	public Boolean addBooking(Booking booking, String City, int hIndex){
        
        OutputStream ops = null;
        ObjectOutputStream objOps = null;
        try {
        	
        	int avail = roomsAvailable(booking, HotelList.retHotels(City).get(hIndex));
        	System.out.println(Integer.toString(avail)+" rooms available");
        	if(avail<booking.rooms) {
        		
        		System.out.println("Waiting List");
        		WaitingList.addBooking(booking);
        		return false;
        	}
        	else {
        	bookings.add(booking);
        	System.out.println("Booking List");
        	}
        	avail = roomsAvailable(booking,HotelList.retHotels(City).get(hIndex));
        	System.out.println(Integer.toString(avail)+" rooms left");

        	
        	ops = new FileOutputStream("BookingList.txt");
            objOps = new ObjectOutputStream(ops);
            objOps.writeObject(bookings);
            
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(objOps != null) objOps.close();
            } catch (Exception ex){
                 
            }
        }
         return false;
    }
}