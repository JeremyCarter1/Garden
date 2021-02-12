import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.event.*; //Importing all the packages we need
public class Project implements ActionListener, ListSelectionListener {
 
  JLabel info; //creating labels for the frame to show information
  JLabel register;
  JLabel appointment;
  JLabel donations;
  JLabel selection;

  JList<String> jlist;// creating the list
  JScrollPane jscrp;
  String gifts[] = {"Seeds", "Soil", "Fertilizer", "Volunteering", 
		    "Garden Tools", "Other Materials"};

  JTextField register2;// creating text fields
  JTextField appointment2;
  
  JButton register3;// creating buttons
  JButton appointment3;

  Project() {
 	JFrame website = new JFrame("Local Community Garden");
	website.setLayout(new FlowLayout());
	website.setSize(1000, 500);// Setting up the size and layout of Frame
	website.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	info = new JLabel("The garden is open from 8:00am-8:00pm, Monday-Friday, 8:00am-5:00pm Saturday. During each appointment, patrons can pick fresh produce, fruits and vegetables, at no cost.");
	register = new JLabel("To register to come to the garden please put in your name and email adress.");// Setting what I want the labels to say
        appointment = new JLabel("To set an apointment please type in the day and time that you will be here.");
        donations = new JLabel("If you want to give donations please select the option from the scroll down menu.");
 	selection = new JLabel("");
    	jlist = new JList<String>(gifts);
	jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// creating Pane and selection single selection mode
	jscrp = new JScrollPane(jlist);
	jscrp.setPreferredSize(new Dimension(120, 120));
	jlist.addListSelectionListener(this);
	register2 = new JTextField(30);
	register2.addActionListener(this);// Adding action listeners for the buttons and scroll pane and Texfields
	appointment2 = new JTextField(30);
	appointment2.addActionListener(this);
	register3 = new JButton("Register");
	register3.addActionListener(this);
	appointment3 = new JButton("Set Appointment");
	appointment3.addActionListener(this);

	website.add(info);
	website.add(register);
	website.add(register2);// Adding everything to the Frame
	website.add(register3);
	website.add(appointment);
	website.add(appointment);
	website.add(appointment2);
	website.add(appointment3);
	website.add(donations);
	website.add(jscrp);
	website.add(selection);
	

	website.setVisible(true);
}
public void actionPerformed(ActionEvent ae) {
  String x, y;
  x = register2.getText();//setting variables x and y to getText from the text fields
  y = appointment2.getText();
  if(ae.getActionCommand().equals("Register"))// if statement to print out what they typed into the console
	System.out.println(x);
   else 
	System.out.print(y);
 }
public void valueChanged(ListSelectionEvent le) {
  int indx = jlist.getSelectedIndex();// creating variable indx to get selected item in scroll pane
  if (!le.getValueIsAdjusting())
     switch(indx) { //Switch statement to print out corresponding text for which option they pressed
	case 0:
     	  System.out.println("They are donating Seeds");
	  break;
	case 1:
	  System.out.println("They are donating Soil");
	  break;
	case 2:
	  System.out.println("They are donating Fertilizer");
	  break;
	case 3:
	  System.out.println("They are Volunteering");
	  break;
	case 4:
	  System.out.println("They are donating Garden Tools");
	  break;
	case 5:
	  System.out.println("They are donating Other Materials");
	  break;
} 	
}
public static void main(String args[]) {
  SwingUtilities.invokeLater(new Runnable() {
	public void run() {
	  new Project();
	}
     });
  }
}