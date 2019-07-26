package Database;

import java.io.*;
import java.util.*;

import Model.*;

public class UserList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 11;
	public static ArrayList <User> Users = new ArrayList <User>();
	
	public UserList() {
		getUserList();
	}
	
	
	public static void addUser(User usr){
        
        OutputStream ops = null;
        ObjectOutputStream objOps = null;
        try {
        	Users.add(usr);
            ops = new FileOutputStream("UserList.txt");
            objOps = new ObjectOutputStream(ops);
            objOps.writeObject(Users);
            System.out.println("Object written successfullly");
            
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
	
	public static void getUserList(){
        
        InputStream fileIs = null;
        ObjectInputStream objIs = null;
        try {
            fileIs = new FileInputStream("UserList.txt");
            objIs = new ObjectInputStream(fileIs);
            Object obj = objIs.readObject();
            if(obj instanceof ArrayList<?>)
            	Users = (ArrayList<User>) obj;
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
	
	public int getIndex(String name) {
		for(int i=0; i<Users.size(); i++) {
			if(Users.get(i).getUserName().equals(name)==true)
				return i;
		}
		return -1;
	}
	
	public static User getUser(String name) {
		//getUserList();
		for(int i=0; i<Users.size(); i++) {
			if(Users.get(i).getUserName().equals(name)==true)
				return Users.get(i);
		}
		return null;
	}
	
	
}