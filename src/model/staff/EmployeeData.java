package model.staff;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeData 
{
	private final StringProperty fname;
	private final StringProperty lname;
	private StringProperty position;
	private final StringProperty dob;
	private final StringProperty email;
	private final StringProperty password;
	
	private final IntegerProperty workDays;
	private final IntegerProperty absentDays;
	
	public EmployeeData(String first, String last, String date, String rank, int worked, int absent, String user, String pass) 
	{
		fname = new SimpleStringProperty(first);
		lname = new SimpleStringProperty(last);
		position = new SimpleStringProperty(rank);
		email = new SimpleStringProperty(user);
		password = new SimpleStringProperty(pass);
		
		workDays = new SimpleIntegerProperty(worked);
		absentDays = new SimpleIntegerProperty(absent);
		
		dob = new SimpleStringProperty(date);
		
		System.out.println(fname);
		System.out.println(lname);
	}
	
	public void setPosition(String newPosition) {
		position = new SimpleStringProperty(newPosition);
	}

	public String getDob() {
		return dob.get();
	}

	public String getFname() {
		return fname.get();
	}

	public String getLname() {
		return lname.get();
	}

	public String getPosition() {
		return position.get();
	}

	public int getWorkDays() {
		return workDays.get();
	}

	public int getAbsentDays() {
		return absentDays.get();
	}

	public String getPassword() {
		return password.get();
	}

	public String getEmail() {
		return email.get();
	}
	
	@Override
	public String toString() 
	{
		return "Name: " + getFname() + " " + getLname() +
				"\nDate of Birth: " + getDob() +
				"\nPosition: " + getPosition();
	}

}
