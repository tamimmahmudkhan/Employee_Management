package model.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StaffManager 
{
	
	/*
	 * Manages staff data to and from database.
	 */
	
	private	ResultSet set;
	private PreparedStatement statement;
	
	private	String  query;
	
	private	ObservableList<EmployeeData> tableData;
	
	private static EmployeeData commonData;
	
	public EmployeeData getCommonData() {
		return commonData;
	}

	public void setCommonData(EmployeeData commonData) {
		StaffManager.commonData = commonData;
	}

	public boolean addEmployee(EmployeeData data) 
	{
		if (!isEmployee(data.getFname(), data.getLname())) 
		{
			query = "insert into staff(fname,lname,dob,position,workDays,absentDays,email,password) values(?,?,?,?,?,?,?,?)";
			try(Connection database = dbConnection.getConnection()) {
				statement = database.prepareStatement(query);
				statement.setString(1, data.getFname());
				statement.setString(2, data.getLname());
				statement.setString(3, data.getDob());
				statement.setString(4, data.getDob());
				statement.setInt(5, 3);     		//To be calculated from day of addition
				statement.setInt(6, 4);				//To be calculated from day of addition
				statement.setString(7, data.getEmail());
				statement.setString(8, data.getPassword());
				
				statement.execute();
				statement.close();
				database.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else {
			return false;
		}
	}
	
	public boolean addEmployee(String fname, String lname, String dob, String position, String email, String pass) 
	{
		if (!isEmployee(fname, lname)) 
		{
			query = "insert into staff(fname,lname,dob,position,workDays,absentDays,email,password) values(?,?,?,?,?,?,?,?)";
			try(Connection database = dbConnection.getConnection()) {
				statement = database.prepareStatement(query);
				statement.setString(1, fname);
				statement.setString(2, lname);
				statement.setString(3, dob);
				statement.setString(4, position);
				statement.setInt(5, 3);     		//To be calculated from day of addition
				statement.setInt(6, 4);				//To be calculated from day of addition
				statement.setString(7, email);
				statement.setString(8, pass);
				
				statement.execute();
				statement.close();
				database.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else {
			return false;
		}
	}
	
	public boolean removeEmployee(EmployeeData data) 
	{
		query = "delete from staff where fname=? and lname=? and dob=? and position=?";
		try(Connection database = dbConnection.getConnection())
		{
			statement = database.prepareStatement(query);
			statement.setString(0, data.getFname());
			statement.setString(1, data.getLname());
			statement.setString(2, data.getDob());
			statement.setString(3, data.getPosition());
			
			return statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ObservableList<EmployeeData> getData() 
	{
		tableData = FXCollections.observableArrayList();
		query = "select * from staff";
		
		try(Connection database = dbConnection.getConnection()) {
			set = database.createStatement().executeQuery(query);
			
			while (set.next()) 
			{
				tableData.add(new EmployeeData(
							set.getString(1),
							set.getString(2),
							set.getString(3),
							set.getString(4),
							set.getInt(5),
							set.getInt(6),
							set.getString(7),
							set.getString(8)));
			}
			return tableData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isEmployee(String email, String password)
	{
		query = "select * from staff where email=? and password=?"; //and dob=? and position=? and workDays=? and absentDays=?";
		try(Connection connection = dbConnection.getConnection()) {
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			
			set = statement.executeQuery();
			
			if (set.next()) 
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
