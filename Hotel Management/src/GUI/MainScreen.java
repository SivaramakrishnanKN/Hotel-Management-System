package GUI;

import Controller.*;
import Database.BookingList;
import Database.HotelList;
import Database.UserList;
import Database.WaitingList;
import Model.*;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainScreen extends JFrame implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID =123;

	public static void main(String[] args) {
		Manager manager = new Manager();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new HomePage(manager);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

class HomePage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 20;

	HomePage(Manager manager) {
		// Creating the Layout
		
		setSize(1920,1080);
		JLabel bg=new JLabel(new ImageIcon("C:\\Users\\siva9\\eclipse-workspace\\Hotel Management\\src\\dark-background-with-star-like-dots_bkpaotdgh__F0000.png"));
		bg.setBounds(0, 0, 1920, 1080);		
		bg.setLayout(null);
		add(bg);
		
		// Adding Label
		JLabel l = new JLabel("Welcome to our Hotel Booking System");
		l.setBounds(375,200,10000,100);
		l.setFont(new Font("Trajan Pro 3", 1, 50));
		l.setForeground(Color.RED);
		bg.add(l);
		
		// Adding a Sign Up button
		JButton sign_up = new JButton("Sign Up");
		sign_up.setFont(new Font("Trajan Pro 3",1,18));
		sign_up.setBounds(800, 500, 120, 60);
		sign_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SignUpPage(manager);
			}
		});
		sign_up.setActionCommand("Sign Up");
		bg.add(sign_up);
		
		// Adding a Log in button
		JButton log_in = new JButton("Login");
		log_in.setFont(new Font("Trajan Pro 3",1,18));
		log_in.setBounds(1000, 500, 120, 60);
		log_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginPage(manager);
			}
		});
		log_in.setActionCommand("Login");
		bg.add(log_in);
				
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class LoginPage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 22;

	public LoginPage(Manager manager) {
		// Creating the Layout
		
		setSize(1920,1080);
		setTitle("Login Page");
		JLabel bg=new JLabel(new ImageIcon("C:\\Users\\siva9\\eclipse-workspace\\Hotel Management\\src\\dark-background-with-star-like-dots_bkpaotdgh__F0000.png"));
		bg.setBounds(0, 0, 1920, 1080);		
		bg.setLayout(null);
		add(bg);
		
		JLabel t = new JLabel("Login");
		t.setForeground(Color.CYAN);
		t.setBounds(900,100,400,50);
		t.setFont(new Font("Trajan Pro 3",1,35));
		bg.add(t);
		
		// Adding Label
		JLabel u = new JLabel("User Name:");
		u.setForeground(Color.WHITE);
		u.setBounds(650,250,200,50);
		u.setFont(new Font("Trajan Pro 3",1,22));
		bg.add(u);
		// Creating a textfield for login
		JTextField user_name = new JTextField("");
		user_name.setBounds(1050,250, 200, 50);
		bg.add(user_name);
		
		JPasswordField pwd = new JPasswordField("");
		pwd.setBounds(1050, 400, 200, 50);
		bg.add(pwd);
		
		JLabel p = new JLabel("Password:");
		p.setForeground(Color.WHITE);
		p.setFont(new Font("Trajan Pro 3",1,22));
		p.setBounds(650,400,200,50);
		bg.add(p);
		
		JLabel m = new JLabel("");
		m.setBounds(825,500,500,50);
		bg.add(m);
		
		JButton log_in = new JButton("Login");
		log_in.setFont(new Font("Trajan Pro 3",1,22));
		log_in.setBounds(700, 650, 200, 50);
		log_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usr_name = user_name.getText();
				String password = new String(pwd.getPassword());
				if(manager.Users.getIndex(usr_name)==-1) {
					m.setFont(new Font("Ariel",1,22));
					
					m.setForeground(Color.RED);
					m.setText("User name does not exist");
					user_name.setText("");
					pwd.setText("");
				}
				else
					if(UserList.getUser(usr_name).Check_Passowrd(password)==true) {
						m.setForeground(Color.GREEN);
						m.setFont(new Font("Ariel",1,22));
						m.setText("Logged in successfully");
						dispose();
						new BookingPage(manager, manager.Users.getIndex(usr_name));
					}
					else {
						m.setForeground(Color.RED);
						m.setFont(new Font("Ariel",1,22));
						m.setText("Incorrect Password");
						user_name.setText("");
						pwd.setText("");
					}
			}
		});
		log_in.setActionCommand("Login");
		bg.add(log_in);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Trajan Pro 3",1,22));
		back.setBounds(1000, 650, 200, 50);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
				new HomePage(manager);
			}
		});
		back.setActionCommand("Back");
		bg.add(back);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
