package Database;

import Model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.*;

public class HotelList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 10;
	public static ArrayList <Hotel> Hotels= new ArrayList<Hotel>();
	
	public static void getHotelList(){
        
        InputStream fileIs = null;
        ObjectInputStream objIs = null;
        try {
            fileIs = new FileInputStream("HotelList.txt");
            objIs = new ObjectInputStream(fileIs);
            Object obj = objIs.readObject();
            if(obj instanceof ArrayList<?>)
            	Hotels = (ArrayList<Hotel>) obj;
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
	
	public static ArrayList<Hotel> retHotels(String city) {
		ArrayList<Hotel> h = new ArrayList<Hotel>();
		for(int i=0; i<Hotels.size(); i++) {
			if(Hotels.get(i).retLocation().equals(city)==true) {
				h.add(Hotels.get(i));
			}
		}
		return h; 
	}
	public void addHotel(Hotel hotel){
        
        OutputStream ops = null;
        ObjectOutputStream objOps = null;
        try {
        	Hotels.add(hotel);
            ops = new FileOutputStream("HotelList.txt");
            objOps = new ObjectOutputStream(ops);
            objOps.writeObject(Hotels);
            
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
	
	public static int retIndex(Hotel h) {
		for(int i=0; i<Hotels.size(); i++) {
			if(h.retName().equals(Hotels.get(i).retName())&&h.retLocation().equals(Hotels.get(i).retLocation())) {
				return i;
			}
		}
		return -1;
	}
	public HotelList() {		
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel a = new Hotel("Hyatt", "Chennai", 3, 8000);
		// Add reviews and Facilities
		a.addReview(5, "Loved the stay here. Top class facilities");
		a.addReview(4, "Spacious rooms, good service");
		a.addReview(5, "Whatta wow!");
	    a.addAmenities("1.Pool\n 2.Wi-Fi\n 3.24 Hour Bar\n");
		addHotel(a);	
		
		Hotel b = new Hotel("Mariott", "Chennai", 2, 9500);
		// Add reviews and Facilities
		b.addReview(2, "This was one of the best places I hung out at. Loved the experience.");
		b.addReview(5, "The ambience was first class. Couldn't have felt more at home.");
		b.addReview(4, "It has great rooms and the scent on the pillow makes you feel at home.");
	        b.addAmenities("1.Fitness Center\n 2.Wi-Fi\n 3.24 hour Conference rooms\n 4.Sightseeing\n 5.24-hour front desk\n");
		addHotel(b);

		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel c = new Hotel("Holiday Inn", "Chennai", 2, 8000);
		// Add reviews and Facilities
		c.addReview(5, "I had a mesmerizing stay. I loved the view from my room.");
		c.addReview(4, "The staff was well behaved and it made me feel like I was in Utopia");
		c.addReview(3, "Bed was very comfortable, good for business stay.");
	        c.addAmenities("1.Pool\n 2.Wi-Fi\n 3.24 Hour Bar\n 4.Car hire\n 5.Lounge with open fire\n");
		addHotel(c);
		








	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel d = new Hotel("The Lemon Tree", "Hyderabad", 2, 6000);
		// Add reviews and Facilities
		d.addReview(4, "Very good work atmosphere, would visit again.");
		d.addReview(4, "Rooms look very good and ultra modern.");
		d.addReview(3, "Bathrooms were not cleaned properly. Else rooms were magnificent.");
	        d.addAmenities("1.24 hour Conference room\n 2.Wi-Fi\n 3.24 Hour Bar\n 4.Currency Exchange\n");
		addHotel(d);
		








	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel e = new Hotel("Red Fox", "Hyderabad", 3, 7000);
		// Add reviews and Facilities
		e.addReview(3, "Five minute walk from amazing restaurants and shopping complex.");
		e.addReview(3, "Staff was rude, and lacked manners");
		e.addReview(1, "Rooms were horribly maintained. Bathrooms reeked of bad smell.");
	        e.addAmenities("1.Pool\n 2.Wi-Fi\n 3.24 Hour Bar\n 4.24-hour front desk\n");
		addHotel(e);
		








	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel f = new Hotel("Hotel ShyamBharose", "Hyderabad", 1, 5000);
		// Add reviews and Facilities
		f.addReview(2, "No working facilities. Cold water in the showers");
		f.addReview(4, "Best Biryani I've tasted before with an ok view from the rooms");
		f.addReview(4, "Mediocre experience. Didn't face many problems.");
	        f.addAmenities("1.Pool\n 2.Wi-Fi\n 3.Air Conditioned rooms\n 4.Sightseeing\n 5.Currency Exchange\n 6.24-hour front desk\n");
		addHotel(f);
		 








	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel g = new Hotel("Bombay Duck", "Mumbai", 3, 11300);
		// Add reviews and Facilities
		g.addReview(5, "In the vicinity of all the major attractions. Enjoyed the stay.");
		g.addReview(3, "Small room but the ocean facing view was beautiful.");
		g.addReview(4, "Ambience was great");
	        g.addAmenities("1.Pool\n 2.Wi-Fi\n 3.24 Hour Bar\n 4.Sightseeing\n 5.24-hour front desk\n 6.Free Newspapers\n");
		addHotel(g);
		









	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel h = new Hotel("Seaview Apartments", "Mumbai", 1, 10000);
		// Add reviews and Facilities
		h.addReview(2, "Arrived with my family. Kids got an infection from sleeping in these rooms.");
		h.addReview(1, "Hated the experience, would not recommend to anyone");
		h.addReview(2, "Not advisable to visit");
	        h.addAmenities("1.Pool\n 2.Air Conditioned rooms\n 3.Sightseeing\n");
		addHotel(h);
		









	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel i = new Hotel("Holiday Inn", "Mumbai", 2, 3500);
		// Add reviews and Facilities
		i.addReview(5, "FANTASTIC ROOMS COULDN'T FIND ANY FLAWS");
		i.addReview(4, "You wont find anything better in the city.");
		i.addReview(5, "The pool was my favorite spot to stay at. All the facilities were top notch.");
	        i.addAmenities("1.Pool\n 2.Wi-Fi\n 3.Air Conditioned rooms\n 4.Sightseeing\n 5.Currency Exchange\n 6.Free Newspapers\n");
		addHotel(i);
		 









	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel j = new Hotel("Taj Allahi", "Delhi", 1, 5500);
		// Add reviews and Facilities
		j.addReview(3, "Mediocre experience. Nothing very special though.");
		j.addReview(4, "Placed in the middle of the city, close to the shopping complex.");
		j.addReview(5, "Really liked the room. Staff was great to us");
	        j.addAmenities("1.Sightseeing\n 2.Wi-Fi\n 3.24 Hour Bar\n 4. Wi-fi\n 5.Free Newspapers\n");
		addHotel(j);
		









	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel k = new Hotel("Blue Fox", "Delhi", 3, 6500);
		// Add reviews and Facilities
		k.addReview(3, "Spacious rooms and amazing food.");
		k.addReview(4, "Smelled great, reminded me of home.");
		k.addReview(3, "Mediocre experience, slept soundly");
	        k.addAmenities("1.Pool\n 2.Wi-Fi\n 3.Free Newspapers\n 4.Sightseeing\n");
		addHotel(k);
		









	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel l = new Hotel("Silver Lining", "Delhi", 2, 7500);
		// Add reviews and Facilities
		l.addReview(1, "No one at reception for 3 hours. Wasted my day.");
		l.addReview(2, "Room service was 6 hours late.");
		l.addReview(1, "Fleas in my bed. Don't go here.");
	        l.addAmenities("1.Pool\n 2.Wi-Fi\n 3.24 Hour Bar\n 4.Sightseeing\n");
		addHotel(l);
		









	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel m = new Hotel("Oceanview Guest House", "Kochi", 1, 2200);
		// Add reviews and Facilities
		m.addReview(5, "Loved the hotel. Especially the pick up and drop facility to the airport.");
		m.addReview(4, "This was a fun place to be at. New surprises everyday.");
		m.addReview(5, "Much better than what I was expecting. Would visit this place again.");
	        m.addAmenities("1.Air Conditioned rooms\n 2.Wi-Fi\n 3.24 Hour Bar\n 4.Currency Exchange\n");
		addHotel(m);
		









	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel n = new Hotel("Hotel Kamal", "Kochi", 2, 2700);
		// Add reviews and Facilities
		n.addReview(4, "Great value for money");
		n.addReview(3, "This was very economical. A steal for its facilities.");
		n.addReview(5, "Great for solo travellers. The rooms were just the right size.");
	        n.addAmenities("1.Pool\n 2.Air Conditioned rooms\n 3.24 Hour Bar\n");
		addHotel(n);
		








	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel o = new Hotel("Harrison Residency", "Kochi", 2, 6600);
		// Add reviews and Facilities
		o.addReview(2, "The bed was not comfortable. Wouldn't recommend.");
		o.addReview(4, "Close to tourist destinations. Relaxing experience.");
		o.addReview(5, "Awesome for single people. Staff was very friendly.");
	        o.addAmenities("1.Pool\n 2.Wi-Fi\n 3.24 Hour Bar\n 4.Free Newspapers\n 5.Finnish Sauna");
		addHotel(o);
		








	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel p = new Hotel("Hotel Pulusekara", "Goa", 4, 7400);
		// Add reviews and Facilities
		p.addReview(5, "The private beach was maintained well. Couldn't ask for anything better");
		p.addReview(5, "I loved this hotel. It was an awesome place to stay.");
		p.addReview(3, "Spacious rooms, good service");
	        p.addAmenities("1.Pool\n 2.Wi-Fi\n 3.24 Hour Bar\n 4.Air Conditioned rooms\n");
		addHotel(p);
		








	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel q = new Hotel("Neal Suites", "Goa", 1, 4500);
		// Add reviews and Facilities
		q.addReview(5, "Good food, Great service. ");
		q.addReview(2, "Meh");
		q.addReview(4, "Parents were having a great time. Lived upto expections");
	        q.addAmenities("1.Air Conditioned rooms\n 2.Wi-Fi\n 3.24 Hour Bar\n 4.Sightseeing\n 5.Finnish Sauna\n");
		addHotel(q);
		 






	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel r = new Hotel("Hotel Amrutha", "Goa", 1, 2500);
		// Add reviews and Facilities
		r.addReview(5, "Highlight of my trip. It made my trip much better than what it could have been");
		r.addReview(4, "Very fortunate to get a hotel in this location.");
		r.addReview(1, "This hotel is terrible. I got sick from staying here.");
	        r.addAmenities("1.Pool\n 2.Wi-Fi\n 3.24 Hour Bar\n 4.Currency Exchange\n");
		addHotel(r);
		 







	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel s = new Hotel("Eastside", "Pondicherry", 2, 3400);
		// Add reviews and Facilities
		s.addReview(1, "Broken windows. Didn't feel safe staying here.");
		s.addReview(3, "Family friendly. It was a fun place to stay.");
		s.addReview(5, "Everyday I stayed here was fun.");
	        s.addAmenities("1.Pool\n 2.Air Conditioned rooms\n 3.24 Hour Bar\n");
		addHotel(s);
		 







	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel t = new Hotel("Auro Inn", "Pondicherry", 2, 4500);
		// Add reviews and Facilities
		t.addReview(5, "Great location and even greater hospitality.");
		t.addReview(3, "Bathrooms were small, could have been bigger.");
		t.addReview(4, "Great place to relax with the family.");
	        t.addAmenities("1.Pool\n 2.Wi-Fi\n 3.24 Hour Bar\n"); 
		addHotel(t);
		 






	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel u = new Hotel("TR Residency", "Pondicherry", 1, 6700);
		// Add reviews and Facilities
		u.addReview(5, "Comfortable rooms and friendly staff.");
		u.addReview(4, "Best WiFi and clean showers.");
		u.addReview(4, "Location is epic, hotel is kind of small.");
	        u.addAmenities("1.Pool\n 2.Wi-Fi\n 3.Sightseeing\n 4.24 Hour Bar\n");
		addHotel(u);
	 







	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel v = new Hotel("Park Wood", "Bangalore", 2, 3400);
		// Add reviews and Facilities
		v.addReview(2, "Management was not well behaved.");
		v.addReview(1, "Bedsheets were not clean and food was bland.");
		v.addReview(2, "Bathrooms were outdated and dirty.");
	        v.addAmenities("1. Pool\n 2.Wi-Fi\n 3.24 Hour Bar\n");
		addHotel(v);
		 







	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel w = new Hotel("Hotel Grand Suites", "Bangalore", 2, 4200);
		// Add reviews and Facilities
		w.addReview(4, "Great value for money. Highly recommended. ");
		w.addReview(3, "Hotel and facilities are nice but location is horrible.");
		w.addReview(4, "Staff were nice and very helpful.");
	        w.addAmenities("1.Pool\n 2.Currency Exchange\n 3.24 Hour Bar\n 4.Air Conditioned rooms\n");
		addHotel(w);
		 







	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel x = new Hotel("Hotel RR International", "Bangalore", 1, 1200);
		// Add reviews and Facilities
		x.addReview(3, "Location was great but bedsheets had stains.");
		x.addReview(3, "Staff are cooperative but food could be better.");
		x.addReview(3, "Rooms are small but clean.");
	        x.addAmenities("1.Air Conditioned rooms\n 2.Wi-Fi\n 3.24 Hour Bar\n 4.Sightseeing\n");
		addHotel(x);
		 







	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel y = new Hotel("Vaishali Guest House", "Kolkata", 2, 3900);
		// Add reviews and Facilities
		y.addReview(4, "In the heart of the city. Close to sweet shops.");
		y.addReview(3, "Rooms were spacious but not very clean.");
		y.addReview(4, "Staff were courteous and helpful.");
	        y.addAmenities("1.Pool\n 2.Wi-Fi\n 3.Air Conditioned rooms and 24 Hour Bar\n");
		addHotel(y);
	 







	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel z = new Hotel("Saurabh Residency", "Kolkata", 1, 5000);
		// Add reviews and Facilities
		z.addReview(5, "Location was amazing and food was authentic Bengali cuisine.");
		z.addReview(4, "Spacious rooms, amazing service");
		z.addReview(5, "Rooms were ultra modern and bathrooms were super clean.");
	        z.addAmenities("1.Pool\n 2.Florist\n 3.24 Hour Bar\n 4.Currency Exchange\n 5.24-hour front desk\n");
		addHotel(z);
		 







	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel ad = new Hotel("Riverside Inn", "Kolkata", 2, 3500);
		// Add reviews and Facilities
		ad.addReview(3, "Great views but rooms were dusty.");
		ad.addReview(2, "AC and TV were not working. Very dissapointed.");
		ad.addReview(3, "Check in and check out took a lot of time.");
	        ad.addAmenities("1.Air Conditioned Rooms\n 2.Wi-Fi\n 3.24 Hour Bar\n 4.Sightseeing\n");
		addHotel(ad);
	 
	 






	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel aa = new Hotel("Hotel Rajput", "Jaipur", 3, 6000);
		// Add reviews and Facilities
		aa.addReview(5, "Ambience was top notch. Felt like a Rajput king.");
		aa.addReview(4, "Staff was very friendly and helpful.");
		aa.addReview(5, "Rooms were spacious with a great view of the city.");
	        aa.addAmenities("1.Pool\n 2.Wi-Fi\n 3.24 Hour Bar\n");
		addHotel(aa);
		 






	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel ab = new Hotel("Kohinoor Inn", "Jaipur", 2, 4700);
		// Add reviews and Facilities
		ab.addReview(3, "Location could have been better.");
		ab.addReview(3, "Small rooms, service needs improvement.");
		ab.addReview(4, "Food was delicous and authentic Rajasthani.");
	        ab.addAmenities("1.Air Conditioned rooms\n 2.Wi-Fi\n 3.24 Hour Bar\n 4.24-hour front desk\n 5.Finnish Sauna\n");
		addHotel(ab);
		






	 
		
		// Create a Hotel (name, location, total_rooms, price)
		Hotel ac = new Hotel("JP Residency", "Jaipur", 1, 3800);
		// Add reviews and Facilities
		ac.addReview(4, "Manager was very helpful as was the rest of the staff.");
		ac.addReview(3, "Rooms could have been bigger and cleaner.");
		ac.addReview(4, "Close to the Metro and local bazaar.");
	        ac.addAmenities("1.Fitness Center\n 2.Wi-Fi\n 3.24 Hour Bar\n 4.Air Conditioned rooms\n 5.Finnish Sauna\n");
		addHotel(ac);
		}
	
	}
	
