package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.staff.EmployeeData;
import model.staff.StaffManager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StaffWindowController implements Initializable
{
	/**
		Main Controller classs for the base window of the application.Responsible for loading and displaying the fxml files for employee edit and display.
	 **/
	@FXML private TableView<EmployeeData> tableWindow;
	
	@FXML
	private HBox parentNode;
	
	@FXML
	private VBox employeeDisplay;

	@FXML
	private EmployeeDisplayController employeeDisplayController;
	
	
	private EditMenuController editMenu;
	
	private StaffManager manager;
	
	FXMLLoader loader = new FXMLLoader();
	
	private boolean isEditMode;
	private boolean isDisplayMode;

	private EmployeeData employeeData = null;
	private ArrayList<EmployeeData> employeeList = new ArrayList<>();
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		System.out.println(employeeDisplayController);
		employeeDisplayController.init(this);
	}
	
	public void displayData() 
	{
		System.out.println("Displaying data");
	}
	
	public void populateFields() {
		System.out.println("Populating Fields");
	}
	
	@FXML
	private void editEmployee(ActionEvent event)
	{
		Node newNode;
		try {
			loader.setController(editMenu);
			newNode = loader.load(getClass().getResource("/view/EditMenu.fxml"));
			editMenu = loader.getController();
			
			Node node = (Node)(event.getSource());
			parentNode.getChildren().remove(0);
			parentNode.getChildren().add(0, newNode);
			isEditMode = true;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setEmployeeData(Object data)
	{
		if (data instanceof EmployeeData)
		{
			employeeData = (EmployeeData) data;
			System.out.println(data.toString());
		}else if (data instanceof ArrayList)
		{
			employeeList.add((EmployeeData)data);
		}
	}
}