/*
class Sign extends JFrame {
	public Sign() {
		setSize(1920,1080);
		setTitle("Sign Up Page");
		JLabel bg=new JLabel(new ImageIcon("C:\\Users\\siva9\\eclipse-workspace\\Hotel Management\\src\\Homespun_2560x1600_by_hermik.jpg"));
		bg.setBounds(0, 0, 1920, 1080);		
		bg.setLayout(null);
		add(bg);
		
		JLabel u = new JLabel("User Name:");
		u.setBounds(250,200,200,50);
		u.setFont(new Font("Trajan Pro 3",1,22));
		bg.add(u);
		JTextField user_name = new JTextField("");
		user_name.setBounds(600,200, 200, 50);
		bg.add(user_name);
		JLabel n = new JLabel("Name:");
		n.setBounds(250,250,200,50);
		n.setFont(new Font("Trajan Pro 3",1,22));
		bg.add(n);
		// Creating a textfield for login
		JTextField name = new JTextField("");
		name.setBounds(600,250, 200, 50);
		bg.add(name);
		
		JLabel a = new JLabel("Address:");
		a.setBounds(250,300,200,50);
		a.setFont(new Font("Trajan Pro 3",1,22));
		bg.add(a);
		// Creating a textfield for login
		JTextField addr = new JTextField("");
		addr.setBounds(600,300, 200, 50);
		bg.add(addr);
		
		JLabel p = new JLabel("Password:");
		p.setBounds(250,350,100,50);
		p.setFont(new Font("Trajan Pro 3",1,22));
		bg.add(p);
		JPasswordField pwd = new JPasswordField("");
		pwd.setBounds(600, 350, 100, 50);
		add(pwd);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}*/

