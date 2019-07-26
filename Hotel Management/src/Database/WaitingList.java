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

public class WaitingList implements Serializable{
	public static ArrayList <Booking> waiting = new ArrayList<Booking>();
	
	public WaitingList() {
		getWaitingList();
	}
	public static void getWaitingList(){
        
        InputStream fileIs = null;
        ObjectInputStream objIs = null;
        try {
            fileIs = new FileInputStream("WaitingList.txt");
            objIs = new ObjectInputStream(fileIs);
            Object obj = objIs.readObject();
            if(obj instanceof ArrayList<?>)
            	waiting = (ArrayList<Booking>) obj;
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
	
	public ArrayList<Booking> retBooking(User usr) {
		ArrayList<Booking> h = new ArrayList<Booking>();
		for(int i=0; i<waiting.size(); i++) {
			if(waiting.get(i).usr_name.equals(usr.getUserName())==true) {
				h.add(waiting.get(i));
			}
		}
		return h; 
	}
	
	public static void removeBooking(Booking wait) {
		System.out.println("Deleted"+ wait.usr_name+ wait.hotel.retName()+ wait.hotel.retLocation() + wait.check_in +" " + wait.check_out);
		OutputStream ops = null;
        ObjectOutputStream objOps = null;
        try {
        	waiting.remove(wait);
        	waiting.trimToSize();
            ops = new FileOutputStream("WaitingList.txt");
            objOps = new ObjectOutputStream(ops);
            objOps.writeObject(waiting);
            
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
	
	
	public static void refreshList() {		
		ArrayList<Booking> wl = null;
		for(int i=0; i<HotelList.Hotels.size(); i++) {			
			wl = WaitingList.getList(HotelList.Hotels.get(i));
			for(int j=0; j< wl.size(); j++) {
				WaitingList.popBooking(HotelList.Hotels.get(i), wl.get(j));
			}
		}
		
	}
	public static void popBooking(Hotel hotel, Booking b) {
		OutputStream ops = null;
        ObjectOutputStream objOps = null;
        OutputStream ops1 = null;
        ObjectOutputStream objOps1 = null;
        try {
        	ArrayList <Booking> wait = getList(hotel);
        	System.out.println(wait.size());
        	
        	
        	int k=0; 
        	try {
        		
        		int avail=BookingList.roomsAvailable(b, hotel);
        		System.out.println(avail+ "rooms available");
        	System.out.println(wait.get(k).rooms + "Rooms req");
        	if(avail>=wait.get(k).rooms) {
        		Booking booking = wait.get(k);
            	waiting.remove(booking);
            	waiting.trimToSize();
            	BookingList.bookings.add(booking);
                ops = new FileOutputStream("WaitingList.txt");
                objOps = new ObjectOutputStream(ops);
                objOps.writeObject(waiting);
                System.out.println("Object written successfullly");
                ops1 = new FileOutputStream("BookingList.txt");
                objOps1 = new ObjectOutputStream(ops1);
                objOps1.writeObject(BookingList.bookings);
                avail=BookingList.roomsAvailable(b, hotel);
        		System.out.println(avail+ "rooms left");
                objOps.flush();
        	}
        	}
        	catch(IndexOutOfBoundsException ie) {
    			
    		}
        	
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
            	if(objOps1 != null) objOps1.close();
                if(objOps != null) objOps.close();
            } catch (Exception ex){
                 
            }
        }
        int avail=BookingList.roomsAvailable(b, hotel);
        
        
    }
	public static ArrayList <Booking> getList(Hotel hotel) {
		ArrayList <Booking> temp = new ArrayList <Booking>();
		for(int i=0; i<waiting.size(); i++) {
			if(waiting.get(i).hotel.retName().equals(hotel.retName())&&waiting.get(i).hotel.retLocation().equals(hotel.retLocation())) {
				temp.add(waiting.get(i));
			}
		}
		return temp;
	}
	public static Boolean addBooking(Booking booking){
        
        OutputStream ops = null;
        ObjectOutputStream objOps = null;
        try {        	
        	
        	waiting.add(booking);
            
        	ops = new FileOutputStream("WaitingList.txt");
            objOps = new ObjectOutputStream(ops);
            objOps.writeObject(waiting);
            System.out.println("Object written successfullly");
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