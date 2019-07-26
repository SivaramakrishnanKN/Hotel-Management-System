package Model;

import java.io.Serializable;
import java.util.*;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID =4;
	String name;
	String address;
	String email;
	String user_name;
	Float dues;
	private String password;	
	Date dob;
	public float getDues() {
		return dues;
	}
	public User(String n, String a, String e, String u, String p) {
		name = n;
		address = a;
		email = e;
		user_name = u;
		password = p;	
		dues = (float) 0;
	}
	public void addDues(Float f) {
		dues+=f;
	}
	public Boolean Check_Passowrd (String p) {
		if(password.equals(p)==true) {
		return true;
		}
		else return false;
	}
	public String getName() {
		return this.name;
	}
	public String getEmail() {
		return this.email;
	}
	public String getPassword() {
		return this.password;
	}
	public String getUserName() {
		return this.user_name;
	}
	public String getAddress() {
		return this.address;
	}
	public void getInfo() {
		System.out.println("Name: "+name+"\nAddress: "+address+"\nEmail: "+email+"\nUsername: "+user_name+"\n");
	}
}