class SignUpPage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 23;

	public SignUpPage(Manager manager) {
		// Creating the Layout
		setSize(1920,1080);
		setTitle("Sign Up Page");
		JLabel bg=new JLabel(new ImageIcon("C:\\Users\\siva9\\eclipse-workspace\\Hotel Management\\src\\dark-background-with-star-like-dots_bkpaotdgh__F0000.png"));
		bg.setBounds(0, 0, 1920, 1080);		
		bg.setLayout(null);
		add(bg);
		
		JLabel t = new JLabel("Sign Up");
		t.setForeground(Color.CYAN);
		t.setBounds(900,100,400,50);
		t.setFont(new Font("Trajan Pro 3",1,35));
		bg.add(t);
		
		
		// Adding Label
		JLabel u = new JLabel("User Name:");
		u.setForeground(Color.WHITE);
		u.setBounds(750,200,200,50);
		u.setFont(new Font("Ariel",1,22));
		bg.add(u);
		// Creating a textfield for login
		JTextField user_name = new JTextField("");
		user_name.setBounds(1100,200, 200, 50);
		bg.add(user_name);
				
		JLabel n = new JLabel("Name:");
		n.setForeground(Color.WHITE);
		n.setBounds(750,300,200,50);
		n.setFont(new Font("Ariel",1,22));
		bg.add(n);
		// Creating a textfield for login
		JTextField name = new JTextField("");
		name.setBounds(1100,300, 200, 50);
		bg.add(name);
		
		JLabel a = new JLabel("Address:");
		a.setForeground(Color.WHITE);
		a.setBounds(750,400,200,50);
		a.setFont(new Font("Ariel",1,22));
		bg.add(a);
		// Creating a textfield for login
		JTextField addr = new JTextField("");
		addr.setBounds(1100,400, 200, 50);
		bg.add(addr);
		
		JLabel p = new JLabel("Password:");
		p.setForeground(Color.WHITE);
		p.setBounds(750,500,200,50);
		p.setFont(new Font("Ariel",1,22));
		bg.add(p);
		/*JPasswordField pwd = new JPasswordField("");
		pwd.setFont(new Font("Trajan Pro 3",1,22));
		pwd.setBounds(600, 350, 100, 50);
		add(pwd);*/
		JPasswordField password = new JPasswordField();
		password.setBounds(1100, 500, 200, 50);
		bg.add(password);
		
		JLabel e = new JLabel("E-Mail ID:");
		e.setForeground(Color.WHITE);
		e.setBounds(750,600,100,50);
		e.setFont(new Font("Ariel",1,22));
		bg.add(e);		
		JTextField email = new JTextField("");
		email.setBounds(1100,600, 200, 50);
		bg.add(email);
		
		JLabel error = new JLabel("");
		error.setBounds(925,650,500,50);
		bg.add(error);
		
		JButton signup = new JButton("Create");
		signup.setFont(new Font("Trajan Pro 3",1,18));
		signup.setBounds(780, 700, 150, 50);
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.getText().chars().allMatch(Character::isLetter)) {
					
				}
				else {
					error.setFont(new Font("Ariel",1,18));					
					error.setForeground(Color.RED);
					error.setText("Invalid Name");
					return;
				}
				if(UserList.getUser(user_name.getText())!=null) {
					error.setFont(new Font("Ariel",1,18));
					
					error.setForeground(Color.RED);
					error.setText("User Name already Exists");
				}	
				
				else if(email.getText().contains(".com")==false||email.getText().contains("@")==false) {
					error.setText("Enter valid email");
					error.setFont(new Font("Ariel",1,18));
					
					error.setForeground(Color.RED);
				}
				else if(name.getText().equals("")|| addr.getText().equals("")|| email.getText().equals("")|| user_name.getText().equals("")|| new String(password.getPassword()).equals("")) {
					error.setFont(new Font("Ariel",1,18));
					
					error.setForeground(Color.RED);
					error.setText("All fields are mandatory");
				}				
				else {
					User user = new User(name.getText(), addr.getText(), email.getText(), user_name.getText(), new String(password.getPassword()));
					UserList.addUser(user);
					dispose();	
					new HomePage(manager);
				}
			}
		});
		bg.add(signup);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Trajan Pro 3",1,18));
		back.setBounds(1130, 700, 150, 50);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();	
				new HomePage(manager);
			}
		});
		back.setActionCommand("New Booking");
		bg.add(back);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class BookingPage extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 24;

	public BookingPage(Manager manager, int Index) {
		setSize(1920,1080);
		setTitle("Booking Page");
		JLabel bg=new JLabel(new ImageIcon("C:\\Users\\siva9\\eclipse-workspace\\Hotel Management\\src\\dark-background-with-star-like-dots_bkpaotdgh__F0000.png"));
		bg.setBounds(0, 0, 1920, 1080);		
		bg.setLayout(null);
		add(bg);
		WaitingList.refreshList();
		
		JLabel t = new JLabel("Welcome "+ UserList.Users.get(Index).getName());
		t.setFont(new Font("Trajan Pro 3",1,30));
		t.setForeground(Color.WHITE);
		t.setBounds(750, 100, 1000, 200);
		bg.add(t);
		
		JButton cur = new JButton("View Current Bookings");
		cur.setFont(new Font("Trajan Pro 3",1,18));
		cur.setBounds(625, 400, 300, 50);
		cur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
				new CurrentBookings(manager, Index);
			}
		});
		cur.setActionCommand("Current Bookings");
		bg.add(cur);
		
		
		JButton new_booking = new JButton("Create New Booking");
		new_booking.setFont(new Font("Trajan Pro 3",1,18));
		new_booking.setBounds(1000, 400, 300, 50);
		new_booking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
				new NewBooking(manager, Index);
			}
		});
		new_booking.setActionCommand("New Booking");
		bg.add(new_booking);
		
		JButton pay = new JButton("Pay Dues");
		pay.setFont(new Font("Trajan Pro 3",1,18));
		pay.setBounds(875, 550, 200, 50);
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
				new PaymentPage(manager, Index);
			}
		});
		pay.setActionCommand("pay");
		bg.add(pay);
		
		JLabel dues = new JLabel("Amount Due: "+UserList.Users.get(Index).getDues());
		dues.setFont(new Font("Ariel",1,18));
		dues.setForeground(Color.RED);
		dues.setBounds(900, 250, 200, 100);
		bg.add(dues);
		
		JLabel err = new JLabel("");
		err.setFont(new Font("Ariel",1,18));
		err.setForeground(Color.RED);
		err.setBounds(825, 300, 1000, 100);
		bg.add(err);
		
		JButton back = new JButton("Log Out");
		back.setBounds(875, 700, 200, 50);
		back.setFont(new Font("Trajan Pro 3",1,18));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(UserList.Users.get(Index).getDues()!=0) {
					err.setText("Pay your dues before you log out");
					return;
				}	
				dispose();	
				new HomePage(manager);
			}
		});
		back.setActionCommand("Back");
		bg.add(back);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class PaymentPage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1820091283947409851L;

	PaymentPage(Manager manager, int Index) {
		setSize(1920,1080);
		setTitle("Payment Page");
		JLabel bg=new JLabel(new ImageIcon("C:\\Users\\siva9\\eclipse-workspace\\Hotel Management\\src\\dark-background-with-star-like-dots_bkpaotdgh__F0000.png"));
		bg.setBounds(0, 0, 1920, 1080);		
		bg.setLayout(null);
		add(bg);
		
		
		JLabel d = new JLabel("Amount Due:"+UserList.Users.get(Index).getDues());
		d.setFont(new Font("Ariel",1,22));
		d.setForeground(Color.RED);
		d.setBounds(850, 300, 500, 50);
		bg.add(d);
		
		JLabel p = new JLabel("Enter password:");
		p.setFont(new Font("Trajan Pro",1,22));
		p.setBounds(750, 400, 230, 50);
		p.setForeground(Color.WHITE);
		bg.add(p);
		JPasswordField pass = new JPasswordField("");
		pass.setBounds(1100, 400, 100, 50);
		bg.add(pass);
		
		JLabel a = new JLabel("Enter ID no:");
		a.setForeground(Color.WHITE);
		a.setFont(new Font("Trajan Pro",1,22));
		a.setBounds(750, 500, 200, 50);
		bg.add(a);
		JTextField id = new JTextField("");
		id.setBounds(1100, 500, 100, 50);
		bg.add(id);
		
		JLabel m = new JLabel("");
		m.setBounds(925, 500, 100, 50);
		bg.add(m);
		
		JButton pay = new JButton("Pay");
		pay.setFont(new Font("Trajan Pro 3",1,22));
		pay.setBounds(950, 600, 100, 50);
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(pass.getPassword());
				try {
					Integer.parseInt(id.getText());
					if(UserList.Users.get(Index).Check_Passowrd(password)==true) {
						m.setText("Paid Successfully");
						UserList.Users.get(Index).addDues(0-UserList.Users.get(Index).getDues());						
						dispose();
						new BookingPage(manager, Index);
					
						
					}
					else {
						m.setText("Incorrect Password");
						m.setFont(new Font("Ariel",1,22));
						m.setBounds(100,600,300,50);
						m.setBackground(Color.RED);
						pass.setText("");
						id.setText("");
					}
				} catch (Exception e2) {
					m.setText("Enter Valid ID");
					m.setBounds(100,600,300,50);
					m.setFont(new Font("Ariel",1,22));
					m.setForeground(Color.RED);
				}
				
			}
		});
		pay.setActionCommand("pay");
		bg.add(pay);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class CurrentBookings extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 25;

	CurrentBookings(Manager manager, int Index) {
		setSize(1920,1080);
		setTitle("Current Bookings");
		JLabel bg=new JLabel(new ImageIcon("C:\\Users\\siva9\\eclipse-workspace\\Hotel Management\\src\\dark-background-with-star-like-dots_bkpaotdgh__F0000.png"));
		bg.setBounds(0, 0, 1920, 1080);		
		bg.setLayout(null);
		add(bg);
		WaitingList.refreshList();
		JLabel us = new JLabel(UserList.Users.get(Index).getName()+"'s Current Bookings");
		us.setFont(new Font("Myriad Pro",1,25));
		us.setForeground(Color.WHITE);
		us.setBounds(750, 100, 1200, 50);
		bg.add(us);
		ArrayList <Booking> blist = BookingList.retBooking(UserList.Users.get(Index));
		ArrayList <Booking> wlist = manager.waiting.retBooking(UserList.Users.get(Index));
		
		int nb = BookingList.retBooking(UserList.Users.get(Index)).size();
		int nw = manager.waiting.retBooking(UserList.Users.get(Index)).size();
		JLabel b[] = new JLabel[nb+nw];
		JRadioButton r[] = new JRadioButton[nb+nw];
		
		JLabel selno = new JLabel("");
		int i;
		JLabel bl = new JLabel("Booking List");
		bl.setBounds(500, 150, 500, 50);
		bl.setForeground(Color.YELLOW);
		bl.setFont(new Font("Ariel",1,25));
		bg.add(bl);
		for(i=0; i<nb; i++) {
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");			
			
			b[i] = new JLabel("Hotel: "+blist.get(i).hotel.retName()+"   City: "+blist.get(i).hotel.retLocation()+"        Check in:"+f.format(blist.get(i).check_in)+"       Check out:"+f.format(blist.get(i).check_out)+ "        Rooms: "+blist.get(i).rooms);
			b[i].setBounds(550, 200+i*50, 1500, 50);
			b[i].setForeground(Color.WHITE);
			b[i].setFont(new Font("Ariel",1,18));
			bg.add(b[i]);
			r[i] = new JRadioButton("");
			r[i].setOpaque(false);
			r[i].setBounds(500, 200+i*50, 50, 50);
			bg.add(r[i]);
			r[i].setActionCommand(Integer.toString(i));
			r[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selno.setText(e.getActionCommand());
				}
			});
		}
		JLabel non1 = new JLabel("");
		non1.setBounds(500, 200, 500, 50);
		non1.setForeground(Color.WHITE);
		non1.setFont(new Font("Ariel",1,18));
		bg.add(non1);
		if(nb==0) {
			non1.setText("None");
		}
		JLabel wl = new JLabel("Waiting List");
		wl.setBounds(500,200+50*nb+50, 400, 50);
		wl.setForeground(Color.YELLOW);
		wl.setFont(new Font("Ariel",1,25));
		bg.add(wl);
		for(i=nb; i<nw+nb; i++) {
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");			
			b[i] = new JLabel("Hotel: "+wlist.get(i-nb).hotel.retName()+"        Check in:"+f.format(wlist.get(i-nb).check_in)+"       Check out:"+f.format(wlist.get(i-nb).check_out)+ "        Rooms: "+wlist.get(i-nb).rooms);
			b[i].setBounds(550, 200+i*50 + 50+50, 1500, 50);
			b[i].setForeground(Color.WHITE);
			b[i].setFont(new Font("Ariel",1,18));
			bg.add(b[i]);
			r[i] = new JRadioButton("");
			r[i].setOpaque(false);
			r[i].setBounds(500, 200+i*50+ 50+ 50, 50, 50);
			bg.add(r[i]);
			r[i].setActionCommand(Integer.toString(i));
			r[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selno.setText(e.getActionCommand());
				}
			});
		}
		JLabel non2 = new JLabel("");
		non2.setBounds(500, 200+50*nb+50+50, 500, 50);
		non2.setForeground(Color.WHITE);
		non2.setFont(new Font("Ariel",1,18));
		bg.add(non2);
		if(nw==0) {
			non2.setText("None");
		}

		JLabel err = new JLabel("");
		err.setBounds(925, 525, 200, 50);
		err.setForeground(Color.RED);
		err.setFont(new Font("Ariel",1,18));
		bg.add(err);
		
		JButton del = new JButton("Delete");
		del.setBounds(600, 700, 150, 50);
		del.setFont(new Font("Myriad Pro",1,22));
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selno.getText().equals("")) {
					err.setText("Select a Booking");
					return;
				}
					
				Booking sel;
				if(Integer.parseInt(selno.getText())>=nb) {
					
					sel = wlist.get(Integer.parseInt(selno.getText())-nb);
					WaitingList.removeBooking(sel);
				}	
				else {
					
					sel = blist.get(Integer.parseInt(selno.getText()));
					BookingList.removeBooking(sel);
				}
				WaitingList.popBooking(sel.hotel, sel);
				Date comp = new Date();
				
				long diff = (sel.check_in.getTime()-comp.getTime())/86400000;
				long dur = (sel.check_out.getTime()-sel.check_in.getTime())/86400000;
				System.out.println("Days:"+diff + " Duration: " + dur);
				
				if(diff<3) {
					System.out.println("Dues added "+(sel.hotel.retPrice()/2)*sel.rooms*dur);
					UserList.getUser(sel.usr_name).addDues((sel.hotel.retPrice()/2)*sel.rooms*dur);
				}
				dispose();
				new CurrentBookings(manager, Index);
			}
		});
		del.setActionCommand("del");
		bg.add(del);
		
		
		
		JButton mod = new JButton("Modify");
		mod.setBounds(800, 700, 150, 50);
		mod.setFont(new Font("Myriad Pro",1,22));
		mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				if(selno.getText().equals("")) {
					err.setText("Select a Booking");
					return;
				}	
				Booking sel;
				
				if(Integer.parseInt(selno.getText())>=nb) {					
					sel = wlist.get(Integer.parseInt(selno.getText())-nb);
					
				}	
				else {					
					sel = blist.get(Integer.parseInt(selno.getText()));
					
				}
				WaitingList.popBooking(sel.hotel, sel);
				Date comp = new Date();
				
				long diff = (sel.check_in.getTime()-comp.getTime())/86400000;
				long dur = (sel.check_out.getTime()-sel.check_in.getTime())/86400000;
				System.out.println("Days:"+diff + " Duration: " + dur);
				
				if(diff<3) {
					err.setText("Cannot modify booking");
					return;
				}
				dispose();
				new ModifyPage(manager, Index, sel);
			}
		});
		mod.setActionCommand("modify");
		bg.add(mod);
		

		JButton rev = new JButton("Review");
		rev.setBounds(1000, 700, 150, 50);
		rev.setFont(new Font("Myriad Pro",1,22));
		rev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				if(selno.getText().equals("")) {
					err.setText("Select a Booking");
					return;
				}	
				Booking sel;
				
				if(Integer.parseInt(selno.getText())>=nb) {					
					sel = wlist.get(Integer.parseInt(selno.getText())-nb);
					
				}	
				else {					
					sel = blist.get(Integer.parseInt(selno.getText()));
					
				}
				
				dispose();
				new ReviewPage(manager, Index, sel);
			}
		});
		rev.setActionCommand("Review");
		bg.add(rev);

		
		JButton back = new JButton("Back");
		back.setBounds(1200, 700, 150, 50);
		back.setFont(new Font("Myriad Pro",1,22));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
				new BookingPage(manager, Index);
			}
		});
		back.setActionCommand("New Booking");
		bg.add(back);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class ReviewPage extends JFrame { 


	/**
	 * 
	 */
	private static final long serialVersionUID = 4281761263290572944L;

	ReviewPage(Manager manager, int Index, Booking b) {
		setSize(1920,1080);
		setTitle("Review Page");
		JLabel bg=new JLabel(new ImageIcon("C:\\Users\\siva9\\eclipse-workspace\\Hotel Management\\src\\dark-background-with-star-like-dots_bkpaotdgh__F0000.png"));
		bg.setBounds(0, 0, 1920, 1080);		
		bg.setLayout(null);
		add(bg);
		
		JLabel title = new JLabel("Review");
		title.setBounds(900, 100, 400, 200);
		title.setForeground(Color.YELLOW);
		title.setFont(new Font("Myriad Pro",1,40));
		bg.add(title);
		
		JTextField review = new JTextField("");
		review.setBounds(850, 300, 500, 100);
		review.setForeground(Color.BLACK);
		review.setFont(new Font("Ariel",1,18));				
		bg.add(review);
		
		JLabel r = new JLabel("Review");
		r.setBounds(650, 300, 100, 50);
		r.setForeground(Color.WHITE);
		r.setFont(new Font("Ariel",1,18));		
		bg.add(r);
		
		JTextField rate = new JTextField("");
		rate.setBounds(850, 500, 500, 100);
		rate.setForeground(Color.BLACK);
		rate.setFont(new Font("Ariel",1,18));				
		bg.add(rate);
		
		JLabel ra = new JLabel("Rate");
		ra.setBounds(650, 500, 100, 50);
		ra.setForeground(Color.WHITE);
		ra.setFont(new Font("Ariel",1,18));				
		bg.add(ra);

		JLabel error = new JLabel("");
		error.setBounds(800, 650, 200, 50);
		error.setForeground(Color.RED);

		bg.add(error);


		JButton add = new JButton("Add Review");
		add.setBounds(800, 700, 150, 50);
		add.setFont(new Font("Myriad Pro",1,22));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
		        { 
		            Integer.parseInt(rate.getText()); 		            
		        }  
		        catch (NumberFormatException f)  
		        { 
		        	error.setText("Enter correct number of rooms");
		        	error.setBounds(100,650,400,50);
		        	error.setForeground(Color.RED);
		    		error.setFont(new Font("Ariel",1,22));
		    		return;
		        }
				if(Integer.parseInt(rate.getText())>5) {
					error.setText("Enter Rating from 1-5");
					return;
				}
				System.out.println("Review Added" + b.hotel.retName());
				HotelList.Hotels.get(HotelList.retIndex(b.hotel)).addReview(Integer.parseInt(rate.getText()), review.getText());
				dispose();
				new CurrentBookings(manager, Index);
			}
		});
		bg.add(add);
		
		
		JButton back = new JButton("Back");
		back.setBounds(1000, 700, 150, 50);
		back.setFont(new Font("Myriad Pro",1,22));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CurrentBookings(manager, Index);
			}
		});
		bg.add(back);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}		

}


