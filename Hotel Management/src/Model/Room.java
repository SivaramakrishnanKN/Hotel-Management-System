package Model;

import java.io.Serializable;
import java.util.Date;

public class Room implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID =3;
	Date check_in;
	Date check_out;
	User occupant;
	public Boolean isOccupied() {
		Date cur = new Date();
		if(cur.after(check_out)) {
			return false;
		}
		else 
			return true;
	}
	public Room(Date in, Date out) {
		check_in = in;
		check_out = out;
	}
}