class ModifyPage extends JFrame { 

	/**
	 * 
	 */
	private static final long serialVersionUID = -2593949275281719431L;

	ModifyPage(Manager manager, int Index, Booking b) {
		setSize(1920,1080);
		setTitle("Modify Page");
		JLabel bg=new JLabel(new ImageIcon("C:\\Users\\siva9\\eclipse-workspace\\Hotel Management\\src\\dark-background-with-star-like-dots_bkpaotdgh__F0000.png"));
		bg.setBounds(0, 0, 1920, 1080);		
		bg.setLayout(null);
		add(bg);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePanel.setSize(200,200);
		datePanel.setBounds(1000,225, 350, 180);
		bg.add(datePanel);
		
		
		
		datePanel.setVisible(true);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		 
		bg.add(datePicker);
		
		UtilDateModel model1 = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
		datePanel1.setSize(200,200);
		datePanel1.setBounds(1000,425, 350, 180);
		bg.add(datePanel1);
		
		
		
		datePanel1.setVisible(true);
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1);
		 
		bg.add(datePicker1);
		
		
		
		// Check in Date
		JLabel c_in = new JLabel("Check-in Date:");
		c_in.setForeground(Color.WHITE);
		c_in.setFont(new Font("Ariel",1,22));
		c_in.setBounds(650,275,300,80);
		bg.add(c_in);
		
		//Check out Date
		JLabel c_out = new JLabel("Check-out Date:");
		c_out.setForeground(Color.WHITE);
		c_out.setFont(new Font("Ariel",1,22));
		c_out.setBounds(650,425,300,80);
		bg.add(c_out);
		
		// Number of rooms required
		JLabel rlabel = new JLabel("Number of rooms:");
		rlabel.setForeground(Color.WHITE);
		rlabel.setFont(new Font("Ariel",1,22));
		rlabel.setBounds(650,625,200,50);
		bg.add(rlabel);
		JTextField rooms = new JTextField("");
		rooms.setBounds(1000,625, 100, 50);
		bg.add(rooms);
		
		JLabel error = new JLabel("");
		error.setBounds(200,700,200,50);
		error.setForeground(Color.RED);
		error.setFont(new Font("Ariel",1,18));		
		bg.add(error);

		JButton mod = new JButton("Change");
		mod.setFont(new Font("Myriad Pro",1,22));
		mod.setBounds(800, 750, 200, 50);
		mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Date i=(Date) datePicker.getModel().getValue();
				Date o=(Date) datePicker1.getModel().getValue();
				Date date = new Date(); 
				
				try 
		        { 
		            Integer.parseInt(rooms.getText()); 		            
		        }  
		        catch (NumberFormatException f)  
		        { 
		        	error.setText("Enter correct number of rooms");
		        }
				if(Integer.parseInt(rooms.getText())==0) {
					error.setText("Pick the number of rooms");
				}
				
				else if(i.before(date)) {
					error.setText("Choose a date after today's date");
				}
				else if(o.before(i)) {
					error.setText("Check out date must be after check in date");
				}
				else if(i==null||o==null) {
					error.setText("Choose a date");
				}
				
				else {
						int inx = HotelList.retHotels(b.hotel.retLocation()).indexOf(b.hotel);
						System.out.println(inx);
						b.display();
						b.check_in = i;
						b.check_out = o;
						b.rooms = Integer.parseInt(rooms.getText());
						if(BookingList.bookings.contains(b)) {
							BookingList.removeBooking(b);
							WaitingList.popBooking(b.hotel, b);
							manager.bookings.addBooking(b, b.hotel.retLocation(), inx);
							
							
						}
						else if(WaitingList.waiting.contains(b)) {
							WaitingList.removeBooking(b);
							WaitingList.popBooking(b.hotel, b);
							manager.bookings.addBooking(b, b.hotel.retLocation(), inx);
							
							
						}
						dispose();
						new CurrentBookings(manager, Index);
				}
			}
		});
		bg.add(mod);
		
		
		
		JButton back = new JButton("Back");
		back.setBounds(1050, 750, 200, 50);
		back.setFont(new Font("Myriad Pro",1,22));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CurrentBookings(manager, Index);
			}
		});
		bg.add(back);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}


class NewBooking extends JFrame { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 26;
	JList<String> location_list;
	JScrollPane location;
	JLabel city;
	NewBooking(Manager manager, int Index) {
		setSize(1920,1080);
		setTitle("New Booking");
		JLabel bg=new JLabel(new ImageIcon("C:\\Users\\siva9\\eclipse-workspace\\Hotel Management\\src\\dark-background-with-star-like-dots_bkpaotdgh__F0000.png"));
		bg.setBounds(0, 0, 1000, 1000);		
		bg.setLayout(null);
		add(bg);
		
		
		// Select Location
		JLabel l = new JLabel("Location:");
		l.setForeground(Color.WHITE);
		l.setFont(new Font("Ariel",1,22));
		l.setBounds(650,100,300,50);
		bg.add(l);
		// Creating a list of Locations
		String cities[] = { "Chennai", "Hyderabad", "Mumbai", "Delhi", "Kochi",  "Goa", "Pondicherry", "Bangalore", "Kolkata", "Jaipur"	};
		location_list = new JList<String> (cities);
		location_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		location = new JScrollPane(location_list);
		location.setBounds(1000, 100, 300, 80);
		city = new JLabel("Choose a city");
		location_list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent le) {
				int i = location_list.getSelectedIndex();
				if(i != -1)
					city.setText(cities[i]);
				else 
					city.setText("Choose a city");
			}
		});
		bg.add(location);
		bg.add(city);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePanel.setSize(200,200);
		datePanel.setBounds(1000,225, 350, 180);
		bg.add(datePanel);
		
		
		
		datePanel.setVisible(true);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		 
		bg.add(datePicker);
		
		UtilDateModel model1 = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
		datePanel1.setSize(200,200);
		datePanel1.setBounds(1000,425, 350, 180);
		bg.add(datePanel1);
		
		
		
		datePanel1.setVisible(true);
		JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1);
		 
		bg.add(datePicker1);
		
		
		
		// Check in Date
		JLabel c_in = new JLabel("Check-in Date:");
		c_in.setForeground(Color.WHITE);
		c_in.setFont(new Font("Ariel",1,22));
		c_in.setBounds(650,275,300,80);
		bg.add(c_in);
		
		//Check out Date
		JLabel c_out = new JLabel("Check-out Date:");
		c_out.setForeground(Color.WHITE);
		c_out.setFont(new Font("Ariel",1,22));
		c_out.setBounds(650,425,300,80);
		bg.add(c_out);
		
		// Number of rooms required
		JLabel rlabel = new JLabel("Number of rooms:");
		rlabel.setForeground(Color.WHITE);
		rlabel.setFont(new Font("Ariel",1,22));
		rlabel.setBounds(650,625,200,50);
		bg.add(rlabel);
		JTextField rooms = new JTextField("");
		rooms.setBounds(1000,625, 100, 50);
		bg.add(rooms);
		
		JLabel error = new JLabel("");
		error.setBounds(200,700,200,50);
		bg.add(error);

		
		System.out.println();
		
		// List Hotels
		JButton hotels = new JButton("Show Hotels");
		hotels.setBounds(650,750,200,50);
		hotels.setFont(new Font("Ariel",1,22));
		hotels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				error.setText("");
				Date i=(Date) datePicker.getModel().getValue();
				Date o=(Date) datePicker1.getModel().getValue();
				Date date = new Date(); 
				
				try 
		        { 
		            Integer.parseInt(rooms.getText()); 		            
		        }  
		        catch (NumberFormatException f)  
		        { 
		        	error.setText("Enter correct number of rooms");
		        	error.setBounds(100,650,400,50);
		        	error.setForeground(Color.RED);
		    		error.setFont(new Font("Ariel",1,22));

		        }
				if(Integer.parseInt(rooms.getText())==0) {
					error.setBounds(150,650,300,50);
					error.setText("Pick the number of rooms");
					error.setForeground(Color.RED);
		    		error.setFont(new Font("Ariel",1,22));

				}
				else if(city.getText()=="Choose a city") {
					error.setText("Choose a city");
					error.setBounds(150,650,300,50);
					error.setForeground(Color.RED);
		    		error.setFont(new Font("Ariel",1,22));

				}
				else if(i==null||o==null) {
					error.setText("Choose a Date");
					error.setBounds(150,650,300,50);
					error.setForeground(Color.RED);
		    		error.setFont(new Font("Ariel",1,22));

				}

				else if(i.before(date)) {
					error.setText("Choose a date after today's date");
					error.setForeground(Color.RED);
					error.setBounds(150,650,400,50);
		    		error.setFont(new Font("Ariel",1,22));

				}
				else if(o.before(i)) {
					error.setText("Check out date must be after check in date");
					error.setForeground(Color.RED);
					error.setBounds(100,650,475,50);
		    		error.setFont(new Font("Ariel",1,22));

				}
				else if(i==null||o==null) {
					error.setText("Choose a date");
					error.setForeground(Color.RED);
		    		error.setFont(new Font("Ariel",1,22));

				}
				
				else {
					dispose();	
					new ListHotels(manager, Index, city.getText(), rooms.getText(), i, o);		
				}
			}
		});
		bg.add(hotels);
		
		// Goes back to Booking Page
		JButton back = new JButton("Back");
		back.setFont(new Font("Ariel",1,22));
		back.setBounds(1000, 750, 200, 50);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
				new BookingPage(manager, Index);
			}
		});
		bg.add(back);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class ListHotels extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 27;

	public ListHotels(Manager manager, int Index, String City, String rooms, Date in, Date out) {
		setSize(1920,1080);
		setTitle("Hotel List");
		JLabel bg=new JLabel(new ImageIcon("C:\\Users\\siva9\\eclipse-workspace\\Hotel Management\\src\\dark-background-with-star-like-dots_bkpaotdgh__F0000.png"));
		bg.setBounds(0, 0, 1920, 1080);		
		bg.setLayout(null);
		add(bg);
		
		JLabel city = new JLabel("Hotels in "+ City);
		city.setFont(new Font("Trajan Pro",1,35));
		city.setBounds(850, 100, 500, 50);
		city.setForeground(Color.YELLOW);
		bg.add(city);
		JLabel[] raa = new JLabel[HotelList.retHotels(City).size()];
		JLabel[] hlabels = new JLabel[HotelList.retHotels(City).size()];
		JLabel[] ratings = new JLabel[HotelList.retHotels(City).size()*5];
		JRadioButton[] b = new JRadioButton[HotelList.retHotels(City).size()];
		for(int i=0; i<HotelList.retHotels(City).size(); i++) {
			ArrayList <Hotel> temp = HotelList.retHotels(City);
			hlabels[i] = new JLabel("Name: "+temp.get(i).retName()+"   Price: "+temp.get(i).retPrice());
			hlabels[i].setBounds(775,200+i*100,900,50);
			hlabels[i].setForeground(Color.WHITE);
			hlabels[i].setFont(new Font("Ariel",1,22));
			bg.add(hlabels[i]);
			raa[i] = new JLabel("   Rating: ");
			raa[i].setBounds(1300,200+i*100,900,50);
			raa[i].setForeground(Color.WHITE);
			raa[i].setFont(new Font("Ariel",1,22));
			bg.add(raa[i]);
			for(int j=0; j<temp.get(i).retRating(); j++) {
			ratings[i+j] = new JLabel(new ImageIcon("C:\\Users\\siva9\\eclipse-workspace\\Hotel Management\\src\\Retro-Star-icon.png"));
			ratings[i+j].setBounds(1400+j*50,200+i*100,50,50);
			ratings[i+j].setForeground(Color.WHITE);
			ratings[i+j].setFont(new Font("Ariel",1,22));
			bg.add(ratings[i+j]);
			}
			b[i] = new JRadioButton(""+(i+1));
			b[i].setFont(new Font("Ariel",1,22));
			b[i].setBounds(625, 200+i*100, 50, 50);
			bg.add(b[i]);
			b[i].setActionCommand(Integer.toString(i));
			b[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();	
					
					new HotelDetails(manager, Index, City, Integer.parseInt(e.getActionCommand()), rooms, in, out);
				}
			});
		}
		
		// Goes Back to New Booking page
		JButton back = new JButton("Back");
		back.setFont(new Font("Ariel",1,22));
		back.setBounds(875, 600, 200, 50);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
				new NewBooking(manager, Index);
			}
		});
		bg.add(back);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}


class HotelDetails extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 28;

	public HotelDetails(Manager manager, int Index, String City, int hIndex, String rooms, Date in, Date out) {
		setLayout(null);
		setSize(1920,1080);	
		setTitle("Hotels Details");
		JLabel bg=new JLabel(new ImageIcon("C:\\Users\\siva9\\eclipse-workspace\\Hotel Management\\src\\dark-background-with-star-like-dots_bkpaotdgh__F0000.png"));
		bg.setBounds(0, 0, 1920, 1080);		
		bg.setLayout(null);
		add(bg);
		JLabel name = new JLabel(HotelList.retHotels(City).get(hIndex).retName());
		name.setBounds(810, 100, 800, 50);
		name.setForeground(Color.YELLOW);
		name.setFont(new Font("Trajan Pro",1,40));
		bg.add(name);
		JLabel rev = new JLabel("User Reviews");
		rev.setForeground(Color.CYAN);
		rev.setFont(new Font("Ariel",1,22));
		rev.setBounds(1000, 250, 200, 50);
		bg.add(rev);
		JLabel loc = new JLabel(HotelList.retHotels(City).get(hIndex).retLocation());
		loc.setBounds(850, 150, 300, 50);
		loc.setForeground(Color.WHITE);
		loc.setFont(new Font("Trajan Pro",1,25));
		bg.add(loc);
		JLabel r = new JLabel("Total Rooms: " +Integer.toString(HotelList.retHotels(City).get(hIndex).retRooms()));
		r.setBounds(500, 250, 300, 50);
		r.setForeground(Color.WHITE);
		r.setFont(new Font("Ariel",1,22));
		bg.add(r);
		int nr = HotelList.retHotels(City).get(hIndex).reviews.size();
		JLabel[] reviews = new JLabel[nr];
		for(int i=0; i<HotelList.retHotels(City).get(hIndex).reviews.size(); i++) {
			ArrayList <Review> temp = HotelList.retHotels(City).get(hIndex).reviews;
			reviews[i] = new JLabel((i+1)+ " "+temp.get(i).retReview()+"   Rating: "+temp.get(i).retRating());
			reviews[i].setBounds(1000,300+i*50,900,50);
			reviews[i].setForeground(Color.WHITE);
			reviews[i].setFont(new Font("Ariel",1,22));
			bg.add(reviews[i]);
		}
		Booking temp = new Booking(HotelList.retHotels(City).get(hIndex), UserList.Users.get(Index).getUserName(),Integer.parseInt(rooms), in, out);
		JLabel a = new JLabel("Available Rooms: " +Integer.toString(BookingList.roomsAvailable(temp,HotelList.retHotels(City).get(hIndex))));
		a.setBounds(500, 300, 400, 50);
		a.setFont(new Font("Ariel",1,22));
		a.setForeground(Color.WHITE);
		bg.add(a);
		
		JLabel am1 = new JLabel("Amenities");
		am1.setBounds(500, 400, 200, 100);
		am1.setForeground(Color.CYAN);
		am1.setFont(new Font("Ariel",1,22));
		bg.add(am1);
		
		JLabel am = new JLabel(HotelList.retHotels(City).get(hIndex).retAmenities());
		am.setBounds(500, 450, 1000, 100);
		am.setForeground(Color.WHITE);
		am.setFont(new Font("Ariel",1,22));
		bg.add(am);
		
	
		long dur = (temp.check_out.getTime()-temp.check_in.getTime())/86400000;
		
		
		
		JLabel price = new JLabel("Total: "+Integer.parseInt(rooms)*dur*temp.hotel.retPrice());
		price.setBounds(850, 550, 300, 50);
		price.setForeground(Color.RED);
		price.setFont(new Font("Trajan Pro",1,25));
		bg.add(price);
		
		JButton book = new JButton("Book");
		book.setFont(new Font("Ariel",1,22));
		book.setBounds(700, 700, 200, 50);
		if(Integer.parseInt(rooms)>(BookingList.roomsAvailable(temp,HotelList.retHotels(City).get(hIndex)))) {
			book.setText("Waiting List");
		}
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Booking temp = new Booking(HotelList.retHotels(City).get(hIndex), UserList.Users.get(Index).getUserName(),Integer.parseInt(rooms), in, out);
				manager.bookings.addBooking(temp,City, hIndex);
				JLabel cnf = new JLabel("Booking Confirmed");
				cnf.setBounds(250, 700, 200, 50);
				bg.add(cnf);
				dispose();
				new BookingPage(manager, Index);
				
			}
		});
		bg.add(book);
		// Back to Hotel list page
		JButton back = new JButton("Back");
		back.setFont(new Font("Ariel",1,22));
		back.setBounds(1000, 700, 200, 50);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
				new ListHotels(manager, Index, City, rooms, in , out);
			}
		});
		bg.add(back);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}